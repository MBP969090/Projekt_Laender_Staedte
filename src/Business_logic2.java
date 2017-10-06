/**
 * Created by Peter Ganzschow
 */
public class Business_logic2 implements IBusiness_logic {
    IDatenhaltung datenhaltung;
    public Business_logic2(IDatenhaltung datenhaltung) {
        this.datenhaltung = datenhaltung;
    }

    @Override
    public void read_counry(int id) {

    }

    @Override
    public void read_own(int id) {

    }

    @Override
    public void change_country_name(int id, String name) {

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
    public void get_countries() {

    }

    @Override
    public void get_towns() {

    }
}
