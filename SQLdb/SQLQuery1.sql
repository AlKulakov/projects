drop table if exists supply;
drop table if EXISTS sale;
drop table if exists supplier;
drop table if exists client;
drop table if exists product;
create table supplier (
	supplier_code int not null identity(1,1),
	supplier_name varchar(32) not null,
	supplier_pn varchar(16) null,
	supplier_ad varchar(64) not null,
	primary key(supplier_code)
);
create table client (
	client_code int not null identity(1,1),
	client_name varchar(32) not null,
	client_pn varchar(16) null,
	client_ad VARCHAR(64) not null,
	primary key(client_code)
);
create table product (
	product_code int not null identity(1,1),
	product_name varchar(32) not null,
	product_info varchar(64) null,
	primary key(product_code)
);
create table supply (
	supply_code int not null identity(1,1),
	product_code int not null,
	supplier_code int not null,
	product_amount int not null,
	sup_price int not null,
	sup_date date not null,
	primary key (product_code,supplier_code, supply_code),
	foreign key(product_code) 
	references product(product_code)
	on update cascade on delete cascade,
	foreign key(supplier_code) 
	references supplier(supplier_code)
	on update cascade on delete cascade
);
create table sale (
	sale_code int not null identity(1,1),
	product_code int not null,
	client_code int not null,
	product_amount int not null,
	sale_price int not null,
	sale_date date not null,
	primary KEY (product_code, client_code, sale_code),
	foreign key(product_code) 
	references product(product_code)
	on delete cascade on update cascade,
	foreign key(client_code) 
	references client(client_code)
	on delete cascade on update cascade
);
INSERT INTO supplier
	(supplier_name, supplier_pn, supplier_ad)
	VALUES
	('«Stolichniy»', '8(800) 444-32-43', 'g. Moskva, ul.12, d.2'),
	('"Fermerskoe hozyaystvo №32"', '8(910) 555-55-55', 'Moskovskaya obl., ul. 32, d.5');
INSERT INTO client
	(client_name, client_pn, client_ad)
	VALUES
	('Ivanov P.A.', '8(495) 444-22-42', 'Moskovskaya obl., ul. 6, d.2'),
	('Petrov I I', '8(900) 455-82-4', 'Moskovskaya obl., ul. 82, d.8');
INSERT INTO product
	(product_name, product_info)
	VALUES
	('«Hleb stolichniy»', 'Hleb cherniy, buhanka'),
	('«Moloko fermerskoe»', 'Moloko 0.5 l.'),
	('«Vipechka»', 'Vipechka');
INSERT INTO supply
	(product_code, supplier_code, product_amount, sup_price, sup_date)
	VALUES
	(1,	1, 56, 40, '2022.01.23'),
	(2, 2, 34, 20, '2022.01.25'),
	(3, 1, 76, 15, '2022.02.15');
INSERT INTO sale
	(product_code, client_code, product_amount, sale_price, sale_date)
	VALUES
	(1, 2, 3, 40, '2022.01.27'),
	(2, 2, 2, 20, '2022.01.30'),
	(3, 1, 2, 15, '2022.02.20');