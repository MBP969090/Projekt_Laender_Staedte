import javax.swing.*;


public class GUI {
    public static void main(String[] args)
    {
        JFrame projectJFrame = new JFrame();
        projectJFrame.setTitle("Project Länder - Städte");
        projectJFrame.setSize(500,900);
        JPanel panel = new JPanel();
        projectJFrame.setResizable(false);

//linke Seite
        String comboBoxListeCountry[] = {"Baden-Württemberg", "Bayern",
                "Berlin", "Brandenburg", "Bremen",
                "Hamburg", "Hessen", "Mecklenburg-Vorpommern",
                "Niedersachsen", "Nordrhein-Westfalen", "Rheinland-Pfalz",
                "Saarland", "Sachsen", "Sachsen-Anhalt",
                "Schleswig-Holstein", "Thüringen"};

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


//rechte Seite
        String comboBoxListeCity[] = {};

        JComboBox cityChooser = new JComboBox(comboBoxListeCity);
        JLabel cityLabel = new JLabel("Stadt");

        panel.setLayout(null);
        panel.add(cityLabel);
        cityLabel.setBounds(345, 60, 40, 10);
        panel.add(cityChooser);
        cityChooser.setBounds(300, 100, 140, 20);

        JTextField cityTextField = new JTextField("", 140);
        panel.add(cityTextField);
        cityTextField.setBounds(300, 140, 140, 20);



        /*https://www.java-tutorial.org/jcombobox.html*/
        projectJFrame.add(panel);
        projectJFrame.setVisible(true);
    }
}
