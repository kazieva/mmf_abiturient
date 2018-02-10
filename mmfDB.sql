-- --------------------------------------------------------
-- Хост:                         127.0.0.1
-- Версия сервера:               5.7.18-log - MySQL Community Server (GPL)
-- Операционная система:         Win64
-- HeidiSQL Версия:              9.4.0.5125
-- --------------------------------------------------------

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET NAMES utf8 */;
/*!50503 SET NAMES utf8mb4 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;


-- Дамп структуры базы данных mmf
CREATE DATABASE IF NOT EXISTS `mmf` /*!40100 DEFAULT CHARACTER SET utf8 */;
USE `mmf`;

-- Дамп структуры для таблица mmf.abiturient
CREATE TABLE IF NOT EXISTS `abiturient` (
  `passport_series` char(2) NOT NULL COMMENT 'состоит из 2 символов.',
  `passport_id` int(10) unsigned NOT NULL COMMENT 'числовое беззнаковое значение.',
  `speciality_id` int(10) unsigned NOT NULL,
  `fname` varchar(20) NOT NULL COMMENT 'на случай длинных имен - 20 символов.',
  `sname` varchar(20) NOT NULL COMMENT 'на случай длинных фамилий- 20 символов.',
  `patronymic` varchar(20) DEFAULT NULL COMMENT 'не во всех странах есть отчество, поэтому поле не явзяется обязательным для заполнения\nна случай длинных очеств - 20 символов.',
  `phone` varchar(20) DEFAULT NULL COMMENT 'телефон - строчный формат. 20 символов, чтобы предусмотреть различный формат записи.\nпредусматривается возможность отсутствия телефона.',
  `school_certificate` tinyint(3) unsigned NOT NULL COMMENT 'максимальное значение - 100. 3 символа достаточно',
  `math_certificate` tinyint(3) unsigned NOT NULL COMMENT 'максимальное значение - 100. 3 символа достаточно',
  `physics_certificate` tinyint(3) unsigned NOT NULL COMMENT 'максимальное значение - 100. 3 символа достаточно',
  `language_certificate` tinyint(3) unsigned NOT NULL COMMENT 'максимальное значение - 100. 3 символа достаточно',
  PRIMARY KEY (`passport_series`,`passport_id`),
  KEY `fk_abiturient_specialty1_idx` (`speciality_id`),
  CONSTRAINT `fk_abiturient_specialty1` FOREIGN KEY (`speciality_id`) REFERENCES `speciality` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- Дамп данных таблицы mmf.abiturient: ~34 rows (приблизительно)
/*!40000 ALTER TABLE `abiturient` DISABLE KEYS */;
INSERT IGNORE INTO `abiturient` (`passport_series`, `passport_id`, `speciality_id`, `fname`, `sname`, `patronymic`, `phone`, `school_certificate`, `math_certificate`, `physics_certificate`, `language_certificate`) VALUES
	('AB', 2394805, 106, 'Октябрина', 'Суворова', 'Владимировна', '+375448441855', 67, 78, 69, 80),
	('AB', 2766140, 102, 'Юлия', 'Казиева', 'Александровна', '+375296953343', 95, 78, 83, 66),
	('AB', 3036104, 103, 'Даниил', 'Селиверстов', 'Денисович', NULL, 61, 60, 54, 70),
	('AB', 4648750, 104, 'Елена', 'Ермакова', 'Алексеевна', '+375295540152', 82, 77, 73, 73),
	('AB', 5207587, 104, 'Таисия', 'Калинина', 'Вячеславовна', '+375298901878', 65, 66, 67, 68),
	('AB', 5730387, 107, 'Глафира', 'Иванова', 'Пантелеймоновна', NULL, 67, 70, 67, 75),
	('AB', 5863034, 109, 'Полина', 'Антонова', 'Денисовна', '+375294414855', 90, 90, 90, 85),
	('AD', 4356788, 105, 'DDDDDD', 'blin', 'asd', '', 100, 100, 100, 100),
	('AK', 2489657, 107, 'Диана', 'Петрова', 'Анатольевна', '+375296784235', 78, 77, 76, 75),
	('AK', 3235559, 107, 'Ангелина', 'Дьячкова', 'Кондратовна', '+375299894213', 69, 70, 69, 69),
	('AM', 1146107, 105, 'Вера', 'Ковалёва', 'Валерьяновна', NULL, 87, 88, 90, 92),
	('AM', 3022051, 106, 'Алина', 'Горбунова', 'Никитевна', '+375296804267', 74, 67, 66, 65),
	('AM', 5669668, 103, 'Геласий', 'Андреев', 'Геласьевич', '+375295540152', 74, 96, 92, 90),
	('AP', 294805, 106, 'Коктябрина', 'Пуворова', 'Владимировна', '+375448441855', 67, 78, 69, 80),
	('KM', 2647847, 105, 'Аркадий', 'Быков', 'Александровна', '+375295553333', 55, 60, 70, 70),
	('KM', 2779620, 109, 'Артём', 'Журавлёв', 'Васильевич', NULL, 88, 84, 82, 80),
	('KM', 3032083, 107, 'Светлана', 'Беспалова', 'Романовна', '+375446935078', 73, 71, 75, 77),
	('KM', 3855807, 106, 'Александр', 'Исаев', 'Исаев', NULL, 82, 74, 76, 75),
	('KP', 5203319, 101, 'Полина', 'Лаврентьева', 'Георгьевна', '+375298710575', 60, 65, 63, 70),
	('KS', 4993607, 104, 'Марина', 'Иванова', 'Аркадьевна', '+375291407371', 84, 83, 82, 81),
	('MP', 1299391, 102, 'Андрей', 'Рогов', 'Владленович', '+375297185459', 72, 73, 74, 75),
	('MP', 3901218, 103, 'Богдан', 'Цветков', 'Евгеньевич', '+375441892083', 81, 80, 79, 78),
	('OM', 2251517, 102, 'Егор', 'Капустин', 'Мстиславович', '+375258031557', 74, 75, 76, 77),
	('PB', 6138167, 101, 'Велимир', 'Никифоров', 'Павлович', '+375253496792', 90, 74, 65, 81),
	('PF', 2275991, 109, 'Христофор', 'Степанов', 'Мэлорович', '+375296425756', 86, 87, 85, 81),
	('PK', 1099493, 101, 'Елена', 'Белоусова', 'Протасьевна', '+375299341579', 81, 55, 55, 55),
	('PK', 1396027, 105, 'Виктор', 'Гурьев', 'Донатович', '+375293332535', 87, 86, 85, 84),
	('PO', 1752862, 109, 'Alex', 'Pekert', '', '+375296953347', 97, 87, 88, 89),
	('PR', 1069967, 106, 'Руслан', 'Аксёнов', 'Лукьевич', '+375295540152', 79, 68, 71, 90),
	('RV', 1351747, 107, 'София', 'Лазарева', 'Аркадьевна', '+375298083355', 85, 80, 80, 80),
	('RV', 2945427, 104, 'Анжела', 'Ершова', 'Сергеевна', NULL, 73, 68, 71, 80),
	('TB', 8031557, 103, 'Дмитрий', 'Лобанов', 'Глебович', '+375295875708', 90, 91, 92, 80),
	('TM', 2814941, 102, 'Таисия', 'Нагуманова', 'Кирилловна', '+375442587634', 84, 64, 70, 80),
	('TP', 1154630, 101, 'Полина', 'Полина', 'Германновна', NULL, 78, 71, 72, 73);
/*!40000 ALTER TABLE `abiturient` ENABLE KEYS */;

-- Дамп структуры для таблица mmf.language
CREATE TABLE IF NOT EXISTS `language` (
  `lang` char(2) NOT NULL COMMENT 'сокращенное название языка.\nпо правилам состоит из 2 букв.',
  `name` varchar(20) NOT NULL COMMENT 'полное название языка',
  PRIMARY KEY (`lang`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- Дамп данных таблицы mmf.language: ~2 rows (приблизительно)
/*!40000 ALTER TABLE `language` DISABLE KEYS */;
INSERT IGNORE INTO `language` (`lang`, `name`) VALUES
	('en', 'english'),
	('ru', 'russian');
/*!40000 ALTER TABLE `language` ENABLE KEYS */;

-- Дамп структуры для таблица mmf.speciality
CREATE TABLE IF NOT EXISTS `speciality` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT COMMENT 'автоикрементируемое поле для индекса.',
  `recruitment_plan` tinyint(4) unsigned NOT NULL DEFAULT '20' COMMENT 'План приема на специальность - обыкновенно не большое. стандартное на ммф - 20 человек.',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=12346 DEFAULT CHARSET=utf8;

-- Дамп данных таблицы mmf.speciality: ~8 rows (приблизительно)
/*!40000 ALTER TABLE `speciality` DISABLE KEYS */;
INSERT IGNORE INTO `speciality` (`id`, `recruitment_plan`) VALUES
	(101, 3),
	(102, 3),
	(103, 2),
	(104, 2),
	(105, 3),
	(106, 3),
	(107, 4),
	(109, 2);
/*!40000 ALTER TABLE `speciality` ENABLE KEYS */;

-- Дамп структуры для таблица mmf.speciality_translate
CREATE TABLE IF NOT EXISTS `speciality_translate` (
  `lang` char(2) NOT NULL COMMENT 'сокращенное название языка',
  `speciality_id` int(10) unsigned NOT NULL,
  `speciality_name` varchar(70) NOT NULL COMMENT 'полное название специальности. может быть довольно длинным.',
  PRIMARY KEY (`lang`,`speciality_id`),
  KEY `fk_speciality_translate_language1_idx` (`lang`),
  KEY `fk_speciality_translate_specialty1_idx` (`speciality_id`),
  CONSTRAINT `fk_speciality_translate_language1` FOREIGN KEY (`lang`) REFERENCES `language` (`lang`) ON DELETE NO ACTION ON UPDATE CASCADE,
  CONSTRAINT `fk_speciality_translate_specialty1` FOREIGN KEY (`speciality_id`) REFERENCES `speciality` (`id`) ON DELETE CASCADE ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- Дамп данных таблицы mmf.speciality_translate: ~16 rows (приблизительно)
/*!40000 ALTER TABLE `speciality_translate` DISABLE KEYS */;
INSERT IGNORE INTO `speciality_translate` (`lang`, `speciality_id`, `speciality_name`) VALUES
	('en', 101, 'Mathematics (Science-Industrial Activity)'),
	('en', 102, 'Web-Programming and Internet Technologies'),
	('en', 103, 'Mathematics (Science-Pedagogical Activity)'),
	('en', 104, 'Mathematics (Science-Design Activity)'),
	('en', 105, 'Computer Mathematics and System Analysis'),
	('en', 106, 'Mathematics (Economic Activity)'),
	('en', 107, 'Mechanics and Mathematical Modeling'),
	('en', 109, 'Mobile Devices Software'),
	('ru', 101, 'Математика (научно-производственная деятельность)'),
	('ru', 102, 'Веб-программирование и Интернет-технологии'),
	('ru', 103, 'Математика (научно-педагогическая деятельность)'),
	('ru', 104, 'Математика (научно-конструкторская деятельность)'),
	('ru', 105, 'Компьютерная математика и системный анализ'),
	('ru', 106, 'Математика (экономическая деятельность)'),
	('ru', 107, 'Механика и математическое моделирование'),
	('ru', 109, 'Математическое и программное обеспечение мобильных устройств');
/*!40000 ALTER TABLE `speciality_translate` ENABLE KEYS */;

-- Дамп структуры для таблица mmf.user
CREATE TABLE IF NOT EXISTS `user` (
  `login` varchar(70) NOT NULL COMMENT 'логин пользователя. \nможет быть довольно длиным.\nнельзя зарегистрироваь друх пользователей с одинаковым логином -> первичный ключ.',
  `password` varchar(32) NOT NULL COMMENT 'хранит результат хеширования md5.\nХэш-код представляет шестнадцатеричное число из 32 символов.',
  `user_role` enum('admin','user') NOT NULL DEFAULT 'user' COMMENT '2 польховательские роли: админ и юзер.',
  `fname` varchar(20) DEFAULT NULL COMMENT '20 символов предусматривают сложные имена.',
  `sname` varchar(20) DEFAULT NULL COMMENT '20 символов предусматривают сложные фамилии.',
  `key` varchar(32) NOT NULL,
  PRIMARY KEY (`login`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- Дамп данных таблицы mmf.user: ~6 rows (приблизительно)
/*!40000 ALTER TABLE `user` DISABLE KEYS */;
INSERT IGNORE INTO `user` (`login`, `password`, `user_role`, `fname`, `sname`, `key`) VALUES
	('blinov@bsu.by', 'f594d12af716b01f1f4a92ceb4ddd199', 'admin', 'Игорь', 'Блинов', 'f594d12af716b01f1f4a92ceb4ddd199'),
	('kazieva@bsu.by', 'f7d31637eeb51bd2f69a9664a4b51915', 'user', 'Юлия', 'Казиева', 'f7d31637eeb51bd2f69a9664a4b51915'),
	('kursov@bsu.by', 'b8b4db0b3d7b9c96fb4e0e8b5cd04752', 'user', 'Валерий', 'Курсов', 'b8b4db0b3d7b9c96fb4e0e8b5cd04752'),
	('medvedev@bsu.by', 'bd0c37c811044dcf528ce605ae198efe', 'admin', 'Дмитрий', 'Медведев', '0f5b25cd58319cde0e6e33715b66db4c'),
	('romanchik@bsu.by', '1f8ecf7fedf91b9939e1523c31270c19', 'user', 'Валерий', 'Романчик', '1f8ecf7fedf91b9939e1523c31270c19'),
	('yuliakazieva1@gmail.com', '4d85afcbc9b9237b2a3ec283f881d25e', 'user', 'yulia', 'kazieva', '4d85afcbc9b9237b2a3ec283f881d25e');
/*!40000 ALTER TABLE `user` ENABLE KEYS */;

/*!40101 SET SQL_MODE=IFNULL(@OLD_SQL_MODE, '') */;
/*!40014 SET FOREIGN_KEY_CHECKS=IF(@OLD_FOREIGN_KEY_CHECKS IS NULL, 1, @OLD_FOREIGN_KEY_CHECKS) */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
