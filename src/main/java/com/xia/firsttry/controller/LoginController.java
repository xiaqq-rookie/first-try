package com.xia.firsttry.controller;

import com.xia.firsttry.entity.User;
import com.xia.firsttry.result.Result;
import com.xia.firsttry.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.util.HtmlUtils;

import java.util.Objects;

@Controller
public class LoginController {

    @Autowired
    UserService userService;

    @CrossOrigin
    @PostMapping (value = "api/login")
    @ResponseBody
    public Result login (@RequestBody User requestUser) {
        //对html标签进行转义，防止 XSS 攻击
        String username = requestUser.getUsername();
        username = HtmlUtils.htmlEscape(username);

        User user = userService.getByUsernameAndPassword(username, requestUser.getPassword());
        if(null == user) {
            return new Result(400);
        }else{
            return new Result(200);
        }
    }

}
