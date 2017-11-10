import java.util.ArrayList;

/**
 * Created by Benjamin Flügel on 05.10.17.
 * Interface for database or storage classes.
 * @author Benjamin Flügel
 * @version 05.10.2017
 */
public interface IDatarepository {

  ArrayList<City> select_cities();

  ArrayList<Country> select_countries();

  City select_city(int city_id);

  Country select_country(int country_id);

  void insert_city(String city_name, int country_id);

  void insert_country(String country_name);

  void update_city(String city_name, int city_id);

  void update_country(String country_name, int country_id);

  void delete_city(int city_id);

  void delete_country(int country_id);
}
