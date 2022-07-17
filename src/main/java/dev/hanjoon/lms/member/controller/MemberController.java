package dev.hanjoon.lms.member.controller;

import java.security.Principal;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import dev.hanjoon.lms.admin.dto.MemberDto;
import dev.hanjoon.lms.course.dto.TakeCourseDto;
import dev.hanjoon.lms.course.model.ServiceResult;
import dev.hanjoon.lms.course.service.TakeCourseService;
import dev.hanjoon.lms.member.model.MemberInput;
import dev.hanjoon.lms.member.model.ResetPasswordInput;
import dev.hanjoon.lms.member.service.MemberService;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Controller
public class MemberController {
    private final MemberService memberService;
    private final TakeCourseService takeCourseService;

    @RequestMapping("/member/login")
    public String login() {
        return "member/login";
    }

    @GetMapping("/member/find-password")
    public String findPassword() {
        return "member/find_password";
    }

    @PostMapping("/member/find-password")
    public String findPasswordSubmit(Model model, ResetPasswordInput parameter) {
        boolean result = memberService.sendResetPassword(parameter);
        model.addAttribute("result", result);
        return "member/find_password_result";
    }

    @GetMapping("/member/register")
    public String register() {
        return "member/register";
    }

    @PostMapping("/member/register")
    public String registerSubmit(Model model, HttpServletRequest request, MemberInput parameter) {
        boolean result = memberService.register(parameter);
        model.addAttribute("result", result);
        return "member/register_complete";
    }

    @GetMapping("/member/email-auth")
    public String emailAuth(Model model, HttpServletRequest request) {
        String uuid = request.getParameter("id");
        System.out.println(uuid);
        boolean result = memberService.emailAuth(uuid);
        model.addAttribute("result", result);
        return "member/email_auth";
    }

    @GetMapping("/member/info")
    public String memberInfo(Model model, Principal principal) {
        String userId = principal.getName();
        MemberDto detail = memberService.detail(userId);
        model.addAttribute("detail", detail);
        return "member/info";
    }

    @PostMapping("/member/info")
    public String memberInfoSubmit(Model model, MemberInput parameter, Principal principal) {
        String userId = principal.getName();
        parameter.setUserId(userId);
        ServiceResult result = memberService.updateMember(parameter);
        if (!result.isResult()) {
            model.addAttribute("message", result.getMessage());
            return "common/error";
        }
        return "redirect:/member/info";
    }

    @GetMapping("/member/password")
    public String memberPassword(Model model, Principal principal) {
        String userId = principal.getName();
        MemberDto detail = memberService.detail(userId);
        model.addAttribute("detail", detail);
        return "member/password";
    }

    @PostMapping("/member/password")
    public String memberPasswordSubmit(Model model, MemberInput parameter, Principal principal) {
        String userId = principal.getName();
        parameter.setUserId(userId);
        ServiceResult result = memberService.updateMemberPassword(parameter);
        if (!result.isResult()) {
            model.addAttribute("message", result.getMessage());
            return "common/error";
        }
        return "redirect:/member/info";
    }

    @GetMapping("/member/takecourse")
    public String memberTakeCourse(Model model, Principal principal) {
        String userId = principal.getName();
        List<TakeCourseDto> list = takeCourseService.myCourse(userId);
        model.addAttribute("list", list);
        return "member/takecourse";
    }

    @GetMapping("/member/withdraw")
    public String memberWithdraw(Model model) {
        return "member/withdraw";
    }

    @PostMapping("/member/withdraw")
    public String memberWithdrawSubmit(Model model, MemberInput parameter, Principal principal) {
        String userId = principal.getName();
        ServiceResult result = memberService.withdraw(userId, parameter.getPassword());
        if (!result.isResult()) {
            model.addAttribute("message", result.getMessage());
            return "common/error";
        }
        return "redirect:/member/logout";
    }
}
