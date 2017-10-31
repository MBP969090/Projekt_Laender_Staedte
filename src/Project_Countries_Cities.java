import com.sun.javaws.exceptions.InvalidArgumentException;

/**
 * Created by Benjamin Flügel on 05.10.17.
 * To use the MySQL-Database start MAMP
 * To use the Mongo-Database start mongod
 */
public class Project_Countries_Cities {
  public static void main (String[] args) {
    IBusiness_logic blns = new Business_logic_not_sorted(new SQL_Databasemanagement());
    try {
      blns.read_country(1);
    } catch (Exception e) {
      System.out.print(e.getStackTrace());
    }
    blns.change_country_name("HAMBURG");
  }
}
