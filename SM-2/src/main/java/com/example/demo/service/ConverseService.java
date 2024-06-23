package com.example.demo.service;

import com.example.demo.entity.Converse;
import com.example.demo.mapper.ConverseMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ConverseService {

    @Autowired
    private ConverseMapper converseMapper;

    public List<Converse> getAllShoes() {
        return converseMapper.getAllShoes();
    }
}
