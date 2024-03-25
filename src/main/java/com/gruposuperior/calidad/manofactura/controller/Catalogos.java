package com.gruposuperior.calidad.manofactura.controller;

import java.util.List;

import com.gruposuperior.calidad.manofactura.dto.response.*;
import com.gruposuperior.calidad.manofactura.entities.*;
import com.gruposuperior.calidad.manofactura.service.*;
import com.gruposuperior.calidad.manofactura.service.ProductoParametroService;
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
import com.gruposuperior.calidad.manofactura.dto.response.EmpleadoDTO;
import com.gruposuperior.calidad.manofactura.dto.response.LineaDTO;
import com.gruposuperior.calidad.manofactura.dto.response.MaquinaDTO;
import com.gruposuperior.calidad.manofactura.dto.response.ParametroDTO;
import com.gruposuperior.calidad.manofactura.dto.response.PerfilDTO;
import com.gruposuperior.calidad.manofactura.dto.response.ProcesoDTO;
import com.gruposuperior.calidad.manofactura.dto.response.ProductoDTO;
import com.gruposuperior.calidad.manofactura.dto.response.TurnoDTO;
import com.gruposuperior.calidad.manofactura.entities.Empleado;
import com.gruposuperior.calidad.manofactura.entities.Linea;
import com.gruposuperior.calidad.manofactura.entities.Maquina;
import com.gruposuperior.calidad.manofactura.entities.Parametro;
import com.gruposuperior.calidad.manofactura.entities.Perfil;
import com.gruposuperior.calidad.manofactura.entities.Proceso;
import com.gruposuperior.calidad.manofactura.entities.Producto;
import com.gruposuperior.calidad.manofactura.entities.Turno;
import com.gruposuperior.calidad.manofactura.service.EmpleadoService;
import com.gruposuperior.calidad.manofactura.service.LineaService;
import com.gruposuperior.calidad.manofactura.service.MaquinaService;
import com.gruposuperior.calidad.manofactura.service.ParametroService;
import com.gruposuperior.calidad.manofactura.service.PerfilService;
import com.gruposuperior.calidad.manofactura.service.ProcesoService;
import com.gruposuperior.calidad.manofactura.service.ProductoService;
import com.gruposuperior.calidad.manofactura.service.TurnoService;

import jakarta.validation.constraints.PositiveOrZero;

@RestController
@RequestMapping(value = "/catalogos")
public class Catalogos {
	private static final Logger LOGGER = LoggerFactory.getLogger(Catalogos.class);
	
    @Autowired
    private TurnoService turnoService;

	@Autowired
	private GuardadoProcesoService guardadoProcesoService;

	@Autowired
	private GuardadoEmpaqueService guardadoEmpaqueService;
    
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

	//Listar y crear línea
	@Autowired
	private LineaService lineaService;


	@GetMapping(value = "listar/linea")
	public ResponseEntity<ResponsePaginatedDTO<List<LineaDTO>>> listarLinea(
			@PositiveOrZero @RequestParam(value = "page", required = false, defaultValue = "0") Integer page,
			@PositiveOrZero @RequestParam(value = "size", required = false, defaultValue = "10") Integer size){
		LOGGER.info("Consulta catalogo linea");
	
		ResponsePaginatedDTO<List<LineaDTO>> result = lineaService.listarLinea(page, size);
		return new ResponseEntity<>(result, result.getHttpStatus());
	}
	@PostMapping(value = "crear/linea")
	public ResponseEntity<ResponseDTO<Linea>> crearLinea(@Validated @RequestBody LineaDTO dto, BindingResult errors){
		LOGGER.info("Insertar catalogo linea");
		if(errors.hasErrors()) {
//			throw new PaymentInvalidException();
			LOGGER.error("Crear linea error");
		}
	
		ResponseDTO<Linea> result = lineaService.crearLinea(dto);
		return new ResponseEntity<>(result, result.getHttpStatus());
	}

	//Listar y crear máquina
	@Autowired
	private MaquinaService maquinaService;


	@GetMapping(value = "listar/maquina")
	public ResponseEntity<ResponsePaginatedDTO<List<MaquinaDTO>>> listarMaquina(){
		LOGGER.info("Consulta catalogo maquina");

		ResponsePaginatedDTO<List<MaquinaDTO>> result = maquinaService.listarMaquina();
		return new ResponseEntity<>(result, result.getHttpStatus());
	}

	@PostMapping(value = "crear/maquina")
	public ResponseEntity<ResponseDTO<Maquina>> crearMaquina(@Validated @RequestBody MaquinaDTO dto, BindingResult errors){
		LOGGER.info("Insertar catalogo maquina");
		if(errors.hasErrors()) {
//			throw new PaymentInvalidException();
			LOGGER.error("Crear maquina error");
		}
	
		ResponseDTO<Maquina> result = maquinaService.crearMaquina(dto);
		return new ResponseEntity<>(result, result.getHttpStatus());
	}

	//Listar y crear perfil
	@Autowired
	private PerfilService perfilService;


	@GetMapping(value = "listar/perfil")
	public ResponseEntity<ResponsePaginatedDTO<List<PerfilDTO>>> listarPerfil(
			@PositiveOrZero @RequestParam(value = "page", required = false, defaultValue = "0") Integer page,
			@PositiveOrZero @RequestParam(value = "size", required = false, defaultValue = "10") Integer size){
		LOGGER.info("Consulta catalogo perfil");

		ResponsePaginatedDTO<List<PerfilDTO>> result = perfilService.listarPerfil(page, size);
		return new ResponseEntity<>(result, result.getHttpStatus());
	}

	@PostMapping(value = "crear/perfil")
	public ResponseEntity<ResponseDTO<Perfil>> crearPerfil(@Validated @RequestBody PerfilDTO dto, BindingResult errors){
		LOGGER.info("Insertar catalogo perfil");
		if(errors.hasErrors()) {
//			throw new PaymentInvalidException();
			LOGGER.error("Crear perfil error");
		}
	
		ResponseDTO<Perfil> result = perfilService.crearPerfil(dto);
		return new ResponseEntity<>(result, result.getHttpStatus());
	}

	//Listar y crear empleado
	@Autowired
	private EmpleadoService empleadoService;


	@GetMapping(value = "listar/empleado")
	public ResponseEntity<ResponsePaginatedDTO<List<EmpleadoDTO>>> listarEmpleado(
			@PositiveOrZero @RequestParam(value = "page", required = false, defaultValue = "0") Integer page,
			@PositiveOrZero @RequestParam(value = "size", required = false, defaultValue = "10") Integer size){
		LOGGER.info("Consulta catalogo empleado");
	
		ResponsePaginatedDTO<List<EmpleadoDTO>> result = empleadoService.listarEmpleado(page, size);
		return new ResponseEntity<>(result, result.getHttpStatus());
	}

	@PostMapping(value = "crear/empleado")
	public ResponseEntity<ResponseDTO<Empleado>> crearEmpleado(@Validated @RequestBody EmpleadoDTO dto, BindingResult errors){
		LOGGER.info("Insertar catalogo empleado");
		if(errors.hasErrors()) {
//			throw new PaymentInvalidException();
			LOGGER.error("Crear empleado error");
		}
	
		ResponseDTO<Empleado> result = empleadoService.crearEmpleado(dto);
		return new ResponseEntity<>(result, result.getHttpStatus());
	}

	//Listar y crear producto
	@Autowired
	private ProductoService productoService;


	@GetMapping(value = "listar/producto")
	public ResponseEntity<ResponsePaginatedDTO<List<ProductoDTO>>> listarProducto(){
		LOGGER.info("Consulta catalogo producto");
	
		ResponsePaginatedDTO<List<ProductoDTO>> result = productoService.listarProducto();
		return new ResponseEntity<>(result, result.getHttpStatus());
	}

	@PostMapping(value = "crear/producto")
	public ResponseEntity<ResponseDTO<Producto>> crearProducto(@Validated @RequestBody ProductoDTO dto, BindingResult errors){
		LOGGER.info("Insertar catalogo producto");
		if(errors.hasErrors()) {
//			throw new PaymentInvalidException();
			LOGGER.error("Crear producto error");
		}
	
		ResponseDTO<Producto> result = productoService.crearProducto(dto);
		return new ResponseEntity<>(result, result.getHttpStatus());
	}

	//Listar y crear proceso
	@Autowired
	private ProcesoService procesoService;


	@GetMapping(value = "listar/proceso")
	public ResponseEntity<ResponsePaginatedDTO<List<ProcesoDTO>>> listarProceso(
			@PositiveOrZero @RequestParam(value = "page", required = false, defaultValue = "0") Integer page,
			@PositiveOrZero @RequestParam(value = "size", required = false, defaultValue = "10") Integer size){
		LOGGER.info("Consulta catalogo proceso");
	
		ResponsePaginatedDTO<List<ProcesoDTO>> result = procesoService.listarProceso(page, size);
		return new ResponseEntity<>(result, result.getHttpStatus());
	}

	@PostMapping(value = "crear/proceso")
	public ResponseEntity<ResponseDTO<Proceso>> crearProceso(@Validated @RequestBody ProcesoDTO dto, BindingResult errors){
		LOGGER.info("Insertar catalogo proceso");
		if(errors.hasErrors()) {
//			throw new PaymentInvalidException();
			LOGGER.error("Crear proceso error");
		}
	
		ResponseDTO<Proceso> result = procesoService.crearProceso(dto);
		return new ResponseEntity<>(result, result.getHttpStatus());
	}

	//Listar y crear parametros
	@Autowired
	private ParametroService parametroService;


	@GetMapping(value = "listar/parametro")
	public ResponseEntity<ResponsePaginatedDTO<List<ParametroDTO>>> listarParametro(){
		LOGGER.info("Consulta catalogo parametro");
	
		ResponsePaginatedDTO<List<ParametroDTO>> result = parametroService.listarParametro();
		return new ResponseEntity<>(result, result.getHttpStatus());
	}

	@PostMapping(value = "crear/parametro")
	public ResponseEntity<ResponseDTO<Parametro>> crearParametro(@Validated @RequestBody ParametroDTO dto, BindingResult errors){
		LOGGER.info("Insertar catalogo parametro");
		if(errors.hasErrors()) {
//			throw new PaymentInvalidException();
			LOGGER.error("Crear parametro error");
		}
	
		ResponseDTO<Parametro> result = parametroService.crearParametro(dto);
		return new ResponseEntity<>(result, result.getHttpStatus());
	}

	//Listar y crear tipo parametros
	@Autowired
	private TipoParametroService tipoParametroService;


	@GetMapping(value = "listar/tipoParametro")
	public ResponseEntity<ResponsePaginatedDTO<List<TipoParametroDTO>>> listarTipoParametro(
			@PositiveOrZero @RequestParam(value = "page", required = false, defaultValue = "0") Integer page,
			@PositiveOrZero @RequestParam(value = "size", required = false, defaultValue = "10") Integer size){
		LOGGER.info("Consulta catalogo tipo parametro");

		ResponsePaginatedDTO<List<TipoParametroDTO>> result = tipoParametroService.listarTipoParametro(page, size);
		return new ResponseEntity<>(result, result.getHttpStatus());
	}

	@PostMapping(value = "crear/tipoParametro")
	public ResponseEntity<ResponseDTO<TipoParametro>> crearTipoParametro(@Validated @RequestBody TipoParametroDTO dto, BindingResult errors){
		LOGGER.info("Insertar catalogo tipo parametro");
		if(errors.hasErrors()) {
//			throw new PaymentInvalidException();
			LOGGER.error("Crear tipo parametro error");
		}

		ResponseDTO<TipoParametro> result = tipoParametroService.crearTipoParametro(dto);
		return new ResponseEntity<>(result, result.getHttpStatus());
	}

	//Listar y crear perfil empleado
	@Autowired
	private PerfilEmpleadoService perfilEmpleadoService;

	@GetMapping(value = "listar/perfilEmpleado")
	public ResponseEntity<ResponsePaginatedDTO<List<PerfilEmpleadoDTO>>> listarPerfilEmpleado(
			@PositiveOrZero @RequestParam(value = "page", required = false, defaultValue = "0") Integer page,
			@PositiveOrZero @RequestParam(value = "size", required = false, defaultValue = "10") Integer size){
		LOGGER.info("Consulta catalogo perfil empleado");

		ResponsePaginatedDTO<List<PerfilEmpleadoDTO>> result = perfilEmpleadoService.listarPerfilEmpleado(page, size);
		return new ResponseEntity<>(result, result.getHttpStatus());
	}

	@GetMapping(value = "listar/sac")
	public ResponseEntity<List<EmpleadoDTO>> listarSac(
			@PositiveOrZero @RequestParam(value = "idPerfil") Integer idPerfil){
		List<EmpleadoDTO> result = empleadoService.listarSac(idPerfil);
		return ResponseEntity.ok(result);
	}

	@GetMapping(value = "listar/aac")
	public ResponseEntity<List<EmpleadoDTO>> listarAac(
			@PositiveOrZero @RequestParam(value = "idPerfil") Integer idPerfil){
		List<EmpleadoDTO> result = empleadoService.listarAac(idPerfil);
		return ResponseEntity.ok(result);
	}

	@PostMapping(value = "crear/perfilEmpleado")
	public ResponseEntity<ResponseDTO<PerfilEmpleado>> crearPerfilEmpleado(@Validated @RequestBody PerfilEmpleadoDTO dto, BindingResult errors) {
		LOGGER.info("Insertar catalogo perfil empleado");
		if (errors.hasErrors()) {
//			throw new PaymentInvalidException();
			LOGGER.error("Crear perfil empleado error");
		}

		ResponseDTO<PerfilEmpleado> result = perfilEmpleadoService.crearPerfilEmpleado(dto);
		return new ResponseEntity<>(result, result.getHttpStatus());
	}

	//Listar y crear tipo Producto Parametro
	@Autowired
	private ProductoParametroService productoParametroService;


	@GetMapping(value = "listar/productoParametro")
	public ResponseEntity<ResponsePaginatedDTO<List<ProductoParametroDTO>>> listarProductoParametro(
			@PositiveOrZero @RequestParam(value = "page", required = false, defaultValue = "0") Integer page,
			@PositiveOrZero @RequestParam(value = "size", required = false, defaultValue = "10") Integer size){
		LOGGER.info("Consulta catalogo producto parametro");

		ResponsePaginatedDTO<List<ProductoParametroDTO>> result = productoParametroService.listarProductoParametro(page, size);
		return new ResponseEntity<>(result, result.getHttpStatus());
	}

	@PostMapping(value = "crear/productoParametro")
	public ResponseEntity<ResponseDTO<ProductoParametro>> crearProductoParametro(@Validated @RequestBody ProductoParametroDTO dto, BindingResult errors){
		LOGGER.info("Insertar catalogo producto parametro");
		if(errors.hasErrors()) {
//			throw new PaymentInvalidException();
			LOGGER.error("Crear producto parametro error");
		}

		ResponseDTO<ProductoParametro> result = productoParametroService.crearProductoParametro(dto);
		return new ResponseEntity<>(result, result.getHttpStatus());
	}

	@GetMapping(value = "listar/parametrosPorProductoYTipoParametro")
	public ResponseEntity<List<ParametroDTO>> obtenerParametrosPorIdProductoYTipoParametroId(
			@PositiveOrZero @RequestParam(value = "idProducto") Integer idProducto,
			@PositiveOrZero @RequestParam(value = "idTipoParametro") Integer idTipoParametro){
		List<ParametroDTO> result = parametroService.obtenerParametrosPorIdProductoYTipo(idProducto, idTipoParametro);
		return ResponseEntity.ok(result);
	}

	@GetMapping("obtenerIdPorCodigoEmpleado")
	public ResponseEntity<Integer> obtenerIdPorCodigoEmpleado(@RequestParam(value = "codigoEmpleado") String codigoEmpleado){
		return ResponseEntity.ok(empleadoService.getIdEmpleado(codigoEmpleado));
	}

	@PostMapping("registrarProceso")
	public ResponseEntity<Boolean> registrarProceso(@RequestBody CabeceraProcesoDTO data){
		System.out.println("Data controller: " + data);
		return ResponseEntity.ok(guardadoProcesoService.registroRespuesta(data));
	}

	@PostMapping("registrarEmpaque")
	public ResponseEntity<Boolean> registrarEmpaque(@RequestBody CabeceraEmpaqueDTO data){
		System.out.println("Data controller: " + data);
		return ResponseEntity.ok(guardadoEmpaqueService.registroRespuesta(data));
	}
}


