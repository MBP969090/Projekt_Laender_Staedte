import com.sun.javaws.exceptions.InvalidArgumentException;

import java.util.ArrayList;

/**
 * Created by Peter Ganzschow
 */
public class Business_logic_not_sorted extends Abstract_business_logic {

	@Override
	public Country[] get_countries() {
		ArrayList<Country> countries_from_database = get_datarepository().select_countries();
		Country[] countries = new Country[countries_from_database.size()];
		for (int i = 0; i < countries.length; i++) {
			countries[i] = countries_from_database.get(i);
		}
		return countries;
	}
	
	@Override
	public Country[] get_countries(int id) {
		return new Country[0];
	}
	
	@Override
	public City[] get_towns() {
		ArrayList<City> cities_from_database = get_datarepository().select_cities();
		City[] cities = new City[cities_from_database.size()];
		for (int i = 0; i < cities.length; i++) {
			cities[i] = cities_from_database.get(i);
		}
		return cities;
	}
	
	@Override
	public City[] get_towns(int id) {
		return new City[0];
	}
}
