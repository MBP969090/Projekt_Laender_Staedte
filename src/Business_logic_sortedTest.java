import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class Business_logic_sortedTest {
    private Business_logic_sorted b;
    private Test_database data;
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
        assertEquals(0, b.get_cities().size());

        data.insert_city("Berlin", 0);
        assertThrows(NullPointerException.class, () -> b.get_cities());
        data.insert_country("Deutschland");
        b.read_country(0);
        assertEquals(1, b.get_cities().size());
        assertEquals(0, b.get_cities().get(0).getCountry_id());
    }

    @Test
    void get_datarepository() {
        assertEquals(new Test_database().getClass(), b.get_datarepository().getClass());
    }

    @Test
    void read_country() {
        assertThrows(NullPointerException.class, () -> b.read_country(100));
        data.insert_country("Deutschland");
        b.read_country(0);
        assertEquals("Deutschland", b.get_selected_country().getCountry_name());
    }

    @Test
    void read_city() {
        assertThrows(NullPointerException.class, () -> b.read_city(100));

        data.insert_city("Berlin", 0);
        b.read_city(0);
        assertEquals("Berlin", b.get_selected_city().getCity_name());
        assertEquals(0, b.get_selected_city().getCountry_id());
    }

    @Test
    void change_country_name() {
        assertThrows(NullPointerException.class, () -> b.change_country_name("Frankreich"));

        data.insert_country("Deutschland");
        b.read_country(0);
        b.change_country_name("Frankreich");
        assertEquals("Frankreich", b.get_selected_country().getCountry_name());
    }

    @Test
    void change_city_name() {
        assertThrows(NullPointerException.class, () -> b.change_city_name("Hamburg"));
        data.insert_city("Berlin", 0);
        b.read_city(0);
        b.change_city_name("Hamburg");
        assertEquals("Hamburg", b.get_selected_city().getCity_name());
    }

    @Test
    void delete_country() {
        assertThrows(NullPointerException.class, () -> b.delete_country());

        data.insert_country("Deutschland");
        data.insert_city("Berlin", 0);
        data.insert_city("Hamburg", 0);
        data.insert_city("Madrid", 1);
        b.read_country(0);
        b.delete_country();
        assertThrows(NullPointerException.class, () -> b.get_selected_country());

        assertThrows(NullPointerException.class, () -> b.get_cities());
    }

    @Test
    void delete_city() {
        assertThrows(NullPointerException.class, ()-> b.delete_city());

        data.insert_country("Deutschland");
        data.insert_city("Berlin", 0);
        data.insert_city("Hamburg", 0);
        b.read_city(1);
        b.delete_city();
        assertThrows(NullPointerException.class, () -> b.get_selected_city());
    }

    @Test
    void add_country() {
        b.add_country("Frankreich");
        assertEquals("Frankreich", data.select_country(0).getCountry_name());
    }

    @Test
    void add_city() {
        assertThrows(NullPointerException.class, () -> b.add_city("Berlin"));
        data.insert_country("Deutschland");
        b.read_country(0);
        b.add_city("Berlin");
        assertEquals(0, data.select_city(0).getCountry_id());
        assertEquals("Berlin", data.select_city(0).getCity_name());
    }

}