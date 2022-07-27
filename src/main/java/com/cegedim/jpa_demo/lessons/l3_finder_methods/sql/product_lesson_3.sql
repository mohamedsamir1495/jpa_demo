use mydb;

create table product_lesson_3
(
    id          int PRIMARY KEY,
    name        varchar(20),
    description varchar(100),
    price       decimal(8, 3)
);

select *
from product_lesson_3;