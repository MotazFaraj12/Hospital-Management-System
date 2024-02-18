drop database IF EXISTS FinalDB;
create database FinalDB;
use FinalDB;

CREATE TABLE Patient (
Patient_id int(10) NOT NULL AUTO_INCREMENT, 
`Phone number` int(10) NOT NULL, 
Patient_name varchar(255) NOT NULL, 
address varchar(30) NOT NULL, 
Room_no int(10) NOT NULL, 
Nurse_id int(10) NOT NULL, 
PRIMARY KEY (Patient_id));

CREATE TABLE Bill (Bill_no int(10) NOT NULL AUTO_INCREMENT,
 Bill_amount int(10) NOT NULL, 
 Patient_id int(10) NOT NULL, 
 PRIMARY KEY (Bill_no)
 );

CREATE TABLE Room (Room_no int(10) NOT NULL AUTO_INCREMENT, 
Room_type varchar(30) NOT NULL, 
Period int(10) NOT NULL, 
PRIMARY KEY (Room_no)
);

CREATE TABLE Medicine (Medicine_id int(10) NOT NULL AUTO_INCREMENT,
Medicine_name varchar(30) NOT NULL, 
Price int(10) NOT NULL, 
PRIMARY KEY (Medicine_id)
);

CREATE TABLE Nurse (Nurse_id int(10) NOT NULL AUTO_INCREMENT,
Nurse_name int(10) NOT NULL, 
Shift varchar(30) NOT NULL, 
Salary int(11) NOT NULL, 
Address int(11) NOT NULL, 
PhoneNumber int(11) NOT NULL, 
Gender int(11) NOT NULL, 
PRIMARY KEY (Nurse_id)
);

CREATE TABLE Doctor (Doctor_id int(10) NOT NULL AUTO_INCREMENT, 
Specialty varchar(30) NOT NULL, 
Doctor_name varchar(30) NOT NULL, 
Address varchar(30) NOT NULL, 
Gender varchar(30) NOT NULL, 
PhoneNumber int(10) NOT NULL, 
Salary int(11) NOT NULL, 
PRIMARY KEY (Doctor_id)
);

CREATE TABLE Diagnosis (Diagnosis_no int(10) NOT NULL AUTO_INCREMENT, 
`Date` time(6) NOT NULL, 
Details varchar(50) NOT NULL, 
Severity varchar(30) NOT NULL,
Doctor_id int(10) NOT NULL, 
 PRIMARY KEY (Diagnosis_no));

CREATE TABLE Patient_Medicine (
Patient_id int(10) NOT NULL, 
Medicine_id int(10) NOT NULL, 
PRIMARY KEY (Patient_id, Medicine_id)
);

CREATE TABLE Patient_Doctor (
Patient_id int(10) NOT NULL, 
Doctor_id int(10) NOT NULL, 
PRIMARY KEY (Patient_id, Doctor_id)
);
ALTER TABLE Bill ADD CONSTRAINT FKBill306615 FOREIGN KEY (Patient_id) REFERENCES Patient (Patient_id);
ALTER TABLE Patient ADD CONSTRAINT FKPatient789131 FOREIGN KEY (Room_no) REFERENCES Room (Room_no);
ALTER TABLE Patient ADD CONSTRAINT FKPatient869526 FOREIGN KEY (Nurse_id) REFERENCES Nurse (Nurse_id);
ALTER TABLE Diagnosis ADD CONSTRAINT FKDiagnosis352334 FOREIGN KEY (Doctor_id) REFERENCES Doctor (Doctor_id);
ALTER TABLE Patient_Medicine ADD CONSTRAINT FKPatient_Me738844 FOREIGN KEY (Medicine_id) REFERENCES Medicine (Medicine_id);
ALTER TABLE Patient_Medicine ADD CONSTRAINT FKPatient_Me36309 FOREIGN KEY (Patient_id) REFERENCES Patient (Patient_id);
ALTER TABLE Patient_Doctor ADD CONSTRAINT FKPatient_Do322471 FOREIGN KEY (Doctor_id) REFERENCES Doctor (Doctor_id);
ALTER TABLE Patient_Doctor ADD CONSTRAINT FKPatient_Do800973 FOREIGN KEY (Patient_id) REFERENCES Patient (Patient_id);