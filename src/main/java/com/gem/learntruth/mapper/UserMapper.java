package com.gem.learntruth.mapper;


import com.gem.learntruth.pojo.Student;
import com.gem.learntruth.pojo.Teacher;
import com.gem.learntruth.pojo.User;

public interface UserMapper {

    Student selectStuBystuNameAndPwd(String uname, String pwd);

    Teacher selectTeaByteNameAndPwd(String uname, String pwd);
}