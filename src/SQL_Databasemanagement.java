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
  private ResultSet resultSet = null;
  private PreparedStatement prepared_statement = null;


  public SQL_Databasemanagement() {
    connect_to_database();
  }

  private void connect_to_database() {
    load_database_treiber();
    try {
      String url = "jdbc:mysql://" + hostname + ":" + port + "/" + dbname;
      this.database_connection = DriverManager.getConnection(url, user, password);
    } catch (SQLException sqle) {
      sqle.printStackTrace();
    }
  }

  private void disconnect_from_database() {
    try {
      this.database_connection.close();
    } catch (SQLException sqle) {
      sqle.printStackTrace();
    }
  }

  private void load_database_treiber() {
    try {
      Class.forName("com.mysql.jdbc.Driver").newInstance();
    } catch (Exception e) {
      e.printStackTrace();
    }
  }

  @Override
  public ArrayList<City> select_cities() {
    ArrayList<City> cities = new ArrayList<City>();
    String query = "SELECT * FROM projekt_laender_staedte.T_Staedte";
    try {
      prepared_statement = database_connection.prepareStatement(query);
      this.resultSet = prepared_statement.executeQuery();
      while (resultSet.next()) {
        int city_id = resultSet.getInt("P_Staedte_ID");
        String city_name = resultSet.getString("Name");
        int country_id = resultSet.getInt("F_Laender_ID");
        cities.add(new City(city_id, city_name, country_id));
      }
      return cities;
    } catch (SQLException sqle) {
      sqle.printStackTrace();
    }
    return null;
  }

  @Override
  public ArrayList<Country> select_countries() {
    ArrayList<Country> countries = new ArrayList<Country>();
    String query = "SELECT * FROM projekt_laender_staedte.T_Laender";
    try {
      prepared_statement = database_connection.prepareStatement(query);
      this.resultSet = prepared_statement.executeQuery();
      while (resultSet.next()) {
        int country_id = resultSet.getInt("P_Laender_ID");
        String coumtry_name = resultSet.getString("Name");
        countries.add(new Country(country_id, coumtry_name));
      }
      return countries;
    } catch (SQLException sqle) {
      sqle.printStackTrace();
    }
    return null;
  }

  @Override
  public City select_city(int city_id) {
    String query = "SELECT * FROM projekt_laender_staedte.T_Staedte WHERE P_Staedte_ID = ?";
    try {
      prepared_statement = database_connection.prepareStatement(query);
      prepared_statement.setInt(1, city_id);
      this.resultSet = prepared_statement.executeQuery();
      if (resultSet.next()) {
        String city_name = resultSet.getString("Name");
        int country_id = resultSet.getInt("F_Laender_ID");
        return new City(city_id, city_name, country_id);
      }
    } catch (SQLException sqle) {
      sqle.printStackTrace();
    }
    return null;
  }

  @Override
  public Country select_country(int country_id) {
    String query = "SELECT * FROM projekt_laender_staedte.T_Laender WHERE P_Laender_ID = ?";
    try {
      prepared_statement = database_connection.prepareStatement(query);
      prepared_statement.setInt(1, country_id);
      this.resultSet = prepared_statement.executeQuery();
      if (resultSet.next()) {
        String coumtry_name = resultSet.getString("Name");
        return new Country(country_id, coumtry_name);
      }
    } catch (SQLException sqle) {
      sqle.printStackTrace();
    }
    return null;
  }

  @Override
  public void insert_city(String city_name, int country_id) {
    String query = "INSERT INTO projekt_laender_staedte.T_Staedte (Name, F_Laender_ID) VALUES (?, ?)";
    try {
      prepared_statement = database_connection.prepareStatement(query);
      prepared_statement.setString(1, city_name);
      prepared_statement.setInt(2, country_id);
      prepared_statement.execute();
    } catch (SQLException sqle) {
      sqle.printStackTrace();
    }
  }

  @Override
  public void insert_country(String country_name) {
    String query = "INSERT INTO projekt_laender_staedte.T_Laender (Name) VALUES (?)";
    try {
      prepared_statement = database_connection.prepareStatement(query);
      prepared_statement.setString(1, country_name);
      prepared_statement.execute();
    } catch (SQLException sqle) {
      sqle.printStackTrace();
    }
  }

  @Override
  public void update_city(String city_name, int city_id) {
    String query = "UPDATE projekt_laender_staedte.T_Staedte SET Name = ? WHERE P_Staedte_ID = ?";
    try {
      prepared_statement = database_connection.prepareStatement(query);
      prepared_statement.setString(1, city_name);
      prepared_statement.setInt(2, city_id);
      prepared_statement.execute();
    } catch (SQLException sqle) {
      sqle.printStackTrace();
    }
  }

  @Override
  public void update_country(String country_name, int country_id) {
    String query = "UPDATE projekt_laender_staedte.T_Laender SET Name = ? WHERE P_Laender_ID = ?";
    try {
      prepared_statement = database_connection.prepareStatement(query);
      prepared_statement.setString(1, country_name);
      prepared_statement.setInt(2, country_id);
      prepared_statement.execute();
    } catch (SQLException sqle) {
      sqle.printStackTrace();
    }
  }

  @Override
  public void delete_city(int city_id) {
    String query = "DELETE FROM  projekt_laender_staedte.T_Staedte WHERE P_Staedte_ID = ?";
    try {
      prepared_statement = database_connection.prepareStatement(query);
      prepared_statement.setInt(1, city_id);
      prepared_statement.execute();
    } catch (SQLException sqle) {
      sqle.printStackTrace();
    }
  }

  @Override
  public void delete_country(int country_id) {
    String query = "DELETE FROM  projekt_laender_staedte.T_Laender WHERE P_Laender_ID = ?";
    try {
      prepared_statement = database_connection.prepareStatement(query);
      prepared_statement.setInt(1, country_id);
      prepared_statement.execute();
    } catch (SQLException sqle) {
      sqle.printStackTrace();
    }
  }
}
