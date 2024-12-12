CREATE DATABASE finalmodule;
USE finalmodule;
CREATE TABLE Category (
    category_id INT AUTO_INCREMENT PRIMARY KEY,
    category_name VARCHAR(255) NOT NULL
);
CREATE TABLE Product (
    product_id INT AUTO_INCREMENT PRIMARY KEY,
    product_name VARCHAR(255) NOT NULL,
    price DECIMAL(15, 2) NOT NULL,
    quantity INT NOT NULL CHECK (quantity > 0),
    color VARCHAR(50) NOT NULL,
    description TEXT,
    category_id INT,
    FOREIGN KEY (category_id) REFERENCES Category(category_id)
);
INSERT INTO Category (category_name) VALUES
('Phone'),
('Tivi'),
('Tủ lạnh');
INSERT INTO Product (product_name, price, quantity, color, description, category_id) VALUES
('IPhone 11', 799, 12, 'Black,Yellown,Green', 'Điện thoại iPhone 11, mới 100%', 1),
('Smart TV 55inch', 799, 12, 'Black,Yellown,Green', 'Smart TV', 2),
('Tủ lạnh Toshiba', 799, 12, 'Black,Yellown,Green', 'Tủ lạnh', 3);


