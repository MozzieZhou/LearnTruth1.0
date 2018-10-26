package com.gem.learntruth.service.Impl;

import com.gem.learntruth.mapper.StudentMapper;
import com.gem.learntruth.pojo.Student;
import com.gem.learntruth.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StudentServiceImpl implements StudentService {

    @Autowired
    private StudentMapper studentMapper;


    @Override
    public Student getStuByName(String telephone) {
        return studentMapper.selectStuByTelephone(telephone);
    }

    @Override
    public boolean addStuInfor(Student student) {
        return studentMapper.insertStuInfor(student.getStutelephone(),student.getStupwd(),student.getStuemail());
    }

    @Override
    public boolean addStuNoByStuTele(String telephone) {

//        Student{id=null, stuno='null', stuname='null', stupwd='530yqah', stutelephone='13222123144', stusex=null, stuemail='123123@qq.com', stuheadpic='null', money=null, status=null}

        Student student=getStuByName(telephone);

        System.out.println(student);


        String stuNo="s"+student.getId();

        return studentMapper.updateStuNoByTele(telephone,stuNo);
    }
}
