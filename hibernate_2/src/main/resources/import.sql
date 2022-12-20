
DROP TABLE IF EXISTS products CASCADE;
DROP TABLE IF EXISTS customers CASCADE;
DROP TABLE IF EXISTS orders CASCADE;

CREATE TABLE IF NOT EXISTS  customers(id bigint auto_increment, name varchar(255) not null, PRIMARY KEY(id));
CREATE TABLE IF NOT EXISTS  products(id bigint auto_increment, title varchar(255) not null, price integer not null, PRIMARY KEY(id));
CREATE TABLE IF NOT EXISTS orders(id bigint auto_increment, customer_id bigint, product_id bigint, price bigint, FOREIGN KEY(customer_id) REFERENCES customers(id), FOREIGN KEY(product_id) REFERENCES products(id), PRIMARY KEY(id));

INSERT into customers(name) values ('Ivanov'),('Petrov'), ('Sidorov');
INSERT into products(title, price) values ('Milk', 50),('Bread', 100), ('Cheese', 120),  ('Coffee', 70),  ('Beer', 110);
INSERT into orders(customer_id, product_id, price) values (1, 1, 5),(1, 2, 10), (1, 3, 15),  (1,4, 20),(2,1, 210),(2,2, 230),(2,3, 240),(3,4, 330),(3,5, 340),(2,3, 330);


