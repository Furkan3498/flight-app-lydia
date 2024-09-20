package com.lydiatechnology.flightticket.exception.handler;



import com.lydiatechnology.flightticket.exception.ApiException;
import lombok.Builder;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.ErrorResponse;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
@Slf4j
@Builder
public class GlobalExceptionHandler {
   /* @ExceptionHandler(ApiException.class)
    public ResponseEntity<ErrorResponse> handleNotFoundException(ApiException exception){
        log.error("Exception is occurred. Exception:{}",exception.getMessage());
        ErrorResponse errorResponse= ErrorResponse.builder()
                .message(exception.getMessage())
                .exceptionType(exception.getClass().getSimpleName())
                .build();
        return ResponseEntity.status(exception.getHttpStatus()).body(errorResponse);
    }*/
}
