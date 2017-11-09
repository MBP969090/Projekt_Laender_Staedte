import java.util.ArrayList;

/**
 * Created by Peter Ganzschow
 */
public class Business_logic_not_sorted extends Abstract_business_logic {
	
	/**
	 * Constructor
	 * @param datarepository
	 */
	public Business_logic_not_sorted(IDatarepository datarepository){
		super(datarepository);
	}
	
	@Override
	public ArrayList<Country> get_countries() {
		ArrayList<Country> countries_from_database = get_datarepository().select_countries();
		ArrayList<Country> countries = new ArrayList<Country>();
		for (Country country : countries_from_database) {
			countries.add(country);
		}
		return countries;
	}
	
	@Override
	public ArrayList<City> get_cities() {
		ArrayList<City> cities_from_database = get_datarepository().select_cities();
		ArrayList<City> cities = new ArrayList<City>();
		for (City city: cities_from_database) {
			if(city.getCountry_id() == this.get_selected_country().getCountry_id()) {
				cities.add(city);
			}
		}
		return cities;
	}
}
