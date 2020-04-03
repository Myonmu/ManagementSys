
CREATE TABLE enseignant(
id NUMBER(2), 
username VARCHAR2(16) UNIQUE,
password VARCHAR2(16),
nom VARCHAR2(30),
prenom VARCHAR2(30),
tel VARCHAR2(10),
profile_number NUMBER(2) UNIQUE,
CONSTRAINT pk_enseignant PRIMARY KEY(id)
);

CREATE TABLE etudiant(
id NUMBER(2),
username VARCHAR2(16) UNIQUE,
password VARCHAR2(16),
nom VARCHAR2(30),
prenom VARCHAR2(30),
email VARCHAR2(50),
profile_number NUMBER,
CONSTRAINT pk_etudiant PRIMARY KEY(id)
);
