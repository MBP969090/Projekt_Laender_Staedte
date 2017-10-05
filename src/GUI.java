import javax.swing.*;


public class GUI {
    public static void main(String[] args)
    {
        JFrame projectJFrame = new JFrame();
        projectJFrame.setTitle("Project Länder - Städte");
        projectJFrame.setSize(500,900);
        JPanel panel = new JPanel();


        String comboBoxListe[] = {"Baden-Württemberg", "Bayern",
                "Berlin", "Brandenburg", "Bremen",
                "Hamburg", "Hessen", "Mecklenburg-Vorpommern",
                "Niedersachsen", "Nordrhein-Westfalen", "Rheinland-Pfalz",
                "Saarland", "Sachsen", "Sachsen-Anhalt",
                "Schleswig-Holstein", "Thüringen"};

        JComboBox countryChooser = new JComboBox(comboBoxListe);

        JLabel countryLabel = new JLabel("Land", JLabel.LEFT);


        panel.add(countryLabel);
        panel.add(countryChooser);



        /*JLabel label = new JLabel ("Land", JLabel.LEFT);
        label.setVerticalAlignment(JLabel.TOP);
        projectJDialog.add(label);*/

        /*https://www.java-tutorial.org/jcombobox.html*/
        projectJFrame.add(panel);
        projectJFrame.setVisible(true);
    }
}
