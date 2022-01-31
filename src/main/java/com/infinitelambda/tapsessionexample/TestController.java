package com.infinitelambda.tapsessionexample;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;

@RestController
public class TestController {

    @RequestMapping("/")
    public Map<String, String> hello(HttpServletRequest request) {
        String username = request.getUserPrincipal().getName();
        String sessionId = request.getSession().getId();
        return Map.of("message", "Hello " + username + "! (Session: " + sessionId + ")");
    }

    @GetMapping("/admin")
    public String adminOnly() {
        return "Success";
    }
}
