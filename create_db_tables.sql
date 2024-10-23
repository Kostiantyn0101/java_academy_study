create database academy_study;
use academy_study;

create table users
(
    id        bigint primary key auto_increment,
    username  varchar(50) not null unique,
    password  varchar(100) not null,
    enabled   boolean     not null
);

create table teachers
(
    id        bigint primary key auto_increment,
    user_id   bigint not null,
    first_name varchar(50),
    last_name  varchar(50),
    foreign key (user_id) references users(id)
);

create table students
(
    id        bigint primary key auto_increment,
    user_id   bigint not null,
    first_name varchar(50),
    last_name  varchar(50),
    foreign key (user_id) references users(id)
);

create table role_names
(
    id   bigint primary key auto_increment,
    role varchar(50) not null unique
);

create table roles
(
    user_id bigint not null,
    role_id bigint not null,
    primary key (user_id, role_id),
    foreign key (user_id) references users(id),
    foreign key (role_id) references role_names(id)
);

