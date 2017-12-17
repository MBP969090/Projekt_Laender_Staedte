import javafx.embed.swing.JFXPanel;

import java.util.Scanner;

/**
 * Created by Benjamin Flügel on 05.10.17.
 * To use the MySQL-Database start MAMP
 * To use the Mongo-Database start mongod
 */
public class Project_Countries_Cities {
  public static void main(String[] args) {
  	UiClassFactory uiClassFactory = new UiClassFactory();
  	Database_class_factory database_class_factory = new Database_class_factory();
  	Business_logic_factory logic_factory = new Business_logic_factory();
  	Scanner scanner = new Scanner(System.in);
		System.out.println("1 - MySQL");
		System.out.println("2 - MongoDB");
		System.out.println("3 - TestDB");
		System.out.println("Wählen Sie eine Datenhaltung");
		int db = Integer.parseInt(scanner.next());
		IDatarepository databasemanagement;
		if(db == 1) {
			databasemanagement = database_class_factory.createDatarepositoryProgram("SQL_Databasemanagement");
		} else if(db == 2) {
			databasemanagement = database_class_factory.createDatarepositoryProgram("MongoDB_Databasemanagement");
		} else if(db == 3) {
			databasemanagement = database_class_factory.createDatarepositoryProgram("Test_database");
		} else {
			databasemanagement = database_class_factory.createDatarepositoryProgram("");
		}
		
		System.out.println("1 - Fachkonzept unsortiert");
		System.out.println("2 - Fachkonzept sortiert");
		System.out.println("Wählen Sie ein Fachkonzept");
		IBusiness_logic business_logic;
		int bl = Integer.parseInt(scanner.next());
		if(bl == 1) {
			business_logic = logic_factory.createBusinessLogicProgram("business_logic_not_sorted", databasemanagement);
		} else if(bl == 2) {
			business_logic = logic_factory.createBusinessLogicProgram("business_logic_sorted", databasemanagement);
		} else {
			business_logic = logic_factory.createBusinessLogicProgram("", databasemanagement);
		}
		
		System.out.println("1 - Userinterface grafisch");
		System.out.println("2 - Userinterface Konsole");
		System.out.println("Wählen Sie ein Userinterface");
		int ui = Integer.parseInt(scanner.next());
		if(ui == 1) {
			uiClassFactory.createUiProgram("GUI", business_logic);
		} else if(ui == 2) {
			uiClassFactory.createUiProgram("TUI", business_logic);
		} else {
			uiClassFactory.createUiProgram("", business_logic);
		}
		System.out.print(business_logic);
  }
}