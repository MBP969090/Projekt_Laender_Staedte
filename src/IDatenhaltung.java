import java.util.ArrayList;

/**
 * Created by Benjamin Flügel on 05.10.17.
 */
public interface IDatenhaltung {
  ArrayList select_staedte();
  ArrayList select_laender();

  ArrayList select_stadt();
  ArrayList select_land();

  void insert_stadt (String name, int laender_id);
  void insert_land (String name);
  //ArrayList<> getLaenderList();

}
