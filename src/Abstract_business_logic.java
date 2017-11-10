/**
 * Created by Peter Ganzschow
 */
abstract public class Abstract_business_logic implements IBusiness_logic{
    private IDatarepository datarepository;
    private Country selected_country;
    private City selected_city;
    
    /**
     * Constructor
     */
    public Abstract_business_logic() {
    	set_datarepository(null);
        set_selected_city(null);
        set_selected_country(null);
    }
    
    /**
     * Constructor
     * @param datarepository
     */
    public Abstract_business_logic(IDatarepository datarepository) {
    	set_datarepository(datarepository);
    	set_selected_city(null);
    	set_selected_country(null);
    }
    
    /**
     * get datarepository
     * @return
     * @throws NullPointerException
     */
    @Override
    public IDatarepository get_datarepository() throws NullPointerException {
        if(this.datarepository == null) {
            throw new NullPointerException("Kein Datarepository ausgewählt.");
        }
        return this.datarepository;
    }
    
    /**
     * set datarepository
     * @param datarepository
     */
    @Override
    public void set_datarepository(IDatarepository datarepository) {
        this.datarepository = datarepository;
    }
    
    /**
     * set selected_country
     * @param country
     */
    @Override
    public void set_selected_country(Country country) {
        this.selected_country = country;
    }
    
    /**
     * get selected_country
     * @return Country_object
     * @throws NullPointerException
     */
    @Override
    public Country get_selected_country() throws NullPointerException{
        if(this.selected_country == null) {
            throw new NullPointerException("Kein Land ausgewählt");
        }
        return this.selected_country;
    }
    
    /**
     * set selected_city
     * @param city
     */
    @Override
    public void set_selected_city(City city) {
        this.selected_city = city;
    }
    
    /**
     * get selected_city
     * @return City_object
     * @throws NullPointerException
     */
    @Override
    public City get_selected_city() throws NullPointerException{
        if(this.selected_city == null) {
            throw new NullPointerException("Keine Stadt ausgewählt");
        }
        return this.selected_city;
    }

    @Override
    public void read_country(int id) {
        set_selected_country(get_datarepository().select_country(id));
    }

    @Override
    public void read_city(int id) {
        set_selected_city(get_datarepository().select_city(id));
    }

    @Override
    public void change_country_name(String name) {
        get_datarepository().update_country(name, get_selected_country().getCountry_id());
    }

    @Override
    public void change_city_name(String name) {
        get_datarepository().update_city(name, get_selected_city().getCity_id());
    }

    @Override
    public void delete_country() {
        get_datarepository().delete_country(get_selected_country().getCountry_id());
    }

    @Override
    public void delete_city() throws NullPointerException{
        get_datarepository().delete_city(get_selected_city().getCity_id());
    }

    @Override
    public void add_country(String name) {
        get_datarepository().insert_country(name);
    }

    @Override
    public void add_city(String name) {
        get_datarepository().insert_city(name, get_selected_country().getCountry_id());
    }
}
