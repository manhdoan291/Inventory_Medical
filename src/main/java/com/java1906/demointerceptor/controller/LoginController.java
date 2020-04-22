package com.java1906.demointerceptor.controller;

import com.java1906.demointerceptor.data.model.UserInfo;
import com.java1906.demointerceptor.data.model.Users;
import com.java1906.demointerceptor.data.repo.UserInfoRepository;
import com.java1906.demointerceptor.data.repo.UserRepository;
import com.java1906.demointerceptor.dto.AuthenticationRequest;
import com.java1906.demointerceptor.exception.LogicException;
import com.java1906.demointerceptor.utils.TokenManager;
import org.apache.tomcat.util.security.MD5Encoder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
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
        // kiểm tra user và password
        // nếu nhập đúng cấp quyền cho user
        // nếu sai redirect lại trang login
        Optional<Users> user = userRepository.findByUsername(authenticationRequest.getUserName());
        if (user.isPresent()) {
            Users user1 = user.get();
            if (user1.getPassword().equals(MD5Encoder.encode((authenticationRequest.getPassWord() + "this is a salt 3l;3k;j08293nu9p2g5n").getBytes()))) {
                String token = tokenManager.createToken(request.getSession().getId());
                request.getSession().setAttribute("role", user1.getRole());
                request.getSession().setAttribute("AuthToken", token);
                request.getSession().setAttribute("Username", authenticationRequest.getUserName());
                Optional<UserInfo> userInfo =userInfoRepository.findById(user1.getId());
                userInfo.get().setToken(token);
                return userInfo.get();

            }
            throw new LogicException("Invalid login", HttpStatus.NOT_FOUND);
            // throw ma exception dang ma http ok: 200, not found: 40..
        }
        throw new LogicException("Invalid login", HttpStatus.NOT_FOUND);

    }
}
// set session co 3 thu: role la gi, auth cho user da dang nhap hay chua,
