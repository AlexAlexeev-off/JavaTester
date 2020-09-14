-- phpMyAdmin SQL Dump
-- version 4.9.5
-- https://www.phpmyadmin.net/
--
-- Хост: localhost
-- Время создания: Сен 14 2020 г., 23:00
-- Версия сервера: 5.6.38
-- Версия PHP: 5.6.31

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- База данных: `gbbiblio`
--
CREATE DATABASE IF NOT EXISTS `gbbiblio` DEFAULT CHARACTER SET utf8 COLLATE utf8_general_ci;
USE `gbbiblio`;

-- --------------------------------------------------------

--
-- Структура таблицы `Author`
--

CREATE TABLE IF NOT EXISTS `Author` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(60) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

--
-- Дамп данных таблицы `Author`
--

INSERT INTO `Author` (`id`, `name`) VALUES
(1, 'Bulgakov Mikhail Afanasevich'),
(2, 'Lermontov Mikhail Yuryevich'),
(3, 'Alexander Sergeyevich Pushkin');

-- --------------------------------------------------------

--
-- Структура таблицы `Books`
--

CREATE TABLE IF NOT EXISTS `Books` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `idAuthor` int(60) DEFAULT NULL,
  `name` varchar(60) DEFAULT NULL,
  `who` int(60) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `idAuthor` (`idAuthor`),
  KEY `who` (`who`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8;

--
-- Дамп данных таблицы `Books`
--

INSERT INTO `Books` (`id`, `idAuthor`, `name`, `who`) VALUES
(1, 1, 'Master and Margarita', 1),
(2, 1, 'Morphine', 2),
(3, 1, 'Revizor', 2),
(4, 2, 'Mciri', 1),
(5, 2, 'Borodino', 3),
(6, 2, 'Kavkazkaya plenica', 5),
(7, 3, 'Evgeny Onegin', 4),
(8, 3, 'Dubrovsky', 5),
(9, 3, 'Poltava', 1);

-- --------------------------------------------------------

--
-- Структура таблицы `Users`
--

CREATE TABLE IF NOT EXISTS `Users` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(60) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;

--
-- Дамп данных таблицы `Users`
--

INSERT INTO `Users` (`id`, `name`) VALUES
(1, 'Biblio'),
(2, 'Alex'),
(3, 'Ivan'),
(4, 'Olga'),
(5, 'Dima');

--
-- Ограничения внешнего ключа сохраненных таблиц
--

--
-- Ограничения внешнего ключа таблицы `Books`
--
ALTER TABLE `Books`
  ADD CONSTRAINT `Books_ibfk_1` FOREIGN KEY (`idAuthor`) REFERENCES `Author` (`id`),
  ADD CONSTRAINT `Books_ibfk_2` FOREIGN KEY (`who`) REFERENCES `Users` (`id`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
