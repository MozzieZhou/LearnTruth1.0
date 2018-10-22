package com.gem.learntruth.control;

import com.gem.learntruth.miaodiyun.httpApiDemo.AccountInfo;
import com.gem.learntruth.miaodiyun.httpApiDemo.IndustrySMS;
import com.gem.learntruth.pojo.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Controller
public class UserControl {

    @RequestMapping("/index")
    public String index(){
        return "/html/login";
    }


    @RequestMapping("/getYanMa")
    public String getYanMa(String phone, HttpServletRequest request) {

        int num = (int) ((Math.random() * 9 + 1) * 100000);//6位随机数字

        System.out.println(num);

//        短信内容,根据注册的模板 例如"【项目中心】您的验证码为23456，请于2分钟内正确输入，如非本人操作，请忽略此短信。"
//        您的验证码为{1}，请于{2}分钟内正确输入，如非本人操作，请忽略此短信。

        String Content = "【学真网】您的验证码为" + num + "，请于2分钟内正确输入，如非本人操作，请忽略此短信。";

        request.setAttribute("yan", num);

        AccountInfo.execute();

        IndustrySMS industrySMS = new IndustrySMS(phone, Content);

        String resJson = industrySMS.execute();

        System.out.println(resJson);

        return resJson;


    }


    @RequestMapping("/login")
    public void login(User user, HttpServletRequest request, HttpServletResponse response) throws IOException {
        if (user.getUname().equals("xl") && user.getPwd().equals("123")) {
            response.setCharacterEncoding("utf-8");
            response.getWriter().print("登录成功");
        }

    }


}
