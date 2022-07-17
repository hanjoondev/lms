package dev.hanjoon.lms.course.service;

import java.util.List;

import dev.hanjoon.lms.course.dto.TakeCourseDto;
import dev.hanjoon.lms.course.model.ServiceResult;
import dev.hanjoon.lms.course.model.TakeCourseParam;

public interface TakeCourseService {
    /**
     * 수강 목록
     */
    List<TakeCourseDto> list(TakeCourseParam parameter);

    /**
     * 수강 상세 정보
     */
    TakeCourseDto detail(long id);

    /**
     * 수강내용 상태 변경
     */
    ServiceResult updateStatus(long id, String status);

    /**
     * 내 수강내역 목록
     */
    List<TakeCourseDto> myCourse(String userId);

    /**
     * 수강신청 취소 처리
     */
    ServiceResult cancel(long id);
}
