package com.booking.seat_service.exception;

import com.booking.seat_service.exception.SeatNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice
public class GlobalEXceptionHandler {

    @ExceptionHandler(SeatNotFoundException.class)
    public ResponseEntity<Map<String,Object>> handleseatNotFoundException(SeatNotFoundException e)
    {
        Map<String, Object> m = new HashMap<>();
        m.put("Field","User");
        m.put("Status", HttpStatus.NOT_FOUND);
        m.put("message",e.getMessage());
        return new ResponseEntity<>(m,HttpStatus.BAD_REQUEST);
    }
}
