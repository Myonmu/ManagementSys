--Cleaning existing data (ENSEIGANT)
DROP SEQUENCE enseignant_id;
DROP TABLE enseignant CASCADE CONSTRAINT;
--Cleaning existing data(GROUPE)
DROP SEQUENCE groupe_id;
DROP TABLE groupe CASCADE CONSTRAINT;
--Cleaning existing data (ETUDIANT)
DROP SEQUENCE etudiant_id;
DROP TABLE etudiant CASCADE CONSTRAINT;
--Cleaning existing data(Cours)
DROP SEQUENCE cours_id;
DROP TABLE cours CASCADE CONSTRAINT;
--Cleaning existing data(Session)
DROP SEQUENCE session_id;
DROP TABLE sess CASCADE CONSTRAINT;
--Cleaning existing data(Planning)
DROP SEQUENCE planning_id;
DROP TABLE planning CASCADE CONSTRAINT;
--Cleaning existing data(Type)
DROP SEQUENCE type_id;
DROP TABLE typeAbs CASCADE CONSTRAINT;
--Cleaning existing data(Justificatif)
DROP SEQUENCE just_id;
DROP TABLE justificatif CASCADE CONSTRAINT;
--Cleanning existing data(Absence)
DROP SEQUENCE absence_id;
DROP TABLE absence CASCADE CONSTRAINT;
--Cleanning constants
DROP TABLE constants;