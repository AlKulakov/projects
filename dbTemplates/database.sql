DROP DATABASE IF EXISTS v09;
CREATE DATABASE v09;
/* -1-2- */
USE v09;
DROP TABLE IF EXISTS `Студенты`;
DROP TABLE IF EXISTS `Предметы`;
DROP TABLE IF EXISTS `Успеваемость студентов`;
CREATE TABLE `Студенты` (
	`№ зачетки` VARCHAR(5) NOT NULL,
	`ФИО Студента` VARCHAR(32) NOT NULL,
	`Номер группы` VARCHAR(10) NOT NULL,
	PRIMARY KEY(`№ зачетки`)
)ENGINE=InnoDB;
CREATE TABLE `Предметы` (
	`Код дисциплины` VARCHAR(10) NOT NULL,
	`Название дисциплины` VARCHAR(32) NOT NULL,
	`Семестр` int NOT NULL,
	`Лекции` int NULL,
	`Семинары` int NULL,
	`Экзамен` VARCHAR(1) NULL,
	`Зачет` VARCHAR(1) NULL,
	PRIMARY KEY(`Код дисциплины`)
)ENGINE=InnoDB;
CREATE TABLE `Успеваемость студентов` (
	`Код дисциплины` VARCHAR(10) NOT NULL,
	`№ зачетки` VARCHAR(5) NOT NULL,
	`Дата сдачи` DATE NOT NULL,
	`Оценка` INT NOT NULL,
	PRIMARY KEY(`Код дисциплины`, `№ зачетки`),
	FOREIGN KEY(`Код дисциплины`) 
	REFERENCES `Предметы`(`Код дисциплины`) 
	ON DELETE RESTRICT ON UPDATE CASCADE,
	FOREIGN KEY(`№ зачетки`) 
	REFERENCES `Студенты`(`№ зачетки`)
	ON DELETE RESTRICT ON UPDATE CASCADE
)ENGINE=InnoDB;
/* -3- */
INSERT INTO `Студенты` 
	(`№ зачетки`, `ФИО студента`, `Номер группы`)
	VALUES
	('12345', 'Иванов Сергей Степанович', 'ИВТ-301'),
	('22222', 'Сидорова Ольга Юрьевна', 'БУ-101'),
	('12487', 'Петров Иван Петрович', 'ИВТ-301');
INSERT INTO `Предметы`
	(`Код дисциплины`, `Название дисциплины`, `Семестр`, `Лекции`,`Семинары`,`Экзамен`,`Зачет`)
	VALUES
	('01', 'Математический анализ', 2, 60, 40, '+', ''), 
	('02', 'Информатика', 1, 40, 60, '', '+'),
	('03', 'Иностранный язык', 1,0,80, '+', '');
INSERT INTO `Успеваемость студентов`
	(`Код дисциплины`, `№ зачетки`, `Дата сдачи`, `Оценка`)
	VALUES
	('03', '12345', '2013.01.20', 4),
	('01', '12345', '2013.01.12', 3),
	('02', '12345', '2013.07.07', 1),
	('01', '22222', '2013.01.20', 3),
    ('02', '12487', '2013.07.07', 1);

DROP FUNCTION IF EXISTS getAVERAGE;
DELIMITER $$
CREATE FUNCTION getAVERAGE(num_zach INT)
RETURNS FLOAT
DETERMINISTIC
BEGIN
	DECLARE AVERAGE FLOAT DEFAULT 0;
	SELECT AVG(`Успеваемость студентов`.`Оценка`) AS `Средний балл`
	INTO AVERAGE
	FROM `Успеваемость студентов` WHERE `Успеваемость студентов`.`Оценка`>=2 AND `Успеваемость студентов`.`№ зачетки` = num_zach;
	RETURN IFNULL(AVERAGE, 0);
END$$
DELIMITER ;
DROP VIEW IF EXISTS `Сводная таблица`;
CREATE VIEW `Сводная таблица` as 
SELECT
	`Студенты`.`№ зачетки`,
	`Студенты`.`ФИО Студента`,
	`Студенты`.`Номер группы`,
	`Предметы`.`Код дисциплины`,
	`Предметы`.`Название дисциплины`, 
	`Предметы`.`Семестр`, 
	`Предметы`.`Лекции`,
	`Предметы`.`Семинары`,
	`Успеваемость студентов`.`Дата сдачи`,
	`Успеваемость студентов`.`Оценка`
FROM `Предметы`
inner JOIN `Успеваемость студентов`
ON `Успеваемость студентов`.`Код дисциплины` = `Предметы`.`Код дисциплины`
inner JOIN `Студенты`
ON `Студенты`.`№ зачетки` = `Успеваемость студентов`.`№ зачетки`
ORDER BY `Студенты`.`№ зачетки`;