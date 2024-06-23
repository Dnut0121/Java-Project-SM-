package com.example.demo.mapper;

import com.example.demo.entity.Adidas;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface AdidasMapper {

    @Select("SELECT * FROM adidas")
    List<Adidas> getAllShoes();
}
