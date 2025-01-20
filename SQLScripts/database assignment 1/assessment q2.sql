CREATE TABLE Branch (
branchNo varchar(10) PRIMARY KEY,
street varchar(20),
city varchar(20),
postcode varchar(10)
);

CREATE TABLE Staff (
staffNo varchar(10) PRIMARY KEY,
fName nvarchar(20),
lName nvarchar(20),
position varchar(15),
sex char(1),
DOB datetime,
salary numeric(8,2),
branchNo varchar(10) FOREIGN KEY REFERENCES Branch
);

CREATE TABLE PrivateOwner (
ownerNo varchar(10) PRIMARY KEY,
fName nvarchar(20),
lName nvarchar(20),
Address varchar(40),
telNo varchar(15)
);

CREATE TABLE PropertyForRent (
propertyNo varchar(10) PRIMARY KEY,
street varchar(20),
city varchar(20),
postcode varchar(10),
type varchar(10) not null,
rooms numeric(2) default 4,
rent numeric(5,2) default 0,
ownerNo varchar(10) FOREIGN KEY REFERENCES PrivateOwner,
staffNo varchar(10) FOREIGN KEY REFERENCES Staff,
branchNo varchar(10) FOREIGN KEY REFERENCES Branch
);

CREATE TABLE Client (
clientNo varchar(10) PRIMARY KEY,
fName nvarchar(20),
lName nvarchar(20),
telNo varchar(15),
prefType varchar(10),
maxRent numeric(6,2),
eMail varchar(40)
);

CREATE TABLE Viewing (
clientNo varchar(10)
  constraint clientNo_fk FOREIGN KEY(clientNo) REFERENCES Client,
propertyNo varchar(10)
  FOREIGN KEY REFERENCES PropertyForRent,
viewDate datetime,
comment varchar(100),
constraint viewing_pk PRIMARY KEY(clientNo,propertyNo)
);


SET NOCOUNT ON

INSERT INTO Branch VALUES ('B002','56 Cover Drive','London','NW10 6EU');
INSERT INTO Branch VALUES ('B003','163 Main Street','Glasgow','G11 9QX');
INSERT INTO Branch VALUES ('B004','32 Manse Road','Bristol','BS99 1NZ');
INSERT INTO Branch VALUES ('B005','22 Deer Road','London','SW1 4EH');
INSERT INTO Branch VALUES ('B007','16 Argyll Street','Aberdeen','AB2 3SU');

-- uncomment following 6 lines if using locale australia
-- INSERT INTO Staff VALUES ('SA9','Mary','Howe','Assistant','F','19/2/1980',18000,'B007');
-- INSERT INTO Staff VALUES ('SG14','David','Ford','Supervisor','M','24/3/1968',36000,'B003');
-- INSERT INTO Staff VALUES ('SG37','Ann','Beech','Assistant','F','10/11/1970',24000,'B003');
-- INSERT INTO Staff VALUES ('SG5','Susan','Brand','Manager','F','3/6/1950',48000,'B003');
-- INSERT INTO Staff VALUES ('SL21','John','White','Manager','M','1/10/1955',60000,'B005');
-- INSERT INTO Staff VALUES ('SL41','Julie','Lee','Assistant','F','13/6/1975',18000,'B005');

-- using default locale (comment off following 6 lines if using australia locale)
INSERT INTO Staff VALUES ('SA9','Mary','Howe','Assistant','F','2/19/1980',18000,'B007');
INSERT INTO Staff VALUES ('SG14','David','Ford','Supervisor','M','3/24/1968',36000,'B003');
INSERT INTO Staff VALUES ('SG37','Ann','Beech','Assistant','F','11/10/1970',24000,'B003');
INSERT INTO Staff VALUES ('SG5','Susan','Brand','Manager','F','6/3/1950',48000,'B003');
INSERT INTO Staff VALUES ('SL21','John','White','Manager','M','10/1/1955',60000,'B005');
INSERT INTO Staff VALUES ('SL41','Julie','Lee','Assistant','F','6/13/1975',18000,'B005');

INSERT INTO Client VALUES ('CR56','Fred','Flintstone','555 1234','House',450,'fred@flintyrock.com');
INSERT INTO Client VALUES ('CR62','Wilma','Flintstone','555 1234','Flat',350,'wilma@flintyrock.com');
INSERT INTO Client VALUES ('CR74','Albert','Johnstone','555 6677','Flat',450,'albie@johnstone.com');
INSERT INTO Client VALUES ('CR77','Clark','Kent','555 9999','Flat',400,'clark@supersite.com');
INSERT INTO Client VALUES ('CR79','Joe','Bloggs','123 4567','House',450,'joe@paisley.com');
INSERT INTO Client VALUES ('CR83','Edward','Scissorhands','123 4567','House',300,'eddie@scix.com');
INSERT INTO Client VALUES ('CR91','Albert','Enistein','555 6789',NULL,450,'bert@nuclearintent.com');
INSERT INTO Client VALUES ('CR92','Snorrie','Sturrluson','333 4567',NULL,400,'snorrie@iceland.com');
INSERT INTO Client VALUES ('CR93','Ferdinand','Oblogiotta','123 5555','House',450,'ferdy@orage.com');
INSERT INTO Client VALUES ('CR94','Joe','Schmoe','123 45678','House',550,'joes@largy.com');
INSERT INTO Client VALUES ('CR95','Bill','Gates','123 5555','House',1000,'bill@gatesland.com');
INSERT INTO Client VALUES ('CR96','Bruce','Wayne','555 6789','House',900,'wayne@batty.com');

INSERT INTO PrivateOwner VALUES ('CO46', 'Joe', 'Keogh', '2 Fergus Dr, Aberdeen AB2 7SX', '01224-861212');
INSERT INTO PrivateOwner VALUES ('CO87', 'Carol', 'Farrel', '6 Achray St, Glasgow G32 9DX', '0141-357-7419');
INSERT INTO PrivateOwner VALUES ('CO40', 'Tina', 'Murphy', '63 Well St, Glasgow G42', '0141-943-1728');
INSERT INTO PrivateOwner VALUES ('CO93', 'Tony', 'Shaw', '12 Park Pl, Glasgow G4 0QR', '0141-225-7025');

INSERT INTO PropertyForRent VALUES ('PA14','16 Holhead','Aberdeen','AB7 5SU','House',6,650,'CO46','SA9','B007');
INSERT INTO PropertyForRent VALUES ('PG16','5 Novar Drive','Glasgow','G12 9AX','Flat',4,450,'CO93','SG14','B003');
INSERT INTO PropertyForRent VALUES ('PG21','18 Dale Road','Glasgow','G12','House',5,600,'CO87','SG37','B003');
INSERT INTO PropertyForRent VALUES ('PG36','2 Manor Road','Glasgow','G32 4QX','Flat',3,375,'CO93','SG37','B003');
INSERT INTO PropertyForRent VALUES ('PG4','6 Lawrence Street','Glasgow','G11 9QX','Flat',3,350,'CO40','SA9','B003');
INSERT INTO PropertyForRent VALUES ('PG97','Muir Drive','Aberdeen','AB42 1DD','House',3,380,'CO46','SA9','B007');
INSERT INTO PropertyForRent VALUES ('PL94','6 Argyll Street','London','NW2','Flat',4,400,'CO87','SL41','B005');

INSERT INTO Viewing VALUES ('CR56', 'PA14', '24-May-2018', 'too small');
INSERT INTO Viewing VALUES ('CR77', 'PG4', '20-April-2018', 'too remote');
INSERT INTO Viewing VALUES ('CR56', 'PG4', '5/26/2018', NULL );
INSERT INTO Viewing VALUES ('CR91', 'PA14', '14-May-2018', 'no dining room');
INSERT INTO Viewing VALUES ('CR56', 'PG36', '28-Apr-18', NULL );

SET NOCOUNT OFF


select * from Branch;
select * from Staff;
select * from PropertyForRent;
select * from Viewing;
select * from Client;
select * from PrivateOwner;


--updating staff member "Julie lee "
Update Staff
SET fname = 'Urvesh Rajendra', lName = 'Patel', DOB = '1990-08-01 00:00:00.000' , sex = 'M'
WHERE staffNo = 'SL41'
SELECT * FROM Staff

--Details of the staff who have annual salary more than 25000 
Select Staff.fName,Staff.lName,Staff.position,Staff.sex,staff.salary
From Staff
Where salary >= '25000'

--Property  and thier owner ordered alphabetically
SELECT PropertyForRent.propertyNo, PropertyForRent.postcode, PrivateOwner.fName, PrivateOwner.lName
FROM PropertyForRent
LEFT JOIN PrivateOwner ON PropertyForRent.ownerNo = PrivateOwner.ownerNo
ORDER BY PrivateOwner.fName

--PROPERTY VIEWED BY ONE OR MORE CLIENT
SELECT PropertyForRent.postcode, PropertyForRent.propertyNo,PropertyForRent.street,Staff.lName, Client.lName,Viewing.viewDate
from PropertyForRent,Viewing,Staff,Client
WHERE PropertyForRent.staffNo = Staff.staffNo
AND PropertyForRent.propertyNo = Viewing.propertyNo
AND Viewing.clientNo = Client.clientNo
ORDER BY PropertyForRent.postcode , PropertyForRent.street

--Property for rent with the city of the location ,staff member and thier branch 
SELECT PropertyForRent.propertyNo, PropertyForRent.city, Branch.city,Staff.branchNo,Staff.fName --not working
From PropertyForRent 
LEFT JOIN ( Staff LEFT JOIN Branch on Staff.branchNo = Branch.branchNo) ON PropertyForRent.staffNo = Staff.staffNo
WHERE PropertyForRent.branchNo = Branch.branchNo







