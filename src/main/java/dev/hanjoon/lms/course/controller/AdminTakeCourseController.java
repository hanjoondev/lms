package dev.hanjoon.lms.course.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.CollectionUtils;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import dev.hanjoon.lms.course.dto.CourseDto;
import dev.hanjoon.lms.course.dto.TakeCourseDto;
import dev.hanjoon.lms.course.model.ServiceResult;
import dev.hanjoon.lms.course.model.TakeCourseParam;
import dev.hanjoon.lms.course.service.CourseService;
import dev.hanjoon.lms.course.service.TakeCourseService;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Controller
public class AdminTakeCourseController extends BaseController {
    private final CourseService courseService;
    private final TakeCourseService takeCourseService;

    @GetMapping("/admin/takecourse/list.do")
    public String list(Model model, TakeCourseParam parameter, BindingResult bindingResult) {
        parameter.init();
        List<TakeCourseDto> list = takeCourseService.list(parameter);
        long totalCount = 0;
        if (!CollectionUtils.isEmpty(list)) {
            totalCount = list.get(0).getTotalCount();
        }
        String queryString = parameter.getQueryString();
        String pagerHtml = getPaperHtml(totalCount, parameter.getPageSize(), parameter.getPageIndex(), queryString);
        model.addAttribute("list", list);
        model.addAttribute("totalCount", totalCount);
        model.addAttribute("pager", pagerHtml);
        List<CourseDto> courseList = courseService.listAll();
        model.addAttribute("courseList", courseList);
        return "admin/takecourse/list";
    }

    @PostMapping("/admin/takecourse/status.do")
    public String status(Model model, TakeCourseParam parameter) {
        ServiceResult result = takeCourseService.updateStatus(parameter.getId(), parameter.getStatus());
        if (!result.isResult()) {
            model.addAttribute("message", result.getMessage());
            return "common/error";
        }
        return "redirect:/admin/takecourse/list.do";
    }
}
