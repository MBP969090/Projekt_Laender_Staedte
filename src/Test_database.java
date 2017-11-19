import java.lang.reflect.Array;
import java.util.ArrayList;

public class Test_database implements IDatarepository{

    ArrayList<City> cities;
    ArrayList<Country> countries;
    int cities_index = 0;
    int countries_index = 0;

    public Test_database(){
        Country germany = new Country(1, "Spanien");
        Country italien = new Country( 2, "USA");
        Country spanien = new Country(3, "Deutschland");

        this.countries = new ArrayList<Country>();
        countries.add(germany);
        countries.add(italien);
        countries.add(spanien);
        countries_index = 4;

        City berlin = new City(1, "Berlin", 3);
        City munich = new City(2, "München", 3);
        City rom = new City(3, "Los Angeles", 2);
        City madrid = new City(4, "Madrid", 1);

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
        for(City city: this.cities) {
            if(city.getCity_id() == city_id) {
                return city;
            }
        }
        throw new NullPointerException("Id ist nicht vorhanden");
    }

    @Override
    public Country select_country(int country_id) {
    	for(Country country: this.countries) {
    	    if(country.getCountry_id() == country_id) {
                return country;
            }
        }
        throw new NullPointerException("Id ist nicht vorhanden");
    }

    @Override
    public void insert_city(String city_name, int country_id) {
        if(city_name.isEmpty()) {
            throw new NullPointerException("Name ist leer");
        }
        this.cities.add(new City(cities_index++, city_name, country_id));
    }

    @Override
    public void insert_country(String country_name) {
        if(country_name.isEmpty()) {
            throw new NullPointerException("Name ist leer");
        }
        this.countries.add(new Country(countries_index++, country_name));
    }

    @Override
    public void update_city(String city_name, int city_id) {
        if(city_name.isEmpty()) {
            throw new NullPointerException("Name ist leer");
        }
        for(City city: this.cities) {
            if(city.getCity_id() == city_id) {
                city.setCity_name(city_name);
                return;
            }
        }
        throw new NullPointerException("Id ist nicht vorhanden");
    }

    @Override
    public void update_country(String country_name, int country_id) {
        if(country_name.isEmpty()) {
            throw new NullPointerException("Name ist leer");
        }
        for(Country country: this.countries) {
            if(country.getCountry_id() == country_id) {
                country.setCountry_name(country_name);
                return;
            }
        }
        throw new NullPointerException("Id ist nicht vorhanden");
    }

    @Override
    public void delete_city(int city_id) {
    	for(int i = 0; i < cities.size(); i++) {
    	    if(cities.get(i).getCity_id() == city_id) {
    	        cities.remove(i);
    	        return;
            }
        }
        throw new NullPointerException("Id ist nicht vorhanden");
    }

    @Override
    public void delete_country(int country_id) {
        for(int i = 0; i < countries.size(); i++) {
            if(countries.get(i).getCountry_id() == country_id) {
                countries.remove(i);
                return;
            }
        }
        throw new NullPointerException("Id ist nicht vorhanden");
    }
}
