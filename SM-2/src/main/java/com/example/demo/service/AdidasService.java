package com.example.demo.service;

import com.example.demo.entity.Adidas;
import com.example.demo.mapper.AdidasMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AdidasService {

    @Autowired
    private AdidasMapper adidasMapper;

    public List<Adidas> getAllShoes() {
        return adidasMapper.getAllShoes();
    }
}
