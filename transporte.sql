-- Database name: transporte
-- Schema: schtransporte
ALTER USER "postgres" SET search_path = "schtransporte";
CREATE TABLE schtransporte.socios 
(
	id SERIAL,
	codigo VARCHAR NOT NULL,
	nombre VARCHAR NOT NULL,
	apellidos VARCHAR NOT NULL,
	linea VARCHAR,
	numero_bus VARCHAR NOT NULL PRIMARY KEY,
	capacidad_bus INTEGER,
	ayudante VARCHAR,
	chofer VARCHAR,
	estado BOOLEAN
)

CREATE TABLE schtransporte.horarios
(
	id SERIAL,
	codigo VARCHAR NOT NULL PRIMARY KEY,
	numero_bus VARCHAR NOT NULL,
	descripcion_horario VARCHAR,
	tiempo_salida TIME WITHOUT TIME ZONE NOT NULL,
	tiempo_llegada TIME WITHOUT TIME ZONE NOT NULL,
	estado BOOLEAN
)
ALTER TABLE schtransporte.horarios ADD CONSTRAINT FK_NUMERO_BUS_HORARIOS_SOCIOS FOREIGN KEY (numero_bus) REFERENCES schtransporte.socios (numero_bus);

CREATE TABLE schtransporte.recorridos
(
	id SERIAL,
	codigo VARCHAR NOT NULL PRIMARY KEY,
	numero_bus VARCHAR NOT NULL,
	descripcion_recorrido VARCHAR,
	tiempo_demora TIME WITHOUT TIME ZONE NOT NULL,
	zona_recorrido VARCHAR,
	cantidad_recorrido INTEGER,
	estado BOOLEAN
)
ALTER TABLE schtransporte.recorridos ADD CONSTRAINT FK_NUMERO_BUS_RECORRIDOS_SOCIOS FOREIGN KEY (numero_bus) REFERENCES schtransporte.socios (numero_bus);




	
	
	
