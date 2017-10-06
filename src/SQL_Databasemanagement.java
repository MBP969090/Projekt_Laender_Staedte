import java.sql.Connection;
import java.util.ArrayList;

/**
 * Created by bf on 05.10.17.
 */
public class SQL_Databasemanagement implements IDatarepository {
  Connection datenbankverbindung;

  public SQL_Databasemanagement(){


  }

  private void connect_to_database() {

  }

  private void disconnect_from_database() {

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
