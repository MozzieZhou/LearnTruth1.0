package com.gem.learntruth.service.Impl;

import com.gem.learntruth.mapper.UserMapper;
import com.gem.learntruth.pojo.Student;
import com.gem.learntruth.pojo.Teacher;
import com.gem.learntruth.pojo.User;
import com.gem.learntruth.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public Student stuLogin(User user) {
        return userMapper.selectStuBystuNameAndPwd(user.getUname(),user.getPwd());
    }

    @Override
    public Teacher teaLogin(User user) {
        return userMapper.selectTeaByteNameAndPwd(user.getUname(),user.getPwd());
    }

}
