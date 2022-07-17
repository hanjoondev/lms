package dev.hanjoon.lms.admin.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import dev.hanjoon.lms.admin.dto.CategoryDto;

@Mapper
public interface CategoryMapper {
    List<CategoryDto> select(CategoryDto parameter);
}
