package com.oycm.spring_mvc_starter.config;

import com.oycm.spring_mvc_starter.controller.ExampleController;
import com.oycm.spring_mvc_starter.dto.ReturnInfo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import javax.servlet.http.HttpServletRequest;

/**
 * @author ouyangcm
 * create 2023/12/27 15:29
 */
@ControllerAdvice(assignableTypes = {ExampleController.class})
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {

    private static final Logger log = LoggerFactory.getLogger(GlobalExceptionHandler.class);

    @ExceptionHandler(Exception.class)
    @ResponseBody
    ReturnInfo handleControllerException(HttpServletRequest request, Throwable ex) {

        HttpStatus status = getStatus(request);
        //return new ReturnInfo(status.value(), ex.getMessage());
        log.error(String.valueOf(status.value()), ex);
        return ReturnInfo.buildErrorInfo(ex.getMessage());
    }

    public static HttpStatus getStatus(HttpServletRequest request) {
        Integer statusCode = (Integer) request.getAttribute("javax.servlet.error.status_code");
        log.info("errorCode: {}", statusCode);
        if (statusCode == null) {
            return HttpStatus.INTERNAL_SERVER_ERROR;
        }
        return HttpStatus.valueOf(statusCode);
    }
}


