import com.sun.javaws.exceptions.InvalidArgumentException;

/**
 * Created by Peter Ganzschow
 */
public class Business_logic_sorted implements IBusiness_logic {
	@Override
	public void read_country(int id) throws InvalidArgumentException {
		
	}
	
	@Override
	public void read_town(int id) throws InvalidArgumentException {
		
	}
	
	@Override
	public void change_country_name(String name) throws NullPointerException {
		
	}
	
	@Override
	public void change_town_name(String name) throws NullPointerException {
		
	}
	
	@Override
	public void delete_country() throws NullPointerException {
		
	}
	
	@Override
	public void delete_town() throws NullPointerException {
		
	}
	
	@Override
	public void add_country(String name) {
		
	}
	
	@Override
	public void add_town(String name) throws NullPointerException {
		
	}
	
	@Override
	public Country[] get_countries() {
		return new Country[0];
	}
	
	@Override
	public Country[] get_countries(int id) {
		return new Country[0];
	}
	
	@Override
	public City[] get_towns() {
		return new City[0];
	}
	
	@Override
	public City[] get_towns(int id) {
		return new City[0];
	}
	
}
