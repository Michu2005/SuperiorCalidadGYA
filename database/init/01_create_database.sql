USE master;
GO

-- DROP DATABASE IF EXISTS dbcalidad;
CREATE DATABASE dbcalidad;
-- ddl-end --

USE dbcalidad;
GO

-- DROP SCHEMA dbo;

-- CREATE SCHEMA dbo;
-- dbcalidad.dbo.empleado definition

-- Drop table

-- DROP TABLE dbcalidad.dbo.empleado;

CREATE TABLE dbcalidad.dbo.empleado (
	id int NOT NULL IDENTITY(1,1),
	codigo varchar(10),
	nombre varchar(255),
	borrado date NULL,
	creado date DEFAULT GETDATE(),
	activo bit DEFAULT 1,
	CONSTRAINT empleado_pk PRIMARY KEY (id)
);


-- dbcalidad.dbo.linea definition

-- Drop table

-- DROP TABLE dbcalidad.dbo.linea;

CREATE TABLE dbcalidad.dbo.linea (
	id int NOT NULL IDENTITY(1,1),
	descripcion varchar(255),
	borrado date NULL,
	creado date DEFAULT GETDATE(),
	activo bit DEFAULT 1,
	CONSTRAINT linea_pk PRIMARY KEY (id)
);


-- dbcalidad.dbo.maquina definition

-- Drop table

-- DROP TABLE dbcalidad.dbo.maquina;

CREATE TABLE dbcalidad.dbo.maquina (
	id int NOT NULL IDENTITY(1,1),
	descripcion varchar(255),
	borrado date NULL,
	creado date DEFAULT GETDATE(),
	activo bit DEFAULT 1,
	CONSTRAINT maquina_pk PRIMARY KEY (id)
);


-- dbcalidad.dbo.perfil definition

-- Drop table

-- DROP TABLE dbcalidad.dbo.perfil;

CREATE TABLE dbcalidad.dbo.perfil (
	id int NOT NULL IDENTITY(1,1),
	descripcion varchar(255),
	borrado date NULL,
	creado date DEFAULT GETDATE(),
	activo bit DEFAULT 1,
	CONSTRAINT perfil_pk PRIMARY KEY (id)
);


-- dbcalidad.dbo.producto definition

-- Drop table

-- DROP TABLE dbcalidad.dbo.producto;

CREATE TABLE dbcalidad.dbo.producto (
	id int NOT NULL IDENTITY(1,1),
	descripcion varchar(255),
	codigo varchar(10),
	borrado date NULL,
	creado date DEFAULT GETDATE(),
	activo bit DEFAULT 1,
	CONSTRAINT producto_pk PRIMARY KEY (id)
);

-- DROP TABLE dbcalidad.dbo.proceso;

CREATE TABLE dbcalidad.dbo.proceso (
	id int NOT NULL IDENTITY(1,1),
	descripcion character varying(255),
	borrado date NULL,
	creado date DEFAULT GETDATE(),
	activo bit DEFAULT 1,
	CONSTRAINT proceso_pk PRIMARY KEY (id)
);


-- dbcalidad.dbo.tipo_parametro definition

-- Drop table

-- DROP TABLE dbcalidad.dbo.tipo_parametro;

CREATE TABLE dbcalidad.dbo.tipo_parametro (
	id int NOT NULL IDENTITY(1,1),
	tipo varchar(255),
	borrado date NULL,
	creado date DEFAULT GETDATE(),
	activo bit DEFAULT 1,
	CONSTRAINT tipo_parametro_pk PRIMARY KEY (id)
);


-- dbcalidad.dbo.turno definition

-- Drop table

-- DROP TABLE dbcalidad.dbo.turno;

CREATE TABLE dbcalidad.dbo.turno (
	id int NOT NULL IDENTITY(1,1),
	descripcion varchar(255),
	borrado date NULL,
	creado date DEFAULT GETDATE(),
	activo bit DEFAULT 1,
	CONSTRAINT turno_pk PRIMARY KEY (id)
);


-- dbcalidad.dbo.parametro definition

-- Drop table

-- DROP TABLE dbcalidad.dbo.parametro;

CREATE TABLE dbcalidad.dbo.parametro (
	id int NOT NULL IDENTITY(1,1),
	id_tipo_parametro int NULL,
	id_proceso int NULL,
	descripcion varchar(255),
	min numeric(10,2) NULL,
	max numeric(10,2) NULL,
	unidad_medida varchar(20),
	borrado date NULL,
	creado date DEFAULT GETDATE(),
	activo bit DEFAULT 1,
	valor_unico bit NULL,
	CONSTRAINT categoria_producto_pk PRIMARY KEY (id),
	CONSTRAINT tipo_parametro_fk FOREIGN KEY (id_tipo_parametro) REFERENCES dbcalidad.dbo.tipo_parametro(id) ON DELETE SET NULL ON UPDATE CASCADE,
	CONSTRAINT proceso_fk FOREIGN KEY (id_proceso) REFERENCES dbcalidad.dbo.proceso(id) ON DELETE SET NULL ON UPDATE CASCADE
);


-- dbcalidad.dbo.perfil_empleado definition

-- Drop table

-- DROP TABLE dbcalidad.dbo.perfil_empleado;

CREATE TABLE dbcalidad.dbo.perfil_empleado (
	id int NOT NULL IDENTITY(1,1),
	id_perfil int NULL,
	id_empleado int NULL,
	borrado date NULL,
	creado date DEFAULT GETDATE(),
	activo bit DEFAULT 1,
	CONSTRAINT perfil_empleado_pk PRIMARY KEY (id),
	CONSTRAINT empleado_fk FOREIGN KEY (id_empleado) REFERENCES dbcalidad.dbo.empleado(id) ON DELETE SET NULL ON UPDATE CASCADE,
	CONSTRAINT perfil_fk FOREIGN KEY (id_perfil) REFERENCES dbcalidad.dbo.perfil(id) ON DELETE SET NULL ON UPDATE CASCADE
);


-- dbcalidad.dbo.producto_parametro definition

-- Drop table

-- DROP TABLE dbcalidad.dbo.producto_parametro;

CREATE TABLE dbcalidad.dbo.producto_parametro (
	id int NOT NULL IDENTITY(1,1),
	id_producto int NULL,
	id_parametro int NULL,
	borrado date NULL,
	creado date DEFAULT GETDATE(),
	activo bit DEFAULT 1,
	CONSTRAINT producto_cat_producto_pk PRIMARY KEY (id),
	CONSTRAINT parametro_fk FOREIGN KEY (id_parametro) REFERENCES dbcalidad.dbo.parametro(id) ON DELETE SET NULL ON UPDATE CASCADE,
	CONSTRAINT producto2_fk FOREIGN KEY (id_producto) REFERENCES dbcalidad.dbo.producto(id) ON DELETE SET NULL ON UPDATE CASCADE
);


-- dbcalidad.dbo.control_empaque_cabecera definition

-- Drop table

-- DROP TABLE dbcalidad.dbo.control_empaque_cabecera;

CREATE TABLE dbcalidad.dbo.control_empaque_cabecera (
	id int NOT NULL IDENTITY(1,1),
	id_turno int NULL,
	id_linea int NULL,
	id_maquina int NULL,
	id_producto int NULL,
	id_perfil_empleado int NULL,
	borrado date NULL,
	creado date DEFAULT GETDATE(),
	activo bit DEFAULT 1,
	id_supervisor int NULL,
	CONSTRAINT empaque_pk PRIMARY KEY (id),
	CONSTRAINT linea_fk FOREIGN KEY (id_linea) REFERENCES dbcalidad.dbo.linea(id) ON DELETE SET NULL ON UPDATE CASCADE,
	CONSTRAINT maquina_fk FOREIGN KEY (id_maquina) REFERENCES dbcalidad.dbo.maquina(id) ON DELETE SET NULL ON UPDATE CASCADE,
	CONSTRAINT perfil_empleado_fk FOREIGN KEY (id_perfil_empleado) REFERENCES dbcalidad.dbo.perfil_empleado(id) ON DELETE SET NULL ON UPDATE CASCADE,
	CONSTRAINT producto1_fk FOREIGN KEY (id_producto) REFERENCES dbcalidad.dbo.producto(id) ON DELETE SET NULL ON UPDATE CASCADE,
	CONSTRAINT turno_fk FOREIGN KEY (id_turno) REFERENCES dbcalidad.dbo.turno(id) ON DELETE SET NULL ON UPDATE CASCADE
);


-- dbcalidad.dbo.control_empaque_detalle definition

-- Drop table

-- DROP TABLE dbcalidad.dbo.control_empaque_detalle;

CREATE TABLE dbcalidad.dbo.control_empaque_detalle (
	id int NOT NULL IDENTITY(1,1),
	id_control_empaque_cabecera int NULL,
	borrado date NULL,
	creado date DEFAULT GETDATE(),
	activo bit DEFAULT 1,
	id_parametro int NULL,
	numero_registro smallint NULL,
	valor numeric(10,2) NULL,
	CONSTRAINT control_empaque_detalle_pk PRIMARY KEY (id),
	CONSTRAINT control_empaque_cabecera_fk FOREIGN KEY (id_control_empaque_cabecera) REFERENCES dbcalidad.dbo.control_empaque_cabecera(id) ON DELETE SET NULL ON UPDATE CASCADE,
	CONSTRAINT parametro1_fk FOREIGN KEY (id_parametro) REFERENCES dbcalidad.dbo.parametro(id)
);


-- dbcalidad.dbo.control_producto_cabecera definition

-- Drop table

-- DROP TABLE dbcalidad.dbo.control_producto_cabecera;

CREATE TABLE dbcalidad.dbo.control_producto_cabecera (
	id int NOT NULL IDENTITY(1,1),
	id_maquina int NULL,
	id_linea int NULL,
	id_turno int NULL,
	id_perfil_empleado int NULL,
	id_producto int NULL,
	borrado date NULL,
	creado date DEFAULT GETDATE(),
	activo bit DEFAULT 1,
	id_supervisor int NULL,
	CONSTRAINT control_producto_pk PRIMARY KEY (id),
	CONSTRAINT linea1_fk FOREIGN KEY (id_linea) REFERENCES dbcalidad.dbo.linea(id) ON DELETE SET NULL ON UPDATE CASCADE,
	CONSTRAINT maquina1_fk FOREIGN KEY (id_maquina) REFERENCES dbcalidad.dbo.maquina(id) ON DELETE SET NULL ON UPDATE CASCADE,
	CONSTRAINT perfil_empleado1_fk FOREIGN KEY (id_perfil_empleado) REFERENCES dbcalidad.dbo.perfil_empleado(id) ON DELETE SET NULL ON UPDATE CASCADE,
	CONSTRAINT producto_fk FOREIGN KEY (id_producto) REFERENCES dbcalidad.dbo.producto(id) ON DELETE SET NULL ON UPDATE CASCADE,
	CONSTRAINT turno1_fk FOREIGN KEY (id_turno) REFERENCES dbcalidad.dbo.turno(id) ON DELETE SET NULL ON UPDATE CASCADE
);


-- dbcalidad.dbo.control_producto_detalle definition

-- Drop table

-- DROP TABLE dbcalidad.dbo.control_producto_detalle;

CREATE TABLE dbcalidad.dbo.control_producto_detalle (
	id int NOT NULL IDENTITY(1,1),
	id_control_producto_cabecera int NULL,
	id_producto_parametro int NULL,
	borrado date NULL,
	creado date DEFAULT GETDATE(),
	activo bit DEFAULT 1,
	numero_registro smallint NULL,
	valor numeric(10,2) NULL,
	CONSTRAINT control_producto_detalle_pk PRIMARY KEY (id),
	CONSTRAINT control_producto_cabecera_fk FOREIGN KEY (id_control_producto_cabecera) REFERENCES dbcalidad.dbo.control_producto_cabecera(id) ON DELETE SET NULL ON UPDATE CASCADE,
	CONSTRAINT producto_parametro_fk FOREIGN KEY (id_producto_parametro) REFERENCES dbcalidad.dbo.producto_parametro(id)
);
