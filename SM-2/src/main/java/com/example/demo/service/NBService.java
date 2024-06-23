package com.example.demo.service;

import com.example.demo.entity.NB;
import com.example.demo.mapper.NBMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NBService {

    @Autowired
    private NBMapper nbMapper;

    public List<NB> getAllShoes() {
        return nbMapper.getAllShoes();
    }
}
