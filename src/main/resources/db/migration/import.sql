
-- Tabla Persona
CREATE TABLE personas (
  id BIGINT AUTO_INCREMENT PRIMARY KEY,
  nombre VARCHAR(255) NOT NULL,
  apellido VARCHAR(255) NOT NULL,
  edad INT NOT NULL,
  tipoDocumento VARCHAR(255) NOT NULL,
  numeroDocumento VARCHAR(255) NOT NULL,
  pais VARCHAR(255) NOT NULL,
  padre_id BIGINT,
  nacionalidad_id BIGINT,
  CONSTRAINT fk_nacionalidad FOREIGN KEY (nacionalidad_id) REFERENCES nacionalidades(id),
  CONSTRAINT fk_padre FOREIGN KEY (padre_id) REFERENCES personas(id)
);

-- Tabla Nacionalidad
CREATE TABLE nacionalidades (
  id BIGINT PRIMARY KEY AUTO_INCREMENT,
  valor VARCHAR(255)
);

-- Tabla DatosContacto
CREATE TABLE datos_contactos (
  id BIGINT PRIMARY KEY AUTO_INCREMENT,
  tipo VARCHAR(255),
  valor VARCHAR(255),
  id_persona BIGINT NOT NULL,
  CONSTRAINT fk_persona FOREIGN KEY (id_persona) REFERENCES persona(id)
);