package com.example.kxchat.service;

import com.example.kxchat.domain.po.User;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author 哈哈
 * @since 2024-05-11
 */
public interface IUserService extends IService<User> {

    User findByName(String name);

    void insertNameAndStatus(String name,int i);


    void updateStatus(String name,int i);
}
