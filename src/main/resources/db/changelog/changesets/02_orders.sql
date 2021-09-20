--liquibase formatted sql

--changeset piotr:create_order_table
create table orders (
    id int primary key auto_increment,
    fk_person int not null,
    issued date not null,
    value int not null,
    foreign key (fk_person) references person(id)
);

--changeset piotr:add_orders
insert into orders (fk_person,issued, value) values
(1,CURRENT_TIMESTAMP,61),
(1,CURRENT_TIMESTAMP,39),
(1,CURRENT_TIMESTAMP,49),
(1,CURRENT_TIMESTAMP,50),
(1,CURRENT_TIMESTAMP,51),
(1,CURRENT_TIMESTAMP,52),
(1,CURRENT_TIMESTAMP,53),
(1,CURRENT_TIMESTAMP,10),
(1,CURRENT_TIMESTAMP,2),
(2,CURRENT_TIMESTAMP,61),
(2,CURRENT_TIMESTAMP,39),
(2,CURRENT_TIMESTAMP,49),
(2,CURRENT_TIMESTAMP,50),
(2,CURRENT_TIMESTAMP,51),
(2,CURRENT_TIMESTAMP,52),
(2,CURRENT_TIMESTAMP,53),
(2,CURRENT_TIMESTAMP,10),
(2,CURRENT_TIMESTAMP,2),
(3,CURRENT_TIMESTAMP,61),
(3,CURRENT_TIMESTAMP,39),
(3,CURRENT_TIMESTAMP,49),
(3,CURRENT_TIMESTAMP,50),
(4,CURRENT_TIMESTAMP,51),
(4,CURRENT_TIMESTAMP,52),
(4,CURRENT_TIMESTAMP,53),
(5,CURRENT_TIMESTAMP,110),
(5,CURRENT_TIMESTAMP,200);
