/**
 * Created by Peter Ganzschow
 */
interface IBusiness_logic {
    void read_country (int id);
    void read_city (int id);
    void change_country_name (int id, String name);
    void change_city_name (int id, String name);
    void delete_country (int id);
    void delete_city (int id);
    void add_country (String name);
    void add_city (String name, int country_id);
    String[] get_countries ();
    String[] get_cities ();
}
