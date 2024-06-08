package com.example.kxchat.controller;


import com.example.kxchat.domain.po.Result;
import com.example.kxchat.domain.po.User;
import com.example.kxchat.service.IUserService;

import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;


import org.springframework.web.bind.annotation.RestController;




/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author 哈哈
 * @since 2024-05-11
 */
@RestController
public class UserController {

    @Autowired
    private IUserService userService;

    @GetMapping("/login")
    public Result<String> login(HttpSession session, String name,int touxiang) {
        User user = userService.findByName(name);
        // 用户名不存在
        boolean b = user != null && user.getStatus() == 0;
        if (user == null) {
            userService.insertNameAndStatus(name,1);
            return Result.success("登陆成功");
        }
        if(b){
            userService.updateStatus(name,1);
            return Result.success("用户已重新上线");
        }
        return Result.error("用户名已存在");
    }

    @GetMapping("/logout")
    public Result<String> logout(String name){
        User user = userService.findByName(name);
        userService.updateStatus(name,0);
        System.out.println("111");
        return Result.success("已退出");

    }

}
