/**
 * Created by Benjamin Flügel on 05.10.17.
 * To use the MySQL-Database start MAMP
 * To use the Mongo-Database start mongod
 */
public class Project_Countries_Cities {
  public static void main(String[] args) {
    // TUI tui = new TUI(new Business_logic_sorted(new Test_database()));
    GUI gui = new GUI(new Business_logic_sorted(new MongoDB_Databasemanagement()));
  }
}
