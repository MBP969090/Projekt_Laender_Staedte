import java.util.ArrayList;

/**
 * Created by Peter Ganzschow
 */
public class Business_logic1 implements IBusiness_logic {
    private IDatarepository datarepository;
    public Business_logic1(IDatarepository datarepository) {
        this.datarepository = datarepository;
    }

    @Override
    public void read_country(int id) {

    }

    @Override
    public void read_city(int id) {

    }

    @Override
    public void change_country_name(int id, String name) {
        datarepository.update_country(name, id);
    }

    @Override
    public void change_city_name(int id, String name) {
        datarepository.update_city(name, id);
    }

    @Override
    public void delete_country(int id) {
        datarepository.delete_country(id);
    }

    @Override
    public void delete_city(int id) {
        datarepository.delete_city(id);
    }

    @Override
    public void add_country(String name) {
        datarepository.insert_country(name);
    }

    @Override
    public void add_city(String name, int country_id) {
        datarepository.insert_city(name, country_id);
    }

    @Override
    public String[] get_countries() {
        ArrayList<Country> countries = datarepository.select_countries();
        String[] country_names = new String[countries.size()];
        for(int i = 0; i < country_names.length; i++) {
            country_names[i] = countries.get(i).getCountry_name();
        }
        return country_names;
    }

    @Override
    public String[] get_cities() {
        ArrayList<City> cities = datarepository.select_cities();
        String[] city_names = new String[cities.size()];
        for(int i = 0; i < city_names.length; i++) {
            city_names[i] = cities.get(i).getCity_name();
        }
        return city_names;
    }
}
