CREATE database IF NOT EXISTS  employee_database;
use employee_database;

create table if not exists  user (id int, active bit(1) , password varchar(255), roles varchar(255), user_name varchar(255) );

insert into user values(1, b'1', "admin", "ROLE_ADMIN", "admin");

create table if not exists  employee (emp_id int, date_of_birth datetime , name varchar(30), permanent bit(1), salary double);
