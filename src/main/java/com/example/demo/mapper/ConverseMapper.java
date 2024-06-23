package com.example.demo.mapper;

import com.example.demo.entity.Converse;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface ConverseMapper {

    @Select("SELECT * FROM converse")
    List<Converse> getAllShoes();
}
