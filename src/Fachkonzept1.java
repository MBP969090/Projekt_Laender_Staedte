/**
 * Created by Peter Ganzschow
 */
public class Fachkonzept1 implements IFachkonzept {
    IDatenhaltung datenhaltung;
    public Fachkonzept1(IDatenhaltung datenhaltung) {
        this.datenhaltung = datenhaltung;
    }

    @Override
    public void lese_land(int id) {

    }

    @Override
    public void lese_stadt(int id) {

    }

    @Override
    public void aendere_land_name(int id, String name) {

    }

    @Override
    public void aendere_stadt_name(int id, String name) {

    }

    @Override
    public void loesche_land(int id) {

    }

    @Override
    public void loesche_stadt(int id) {

    }

    @Override
    public void liste_laender() {

    }

    @Override
    public void liste_staedte() {

    }
}
