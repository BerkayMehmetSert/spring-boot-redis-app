package com.bms.springredisapp.core.exceptions;

import com.bms.springredisapp.core.exceptions.details.BusinessExceptionDetail;
import com.bms.springredisapp.core.exceptions.details.NotFoundExceptionDetail;
import org.springframework.http.HttpStatus;
import org.springframework.http.ProblemDetail;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@RestControllerAdvice
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {
    @ExceptionHandler(NotFoundException.class)
    public ResponseEntity<ProblemDetail> handleNotFoundException(NotFoundException ex) {
        return new ResponseEntity<>(new NotFoundExceptionDetail(ex.getMessage()), HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(BusinessException.class)
    public ResponseEntity<ProblemDetail> handleBusinessException(BusinessException ex) {
        return new ResponseEntity<>(new BusinessExceptionDetail(ex.getMessage()), HttpStatus.BAD_REQUEST);
    }
}
