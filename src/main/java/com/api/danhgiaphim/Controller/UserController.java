package com.api.danhgiaphim.Controller;

import com.api.danhgiaphim.dto.request.ApiResponse;
import com.api.danhgiaphim.dto.request.UserRequest;
import com.api.danhgiaphim.entity.User;
import com.api.danhgiaphim.service.UserService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @PostMapping
    public ApiResponse<User> createUser(@RequestBody UserRequest request) {
        ApiResponse<User> apiRespone = new ApiResponse<>();
        apiRespone.setResult(userService.createUser(request));
        return apiRespone;
    }

    @GetMapping
    public List<User> getUsers() {
        return userService.getUsers();
    }

    @GetMapping("/{id}")
    public ApiResponse<User> getUser(@PathVariable("id") Integer id) {
        ApiResponse<User> apiRespone = new ApiResponse<>();
        apiRespone.setResult(userService.getUser(id));
        return apiRespone;
    }

    @PutMapping("/{id}")
    public User updateUser(@PathVariable("id") Integer id, @RequestBody UserRequest request) {
        return userService.updateUser(id, request);
    }

    @DeleteMapping("/{id}")
    public String deleteUser(@PathVariable("id") Integer id) {
        userService.deleteUser(id);
        return "Đã xoá người dùng";
    }

    @GetMapping("/test-password")
    public String testPassword(@RequestParam String username, @RequestParam String rawPassword) {
        User user = userService.getUserByUsername(username); // bạn cần thêm hàm này
        boolean match = passwordEncoder.matches(rawPassword, user.getPassword());
        return match ? "Mật khẩu đúng" : "Mật khẩu sai";
    }
}
