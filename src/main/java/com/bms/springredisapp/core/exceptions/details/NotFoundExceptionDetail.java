package com.bms.springredisapp.core.exceptions.details;

import org.springframework.http.HttpStatus;
import org.springframework.http.ProblemDetail;

import java.net.URI;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class NotFoundExceptionDetail extends ProblemDetail {
    public NotFoundExceptionDetail(String detail) {
        setTitle("Not Found Exception");
        setDetail(detail);
        setStatus(HttpStatus.NOT_FOUND);
        setType(URI.create("https://example.com/not-found-exception"));
        setProperty("timestamp", DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss").format(LocalDateTime.now()));
    }
}
