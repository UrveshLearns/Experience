CREATE TABLE Medic(
medicID INT PRIMARY KEY,
medicName nvarchar(30)
);

CREATE TABLE Patient(
patientID INT PRIMARY KEY,
patientName nvarchar(30)
);

CREATE TABLE Herbal(
herbalID INT PRIMARY KEY,
herbalName nvarchar(30),
herbalUnit nvarchar(30),
pricePerUnit Money,
);

CREATE TABLE Diagnosis(
diagnosisID INT PRIMARY KEY,
patientID INT REFERENCES Patient,
medicID INT REFERENCES Medic,
descriptionOfDiagnosis nvarchar(60),
dateOfDiagnosis Date,
);

CREATE TABLE Prescription(
prescriptionID INT PRIMARY KEY,
diagnosisID INT REFERENCES Diagnosis,
medicID INT REFERENCES Medic,
herbalID INT REFERENCES Herbal,
unitPrescribed INT ,
datePrescribed DATE,
);



SELECT *FROM Medic
SELECT *FROM Patient
SELECT *FROM Herbal
SELECT *FROM Diagnosis
SELECT *FROM Prescription

INSERT INTO Medic VALUES(1,'Jhon')
INSERT INTO Medic VALUES(2,'Alan')
INSERT INTO Medic VALUES(3,'Bob')
INSERT INTO Medic VALUES(4,'Urvesh')

INSERT INTO Patient VALUES(1,'May')
INSERT INTO Patient VALUES(2,'Ram')
INSERT INTO Patient VALUES(3,'Shyam')
INSERT INTO Patient VALUES(4,'Rohan')
INSERT INTO Patient VALUES(5,'Lily')


INSERT INTO Herbal Values(1,'Dolo','Tablets','2')
INSERT INTO Herbal Values(2,'Aurvedic Painkiller','Capsule','8')
INSERT INTO Herbal Values(3,'Omee','Capsules','9')
INSERT INTO Herbal Values(4,'Homeopathic','Piece','6')
INSERT INTO Herbal Values(5,'Herbal Protien','1 kg', '10')

INSERT INTO Diagnosis Values(1,1,2,'high body temperature,potential fever','2024-08-01')
INSERT INTO Diagnosis Values(2,2,3,'Dislocated shoulder, rearranged','2024-08-10')
INSERT INTO Diagnosis Values(3,3,1,'from blood test,vitamin deficient','2024-08-11')
INSERT INTO Diagnosis Values(4,4,4,'mild cold','2024-08-20')
INSERT INTO Diagnosis Values(5,5,1,'stomach ache','2024-08-21')

INSERT INTO Prescription Values(1,1,1,1,2,'2024-08-02')
INSERT INTO Prescription Values(2,2,2,2,4,'2024-08-11')
INSERT INTO Prescription Values(3,3,3,5,1,'2024-08-12')
INSERT INTO Prescription Values(4,4,2,3,2,'2024-08-21')
INSERT INTO Prescription Values(5,5,4,3,1,'2024-08-22')
INSERT INTO Prescription VALUES(6,5,1,5,7,'2024-08-22')

-- ALL herbs with their price per unit and units prescribed
SELECT Prescription.prescriptionID, Herbal.herbalName, Prescription.unitPrescribed , Herbal.pricePerUnit
FROM Prescription, Herbal
WHERE Prescription.herbalID = Herbal.herbalID
AND PrescriptionId = 1

--DETAILS OF PRESCRIPTION ORDERD ALPHABETICALLY BY PATIENTS NAME
SELECT Patient.patientName,Prescription.datePrescribed,Prescription.prescriptionID,Medic.medicName
From Prescription
LEFT JOIN (Diagnosis LEFT JOIN  Patient ON Diagnosis.patientID = Patient.patientID)
ON Prescription.diagnosisID = Diagnosis.diagnosisID
LEFT JOIN Medic ON Prescription.medicID = Medic.medicID
ORDER BY Patient.patientName, Prescription.datePrescribed DESC
