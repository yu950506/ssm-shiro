package cn.yhs.learn.controller;

import cn.yhs.learn.domain.User;
import cn.yhs.learn.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import java.util.List;


/**
 * @ProjectName: ssm-shiro
 * @Name: cn.yhs.learn.controller.UserController
 * @Author: Splendor -- 加油,你是最棒的 ~_~
 * @Email: 15617577080@163.com
 * @Time: 2020/6/18 18:46
 * @Description: todo
 **/
@Slf4j
@Controller
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService;


    @RequiresPermissions(value = "user:find")
    @ResponseBody
    @RequestMapping("/findAll")
    public Object findAll() {
        List<User> userList = userService.findAll();
        return userList;
    }

    @RequestMapping("/login")
    public String login(@RequestParam(required = true) String username, @RequestParam(required = true) String password, HttpSession session) {
        Subject subject = SecurityUtils.getSubject();
        UsernamePasswordToken token = new UsernamePasswordToken(username, password);
        try {
            subject.login(token);
            User user = (User) subject.getPrincipal();
            // 登录成功！将用户信息保存到Session中去
            session.setAttribute("user", user);
            System.out.println("session = " + session);
            log.info("登录成功");
            Session subjectSession = subject.getSession();
            System.out.println("subjectSession = " + subjectSession);
            boolean hasUserRole = subject.hasRole("user");
            System.out.println("hasUserRole = " + hasUserRole);
            boolean hasAdminRole = subject.hasRole("admin");
            System.out.println("hasAdminRole = " + hasAdminRole);
            boolean permitted = subject.isPermitted("user:add");
            System.out.println("permitted = " + permitted);

            // 去用户列表页
            return "user_list";
        } catch (AuthenticationException e) {
            // 登录失败
            log.info("登录失败:{}", e.getLocalizedMessage());
            // 跳转发哦登录页面
            return "redirect:/login.jsp";
        }

    }


}
