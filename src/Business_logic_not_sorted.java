import com.sun.javaws.exceptions.InvalidArgumentException;

import java.util.ArrayList;

/**
 * Created by Peter Ganzschow
 */
public class Business_logic_not_sorted implements IBusiness_logic {
	private IDatarepository datarepository;
	private Country selected_country;
	private City selected_town;
	
	public Business_logic_not_sorted(IDatarepository datarepository) {
		this.datarepository = datarepository;
		this.selected_country = null;
		this.selected_town = null;
	}
	
	@Override
	public void read_country(int id) throws InvalidArgumentException{
		this.selected_country = datarepository.select_country(id);
		this.selected_country = new Country(1, "Deutschland");
	}
	
	@Override
	public void read_town(int id) throws InvalidArgumentException {
		this.selected_town = datarepository.select_city(id);
	}
	
	@Override
	public void change_country_name(String name) throws NullPointerException{
		if(this.selected_country == null) {
			throw new NullPointerException("Kein Land ausgewählt");
		}
		datarepository.update_country(name, this.selected_country.getCountry_id());
	}
	
	@Override
	public void change_town_name(String name) throws NullPointerException{
		if(this.selected_town == null) {
			throw new NullPointerException("Keine Stadt ausgewählt");
		}
		datarepository.update_city(name, this.selected_town.getCity_id());
	}
	
	@Override
	public void delete_country() throws NullPointerException{
		if(this.selected_country == null) {
			throw new NullPointerException("Kein Land ausgewählt");
		}
		datarepository.delete_country(this.selected_country.getCountry_id());
	}
	
	@Override
	public void delete_town() throws NullPointerException{
		if(this.selected_town == null) {
			throw new NullPointerException("Keine Stadt ausgewählt");
		}
		datarepository.delete_city(this.selected_town.getCity_id());
	}
	
	@Override
	public void add_country(String name) {
		datarepository.insert_country(name);
	}
	
	@Override
	public void add_town(String name) throws NullPointerException{
		if(this.selected_country == null) {
			throw new NullPointerException("Kein Land ausgewählt");
		}
		datarepository.insert_city(name, this.selected_country.getCountry_id());
	}
	
	@Override
	public Country[] get_countries() {
		ArrayList<Country> countries_from_database = datarepository.select_countries();
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
		ArrayList<City> cities_from_database = datarepository.select_cities();
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
