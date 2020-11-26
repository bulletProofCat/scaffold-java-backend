package com.example.demo.restapi.response;

import com.example.demo.entity.User;

import java.time.LocalDateTime;

public class UserResponse {
    private Long id;
    private String phone;
    private String name;
    private String email;
    private int sex;
    private String avatar;
    private String departmentId;
    private int enabled;
    private LocalDateTime createTime;
    private LocalDateTime updateTime;

    public static UserResponse fromUser(User user) {
        UserResponse userResponse = new UserResponse();
        userResponse.id = user.getId();
        userResponse.phone = user.getPhone();
        userResponse.name = user.getName();
        userResponse.email = user.getEmail();
        userResponse.sex = user.getSex();
        userResponse.avatar = user.getAvatar();
        userResponse.departmentId = user.getDepartmentId();
        userResponse.enabled = user.getEnabled();
        userResponse.createTime = user.getCreateTime();
        userResponse.updateTime = user.getUpdateTime();
        return userResponse;
    }
}
