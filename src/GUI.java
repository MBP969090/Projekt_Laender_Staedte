import javax.swing.*;


public class GUI {
    private IBusiness_logic business_logic;
    public GUI (IBusiness_logic business_logic) {
        this.business_logic = business_logic;
    }
    public static void main(String[] args)
    {
        GUI gui = new GUI(new Business_logic_not_sorted(new SQL_Databasemanagement()));

        JFrame projectJFrame = new JFrame();
        projectJFrame.setTitle("Project Länder - Städte");
        projectJFrame.setSize(500,500);
        JPanel panel = new JPanel();
        projectJFrame.setResizable(false);

//linke Seite
        Country[] countries = gui.business_logic.get_countries();
        String comboBoxListeCountry[] = new String[countries.length];
        for(int i = 0; i < countries.length; i++) {
            comboBoxListeCountry[i] = countries[i].getCountry_name();
        }

        JComboBox countryChooser = new JComboBox(comboBoxListeCountry);
        JLabel countryLabel = new JLabel("Land");

        panel.setLayout(null);
        panel.add(countryLabel);
        countryLabel.setBounds(95, 60, 40, 10);
        panel.add(countryChooser);
        countryChooser.setBounds(50, 100, 140, 20);

        JTextField countryTextField = new JTextField("", 140);
        panel.add(countryTextField);
        countryTextField.setBounds(50, 140, 140, 20);

        JButton editCountryButton = new JButton("Bearbeiten");
        panel.add(editCountryButton);
        editCountryButton.setBounds(50, 170, 140, 20);

        JButton addCountryButton = new JButton("Hinzufügen");
        panel.add(addCountryButton);
        addCountryButton.setBounds(50, 193, 140, 20);

        JButton deleteCountryButton = new JButton("Löschen");
        panel.add(deleteCountryButton);
        deleteCountryButton.setBounds(50, 216, 140, 20);
//rechte Seite
        String townListComboBox[] = {};

        JComboBox townChooser = new JComboBox(townListComboBox);
        JLabel townLabel = new JLabel("Stadt");

        panel.setLayout(null);
        panel.add(townLabel);
        townLabel.setBounds(345, 60, 40, 10);
        panel.add(townChooser);
        townChooser.setBounds(300, 100, 140, 20);

        JTextField townTextField = new JTextField("", 140);
        panel.add(townTextField);
        townTextField.setBounds(300, 140, 140, 20);

        JButton editTownButton = new JButton("Bearbeiten");
        panel.add(editTownButton);
        editTownButton.setBounds(300, 170, 140, 20);

        JButton addTownButton = new JButton("Hinzufügen");
        panel.add(addTownButton);
        addTownButton.setBounds(300, 193, 140, 20);

        JButton deleteTownButton = new JButton("Löschen");
        panel.add(deleteTownButton);
        deleteTownButton.setBounds(300, 216, 140, 20);


        /*https://www.java-tutorial.org/jcombobox.html*/
        projectJFrame.add(panel);
        projectJFrame.setVisible(true);
    }
}
