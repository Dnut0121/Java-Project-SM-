package com.example.demo.service;

import com.example.demo.entity.Nike;
import com.example.demo.mapper.NikeMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NikeService {

    @Autowired
    private NikeMapper nikeMapper;

    public List<Nike> getAllShoes() {
        return nikeMapper.getAllShoes();
    }
}
