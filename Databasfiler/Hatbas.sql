DROP DATABASE IF EXISTS hatdb;
CREATE DATABASE hatdb;
USE hatdb;
DROP USER IF EXISTS hatdb@localhost;

CREATE USER hatdb@localhost IDENTIFIED BY 'hatkey';
GRANT ALL PRIVILEGES ON hatdb.* TO hatdb@localhost;



DROP TABLE IF EXISTS Fabric;

CREATE TABLE Fabric (
  Fabric_ID int AUTO_INCREMENT,
  Name varchar(20),
  Price double,
  Color varchar(20),
  Supplier varchar(40),
  Description varchar(255),
  PRIMARY KEY (Fabric_ID));

DROP TABLE IF EXISTS Standard_Hat;

CREATE TABLE Standard_Hat (
  Standard_Hat_ID int AUTO_INCREMENT,
  Name varchar(30),
  Price double,
  Description varchar(255),
  Hat_Fabric int,
  Active bool DEFAULT True,
  PRIMARY KEY (Standard_Hat_ID),
  CONSTRAINT Standard_Hat_Fabric_fk FOREIGN KEY (Hat_Fabric) REFERENCES Fabric (Fabric_ID));

DROP TABLE IF EXISTS Employee;

CREATE TABLE Employee (
  Employee_ID int AUTO_INCREMENT,
  Username varchar(20),
  Password varchar(20),
  Name varchar(20),
  Phone varchar(20),
  Security_Question varchar(50),
  Security_Answer varchar(25),
  PRIMARY KEY (Employee_ID));

DROP TABLE IF EXISTS Hat;

CREATE TABLE Hat (
  Hat_ID int AUTO_INCREMENT,
  Name varchar(30),
  Price double,
  Size varchar(3),
  Description varchar(255),
  Finished bool DEFAULT FALSE,
  Hat_Fabric int,
  Worker int,
  PRIMARY KEY (Hat_ID),
  CONSTRAINT Hat_Fabric_fk FOREIGN KEY (Hat_Fabric) REFERENCES Fabric (Fabric_ID),
  CONSTRAINT Hat_Employee_fk FOREIGN KEY (Worker) REFERENCES Employee (Employee_ID));

DROP TABLE IF EXISTS Special_Hat;

CREATE TABLE Special_Hat (
  Hat_ID int,
  Image_Path varchar(1024),
  PRIMARY KEY (Hat_ID));

DROP TABLE IF EXISTS Custom_Hat;

CREATE TABLE Custom_Hat (
  Hat_ID int,
  PRIMARY KEY (Hat_ID));


DROP TABLE IF EXISTS Address;

CREATE TABLE Address (
  Address_ID int AUTO_INCREMENT,
  Street varchar(25),
  Postal varchar(10),
  City varchar(15),
  Country varchar(15),
  PRIMARY KEY (Address_ID));

DROP TABLE IF EXISTS Customer;

CREATE TABLE Customer (
  Customer_ID int AUTO_INCREMENT,
  Customer_Nr int(8),
  First_Name varchar(15),
  Last_Name varchar(25),
  Email varchar(20),
  Phone_Nr varchar(20),
  Address int,
  Comment varchar(200),
  Active bool DEFAULT TRUE,
  PRIMARY KEY (Customer_ID),
  CONSTRAINT Customer_Address_fk FOREIGN KEY (Address) REFERENCES Address(Address_ID));

DROP TABLE IF EXISTS ORDERS;

CREATE TABLE ORDERS (
  Orders_ID int AUTO_INCREMENT,
  Total_Price double,
  Delivery_Date date,
  Order_Date date,
  Status varchar(20),
  Delivery_Address int,
  Customer int,
  Created_By int,
  Active bool DEFAULT TRUE,
  PRIMARY KEY (Orders_ID),
  CONSTRAINT Orders_Address_fk FOREIGN KEY (Delivery_Address) REFERENCES Address(Address_ID),
  CONSTRAINT Orders_Customer_fk FOREIGN KEY (Customer) REFERENCES Customer(Customer_ID),
  CONSTRAINT Orders_Employee_fk FOREIGN KEY (Created_By) REFERENCES Employee(Employee_ID));

DROP TABLE IF EXISTS Ordered_St_Hat;

CREATE TABLE Ordered_St_Hat (
  Size varchar(3),
  Standard_Hat int,
  Order_Nr int,
  CONSTRAINT Ordered_St_Hat_Standard_Hat_fk FOREIGN KEY (Standard_Hat) REFERENCES Standard_Hat(Standard_Hat_ID),
  CONSTRAINT Ordered_St_Hat_Order_fk FOREIGN KEY (Order_Nr) REFERENCES orders(Orders_ID));

DROP TABLE IF EXISTS Ordered_Hat;

CREATE TABLE Ordered_Hat (
  Hat_ID int,
  Order_Nr int,
  CONSTRAINT Ordered_Hat_Hat_fk FOREIGN KEY (Hat_ID) REFERENCES Hat(Hat_ID),
  CONSTRAINT Ordered_Hat_Order_fk FOREIGN KEY (Order_Nr) REFERENCES ORDERS(Orders_ID));


DROP TABLE IF EXISTS Customs;

CREATE TABLE Customs (
  Code_ID int AUTO_INCREMENT,
  Code varchar(8),
  PRIMARY KEY (Code_ID));

DROP TABLE IF EXISTS Shipping;

CREATE TABLE Shipping_Invoice (
  Shipping_ID int AUTO_INCREMENT,
  Shipping_Date date,
  Order_ID int,
  Customs_Code int,
  PRIMARY KEY (Shipping_ID),
  CONSTRAINT Shipping_Invoice_Orders_fk FOREIGN KEY (Order_ID) REFERENCES orders(Orders_ID),
  CONSTRAINT Shipping_Invoice_Customs_fk FOREIGN KEY (Customs_Code) REFERENCES Customs(Code_ID));



INSERT INTO Fabric VALUES
(1, 'Leather', 100, 'Green', 'SkinnersINC', 'For when you want that swamp troll feel');
INSERT INTO Fabric VALUES
(2, 'Leather', 100, 'Black', 'SkinnersINC', 'Not much to say, its black leather');
INSERT INTO Fabric VALUES
(3, 'Wool', 200, 'Green', 'Woolers', 'Nice and sturdy material for everyday use');
INSERT INTO Fabric VALUES
(4, 'Wool', 200, 'Brown', 'Woolers', 'Nice and sturdy material for everyday use');
INSERT INTO Fabric VALUES
(5, 'Silk', 400, 'Red', 'SilkRoad', 'Finest silk in the west');
INSERT INTO Fabric VALUES
(6, 'Silk', 400, 'Blue', 'SilkRoad', 'Finest silk in the west');
INSERT INTO Fabric VALUES
(7, 'Cotton', 50, 'White', 'CottonEye', 'Eco-friendly');
INSERT INTO Fabric VALUES
(8, 'Cotton', 50, 'Purple', 'CottonEye', 'Eco-friendly');
INSERT INTO Fabric VALUES
(9, 'Cotton', 50, 'Orange', 'CottonEye', 'Eco-friendly');

INSERT INTO Standard_Hat(standard_hat_id, name, price, description, hat_fabric) VALUES
(1, 'Tophat', 599, 'A fine looking tophat for those fancy situations', 2);
INSERT INTO Standard_Hat(standard_hat_id, name, price, description, hat_fabric) VALUES
(2, 'Octoberhat', 399, NULL, 1);
INSERT INTO Standard_Hat(standard_hat_id, name, price, description, hat_fabric) VALUES
(3, 'Novemberhat', 549, NULL, 6);
INSERT INTO Standard_Hat(standard_hat_id, name, price, description, hat_fabric) VALUES
(4, 'Piratehat', 799, NULL, 5);

INSERT INTO Employee (Employee_ID, Username, Password, Name, Phone) VALUES
(1, 'Ottoadmin', 'Hats4Life', 'Otto', '123-456789');
INSERT INTO Employee (Employee_ID, Username, Password, Name, Phone) VALUES
(2, 'Judithadmin', 'Judith123', 'Judith', '123-456789');

INSERT INTO Hat VALUES
(1, 'FancyShrek', 799, 'XL', '', 0, 1, 1);
INSERT INTO Hat VALUES
(2, 'DarthVader', 1299, 'M', 'Insert description here', 0, 2, 1);



INSERT INTO Custom_Hat VALUES
(1);

INSERT INTO Special_Hat VALUES
(2, 'Insert image here');

INSERT INTO Address VALUES
(1, 'Stengatan', '12345', 'Stockholm', 'Sverige');
INSERT INTO Address VALUES
(2, 'Kustgatan', '12345', 'Kalmar', 'Sverige');

INSERT INTO Customer(customer_id, customer_nr, first_name, last_name, email, phone_nr, address, comment) VALUES
(1, 42758396, 'Kalle', 'Anka', 'Kalle@mail.se', '070-123456', 1, 'Is this a duck?');
INSERT INTO Customer(customer_id, customer_nr, first_name, last_name, email, phone_nr, address, comment) VALUES
(2, 96746534, 'Bert', 'Klaesson', 'Bert@mail.se', '076-987654', 2, NULL);
INSERT INTO Customer(customer_id, customer_nr, first_name, last_name, email, phone_nr, address, comment) VALUES
(3, 95673534, 'Ann-Kristin', 'Klaesson-Johnsson', 'Annkristin@mail.se', '076-982344', 1, NULL);
INSERT INTO Customer(customer_id, customer_nr, first_name, last_name, email, phone_nr, address, comment) VALUES
(4, 92485534, 'Claes-Göran', 'Von-Kristensson', 'Claesgoran@mail.se', '076-986543', 2, NULL);

INSERT INTO ORDERS(orders_id, total_price, delivery_date, order_date, status, delivery_address, customer, created_by) VALUES
(1, 1398, '2022-03-21', '2022-04-22', 'Ongoing', 1, 1, 1);
INSERT INTO ORDERS(orders_id, total_price, delivery_date, order_date, status, delivery_address, customer, created_by) VALUES
(2, 1299, '2022-03-27', '2022-04-06', 'Completed', 1, 1, 1);

INSERT INTO Ordered_St_Hat VALUES
('M', 1, 1);

INSERT INTO Ordered_Hat VALUES
(1, 1);
INSERT INTO Ordered_Hat VALUES
(2, 2);

INSERT INTO Customs VALUES
(1,'12345678');
INSERT INTO Customs VALUES
(2, '87654321');

INSERT INTO Shipping_Invoice VALUES
(1, '2022-04-01', 2, 1);

INSERT INTO Customer(customer_id, customer_nr, first_name, last_name, email, phone_nr, address, comment) VALUES
(5, 42758397, 'Kalle', 'And', 'Kalle@mail.se', '070-123456', 1, 'Is this a duck?');
INSERT INTO Customer(customer_id, customer_nr, first_name, last_name, email, phone_nr, address, comment) VALUES
(6, 96746535, 'Bert', 'Karlsson', 'Bert@mail.se', '076-987654', 2, NULL);
INSERT INTO Customer(customer_id, customer_nr, first_name, last_name, email, phone_nr, address, comment) VALUES
(7, 95673535, 'Kajsa', 'Anka', 'Annkristin@mail.se', '076-982344', 1, NULL);
INSERT INTO Customer(customer_id, customer_nr, first_name, last_name, email, phone_nr, address, comment) VALUES
(8, 92485535, 'Ida', 'And', 'Claesgoran@mail.se', '076-986543', 2, NULL);

select distinct name from Standard_Hat;




