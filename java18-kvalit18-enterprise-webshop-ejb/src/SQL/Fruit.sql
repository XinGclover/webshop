CREATE TABLE Fruit
(
    FruitID INT NOT NULL GENERATED ALWAYS AS IDENTITY(START WITH 1, INCREMENT BY 1),
    Fruit_name VARCHAR(40),
    Unit VARCHAR(40),
    Price INT,
    ImageURL VARCHAR(200),
    PRIMARY KEY (FruitId)   
);

INSERT INTO Fruit (Fruit_name,Unit,Price,ImageURL) VALUES ('Apple','1kg',30,'img/01.jpg');
INSERT INTO Fruit (Fruit_name,Unit,Price,ImageURL) VALUES ('Banana','1kg',30,'img/01.jpg');
INSERT INTO Fruit (Fruit_name,Unit,Price,ImageURL) VALUES ('Mango','1 piece',20,'img/01.jpg');
INSERT INTO Fruit (Fruit_name,Unit,Price,ImageURL) VALUES ('Orange','1kg',30,'img/01.jpg');
INSERT INTO Fruit (Fruit_name,Unit,Price,ImageURL) VALUES ('Pineapple','1 piece',30,'img/01.jpg');
INSERT INTO Fruit (Fruit_name,Unit,Price,ImageURL) VALUES ('Cherry','1 box',80,'img/01.jpg');
INSERT INTO Fruit (Fruit_name,Unit,Price,ImageURL) VALUES ('Grapes','1 box',30,'img/01.jpg');
INSERT INTO Fruit (Fruit_name,Unit,Price,ImageURL) VALUES ('Kiwi','1 piece',6,'img/01.jpg');
INSERT INTO Fruit (Fruit_name,Unit,Price,ImageURL) VALUES ('Lemon','1 piece',5,'img/01.jpg');
INSERT INTO Fruit (Fruit_name,Unit,Price,ImageURL) VALUES ('Pear','1kg',30,'img/01.jpg');

