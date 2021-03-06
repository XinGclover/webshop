DROP TABLE Admins;
DROP TABLE OrderDetails;
DROP TABLE Orders;
DROP TABLE Products;
DROP TABLE Categories;
DROP TABLE Customers;

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
    UnitPrice INT,
    UnitsInStock INT,
    PRIMARY KEY (ProductID)
);

CREATE TABLE Orders (
    OrderID INT NOT NULL GENERATED ALWAYS AS IDENTITY(START WITH 1, INCREMENT BY 1),
    CustomerID INT,
    OrderPrice DOUBLE,
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

create table CUSTOMERS
(
    ID INT NOT NULL GENERATED ALWAYS AS IDENTITY(START WITH 1, INCREMENT BY 1),
    FIRSTNAME VARCHAR(50),
    LASTNAME VARCHAR(50),
    EMAIL VARCHAR(50),
    ADDRESS VARCHAR(50),
    PASSWORD VARCHAR(50),
    PREMIUM SMALLINT default 0,
    TOTAL_MONEY_SPENT DOUBLE,
    PRIMARY KEY (ID)
);

create table ADMINS
(
    ID INT NOT NULL GENERATED ALWAYS AS IDENTITY(START WITH 1, INCREMENT BY 1),
    EMAIL VARCHAR(20),
    PASSWORD VARCHAR(32),
    PRIMARY KEY (ID)
);

INSERT INTO Categories VALUES(default,'Beverages','Soft drinks, coffees, teas, beers, and ales','img/01.jpg');
INSERT INTO Categories VALUES(default,'Condiments','Sweet and savory sauces','img/01.jpg');
INSERT INTO Categories VALUES(default,'Dairy Products','Cheeses','img/01.jpg');
INSERT INTO Categories VALUES(default,'Meat/Poultry','Prepared meats','img/01.jpg');
INSERT INTO Categories VALUES(default,'Seafood','Seaweed and fish','img/01.jpg');

INSERT INTO Products VALUES(default, 'Chai', 1, '10 boxes x 20 bags', 500000, 39);
INSERT INTO Products VALUES(default, 'Chang', 1, '24 - 12 oz bottles', 19000, 12);
INSERT INTO Products VALUES(default, 'Aniseed Syrup', 2, '12 - 550 ml bottles', 10000, 13);
INSERT INTO Products VALUES(default, 'Chef Anton''s Cajun Seasoning', 2, '43 - 4 oz jars', 22000, 53);
INSERT INTO Products VALUES(default, 'Chef Anton''s Gumbo Mix', 2, '34 boxes', 21000, 20);
INSERT INTO Products VALUES(default, 'Grandma''s Boysenberry Spread',  2, '12 - 3 oz jars', 25000, 120);
INSERT INTO Products VALUES(default, 'Uncle Bob''s Organic Dried Pears', 2, '12 - 1 lb pkgs.', 30000, 15);
INSERT INTO Products VALUES(default, 'Northwoods Cranberry Sauce',  2, '12 - 12 oz jars', 40000, 4);
INSERT INTO Products VALUES(default, 'Mishi Kobe Niku', 4, '13 - 500 g pkgs.', 92000, 29);
INSERT INTO Products VALUES(default, 'Ikura',  3, '12 - 200 ml jars', 31000, 31);
INSERT INTO Products VALUES(default, 'Queso Cabrales',  4, '1 kg pkg.', 21000, 22);
INSERT INTO Products VALUES(default, 'Queso Manchego La Pastora',  4, '10 - 500 g pkgs.', 33000, 34);
INSERT INTO Products VALUES(default, 'Konbu',  3, '2 kg box', 4000, 24);
INSERT INTO Products VALUES(default, 'Tofu',  2, '40 - 100 g pkgs.', 23000, 35);
INSERT INTO Products VALUES(default, 'Genen Shouyu',  2, '24 - 250 ml bottles', 15000, 39);
INSERT INTO Products VALUES(default, 'Pavlova',  3, '32 - 500 g boxes', 12000, 29);
INSERT INTO Products VALUES(default, 'Alice Mutton',  4, '20 - 1 kg tins', 39000, 31);
INSERT INTO Products VALUES(default, 'Carnarvon Tigers',  3, '14 kg pkg.', 42000, 42);
INSERT INTO Products VALUES(default, 'Teatime Chocolate Biscuits',  3, '10 boxes x 12 pieces', 9000, 25);
INSERT INTO Products VALUES(default, 'Sir Rodney''s Marmalade',  3, '30 gift boxes', 31000, 40);
INSERT INTO Products VALUES(default, 'Sir Rodney''s Scones', 3, '24 pkgs. x 4 pieces', 10000, 43);
INSERT INTO Products VALUES(default, 'Gustaf''s Knckebrd',  5, '24 - 500 g pkgs.', 21000, 104);
INSERT INTO Products VALUES(default, 'Tunnbrd',  5, '12 - 250 g pkgs.', 9000, 41);
INSERT INTO Products VALUES(default, 'Guaran Fantstica',  1, '12 - 355 ml cans', 4000, 20);
INSERT INTO Products VALUES(default, 'NuNuCa Nu-Nougat-Creme',  3, '20 - 450 g glasses', 14000, 24);
INSERT INTO Products VALUES(default, 'Gumbr Gummibrchen',  3, '100 - 250 g bags', 31000, 65);
INSERT INTO Products VALUES(default, 'Schoggi Schokolade',  3, '100 - 100 g pieces', 43000, 49);
INSERT INTO Products VALUES(default, 'Rssle Sauerkraut',  2, '25 - 325 g cans', 45000, 24);
INSERT INTO Products VALUES(default, 'Thringer Rostbratwurst',  4, '50 bags x 30 sausgs.', 123000, 41);
INSERT INTO Products VALUES(default, 'Nord-Ost Matjeshering', 3, '10 - 200 g glasses', 25000, 64);
INSERT INTO Products VALUES(default, 'Gorgonzola Telino',  4, '12 - 100 g pkgs', 12000, 23);
INSERT INTO Products VALUES(default, 'Mascarpone Fabioli',  4, '24 - 200 g pkgs.', 32000, 9);
INSERT INTO Products VALUES(default, 'Geitost',  4, '500 g', 5000, 112);
INSERT INTO Products VALUES(default, 'Sasquatch Ale', 1, '24 - 12 oz bottles', 14000, 111);
INSERT INTO Products VALUES(default, 'Steeleye Stout',  1, '24 - 12 oz bottles', 13000, 20);
INSERT INTO Products VALUES(default, 'Inlagd Sill', 3, '24 - 250 g  jars', 19000, 112);
INSERT INTO Products VALUES(default, 'Gravad lax',  3, '12 - 500 g pkgs.', 24000, 31);
INSERT INTO Products VALUES(default, 'Cte de Blaye',  1, '12 - 25 cl bottles', 243000, 82);
INSERT INTO Products VALUES(default, 'Chartreuse verte',  1, '250 cc per bottle', 13000, 49);
INSERT INTO Products VALUES(default, 'Boston Crab Meat',  3, '24 - 4 oz tins', 13000, 123);
INSERT INTO Products VALUES(default, 'Jack''s New England Clam Chowder',  3, '12 - 12 oz cans', 9000, 35);
INSERT INTO Products VALUES(default, 'Singaporean Hokkien Fried Mee',  5, '32 - 1 kg pkgs.', 14000, 24);
INSERT INTO Products VALUES(default, 'Ipoh Coffee',  1, '14 - 500 g tins', 44000, 42);
INSERT INTO Products VALUES(default, 'Gula Malacca',  2, '20 - 2 kg bags', 19000, 22);
INSERT INTO Products VALUES(default, 'Rogede sild',  3, '1k pkg.', 9000, 85);
INSERT INTO Products VALUES(default, 'Spegesild',  3, '4 - 450 g glasses', 12000, 95);
INSERT INTO Products VALUES(default, 'Zaanse koeken',  3, '10 - 4 oz boxes', 9000, 34);
INSERT INTO Products VALUES(default, 'Chocolade',  3, '10 pkgs.', 12000, 45);
INSERT INTO Products VALUES(default, 'Maxilaku',  3, '24 - 50 g pkgs.', 20000, 70);
INSERT INTO Products VALUES(default, 'Valkoinen suklaa',  3, '12 - 100 g bars', 14000, 45);
INSERT INTO Products VALUES(default, 'Manjimup Dried Apples', 2, '50 - 300 g pkgs.', 53000, 50);
INSERT INTO Products VALUES(default, 'Filo Mix',  5, '14 - 2 kg boxes', 2000, 33);
INSERT INTO Products VALUES(default, 'Perth Pasties', 4, '43 pieces', 32000, 81);
INSERT INTO Products VALUES(default, 'Tourtire',  4, '14 pies', 20000, 31);
INSERT INTO Products VALUES(default, 'Pt chinois',  4, '24 boxes x 2 pies', 24000, 115);
INSERT INTO Products VALUES(default, 'Gnocchi di nonna Alice', 5, '24 - 250 g pkgs.', 33000, 41);

INSERT INTO Customers VALUES(default, 'Ettan', 'Etsson', 'ettan.ettson@mail.nu', 'Ettgatan 1, 12301, Ettan', 'Losen1', 0, 155000);
INSERT INTO Customers VALUES(default, 'Tvåan', 'Tvåson', 'tvåan.tvåson@mail.nu', 'Tvågatan 2,12302,Tvåan', 'Losen2', 0, 230000);
INSERT INTO Customers VALUES(default, 'Trean', 'Treson', 'trean.treson@mail.nu', 'Tregatan 3, 12303, Trean', 'Losen3', 0, 222000);
INSERT INTO Customers VALUES(default, 'Fyran', 'Fyrson', 'fyran.fyrson@mail.nu', 'Fyrgatan 4,12304,Fyran', 'Losen4', 0, 0);
INSERT INTO Customers VALUES(default, 'Femman', 'Femson', 'femman.femson@mail.nu', 'Femgatan 5,12305,Femman', 'Losen5', 0, 0);
INSERT INTO Customers VALUES(default, 'Sexan', 'Sexson', 'sexan.sexson@mail.nu', 'Sexgatan 6,12306, Sexan', 'Losen6', 0, 0);
INSERT INTO Customers VALUES(default, 'Sjuan', 'Sjuson', 'sjuan.sjuson@mail.nu', 'Sjugatan 7,12307,Sjuan', 'Losen7', 0, 0);
INSERT INTO Customers VALUES(default, 'Åttan', 'Åttson', 'åttan.åttson@mail.nu', 'Åttgatan 8, 12308, Åttan', 'Losen8', 0, 0);
INSERT INTO Customers VALUES(default, 'Nian', 'Nison', 'nian.nison@mail.nu', 'Niagatan 9, 12309, Nian', 'Losen9', 0, 0);
INSERT INTO Customers VALUES(default, 'Tian', 'Tison', 'tian.tison@mail.nu', 'Tiagatan 10,12310,Tian', 'Losen10', 0, 0);
INSERT INTO Customers VALUES(default, 'Elvan', 'Elvson', 'elvan.elvson@mail.nu', 'Elvgatan 11, 12311, Elvan', 'Losen11', 0, 0);
INSERT INTO Customers VALUES(default, 'Tolvan', 'Tolvson', 'tolvan.tolvson@mail.nu', 'Tolvgatan 12,12312,Tolvan', 'Losen12', 0, 0);
INSERT INTO Customers VALUES(default, 'Trettonet', 'Trettson', 'trettonet.trettson@mail.nu', 'Tregatan 13,12313,Trettonet', 'Losen13', 0, 0);
INSERT INTO Customers VALUES(default, 'Fjortonet', 'Fjortson', 'fjortonet.fjortson@mail.nu', 'Fjortgatan 14,12314,Fjortonet', 'Losen14', 0, 0);
INSERT INTO Customers VALUES(default, 'Femtonet', 'Femtson', 'femtonet.femtson@mail.nu', 'Femgatan 15,12315,Femtonet', 'Losen15', 0, 0);
INSERT INTO Customers VALUES(default, 'Sextonet', 'Sextson', 'sextonet.sextson@mail.nu', 'Sexgatan 16, 12316, Sextonet', 'Losen16', 1, 500000);
INSERT INTO Customers VALUES(default, 'Sjuttonet', 'Sjuttson', 'sjuttonet.sjuttson@mail.nu', 'Sjugatan 17,12317,Sjuttonet', 'Losen17', 1, 500000);
INSERT INTO Customers VALUES(default, 'Artonet', 'Artson', 'artonet.artson@mail.nu', 'Artgatan 18,12318,Artonet', 'Losen18', 1, 500000);
INSERT INTO Customers VALUES(default, 'Nittonet', 'Nittson', 'nittonet.nittson@mail.nu', 'Nitgatan 19,12319,Nittonet', 'Losen19', 1, 500000);
INSERT INTO Customers VALUES(default, 'Tjugan', 'Tjugson', 'tjugan.tjugson@mail.nu', 'Tjugatan 20,12320,Tjugan', 'Losen20', 1, 500000);

INSERT INTO Admins VALUES(default, 'admin.ettan@mail.nu', 'Admin1');
INSERT INTO Admins VALUES(default, 'admin.tvåan@mail.nu', 'Admin2');
INSERT INTO Admins VALUES(default, 'admin.trean@mail.nu', 'Admin3');
INSERT INTO Admins VALUES(default, 'admin.fyran@mail.nu', 'Admin4');
INSERT INTO Admins VALUES(default, 'admin.femman@mail.nu', 'Admin5');


INSERT INTO Orders VALUES(default, 1, 155000, CURRENT_TIMESTAMP);
INSERT INTO Orders VALUES(default, 2, 230000, CURRENT_TIMESTAMP);
INSERT INTO Orders VALUES(default, 3, 47000, CURRENT_TIMESTAMP);
INSERT INTO Orders VALUES(default, 3, 115000, CURRENT_TIMESTAMP);
INSERT INTO Orders VALUES(default, 3, 60000, CURRENT_TIMESTAMP);
INSERT INTO Orders VALUES(default, 4, 0, CURRENT_TIMESTAMP);
INSERT INTO Orders VALUES(default, 4, 0, CURRENT_TIMESTAMP);
INSERT INTO Orders VALUES(default, 4, 0, CURRENT_TIMESTAMP);
INSERT INTO Orders VALUES(default, 4, 0, CURRENT_TIMESTAMP);
INSERT INTO Orders VALUES(default, 4, 0, CURRENT_TIMESTAMP);
INSERT INTO Orders VALUES(default, 5, 0, CURRENT_TIMESTAMP);
INSERT INTO Orders VALUES(default, 5, 0, CURRENT_TIMESTAMP);
INSERT INTO Orders VALUES(default, 6, 0, CURRENT_TIMESTAMP);
INSERT INTO Orders VALUES(default, 6, 0, CURRENT_TIMESTAMP);
INSERT INTO Orders VALUES(default, 7, 0, CURRENT_TIMESTAMP);
INSERT INTO Orders VALUES(default, 7, 0, CURRENT_TIMESTAMP);
INSERT INTO Orders VALUES(default, 7, 0, CURRENT_TIMESTAMP);
INSERT INTO Orders VALUES(default, 8, 0, CURRENT_TIMESTAMP);
INSERT INTO Orders VALUES(default, 8, 0, CURRENT_TIMESTAMP);
INSERT INTO Orders VALUES(default, 8, 0, CURRENT_TIMESTAMP);
INSERT INTO Orders VALUES(default, 8, 0, CURRENT_TIMESTAMP);
INSERT INTO Orders VALUES(default, 9, 0, CURRENT_TIMESTAMP);
INSERT INTO Orders VALUES(default, 9, 0, CURRENT_TIMESTAMP);
INSERT INTO Orders VALUES(default, 10, 0, CURRENT_TIMESTAMP);
INSERT INTO Orders VALUES(default, 10, 0, CURRENT_TIMESTAMP);
INSERT INTO Orders VALUES(default, 11, 0, CURRENT_TIMESTAMP);
INSERT INTO Orders VALUES(default, 11, 0, CURRENT_TIMESTAMP);
INSERT INTO Orders VALUES(default, 11, 0, CURRENT_TIMESTAMP);
INSERT INTO Orders VALUES(default, 12, 0, CURRENT_TIMESTAMP);
INSERT INTO Orders VALUES(default, 12, 0, CURRENT_TIMESTAMP);
INSERT INTO Orders VALUES(default, 13, 0, CURRENT_TIMESTAMP);
INSERT INTO Orders VALUES(default, 13, 0, CURRENT_TIMESTAMP);
INSERT INTO Orders VALUES(default, 13, 0, CURRENT_TIMESTAMP);
INSERT INTO Orders VALUES(default, 13, 0, CURRENT_TIMESTAMP);
INSERT INTO Orders VALUES(default, 14, 0, CURRENT_TIMESTAMP);
INSERT INTO Orders VALUES(default, 15, 0, CURRENT_TIMESTAMP);
INSERT INTO Orders VALUES(default, 16, 0, CURRENT_TIMESTAMP);
INSERT INTO Orders VALUES(default, 16, 0, CURRENT_TIMESTAMP);
INSERT INTO Orders VALUES(default, 17, 0, CURRENT_TIMESTAMP);
INSERT INTO Orders VALUES(default, 17, 0, CURRENT_TIMESTAMP);
INSERT INTO Orders VALUES(default, 18, 700000, CURRENT_TIMESTAMP);
INSERT INTO Orders VALUES(default, 19, 500000, CURRENT_TIMESTAMP);
INSERT INTO Orders VALUES(default, 19, 500000, CURRENT_TIMESTAMP);
INSERT INTO Orders VALUES(default, 19, 500000, CURRENT_TIMESTAMP);
INSERT INTO Orders VALUES(default, 20, 500000, CURRENT_TIMESTAMP);


INSERT INTO Orderdetails VALUES(default, 1, 10, 5);
INSERT INTO Orderdetails VALUES(default, 2, 13, 5);
INSERT INTO Orderdetails VALUES(default, 2, 12, 5);
INSERT INTO Orderdetails VALUES(default, 2, 45, 5);
INSERT INTO Orderdetails VALUES(default, 3, 23, 1);
INSERT INTO Orderdetails VALUES(default, 3, 54, 1);
INSERT INTO Orderdetails VALUES(default, 3, 23, 1);
INSERT INTO Orderdetails VALUES(default, 3, 45, 1);
INSERT INTO Orderdetails VALUES(default, 4, 51, 1);
INSERT INTO Orderdetails VALUES(default, 4, 19, 1);
INSERT INTO Orderdetails VALUES(default, 4, 42, 1);
INSERT INTO Orderdetails VALUES(default, 4, 17, 1);
INSERT INTO Orderdetails VALUES(default, 5, 24, 1);
INSERT INTO Orderdetails VALUES(default, 5, 10, 1);
INSERT INTO Orderdetails VALUES(default, 5, 13, 1);
INSERT INTO Orderdetails VALUES(default, 5, 5, 1);
INSERT INTO Orderdetails VALUES(default, 6, 7, 1);
INSERT INTO Orderdetails VALUES(default, 6, 19, 1);
INSERT INTO Orderdetails VALUES(default, 6, 6, 1);
INSERT INTO Orderdetails VALUES(default, 6, 50, 1);
INSERT INTO Orderdetails VALUES(default, 6, 30, 1);
INSERT INTO Orderdetails VALUES(default, 7, 35, 1);
INSERT INTO Orderdetails VALUES(default, 7, 37, 1);
INSERT INTO Orderdetails VALUES(default, 7, 26, 1);
INSERT INTO Orderdetails VALUES(default, 7, 16, 1);
INSERT INTO Orderdetails VALUES(default, 7, 51, 1);
INSERT INTO Orderdetails VALUES(default, 7, 16, 1);
INSERT INTO Orderdetails VALUES(default, 8, 27, 1);
INSERT INTO Orderdetails VALUES(default, 8, 28, 1);
INSERT INTO Orderdetails VALUES(default, 8, 12, 1);
INSERT INTO Orderdetails VALUES(default, 8, 1, 1);
INSERT INTO Orderdetails VALUES(default, 8, 18, 1);
INSERT INTO Orderdetails VALUES(default, 8, 27, 1);
INSERT INTO Orderdetails VALUES(default, 9, 35, 1);
INSERT INTO Orderdetails VALUES(default, 9, 7, 1);
INSERT INTO Orderdetails VALUES(default, 10, 42, 1);
INSERT INTO Orderdetails VALUES(default, 10, 33, 1);
INSERT INTO Orderdetails VALUES(default, 11, 44, 1);
INSERT INTO Orderdetails VALUES(default, 11, 53, 1);
INSERT INTO Orderdetails VALUES(default, 11, 26, 1);
INSERT INTO Orderdetails VALUES(default, 11, 36, 1);
INSERT INTO Orderdetails VALUES(default, 11, 25, 1);
INSERT INTO Orderdetails VALUES(default, 12, 32, 1);
INSERT INTO Orderdetails VALUES(default, 12, 51, 1);
INSERT INTO Orderdetails VALUES(default, 12, 43, 1);
INSERT INTO Orderdetails VALUES(default, 12, 40, 1);
INSERT INTO Orderdetails VALUES(default, 13, 37, 1);
INSERT INTO Orderdetails VALUES(default, 13, 43, 1);
INSERT INTO Orderdetails VALUES(default, 14, 10, 1);
INSERT INTO Orderdetails VALUES(default, 14, 7, 1);
INSERT INTO Orderdetails VALUES(default, 15, 40, 1);
INSERT INTO Orderdetails VALUES(default, 16, 36, 1);
INSERT INTO Orderdetails VALUES(default, 16, 38, 1);
INSERT INTO Orderdetails VALUES(default, 16, 55, 1);
INSERT INTO Orderdetails VALUES(default, 17, 35, 1);
INSERT INTO Orderdetails VALUES(default, 17, 38, 1);
INSERT INTO Orderdetails VALUES(default, 18, 54, 1);
INSERT INTO Orderdetails VALUES(default, 19, 37, 1);
INSERT INTO Orderdetails VALUES(default, 19, 16, 1);
INSERT INTO Orderdetails VALUES(default, 20, 46, 1);
INSERT INTO Orderdetails VALUES(default, 21, 37, 1);
INSERT INTO Orderdetails VALUES(default, 21, 8, 1);
INSERT INTO Orderdetails VALUES(default, 22, 50, 1);
INSERT INTO Orderdetails VALUES(default, 22, 47, 1);
INSERT INTO Orderdetails VALUES(default, 22, 10, 1);
INSERT INTO Orderdetails VALUES(default, 23, 15, 1);
INSERT INTO Orderdetails VALUES(default, 23, 1, 1);
INSERT INTO Orderdetails VALUES(default, 24, 5, 1);
INSERT INTO Orderdetails VALUES(default, 25, 2, 1);
INSERT INTO Orderdetails VALUES(default, 25, 47, 1);
INSERT INTO Orderdetails VALUES(default, 26, 9, 1);
INSERT INTO Orderdetails VALUES(default, 26, 10, 1);
INSERT INTO Orderdetails VALUES(default, 26, 25, 1);
INSERT INTO Orderdetails VALUES(default, 27, 36, 1);
INSERT INTO Orderdetails VALUES(default, 27, 47, 1);
INSERT INTO Orderdetails VALUES(default, 27, 27, 1);
INSERT INTO Orderdetails VALUES(default, 28, 24, 1);
INSERT INTO Orderdetails VALUES(default, 28, 44, 1);
INSERT INTO Orderdetails VALUES(default, 28, 12, 1);
INSERT INTO Orderdetails VALUES(default, 29, 11, 1);
INSERT INTO Orderdetails VALUES(default, 29, 19, 1);
INSERT INTO Orderdetails VALUES(default, 29, 14, 1);
INSERT INTO Orderdetails VALUES(default, 29, 16, 1);
INSERT INTO Orderdetails VALUES(default, 30, 37, 1);
INSERT INTO Orderdetails VALUES(default, 31, 6, 1);
INSERT INTO Orderdetails VALUES(default, 32, 15, 1);
INSERT INTO Orderdetails VALUES(default, 33, 24, 1);
INSERT INTO Orderdetails VALUES(default, 33, 13, 1);
INSERT INTO Orderdetails VALUES(default, 33, 46, 1);
INSERT INTO Orderdetails VALUES(default, 34, 44, 1);
INSERT INTO Orderdetails VALUES(default, 34, 33, 1);
INSERT INTO Orderdetails VALUES(default, 35, 22, 1);
INSERT INTO Orderdetails VALUES(default, 35, 55, 1);
INSERT INTO Orderdetails VALUES(default, 35, 37, 1);
INSERT INTO Orderdetails VALUES(default, 36, 42, 1);
INSERT INTO Orderdetails VALUES(default, 36, 53, 1);
INSERT INTO Orderdetails VALUES(default, 37, 10, 1);
INSERT INTO Orderdetails VALUES(default, 37, 33, 1);
INSERT INTO Orderdetails VALUES(default, 37, 26, 1);
INSERT INTO Orderdetails VALUES(default, 38, 27, 1);
INSERT INTO Orderdetails VALUES(default, 38, 36, 1);
INSERT INTO Orderdetails VALUES(default, 38, 41, 1);
INSERT INTO Orderdetails VALUES(default, 39, 42, 1);
INSERT INTO Orderdetails VALUES(default, 39, 3, 1);
INSERT INTO Orderdetails VALUES(default, 40, 7, 1);
INSERT INTO Orderdetails VALUES(default, 40, 2, 1);
INSERT INTO Orderdetails VALUES(default, 41, 4, 1);
INSERT INTO Orderdetails VALUES(default, 41, 1, 1);
INSERT INTO Orderdetails VALUES(default, 42, 16, 1);
INSERT INTO Orderdetails VALUES(default, 42, 26, 1);
INSERT INTO Orderdetails VALUES(default, 42, 2, 1);
INSERT INTO Orderdetails VALUES(default, 42, 5, 1);
INSERT INTO Orderdetails VALUES(default, 43, 36, 1);
INSERT INTO Orderdetails VALUES(default, 44, 7, 1);
INSERT INTO Orderdetails VALUES(default, 44, 9, 1);
INSERT INTO Orderdetails VALUES(default, 44, 10, 1);
INSERT INTO Orderdetails VALUES(default, 45, 37, 1);
INSERT INTO Orderdetails VALUES(default, 45, 6, 1);
INSERT INTO Orderdetails VALUES(default, 45, 24, 1);