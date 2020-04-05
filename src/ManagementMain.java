import DAO.EnseignantDAO;
import models.Enseignant;

public class ManagementMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Enseignant test=new Enseignant(1,"0000","0000","PATRIKOV","SIMON","00000000");
		EnseignantDAO testDAO=new EnseignantDAO();
		testDAO.add(test);
		Enseignant test1=new Enseignant(2,"1111","1111","LOVECRAFT","H.P.","00000000");
		testDAO.add(test1);
		test.randomizer();
		testDAO.modify(test);
		test.printAll();
		testDAO.delete(test1);

	}

}
