/**
 * Created by Peter Ganzschow
 */
interface IFachkonzept {
    void lese_land (int id);
    void lese_stadt (int id);
    void aendere_land_name (int id, String name);
    void aendere_stadt_name(int id, String name);
    void loesche_land(int id);
    void loesche_stadt(int id);
    void liste_laender();
    void liste_staedte();
}
