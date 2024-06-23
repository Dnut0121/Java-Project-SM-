package com.example.demo.dao;

import com.example.demo.entity.User;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class UserDAO {

    @Autowired
    private SqlSession sqlSession;

    public void insertUser(User user) {
        sqlSession.insert("com.example.demo.mapper.UserMapper.insertUser", user);
    }

    public User getUserByUsername(String username) {
        return sqlSession.selectOne("com.example.demo.mapper.UserMapper.getUserByUsername", username);
    }

    public User getUserById(Long id) {
        return sqlSession.selectOne("com.example.demo.mapper.UserMapper.getUserById", id);
    }

    public List<User> getUserList() {
        return sqlSession.selectList("com.example.demo.mapper.UserMapper.getUserList");
    }
}
