import com.sun.javaws.exceptions.InvalidArgumentException;

import java.lang.reflect.Array;
import java.util.ArrayList;

/**
 * Created by Peter Ganzschow
 */
public class Business_logic_sorted extends Abstract_business_logic {

	public Business_logic_sorted(IDatarepository datarepository){
		super(datarepository);
	}

	@Override
	public ArrayList<Country> get_countries() {
		ArrayList<Country> sorted_countries = get_countries().sort();
	}
	
	@Override
	public ArrayList<City> get_cities() {
		return null;
	}
}
