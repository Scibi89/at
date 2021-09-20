--liquibase formatted sql

--changeset piotr:create_person_table
create table person (
    id int primary key auto_increment,
    name varchar(255)
);

--changeset piotr:add_people
insert into person (name) values
('adam'),
('joanna'),
('krzysiek'),
('marta'),
('jowita'),
('piotrek'),
('ania'),
('robert'),
('dawid'),
('kasia');