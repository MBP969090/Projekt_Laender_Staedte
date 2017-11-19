import java.util.ArrayList;
import java.util.Collections;

/**
 * Created by Peter Ganzschow
 */
public class Business_logic_sorted extends Abstract_business_logic {

	public Business_logic_sorted(IDatarepository datarepository){
		super(datarepository);
	}

	@Override
	public ArrayList<Country> get_countries() {
		ArrayList<Country> countries = get_datarepository().select_countries();
		Collections.sort(countries);
		ArrayList<Country> sorted_countries = new ArrayList<Country>();
		for(Country country: countries) {
			sorted_countries.add(country);
		}
		return sorted_countries;
	}
	
	@Override
	public ArrayList<City> get_cities() {
		ArrayList<City> cities = get_datarepository().select_cities();
		Collections.sort(cities);
		ArrayList<City> sorted_cites = new ArrayList<City>();
		for(City city: cities) {
			if(city.getCountry_id() == get_selected_country().getCountry_id()) {
				sorted_cites.add(city);
			}
		}
		return sorted_cites;
	}
}
