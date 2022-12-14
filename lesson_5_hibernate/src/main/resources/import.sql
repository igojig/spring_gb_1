DROP TABLE IF EXISTS products;
CREATE TABLE IF NOT EXISTS  products(id bigint auto_increment, title varchar(255) not null, price integer not null, PRIMARY KEY(id));
insert into products(title, price) values ('Milk', 50),('Bread', 100), ('Cheese', 120);