package com.example.demo.service;

import com.example.demo.entity.User;
import com.example.demo.entity.UserExample;
import com.example.demo.mapper.UserMapper;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class UserService {

    @Autowired
    private SqlSession sqlSession;

    private UserMapper getMapper() {
        return sqlSession.getMapper(UserMapper.class);
    }

    public @Nullable User getUser() {
        try {
            UserExample userExample = new UserExample();
            userExample.createCriteria().andNameEqualTo("gaolf");
            List<User> users = getMapper().selectByExample(userExample);
            if (users != null && users.size() == 1) {
                return users.get(0);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

}
