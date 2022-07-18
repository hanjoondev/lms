package dev.hanjoon.lms.banner.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import dev.hanjoon.lms.banner.dto.BannerDto;
import dev.hanjoon.lms.banner.model.BannerParam;

@Mapper
public interface BannerMapper {
    long selectListCount();
    List<BannerDto> selectList(BannerParam parameter);
}
