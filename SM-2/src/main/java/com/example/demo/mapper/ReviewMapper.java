package com.example.demo.mapper;

import com.example.demo.entity.Review;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface ReviewMapper {

    @Select("SELECT * FROM reviews WHERE shoeNum = #{shoeNum} ORDER BY reviewDate DESC")
    List<Review> getReviewsByShoeNum(int shoeNum);

    @Insert("INSERT INTO reviews (shoeNum, username, reviewText, reviewDate) VALUES (#{shoeNum}, #{username}, #{reviewText}, #{reviewDate})")
    void insertReview(Review review);
}
