/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.swodd.backend.resource;

import com.swodd.backend.service.UserService;
import java.util.Collections;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author User
 */

@RestController
public class LoginResource {
    
    @Autowired
    private UserService userService;
    
    @RequestMapping("/token")
    public Map<String, String> token(HttpSession session, HttpServletRequest request){
        System.out.println(request.getRemoteHost());
        
        String remoteHost = request.getRemoteHost();
        int portNumber = request.getRemotePort();
        
        System.out.println(remoteHost + ":" + portNumber);
        System.out.println(request.getRemoteAddr());
        
        return Collections.singletonMap("token", session.getId());
    }
    
}
