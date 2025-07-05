package com.api.danhgiaphim.Controller;

import com.api.danhgiaphim.dto.request.ApiResponse;
import com.api.danhgiaphim.dto.request.CreateUserRequest;
import com.api.danhgiaphim.dto.request.UpdateUserProfileRequest;
import com.api.danhgiaphim.entity.User;
import com.api.danhgiaphim.service.UserService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @PostMapping
    public ResponseEntity<ApiResponse<User>> createUser(@Valid @RequestBody CreateUserRequest request) {
        User user = userService.createUser(request);
        return ResponseEntity.ok(new ApiResponse<>(200, "Tạo người dùng thành công", user));
    }

    @GetMapping
    public ResponseEntity<ApiResponse<List<User>>> getUsers() {
        List<User> ds = userService.getUsers();
        return ResponseEntity.ok(new ApiResponse<>(200, "Lấy danh sách người dùng thành công", ds));
    }

    @GetMapping("/{id}")
    public ResponseEntity<ApiResponse<User>> getUser(@PathVariable("id") Integer id) {
        User user = userService.getUser(id);
        return ResponseEntity.ok(new ApiResponse<>(200, "Lấy người dùng thành công", user));
    }

    @PutMapping("/{id}")
    public ResponseEntity<ApiResponse<User>> updateUser(@PathVariable("id") Integer id,
                                                        @Valid @RequestBody UpdateUserProfileRequest request) {
        User user = userService.updateUser(id, request);
        return ResponseEntity.ok(new ApiResponse<>(200, "Cập nhật người dùng thành công", user));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<ApiResponse<String>> deleteUser(@PathVariable("id") Integer id) {
        userService.deleteUser(id);
        return ResponseEntity.ok(new ApiResponse<>(200, "Xóa người dùng thành công", null));
    }

    @GetMapping("/test-password")
    public ResponseEntity<ApiResponse<String>> testPassword(@RequestParam String username,
                                                            @RequestParam String rawPassword) {
        User user = userService.getUserByUsername(username);
        boolean match = passwordEncoder.matches(rawPassword, user.getPassword());
        String result = match ? "Mật khẩu đúng" : "Mật khẩu sai";
        return ResponseEntity.ok(new ApiResponse<>(200, "Kiểm tra mật khẩu thành công", result));
    }
}
