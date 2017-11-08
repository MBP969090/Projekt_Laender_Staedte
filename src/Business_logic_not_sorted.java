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

	public IDatarepository get_datarepository() throws NullPointerException{
		if(this.datarepository == null) {
			throw new NullPointerException("Kein Datarepository ausgewählt.");
		}
		return this.datarepository;
	}

	public void set_selected_country(Country country) {
		this.selected_country = country;
	}

	public Country get_selected_country() throws NullPointerException{
		if(this.selected_country == null) {
			throw new NullPointerException("Kein Land ausgewählt");
		}
		return this.selected_country;
	}

	public void set_selected_town(City town) {
		this.selected_town = town;
	}

	public City get_selected_town() throws NullPointerException{
		if(this.selected_town == null) {
			throw new NullPointerException("Keine Stadt ausgewählt");
		}
		return this.selected_town;
	}

	@Override
	public void read_country(int id) {
		set_selected_country(get_datarepository().select_country(id));
	}
	
	@Override
	public void read_town(int id) {
		set_selected_town(get_datarepository().select_city(id));
	}
	
	@Override
	public void change_country_name(String name) {
		get_datarepository().update_country(name, get_selected_country().getCountry_id());
	}
	
	@Override
	public void change_town_name(String name) {
		get_datarepository().update_city(name, get_selected_town().getCity_id());
	}
	
	@Override
	public void delete_country() {
		get_datarepository().delete_country(get_selected_country().getCountry_id());
	}
	
	@Override
	public void delete_town() throws NullPointerException{
		get_datarepository().delete_city(get_selected_town().getCity_id());
	}
	
	@Override
	public void add_country(String name) {
		get_datarepository().insert_country(name);
	}
	
	@Override
	public void add_town(String name) {
		get_datarepository().insert_city(name, get_selected_country().getCountry_id());
	}
	
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
