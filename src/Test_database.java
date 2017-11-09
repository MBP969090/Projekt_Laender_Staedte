import java.lang.reflect.Array;
import java.util.ArrayList;

public class Test_database implements IDatarepository{

    ArrayList<City> cities;
    ArrayList<Country> countries;
    int cities_index = 0;
    int countries_index = 0;

    public Test_database(){
        Country germany = new Country(1, "Deutschland");
        Country italien = new Country( 2, "Italien");
        Country spanien = new Country(3, "Spanien");

        this.countries = new ArrayList<Country>();
        countries.add(germany);
        countries.add(italien);
        countries.add(spanien);
        countries_index = 4;

        City berlin = new City(1, "Berlin", 1);
        City munich = new City(2, "München", 1);
        City rom = new City(3, "Rom", 2);
        City madrid = new City(4, "Madrid", 3);

        this.cities = new ArrayList<City>();
        cities.add(berlin);
        cities.add(munich);
        cities.add(rom);
        cities.add(madrid);
        cities_index = 5;
    }
    @Override
    public ArrayList<City> select_cities() {
        return this.cities;
    }

    @Override
    public ArrayList<Country> select_countries() {
        return this.countries;
    }

    @Override
    public City select_city(int city_id) {
        return this.cities.get(city_id);
    }

    @Override
    public Country select_country(int country_id) {
        return this.countries.get(country_id);
    }

    @Override
    public void insert_city(String city_name, int country_id) {
        this.cities.add(new City(cities_index++, city_name, country_id));
    }

    @Override
    public void insert_country(String country_name) {
        this.countries.add(new Country(countries_index++, country_name));
    }

    @Override
    public void update_city(String city_name, int city_id) {
        this.cities.get(city_id).setCity_name(city_name);
    }

    @Override
    public void update_country(String country_name, int country_id) {
        this.countries.get(country_id).setCountry_name(country_name);
    }

    @Override
    public void delete_city(int city_id) {
        this.cities.remove(city_id);
    }

    @Override
    public void delete_country(int country_id) {
        this.countries.remove(country_id);
    }
}
