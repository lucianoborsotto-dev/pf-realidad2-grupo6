-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Servidor: 127.0.0.1
-- Tiempo de generación: 28-10-2026 a las 01:33:25
-- Versión del servidor: 10.4.32-MariaDB
-- Versión de PHP: 8.2.12

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de datos: `flechaflash`
--
CREATE DATABASE IF NOT EXISTS `flechaflash` DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci;
USE `flechaflash`;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `colectivos`
--

CREATE TABLE `colectivos` (
  `id_colectivo` int(11) NOT NULL,
  `matricula` varchar(15) NOT NULL,
  `marca` varchar(50) NOT NULL,
  `modelo` varchar(50) NOT NULL,
  `capacidad` int(11) NOT NULL,
  `chofer` varchar(100) NOT NULL,
  `estado` tinyint(1) NOT NULL DEFAULT 1
) ;

--
-- Disparadores `colectivos`
--
DELIMITER $$
CREATE TRIGGER `trg_colectivo_capacidad` BEFORE UPDATE ON `colectivos` FOR EACH ROW BEGIN
  IF NEW.capacidad <> OLD.capacidad THEN
    SIGNAL SQLSTATE '45000' SET MESSAGE_TEXT = 'La capacidad no puede modificarse automaticamente; gestione los asientos primero';
  END IF;
END
$$
DELIMITER ;
DELIMITER $$
CREATE TRIGGER `trg_colectivo_crear_asientos` AFTER INSERT ON `colectivos` FOR EACH ROW BEGIN
  DECLARE numero INT DEFAULT 1;
  WHILE numero <= NEW.capacidad DO
    INSERT INTO lugares (id_colectivo, numero_asiento, estado)
    VALUES (NEW.id_colectivo, numero, 1);
    SET numero = numero + 1;
  END WHILE;
END
$$
DELIMITER ;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `lugares`
--

CREATE TABLE `lugares` (
  `id_lugar` int(11) NOT NULL,
  `id_colectivo` int(11) NOT NULL,
  `numero_asiento` int(11) NOT NULL,
  `estado` tinyint(1) NOT NULL DEFAULT 1
) ;

--
-- Disparadores `lugares`
--
DELIMITER $$
CREATE TRIGGER `trg_lugar_validar_insert` BEFORE INSERT ON `lugares` FOR EACH ROW BEGIN
  IF NEW.numero_asiento < 1 OR NEW.numero_asiento > COALESCE((SELECT capacidad FROM colectivos WHERE id_colectivo = NEW.id_colectivo), 0) THEN
    SIGNAL SQLSTATE '45000' SET MESSAGE_TEXT = 'Numero de asiento fuera de la capacidad del colectivo';
  END IF;
END
$$
DELIMITER ;
DELIMITER $$
CREATE TRIGGER `trg_lugar_validar_update` BEFORE UPDATE ON `lugares` FOR EACH ROW BEGIN
  IF NEW.numero_asiento < 1 OR NEW.numero_asiento > COALESCE((SELECT capacidad FROM colectivos WHERE id_colectivo = NEW.id_colectivo), 0) THEN
    SIGNAL SQLSTATE '45000' SET MESSAGE_TEXT = 'Numero de asiento fuera de la capacidad del colectivo';
  END IF;
END
$$
DELIMITER ;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `pasajeros`
--

CREATE TABLE `pasajeros` (
  `id_pasajero` int(11) NOT NULL,
  `dni` varchar(15) NOT NULL,
  `nombre` varchar(100) NOT NULL,
  `apellido` varchar(100) NOT NULL,
  `correo` varchar(150) DEFAULT NULL,
  `telefono` varchar(20) DEFAULT NULL,
  `estado` tinyint(1) NOT NULL DEFAULT 1
) ;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `pasajes`
--

CREATE TABLE `pasajes` (
  `id_pasaje` int(11) NOT NULL,
  `id_pasajero` int(11) NOT NULL,
  `id_lugar` int(11) NOT NULL,
  `id_ruta` int(11) NOT NULL,
  `fecha_venta` date NOT NULL,
  `hora_venta` time NOT NULL,
  `precio` decimal(10,2) NOT NULL,
  `estado` tinyint(1) NOT NULL DEFAULT 1,
  `reserva_activa` tinyint(1) GENERATED ALWAYS AS (case when `estado` = 1 then 1 else NULL end) STORED,
  `id_colectivo` int(11) NOT NULL
) ;

--
-- Disparadores `pasajes`
--
DELIMITER $$
CREATE TRIGGER `trg_pasaje_validar_insert` BEFORE INSERT ON `pasajes` FOR EACH ROW BEGIN
  IF NEW.estado = 1 THEN
    IF NOT EXISTS (SELECT 1 FROM pasajeros p WHERE p.id_pasajero = NEW.id_pasajero AND p.estado = 1) THEN
      SIGNAL SQLSTATE '45000' SET MESSAGE_TEXT = 'El pasajero no existe o esta inactivo';
    END IF;
    IF NOT EXISTS (SELECT 1 FROM rutas r JOIN colectivos c ON c.id_colectivo = r.id_colectivo JOIN lugares l ON l.id_colectivo = c.id_colectivo WHERE r.id_ruta = NEW.id_ruta AND c.id_colectivo = NEW.id_colectivo AND l.id_lugar = NEW.id_lugar AND r.estado = 1 AND c.estado = 1 AND l.estado = 1 AND TIMESTAMP(r.fecha_viaje, r.hora_salida) > NOW()) THEN
      SIGNAL SQLSTATE '45000' SET MESSAGE_TEXT = 'Viaje no disponible, ya iniciado o asiento inhabilitado';
    END IF;
  END IF;
END
$$
DELIMITER ;
DELIMITER $$
CREATE TRIGGER `trg_pasaje_validar_update` BEFORE UPDATE ON `pasajes` FOR EACH ROW BEGIN
  IF NEW.estado = 1 AND (OLD.estado <> 1 OR NEW.id_pasajero <> OLD.id_pasajero OR NEW.id_lugar <> OLD.id_lugar OR NEW.id_ruta <> OLD.id_ruta OR NEW.id_colectivo <> OLD.id_colectivo) THEN
    IF NOT EXISTS (SELECT 1 FROM pasajeros p WHERE p.id_pasajero = NEW.id_pasajero AND p.estado = 1) THEN
      SIGNAL SQLSTATE '45000' SET MESSAGE_TEXT = 'El pasajero no existe o esta inactivo';
    END IF;
    IF NOT EXISTS (SELECT 1 FROM rutas r JOIN colectivos c ON c.id_colectivo = r.id_colectivo JOIN lugares l ON l.id_colectivo = c.id_colectivo WHERE r.id_ruta = NEW.id_ruta AND c.id_colectivo = NEW.id_colectivo AND l.id_lugar = NEW.id_lugar AND r.estado = 1 AND c.estado = 1 AND l.estado = 1 AND TIMESTAMP(r.fecha_viaje, r.hora_salida) > NOW()) THEN
      SIGNAL SQLSTATE '45000' SET MESSAGE_TEXT = 'Viaje no disponible, ya iniciado o asiento inhabilitado';
    END IF;
  END IF;
END
$$
DELIMITER ;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `rutas`
--

CREATE TABLE `rutas` (
  `id_ruta` int(11) NOT NULL,
  `origen` varchar(100) NOT NULL,
  `destino` varchar(100) NOT NULL,
  `fecha_viaje` date NOT NULL,
  `hora_salida` time NOT NULL,
  `hora_llegada` time NOT NULL,
  `id_colectivo` int(11) NOT NULL,
  `precio` decimal(10,2) NOT NULL,
  `estado` tinyint(1) NOT NULL DEFAULT 1
) ;

-- --------------------------------------------------------

--
-- Estructura Stand-in para la vista `vista_disponibilidad_asientos`
-- (Véase abajo para la vista actual)
--
CREATE TABLE `vista_disponibilidad_asientos` (
`id_ruta` int(11)
,`origen` varchar(100)
,`destino` varchar(100)
,`fecha_viaje` date
,`hora_salida` time
,`hora_llegada` time
,`id_colectivo` int(11)
,`id_lugar` int(11)
,`numero_asiento` int(11)
,`estado_lugar` tinyint(1)
,`ocupado` int(1)
);

-- --------------------------------------------------------

--
-- Estructura para la vista `vista_disponibilidad_asientos`
--
DROP TABLE IF EXISTS `vista_disponibilidad_asientos`;

CREATE ALGORITHM=UNDEFINED DEFINER=`root`@`localhost` SQL SECURITY DEFINER VIEW `vista_disponibilidad_asientos`  AS SELECT `r`.`id_ruta` AS `id_ruta`, `r`.`origen` AS `origen`, `r`.`destino` AS `destino`, `r`.`fecha_viaje` AS `fecha_viaje`, `r`.`hora_salida` AS `hora_salida`, `r`.`hora_llegada` AS `hora_llegada`, `r`.`id_colectivo` AS `id_colectivo`, `l`.`id_lugar` AS `id_lugar`, `l`.`numero_asiento` AS `numero_asiento`, `l`.`estado` AS `estado_lugar`, CASE WHEN `p`.`id_pasaje` is null THEN 0 ELSE 1 END AS `ocupado` FROM ((`rutas` `r` join `lugares` `l` on(`l`.`id_colectivo` = `r`.`id_colectivo`)) left join `pasajes` `p` on(`p`.`id_ruta` = `r`.`id_ruta` and `p`.`id_lugar` = `l`.`id_lugar` and `p`.`estado` = 1)) ;

--
-- Índices para tablas volcadas
--

--
-- Indices de la tabla `colectivos`
--
ALTER TABLE `colectivos`
  ADD PRIMARY KEY (`id_colectivo`),
  ADD UNIQUE KEY `matricula` (`matricula`);

--
-- Indices de la tabla `lugares`
--
ALTER TABLE `lugares`
  ADD PRIMARY KEY (`id_lugar`),
  ADD UNIQUE KEY `uq_asiento_colectivo` (`id_colectivo`,`numero_asiento`),
  ADD UNIQUE KEY `uq_lugar_colectivo` (`id_lugar`,`id_colectivo`);

--
-- Indices de la tabla `pasajeros`
--
ALTER TABLE `pasajeros`
  ADD PRIMARY KEY (`id_pasajero`),
  ADD UNIQUE KEY `dni` (`dni`),
  ADD UNIQUE KEY `correo` (`correo`);

--
-- Indices de la tabla `pasajes`
--
ALTER TABLE `pasajes`
  ADD PRIMARY KEY (`id_pasaje`),
  ADD UNIQUE KEY `uq_pasaje_activo` (`id_ruta`,`id_lugar`,`reserva_activa`),
  ADD KEY `fk_pasajes_pasajeros` (`id_pasajero`),
  ADD KEY `idx_pasajes_ruta_lugar` (`id_ruta`,`id_lugar`),
  ADD KEY `fk_pasaje_lugar_colectivo` (`id_lugar`,`id_colectivo`),
  ADD KEY `fk_pasaje_ruta_colectivo` (`id_ruta`,`id_colectivo`);

--
-- Indices de la tabla `rutas`
--
ALTER TABLE `rutas`
  ADD PRIMARY KEY (`id_ruta`),
  ADD UNIQUE KEY `uq_ruta_colectivo` (`id_ruta`,`id_colectivo`),
  ADD KEY `fk_rutas_colectivos` (`id_colectivo`);

--
-- AUTO_INCREMENT de las tablas volcadas
--

--
-- AUTO_INCREMENT de la tabla `colectivos`
--
ALTER TABLE `colectivos`
  MODIFY `id_colectivo` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT de la tabla `lugares`
--
ALTER TABLE `lugares`
  MODIFY `id_lugar` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT de la tabla `pasajeros`
--
ALTER TABLE `pasajeros`
  MODIFY `id_pasajero` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT de la tabla `pasajes`
--
ALTER TABLE `pasajes`
  MODIFY `id_pasaje` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT de la tabla `rutas`
--
ALTER TABLE `rutas`
  MODIFY `id_ruta` int(11) NOT NULL AUTO_INCREMENT;

--
-- Restricciones para tablas volcadas
--

--
-- Filtros para la tabla `lugares`
--
ALTER TABLE `lugares`
  ADD CONSTRAINT `fk_lugares_colectivos` FOREIGN KEY (`id_colectivo`) REFERENCES `colectivos` (`id_colectivo`);

--
-- Filtros para la tabla `pasajes`
--
ALTER TABLE `pasajes`
  ADD CONSTRAINT `fk_pasaje_lugar_colectivo` FOREIGN KEY (`id_lugar`,`id_colectivo`) REFERENCES `lugares` (`id_lugar`, `id_colectivo`),
  ADD CONSTRAINT `fk_pasaje_ruta_colectivo` FOREIGN KEY (`id_ruta`,`id_colectivo`) REFERENCES `rutas` (`id_ruta`, `id_colectivo`),
  ADD CONSTRAINT `fk_pasajes_lugares` FOREIGN KEY (`id_lugar`) REFERENCES `lugares` (`id_lugar`),
  ADD CONSTRAINT `fk_pasajes_pasajeros` FOREIGN KEY (`id_pasajero`) REFERENCES `pasajeros` (`id_pasajero`),
  ADD CONSTRAINT `fk_pasajes_rutas` FOREIGN KEY (`id_ruta`) REFERENCES `rutas` (`id_ruta`);

--
-- Filtros para la tabla `rutas`
--
ALTER TABLE `rutas`
  ADD CONSTRAINT `fk_rutas_colectivos` FOREIGN KEY (`id_colectivo`) REFERENCES `colectivos` (`id_colectivo`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
