package com.example.demo.mapper;

import com.example.demo.entity.User;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface UserMapper {

    @Insert("INSERT INTO users (username, password, grade, likes) VALUES (#{username}, #{password}, 1, 0)")
    void insertUser(User user);

    @Select("SELECT * FROM users ORDER BY id DESC")
    List<User> getUserList();

    @Select("SELECT * FROM users WHERE username = #{username}")
    User getUserByUsername(String username);

    @Update("UPDATE users SET grade = #{grade} WHERE username = #{username}")
    void updateUser(User user);
}
