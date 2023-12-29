package com.oycm.spring_mvc_starter.config;

import com.oycm.spring_mvc_starter.dto.ReturnInfo;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
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
@ControllerAdvice
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {

    private final Log log = LogFactory.getLog(this.getClass());

    @ExceptionHandler(Exception.class)
    @ResponseBody
    ReturnInfo handleControllerException(HttpServletRequest request, Throwable ex) {
        HttpStatus status = getStatus(request);
        log.error(status.value(),ex);
        return ReturnInfo.buildErrorInfo(ex.getMessage());
    }

    private HttpStatus getStatus(HttpServletRequest request) {
        Integer statusCode = (Integer) request.getAttribute("javax.servlet.error.status_code");
        if (statusCode == null) {
            return HttpStatus.INTERNAL_SERVER_ERROR;
        }
        return HttpStatus.valueOf(statusCode);
    }
}


