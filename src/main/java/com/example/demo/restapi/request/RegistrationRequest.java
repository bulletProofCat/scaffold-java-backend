package com.example.demo.restapi.request;

import com.example.demo.entity.User;
import lombok.Data;
import org.hibernate.validator.constraints.Length;
import org.springframework.security.crypto.password.PasswordEncoder;

import javax.validation.constraints.Digits;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

@Data
public class RegistrationRequest {

    @NotBlank(message = "用户名不可为空")
    private String name;

    @Length(min = 6, message = "密码至少6位")
    private String password;

    @Pattern(regexp = "\\d+", message = "请输入合法的手机号")
    private String phone;

    public User toUser(PasswordEncoder passwordEncoder) {
        User user = new User();
        user.setName(name);
        user.setPassword(passwordEncoder.encode(password));
        user.setPhone(phone);
        return user;
    }

}
