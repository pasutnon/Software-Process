package com.sit.swprocess.DogeCommerce.Config.Interceptor;

import com.auth0.jwt.exceptions.JWTVerificationException;
import com.auth0.jwt.interfaces.DecodedJWT;
import com.sit.swprocess.DogeCommerce.User.JwtService;
import com.sit.swprocess.DogeCommerce.User.User;
import com.sit.swprocess.DogeCommerce.User.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Map;
import java.util.Optional;

@Component
public class AuthInterceptor extends HandlerInterceptorAdapter {

    @Autowired
    JwtService jwtService;

    @Autowired
    UserService userService;

    public AuthInterceptor() {
        super();
    }

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        Map<String, String> pathVariables = (Map<String, String>) request.getAttribute(HandlerMapping.URI_TEMPLATE_VARIABLES_ATTRIBUTE);
        System.out.println(pathVariables);
        System.out.println("interceppp");
        String token = request.getHeader("Authorization");
        try {
            DecodedJWT jwt = jwtService.verify(token);
            Optional<User> incomingUserOptional = userService.getUserById(Long.parseLong(pathVariables.get("userId")));
            User jwtUser = userService.getUserById(jwt.getClaim("id").asLong()).get();
            if( incomingUserOptional.isPresent() ) {
                User incomingUser = incomingUserOptional.get();
                if(jwtUser.getId() == incomingUser.getId()) {
                    return true;
                }
            }
        }catch(JWTVerificationException jwte) {
            jwte.printStackTrace();
            response.sendError(403);
            return false;
        }
        return super.preHandle(request, response, handler);
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        super.postHandle(request, response, handler, modelAndView);
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        super.afterCompletion(request, response, handler, ex);
    }

    @Override
    public void afterConcurrentHandlingStarted(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        super.afterConcurrentHandlingStarted(request, response, handler);
    }
}