package com.example.demo.mapper;

import com.example.demo.entity.Nike;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface NikeMapper {

    @Select("SELECT * FROM nike")
    List<Nike> getAllShoes();
}
