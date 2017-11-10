import com.sun.javaws.exceptions.InvalidArgumentException;

/**
 * Created by Benjamin Flügel on 05.10.17.
 * To use the MySQL-Database start MAMP
 * To use the Mongo-Database start mongod
 */
public class Project_Countries_Cities {
  public static void main (String[] args) {
//    GUI_main gui = new GUI_main(new Business_logic_not_sorted(new Test_database()));
      GUI2 gui = new GUI2(new Business_logic_not_sorted(new Test_database()));
  }
}
