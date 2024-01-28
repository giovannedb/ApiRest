package com.cursoapiudemy.cursor_api_udemy.handler;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.cursoapiudemy.cursor_api_udemy.model.Error.ErrorMensage;
import com.cursoapiudemy.cursor_api_udemy.model.exception.ResourceNotFoundExcepetion;

//controle manipulação de eventos dentro da nosso aplicação
@ControllerAdvice
public class RestExceptionHandler {

    // retorna response de qualquer coisa ?
    // Esse metodo ouve as exeption
    // Toda vez que acontecer esse erro (ResourceNotFoundExcepetion) ele retorna
    // essa classe
    @ExceptionHandler(ResourceNotFoundExcepetion.class)
    public ResponseEntity<?> handleResourceNotFoundException(ResourceNotFoundExcepetion ex) {

        ErrorMensage error = new ErrorMensage("Not Found", HttpStatus.NOT_FOUND.value(), ex.getMessage());
        return new ResponseEntity<>(error, HttpStatus.NOT_FOUND);

    }
}
