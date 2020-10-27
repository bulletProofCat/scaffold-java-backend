--create database test CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci;

drop table if exists user;
drop table if exists role;
drop table if exists user_role;
drop table if exists department;
drop table if exists company;
drop table if exists company_department;

create table user (
    id int primary key auto_increment,
    phone varchar(20) UNIQUE NOT NULL,
    email varchar(100) UNIQUE NOT NULL,
    name varchar(40) NOT NULL,
    password varchar(128) NOT NULL COMMENT '密码+salt计算的hash',
    sex int NOT NULL COMMENT '0表示未指定，1男2女',
    enable int NOT NULL,
    avatar varchar(400) NOT NULL,
    department_id int NOT NULL,
    create_time datetime NOT NULL DEFAULT current_timestamp,
    update_time datetime NOT NULL DEFAULT current_timestamp ON UPDATE current_timestamp
);

create table role (
    id int primary key auto_increment,
    name varchar(40) NOT NULL,
    description varchar(200) NOT NULL,
    create_time datetime NOT NULL DEFAULT current_timestamp,
    update_time datetime NOT NULL DEFAULT current_timestamp ON UPDATE current_timestamp
);

create table user_role (
    id int primary key auto_increment,
    user_id int NOT NULL,
    role_id int NOT NULL,
    create_time datetime NOT NULL DEFAULT current_timestamp
);

create table department (
    id int primary key auto_increment,
    name varchar(40) UNIQUE NOT NULL,
    create_time datetime NOT NULL DEFAULT current_timestamp,
    update_time datetime NOT NULL DEFAULT current_timestamp ON UPDATE current_timestamp
);

create table company (
    id int primary key auto_increment,
    name varchar(40) UNIQUE NOT NULL,
    address varchar(200) NOT NULL,
    photo varchar(400) NOT NULL,
    create_time datetime NOT NULL DEFAULT current_timestamp,
    update_time datetime NOT NULL DEFAULT current_timestamp ON UPDATE current_timestamp
);

create table company_department (
    id int primary key auto_increment,
    company_id int NOT NULL,
    department_id int NOT NULL,
    create_time datetime NOT NULL DEFAULT current_timestamp
);
