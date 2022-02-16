-- phpMyAdmin SQL Dump
-- version 5.1.1
-- https://www.phpmyadmin.net/
--
-- Servidor: 127.0.0.1
-- Tiempo de generación: 16-02-2022 a las 21:12:25
-- Versión del servidor: 10.4.20-MariaDB
-- Versión de PHP: 8.0.8

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de datos: `spring_db`
--
CREATE DATABASE IF NOT EXISTS `spring_db` DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci;
USE `spring_db`;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `albumes`
--

CREATE TABLE `albumes` (
  `id_album` int(10) NOT NULL,
  `id_artista` int(10) DEFAULT NULL,
  `nombre` varchar(100) DEFAULT NULL,
  `fecha_lanz` date DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `albumes`
--

INSERT INTO `albumes` (`id_album`, `id_artista`, `nombre`, `fecha_lanz`) VALUES
(1, 1, 'Handwritten', '2015-04-14'),
(8, 7, 'Oops I did it again', '2000-05-16'),
(10, 1, 'Oops I did it again', '2022-01-30'),
(11, 1, 'álbum inventado ', '2005-03-02'),
(12, 1, 'No entiendo', '2000-07-14'),
(13, 10, 'Rose', '2021-03-12'),
(14, 3, 'jkdsjaldas', '2021-10-08');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `artistas`
--

CREATE TABLE `artistas` (
  `id_artista` int(10) NOT NULL,
  `nombre` varchar(100) DEFAULT NULL,
  `id_genero` int(10) DEFAULT NULL,
  `fecha_nac` date DEFAULT NULL,
  `link_imagen` mediumtext NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `artistas`
--

INSERT INTO `artistas` (`id_artista`, `nombre`, `id_genero`, `fecha_nac`, `link_imagen`) VALUES
(1, 'Shawn Mendes', 1, '1998-08-08', 'https://imagenes.elpais.com/resizer/TRUKQsyDjU-oTUp2J79oB9MbofI=/414x0/cloudfront-eu-central-1.images.arcpublishing.com/prisa/MYOKFPZTCJEZFMVX2SFPQBJ6KY.jpg'),
(3, 'Chayanne', 1, '1968-06-28', 'data:image/jpeg;base64,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'),
(5, 'Alicia Keys', 2, '1981-01-25', 'https://assets.adnradio.cl/2020/11/Alicia-Keys-So-Done-Hair.jpg'),
(7, 'Britney Spears', 1, '1981-12-02', 'https://media.revistavanityfair.es/photos/60e82ee92961da12c30f6cab/master/w_1600%2Cc_limit/147334.jpg'),
(10, 'Rosé', 16, '1997-02-11', 'https://i.scdn.co/image/ab67706c0000bebbfe373362560eff20af800c2c'),
(22, 'CONSTANZA', 12, '1900-01-01', 'https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQ5_u6G-llwL_q6X0VotcnOlk3UX7wHyRHEFw&usqp=CAU');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `canciones`
--

CREATE TABLE `canciones` (
  `id_cancion` int(10) NOT NULL,
  `id_album` int(10) DEFAULT NULL,
  `nombre` varchar(100) DEFAULT NULL,
  `fecha_lanz` date DEFAULT NULL,
  `link_cancion` mediumtext DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `ciudades`
--

CREATE TABLE `ciudades` (
  `id_ciudades` int(10) NOT NULL,
  `ciudad` varchar(45) NOT NULL,
  `id` bigint(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `ciudades`
--

INSERT INTO `ciudades` (`id_ciudades`, `ciudad`, `id`) VALUES
(1, 'Valparaíso', 0),
(2, 'Viña', 0),
(3, 'Quillota', 0),
(4, 'Casablanca', 0);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `clientes`
--

CREATE TABLE `clientes` (
  `id_cliente` int(10) NOT NULL,
  `nombres` varchar(45) NOT NULL,
  `apellidos` varchar(45) NOT NULL,
  `telefono` int(9) DEFAULT NULL,
  `email` varchar(45) NOT NULL,
  `id_ciudades` int(10) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `clientes`
--

INSERT INTO `clientes` (`id_cliente`, `nombres`, `apellidos`, `telefono`, `email`, `id_ciudades`) VALUES
(1, 'Constanza', 'Castillo', 911111111, 'cony.castillo03@gmail.com', 1),
(8, 'Diego', 'Canelo', 993057393, 'canelovigny@gmail.com', 3),
(9, 'Marcela', 'Contreras', 946330797, 'marcelitakarina@gmail.com', 4),
(11, 'Saimond Slayh', 'Castillo Muñoz', 969190080, 'sslayh@gmail.com', 4),
(18, 'Rengoku', 'prueba', 900000, 'rengoku@gmail.com', 3),
(22, 'Holas', 'chaos', 993057393, 'constanza@gmail.com', 1),
(23, 'Matthew', 'Rocco', 9992931, 'mrocco@acl.cl', 3),
(26, 'Cliente', 'Dos', 9992931, 'user1@gmail.com', 1),
(27, 'Cliente', 'Uno', 99999999, '321@gmail.com', 1),
(29, 'Holas', 'prueba', 9992931, 'constanza@gmail.com', 3),
(30, 'Matthew', 'prueba', 9992931, 'usuario1@gmial.com', 1),
(32, 'Holas', 'Chaos', 998345678, 'usuario1@gmial.com', 1);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `generos`
--

CREATE TABLE `generos` (
  `id_genero` int(10) NOT NULL,
  `nombre` varchar(100) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `generos`
--

INSERT INTO `generos` (`id_genero`, `nombre`) VALUES
(1, 'POP'),
(2, 'R&B'),
(3, 'Rap'),
(4, 'Rock'),
(5, 'Balada'),
(6, 'Bachata'),
(7, 'Electrónica'),
(8, 'Jazz'),
(9, 'Blues'),
(10, 'Punk'),
(11, 'Funk'),
(12, 'Metal'),
(13, 'Soul'),
(14, 'Country'),
(15, 'Folclor'),
(16, 'K-Pop');

--
-- Índices para tablas volcadas
--

--
-- Indices de la tabla `albumes`
--
ALTER TABLE `albumes`
  ADD PRIMARY KEY (`id_album`),
  ADD KEY `fk_id_artista` (`id_artista`) USING BTREE;

--
-- Indices de la tabla `artistas`
--
ALTER TABLE `artistas`
  ADD PRIMARY KEY (`id_artista`),
  ADD KEY `id_genero` (`id_genero`);

--
-- Indices de la tabla `canciones`
--
ALTER TABLE `canciones`
  ADD PRIMARY KEY (`id_cancion`),
  ADD KEY `id_album` (`id_album`);

--
-- Indices de la tabla `ciudades`
--
ALTER TABLE `ciudades`
  ADD PRIMARY KEY (`id_ciudades`);

--
-- Indices de la tabla `clientes`
--
ALTER TABLE `clientes`
  ADD PRIMARY KEY (`id_cliente`),
  ADD KEY `fk_id_ciudad` (`id_ciudades`);

--
-- Indices de la tabla `generos`
--
ALTER TABLE `generos`
  ADD PRIMARY KEY (`id_genero`);

--
-- AUTO_INCREMENT de las tablas volcadas
--

--
-- AUTO_INCREMENT de la tabla `albumes`
--
ALTER TABLE `albumes`
  MODIFY `id_album` int(10) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=15;

--
-- AUTO_INCREMENT de la tabla `artistas`
--
ALTER TABLE `artistas`
  MODIFY `id_artista` int(10) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=23;

--
-- AUTO_INCREMENT de la tabla `canciones`
--
ALTER TABLE `canciones`
  MODIFY `id_cancion` int(10) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT de la tabla `clientes`
--
ALTER TABLE `clientes`
  MODIFY `id_cliente` int(10) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=33;

--
-- AUTO_INCREMENT de la tabla `generos`
--
ALTER TABLE `generos`
  MODIFY `id_genero` int(10) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=17;

--
-- Restricciones para tablas volcadas
--

--
-- Filtros para la tabla `albumes`
--
ALTER TABLE `albumes`
  ADD CONSTRAINT `albumes_ibfk_1` FOREIGN KEY (`id_artista`) REFERENCES `artistas` (`id_artista`),
  ADD CONSTRAINT `albumes_ibfk_2` FOREIGN KEY (`id_artista`) REFERENCES `artistas` (`id_artista`);

--
-- Filtros para la tabla `artistas`
--
ALTER TABLE `artistas`
  ADD CONSTRAINT `artistas_ibfk_1` FOREIGN KEY (`id_genero`) REFERENCES `generos` (`id_genero`);

--
-- Filtros para la tabla `canciones`
--
ALTER TABLE `canciones`
  ADD CONSTRAINT `canciones_ibfk_1` FOREIGN KEY (`id_album`) REFERENCES `albumes` (`id_album`);

--
-- Filtros para la tabla `clientes`
--
ALTER TABLE `clientes`
  ADD CONSTRAINT `fk_id_ciudad` FOREIGN KEY (`id_ciudades`) REFERENCES `ciudades` (`id_ciudades`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
