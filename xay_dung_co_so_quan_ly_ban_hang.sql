create database sales_management;
use sales_management;

create table customer(
	cID varchar(6) primary key,
    cName varchar(50) not null,
    cAge int
    );
 create table orders(
	oID varchar(6) primary key,
    cID varchar(6),
    oDate Date,
    oTotalPrice float,
	foreign key(cID) references customer(cID)
   );
   
  create table product(
	pID varchar(6) primary key,
    pName varchar(50) not null,
    pPrice float
    );
   
   create table order_detail(
	oID varchar(6) ,
    pID varchar(6) ,
    primary key(oID,pID),
    foreign key(oID) references orders(oID),
    foreign key(pID) references product(pID)
    );
    alter table order_detail
    add odQTY int;
    
   