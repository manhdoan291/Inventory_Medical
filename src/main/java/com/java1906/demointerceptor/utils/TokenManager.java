package com.java1906.demointerceptor.utils;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.java1906.demointerceptor.interceptor.HasRole;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.servlet.http.HttpServletRequest;
import java.util.*;

@Component
public class TokenManager {

    public static TokenManager tokenManager;
    private Map<String, String> storedTokens = new HashMap<>();
    private Map<String, List<String>> storedRoles = new HashMap<>();
    @Autowired
    private ObjectMapper mapper;

    public static TokenManager getInstance() {
        return tokenManager;
    }

    @PostConstruct
    public void setup() {
        tokenManager = this;
        ArrayList<String> users = new ArrayList<>();
        users.add("Casper");
        ArrayList<String> adminUsers = new ArrayList<>();
        adminUsers.add("Admin");
        storedRoles.put("USER", users);
        storedRoles.put("ADMIN", adminUsers);
    }

    public String createToken(String sessionId) {
        String uuidToken = UUID.randomUUID().toString();
        storedTokens.put(sessionId, uuidToken);
        return uuidToken;
    }

    public boolean isAuthenticated(String sessionId, HttpServletRequest request) throws JsonProcessingException {
        System.out.println(mapper.writeValueAsString(storedTokens));
        String token = request.getHeader("AuthToken");
        if (token == null) {
            token = request.getParameter("AuthToken");
        }
        if (token == null) {
            token = (String) request.getSession().getAttribute("AuthToken");
        }
        return storedTokens.get(sessionId) != null && storedTokens.get(sessionId).equals(token);
    }

    public boolean hasRole(HttpServletRequest request, HasRole hasRole) throws JsonProcessingException {
        System.out.println(mapper.writeValueAsString(storedTokens));
        String username = (String) request.getSession().getAttribute("Username");
        for (Map.Entry<String, List<String>> roleEntry : storedRoles.entrySet()) {
            for (String usernameHasRole : roleEntry.getValue()) {
                if (usernameHasRole.equals(username) && checkExistedInArray(roleEntry.getKey(), hasRole.value())) {
                    return true;
                }
            }
        }
        return false;
    }

    private boolean checkExistedInArray(String value, String[] array) {
        if (value == null)
            return false;
        for (String item : array) {
            if (value.equals(item)) {
                return true;
            }
        }
        return false;
    }
}
