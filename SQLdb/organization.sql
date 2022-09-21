drop database if exists Org;
create database Org;
use Org;

drop table if exists supply;
drop table if EXISTS sale;
drop table if exists supplier;
drop table if exists client;
drop table if exists product;
drop table if exists employee;
drop table if exists users;
drop table if exists visitors;
create table supplier (
	supplier_code int not null AUTO_INCREMENT,
	supplier_name varchar(32) not null,
	supplier_photo mediumblob null,
	supplier_pn varchar(16) null,
	supplier_ad varchar(64) not null,
	supplier_bank_num varchar(32) not null,
	primary key(supplier_code)
);
create table client (
	client_code int not null AUTO_INCREMENT,
	client_name varchar(32) not null,
	client_photo mediumblob null,
	client_pn varchar(16) null,
	client_ad VARCHAR(64) not null,
	client__bank_num varchar(32) not null,
	primary key(client_code)
);
create table product (
	product_code int not null AUTO_INCREMENT,
	product_name varchar(32) not null,
	product_photo mediumblob null,
	product_info varchar(64) null,
	primary key(product_code)
);
create table employee (
	employee_id int not null AUTO_INCREMENT,
	employee_fio varchar(64) not null, 
	employee_position varchar(32) not null,
	employee_photo mediumblob null,
	employee_info varchar(128) null,
	primary key(employee_id)
)auto_increment=100;

create table supply (
	supply_code int not null AUTO_INCREMENT,
	product_code int not null,
	supplier_code int not null,
	employee_id int not null,
	product_amount int not null,
	sup_price int not null,
	sup_date date not null,
	primary key (supply_code),
	foreign key(product_code) 
	references product(product_code)
	on delete cascade on update cascade,
	foreign key(supplier_code) 
	references supplier(supplier_code)
	on delete cascade on update cascade,
	foreign key(employee_id) 
	references employee(employee_id)
	on update cascade on delete cascade
);
create table sale (
	sale_code int not null auto_increment,
	product_code int not null,
	client_code int not null,
	employee_id int not null,
	product_amount int not null,
	sale_price int not null,
	sale_date date not null,
	primary KEY (sale_code),
	foreign key(product_code) 
	references product(product_code)
	on delete cascade on update cascade,
	foreign key(client_code) 
	references client(client_code)
	on delete cascade on update cascade,
	foreign key(employee_id) 
	references employee(employee_id)
	on update cascade on delete cascade
);
create table users (
	user_code int not null,
	employee_id int not null,
	username varchar(32) not null,
	password varchar(128) not null,
	primary key(user_code),
	foreign key (employee_id) references employee(employee_id) on update restrict on delete restrict
) engine=InnoDB;
create table visitors (
	visitor_id int not null auto_increment,
	employee_id int not null,
	visitor_fio varchar(64) not null,
	visit_date date not null,
	visitor_photo mediumblob null,
	visitor_info text null,
	primary key(visitor_id),
	foreign key (employee_id) references employee(employee_id) on update restrict on delete restrict
);
create table back_up (
	back_up_id int not null auto_increment,
	back_up_db_name varchar(64) not null,
	back_up_date date not null,
	back_up_time time not null,
	primary key(back_up_id)
);

INSERT INTO supplier
	(supplier_name, supplier_pn, supplier_ad, supplier_bank_num)
	VALUES
	('ElectroniX', '8(916) 644-32-43', 'g. Moskva, ul.12, d.2', '2421935321389221'),
	('ООО "Профметалл"', '8(495) 255-31-31', 'ул. Донбасская, Михнево, Московская обл., 142840', '6159934748938251');
INSERT INTO client
	(client_name, client_pn, client_ad, client__bank_num)
	VALUES
	('Ivanov P.A.', '8(495) 444-22-42', 'Moskovskaya obl., ul. 6, d.2', '5323432342342342'),
	('Petrov I I', '8(966) 665-82-43', 'Moskovskaya obl., ul. 82, d.8', '7421934857389232');
INSERT INTO product
	(product_name, product_info)
	VALUES
	('A-865', ''),
	('A-782', ''),
	('B-987', '');
INSERT INTO supply
	(product_code, supplier_code, employee_id, product_amount, sup_price, sup_date)
	VALUES
	(1,	1, 107, 32, 401231, '2022.01.23'),
	(2, 2, 109, 23, 201232, '2022.01.25'),
	(3, 1, 108, 12, 152312, '2022.02.15');
INSERT INTO sale
	(product_code, client_code, employee_id, product_amount, sale_price, sale_date)
	VALUES
	(1, 2, 109, 40, 221311, '2022.01.27'),
	(2, 2, 108, 20, 120023, '2022.01.30'),
	(3, 1, 107, 15, 100234, '2022.02.20');
insert into employee
	(employee_fio, employee_position, employee_info)
	VALUES
	("Гусев Владимир Николаевич", "Генеральный директор", ""),
	("Пирогов Алексей Алекссевич", "Зам. генерального директора", ""),
	("Александрова Мария Александровна", "Секретарь", ""),
	("Руденко Петр Вячеславович", "Сис. Администратор", ""),
	("Лапин Алексей Александрович", "Сис.Администратор", ""),
	("Иванова Елена Владимировна", "Бухгалтер", ""),
	("Горин Павел Иванович", "Менеджер", ""),
	("Захарова Анастасия Георгиевна", "Менеджер", ""),
	("Еловская Василиса Александровна", "Менеджер", ""),
	("Борисов Константин Борисович", "Менеджер", ""),
	("Федотов Евгений Александрович", "Научный сотрудник", ""),
	("Семёнова Лидия Ивановна", "Ст. Научный сотрудник", ""),
	("Бредихин Владимир Алексеевич", "Ст. Научный сотрудник", ""),
	("Никифоров Александр Павлович", "Научный сотрудник", ""),
	("Амелин Александр Евгеньевич ", "Научный сотрудник", ""),
	("Мухамедов Али Арбекович", "Сотрудник охраны", ""),
	("Кривчук Никита Тарасович", "Сотрудник охраны", ""),
	("Михайлова Ольга Константиновна", "Научный сотрудник", ""),
	("Перчаткина Татьяна Сергеевна", "Научный сотрудник", ""),
	("Круглов Иван Владимирович", "Заведующий службы безопасности", ""),
	("Пак Евгений Олегович", "Научный сотрудник", "");
	drop user administrator@localhost;
	drop user accountant@localhost;
	drop user storeWorker@localhost;
	drop user director@localhost;
	drop user manager@localhost;
	drop user researcher@localhost;
create user administrator@'127.0.0.1' identified by 'asdzxc';
flush privileges;
create user accountant@'127.0.0.1' identified by 'asdzxc';
flush privileges;
create user manager@'127.0.0.1' identified by 'asdzxc';
flush privileges;
create user researcher@'127.0.0.1' identified by 'qwerty';
flush privileges;
create user director@'127.0.0.1' identified by 'qwerty';
flush privileges;
create user storeWorker@'127.0.0.1' identified by 'qwerty';
flush privileges;

grant all privileges on *.* to administrator@'127.0.0.1' with grant option;
flush privileges;

grant select, insert, update on *.* to director@'127.0.0.1';
flush privileges;

grant select, insert, update on Org.employee to accountant@'127.0.0.1';
grant select, insert, update on Org.sale to accountant@'127.0.0.1';
grant select, insert, update on Org.supply to accountant@'127.0.0.1';
flush privileges;

grant select, insert, update on Org.product to manager@'127.0.0.1';
grant select, insert, update on Org.client to manager@'127.0.0.1';
grant select, insert, update on Org.supplier to manager@'127.0.0.1';
flush privileges;

grant select, insert, update on Org.product to researcher@'127.0.0.1';
flush privileges;

grant select on Org.product to storeWorker@'127.0.0.1';
grant select on Org.sale to storeWorker@'127.0.0.1';
grant select on Org.supply to storeWorker@'127.0.0.1';
flush privileges;