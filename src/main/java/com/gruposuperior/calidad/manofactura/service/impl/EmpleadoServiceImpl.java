package com.gruposuperior.calidad.manofactura.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import com.gruposuperior.calidad.manofactura.entities.PerfilEmpleado;
import com.gruposuperior.calidad.manofactura.repositories.PerfilEmpleadoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.gruposuperior.calidad.manofactura.dto.ResponseDTO;
import com.gruposuperior.calidad.manofactura.dto.ResponsePaginatedDTO;
import com.gruposuperior.calidad.manofactura.dto.response.EmpleadoDTO;
import com.gruposuperior.calidad.manofactura.entities.Empleado;
import com.gruposuperior.calidad.manofactura.repositories.EmpleadoRepository;
import com.gruposuperior.calidad.manofactura.service.EmpleadoService;

@Service
public class EmpleadoServiceImpl implements EmpleadoService{
	
	@Autowired
	private EmpleadoRepository empleadoRepository;
	@Autowired
	private PerfilEmpleadoRepository perfilEmpleadoRepository;

	@Override
	public ResponsePaginatedDTO<List<EmpleadoDTO>> listarEmpleado(int pageNumber, int pageSize) {
		// Define el tipo de resultado a retornar		
		ResponsePaginatedDTO<List<EmpleadoDTO>> result = new ResponsePaginatedDTO<List<EmpleadoDTO>>();
		// Consulta al repositorio con paginacion
		Sort sort = Sort.by( Sort.Order.desc("id") );
		Pageable pagination = PageRequest.of(pageNumber, pageSize, sort);
		Page<Empleado> pageEmpleado = empleadoRepository.findAll(pagination);
		
		// Setea el resultado de la consulta en la respuesta
		result.setData(pageEmpleado.getContent().stream().map(empleado -> {
			return new EmpleadoDTO(empleado.getCodigo(), empleado.getNombre());
		}).collect(Collectors.toList()));
		
		result.setCurrentPage(pageEmpleado.getNumber());
		result.setTotalElements(pageEmpleado.getTotalElements());
		result.setTotalPages(pageEmpleado.getTotalPages());
		result.setHttpStatus(HttpStatus.OK);
		
		return result;
	}

	@Override
	public ResponseDTO<Empleado> crearEmpleado(EmpleadoDTO empleadoDTO) {
		ResponseDTO<Empleado> result = new ResponseDTO<Empleado>();
		Empleado empleado = new Empleado();
//		empleado.setDescripcion(empleadoDTO.getDescripcion());
		empleado.setActivo(true);
		empleado.setCreado(new Date());
		empleadoRepository.save(empleado);
		
		result.setData(empleado);
		result.setHttpStatus(HttpStatus.OK);
		return result;
	}

	@Override
	public List<EmpleadoDTO> listarSac(int idPerfil) {
		List<EmpleadoDTO> result = new ArrayList<>();
		List<PerfilEmpleado> listaPerfilempleado = perfilEmpleadoRepository.findByIdPerfil(idPerfil);
		if(listaPerfilempleado.isEmpty()) throw new RuntimeException("No se encontro registros");
		List<Empleado> listaEmpleado = new ArrayList<>();
		for (PerfilEmpleado perfilEmpleado : listaPerfilempleado){
			Optional<Empleado> empleado = empleadoRepository.findById(perfilEmpleado.getIdEmpleado());
			if (empleado.isPresent()){
				listaEmpleado.add(empleado.get());
			}
		}
		return listaEmpleadoAListaEmpleadoDTO(listaEmpleado);
	}

	private EmpleadoDTO trasnformaEmpleadoAEmpleadoDTO(Empleado empleado){
		EmpleadoDTO empleadoDTO = new EmpleadoDTO(empleado.getCodigo(), empleado.getNombre());
		return empleadoDTO;
	}

	private List<EmpleadoDTO> listaEmpleadoAListaEmpleadoDTO(List<Empleado> listaEmpleados){
		List<EmpleadoDTO> result = new ArrayList<>();
		for (Empleado empleado : listaEmpleados){
			result.add(trasnformaEmpleadoAEmpleadoDTO(empleado));
		}
		return result;
	}
}
