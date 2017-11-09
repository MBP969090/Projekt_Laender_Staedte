import com.sun.javaws.exceptions.InvalidArgumentException;

import java.util.ArrayList;

/**
 * Created by Peter Ganzschow
 */
interface IBusiness_logic {
    void read_country (int id) throws InvalidArgumentException;
    void read_city (int id) throws InvalidArgumentException;
    void change_country_name (String name) throws NullPointerException;
    void change_city_name (String name) throws NullPointerException;
    void delete_country () throws NullPointerException;
    void delete_city () throws NullPointerException;
    void add_country (String name);
    void add_city (String name) throws NullPointerException;
    ArrayList<Country> get_countries ();
    ArrayList<City> get_cities ();
}
