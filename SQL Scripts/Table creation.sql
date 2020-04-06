--Cleaning existing data (ENSEIGANT)
DROP SEQUENCE enseignant_id;
DROP TABLE enseignant;
--Creating ENSEIGNANT
CREATE SEQUENCE enseignant_id START WITH 1 INCREMENT BY 1;
CREATE TABLE enseignant(
id_ens NUMBER(2), 
username VARCHAR2(16) UNIQUE,
password VARCHAR2(16),
nom VARCHAR2(30),
prenom VARCHAR2(30),
tel VARCHAR2(10),
CONSTRAINT pk_enseignant PRIMARY KEY(id_ens)
);


--Cleaning existing data (ETUDIANT)
DROP SEQUENCE etudiant_id;
DROP TABLE etudiant;
--Creating ETUDIANT
CREATE SEQUENCE etudiant_id START WITH 1 INCREMENT BY 1;
CREATE TABLE etudiant(
id_etu NUMBER(2),
username VARCHAR2(16) UNIQUE,
password VARCHAR2(16),
nom VARCHAR2(30),
prenom VARCHAR2(30),
email VARCHAR2(50),
groupNum NUMBER(2),
CONSTRAINT pk_etudiant PRIMARY KEY(id_etu),
CONSTRAINT fk_etu_gr FOREIGN KEY (groupNum) REFERENCES groupe(id_gr) ON DELETE SET NULL
);

--Cleaning existing data(GROUPE)
DROP SEQUENCE groupe_id;
DROP TABLE groupe;
--Creating GROUPE
CREATE SEQUENCE groupe_id START WITH 1 INCREMENT BY 1;
CREATE TABLE groupe(
id_gr NUMBER(2),
num NUMBER(2) UNIQUE,
cap NUMBER(2),
CONSTRAINT pk_groupe PRIMARY KEY(id_gr)
);







