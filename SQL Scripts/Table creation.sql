
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



--Creating ETUDIANT
CREATE SEQUENCE etudiant_id START WITH 1 INCREMENT BY 1;
CREATE TABLE etudiant(
id_etu NUMBER(3),
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
nom_cours VARCHAR2(20) UNIQUE,
masse NUMBER(2),
ens_par NUMBER(2),
CONSTRAINT pk_cours PRIMARY KEY (id_cours),
CONSTRAINT fk_cours_ens FOREIGN KEY (ens_par) REFERENCES enseignant(id_ens) ON DELETE SET NULL

);

--Creating SESSION
CREATE SEQUENCE session_id START WITH 1 INCREMENT BY 1;
CREATE TABLE sess(
id_session NUMBER(2),
num_session NUMBER(2) UNIQUE,
date_debut DATE,
CONSTRAINT pk_session PRIMARY KEY (id_session)
);

--Creating PLANNING
CREATE SEQUENCE planning_id START WITH 1 INCREMENT BY 1;
CREATE TABLE planning(
id_planning NUMBER(4),
sess NUMBER(2),
mat NUMBER(2),
dow NUMBER(1),
horaire VARCHAR2(10),
type_cr VARCHAR2(10),
duree NUMBER(3),
gr NUMBER(2),
ens NUMBER(2),
CONSTRAINT pk_planning PRIMARY KEY(id_planning),
CONSTRAINT fk_pl_sess FOREIGN KEY(sess) REFERENCES sess(id_session) ON DELETE CASCADE,
CONSTRAINT fk_pl_cr FOREIGN KEY(mat) REFERENCES cours(id_cours) ON DELETE CASCADE,
CONSTRAINT fk_pl_gr FOREIGN KEY(gr) REFERENCES groupe(id_gr) ON DELETE SET NULL,
CONSTRAINT fk_pl_ens FOREIGN KEY(ens) REFERENCES enseignant(id_ens) ON DELETE SET NULL
);
--Creating typeAbs
CREATE SEQUENCE type_id START WITH 1 INCREMENT BY 1;
CREATE TABLE typeAbs(
id_type NUMBER(2),
nom VARCHAR2(25) UNIQUE,
CONSTRAINT pk_type PRIMARY KEY (id_type)
);
--Creating Justificatif
CREATE SEQUENCE just_id START WITH 1 INCREMENT BY 1;
CREATE TABLE justificatif(
id_just NUMBER(4),
trj VARCHAR2(200),
CONSTRAINT pk_just PRIMARY KEY(id_just)
);
--Creating Absence
CREATE SEQUENCE absence_id START WITH 1 INCREMENT BY 1;
CREATE TABLE absence(
id_abs NUMBER(4),
plan NUMBER(4),
week NUMBER(2),
etu NUMBER(4),
etat NUMBER(2),
just NUMBER(4),
commentaire VARCHAR2(50),
CONSTRAINT pk_abs PRIMARY KEY (id_abs),
CONSTRAINT fk_abs_plan FOREIGN KEY (plan) REFERENCES planning(id_planning) ON DELETE CASCADE,
CONSTRAINT fk_abs_etu FOREIGN KEY (etu) REFERENCES etudiant(id_etu) ON DELETE CASCADE,
CONSTRAINT fk_abs_etat FOREIGN KEY (etat) REFERENCES typeAbs(id_type) ON DELETE SET NULL,
CONSTRAINT fk_abs_just FOREIGN KEY (just) REFERENCES justificatif(id_just) ON DELETE SET NULL
);

--Creating Constants
CREATE TABLE constants(
description VARCHAR2(20),
constValue NUMBER(10),
CONSTRAINT pk_const PRIMARY KEY (description)
);
