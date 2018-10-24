package com.gem.learntruth.control;

import com.gem.learntruth.miaodiyun.httpApiDemo.AccountInfo;
import com.gem.learntruth.miaodiyun.httpApiDemo.IndustrySMS;
import com.gem.learntruth.pojo.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@Controller
@SessionAttributes("yanz")
public class UserControl {

    @RequestMapping("/index")
    public String index(){
        return "/html/login1";
    }

    @RequestMapping("/login1")
    public String login(){return "/html/login";}

    @RequestMapping("/register")
    public String register(){return "/html/register";}


    @RequestMapping("/getYanMa")
    public @ResponseBody String getYanMa(String phone, HttpServletRequest request, HttpSession session) {

        int num = (int) ((Math.random() * 9 + 1) * 100000);//6位随机数字

        System.out.println(num);

//        短信内容,根据注册的模板 例如"【项目中心】您的验证码为23456，请于2分钟内正确输入，如非本人操作，请忽略此短信。"
//        您的验证码为{1}，请于{2}分钟内正确输入，如非本人操作，请忽略此短信。

        String Content = "【学真网】您的验证码为" + num + "，请于2分钟内正确输入，如非本人操作，请忽略此短信。";

        request.setAttribute("yan", num);

        session.setAttribute("yanz",num);

        AccountInfo.execute();

        IndustrySMS industrySMS = new IndustrySMS(phone, Content);

        String resJson = industrySMS.execute();

        System.out.println(resJson);

        String reJson=resJson+num;

        return reJson;


    }


    @RequestMapping("/login")
    public void login(User user, HttpServletRequest request, HttpServletResponse response) throws IOException {
//            <p>用户名：<input type="text" name="uname"/></p>
//    <p>密码：<input type="password" name="pwd"/></p>
//    <p>手机号码：<input type="number" name="phone" id="phone"/>
//
//        <input type="button" value="获取验证码" id="btn"/> <span id="errormsg"></span></p>
//    <p>验证码：<input type="number" name="phonema" id="phonema"/></p>
//    <p><input type="hidden" name="yanzhengma" id="yanzhengma"/></p>
//
//
//    <input type="submit" value="登录"/> <input type="reset" value="取消"/>

    }


}
