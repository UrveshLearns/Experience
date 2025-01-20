Create Table Client(
clientID NUMERIC PRIMARY KEY,
regular bit,
fname nvarchar(30),
lname nvarchar(30),
phoneNo nvarchar(30) ,
)


CREATE TABLE Therapist(
staffID NUMERIC PRIMARY KEY,
fname nvarchar(30),
lname nvarchar(30),
phoneNo nvarchar(30) ,
)

Create Table ServiceType(
serviceTypeID NUMERIC PRIMARY KEY,
serviceType nvarchar(30),
)

Create Table Service(
serviceID NUMERIC PRIMARY KEY,
serviceName nvarchar(30),
serviceType  Numeric REFERENCES ServiceType,
)


CREATE TABLE TherapistSpeciality(
therapistSpecalityID NUMERIC PRIMARY KEY,
staffID numeric REFERENCES Therapist ,
serviceID NUMERIC REFERENCES Service,
expertiseLevel NUMERIC CHECK(expertiseLevel > 0 and expertiseLevel <= 5)
)


Create Table ItemBasedService(
serviceID NUMERIC REFERENCES Service,
servicePrice Money ,
)


Create Table HourBasedService(
therapistSpecalityID NUMERIC REFERENCES TherapistSpeciality,
servicePrice Money ,
)


CREATE Table Booking(
bookingID NUMERIC PRIMARY KEY,
clientID NUMERIC REFERENCES Client ,
staffID NUMERIC  REFERENCES Therapist,
dateBooked date,
timeBookedFrom time,
timeBookedTo time,
)
/*
Drop table Client
Drop table Therapist
Drop table TherapistSpeciality
Drop table ServiceType
Drop table Service
Drop table ItemBasedService
Drop table HourBasedService
Drop table Booking
*/



select * from Therapist

select * from Client
select * from Booking
select * from Service
select * from TherapistSpeciality
select * from HourBasedService
select * from ServiceType
select * from ItemBasedService



INSERT INTO Client Values(1,0,'Jay','Smith','111111111')
INSERT INTO Client Values(2,0,'Pam','lia','222222222')
INSERT INTO Client Values(3,1,'Jhon','Liam','333333333')
INSERT INTO Client Values(4,1,'Ray','Line','444444444')
INSERT INTO Client Values(5,1,'Sara','kay','555555555')
INSERT INTO Client Values(6,1,'Paige','lackey','666666666')

INSERT INTO Therapist Values(1,'onety','five','777777777')
INSERT INTO Therapist Values(2,'six','seven','88888888')
INSERT INTO Therapist Values(3,'eight','nine','99999999')
INSERT INTO Therapist Values(4,'eleven','ten','191911919')

INSERT INTO ServiceType VALUES(1,'item based')
INSERT INTO ServiceType VALUES(2,'hour based')

INSERT INTO Service VALUES(1,'Manicure',2)
INSERT INTO Service VALUES(2,'Pedicure',2)
INSERT INTO Service VALUES(3,'Facial',2)
INSERT INTO Service VALUES(4,'Massage',2)
INSERT INTO Service VALUES(5,'Waxing',1)
INSERT INTO Service VALUES(6,'Threading',1)

INSERT INTO TherapistSpeciality VALUES (1,1,1,4)
INSERT INTO TherapistSpeciality VALUES (2,1,2,3)
INSERT INTO TherapistSpeciality VALUES (3,2,1,3)
INSERT INTO TherapistSpeciality VALUES (4,2,3,5)
INSERT INTO TherapistSpeciality VALUES (5,3,4,5)

INSERT INTO ItemBasedService VALUES (5,'20')
INSERT INTO ItemBasedService VALUES (6,'10')


INSERT INTO HourBasedService VALUES (1,'30')
INSERT INTO HourBasedService VALUES (2,'50')
INSERT INTO HourBasedService VALUES (3,'25')
INSERT INTO HourBasedService VALUES (4,'15')
INSERT INTO HourBasedService VALUES (5,'40')


INSERT INTO Booking VALUES (1, 1, 1, '2024-10-11', '10:00:00', '11:00:00') 
INSERT INTO Booking VALUES (2, 2, 2, '2024-10-12', '12:00:00', '13:00:00') 
INSERT INTO Booking VALUES (3, 3, 3, '2024-10-13', '14:00:00', '15:00:00') 
INSERT INTO Booking VALUES (4, 4, 4, '2024-10-14', '09:00:00', '10:00:00') 
INSERT INTO Booking VALUES (5, 1, 2, '2024-10-15', '11:00:00', '12:00:00') 
INSERT INTO Booking VALUES (6, 2, 1, '2024-10-16', '13:00:00', '14:00:00') 
INSERT INTO Booking VALUES (7, 3, 4, '2024-10-17', '15:00:00', '16:00:00') 
INSERT INTO Booking VALUES (8, 4, 3, '2024-10-18', '09:00:00', '10:30:00') 
INSERT INTO Booking VALUES (9, 5, 2, '2024-10-19', '14:00:00', '15:00:00') 
INSERT INTO Booking VALUES (10, 6, 1, '2024-10-20', '12:00:00', '13:00:00')
INSERT INTO Booking VALUES (11, 5, 1, '2024-10-11', '12:00:00', '13:00:00')

--List all the timed services along with the therapists who can provide such services. The list should be sorted alphabetically in the service names

SELECT T.fname, T.lname, S.serviceName 
FROM TherapistSpeciality AS TS
LEFT JOIN Therapist AS T ON TS.staffID = T.staffID
LEFT JOIN Service AS S ON TS.serviceID = S.serviceID
LEFT JOIN ServiceType AS ST ON S.serviceType = ST.serviceTypeID
WHERE ST.serviceType = 'hour based'  -- Ensure this matches your ServiceType entry
ORDER BY S.serviceName ASC;

-- For a given day, say, 2024-11-11, list all the names of the therapists who have/had at least one booking/appointment on that day. Don't repeat the names in the list
SELECT Distinct T.lname,T.fname
From Booking AS B
INNER JOIN Therapist as T on B.staffID = T.staffID
WHERE B.dateBooked = '2024-10-11'

--List the names of all the clients along with the corresponding total number of bookings.
SELECT C.fname , C.lname, COUNT(B.bookingID) as noOfBookings
From Booking  AS b 
INNER JOIN Client AS C on B.clientID = C.clientID
Group by C.fname , C.lname


--List all therapists and the corresponding therapeutic services they are registered to provide at the Beauty Salon. Sort the output according to their staff name, type of service (timed or itemised), and finally the name of the service.  


-- Timed services provided by specific therapists
SELECT  T.fname,T.lname,ST.serviceType,S.serviceName
FROM Therapist AS T
INNER JOIN TherapistSpeciality AS TS ON T.staffID = TS.staffID
INNER JOIN Service AS S ON TS.serviceID = S.serviceID
INNER JOIN ServiceType AS ST ON ST.serviceTypeID = S.serviceType
LEFT JOIN HourBasedService AS HS ON TS.therapistSpecalityID = HS.therapistSpecalityID
UNION
-- Item-based services provided by all therapists
SELECT  T.fname,T.lname,ST.serviceType,S.serviceName
FROM 
Therapist AS T
CROSS JOIN ItemBasedService AS IBS
INNER JOIN Service AS S ON IBS.serviceID = S.serviceID
INNER JOIN ServiceType AS ST ON ST.serviceTypeID = S.serviceType
ORDER BY lname, fname, serviceType,  serviceName;

-- For each timed service, list the names of the therapists whose hourly rates are the cheapest, along with their actual hourly rates
SELECT T.fname,T.lname,S.serviceName,HBS.servicePrice 
FROM Therapist AS T
INNER JOIN TherapistSpeciality AS TS ON T.staffID = TS.staffID   
INNER JOIN HourBasedService AS HBS ON TS.therapistSpecalityID = HBS.therapistSpecalityID
INNER JOIN Service AS S ON TS.serviceID = S.serviceID          
WHERE 
    HBS.servicePrice = (SELECT MIN(servicePrice)                
                        FROM HourBasedService
                        WHERE therapistSpecalityID = TS.therapistSpecalityID)
ORDER BY 
    S.serviceName, servicePrice; 

--Q3 3 
SELECT T.staffID, T.fname,T.lname,TS.serviceID
FROM 
Therapist AS T
INNER JOIN TherapistSpeciality AS TS ON T.staffID = TS.staffID
LEFT JOIN Service AS S ON TS.serviceID = S.serviceID
WHERE
S.serviceID IS NULL 
