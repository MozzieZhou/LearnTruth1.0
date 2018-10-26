package com.gem.learntruth.control;

import com.gem.learntruth.miaodiyun.httpApiDemo.AccountInfo;
import com.gem.learntruth.miaodiyun.httpApiDemo.IndustrySMS;
import com.gem.learntruth.pojo.Student;
import com.gem.learntruth.pojo.Teacher;
import com.gem.learntruth.pojo.User;
import com.gem.learntruth.service.StudentService;
import com.gem.learntruth.service.TeacherService;
import com.gem.learntruth.service.UserService;
import com.sun.deploy.net.HttpResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@RequestMapping("/user")
@Controller
public class UserControl {

    @Autowired
    private UserService userService;

    @Autowired
    private StudentService studentService;

    @RequestMapping("/index")
    public String getloginhtml(){return "/html/login";}

    @RequestMapping("/register")
    public String getregisterhtml(){return "/html/register";}


    @RequestMapping("/getYanMa")
    public @ResponseBody String getYanMa(String phone, HttpServletRequest request, HttpSession session) {

        int num = (int) ((Math.random() * 9 + 1) * 100000);//6位随机数字

        System.out.println(num);

//        短信内容,根据注册的模板 例如"【项目中心】您的验证码为23456，请于2分钟内正确输入，如非本人操作，请忽略此短信。"
//        您的验证码为{1}，请于{2}分钟内正确输入，如非本人操作，请忽略此短信。

        String Content = "【学真网】您的验证码为" + num + "，请于2分钟内正确输入，如非本人操作，请忽略此短信。";

        AccountInfo.execute();

        IndustrySMS industrySMS = new IndustrySMS(phone, Content);

        String resJson = industrySMS.execute();

        System.out.println(resJson);

        String reJson=resJson+num;

        return reJson;


    }

    @RequestMapping("/login")
    public String login(User user){

        Student student=userService.stuLogin(user);

        if(student!=null){
            //学生登录成功
            return "";
        }else {

            Teacher teacher=userService.teaLogin(user);

            if(teacher!=null){
                //老师登录成功
                return "";
            }else {
                return "forward:index";
            }

        }
    }

    //ajax查找名字是否重复
    @RequestMapping("/isRepeatName")
    public @ResponseBody String findUname(String uname){

        System.out.println(uname);

        Student student=studentService.getStuByName(uname);

        System.out.println(student);

        if(student!=null){
            return "true";
        }else {
            return "false";
        }

    }

    @RequestMapping("/registerStu")
    public String registerStu(Student student, HttpServletResponse response) throws IOException {


//        Student{id=null, stuno='null', stuname='null', stupwd='530yqah', stutelephone='13222123144', stusex=null, stuemail='123123@qq.com', stuheadpic='null', money=null, status=null}

        boolean isok=studentService.addStuInfor(student);

        boolean b=studentService.addStuNoByStuTele(student.getStutelephone());

        if(b){
//            response.getWriter().write("<script>alert('注册成功')</script>");
            return "redirect:/user/index";
        }else {
//            response.getWriter().write("<script>alert('注册失败')</script>");
            return "redirect:/user/register";
        }


    }


}
