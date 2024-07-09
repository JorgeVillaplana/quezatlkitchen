-- --------------------------------------------------------
-- Host:                         79.109.198.49
-- Versión del servidor:         10.5.23-MariaDB-0+deb11u1 - Debian 11
-- SO del servidor:              debian-linux-gnu
-- HeidiSQL Versión:             12.7.0.6850
-- --------------------------------------------------------

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET NAMES utf8 */;
/*!50503 SET NAMES utf8mb4 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;


-- Volcando estructura de base de datos para QUETZALKITCHEN
CREATE DATABASE IF NOT EXISTS `QUETZALKITCHEN` /*!40100 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci */;
USE `QUETZALKITCHEN`;

-- Volcando estructura para tabla QUETZALKITCHEN.ALERGENO
CREATE TABLE IF NOT EXISTS `ALERGENO` (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `NOMBRE` varchar(200) NOT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=33 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- Volcando datos para la tabla QUETZALKITCHEN.ALERGENO: ~8 rows (aproximadamente)
DELETE FROM `ALERGENO`;
INSERT INTO `ALERGENO` (`ID`, `NOMBRE`) VALUES
	(1, 'Huevos'),
	(2, 'Pescado'),
	(3, 'Moluscos'),
	(4, 'Mostaza'),
	(5, 'Lacteos'),
	(6, 'Sulfitos'),
	(7, 'Soja'),
	(8, 'Gluten');

-- Volcando estructura para tabla QUETZALKITCHEN.ALERGENO_EN_PLATO
CREATE TABLE IF NOT EXISTS `ALERGENO_EN_PLATO` (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `ID_ALERGENO` int(11) NOT NULL,
  `ID_PLATO` int(11) NOT NULL,
  PRIMARY KEY (`ID`),
  KEY `ALERGENO_PLATO_FK` (`ID_ALERGENO`),
  KEY `PLATO_ALERGENO_FK` (`ID_PLATO`),
  CONSTRAINT `ALERGENO_PLATO_FK` FOREIGN KEY (`ID_ALERGENO`) REFERENCES `ALERGENO` (`ID`),
  CONSTRAINT `PLATO_ALERGENO_FK` FOREIGN KEY (`ID_PLATO`) REFERENCES `PLATO` (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=23 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- Volcando datos para la tabla QUETZALKITCHEN.ALERGENO_EN_PLATO: ~22 rows (aproximadamente)
DELETE FROM `ALERGENO_EN_PLATO`;
INSERT INTO `ALERGENO_EN_PLATO` (`ID`, `ID_ALERGENO`, `ID_PLATO`) VALUES
	(1, 1, 2),
	(2, 2, 3),
	(3, 3, 3),
	(4, 6, 3),
	(5, 5, 4),
	(6, 4, 5),
	(7, 4, 5),
	(8, 6, 5),
	(9, 5, 5),
	(10, 1, 5),
	(11, 5, 6),
	(12, 2, 6),
	(13, 7, 6),
	(14, 6, 6),
	(15, 8, 9),
	(16, 8, 10),
	(17, 1, 10),
	(18, 3, 11),
	(19, 8, 12),
	(20, 5, 12),
	(21, 8, 13),
	(22, 5, 13);

-- Volcando estructura para tabla QUETZALKITCHEN.DESCUENTO
CREATE TABLE IF NOT EXISTS `DESCUENTO` (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `CODIGO` varchar(200) NOT NULL,
  `PORCENTAJE` int(11) NOT NULL,
  PRIMARY KEY (`ID`),
  UNIQUE KEY `CODIGO` (`CODIGO`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- Volcando datos para la tabla QUETZALKITCHEN.DESCUENTO: ~3 rows (aproximadamente)
DELETE FROM `DESCUENTO`;
INSERT INTO `DESCUENTO` (`ID`, `CODIGO`, `PORCENTAJE`) VALUES
	(1, 'JORGE10', 10),
	(2, 'NATALIA05', 5),
	(3, 'JUANMA20', 20);

-- Volcando estructura para tabla QUETZALKITCHEN.DIRECCION
CREATE TABLE IF NOT EXISTS `DIRECCION` (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `LOCALIDAD` varchar(200) NOT NULL,
  `CP` int(11) NOT NULL,
  `CALLE_NUM_PISO` varchar(200) NOT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=61 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- Volcando datos para la tabla QUETZALKITCHEN.DIRECCION: ~33 rows (aproximadamente)
DELETE FROM `DIRECCION`;
INSERT INTO `DIRECCION` (`ID`, `LOCALIDAD`, `CP`, `CALLE_NUM_PISO`) VALUES
	(1, 'Albacete', 2006, 'C/Iris, 55, 2A'),
	(2, 'Albacete', 2008, 'C/Hermanos Falco, 17, 1B'),
	(3, 'Albacete', 2002, 'C/Carmen 28, 4Der'),
	(4, 'Albacete', 2005, 'C/Zapateros, 34,1D'),
	(5, 'Albacete', 2003, 'C/Marques de Molins, 45, 3A'),
	(6, 'Albacete', 2008, 'C/La Roda 123, 4B'),
	(7, 'Albacete', 2003, 'C/Paseo de la Feria, 56'),
	(8, 'Albacete', 2006, 'Av. De la circunvalacion, 67'),
	(9, 'Albacete', 2001, 'C/Mayor,55'),
	(10, 'Albacete', 2006, 'C/Cid, 6'),
	(11, 'Albacete', 2005, 'C/Purisima, 1'),
	(12, 'Albacete', 2008, 'Av. de la Guardia Civil 37'),
	(38, 'Albacete', 2006, 'Av. Del Arte, 43'),
	(39, 'Albacete', 2002, 'C/Iris, 55, 2A'),
	(40, 'Albacete', 2006, 'Av. Del Arte, 43'),
	(41, 'Albacete', 2008, 'C/Hermanos Falco, 17, 1B'),
	(42, 'Albacete', 2002, 'C/Carmen 28, 4Der'),
	(43, 'Albacete', 2005, 'C/Zapateros, 34,1D'),
	(44, 'Albacete', 2003, 'C/Marques de Molins, 45, 3A'),
	(45, 'Albacete', 2008, 'C/La Roda 123, 4B'),
	(46, 'Albacete', 2003, 'C/Paseo de la Feria, 56'),
	(47, 'Albacete', 2006, 'Av. De la circunvalacion, 67'),
	(48, 'Albacete', 2001, 'C/Mayor,55'),
	(49, 'Albacete', 2006, 'C/Cid, 6'),
	(50, 'Albacete', 2005, 'C/Purisima, 1'),
	(51, 'Albacete', 2008, 'Av. de la Guardia Civil 37'),
	(54, 'Teruel', 36025, 'Mi casa'),
	(55, 'Prueba1', 2022, 'Prueba1'),
	(56, 'Prueba1', 6, 'Prueba1'),
	(57, 'Prueba2', 654, 'Prueba2'),
	(58, 'Prueba2', 654, 'Prueba2'),
	(59, 'Albacete', 321, 'afdgad'),
	(60, 'Chaparra', 987, 'ASDG');

-- Volcando estructura para tabla QUETZALKITCHEN.PEDIDO
CREATE TABLE IF NOT EXISTS `PEDIDO` (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `ID_DESCUENTO` int(11) DEFAULT NULL,
  `PRECIO_SIN_DESCUENTO` double DEFAULT NULL,
  `PRECIO_CON_DESCUENTO` double DEFAULT NULL,
  `ID_DIRECCION` int(11) DEFAULT NULL,
  `HORA_ESTIMADA` datetime DEFAULT (current_timestamp() + 150000),
  `ID_USUARIO` int(11) NOT NULL,
  PRIMARY KEY (`ID`),
  KEY `PEDIDO_DESCUENTO_FK` (`ID_DESCUENTO`),
  KEY `PEDIDO_DIRECCION_FK` (`ID_DIRECCION`),
  KEY `PEDIDO_USUARIO_FK` (`ID_USUARIO`),
  CONSTRAINT `PEDIDO_DESCUENTO_FK` FOREIGN KEY (`ID_DESCUENTO`) REFERENCES `DESCUENTO` (`ID`),
  CONSTRAINT `PEDIDO_DIRECCION_FK` FOREIGN KEY (`ID_DIRECCION`) REFERENCES `DIRECCION` (`ID`),
  CONSTRAINT `PEDIDO_USUARIO_FK` FOREIGN KEY (`ID_USUARIO`) REFERENCES `USUARIO` (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- Volcando datos para la tabla QUETZALKITCHEN.PEDIDO: ~0 rows (aproximadamente)
DELETE FROM `PEDIDO`;

-- Volcando estructura para tabla QUETZALKITCHEN.PLATO
CREATE TABLE IF NOT EXISTS `PLATO` (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `NOMBRE` varchar(200) NOT NULL,
  `PRECIO_UNITARIO` double NOT NULL,
  `ID_RESTAURANTE` int(11) NOT NULL,
  PRIMARY KEY (`ID`),
  KEY `PLATO_RESTAURANTE_FK` (`ID_RESTAURANTE`),
  CONSTRAINT `PLATO_RESTAURANTE_FK` FOREIGN KEY (`ID_RESTAURANTE`) REFERENCES `RESTAURANTE` (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=17 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- Volcando datos para la tabla QUETZALKITCHEN.PLATO: ~12 rows (aproximadamente)
DELETE FROM `PLATO`;
INSERT INTO `PLATO` (`ID`, `NOMBRE`, `PRECIO_UNITARIO`, `ID_RESTAURANTE`) VALUES
	(2, 'Tortilla de patatas con cebolla', 10.5, 1),
	(3, 'Arroz negro', 13.95, 35),
	(4, 'Guacamole', 5, 33),
	(5, 'Solomillo Wellington', 27.9, 31),
	(6, 'Roll de aguacate', 6, 33),
	(7, 'Fanta Naranja', 2.5, 32),
	(8, 'Coca-Cola Zero', 2.5, 32),
	(9, 'Migas con Chorizo y uvas', 10, 36),
	(10, 'Pan de muerto negro', 3, 33),
	(11, 'Takoyaki', 5, 34),
	(12, 'Tarta 3 chocolates', 9.5, 36),
	(13, 'Helado de Lotus', 3.4, 36);

-- Volcando estructura para tabla QUETZALKITCHEN.PLATO_EN_PEDIDO
CREATE TABLE IF NOT EXISTS `PLATO_EN_PEDIDO` (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `ID_PLATO` int(11) NOT NULL,
  `ID_PEDIDO` int(11) DEFAULT NULL,
  `CANTIDAD` int(11) DEFAULT NULL,
  `PRECIO_PLATOS` double NOT NULL,
  PRIMARY KEY (`ID`),
  KEY `PLATO_PEDIDO_FK` (`ID_PLATO`),
  KEY `PEDIDO_PLATO_FK` (`ID_PEDIDO`),
  CONSTRAINT `PEDIDO_PLATO_FK` FOREIGN KEY (`ID_PEDIDO`) REFERENCES `PEDIDO` (`ID`),
  CONSTRAINT `PLATO_PEDIDO_FK` FOREIGN KEY (`ID_PLATO`) REFERENCES `PLATO` (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- Volcando datos para la tabla QUETZALKITCHEN.PLATO_EN_PEDIDO: ~0 rows (aproximadamente)
DELETE FROM `PLATO_EN_PEDIDO`;

-- Volcando estructura para tabla QUETZALKITCHEN.RESTAURANTE
CREATE TABLE IF NOT EXISTS `RESTAURANTE` (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `NOMBRE` varchar(200) NOT NULL,
  `ENVIOS` tinyint(1) NOT NULL DEFAULT 0,
  `ID_DIRECCION` int(11) DEFAULT NULL,
  PRIMARY KEY (`ID`),
  KEY `RESTAURANTE_DIRECCION_FK` (`ID_DIRECCION`),
  CONSTRAINT `RESTAURANTE_DIRECCION_FK` FOREIGN KEY (`ID_DIRECCION`) REFERENCES `DIRECCION` (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=38 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- Volcando datos para la tabla QUETZALKITCHEN.RESTAURANTE: ~7 rows (aproximadamente)
DELETE FROM `RESTAURANTE`;
INSERT INTO `RESTAURANTE` (`ID`, `NOMBRE`, `ENVIOS`, `ID_DIRECCION`) VALUES
	(1, '﻿QuetzalKitchen', 1, 8),
	(31, '﻿QuetzalKitchen', 1, 8),
	(32, 'Mercadona', 0, 9),
	(33, 'Princesa Maya', 0, 10),
	(34, 'Gunkan Sushi', 0, 11),
	(35, 'L´Arruz', 0, 11),
	(36, 'Casa Manolo', 0, 12);

-- Volcando estructura para tabla QUETZALKITCHEN.USUARIO
CREATE TABLE IF NOT EXISTS `USUARIO` (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `DNI` varchar(10) NOT NULL,
  `NOMBRE` varchar(50) NOT NULL,
  `APELLIDO1` varchar(100) NOT NULL,
  `APELLIDO2` varchar(100) DEFAULT NULL,
  `EDAD` int(11) DEFAULT NULL,
  `EMAIL` varchar(200) NOT NULL,
  `PASS` varchar(50) NOT NULL,
  `ID_DIRECCION` int(11) DEFAULT NULL,
  PRIMARY KEY (`ID`),
  UNIQUE KEY `DNI` (`DNI`),
  KEY `USUARIO_DIRECCION_FK` (`ID_DIRECCION`),
  CONSTRAINT `USUARIO_DIRECCION_FK` FOREIGN KEY (`ID_DIRECCION`) REFERENCES `DIRECCION` (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=16 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- Volcando datos para la tabla QUETZALKITCHEN.USUARIO: ~8 rows (aproximadamente)
DELETE FROM `USUARIO`;
INSERT INTO `USUARIO` (`ID`, `DNI`, `NOMBRE`, `APELLIDO1`, `APELLIDO2`, `EDAD`, `EMAIL`, `PASS`, `ID_DIRECCION`) VALUES
	(8, '﻿47581648H', 'Juan', 'Palomo', 'Márquez', 35, 'jpm@gmail.com', 'jpmiunte09', 1),
	(9, '07684592D', 'Daniel', 'Sánchez', 'Lara', 31, 'dsl67@gmail.com', 'dslrotlo087', 2),
	(10, '57816547C', 'Carlos', 'Melero', 'Las Heras', 29, 'cmlh87@gmail.com', 'cmlhiter097', 3),
	(11, '87654321X', 'Jimena', 'Garcia', 'Matamoros', 39, 'jgm876@gmail.com', 'jgmkijer678', 4),
	(12, '45678901T', 'Teresa', 'Jimenez', 'Calero', 41, 'tjc654@gmail.com', 'tjcabser897', 5),
	(13, '76543210W', 'Wenceslao', 'Galvan', 'Gaviria', 35, 'wgg875@gmail.com', 'wggloeso756', 6),
	(14, '90123456P', 'Pilar', 'Maestre', 'Gonzalez', 59, 'pmg784@gmail.com', 'pmgjfjsl8643', 7),
	(15, 'Prueba2', 'Prueba2', 'Prueba2', 'Prueba2', 12, 'Prueba2', 'Prueba2', 58);

/*!40103 SET TIME_ZONE=IFNULL(@OLD_TIME_ZONE, 'system') */;
/*!40101 SET SQL_MODE=IFNULL(@OLD_SQL_MODE, '') */;
/*!40014 SET FOREIGN_KEY_CHECKS=IFNULL(@OLD_FOREIGN_KEY_CHECKS, 1) */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40111 SET SQL_NOTES=IFNULL(@OLD_SQL_NOTES, 1) */;
