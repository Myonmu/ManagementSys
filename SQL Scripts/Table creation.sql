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

--Creating GROUPE
CREATE SEQUENCE groupe_id START WITH 1 INCREMENT BY 1;
CREATE TABLE groupe(
id_gr NUMBER(2),
num NUMBER(2) UNIQUE,
cap NUMBER(2),
CONSTRAINT pk_groupe PRIMARY KEY(id_gr)
);

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

--Creating COURS
CREATE SEQUENCE cours_id START WITH 1 INCREMENT BY 1;
CREATE TABLE cours(
id_cours NUMBER(2),
nom_cours VARCHAR(20) UNIQUE,
masse NUMBER(2),
ens_par NUMBER(2),
CONSTRAINT pk_cours PRIMARY KEY (id_cours),
CONSTRAINT fk_cours_ens FOREIGN KEY (ens_par) REFERENCES enseignant(id_ens) ON DELETE SET NULL
);

--Creating SESSION
CREATE SEQUENCE session_id START WITH 1 INCREMENT BY 1;
CREATE TABLE SESSION(
id_session NUMBER(2),
num_session NUMBER(2) UNIQUE,
date_debut DATE,
CONSTRAINT pk_session PRIMARY KEY (id_session)
);




