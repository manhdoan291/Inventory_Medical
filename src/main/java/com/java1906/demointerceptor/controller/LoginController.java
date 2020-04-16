package com.java1906.demointerceptor.controller;

import com.java1906.demointerceptor.data.model.User;
import com.java1906.demointerceptor.data.repo.UserRepository;
import com.java1906.demointerceptor.utils.TokenManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.Optional;

@Controller
@ResponseBody
public class LoginController {

    @Autowired
    private TokenManager tokenManager;

    @Autowired
    private UserRepository userRepository;

    public String login(
    ) {
        return "login";
    }

    @RequestMapping("/doLogin")
    public String doLogin(
            HttpServletRequest request,
            @RequestParam("username") String username,
            @RequestParam("password") String password) {

        Optional<User> user = userRepository.findByUsername("Casper");
        if (user.isPresent()) {
            User user1 = user.get();
        }

        if (username.equals("Casper") && password.equals("1111")) {
            String token = tokenManager.createToken(request.getSession().getId());
            request.getSession().setAttribute("AuthToken", token);
            request.getSession().setAttribute("Username", username);
            return "success";
        } else if (username.equals("Admin") && password.equals("2222")) {
            String token = tokenManager.createToken(request.getSession().getId());
            request.getSession().setAttribute("AuthToken", token);
            request.getSession().setAttribute("Username", username);
            return "success";
        } else {
            request.getSession().setAttribute("AuthToken", null);
            return "error";
        }

    }
}
