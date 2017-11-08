import java.sql.*;
import java.sql.ResultSet;
import java.util.ArrayList;

/**
 * Created by bf on 05.10.17.
 */
public class SQL_Databasemanagement implements IDatarepository {
  private final String hostname = "localhost";
  private final String port = "8889";
  private final String dbname = "projekt_laender_staedte";
  private final String user = "root";
  private final String password = "root";
  private Connection database_connection = null;


  public SQL_Databasemanagement(){
    System.out.println("Starten");
    connect_to_database();
    System.out.println("Verbindung erfolgreich");
  }

  private void connect_to_database() {
    load_database_treiber();
     Statement statement = null;
     PreparedStatement preparedStatement = null;
    ResultSet resultSet = null;
    try {
      String url = "jdbc:mysql://"+hostname+":"+port+"/"+dbname;
      this.database_connection = DriverManager.getConnection(url, user, password);
      statement = database_connection.createStatement();
      // Result set get the result of the SQL query
      resultSet = statement
          .executeQuery("select * from projekt_laender_staedte.T_Staedte");
      while (resultSet.next()) {
        String user = resultSet.getString("Name");
      }
      int i = 1;
    }
    catch (SQLException sqle) {
      sqle.printStackTrace();
    }
  }

  private void disconnect_from_database() {
    try {
      this.database_connection.close();
    } catch (SQLException sqle) {

    }
  }

  private void load_database_treiber(){
    try {
      Class.forName("com.mysql.jdbc.Driver").newInstance();
    }
    catch (Exception e) {
      e.printStackTrace();
    }
  }

  @Override
  public ArrayList<City> select_cities() {
    return null;
  }

  @Override
  public ArrayList<Country> select_countries() {
    return null;
  }

  @Override
  public City select_city(Integer city_id) {
    return null;
  }

  @Override
  public Country select_country(Integer country_id) {
    return null;
  }

  @Override
  public void insert_city(String city_name, Integer country_id) {

  }

  @Override
  public void insert_country(String country_name) {

  }

  @Override
  public void update_city(String city_name, Integer city_id) {

  }

  @Override
  public void update_country(String country_name, Integer country_id) {

  }

  @Override
  public void delete_city(Integer city_id) {

  }

  @Override
  public void delete_country(Integer country_id) {

  }
}
