package com.java1906.demointerceptor.controller;

import com.java1906.demointerceptor.interceptor.HasRole;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;

@Controller
@RequestBody
public class CategoryController {
    //@Autowired

    //@InitBinder

    @RequestMapping(value= {"/category/list","/category/list/"})

    public String redirect() {
        return "redirect:/category/list/1";
    }

    @RequestMapping(value="/category/list/{page}")
    @HasRole({"USER", "ADMIN"})
    public String showCategoryList(Model model, HttpSession session , @ModelAttribute("searchForm") Category category, @PathVariable("page") int page) {
        //body

        //model.addAttribute();
        return "category-list";
    }

    @GetMapping("/category/add")
    @HasRole({"USER", "ADMIN"})
    public String add(Model model) {
        //body

        //model.addAttribute();
        return "category-action";
    }

    @GetMapping("/category/edit/{id}")
    @HasRole({"USER", "ADMIN"})
    public String edit(Model model , @PathVariable("id") int id) {
        //body

        //model.addAttribute();
        return "category-action";
    }
        return "redirect:/category/list";
    }

    @GetMapping("/category/view/{id}")
    @HasRole({"USER", "ADMIN"})
    public String view(Model model , @PathVariable("id") int id) {
        //body

        // model.addAttribute();
            return "category-action";
        }
        return "redirect:/category/list";
    }

    @PostMapping("/category/save")
    @HasRole({"USER", "ADMIN"})
    public String save(Model model, @ModelAttribute("modelForm") @Validated Category category, BindingResult result, HttpSession session) {
        //body

        // model.addAttribute();

        return "redirect:/category/list";

    }

    @GetMapping("/category/delete/{id}")
    @HasRole({"USER", "ADMIN"})
    public String delete(Model model , @PathVariable("id") int id,HttpSession session) {
        //body

        // model.addAttribute();
        return "redirect:/category/list";
    }
}
