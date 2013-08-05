package com.jingpaidang.tools.batch.controller.user;


import com.jingpaidang.tools.batch.service.user.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("user")
public class UserController {
    @Autowired
    private HttpServletRequest request;

    @Autowired
    private HttpSession session;



    @Resource
    private UserService userService;
    /**
     *
     * @Title:toadd
     * @Description:TODO(跳转到添加)
     * @param:
     * @return:String
     * @throws
     * @Create: 2013-7-25 下午2:43:19
     * @Author : Alex
     */
    @RequestMapping("toadd")
    public String toadd(){

        System.err.println("==================");
        return "user/add" ;
    }

    @RequestMapping("list")
    @ResponseBody
    public String list() {
        userService.findAllUser();


        return "user/list";
    }

    /**
     * 测试ftl
     * @return
     */
    @RequestMapping("testftl")
    public String testftl() {
        System.err.println(request.getParameter("name"));
        System.err.println(session);
        return "userLogin";
    }

}
