package com.gruposuperior.calidad.manofactura.controller;

import com.gruposuperior.calidad.manofactura.dto.ResponseDTO;
import com.gruposuperior.calidad.manofactura.service.Saludos;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.resource.NoResourceFoundException;

@RestController
@RequestMapping(value = "/babosa")
public class Prueba {
    @Autowired
    private Saludos saludos;
    @GetMapping(value = "saluda")
    public String saludar(){
        return saludos.hola();
    }

    @GetMapping(value = "demo")
    public ResponseEntity<ResponseDTO<String>> demo(){
        ResponseDTO<String> resultado = new ResponseDTO<>();
        String hola = saludos.hola();
        resultado.setData(hola);
        resultado.setHttpStatus(HttpStatus.OK);
        return new ResponseEntity<>(resultado, HttpStatus.UNAUTHORIZED);
    }

//    @GetMapping(value = "demo")
//    public ResponseEntity<ResponseDTO<String>> demo(){
//        ResponseDTO<String> resultado = new ResponseDTO<>();
//        try {
//
//
//            String hola = saludos.hola();
//
//            resultado.setData(hola);
//            resultado.setHttpStatus(HttpStatus.OK);
//            //throw new NoResourceFoundException(HttpMethod.GET,"");
//        }catch (RuntimeException exception){
//            resultado.setData("Error");
//            resultado.setHttpStatus(HttpStatus.OK);
//        }
//
//        return new ResponseEntity<>(resultado, HttpStatus.UNAUTHORIZED);
//    }
}


