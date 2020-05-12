--GESTIONNAIRE Sample data
INSERT INTO gestionnaire(id_gest,username,password)
VALUES
(gestionnaire_id.NEXTVAL,'0000','0000');
--ENSEIGNANT Sample data
INSERT INTO enseignant (id_ens,username,password,nom,prenom,tel)
VALUES
(enseignant_id.NEXTVAL,'GUNTER','GUNTER','PATRIKOV','GUNTER','00212498');
INSERT INTO enseignant (id_ens,username,password,nom,prenom,tel)
VALUES
(enseignant_id.NEXTVAL,'LOVECRAFT','LOVECRAFT','LOVECRAFT','H.P.','00327684');
INSERT INTO enseignant (id_ens,username,password,nom,prenom,tel)
VALUES
(enseignant_id.NEXTVAL,'WEST','WEST','WEST','HERBERT','00237563');
--GROUPE Sample data
INSERT INTO groupe (id_gr,num,cap)
VALUES
(groupe_id.NEXTVAL,1,30);
INSERT INTO groupe (id_gr,num,cap)
VALUES
(groupe_id.NEXTVAL,2,60);
INSERT INTO groupe (id_gr,num,cap)
VALUES
(groupe_id.NEXTVAL,3,45);
--ETUDIANT Sample data
INSERT INTO etudiant (id_etu,username,password,nom,prenom,email,groupNum)
VALUES
(etudiant_id.NEXTVAL,'SIMON','SIMON','PATRIKOV','SIMON','s.patrikov@mu.edu',1);
INSERT INTO etudiant (id_etu,username,password,nom,prenom,email,groupNum)
VALUES
(etudiant_id.NEXTVAL,'BAKER','BAKER','AGNES','BAKER','a.baker@mu.edu',1);
INSERT INTO etudiant (id_etu,username,password,nom,prenom,email,groupNum)
VALUES
(etudiant_id.NEXTVAL,'CARTER','CARTER','CARTER','RANDOLPH','r.carter@mu.edu',2);
--COURS Sample data
INSERT INTO cours (id_cours,nom_cours,masse,ens_par)
VALUES
(cours_id.NEXTVAL,'Metaphysics',60,2);
INSERT INTO cours (id_cours,nom_cours,masse,ens_par)
VALUES
(cours_id.NEXTVAL,'S.Anatomy',60,3);
INSERT INTO cours (id_cours,nom_cours,masse,ens_par)
VALUES
(cours_id.NEXTVAL,'Folklore',80,1);
--SESSION Sample data
INSERT INTO sess (id_session,num_session,date_debut)
VALUES
(session_id.NEXTVAL,1,'01/01/2000');
--PLANNING Sample data
INSERT INTO planning (id_planning,sess,mat,dow,horaire,type_cr,duree,gr,ens)
VALUES
(planning_id.NEXTVAL,1,1,1,'8:30','AMPHI',120,1,2);
INSERT INTO planning (id_planning,sess,mat,dow,horaire,type_cr,duree,gr,ens)
VALUES
(planning_id.NEXTVAL,1,1,2,'10:30','AMPHI',120,1,2);
INSERT INTO planning (id_planning,sess,mat,dow,horaire,type_cr,duree,gr,ens)
VALUES
(planning_id.NEXTVAL,1,1,4,'8:30','TD',120,1,2);
INSERT INTO planning (id_planning,sess,mat,dow,horaire,type_cr,duree,gr,ens)
VALUES
(planning_id.NEXTVAL,1,1,5,'8:30','TP',240,1,2);
INSERT INTO planning (id_planning,sess,mat,dow,horaire,type_cr,duree,gr,ens)
VALUES
(planning_id.NEXTVAL,1,2,2,'8:30','AMPHI',120,1,3);
INSERT INTO planning (id_planning,sess,mat,dow,horaire,type_cr,duree,gr,ens)
VALUES
(planning_id.NEXTVAL,1,2,1,'13:30','TP',240,1,3);
INSERT INTO planning (id_planning,sess,mat,dow,horaire,type_cr,duree,gr,ens)
VALUES
(planning_id.NEXTVAL,1,2,2,'13:30','TD',120,1,3);
INSERT INTO planning (id_planning,sess,mat,dow,horaire,type_cr,duree,gr,ens)
VALUES
(planning_id.NEXTVAL,1,3,3,'8:30','AMPHI',120,2,1);
INSERT INTO planning (id_planning,sess,mat,dow,horaire,type_cr,duree,gr,ens)
VALUES
(planning_id.NEXTVAL,1,3,3,'13:30','TD',120,2,1);
INSERT INTO planning (id_planning,sess,mat,dow,horaire,type_cr,duree,gr,ens)
VALUES
(planning_id.NEXTVAL,1,3,5,'13:30','AMPHI',120,2,1);
--TYPE_ABSENCE Sample data
INSERT INTO typeAbs (id_type,nom)
VALUES
(type_id.NEXTVAL,'EN TRAITEMENT');
INSERT INTO typeAbs (id_type,nom)
VALUES
(type_id.NEXTVAL,'EXCUSEE');
INSERT INTO typeAbs (id_type,nom)
VALUES
(type_id.NEXTVAL,'NON-EXCUSEE');
--Justificatif : NO SAMPLE DATA
--ABSENCE: NO SAMPLE DATA
--Constants
INSERT INTO constants(description,constValue)
VALUES('Quota',300);
