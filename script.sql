CREATE TABLE IF NOT EXISTS DIRECCION ( #Hacer registros
    ID INT NOT NULL PRIMARY KEY AUTO_INCREMENT,
    LOCALIDAD VARCHAR(200) NOT NULL,
    CP INT NOT NULL,
    CALLE_NUM_PISO VARCHAR(200) NOT NULL
);

CREATE TABLE IF NOT EXISTS USUARIO ( #Hacer registros IMPORTANTE
    ID INT NOT NULL PRIMARY KEY AUTO_INCREMENT,
    DNI VARCHAR(10) NOT NULL UNIQUE,
    NOMBRE VARCHAR(50) NOT NULL,
    APELLIDO1 VARCHAR(100) NOT NULL,
    APELLIDO2 VARCHAR(100),
    FECHA_NAC DATETIME NOT NULL,
    EDAD INT,
    EMAIL VARCHAR(200) NOT NULL,
    PASS VARCHAR(50) NOT NULL,
    ID_DIRECCION INT,
    CONSTRAINT FOREIGN KEY USUARIO_DIRECCION_FK (ID_DIRECCION) REFERENCES DIRECCION (ID)
);

CREATE TABLE IF NOT EXISTS RESTAURANTE ( #Hacer registros
    ID INT NOT NULL PRIMARY KEY AUTO_INCREMENT,
    NOMBRE VARCHAR(200) NOT NULL,
    EMPRESA_ENVIO_PROPIA BIT NOT NULL,
    ID_DIRECCION INT,
    CONSTRAINT FOREIGN KEY RESTAURANTE_DIRECCION_FK (ID_DIRECCION) REFERENCES DIRECCION (ID)
)

CREATE TABLE IF NOT EXISTS PLATO ( #Hacer registros IMPORTANTE
    ID INT NOT NULL PRIMARY KEY AUTO_INCREMENT,
    NOMBRE VARCHAR(200) NOT NULL,
    PRECIO_UNITARIO DOUBLE NOT NULL,
    ID_RESTAURANTE INT NOT NULL,
    CONSTRAINT FOREIGN KEY PLATO_RESTAURANTE_FK (ID_RESTAURANTE) REFERENCES RESTAURANTE (ID)
);

CREATE TABLE IF NOT EXISTS DESCUENTO ( #Hacer registros IMPORTANTE
    ID INT NOT NULL PRIMARY KEY AUTO_INCREMENT,
    CODIGO VARCHAR(200) NOT NULL UNIQUE,
    PORCENTAJE INT NOT NULL
):

CREATE TABLE IF NOT EXISTS PEDIDO (
    ID INT NOT NULL PRIMARY KEY AUTO_INCREMENT,
    ID_DESCUENTO INT,
    PRECIO_SIN_DESCUENTO DOUBLE NOT NULL,
    PRECIO_CON_DESCUENTO DOUBLE,
    ID_DIRECCION INT NOT NULL,
    HORA_ESTIMADA DATETIME NOT NULL DEFAULT (CURRENT_TIMESTAMP + 150000),
    ID_USUARIO INT NOT NULL,
    CONSTRAINT FOREIGN KEY PEDIDO_DESCUENTO_FK (ID_DESCUENTO) REFERENCES DESCUENTO (ID),
    CONSTRAINT FOREIGN KEY PEDIDO_DIRECCION_FK (ID_DIRECCION) REFERENCES DIRECCION (ID),
    CONSTRAINT FOREIGN KEY PEDIDO_USUARIO_FK (ID_USUARIO) REFERENCES USUARIO (ID)
);

CREATE TABLE IF NOT EXISTS PLATO_EN_PEDIDO (
    ID INT NOT NULL PRIMARY KEY AUTO_INCREMENT,
    ID_PLATO INT NOT NULL,
    ID_PEDIDO INT NOT NULL,
    CANTIDAD INT,
    PRECIO_PLATOS DOUBLE NOT NULL,
    CONSTRAINT FOREIGN KEY PLATO_PEDIDO_FK (ID_PLATO) REFERENCES PLATO (ID),
    CONSTRAINT FOREIGN KEY PEDIDO_PLATO_FK (ID_PEDIDO) REFERENCES PEDIDO (ID)
);

CREATE TABLE IF NOT EXISTS ALERGENO ( #Hacer registros
    ID INT NOT NULL PRIMARY KEY AUTO_INCREMENT,
    NOMBRE VARCHAR(200) NOT NULL
);

CREATE TABLE IF NOT EXISTS ALERGENO_EN_PLATO (
    ID INT NOT NULL PRIMARY KEY AUTO_INCREMENT,
    ID_ALERGENO INT NOT NULL,
    ID_PLATO INT NOT NULL,
    CONSTRAINT FOREIGN KEY ALERGENO_PLATO_FK (ID_ALERGENO) REFERENCES ALERGENO (ID),
    CONSTRAINT FOREIGN KEY PLATO_ALERGENO_FK (ID_PLATO) REFERENCES PLATO (ID)
);