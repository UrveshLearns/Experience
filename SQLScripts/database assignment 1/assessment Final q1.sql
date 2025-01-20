CREATE TABLE Author(
authorID INT PRIMARY KEY,
authorName nvarchar(20)
);

CREATE TABLE Book(
bookID INT PRIMARY KEY,
bookTitle nvarchar(20),
authorID INT REFERENCES Author
);

CREATE TABLE Reviewer(
reviewerID INT PRIMARY KEY,
reviewerName nvarchar(20),
);

CREATE TABLE Report(
reportID INT PRIMARY KEY,
reviewerID INT REFERENCES Reviewer,
bookID INT REFERENCES Book,
rating INT ,
CHECK (1<= rating and rating<=5),
dateReviewed nvarchar(20),
);
SELECT *FROM Author
SELECT *FROM Book
SELECT *FROM Reviewer
SELECT *FROM Report

INSERT INTO Author VALUES(1,'Shakespear');
INSERT INTO Author VALUES(2,'Place Holder');
INSERT INTO Author VALUES(3,'Holder Place');
INSERT INTO Author VALUES(4,'Jhon');

INSERT INTO Book VALUES(1,'Lord of the rings',1);
INSERT INTO Book VALUES(2,'Telltale',2);
INSERT INTO Book VALUES(3,'Kites',3);
INSERT INTO Book VALUES(4,'Celeste',4);

INSERT INTO Reviewer VALUES (1,'Bob')
INSERT INTO Reviewer VALUES (2,'May')
INSERT INTO Reviewer VALUES (3,'Smith')
INSERT INTO Reviewer VALUES (4,'Robin')
INSERT INTO Reviewer VALUES (5,'Stacy')
INSERT INTO Reviewer VALUES (6,'Austin')
INSERT INTO Reviewer VALUES (7,'Fred')
INSERT INTO Reviewer VALUES (8,'Caleb')

INSERT INTO Report VALUES (1,1,2,4,'20-12-2023')
INSERT INTO Report VALUES (2,1,2,1,'2-12-2023')
INSERT INTO Report VALUES (3,2,1,3,'20-1-2024')
INSERT INTO Report VALUES (4,2,4,4,'20-2-2024')
INSERT INTO Report VALUES (5,3,1,5,'20-3-2024')
INSERT INTO Report VALUES (6,6,2,1,'1-12-2023')
INSERT INTO Report VALUES (7,8,3,2,'1-11-2023')
INSERT INTO Report VALUES (8,4,4,1,'20-6-2024')




--author with my family name
SELECT Author.authorID, Author.authorName
From Author
WHERE authorName LIKE 'Place%';


--Rating for the corresponding book with the reviewers name
SELECT Book.bookTitle,Reviewer.reviewerName,Report.rating
From Report
LEFT JOIN Book on Report.bookID = Book.bookID
LEFT JOIN Reviewer ON Report.reviewerID= Reviewer.reviewerID
WHERE Book.bookID = 1;

--All book Titles with the reviewers name and their respective rating
SELECT Book.bookTitle,Reviewer.reviewerName,Report.dateReviewed
From Report
LEFT JOIN Book on Report.bookID = Book.bookID
LEFT JOIN Reviewer ON Report.reviewerID= Reviewer.reviewerID
ORDER BY bookTitle





