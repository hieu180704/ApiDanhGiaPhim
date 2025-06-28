package com.api.danhgiaphim.Controller;

import com.api.danhgiaphim.dto.request.ApiResponse;
import com.api.danhgiaphim.dto.request.ForgotPasswordRequest;
import com.api.danhgiaphim.dto.request.ResetPasswordRequest;
import com.api.danhgiaphim.entity.PasswordResetToken;
import com.api.danhgiaphim.entity.User;
import com.api.danhgiaphim.repository.PasswordResetTokenRepository;
import com.api.danhgiaphim.repository.UserRepository;
import com.api.danhgiaphim.service.MailService;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import java.time.LocalDateTime;
import java.util.Optional;
import java.util.UUID;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
public class AuthController {

    @Autowired
    private UserRepository userRepo;
    @Autowired
    private PasswordResetTokenRepository tokenRepo;
    @Autowired
    private PasswordEncoder passwordEncoder;
    @Autowired
    private MailService mailService;

    @Transactional
    @PostMapping("/forgot-password")
    public ApiResponse<String> forgotPassword(@RequestBody @Valid ForgotPasswordRequest request) {
        Optional<User> userOpt = userRepo.findAll().stream()
                .filter(u -> u.getEmail().equalsIgnoreCase(request.getEmail()))
                .findFirst();

        if (userOpt.isEmpty()) {
            return new ApiResponse<>(404, "Email không tồn tại trong hệ thống", null);
        }

        tokenRepo.deleteByEmail(request.getEmail()); // Xoá token cũ nếu có
        String token = UUID.randomUUID().toString();
        PasswordResetToken resetToken = new PasswordResetToken();
        resetToken.setEmail(request.getEmail());
        resetToken.setToken(token);
        resetToken.setExpiry(LocalDateTime.now().plusMinutes(15));
        tokenRepo.save(resetToken);

        mailService.sendResetEmail(request.getEmail(), token);
        return new ApiResponse<>(200, "Đã gửi email đặt lại mật khẩu", null);
    }

    @Transactional
    @PostMapping("/reset-password")
    public ApiResponse<String> resetPassword(@RequestBody @Valid ResetPasswordRequest request) {
        PasswordResetToken token = tokenRepo.findByToken(request.getToken())
                .orElseThrow(() -> new RuntimeException("Token không hợp lệ"));

        if (token.getExpiry().isBefore(LocalDateTime.now())) {
            return new ApiResponse<>(400, "Token đã hết hạn", null);
        }

        Optional<User> userOpt = userRepo.findAll().stream()
                .filter(u -> u.getEmail().equalsIgnoreCase(token.getEmail()))
                .findFirst();

        if (userOpt.isEmpty()) {
            return new ApiResponse<>(404, "Không tìm thấy người dùng", null);
        }

        User user = userOpt.get();
        user.setPassword(passwordEncoder.encode(request.getNewPassword()));
        userRepo.save(user);
        tokenRepo.deleteByEmail(token.getEmail());

        return new ApiResponse<>(200, "Đổi mật khẩu thành công", null);
    }
}
