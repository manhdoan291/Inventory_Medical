package com.java1906.climan.utils;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.java1906.climan.interceptor.HasRole;
import org.apache.commons.lang3.ArrayUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.servlet.http.HttpServletRequest;
import java.util.*;

@Component
public class TokenManager {

    public static TokenManager tokenManager;
    private Map<String, String> storedTokens = new HashMap<>();

    @Autowired
    private ObjectMapper mapper;

    public static TokenManager getInstance() {
        return tokenManager;
    }

    @PostConstruct
    public void setup() {
        tokenManager = this;

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
        Object role = request.getSession().getAttribute("role");
        if ((role != null) && (ArrayUtils.contains(hasRole.value(), role.toString())))
        {

            return true;
        }
        else
        {
            return false;
        }

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
