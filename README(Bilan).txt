# ManagementSys
________________INSTALLATION GUIDE_______________

1. Unzip this file
2. Open this file as project in Eclipse
3. In the hierarchy view, go to the lib folder, right click on every library listed and add them to build path. They thould now appear in Referenced Libraries
4. Execute SQL scripts in the folder : SQL Scripts. If this is NOT your first time executing them, execute Cleaning.sql first. And then, execute Table Creation.sql followed by Sample Data.sql 
5. It shoud be good to go. Run (default)>ManagementMain

________________IMPORTANT NOTES_______________

1. GUIs have appearance difference since they are not made by the same person. Generally, GUIs with "fancy" looking do not auto-refresh. To see any modification you have made, you have to close the window and click on the button which makes the window appears. (manual refresh)

2. You may have to create a student with your real email address in order to test the mailing system. The mail may be considered as spam.

3. The justification system does not actually upload any file. It will access images on your own local storage. Large image files need more time to be loaded.



_________________Conception notes_______________
Changes compare to initial technical documents:
1. No DAO or GUI are created to manage manager accounts. Any operation related to manager accounts has to be perfomed manually via sql commands. The program refer a manager as an anonymous account with level-3 accessibility.
2. Justification format is undefined in any of the technical documents. In the program, they are considered as images (JLabel has the ability to handle images). FTP servers need too much time to study,so we dcould not upload anything to a such server.
3. Mail notification is surprisingly easy to handle. However with the time left we could only achieve to send warning emails. Other notifications are not difficult to create, but the GUI creation is extremely time-consuming, so we abandoned other parts of the mail system.
4. A not essential but handy image compression function is created. Every justification image will be scaled down so that no side can be larger than 500px.

For simplicity, in models, foreign objects are represented as object id instead of the object it self. 
This reduces the amount of sql commends thus reduces the number of methods.
In order to retrieve a foreign object, for exemple, retrieve a Groupe object from a Planning object, do as follow:
Declaration: GroupeDAO grDAO=new GroupeDAO(); PlanningDAO plDAO=new PlanningDAO();
int grID = plDAO.searchByID(x).getGr(); 
Groupe gr=grDAO.searchByID(grID);

  
