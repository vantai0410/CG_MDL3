create database demo_ss5;
use demo_ss5;

create table products (
    id char(4) primary key,
    productcode varchar(50) not null,
    productname varchar(100) not null,
    productprice float not null,
    productamount int not null,
    productdescription text,
    productstatus bit default 1
);



insert into products (id, productcode, productname, productprice, productamount, productdescription, productstatus)
values
('001', 'P001', 'Product 1', 200.00, 50, 'Description for product 1', 1),
('002', 'P002', 'Product 2', 150.00, 30, 'Description for product 2', 1),
('003', 'P003', 'Product 3', 750.00, 20, 'Description for product 3', 0),
('004', 'P004', 'Product 4', 250.00, 10, 'Description for product 4', 1);


-- Tạo Unique Index trên cột productcode
create unique index idx_productcode on products (productcode);

-- Tạo Composite Index trên các cột productname và productprice
create index idx_productname_price on products (productname, productprice);

-- Trước khi tạo index (có thể bỏ qua bước này nếu index đã được tạo)
-- Sau khi tạo index

-- Tạo view lấy các thông tin productcode, productname, productprice, productstatus từ bảng products
create view product_view as
select productcode, productname, productprice, productstatus
from products;

-- Sửa đổi view (giả sử muốn thêm productamount vào view)
create or replace view product_view as
select productcode, productname, productprice, productstatus, productamount
from products;

-- Xóa view
drop view if exists product_view;

-- Store procedure lấy tất cả thông tin của tất cả các sản phẩm
delimiter //
create procedure get_all_products()
begin
    select * from products;
end //
delimiter ;

-- Store procedure thêm một sản phẩm mới
delimiter //
create procedure add_product(
	in p_id char(4),
    in p_productcode varchar(50),
    in p_productname varchar(100),
    in p_productprice decimal(10, 2),
    in p_productamount int,
    in p_productdescription text,
    in p_productstatus bit
)
begin
    insert into products (id,productcode, productname, productprice, productamount, productdescription, productstatus)
    values (p_id,p_productcode, p_productname, p_productprice, p_productamount, p_productdescription, p_productstatus);
end //
delimiter ;

-- Store procedure sửa thông tin sản phẩm theo id
delimiter //
create procedure update_product(
    in p_id char(4),
    in p_productcode varchar(50),
    in p_productname varchar(100),
    in p_productprice float,
    in p_productamount int,
    in p_productdescription text,
    in p_productstatus bit
)
begin
    update products
    set productcode = p_productcode,
        productname = p_productname,
        productprice = p_productprice,
        productamount = p_productamount,
        productdescription = p_productdescription,
        productstatus = p_productstatus
    where id = p_id;
end //
delimiter ;

-- Store procedure xoá sản phẩm theo id
delimiter //
create procedure delete_product(in p_id int)
begin
    delete from products where id = p_id;
end //
delimiter ;




