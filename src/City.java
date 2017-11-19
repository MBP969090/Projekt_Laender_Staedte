import java.util.Comparator;

/**
 * Created by bf on 06.10.17.
 */
public class City implements Comparable<City>{
  private int city_id;
  private String city_name;
  private int country_id;


  public City(int city_id, String city_name, int country_id) {
    setCity_id(city_id);
    setCity_name(city_name);
    setCountry_id(country_id);
  }

  public int getCity_id() {
    return city_id;
  }

  public String getCity_name() {
    return city_name;
  }

  public int getCountry_id() {
    return country_id;
  }

  public void setCity_id(int city_id) {
    this.city_id = city_id;
  }

  public void setCity_name(String city_name) {
    this.city_name = city_name;
  }

  public void setCountry_id(int country_id) {
    this.country_id = country_id;
  }

  @Override
  public int compareTo(City o1) {
    return this.getCity_name().compareTo(o1.getCity_name());
  }
  
  @Override
  public String toString() {
    return getCity_name();
  }
}