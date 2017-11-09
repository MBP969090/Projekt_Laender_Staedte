import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class GUI2 extends Application {
    public static void main(String[] args) {
        launch(args);
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
        countryComboBox.getItems().addAll( );

        final ComboBox cityComboBox = new ComboBox();
        cityComboBox.getItems().addAll( );

        GridPane grid = new GridPane();
        grid.setVgap(10);
        grid.setHgap(10);
        grid.setPadding(new Insets(10, 15, 10, 15                                      ));
        grid.add(new Label("Länder"), 0, 0);
        grid.add(countryComboBox, 0, 1);

        grid.add(editCountryButton, 0, 2);
        grid.add(addCountryButton, 0, 3);
        grid.add(deleteCountryButton, 0, 4);

        grid.add(new Label("Städte"), 2, 0);
        grid.add(cityComboBox, 2, 1);

        grid.add(editCityButton, 2, 2);
        grid.add(addCityButton, 2, 3);
        grid.add(deleteCityButton, 2, 4);


        Group root = (Group)scene.getRoot();
        root.getChildren().add(grid);
        stage.setScene(scene);
        stage.setHeight(500);
        stage.setWidth(500);
        stage.show();
    }
}