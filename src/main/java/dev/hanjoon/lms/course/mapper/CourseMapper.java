package dev.hanjoon.lms.course.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import dev.hanjoon.lms.course.dto.CourseDto;
import dev.hanjoon.lms.course.model.CourseParam;

@Mapper
public interface CourseMapper {
    long selectListCount(CourseParam parameter);
    List<CourseDto> selectList(CourseParam parameter);
}
