package dev.hanjoon.lms.course.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import dev.hanjoon.lms.course.dto.TakeCourseDto;
import dev.hanjoon.lms.course.model.TakeCourseParam;

@Mapper
public interface TakeCourseMapper {
    long selectListCount(TakeCourseParam parameter);
    List<TakeCourseDto> selectList(TakeCourseParam parameter);
    List<TakeCourseDto> selectListMyCourse(TakeCourseParam parameter);
}
