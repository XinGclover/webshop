CREATE TABLE Categories ( 
    CategoryID INT NOT NULL GENERATED ALWAYS AS IDENTITY(START WITH 1, INCREMENT BY 1),
    CategoryName VARCHAR(15),
    Description VARCHAR(45),
    Picture VARCHAR(200),
    PRIMARY KEY (CategoryID)
);

CREATE TABLE Products 
(
    ProductID INT NOT NULL GENERATED ALWAYS AS IDENTITY(START WITH 1, INCREMENT BY 1),
    ProductName VARCHAR(40),
    CategoryID INT references Categories(CategoryID),
    QuantityPerUnit VARCHAR(20),
    UnitPrice DECIMAL(10,4),
    UnitsInStock INT,
    PRIMARY KEY (ProductID)
);

CREATE TABLE Orders 
(
    OrderID INT NOT NULL GENERATED ALWAYS AS IDENTITY(START WITH 1, INCREMENT BY 1),
    CustomerID INT,
    OrderPrice DECIMAL(10,4),
    OrderDate TIMESTAMP,
    PRIMARY KEY (OrderID)
);

CREATE TABLE OrderDetails 
(
    ID INT NOT NULL GENERATED ALWAYS AS IDENTITY(START WITH 1, INCREMENT BY 1),
    OrderID INT references Orders(OrderID),
    ProductID INT references Products(ProductID),
    Quantity INT,
    PRIMARY KEY (ID)
);

create table CUSTOMERS
(
	ID INT NOT NULL GENERATED ALWAYS AS IDENTITY(START WITH 1, INCREMENT BY 1),
	FirstName VARCHAR(50),
	LastName VARCHAR(50),
	Email VARCHAR(50),
	Address VARCHAR(50),
	Password VARCHAR(50),
	Premium SMALLINT default 0,
	Total_Money_Spent DOUBLE,
        PRIMARY KEY (ID)
);

create table ADMINS
(
	ID INT NOT NULL GENERATED ALWAYS AS IDENTITY(START WITH 1, INCREMENT BY 1),
	Email VARCHAR(20),
	Password VARCHAR(32),
        PRIMARY KEY (ID)
);








