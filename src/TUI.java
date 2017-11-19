import java.util.Scanner;

/**
 * Created by Peter on 09.11.2017.
 */
public class TUI {
	private IBusiness_logic business_logic;
	private Scanner scanner;
	public TUI(IBusiness_logic business_logic) {
		this.business_logic = business_logic;
		scanner = new Scanner(System.in);
		start();
	}
	
	private IBusiness_logic get_business_logic() {
		if(business_logic == null) {
			throw new NullPointerException("Kein Fachkonzept gewählt");
		}
		return business_logic;
	}
	
	private void start() {
		boolean exited = false;
		while(!exited) {
			try {
				print_menu();
				get_business_logic().set_selected_city(null);
				get_business_logic().set_selected_country(null);
				switch (get_user_option()) {
					case 0:
						exited = true;
						System.out.println("Bye");
						break;
					case 1:
						print_country_list();
						break;
					case 2:
						print_country_edit_dialog();
						break;
					case 3:
						print_country_add_dialog();
						break;
					case 4:
						print_country_delete_dialog();
						break;
					case 5:
						print_city_list();
						break;
					case 6:
						print_city_edit_dialog();
						break;
					case 7:
						print_city_add_dialog();
						break;
					case 8:
						print_city_delete_dialog();
						break;
					case 9:
						print_all_list();
						break;
					default:
						break;
				}
				System.out.print("Zurück zum Menü");
				System.in.read();
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
		}
	}
	
	private void print_menu(){
		String output = "";
		output += "Projekt: Länder - Städte Zuordnung\n";
		output += "----------------------------------\n";
		output += "(1) Länder anzeigen\n";
		output += "(2) Land bearbeiten\n";
		output += "(3) Land hinzufügen\n";
		output += "(4) Land löschen\n";
		output += "----------------------------------\n";
		output += "(5) Städte anzeigen\n";
		output += "(6) Stadt bearbeiten\n";
		output += "(7) Stadt hinzufügen\n";
		output += "(8) Stadt löschen\n";
		output += "----------------------------------\n";
		output += "(9) Alles anzeigen\n";
		output += "----------------------------------\n";
		output += "(0) Beenden\n";
		
		System.out.println(output);
	}
	
	private int get_user_option() {
		System.out.print("Bitte geben Sie eine Nummer ein: ");
		int option;
		try {
			option = Integer.parseInt(scanner.next());
		}catch(NumberFormatException nfe) {
			System.out.println("Eingabe war falsch!");
			return get_user_option();
		}
		System.out.println("");
		return option;
	}
	
	private void print_country_list() {
		String output = "Länder: \n";
		for(Country country: get_business_logic().get_countries()) {
			output += "("+country.getCountry_id()+") "+country.getCountry_name()+"\n";
		}
		System.out.println(output);
	}
	
	private void print_city_list() {
		print_country_list();
		String output = "";
		System.out.println("Für welches Land wollen Sie die Städte sehen?");
		try {
			get_business_logic().read_country(get_user_option());
		} catch(Exception e) {
			System.out.println(e.getMessage());
			return;
		}
		output = "Städte in "+get_business_logic().get_selected_country().getCountry_name()+"\n";
		for(City city: get_business_logic().get_cities()) {
			output += "(" + city.getCity_id() + ") " + city.getCity_name() + "\n";
		}
		System.out.println(output);
	}
	
	private void print_city_list(int country_id) {
		String output = "";
		try {
			get_business_logic().read_country(country_id);
		} catch(Exception e) {
			System.out.println(e.getMessage());
			return;
		}
		for(City city: get_business_logic().get_cities()) {
			output += "("+city.getCity_id()+") "+city.getCity_name()+"\n";
		}
		System.out.println(output);
	}
	
	private void print_country_edit_dialog() {
		print_country_list();
		System.out.println("Welches Land wollen Sie bearbeiten?");
		int country_id = get_user_option();
		try {
			get_business_logic().read_country(country_id);
		} catch (Exception e) {
			System.out.println(e.getMessage());
			return;
		}
		System.out.println("Wie soll der neue Name heißen?");
		String input = scanner.next();
		get_business_logic().change_country_name(input);
	}
	
	private void print_city_edit_dialog() {
		print_country_list();
		System.out.println("Für welches Land wollen Sie eine Stadt bearbeiten?");
		int country_id = get_user_option();
		try {
			get_business_logic().read_country(country_id);
			print_city_list(country_id);
			System.out.println("Welche Stadt wollen Sie bearbeiten?");
			get_business_logic().read_city(get_user_option());
		} catch (Exception e) {
			System.out.println(e.getMessage());
			return;
		}
		System.out.println("Wie soll der neue Name heißen?");
		String input = scanner.next();
		get_business_logic().change_city_name(input);
	}
	
	private void print_country_add_dialog() {
		System.out.print("Bitte nennen sie den Namen für das neue Land: ");
		String input = scanner.next();
		get_business_logic().add_country(input);
	}
	
	private void print_city_add_dialog() {
		print_country_list();
		System.out.println("Für welches Land wollen Sie eine Stadt hinzufügen?");
		try {
			get_business_logic().read_country(get_user_option());
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		System.out.print("Bitte nennen sie den Namen für das die neue Stadt: ");
		String input = scanner.next();
		get_business_logic().add_city(input);
	}
	
	private void print_country_delete_dialog() {
		print_country_list();
		System.out.println("Welches Land soll gelöscht werden?");
		try {
			get_business_logic().read_country(get_user_option());
			get_business_logic().delete_country();
		}catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
	
	private void print_city_delete_dialog() {
		print_country_list();
		System.out.println("Für welches Land wollen Sie eine Stadt löschen?");
		try {
			int country_id = get_user_option();
			get_business_logic().read_country(country_id);
			print_city_list(country_id);
			System.out.println("Welche Stadt soll gelöscht werden?");
			get_business_logic().read_city(get_user_option());
			get_business_logic().delete_city();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

	private void print_all_list() {
		String output = "";
		for(Country country: get_business_logic().get_countries()) {
			output += country.getCountry_name()+"\n";
			get_business_logic().set_selected_country(country);
			for(City city: get_business_logic().get_cities()) {
				output += "\t"+city.getCity_name()+"\n";
			}
			output += "\n";
		}

		System.out.println(output);
	}
}
