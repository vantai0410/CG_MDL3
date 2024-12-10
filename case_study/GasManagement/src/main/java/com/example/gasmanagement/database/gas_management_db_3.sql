-- Tạo cơ sở dữ liệu
CREATE DATABASE GasManagement3;
USE GasManagement3;

-- Tạo bảng Customer
CREATE TABLE Customer (
    CustomerID INT AUTO_INCREMENT PRIMARY KEY,
    Name NVARCHAR(100) NOT NULL,
    Phone NVARCHAR(15) UNIQUE NOT NULL,
    Email NVARCHAR(50),
    Address NVARCHAR(200) NOT NULL
);

-- Tạo bảng Product
CREATE TABLE Product (
    GasID VARCHAR(5) PRIMARY KEY,
    GasName VARCHAR(100) NOT NULL,
    Price FLOAT CHECK (Price > 0),
    Weight FLOAT CHECK (Weight > 0),
    GasType VARCHAR(10) NOT NULL,
    StockQuantity INT DEFAULT 0
);

-- Tạo bảng Order
CREATE TABLE `Order` (
    OrderID VARCHAR(5) PRIMARY KEY,
    CustomerID INT,
    OrderDate DATETIME NOT NULL,
    TotalAmount FLOAT,
    Status NVARCHAR(20),
    FOREIGN KEY (CustomerID) REFERENCES Customer(CustomerID)
);

-- Tạo bảng OrderDetail
CREATE TABLE OrderDetail (
    OrderDetailID INT AUTO_INCREMENT PRIMARY KEY,
    OrderID VARCHAR(5),
    GasID VARCHAR(5),
    Quantity INT NOT NULL CHECK (Quantity > 0),
    Price FLOAT NOT NULL,
    FOREIGN KEY (OrderID) REFERENCES `Order`(OrderID),
    FOREIGN KEY (GasID) REFERENCES Product(GasID)
);

-- Thêm dữ liệu mẫu vào bảng Customer
INSERT INTO Customer (Name, Phone, Email, Address)
VALUES 
('Ngo Van Tai', '0905123456', 'vantai04102004@gmail.com', '759 Truong Chinh, Cam Le, Da Nang');

-- Thêm dữ liệu mẫu vào bảng Product
INSERT INTO Product (GasID, GasName, Price, Weight, GasType, StockQuantity)
VALUES 
('G001', 'Petrolimex 12kg', 460000, 12, 'Petrolimex', 7),
('G002', 'PetroVietNam 45kg', 1500000, 45, 'PetroVN', 5),
('G003', 'PetroDana 12kg', 420000, 12, 'PetroDana', 10);

-- Thêm dữ liệu mẫu vào bảng Order
INSERT INTO `Order` (OrderID, CustomerID, OrderDate, TotalAmount, Status)
VALUES
('O001', (SELECT CustomerID FROM Customer WHERE Phone = '0905123456'), '2024-12-10 08:00:00', 920000, 'Chờ'),
('O002', (SELECT CustomerID FROM Customer WHERE Phone = '0905123456'), '2024-12-10 09:00:00', 1500000, 'Hoàn thành');

-- Thêm dữ liệu mẫu vào bảng OrderDetail
INSERT INTO OrderDetail (OrderID, GasID, Quantity, Price)
VALUES 
('O001', 'G001', 2, 920000),
('O002', 'G002', 1, 1500000);

-- Truy vấn dữ liệu mẫu
SELECT o.OrderID, o.CustomerID, o.OrderDate, o.TotalAmount, o.Status, 
       p.GasName, od.Quantity, od.Price
FROM `Order` o
JOIN OrderDetail od ON o.OrderID = od.OrderID
JOIN Product p ON od.GasID = p.GasID;
