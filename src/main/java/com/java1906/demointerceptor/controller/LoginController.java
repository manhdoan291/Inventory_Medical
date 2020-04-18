package com.java1906.demointerceptor.controller;

import com.java1906.demointerceptor.data.model.User;
import com.java1906.demointerceptor.data.repo.UserRepository;
import com.java1906.demointerceptor.utils.TokenManager;
import org.apache.tomcat.util.security.MD5Encoder;
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

    @RequestMapping(value = "/login")
    public String login() {
        return "login";
    }

    @RequestMapping("/doLogin")
    public String doLogin(
            HttpServletRequest request,
            @RequestParam("username") String username,
            @RequestParam("password") String password) {
        // kiểm tra user và password
        // nếu nhập đúng cấp quyền cho user
        // nếu sai redirect lại trang login

        Optional<User> user = userRepository.findByUsername(username);
        if (user.isPresent()) {
            User user1 = user.get();
            if (user1.getPassword().equals(MD5Encoder.encode((password + "this is a salt 3l;3k;j08293nu9p2g5n").getBytes()))) {
                String token = tokenManager.createToken(request.getSession().getId());
                request.getSession().setAttribute("role", user1.getRole());
                request.getSession().setAttribute("AuthToken", token);
                request.getSession().setAttribute("Username", username);
                return "Success";
            }
            return "failure";
        }
        return "failure";

    }
}
// set session co 3 thu: role la gi, auth cho user da dang nhap hay chua,
