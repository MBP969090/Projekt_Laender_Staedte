import javafx.application.Application;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.embed.swing.JFXPanel;
import javafx.geometry.Insets;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;


public class GUI extends Application implements UI {

  private IBusiness_logic business_logic;
  private JFXPanel panel = new JFXPanel();

  public GUI() {

  }

  public GUI(IBusiness_logic business_logic) {
    Application.launch(business_logic.getClass().toString(),
        business_logic.get_datarepository().getClass().toString());
  }

  public void init() {
    Parameters p = getParameters();
    IDatarepository datarepository;

    String datarepo = p.getRaw().get(1);
    String business = p.getRaw().get(0);
    if (datarepo.equals("class Test_database")) {
      datarepository = new Test_database();
    } else if (datarepo.equals("class SQL_Databasemanagement")) {
      datarepository = new SQL_Databasemanagement();
    } else if (datarepo.equals("class MongoDB_Databasemanagement")) {
      datarepository = new MongoDB_Databasemanagement();
    } else {
      datarepository = null;
    }
    if (business.equals("class Business_logic_sorted")) {
      this.business_logic = new Business_logic_sorted(datarepository);
    } else {
      this.business_logic = new Business_logic_not_sorted(datarepository);
    }
  }

  public void setBusiness_logic(IBusiness_logic business_logic) {
    this.business_logic = business_logic;
  }

    private final Button editCountryButton = new Button ("Bearbeiten");
    private final Button addCountryButton = new Button ("Hinzufügen");
    private final Button deleteCountryButton = new Button ("Löschen");
    private final Button editCityButton = new Button ("Bearbeiten");
    private final Button addCityButton = new Button ("Hinzufügen");
    private final Button deleteCityButton = new Button ("Löschen");
    private final Label errors = new Label ("");
    private final ListView<Country> countryComboBox = new ListView<>();
    private final ListView<City> cityComboBox = new ListView<>();
    private final TextField countryTextField = new TextField();
	private final TextField cityTextField = new TextField();


    @Override public void start(Stage stage) {
        stage.setTitle("Projekt: Länder - Städte");
        Scene scene = new Scene(new Group(), 450, 250);
        fill_country_list();

        countryTextField.setPrefWidth(150);
        cityTextField.setPrefWidth(150);
	
		editCountryButton.setPrefWidth(150);
		editCountryButton.setOnMouseClicked((MouseEvent event) -> {
			edit_country();
		});
		addCountryButton.setPrefWidth(150);
		addCountryButton.setOnMouseClicked((MouseEvent event) -> {
			add_country();
		});
		deleteCountryButton.setPrefWidth(150);
		deleteCountryButton.setOnMouseClicked((MouseEvent event) -> {
			delete_country();
		});
	
	
		editCityButton.setPrefWidth(150);
		editCityButton.setOnMouseClicked((MouseEvent event) -> {
			edit_city();
		});
		addCityButton.setPrefWidth(150);
		addCityButton.setOnMouseClicked((MouseEvent event) -> {
			add_city();
		});
		deleteCityButton.setPrefWidth(150);
		deleteCityButton.setOnMouseClicked((MouseEvent event) -> {
			delete_city();
		});
		
		countryComboBox.setPrefHeight(150);
		countryComboBox.setPrefWidth(150);
		countryComboBox.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<Country>() {
			@Override
			public void changed(ObservableValue observable, Country oldValue, Country newValue) {
				try {
					business_logic.read_country(newValue.getCountry_id());
					fill_city_list();
					countryTextField.setText(business_logic.get_selected_country().getCountry_name());
					cityTextField.clear();
				} catch (Exception e) {
					errors.setText(e.getMessage());
				}
			}
		});
	
		cityComboBox.setPrefHeight(150);
		cityComboBox.setPrefWidth(150);
		cityComboBox.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<City>() {
			@Override
			public void changed(ObservableValue observable, City oldValue, City newValue) {
				try {
					business_logic.read_city(newValue.getCity_id());
					cityTextField.setText(business_logic.get_selected_city().getCity_name());
				} catch (Exception e) {
					errors.setText(e.getMessage());
				}
			}
		});
	
		GridPane grid = new GridPane();
		grid.setVgap(10);
		grid.setHgap(10);
		grid.setPadding(new Insets(10, 15, 10, 15));
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
	
		grid.add(errors, 0, 7);
	
	
		Group root = (Group)scene.getRoot();
		root.getChildren().add(grid);
		stage.setScene(scene);
		stage.setHeight(390);
		stage.setWidth(366);
		stage.show();
	}
	
	private void fill_country_list() {
		try {
			countryComboBox.getItems().setAll(business_logic.get_countries());
		} catch (Exception e) {
			errors.setText(e.getMessage());
		}
	}
	
	private void fill_city_list() {
		try {
			cityComboBox.getItems().setAll(business_logic.get_cities());
		} catch (Exception e) {
			errors.setText(e.getMessage());
		}
	}
	
	private void add_country() {
		try {
			business_logic.add_country(countryTextField.getText());
			fill_country_list();
			countryTextField.clear();
		} catch (Exception e) {
			errors.setText(e.getMessage());
		}
	}
	
	private void add_city() {
		try {
			business_logic.add_city(cityTextField.getText());
			fill_city_list();
			cityTextField.clear();
		} catch (Exception e) {
			errors.setText(e.getMessage());
		}
	}
	
	private void edit_country() {
		try {
			business_logic.change_country_name(countryTextField.getText());
			fill_country_list();
			countryTextField.clear();
		} catch (Exception e) {
			errors.setText(e.getMessage());
		}
	}
	
	private void edit_city() {
		try {
			business_logic.change_city_name(cityTextField.getText());
			fill_city_list();
			cityTextField.clear();
		} catch (Exception e) {
			errors.setText(e.getMessage());
		}
	}
	
	private void delete_country() {
		try {
			business_logic.delete_country();
			fill_country_list();
			cityComboBox.getItems().clear();
		} catch (Exception e) {
			errors.setText(e.getMessage());
		}
	}
	
	private void delete_city() {
		try {
			business_logic.delete_city();
			fill_city_list();
		} catch (Exception e) {
			errors.setText(e.getMessage());
		}
	}
}