create database GasManagement
use GasManagement;

create table Customer (
 CustomerID int  AUTO_INCREMENT primary key,
 Name nvarchar(100) not null,
 Phone nvarchar(15) unique not null,
 Email nvarchar(50),
 Address nvarchar(200) not null
 );

 create table Product(
 GasID varchar(5) primary key,
 GasName VARCHAR(100) NOT NULL,
 Price float check (Price > 0),
 Weight float check (Weight > 0),
 GasType varchar(10) not null,
 StockQuantity int default 0
 );
 
create table `Order` (
  OrderID varchar(5) PRIMARY KEY,
  CustomerID int,
  OrderDate DATETIME NOT NULL,
  TotalAmount float,
  Status NVARCHAR(20),
  FOREIGN KEY (CustomerID) REFERENCES Customer(CustomerID)
);
create table OrderDetail (
	OrderDetailID varchar(5) PRIMARY KEY ,
    OrderID varchar(5),
    GasID varchar(5),
    Quantity INT NOT NULL CHECK (Quantity > 0),
    Price float NOT NULL,
    FOREIGN KEY (OrderID) REFERENCES `Order`(OrderID),
    FOREIGN KEY (GasID) REFERENCES Product(GasID)
	);

CREATE TABLE Staff (
    StaffID VARCHAR(5) PRIMARY KEY,
    NameStaff NVARCHAR(100) NOT NULL,
    Role NVARCHAR(50) NOT NULL,
    Email NVARCHAR(100) NOT NULL,
    Password VARCHAR(100) NOT NULL
);



INSERT INTO Customer (Name, Phone, Email, Address)
VALUES 
('Ngo Van Tai', '0905123456', 'vantai04102004@gmail.com', '759 Truong Chinh, Cam Le, Da Nang'),
('Tran Viet Tai', '0987654321', 'vietai145@gmail.com', '71 Ngu Hanh Son, Da Nang'),
('Le Canh Ba Hung', '1122334455', 'bhung045@gmail.com', '51 Nguyen Tat Thanh, Thanh Khe, Da Nang');

INSERT INTO Product (GasID, GasName, Price, Weight, GasType, StockQuantity)
VALUES 
('G001', 'Petrolimex 12kg', 460000, 12, 'Petrolimex', 7),
('G002', N'PetroVietNam 45kg', 1500000, 45, 'PetroVN', 5),
('G003', 'PetroDana 12kg', 420000, 12, 'PetroDana', 10);

INSERT INTO `Order` (OrderID, CustomerID, OrderDate, TotalAmount, Status)
VALUES
('O001', (SELECT CustomerID FROM Customer WHERE Phone = '0905123456'), '2024-12-03 14:00:00', 150.75, 'Pending'),
('O002', (SELECT CustomerID FROM Customer WHERE Phone = '0987654321'), '2024-12-03 15:00:00', 200.50, 'Completed'),
('O003', (SELECT CustomerID FROM Customer WHERE Phone = '1122334455'), '2024-12-03 16:00:00', 180.00, 'Pending');
INSERT INTO OrderDetail (OrderDetailID, OrderID, GasID, Quantity, Price)
VALUES 
('OD001', 'O001', 'G001', 2, 460000),
('OD002', 'O001', 'G003', 1, 420000),
('OD003', 'O002', 'G002', 1, 1500000),
('OD004', 'O003', 'G001', 1, 460000),
('OD005', 'O003', 'G003', 2, 420000);
INSERT INTO Staff (StaffID, NameStaff, Role, Email, Password)
VALUES 
('S001', 'Pham Thi Lan', 'Admin', 'lan.pham@example.com', 'adminpass123'),
('S001', 'Pham Thi Lan', 'Admin', 'lan.pham@example.com', 'adminpass123'),
('S002', 'Nguyen Bao Chau', 'Delivery Staff', 'chau@example.com', 'delivery123'),
('S003', 'Tran Thi Binh', 'Order Processing Staff', 'binh.tran@example.com', 'orderpass456'),
('S004', 'Le Hong Ha', 'Admin', 'ha.le@example.com', 'adminpass789'),
('S005', 'Tran Minh Quang', 'Delivery Staff', 'quang.tran@example.com', 'deliverypass456');