package com.java1906.climan.utils;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.java1906.climan.data.model.RoleType;
import com.java1906.climan.interceptor.HasRole;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

@Component
public class TokenManager {

    public static TokenManager tokenManager;
    private Map<String, String> storedTokens = new HashMap<>();
    private Map<String, RoleType> mappedRoles = new HashMap<>();

    @Autowired
    private ObjectMapper mapper;

    public static TokenManager getInstance() {
        return tokenManager;
    }

    @PostConstruct
    public void setup() {
        tokenManager = this;

    }

    public String createToken(String username, RoleType role) {
        String uuidToken = UUID.randomUUID().toString();
        storedTokens.put(uuidToken, username);
        mappedRoles.put(username, role);
        return uuidToken;
    }

    public boolean isAuthenticated(HttpServletRequest request) throws JsonProcessingException {
        System.out.println(mapper.writeValueAsString(storedTokens));
        String token = getToken(request);
        return storedTokens.get(token) != null;
    }

    private String getToken(HttpServletRequest request) {
        String token = request.getHeader("AuthToken");
        if (token == null) {
            token = request.getParameter("AuthToken");
        }
        if (token == null) {
            token = (String) request.getSession().getAttribute("AuthToken");
        }
        return token;
    }

    public boolean hasRole(HttpServletRequest request, HasRole hasRole) throws JsonProcessingException {
        RoleType roleType = mappedRoles.get(storedTokens.get(getToken(request)));
        if (roleType == null) {
            return false;
        }
        for (String role : hasRole.value()) {
            if (role.equals(roleType.toString()))
                return true;
        }
        return false;
    }
}
