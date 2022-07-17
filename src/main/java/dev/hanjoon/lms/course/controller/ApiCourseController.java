package dev.hanjoon.lms.course.controller;

import java.security.Principal;

import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import dev.hanjoon.lms.common.model.ResponseResult;
import dev.hanjoon.lms.course.model.ServiceResult;
import dev.hanjoon.lms.course.model.TakeCourseInput;
import dev.hanjoon.lms.course.service.CourseService;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@RestController
public class ApiCourseController extends BaseController {
    private final CourseService courseService;

    @PostMapping("/api/course/req.api")
    public ResponseEntity<?> courseReq(Model model, @RequestBody TakeCourseInput parameter, Principal principal) {
        parameter.setUserId(principal.getName());
        ServiceResult result = courseService.req(parameter);
        if (!result.isResult()) {
            ResponseResult responseResult = new ResponseResult(false, result.getMessage());
            return ResponseEntity.ok().body(responseResult);
        }
        ResponseResult responseResult = new ResponseResult(true);
        return ResponseEntity.ok().body(responseResult);
    }
}
