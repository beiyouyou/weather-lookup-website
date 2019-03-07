DROP DATABASE IF EXISTS Weather;
CREATE DATABASE Weather;
USE Weather;
CREATE TABLE User(
	userID INT(11) PRIMARY KEY auto_increment,
	username VARCHAR(50) NOT NULL,
	password VARCHAR(50) NOT NULL
);
INSERT INTO User(username,password)
	values('beiyouzh', 'beiyou'),
		  ('kerenli','keren');
CREATE TABLE Search(
	SearchID INT(11) PRIMARY KEY AUTO_INCREMENT,
    userID INT(11) NOT NULL,
    result VARCHAR(50) NOT NULL,
    foreign key (userID) references User(userID)
);
INSERT INTO Search(userID,result)
	values('1','Beijing'),
		('1', 'Hangzhou'),
        ('1','Hunan'),
        ('2','hangzhou');