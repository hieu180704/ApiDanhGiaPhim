package com.api.danhgiaphim.service;

import com.api.danhgiaphim.dto.request.CreateUserRequest;
import com.api.danhgiaphim.dto.request.UpdateUserProfileRequest;
import com.api.danhgiaphim.dto.request.UserRequest;
import com.api.danhgiaphim.entity.User;
import com.api.danhgiaphim.repository.UserRepository;
import jakarta.validation.Valid;
import java.time.LocalDateTime;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepo;

    private final PasswordEncoder passwordEncoder = new BCryptPasswordEncoder(10);

    public User createUser(@Valid CreateUserRequest request) {
        if (userRepo.existsByUsernameIgnoreCase(request.getUsername())) {
            throw new RuntimeException("Tên tài khoản đã tồn tại");
        }
        if (userRepo.existsByEmailIgnoreCase(request.getEmail())) {
            throw new RuntimeException("Email đã được sử dụng!");
        }

        User user = new User();
        user.setUsername(request.getUsername());
        user.setPassword(passwordEncoder.encode(request.getPassword()));
        user.setEmail(request.getEmail());
        user.setFullName(request.getFullName());
        user.setPhone(request.getPhone());
        user.setRole(request.getRole());
        user.setStatus(request.isStatus());
        user.setCreatedAt(request.getCreatedAt());
        user.setUpdatedAt(request.getUpdatedAt());

        return userRepo.save(user);
    }

    public List<User> getUsers() {
        return userRepo.findAll();
    }

    public User getUser(Integer id) {
        return userRepo.findById(id)
                .orElseThrow(() -> new RuntimeException("Không tìm thấy người dùng với mã: " + id));
    }

    public User updateUser(Integer id, @Valid UpdateUserProfileRequest request) {
        User existingUser = getUser(id);
        
        existingUser.setFullName(request.getFullName());
        existingUser.setPhone(request.getPhone());

        existingUser.setUpdatedAt(LocalDateTime.now());

        return userRepo.save(existingUser);
    }

    public void deleteUser(Integer id) {
        if (!userRepo.existsById(id)) {
            throw new RuntimeException("Không tìm thấy người dùng để xoá");
        }
        userRepo.deleteById(id);
    }

    public User getUserByUsername(String username) {
        return userRepo.findByUsernameIgnoreCase(username)
                .orElseThrow(() -> new RuntimeException("Không tìm thấy user"));
    }

}
