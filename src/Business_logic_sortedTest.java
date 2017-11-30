import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class Business_logic_sortedTest {
    Business_logic_sorted b;
    Test_database data;
    @BeforeEach
    void setUp() {
        data = new Test_database();
        b = new Business_logic_sorted(data);
    }

    @Test
    void get_countries() {
        ArrayList<Country> countries = b.get_countries();
        assertEquals(0, countries.size());

        data.insert_country("Deutschland");
        countries = b.get_countries();
        assertEquals("Deutschland", countries.get(0).getCountry_name());
        assertEquals(0, countries.get(0).getCountry_id());

        data.insert_country("Armenien");
        countries = b.get_countries();
        assertEquals("Deutschland", countries.get(1).getCountry_name());
        assertEquals(0, countries.get(1).getCountry_id());
        assertEquals("Armenien", countries.get(0).getCountry_name());
        assertEquals(1, countries.get(0).getCountry_id());
    }

    @Test
    void get_cities() {
        //ArrayList<City> cities = b.get_cities();
        //assertEquals(0, cities.size());

        // data.insert_city("Berlin", 0);
        assertThrows(NullPointerException.class, () -> {
            b.get_cities();
        });
    }

    @Test
    void get_datarepository() {
        assertEquals(new Test_database().getClass(), b.get_datarepository().getClass());
    }

    @Test
    void set_datarepository() {
    }

    @Test
    void set_selected_country() {
    }

    @Test
    void get_selected_country() {
    }

    @Test
    void set_selected_city() {
    }

    @Test
    void get_selected_city() {
    }

    @Test
    void read_country() {
    }

    @Test
    void read_city() {
    }

    @Test
    void change_country_name() {
    }

    @Test
    void change_city_name() {
    }

    @Test
    void delete_country() {
    }

    @Test
    void delete_city() {
    }

    @Test
    void add_country() {
    }

    @Test
    void add_city() {
    }

}