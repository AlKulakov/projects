/*1*/
drop database `Сессия студентов`;
create database `Сессия студентов`;
use `Сессия студентов`;
create table `Студенты` (
    `Номер зачетки` VARCHAR(8) not null,
    `ФИО студента` VARCHAR(32) not null,
    `Номер группы` VARCHAR(8) not null,
    primary key(`Номер зачетки`)
);
create table `Предметы` (
    `Код дисциплины` VARCHAR(4) not null,
    `Название дисциплины` VARCHAR(32) not null,
    `Семестр` int not null,
    `Часы лекций` int null,
    `Часы семинаров` int null,
    `Экзамен` varchar(1) null,
    `Зачет` varchar(1) null,
    primary key(`Код дисциплины`)
);
create table `Успеваемость студентов` (
    `Код дисциплины` varchar(4) not null,
    `Номер зачетки` varchar(8) not null,
    `Дата сдачи` date not null,
    `Оценка` int not null,
    primary key(`Код дисциплины`, `Номер зачетки`),
    foreign key (`Код дисциплины`) references `Предметы`(`Код дисциплины`) on update cascade on delete restrict,
    foreign key (`Номер зачетки`) references `Студенты`(`Номер зачетки`) on update cascade on delete restrict
);
create table `Успеваемость студентов1` (
    `Код дисциплины` varchar(4) not null,
    `Номер зачетки` varchar(8) not null,
    `Дата сдачи` date not null,
    `Оценка` int not null,
    primary key(`Код дисциплины`, `Номер зачетки`)
);
/*3*/
insert into `Студенты`(`Номер зачетки`, `ФИО студента`, `Номер группы`) values 
    ('12345', 'Иванов Сергей Степанович', 'ИВТ-301'),
    ('22222', 'Сидорова Ольга Юрьевна', 'БУ-101'),
    ('12487', 'Петров Иван Петрович', 'ИВТ-301');
insert into `Предметы`(`Код дисциплины`,`Название дисциплины`, `Семестр`, `Часы лекций`, `Часы семинаров`, `Экзамен`, `Зачет`) values 
    ('01', 'Математический анализ', 2, 60, 40, '+', null),
    ('02', 'Информатика', 1, 40, 60, null, '+'),
    ('03', 'Иностранный язык', 1, null, 80, '+', null);
insert into `Успеваемость студентов`(`Код дисциплины`, `Номер зачетки`, `Дата сдачи`, `Оценка`) values
    ('03', '12345', '2013.01.20', 4),
    ('01', '12345', '2013.01.12', 3);
insert into `Успеваемость студентов1`(`Код дисциплины`, `Номер зачетки`, `Дата сдачи`, `Оценка`) values
    ('02', '12345', '2013.07.07', 1),
    ('01', '22222', '2013.07.07', 3),
    ('02', '12487', '2013.07.07', 1);
/*4*/
insert into `Успеваемость студентов` select * from `Успеваемость студентов1`;
/*5*/
update `Студенты` left join `Успеваемость студентов` on `Студенты`.`Номер зачетки`= `Успеваемость студентов`.`Номер зачетки`
set `Студенты`.`Номер зачетки`= '33333', `Успеваемость студентов`.`Номер зачетки` = `Студенты`.`Номер зачетки`
where `Студенты`.`Номер зачетки` = '22222';
/*6*/
drop table if exists `Успеваемость студентов1`;
/*7*/
delete `Студенты`, `Успеваемость студентов` from `Студенты` left join `Успеваемость студентов` 
on `Студенты`.`Номер зачетки`= `Успеваемость студентов`.`Номер зачетки`
where `Студенты`.`Номер зачетки` = '33333';
/*8*/
select `Код дисциплины`, `Название дисциплины`, `Семестр`, `Часы лекций`, `Часы семинаров` from `Предметы`
where `Предметы`.`Часы семинаров` between 40 and 70;
/*9*/
select `Студенты`.`Номер зачетки`, `Студенты`.`ФИО студента`, `Студенты`.`Номер группы`, `Успеваемость студентов`.`Дата сдачи`, `Успеваемость студентов`.`Оценка`, `Название дисциплины` 
from `Предметы` inner join `Успеваемость студентов` on `Предметы`.`Код дисциплины` = `Успеваемость студентов`.`Код дисциплины`
inner join `Студенты` on `Успеваемость студентов`. `Номер зачетки` = `Студенты`.`Номер зачетки`
group by 1,2,3,6,4,5;
/*10*/
select `Код дисциплины`, `Название дисциплины`, `Семестр`, `Часы лекций`, `Часы семинаров` from `Предметы`
where `Предметы`.`Зачет` = '+';
/*11*/
select `Студенты`.`Номер зачетки`, `ФИО студента`, count(distinct `Успеваемость студентов`.`Код дисциплины`) as 'Кол-во дисциплин'
from `Студенты` inner join `Успеваемость студентов` on `Студенты`.`Номер зачетки` = `Успеваемость студентов`.`Номер зачетки`
having count(distinct `Успеваемость студентов`.`Код дисциплины`) >= 2;
/*12*/
select AVG(`Оценка`) as `Средний бал за экзамен` from `Успеваемость студентов` inner join `Предметы` 
on `Успеваемость студентов`.`Код дисциплины` = `Предметы`.`Код дисциплины`
where `Предметы`.`Экзамен` = '+';
/*13*/
select `Предметы`.`Код дисциплины`, `Название дисциплины`, count(distinct `Успеваемость студентов`.`Номер зачетки`) as `Кол-во сдавших`
from `Предметы` left join `Успеваемость студентов` on `Предметы`.`Код дисциплины` = `Успеваемость студентов`.`Код дисциплины`
group by 1,2;
/*14*/
select `Студенты`.`Номер зачетки`, `ФИО студента`,`Номер группы`, AVG(`Успеваемость студентов`.`Оценка`) as 'Средний балл' from `Студенты`
inner join `Успеваемость студентов` on `Студенты`.`Номер зачетки` = `Успеваемость студентов`.`Номер зачетки`
group by 1,2,3
order by AVG(`Успеваемость студентов`.`Оценка`) DESC
limit 1;
