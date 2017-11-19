import java.util.Comparator;

/**
 * Created by bf on 06.10.17.
 */
public class Country implements Comparable<Country>{
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
  public int compareTo(Country o1) {
    return this.getCountry_name().compareTo(o1.getCountry_name());
  }
  
  @Override
  public String toString() {
    return getCountry_name();
  }
}
