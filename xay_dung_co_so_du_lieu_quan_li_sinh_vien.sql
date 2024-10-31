create database student_management;
use student_management;

create table student (
	id int primary key,
    name varchar(100),
    age int,
    country varchar(50)
    );
create table class(
	id int primary key,
    name varchar(50)
    );

create table teacher(
	id int primary key,
    name varchar(50),
    age int,
    country varchar(50)
    );
    
insert into class(id,name)
values(1,"C06"),
	  (2,"C07");

insert into student( id, name, age, country )
    values (1,'Tai',20,'Viet Nam'),
		   (2,'Quan',19,'Viet Nam');
           
insert into teacher( id, name, age, country)
values(1,"Thanh Cong",30,"Viet Nam"),
	  (2,"Van Chanh", 35, "Viet Nam");	
      
  
 
 
      
    