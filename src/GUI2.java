import javafx.application.Application;
import javafx.embed.swing.JFXPanel;
import javafx.geometry.Insets;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import sun.rmi.server.Activation$ActivationSystemImpl_Stub;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class GUI2 extends Application {
    private IBusiness_logic business_logic;
    private JFXPanel panel = new JFXPanel();

    public GUI2 () {
        this.business_logic = new Business_logic_not_sorted(new Test_database());
    }

    public GUI2 (IBusiness_logic business_logic) {
        Application.launch();
    }

    public void setBusiness_logic(IBusiness_logic business_logic) {
        this.business_logic = business_logic;
    }

    final Button editCountryButton = new Button ("Bearbeiten");
    final Button addCountryButton = new Button ("Hinzufügen");
    final Button deleteCountryButton = new Button ("Löschen");
    final Button editCityButton = new Button ("Bearbeiten");
    final Button addCityButton = new Button ("Hinzufügen");
    final Button deleteCityButton = new Button ("Löschen");
    final Label notification = new Label ();
    final TextField subject = new TextField("");
    final TextArea text = new TextArea ("");


    @Override public void start(Stage stage) {
        stage.setTitle("Projekt: Länder - Städte");
        Scene scene = new Scene(new Group(), 450, 250);

        final ComboBox countryComboBox = new ComboBox();
        ArrayList<Country> countries = business_logic.get_countries();
        String[] country_elements = new String[countries.size()];
        int i = 0;
        for(Country country: countries) {
            country_elements[i] = country.getCountry_name();
            i++;
        }
        countryComboBox.getItems().addAll(country_elements);

        TextField countryTextField = new TextField ();
        countryTextField.setPrefWidth(60);

        editCountryButton.setPrefWidth(110);
        addCountryButton.setPrefWidth(110);
        deleteCountryButton.setPrefWidth(110);

        final ComboBox cityComboBox = new ComboBox();
        try {
            ArrayList<City> cities = business_logic.get_cities();
            String[] city_elements = new String[cities.size()];
            i = 0;
            for (City city : cities) {
                city_elements[i] = city.getCity_name();
                i++;
            }
            cityComboBox.getItems().addAll(city_elements);
        } catch (Exception e) {
            
        }

        TextField cityTextField = new TextField ();
        cityTextField.setPrefWidth(60);

        editCityButton.setPrefWidth(110);
        addCityButton.setPrefWidth(110);
        deleteCityButton.setPrefWidth(110);

        GridPane grid = new GridPane();
        grid.setVgap(10);
        grid.setHgap(10);
        grid.setPadding(new Insets(10, 15, 10, 15                                      ));
        grid.add(new Label("Länder"), 0, 0);
        grid.add(countryComboBox, 0, 1);
        grid.add(countryTextField, 0, 2);

        grid.add(editCountryButton, 0, 3);
        grid.add(addCountryButton, 0, 4);
        grid.add(deleteCountryButton, 0, 5);

        grid.add(new Label("Städte"), 2, 0);
        grid.add(cityComboBox, 2, 1);
        grid.add(cityTextField, 2, 2);

        grid.add(editCityButton, 2, 3);
        grid.add(addCityButton, 2, 4);
        grid.add(deleteCityButton, 2, 5);


        Group root = (Group)scene.getRoot();
        root.getChildren().add(grid);
        stage.setScene(scene);
        stage.setHeight(500);
        stage.setWidth(500);
        stage.show();
    }
}