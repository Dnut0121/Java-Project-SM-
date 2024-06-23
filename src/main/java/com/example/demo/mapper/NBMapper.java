package com.example.demo.mapper;

import com.example.demo.entity.NB;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface NBMapper {

    @Select("SELECT * FROM NB")
    List<NB> getAllShoes();
}
