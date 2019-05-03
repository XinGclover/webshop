CREATE TABLE Categories (
    CategoryID INT NOT NULL GENERATED ALWAYS AS IDENTITY(START WITH 1, INCREMENT BY 1),
    CategoryName VARCHAR(15),
    Description VARCHAR(45),
    Picture VARCHAR(200),
    PRIMARY KEY (CategoryID)
);

CREATE TABLE Products (
    ProductID INT NOT NULL GENERATED ALWAYS AS IDENTITY(START WITH 1, INCREMENT BY 1),
    ProductName VARCHAR(40),
    CategoryID INT references Categories(CategoryID),
    QuantityPerUnit VARCHAR(20),
    UnitPrice DECIMAL(10,4),
    UnitsInStock INT,
    PRIMARY KEY (ProductID)
);

CREATE TABLE Orders (
    OrderID INT NOT NULL GENERATED ALWAYS AS IDENTITY(START WITH 1, INCREMENT BY 1),
    CustomerID INT,
    OrderPrice DECIMAL,
    OrderDate TIMESTAMP,
    PRIMARY KEY (OrderID)
);

CREATE TABLE OrderDetails (
    ID INT NOT NULL GENERATED ALWAYS AS IDENTITY(START WITH 1, INCREMENT BY 1),
    OrderID INT references Orders(OrderID),
    ProductID INT references Products(ProductID),
    Quantity INT,
    PRIMARY KEY (ID)
);







