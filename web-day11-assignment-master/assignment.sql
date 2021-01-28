drop database if exists web_day11_assignment;

create database web_day11_assignment;
use web_day11_assignment;


create table role(
	id int not null auto_increment,
    name varchar(30) not null unique,
    primary key(id)
);
insert into role (name) values
('ROLE_EMPLOYEE'), ('ROLE_CUSTOMER'), ('ROLE_ADMIN');

create table user(
	id int not null auto_increment,
    username varchar(20) unique not null,
    fullname int not null,
    primary key(id)
);

create table user_role(
    id int not null auto_increment,
    role_id int not null,
    user_id int not null,
    primary key(id),
    foreign key(role_id) references role(id),
    foreign key(user_id) references user(id)
);


select * from user;
select * from role;
select * from user_role;
