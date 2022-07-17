package dev.hanjoon.lms.admin.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import dev.hanjoon.lms.admin.dto.CategoryDto;
import dev.hanjoon.lms.admin.model.CategoryInput;
import dev.hanjoon.lms.admin.model.MemberParam;
import dev.hanjoon.lms.admin.service.CategoryService;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Controller
public class AdminCategoryController {
    private final CategoryService categoryService;

    @GetMapping("/admin/category/list.do")
    public String list(Model model, MemberParam parameter) {
        List<CategoryDto> list = categoryService.list();
        model.addAttribute("list", list);
        return "admin/category/list";
    }

    @PostMapping("/admin/category/add.do")
    public String add(Model model, CategoryInput parameter) {
        categoryService.add(parameter.getCategoryName());
        return "redirect:/admin/category/list.do";
    }

    @PostMapping("/admin/category/delete.do")
    public String del(Model model, CategoryInput parameter) {
        categoryService.del(parameter.getId());
        return "redirect:/admin/category/list.do";
    }

    @PostMapping("/admin/category/update.do")
    public String update(Model model, CategoryInput parameter) {
        categoryService.update(parameter);
        return "redirect:/admin/category/list.do";
    }
}
