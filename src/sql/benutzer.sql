DROP TABLE Benutzer;
CREATE TABLE Benutzer
( 
    art VARCHAR(255),
    username VARCHAR(255),
    password VARCHAR(255)
);

SELECT *
FROM Benutzer;

SELECT * 
FROM Benutzer
WHERE username='seehea16';

DELETE FROM Benutzer 
Where username = 'seewannHerbert';