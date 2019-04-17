DROP DATABASE IF EXISTS northwind;

CREATE DATABASE IF NOT EXISTS northwind;

USE northwind;



CREATE TABLE `categories` (
    `Categoryid` INTEGER NOT NULL AUTO_INCREMENT,
    `CategoryName` VARCHAR(15) NOT NULL,
    `Description` MEDIUMTEXT,
    `Picture` LONGBLOB,
    CONSTRAINT `PK_categories` PRIMARY KEY (`Categoryid`)
);

CREATE INDEX `CategoryName` ON `categories` (`CategoryName`);







CREATE TABLE `customerdemographics` (
    `CustomerTypeid` VARCHAR(10) NOT NULL,
    `CustomerDesc` MEDIUMTEXT,
    CONSTRAINT `PK_customerdemographics` PRIMARY KEY (`CustomerTypeid`)
);

CREATE TABLE `customercustomerdemo` (
    `Customerid` VARCHAR(5) NOT NULL,
    `CustomerTypeid` VARCHAR(10) NOT NULL,
	CONSTRAINT `FK_customercustomerdemo` FOREIGN KEY (`CustomerTypeid`) REFERENCES `customerdemographics` (`CustomerTypeid`),
    CONSTRAINT `PK_customercustomerdemo` PRIMARY KEY (`Customerid`, `CustomerTypeid`)
	
);

CREATE TABLE `region` (
    `regionid` INTEGER NOT NULL,
    `regionDescription` VARCHAR(50) NOT NULL,
    CONSTRAINT `PK_region` PRIMARY KEY (`regionid`)
);

CREATE TABLE `territories` (
    `Territoryid` VARCHAR(20) NOT NULL,
    `TerritoryDescription` VARCHAR(50) NOT NULL,
    `regionid` INTEGER NOT NULL,
	CONSTRAINT `FK_territories_region` FOREIGN KEY (`regionid`) REFERENCES `region` (`regionid`),
    CONSTRAINT `PK_territories` PRIMARY KEY (`Territoryid`)
);

CREATE TABLE `customers` (
    `Customerid` VARCHAR(5) NOT NULL,
    `CompanyName` VARCHAR(40) NOT NULL,
    `ContactName` VARCHAR(30),
    `ContactTitle` VARCHAR(30),
    `Address` VARCHAR(60),
    `City` VARCHAR(15),
    `region` VARCHAR(15),
    `PostalCode` VARCHAR(10),
    `Country` VARCHAR(15),
    `Phone` VARCHAR(24),
    `Fax` VARCHAR(24),
    CONSTRAINT `PK_customers` PRIMARY KEY (`Customerid`)
);

CREATE INDEX `City` ON `customers` (`City`);

CREATE INDEX `CompanyName` ON `customers` (`CompanyName`);

CREATE INDEX `PostalCode` ON `customers` (`PostalCode`);

CREATE INDEX `region` ON `customers` (`region`);



CREATE TABLE `employees` (
    `Employeeid` INTEGER NOT NULL AUTO_INCREMENT,
    `LastName` VARCHAR(20) NOT NULL,
    `Password` VARCHAR(20),
    `FirstName` VARCHAR(10) NOT NULL,
    `Title` VARCHAR(30),
    `TitleOfCourtesy` VARCHAR(25),
    `BirthDate` DATETIME,
    `HireDate` DATETIME,
    `Address` VARCHAR(60),
    `City` VARCHAR(15),
    `region` VARCHAR(15),
    `PostalCode` VARCHAR(10),
    `Country` VARCHAR(15),
    `HomePhone` VARCHAR(24),
    `Extension` VARCHAR(4),
    `Photo` LONGBLOB,
    `Notes` MEDIUMTEXT NOT NULL,
    `ReportsTo` INTEGER,
    `PhotoPath` VARCHAR(255),
     `Salary` FLOAT,
	CONSTRAINT `FK_employees_employees` FOREIGN KEY (`ReportsTo`) REFERENCES `employees` (`Employeeid`),
    CONSTRAINT `PK_employees` PRIMARY KEY (`Employeeid`)
);

CREATE INDEX `LastName` ON `employees` (`LastName`);

CREATE INDEX `PostalCode` ON `employees` (`PostalCode`);



CREATE TABLE `employeeterritories` (
    `Employeeid` INTEGER NOT NULL,
    `Territoryid` VARCHAR(20) NOT NULL,
	CONSTRAINT `FK_employeeterritories_employees` FOREIGN KEY (`Employeeid`) REFERENCES `employees` (`Employeeid`),
	CONSTRAINT `FK_employeeterritories_territories` FOREIGN KEY (`Territoryid`) REFERENCES `territories` (`Territoryid`),
    CONSTRAINT `PK_employeeterritories` PRIMARY KEY (`Employeeid`, `Territoryid`)
);

CREATE TABLE `shippers` (
    `Shipperid` INTEGER NOT NULL AUTO_INCREMENT,
    `CompanyName` VARCHAR(40) NOT NULL,
    `Phone` VARCHAR(24),
    CONSTRAINT `PK_shippers` PRIMARY KEY (`Shipperid`)
);



CREATE TABLE `suppliers` (
    `Supplierid` INTEGER NOT NULL AUTO_INCREMENT,
    `CompanyName` VARCHAR(40) NOT NULL,
    `ContactName` VARCHAR(30),
    `ContactTitle` VARCHAR(30),
    `Address` VARCHAR(60),
    `City` VARCHAR(15),
    `region` VARCHAR(15),
    `PostalCode` VARCHAR(10),
    `Country` VARCHAR(15),
    `Phone` VARCHAR(24),
    `Fax` VARCHAR(24),
    `HomePage` MEDIUMTEXT,
    CONSTRAINT `PK_suppliers` PRIMARY KEY (`Supplierid`)
);


CREATE TABLE `orders` (
    `Orderid` int NOT NULL AUTO_INCREMENT,
    `Customerid` VARCHAR(5),
    `Employeeid` INTEGER,
    `OrderDate` DATETIME,
    `RequiredDate` DATETIME,
    `ShippedDate` DATETIME,
    `ShipVia` INTEGER,
    `Freight` DECIMAL(10,4) DEFAULT 0,
    `ShipName` VARCHAR(40),
    `ShipAddress` VARCHAR(60),
    `ShipCity` VARCHAR(15),
    `Shipregion` VARCHAR(15),
    `ShipPostalCode` VARCHAR(10),
    `ShipCountry` VARCHAR(15),
	CONSTRAINT `FK_orders_customers` FOREIGN KEY (`Customerid`) REFERENCES `customers` (`Customerid`),
	CONSTRAINT `FK_orders_employees` FOREIGN KEY (`Employeeid`) REFERENCES `employees` (`Employeeid`),
	CONSTRAINT `FK_orders_shippers` FOREIGN KEY (`ShipVia`) REFERENCES `shippers` (`Shipperid`),
    CONSTRAINT `PK_orders` PRIMARY KEY (`Orderid`)
);

CREATE TABLE `products` (
    `Productid` INTEGER NOT NULL AUTO_INCREMENT,
    `ProductName` VARCHAR(40) NOT NULL,
    `Supplierid` INTEGER,
    `Categoryid` INTEGER,
    `QuantityPerUnit` VARCHAR(20),
    `UnitPrice` DECIMAL(10,4) DEFAULT 0,
    `UnitsInStock` SMALLINT(2) DEFAULT 0,
    `UnitsOnOrder` SMALLINT(2) DEFAULT 0,
    `ReorderLevel` SMALLINT(2) DEFAULT 0,
    `Discontinued` BIT NOT NULL DEFAULT 0,
	CONSTRAINT `FK_products_categories` FOREIGN KEY (`Categoryid`) REFERENCES `categories` (`Categoryid`),
	CONSTRAINT `FK_products_suppliers` FOREIGN KEY (`Supplierid`) REFERENCES `suppliers` (`Supplierid`),
    CONSTRAINT `PK_products` PRIMARY KEY (`Productid`)
);


CREATE TABLE `order details` (
    `Orderid` INTEGER NOT NULL,
    `Productid` INTEGER NOT NULL,
    `UnitPrice` DECIMAL(10,4) NOT NULL DEFAULT 0,
    `Quantity` SMALLINT(2) NOT NULL DEFAULT 1,
    `Discount` REAL(8,0) NOT NULL DEFAULT 0,
	CONSTRAINT `FK_Order_Details_orders` FOREIGN KEY (`Orderid`) REFERENCES `orders` (`Orderid`),
	CONSTRAINT `FK_Order_Details_products` FOREIGN KEY (`Productid`) REFERENCES `products` (`Productid`),
    CONSTRAINT `PK_order details` PRIMARY KEY (`Orderid`, `Productid`)
);





CREATE INDEX `OrderDate` ON `orders` (`OrderDate`);

CREATE INDEX `ShippedDate` ON `orders` (`ShippedDate`);

CREATE INDEX `ShipPostalCode` ON `orders` (`ShipPostalCode`);





CREATE INDEX `ProductName` ON `products` (`ProductName`);









CREATE INDEX `CompanyName` ON `suppliers` (`CompanyName`);

CREATE INDEX `PostalCode` ON `suppliers` (`PostalCode`);



