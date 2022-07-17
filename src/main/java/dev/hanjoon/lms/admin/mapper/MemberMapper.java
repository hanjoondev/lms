package dev.hanjoon.lms.admin.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import dev.hanjoon.lms.admin.dto.MemberDto;
import dev.hanjoon.lms.admin.model.MemberParam;

@Mapper
public interface MemberMapper {
    long selectListCount(MemberParam parameter);
    List<MemberDto> selectList(MemberParam parameter);
}
