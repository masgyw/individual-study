package cn.gyw.community.security.advice;

import java.time.LocalDateTime;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import cn.gyw.community.security.controller.AdminController;
import cn.gyw.community.security.controller.HomeController;
import cn.gyw.community.security.controller.UserController;
import cn.gyw.community.security.domain.ErrorDetails;
import cn.gyw.community.security.exception.CustomizeException;

@RestControllerAdvice(assignableTypes = {UserController.class, HomeController.class, AdminController.class})
public class CustomControllerAdvice {
    @ExceptionHandler
    public HttpEntity customExceptionHandler(CustomizeException e, HttpServletRequest request) {
        ErrorDetails errorDetails = new ErrorDetails();
        errorDetails.setTimestamp(LocalDateTime.now());
        errorDetails.setStatus(HttpStatus.NOT_FOUND.value());
        errorDetails.setError(HttpStatus.NOT_FOUND.getReasonPhrase());
        errorDetails.setMessage(e.getLocalizedMessage());
        errorDetails.setPath(request.getServletPath());
        return ResponseEntity
                .status(HttpStatus.FORBIDDEN)
                .body(errorDetails);
    }
}
