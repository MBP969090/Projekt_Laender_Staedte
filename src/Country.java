import java.util.Comparator;

/**
 * Created by bf on 06.10.17.
 */
public class Country implements Comparator<Country>{
  private int country_id;
  private String country_name;

  public Country(int country_id, String country_name) {
    setCountry_id(country_id);
    setCountry_name(country_name);
  }

  public int getCountry_id() {
    return country_id;
  }

  public String getCountry_name() {
    return country_name;
  }

  public void setCountry_id(int country_id) {
    this.country_id = country_id;
  }

  public void setCountry_name(String country_name) {
    this.country_name = country_name;
  }

  @Override
  public int compare(Country o1, Country o2) {
    return 0;
  }
}
