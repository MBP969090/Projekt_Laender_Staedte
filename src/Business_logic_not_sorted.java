/**
 * Created by Peter Ganzschow
 */
public class Business_logic_not_sorted implements IBusiness_logic {
	private IDatarepository datarepository;
	
	public Business_logic_not_sorted(IDatarepository datarepository) {
		this.datarepository = datarepository;
	}
	
	@Override
	public void read_country(int id) {
		
	}
	
	@Override
	public void read_town(int id) {
		
	}
	
	@Override
	public void change_country_name(int id, String name) {
		datarepository.update_country(name, id);
	}
	
	@Override
	public void change_town_name(int id, String name) {
		
	}
	
	@Override
	public void delete_country(int id) {
		
	}
	
	@Override
	public void delete_town(int id) {
		
	}
	
	@Override
	public void add_country(String name) {
		
	}
	
	@Override
	public void add_town(String name, int country_id) {
		
	}
	
	@Override
	public String[] get_countries() {
		return new String[0];
	}
	
	@Override
	public String[] get_countries(int id) {
		return new String[0];
	}
	
	@Override
	public String[] get_towns() {
		return new String[0];
	}
	
	@Override
	public String[] get_towns(int id) {
		return new String[0];
	}
}
