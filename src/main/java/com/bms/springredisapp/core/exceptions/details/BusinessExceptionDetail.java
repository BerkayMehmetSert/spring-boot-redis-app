package com.bms.springredisapp.core.exceptions.details;

import org.springframework.http.HttpStatus;
import org.springframework.http.ProblemDetail;

import java.net.URI;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class BusinessExceptionDetail extends ProblemDetail {
    public BusinessExceptionDetail(String detail){
        setTitle("Business Exception");
        setDetail(detail);
        setStatus(HttpStatus.BAD_REQUEST);
        setType(URI.create("https://example.com/business-exception"));
        setProperty("timestamp", DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss").format(LocalDateTime.now()));
    }
}
