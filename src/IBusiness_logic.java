import com.sun.javaws.exceptions.InvalidArgumentException;

/**
 * Created by Peter Ganzschow
 */
interface IBusiness_logic {
    void read_country (int id) throws InvalidArgumentException;
    void read_town (int id) throws InvalidArgumentException;
    void change_country_name (String name) throws NullPointerException;
    void change_town_name (String name) throws NullPointerException;
    void delete_country () throws NullPointerException;
    void delete_town () throws NullPointerException;
    void add_country (String name);
    void add_town (String name) throws NullPointerException;
    Country[] get_countries ();
    Country[] get_countries (int id);
    City[] get_towns ();
    City[] get_towns (int id);
}
