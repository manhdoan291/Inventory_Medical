package com.java1906.climan.controller;

import com.java1906.climan.data.model.UserInfo;
import com.java1906.climan.data.model.User;
import com.java1906.climan.data.repo.UserInfoRepository;
import com.java1906.climan.data.repo.UserRepository;
import com.java1906.climan.dto.AuthenticationRequest;
import com.java1906.climan.exception.LogicException;
import com.java1906.climan.utils.TokenManager;
import org.apache.commons.codec.digest.DigestUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.Optional;

@Controller
public class LoginController {

    @Autowired
    private TokenManager tokenManager;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private UserInfoRepository userInfoRepository;

    @RequestMapping(value = "/login")
    public String login()  {
        return "login";
    }

    @RequestMapping("/doLogin")
    @ResponseBody
    public Object doLogin (
            HttpServletRequest request,
            @RequestBody AuthenticationRequest authenticationRequest
            ) throws LogicException {
        Optional<User> user = userRepository.findByUsername(authenticationRequest.getUserName());
        if (user.isPresent()) {
            User user1 = user.get();

            String md5Hex = DigestUtils
                    .md5Hex(authenticationRequest.getPassWord()).toUpperCase();
            if (user1.getPassword().toUpperCase().equals(md5Hex)) {
                String token = tokenManager.createToken(request.getSession().getId());
                request.getSession().setAttribute("role", user1.getRole());
                request.getSession().setAttribute("AuthToken", token);
                request.getSession().setAttribute("Username", authenticationRequest.getUserName());
                Optional<UserInfo> userInfo =userInfoRepository.findById(user1);
                userInfo.get().setToken(token);

                return userInfo.get();

            }
            throw new LogicException("Invalid login", HttpStatus.NOT_FOUND);
            // throw ma exception dang ma http ok: 200, not found: 40..
        }
        throw new LogicException("Invalid login", HttpStatus.NOT_FOUND);
    }

    @GetMapping("/logout")
    public ResponseEntity logout(HttpSession session) {
        session.removeAttribute("role");
        session.removeAttribute("AuthToken");
        session.removeAttribute("Username");
        return ResponseEntity.ok(" ") ;
    }
}
// set session co 3 thu: role la gi, auth cho user da dang nhap hay chua,
