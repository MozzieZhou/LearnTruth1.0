package com.gem.learntruth.service;

import com.gem.learntruth.pojo.Student;
import com.gem.learntruth.pojo.Teacher;
import com.gem.learntruth.pojo.User;

public interface UserService {

   Student stuLogin(User user);
   Teacher teaLogin(User user);



}
