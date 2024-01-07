package com.gruposuperior.calidad.manofactura.exception.handler;

import com.gruposuperior.calidad.manofactura.dto.ResponseDTO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ApplicationExceptionHandler {
    private static final Logger LOGGER = LoggerFactory.getLogger(ApplicationExceptionHandler.class);
    @ExceptionHandler(value = {RuntimeException.class})
    protected ResponseEntity<ResponseDTO<String>> handleRuntimeException(RuntimeException exception){
        LOGGER.error(exception.getMessage(),exception);
        ResponseDTO<String> resultado = new ResponseDTO<>();
        resultado.setData("Error en tiempo de ejecucion");
        resultado.setHttpStatus(HttpStatus.INTERNAL_SERVER_ERROR);

        return new ResponseEntity<>(resultado, resultado.getHttpStatus());
    }
}
