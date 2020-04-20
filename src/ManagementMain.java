import DAO.*;
import models.*;

public class ManagementMain {

	public static void main(String[] args) {
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
		

	}

}
