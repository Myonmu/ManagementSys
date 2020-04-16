import DAO.EnseignantDAO;
import DAO.EtudiantDAO;
import DAO.GroupeDAO;
import models.Enseignant;
import models.Etudiant;
import models.Groupe;

public class ManagementMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Enseignant test=new Enseignant(1,"33333","0000","PATRIKOV","SIMON","00000000");
		EnseignantDAO testDAO=new EnseignantDAO();
		testDAO.add(test);
		Enseignant test1=new Enseignant(2,"44444","1111","LOVECRAFT","H.P.","00000000");
		testDAO.add(test1);
		test.randomizer();
		testDAO.modify(test);
		test.printAll();
		testDAO.delete(test1);
		Etudiant etu1=new Etudiant(1,"123456","0000","WEST","HERBERT","HW@MU.EDU",0);
		EtudiantDAO etuDAO=new EtudiantDAO();
		etuDAO.add(etu1);
		System.out.println(etuDAO.login(etu1));
		GroupeDAO grDAO=new GroupeDAO();
		Groupe testGr=new Groupe(0, 0, 0);

	}

}
