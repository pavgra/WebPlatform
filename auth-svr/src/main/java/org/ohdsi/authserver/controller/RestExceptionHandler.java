package org.ohdsi.authserver.controller;

import lombok.extern.slf4j.Slf4j;
import org.ohdsi.authserver.security.jwt.InvalidJwtAuthenticationException;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;

import static org.springframework.http.HttpStatus.UNAUTHORIZED;
import static org.springframework.http.ResponseEntity.status;

@RestControllerAdvice
@Slf4j
public class RestExceptionHandler {

    // TODO:
    /*@ExceptionHandler(value = AccessDeniedException.class)
    public ResponseEntity accessDenied(AccessDeniedException ex, WebRequest request) {

        log.debug(ex.getMessage());
        return status(UNAUTHORIZED).build();
    }*/

    @ExceptionHandler(value = InvalidJwtAuthenticationException.class)
    public ResponseEntity invalidJwtAuthentication(InvalidJwtAuthenticationException ex, WebRequest request) {

        log.debug(ex.getMessage());
        return status(UNAUTHORIZED).build();
    }
}
