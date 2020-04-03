import DAO.EnseignantDAO;
import models.Enseignant;

public class ManagementMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Enseignant test=new Enseignant("0000","0000","PATRIKOV","SIMON","00000000");
		EnseignantDAO testDAO=new EnseignantDAO();
		testDAO.add(test);

	}

}
