package com.oycm.spring_mvc_starter.config;

import com.oycm.spring_mvc_starter.controller.UserController;
import com.oycm.spring_mvc_starter.dto.User;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

import static com.oycm.spring_mvc_starter.config.GlobalExceptionHandler.getStatus;

@ControllerAdvice(assignableTypes = {UserController.class})
public class GlobalExceptionHandlerOne {

    private final Log log = LogFactory.getLog(this.getClass());

    @ExceptionHandler(Exception.class)
    @ResponseBody
    User handleControllerException(HttpServletRequest request, Throwable ex) {
        User user = new User();
        HttpStatus status = getStatus(request);
        log.error(status.value(),ex);
        user.setUsername("Error");
        user.setAge(status.value());
        return user;
    }
}
