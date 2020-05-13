
import java.awt.EventQueue;

import DAO.*;
import GUI.Menu_Authen;
import Other.Mail;

public class ManagementMain {

	public static void main(String[] args) {
		ConstantsDAO csDAO=new ConstantsDAO();
		csDAO.modifyQ(300);
		System.out.println(csDAO.readQ());
		Mail mail=new Mail();
		mail.sendMultiWarning();
		
		/*
		// TODO Auto-generated method stub
		Enseignant test=new Enseignant(1,"33333","0000","PATRIKOV","SIMON","00000000");
		EnseignantDAO testDAO=new EnseignantDAO();
		testDAO.add(test);
		test.randomizer();
		testDAO.modify(test);
		test.printAll();
		Etudiant etu1=new Etudiant(1,"123456","0000","WEST","HERBERT","HW@MU.EDU",0);
		EtudiantDAO etuDAO=new EtudiantDAO();
		etuDAO.add(etu1);
		System.out.println(etuDAO.login(etu1));

		GroupeDAO grDAO=new GroupeDAO();
		Groupe testGr=new Groupe(1, 1, 60);
		grDAO.add(testGr);
		etuDAO.assignTo(etu1, testGr);
		AbsenceType type1=new AbsenceType(1, "Pending...");
		AbsTypeDAO typeDAO=new AbsTypeDAO();
		typeDAO.add(type1);
		SessionDAO sessDAO=new SessionDAO();
		Session s1=new Session(1, 1, "01/01/2020");
		sessDAO.add(s1);
		CoursDAO crDAO=new CoursDAO();
		Cours c1= new Cours(1, "Astroastrologie", 50, 1);
		crDAO.add(c1);
		crDAO.ensPar(c1, test);
		PlanningDAO plDAO = new PlanningDAO();
		Planning pl=new Planning(1, 1, 1, 1, "8:30", "AMPHI", 2, 1, 1);
		plDAO.add(pl);
		System.out.println(userID.ID);
		Absence absence=new Absence(1, 1, 1, 1, 1, 0, "");
		AbsenceDAO absDAO=new AbsenceDAO();
		absDAO.addNoJust(absence);
		*/


	}

}
