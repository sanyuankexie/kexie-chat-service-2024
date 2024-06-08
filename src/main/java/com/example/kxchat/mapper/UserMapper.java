package com.example.kxchat.mapper;

import com.example.kxchat.domain.po.User;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.*;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author 哈哈
 * @since 2024-05-11
 */
@Mapper
public interface UserMapper extends BaseMapper<User> {

    @Select("select * from user where name=#{name}")
    User findByName(@Param("name") String name);

    @Insert("INSERT INTO user (name,status) VALUES (#{name},#{i})")
    void insertNameAndStatus(String name,int i);


    @Update("UPDATE user SET status = #{i} WHERE name = #{name}")
    void updateStatus(String name,int i);
}
