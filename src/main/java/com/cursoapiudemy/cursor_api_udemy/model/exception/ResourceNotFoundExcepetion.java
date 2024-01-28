package com.cursoapiudemy.cursor_api_udemy.model.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.NOT_FOUND)
public class ResourceNotFoundExcepetion extends RuntimeException {

    public ResourceNotFoundExcepetion(String mensagem) {
        // recebe o erro e manda para o runtimeException
        super(mensagem);
    }
}
