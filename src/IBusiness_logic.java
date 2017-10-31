/**
 * Created by Peter Ganzschow
 */
interface IBusiness_logic {
    void read_country (int id);
    void read_town (int id);
    void change_country_name (int id, String name);
    void change_town_name (int id, String name);
    void delete_country (int id);
    void delete_town (int id);
    void add_country (String name);
    void add_town (String name, int country_id);
    String[] get_countries ();
    String[] get_countries (int id);
    String[] get_towns ();
    String[] get_towns (int id);
}
