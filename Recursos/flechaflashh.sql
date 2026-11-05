-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Servidor: 127.0.0.1
-- Tiempo de generación: 29-10-2026 a las 23:43:27
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
-- Base de datos: `flechaflashh`
--
CREATE DATABASE IF NOT EXISTS `flechaflashh` DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci;
USE `flechaflashh`;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `colectivo`
--

CREATE TABLE `colectivo` (
  `ID_Colectivo` int(11) NOT NULL,
  `Matricula` varchar(20) NOT NULL,
  `Marca` varchar(50) NOT NULL,
  `Modelo` varchar(50) NOT NULL,
  `Capacidad` int(11) NOT NULL,
  `Chofer` varchar(100) NOT NULL,
  `Estado` tinyint(1) NOT NULL DEFAULT 1
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `lugar`
--

CREATE TABLE `lugar` (
  `ID_Lugar` int(11) NOT NULL,
  `ID_Viaje` int(11) NOT NULL,
  `NumeroAsiento` int(11) NOT NULL,
  `Estado` tinyint(1) NOT NULL DEFAULT 1
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `pasajeros`
--

CREATE TABLE `pasajeros` (
  `ID_Pasajero` int(11) NOT NULL,
  `DNI` varchar(20) NOT NULL,
  `Nombre` varchar(100) NOT NULL,
  `Apellido` varchar(100) NOT NULL,
  `Correo` varchar(150) NOT NULL,
  `Telefono` varchar(30) DEFAULT NULL,
  `Estado` tinyint(1) NOT NULL DEFAULT 1
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `pasajes`
--

CREATE TABLE `pasajes` (
  `ID_Pasaje` int(11) NOT NULL,
  `ID_Pasajero` int(11) NOT NULL,
  `ID_Lugar` int(11) NOT NULL,
  `ID_Ruta` int(11) NOT NULL,
  `FechaVenta` date NOT NULL,
  `HoraVenta` time NOT NULL,
  `Precio` decimal(10,2) NOT NULL,
  `Estado` tinyint(1) NOT NULL DEFAULT 1
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `viaje`
--

CREATE TABLE `viaje` (
  `ID_Viaje` int(11) NOT NULL,
  `Origen` varchar(100) NOT NULL,
  `Destino` varchar(100) NOT NULL,
  `HoraSalida` time NOT NULL,
  `HoraLlegada` time NOT NULL,
  `ID_Colectivo` int(11) DEFAULT NULL,
  `Precio` decimal(10,2) NOT NULL,
  `Estado` tinyint(1) NOT NULL DEFAULT 1
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Índices para tablas volcadas
--

--
-- Indices de la tabla `colectivo`
--
ALTER TABLE `colectivo`
  ADD PRIMARY KEY (`ID_Colectivo`),
  ADD UNIQUE KEY `Matricula` (`Matricula`);

--
-- Indices de la tabla `lugar`
--
ALTER TABLE `lugar`
  ADD PRIMARY KEY (`ID_Lugar`),
  ADD UNIQUE KEY `uq_asiento_viaje` (`ID_Viaje`,`NumeroAsiento`);

--
-- Indices de la tabla `pasajeros`
--
ALTER TABLE `pasajeros`
  ADD PRIMARY KEY (`ID_Pasajero`),
  ADD UNIQUE KEY `DNI` (`DNI`),
  ADD UNIQUE KEY `Correo` (`Correo`);

--
-- Indices de la tabla `pasajes`
--
ALTER TABLE `pasajes`
  ADD PRIMARY KEY (`ID_Pasaje`),
  ADD KEY `fk_pasaje_pasajero` (`ID_Pasajero`),
  ADD KEY `fk_pasaje_lugar` (`ID_Lugar`),
  ADD KEY `fk_pasaje_viaje` (`ID_Ruta`);

--
-- Indices de la tabla `viaje`
--
ALTER TABLE `viaje`
  ADD PRIMARY KEY (`ID_Viaje`),
  ADD KEY `fk_viaje_colectivo` (`ID_Colectivo`);

--
-- AUTO_INCREMENT de las tablas volcadas
--

--
-- AUTO_INCREMENT de la tabla `colectivo`
--
ALTER TABLE `colectivo`
  MODIFY `ID_Colectivo` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT de la tabla `lugar`
--
ALTER TABLE `lugar`
  MODIFY `ID_Lugar` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT de la tabla `pasajeros`
--
ALTER TABLE `pasajeros`
  MODIFY `ID_Pasajero` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT de la tabla `pasajes`
--
ALTER TABLE `pasajes`
  MODIFY `ID_Pasaje` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT de la tabla `viaje`
--
ALTER TABLE `viaje`
  MODIFY `ID_Viaje` int(11) NOT NULL AUTO_INCREMENT;

--
-- Restricciones para tablas volcadas
--

--
-- Filtros para la tabla `lugar`
--
ALTER TABLE `lugar`
  ADD CONSTRAINT `fk_lugar_viaje` FOREIGN KEY (`ID_Viaje`) REFERENCES `viaje` (`ID_Viaje`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Filtros para la tabla `pasajes`
--
ALTER TABLE `pasajes`
  ADD CONSTRAINT `fk_pasaje_lugar` FOREIGN KEY (`ID_Lugar`) REFERENCES `lugar` (`ID_Lugar`) ON UPDATE CASCADE,
  ADD CONSTRAINT `fk_pasaje_pasajero` FOREIGN KEY (`ID_Pasajero`) REFERENCES `pasajeros` (`ID_Pasajero`) ON UPDATE CASCADE,
  ADD CONSTRAINT `fk_pasaje_viaje` FOREIGN KEY (`ID_Ruta`) REFERENCES `viaje` (`ID_Viaje`) ON UPDATE CASCADE;

--
-- Filtros para la tabla `viaje`
--
ALTER TABLE `viaje`
  ADD CONSTRAINT `fk_viaje_colectivo` FOREIGN KEY (`ID_Colectivo`) REFERENCES `colectivo` (`ID_Colectivo`) ON DELETE SET NULL ON UPDATE CASCADE;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
