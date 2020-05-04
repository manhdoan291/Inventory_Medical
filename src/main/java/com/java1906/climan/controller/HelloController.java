package com.java1906.climan.controller;

import com.java1906.climan.interceptor.HasRole;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@ResponseBody
public class HelloController {
    @GetMapping("/hello")
    public String doCheckLogin() {
        return "Welcome anyone";
    }

    @GetMapping("/helloAdmin")
    @HasRole("ADMIN")
    public String doCheckLoginAdmin() {
        return "You're login successed and getting this data as an Administrator";
    }

    @GetMapping("/helloUser")
    @HasRole({"USER", "ADMIN"})
    public String doCheckLoginUser() {
        return "You're login successed and getting this data as an User";
    }
}
