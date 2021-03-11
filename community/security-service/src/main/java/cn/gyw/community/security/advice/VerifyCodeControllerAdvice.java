package cn.gyw.community.security.advice;

import java.time.LocalDateTime;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import cn.gyw.community.security.controller.VerifyCodeController;
import cn.gyw.community.security.domain.ErrorDetails;
import cn.gyw.community.security.exception.VerifyFailedException;

@RestControllerAdvice(assignableTypes = VerifyCodeController.class)
public class VerifyCodeControllerAdvice {

    @ExceptionHandler
    public HttpEntity verifyFailedExceptionHandler(VerifyFailedException e, HttpServletRequest request) {
        ErrorDetails errorDetails = new ErrorDetails();
        errorDetails.setTimestamp(LocalDateTime.now());
        errorDetails.setStatus(HttpStatus.FORBIDDEN.value());
        errorDetails.setError(HttpStatus.FORBIDDEN.getReasonPhrase());
        errorDetails.setMessage(e.getLocalizedMessage());
        errorDetails.setPath(request.getServletPath());
        return ResponseEntity
                .status(HttpStatus.FORBIDDEN)
                .body(errorDetails);
    }
}
