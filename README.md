# ManagementSys
________________INSTALLATION GUIDE___________________

1. Unzip this file
2. Open this file as project in Eclipse
3. In the hierarchy view, go to the lib folder, right click on every library listed and add them to build path. 
They thould now appear in Referenced Libraries
4. Execute SQL scripts in the folder SQL Scripts. If this is NOT your first time execute them, execute Cleaning.sql first.
And then, execute Table Creation.sql follow by Sample Data.sql
5. It shoud be good to go.

________________IMPORTANT NOTES___________________

1. GUIs have appearance difference since they are not made by the same person. 
Generally, GUIs with fancy looking do not auto-refresh. To see any modification you have made,
you have to close the window and click on the button which makes the window appears. (manual refresh)

2. You may have to create a student with your real email address in order to test the mailing system.
The mail may be considered as spam.

3. The justification system does not actually upload anything. It will access images on your own local storage.



_________________Conception notes___________________

For simplicity, in models, foreign objects are represented as object id instead of the object it self. 
This reduces the amount of sql commends thus reduces the number of methods.
In order to retrieve a foreign object, for exemple, retrieve a Groupe object from a Planning object, do as follow:
Declaration: GroupeDAO grDAO=new GroupeDAO(); PlanningDAO plDAO=new PlanningDAO();
int grID = plDAO.searchByID(x).getGr(); 
Groupe gr=grDAO.searchByID(grID);

  
