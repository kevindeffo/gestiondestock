package com.desktech.gestiondestock.handlers;

//import jakarta.persistence.EntityNotFoundException;
import com.desktech.gestiondestock.exception.EntityNotFoundException;
import com.desktech.gestiondestock.exception.InvalidEntityException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@RestControllerAdvice
public class RestExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(EntityNotFoundException.class)
    public ResponseEntity<ErrorDto> handleException(EntityNotFoundException exception, WebRequest webRequest){
        final HttpStatus notFound = HttpStatus.NOT_FOUND;

        final ErrorDto errorDto =  ErrorDto.builder()
                .message(exception.getMessage())
                .httpCode(notFound.value())
                .code(exception.getErrorCodes())
                .build();

        return new ResponseEntity<>(errorDto, notFound);
    }

    @ExceptionHandler(InvalidEntityException.class)
    public ResponseEntity<ErrorDto> handleException(InvalidEntityException exception, WebRequest webRequest){
        final HttpStatus badRequest = HttpStatus.BAD_REQUEST;

        final ErrorDto errorDto =  ErrorDto.builder()
                .message(exception.getMessage())
                .httpCode(badRequest.value())
                .code(exception.getErrorCodes())
                .errors(exception.getErrors())
                .build();

        return new ResponseEntity<>(errorDto, badRequest);
    }
}
