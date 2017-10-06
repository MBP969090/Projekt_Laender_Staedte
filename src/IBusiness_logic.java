/**
 * Created by Peter Ganzschow
 */
interface IBusiness_logic {
    void read_counry (int id);
    void read_own (int id);
    void change_country_name (int id, String name);
    void change_town_name (int id, String name);
    void delete_country (int id);
    void delete_town (int id);
    void get_countries ();
    void get_towns ();
}
