package com.gruposuperior.calidad.manofactura.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.gruposuperior.calidad.manofactura.dto.ResponseDTO;
import com.gruposuperior.calidad.manofactura.dto.ResponsePaginatedDTO;
import com.gruposuperior.calidad.manofactura.dto.response.TurnoDTO;
import com.gruposuperior.calidad.manofactura.entities.Turno;
import com.gruposuperior.calidad.manofactura.service.TurnoService;

import jakarta.validation.constraints.PositiveOrZero;

@RestController
@RequestMapping(value = "/catalogos")
public class Catalogos {
	private static final Logger LOGGER = LoggerFactory.getLogger(Catalogos.class);
	
    @Autowired
    private TurnoService turnoService;
    
    
    @GetMapping(value = "listar/turno")
    public ResponseEntity<ResponsePaginatedDTO<List<TurnoDTO>>> listarTurnos( 
			@PositiveOrZero @RequestParam(value = "page", required = false, defaultValue = "0") Integer page,
			@PositiveOrZero @RequestParam(value = "size", required = false, defaultValue = "10") Integer size){
		LOGGER.info("Consulta catalogo turno");
	
		ResponsePaginatedDTO<List<TurnoDTO>> result = turnoService.listarTurno(page, size);
		return new ResponseEntity<>(result, result.getHttpStatus());
	}
    
    @PostMapping(value = "crear/turno")
    public ResponseEntity<ResponseDTO<Turno>> crearTurno(@Validated @RequestBody TurnoDTO dto, BindingResult errors){
		LOGGER.info("Insertar catalogo turno");
		if(errors.hasErrors()) {
//			throw new PaymentInvalidException();
			LOGGER.error("Crear turno error");
		}
	
		ResponseDTO<Turno> result = turnoService.crearTurno(dto);
		return new ResponseEntity<>(result, result.getHttpStatus());
	}

}


