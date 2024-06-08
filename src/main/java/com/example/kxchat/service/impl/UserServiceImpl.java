package com.example.kxchat.service.impl;

import com.example.kxchat.domain.po.User;
import com.example.kxchat.mapper.UserMapper;
import com.example.kxchat.service.IUserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author 哈哈
 * @since 2024-05-11
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements IUserService {

    @Autowired
    UserMapper userMapper;
    @Override
    public User findByName(String name) {
        return userMapper.findByName(name);
    }

    @Override
    public void insertNameAndStatus(String name,int i) {
         userMapper.insertNameAndStatus(name,i);
    }

    @Override
    public void updateStatus(String name,int i) {
        userMapper.updateStatus(name,i);
    }


}
