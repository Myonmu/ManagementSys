# ManagementSys
For simplicity, in models, foreign objects are represented as object id instead of the object it self. 
This reduces the amount of sql commends thus reduces the number of methods.
In order to retrieve a foreign object, for exemple, retrieve a Groupe object from a Planning object, do as follow:
Declaration: GroupeDAO grDAO=new GroupeDAO(); PlanningDAO plDAO=new PlanningDAO();
int grID = plDAO.searchByID(x).getGr(); 
Groupe gr=grDAO.searchByID(grID);

  
