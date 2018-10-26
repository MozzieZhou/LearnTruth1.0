package com.gem.learntruth.service;

import com.gem.learntruth.pojo.Student;

public interface StudentService {

    Student getStuByName(String name);

    boolean addStuInfor(Student student);

    boolean addStuNoByStuTele(String telephone);

}
