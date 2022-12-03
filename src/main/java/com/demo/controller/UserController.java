package com.demo.controller;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.demo.entity.Result;
import com.demo.entity.User;
import com.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.DigestUtils;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.nio.charset.StandardCharsets;

@RestController
public class UserController {
    @Autowired
    private UserService userService;
    @PostMapping("/addUsers")
    public Result addUser(@RequestBody User user){
        userService.save(user);
        return Result.success();

    }

    @PostMapping("/login")
    public Result login(HttpServletRequest  request, @RequestBody User user){
        //将页面提交地密码加密处理
        String password = user.getPassword();
//        password = DigestUtils.md5DigestAsHex(password.getBytes());

        //查询
        LambdaQueryWrapper<User>queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.eq(User::getUsername,user.getUsername());
        User user1 = userService.getOne(queryWrapper);
        if (user1 == null){
            return Result.error();
        }
        //比对
        if(!user1.getPassword().equals(password)){
            return Result.error();
        }
        request.getSession().setAttribute("user",user1.getUserId());
        return  Result.success();
    }
}
