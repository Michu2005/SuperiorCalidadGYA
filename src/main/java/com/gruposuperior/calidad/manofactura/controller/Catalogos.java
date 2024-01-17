package com.gruposuperior.calidad.manofactura.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.gruposuperior.calidad.manofactura.dto.ResponseDTO;
import com.gruposuperior.calidad.manofactura.service.Saludos;

@RestController
@RequestMapping(value = "/catalogos")
public class Catalogos {
    @Autowired
    private Saludos saludos;
    

    @GetMapping(value = "turno")
    public ResponseEntity<ResponseDTO<String>> demo(){
        ResponseDTO<String> resultado = new ResponseDTO<>();
        String hola = "esto es test";
        resultado.setData(hola);
        resultado.setHttpStatus(HttpStatus.OK);
        return new ResponseEntity<>(resultado, HttpStatus.UNAUTHORIZED);
    }

}


