-- phpMyAdmin SQL Dump
-- version 5.2.0
-- https://www.phpmyadmin.net/
--
-- Хост: 127.0.0.1
-- Время создания: Фев 26 2023 г., 11:09
-- Версия сервера: 10.4.27-MariaDB
-- Версия PHP: 8.2.0

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- База данных: `pizza_db`
--

-- --------------------------------------------------------

--
-- Дублирующая структура для представления `accountings`
-- (См. Ниже фактическое представление)
--
CREATE TABLE `accountings` (
`name` varchar(64)
,`description` varchar(128)
,`type` varchar(16)
,`total` decimal(33,0)
);

-- --------------------------------------------------------

--
-- Структура таблицы `products`
--

CREATE TABLE `products` (
  `id` int(4) NOT NULL,
  `name` varchar(64) NOT NULL,
  `description` varchar(128) DEFAULT NULL,
  `type` varchar(16) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Дамп данных таблицы `products`
--

INSERT INTO `products` (`id`, `name`, `description`, `type`) VALUES
(1, 'Ветчина', '1 кг ветчины', 'Продукт'),
(2, 'Сыр швейцарский', '1 кг отборного сыра', 'Продукт'),
(5, 'Сыр Моцарелла', '1 кг отборного сыра', 'Продукт'),
(6, 'Сыр Кавказский', '1 кг отборного сыра', 'Продукт'),
(7, 'Мясо Говядина', '1 кг телятины', 'Продукт'),
(8, 'Ноутбук HP-625', 'Ноутбук', 'Оборудование'),
(12, 'Зелень фасованная', '1 кг зелени', 'Продукт'),
(13, 'Gygabyte 1151 z290', 'Настольный компьютер', 'Оборудование'),
(15, 'Acer 5503 15 1', 'Ноутбук', 'Оборудование'),
(16, 'Бокал', 'Бокалы стеклянные', 'Оборудование'),
(17, 'fuijitsu-551', 'Кассовый аппарат', 'Оборудование'),
(18, 'Салфетки', 'Салфетки настольные белые', 'Оборудование'),
(19, 'Вилки', 'Вилки набор 10 шт.', 'Оборудование'),
(20, 'Ложки', 'Ложки набор 10 шт.', 'Оборудование'),
(21, 'Тарелки', 'Тарелки белые набор 10 шт', 'Оборудование'),
(22, 'Телефон Sony-4293', 'Настольный телефон для организаций', 'Оборудование'),
(23, 'Ноутбук Lenovo z51', 'Ноутбук', 'Оборудование'),
(24, 'Ноутбук HP ay-551-23', 'Ноутбук', 'Оборудование'),
(26, 'Стол', 'Стол деревянный, черный, 1 шт.', 'Оборудование'),
(27, 'Стул', 'Набор 4 шт.', 'Оборудование'),
(28, 'Redmond 213', 'Кофеварочная машина', 'Оборудование'),
(29, 'Шкаф', 'Шкаф платяной 1 шт.', 'Оборудование'),
(30, 'Кетчуп', 'Кетчуп шашлычный 1 л.', 'Продукт'),
(31, 'Вода 5л.', 'Вода питьевая 5 л. негазированная', 'Продукт'),
(32, 'Шампаское французское', 'Бутылка, 2 л.', 'Продукт'),
(33, 'Тесто', 'Тесто дрожжевое 1 кг.', 'Продукт'),
(34, 'Хлеб столичный', 'Хлеб черный столичный, батон', 'Продукт'),
(35, 'Рыба Форель', 'Рыба Форель 1 шт, замороженная', 'Продукт'),
(36, 'Креветки', 'Креветки фасованные, 2 кг.', 'Продукт'),
(37, 'Оливки', 'Оливки 1 кг', 'Продукт'),
(38, 'Макароны', 'Упаковка 1 кг', 'Продукт'),
(39, 'Молоко', 'Молоко коровье, бутылка 1.5 л, 2.5%', 'Продукт'),
(40, 'Бекон французский', 'Бекон французский 1 кг', 'Продукт'),
(42, 'Салфеткив', 'Салфетки настольные белые', 'Оборудование'),
(43, 'Вода 2 л.', 'Вода питьевая 5 л. негазированная', 'Продукт');

-- --------------------------------------------------------

--
-- Структура таблицы `realizations`
--

CREATE TABLE `realizations` (
  `id` int(4) NOT NULL,
  `product_id` int(4) NOT NULL,
  `amount` int(4) NOT NULL DEFAULT 0,
  `date` date NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Дамп данных таблицы `realizations`
--

INSERT INTO `realizations` (`id`, `product_id`, `amount`, `date`) VALUES
(1, 1, 1, '2022-12-02'),
(4, 1, 23, '2023-02-24'),
(5, 1, 5, '2023-02-24'),
(6, 1, 1, '2023-02-24'),
(7, 6, 20, '2023-02-25'),
(11, 1, 1, '2023-02-01'),
(12, 8, 1, '2023-02-03'),
(14, 6, 5, '2023-02-09'),
(15, 8, 1, '2023-02-09'),
(16, 15, 2, '2023-02-09'),
(17, 12, 10, '2023-02-09'),
(18, 36, 2, '2023-02-09'),
(19, 16, 12, '2023-02-09'),
(20, 27, 2, '2023-02-09'),
(21, 5, 2, '2023-02-10'),
(22, 15, 2, '2023-02-10'),
(23, 29, 1, '2023-02-27'),
(24, 15, 1, '2023-02-27'),
(25, 1, 1, '2023-02-27'),
(26, 6, 4, '2023-02-15');

-- --------------------------------------------------------

--
-- Структура таблицы `suppliers`
--

CREATE TABLE `suppliers` (
  `id` int(4) NOT NULL,
  `name` varchar(64) NOT NULL,
  `phone` varchar(11) NOT NULL,
  `account` varchar(20) NOT NULL,
  `address` varchar(128) NOT NULL,
  `description` varchar(128) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Дамп данных таблицы `suppliers`
--

INSERT INTO `suppliers` (`id`, `name`, `phone`, `account`, `address`, `description`) VALUES
(1, 'ООО ТехноБанк', '84956488523', '9456 3957 3957 3854', 'г. Москва, ул. Проспект Мира, д. 31', 'Финансовый партнер организации'),
(2, 'ООО Vec', '89842321842', '3850 3876 0385 6495', 'г. Москва, ул. Ленина, д.2, к.1', 'Поставщик кассового оборудования '),
(3, 'ИП Перов А.М.', '89653829523', '8589 2329 3495 8731', 'г.Рязань, ул. Октябрьская, д.5, к.3', 'Поставщик сырной продукции'),
(4, 'ОАО UniGlass', '89763728728', '8673 4648 5723 6584', 'г. Пермь, ул. 7, д.3, к.2', 'Поставщик посуды'),
(5, 'ИП Миронов И.А.', '89628957434', '4756 2934 6385 6323', 'г. Кострома, ул. 40 лет октября, д.3', 'Поставщик ингридиентов зелени'),
(6, 'ООО МебельДом', '89328232312', '8453 9457 4328 5349', 'г. Москва, ул. Маршала Баграмяна, д.2', 'Поставщик мебели'),
(7, 'ПАО Сбербанк', '84953823236', '4327 5634 8563 2432', 'г. Москва, ул. Каширская, д.7', 'Финансовый партнер'),
(8, 'ООО КанцТовары', '84952345643', '8734 6587 2349 4353', 'г. Москва, ул. Белореченская, д.1, к. 1', 'Поставщик канцелярских инструментов'),
(9, 'ИП Иванов О.А.', '89103452987', '2349 8573 0498 5734', 'г. Санкт-Петербург, ул. Центральная, д.5, к.3', 'Поставщик кухонных принадлежностей'),
(10, 'ООО ДревЗавод', '89934534534', '2348 2317 8957 3495', 'г. Москва, ул. Коммунистов, д.1', 'Поставщик мебели'),
(11, 'ООО МебельДом2', '89328232312', '8453 9457 4328 5349', 'г. Москва, ул. Маршала Баграмяна, д.2', 'Поставщик мебели'),
(14, 'ПАО Сбербанкl', '84953823236', '4327 5634 8563 2432', 'г. Москва, ул. Каширская, д.7', 'Финансовый партнер');

-- --------------------------------------------------------

--
-- Структура таблицы `supplies`
--

CREATE TABLE `supplies` (
  `id` int(4) NOT NULL,
  `suplier_id` int(4) NOT NULL,
  `product_id` int(4) NOT NULL,
  `amount` int(4) NOT NULL DEFAULT 0,
  `date` date NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Дамп данных таблицы `supplies`
--

INSERT INTO `supplies` (`id`, `suplier_id`, `product_id`, `amount`, `date`) VALUES
(2, 3, 6, 45, '2023-02-24'),
(5, 2, 8, 12, '2023-02-24'),
(6, 3, 1, 10, '2023-02-24'),
(7, 2, 17, 43, '2023-02-24'),
(8, 9, 1, 20, '2023-02-24'),
(9, 3, 7, 30, '2023-02-09'),
(10, 5, 1, 5, '2023-02-08'),
(11, 9, 5, 25, '2023-02-16'),
(12, 5, 7, 12, '2023-02-16'),
(13, 9, 34, 10, '2023-02-16'),
(14, 5, 36, 5, '2023-02-11'),
(15, 3, 5, 12, '2023-02-16'),
(16, 1, 15, 12, '2023-02-16'),
(17, 10, 29, 5, '2023-02-16'),
(18, 10, 26, 10, '2023-02-16'),
(19, 6, 27, 10, '2023-02-16'),
(20, 4, 16, 60, '2023-02-04'),
(21, 5, 12, 25, '2023-02-16'),
(22, 7, 30, 30, '2023-02-16'),
(23, 2, 13, 1, '2023-02-16'),
(24, 1, 24, 4, '2023-02-16'),
(25, 5, 36, 5, '2023-02-11'),
(26, 1, 15, 12, '2023-02-16'),
(27, 3, 5, 12, '2023-02-16'),
(28, 3, 7, 30, '2023-02-09'),
(29, 10, 29, 5, '2023-02-16');

-- --------------------------------------------------------

--
-- Структура таблицы `users`
--

CREATE TABLE `users` (
  `id` int(4) NOT NULL,
  `user_name` varchar(64) NOT NULL,
  `password` varchar(64) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Дамп данных таблицы `users`
--

INSERT INTO `users` (`id`, `user_name`, `password`) VALUES
(1, 'user', '1234');

-- --------------------------------------------------------

--
-- Структура для представления `accountings`
--
DROP TABLE IF EXISTS `accountings`;

CREATE ALGORITHM=UNDEFINED DEFINER=`root`@`localhost` SQL SECURITY DEFINER VIEW `accountings`  AS SELECT `p`.`name` AS `name`, `p`.`description` AS `description`, `p`.`type` AS `type`, coalesce(`supply_amount`.`totalSupplies`,0) - coalesce(`realizations_amount`.`totalRealizations`,0) AS `total` FROM ((`products` `p` left join (select `s`.`product_id` AS `product_id`,sum(`s`.`amount`) AS `totalSupplies` from `supplies` `s` group by `s`.`product_id`) `supply_amount` on(`p`.`id` = `supply_amount`.`product_id`)) left join (select `r`.`product_id` AS `product_id`,sum(`r`.`amount`) AS `totalRealizations` from `realizations` `r` group by `r`.`product_id`) `realizations_amount` on(`p`.`id` = `realizations_amount`.`product_id`)) GROUP BY 1 ORDER BY coalesce(`supply_amount`.`totalSupplies`,0) - coalesce(`realizations_amount`.`totalRealizations`,0) AS `DESCdesc` ASC  ;

--
-- Индексы сохранённых таблиц
--

--
-- Индексы таблицы `products`
--
ALTER TABLE `products`
  ADD PRIMARY KEY (`id`),
  ADD UNIQUE KEY `name` (`name`);

--
-- Индексы таблицы `realizations`
--
ALTER TABLE `realizations`
  ADD PRIMARY KEY (`id`),
  ADD KEY `product_id` (`product_id`);

--
-- Индексы таблицы `suppliers`
--
ALTER TABLE `suppliers`
  ADD PRIMARY KEY (`id`),
  ADD UNIQUE KEY `name` (`name`);

--
-- Индексы таблицы `supplies`
--
ALTER TABLE `supplies`
  ADD PRIMARY KEY (`id`),
  ADD KEY `product_id` (`product_id`);

--
-- Индексы таблицы `users`
--
ALTER TABLE `users`
  ADD PRIMARY KEY (`id`);

--
-- AUTO_INCREMENT для сохранённых таблиц
--

--
-- AUTO_INCREMENT для таблицы `products`
--
ALTER TABLE `products`
  MODIFY `id` int(4) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=44;

--
-- AUTO_INCREMENT для таблицы `realizations`
--
ALTER TABLE `realizations`
  MODIFY `id` int(4) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=27;

--
-- AUTO_INCREMENT для таблицы `suppliers`
--
ALTER TABLE `suppliers`
  MODIFY `id` int(4) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=15;

--
-- AUTO_INCREMENT для таблицы `supplies`
--
ALTER TABLE `supplies`
  MODIFY `id` int(4) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=30;

--
-- AUTO_INCREMENT для таблицы `users`
--
ALTER TABLE `users`
  MODIFY `id` int(4) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;

--
-- Ограничения внешнего ключа сохраненных таблиц
--

--
-- Ограничения внешнего ключа таблицы `realizations`
--
ALTER TABLE `realizations`
  ADD CONSTRAINT `realizations_ibfk_1` FOREIGN KEY (`product_id`) REFERENCES `products` (`id`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Ограничения внешнего ключа таблицы `supplies`
--
ALTER TABLE `supplies`
  ADD CONSTRAINT `supplies_ibfk_1` FOREIGN KEY (`product_id`) REFERENCES `products` (`id`) ON DELETE CASCADE ON UPDATE CASCADE;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;

ALTER TABLE products ADD UNIQUE(name);
ALTER TABLE realizations CHANGE id id INT(4) NOT NULL AUTO_INCREMENT, add PRIMARY KEY (id);
ALTER TABLE products CHANGE id id INT(4) NOT NULL AUTO_INCREMENT, add PRIMARY KEY (id);
ALTER TABLE suppliers CHANGE id id INT(4) NOT NULL AUTO_INCREMENT, add PRIMARY KEY (id);
ALTER TABLE suppliers ADD UNIQUE(name);
ALTER TABLE users CHANGE id id INT(4) NOT NULL AUTO_INCREMENT, add PRIMARY KEY (id);
ALTER TABLE supplies CHANGE id id INT(4) NOT NULL AUTO_INCREMENT, add PRIMARY KEY (id);
ALTER TABLE supplies ADD FOREIGN KEY (product_id) REFERENCES products(id) ON DELETE CASCADE ON UPDATE CASCADE;
ALTER TABLE supplies ADD FOREIGN KEY (supplier_id) REFERENCES suppliers(id) ON DELETE CASCADE ON UPDATE CASCADE;
ALTER TABLE realizations ADD FOREIGN KEY (product_id) REFERENCES products(id) ON DELETE CASCADE ON UPDATE CASCADE;
create view accountings as select p.name as name, p.description, p.type,
    COALESCE(supply_amount.totalSupplies, 0) -
    COALESCE(realizations_amount.totalRealizations, 0) as total
    from products p
    left JOIN 
    (
        SELECT s.product_id as product_id, sum(amount) as totalSupplies
        from supplies s
        GROUP by s.product_id
    ) supply_amount
    ON p.id = supply_amount.product_id
    LEFT JOIN
    (
        SELECT r.product_id as product_id, SUM(amount) as totalRealizations
        from realizations r
        GROUP BY r.product_id
    ) realizations_amount
    ON p.id = realizations_amount.product_id
    GROUP by 1
    order by total desc