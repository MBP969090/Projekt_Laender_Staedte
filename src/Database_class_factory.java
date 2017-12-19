/**
 * Created by Peter on 17.12.2017.
 */
public class Database_class_factory {
	IDatarepository program;
	public IDatarepository createDatarepositoryProgram(String wanted_program) {
		switch (wanted_program) {
			case "SQL_Databasemanagement":
				program = new SQL_Databasemanagement();
				break;
			case "MongoDB_Databasemanagement":
				program = new MongoDB_Databasemanagement();
				break;
			case "Test_database":
				program = new Test_database();
				break;
			default:
				program = null;
				break;
		}
		return program;
	}
}
