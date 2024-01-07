package com.gruposuperior.calidad.manofactura.service.impl;

import com.gruposuperior.calidad.manofactura.entities.Turno;
import com.gruposuperior.calidad.manofactura.repositories.TurnoRepository;
import com.gruposuperior.calidad.manofactura.service.Saludos;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class SaludosImpl implements Saludos {
    @Autowired
    private TurnoRepository turnoRepository;
    @Override
    public String hola() throws RuntimeException {
        Optional<Turno> optionalTurno = turnoRepository.findById(1);
        if(optionalTurno.isPresent()) {
            System.out.println(optionalTurno.get().getDescripcion());
            throw new RuntimeException("Message from etc");
        }

        return "Hola tu babosa" + turnoRepository.count();
    }
}
