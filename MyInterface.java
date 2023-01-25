import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.ScrollPaneConstants;
import javax.swing.border.EtchedBorder;
import javax.swing.border.TitledBorder;
import java.awt.Color;
import java.awt.*;
import java.awt.event.*;
import java.util.Comparator;
import java.util.List;

public class MyInterface extends JFrame implements ActionListener {
    private static List<Personne> tribu;
    // Import
    private static JButton buttonAgeAuDeces = new JButton("Age au décés");
    private static JButton buttonAnneeDeNaissance = new JButton("Année de naissance");
    private static JButton buttonAnneeDeces = new JButton("Année du décés");
    private static JRadioButton buttonCroissant = new JRadioButton("Croissant");
    private static JRadioButton buttonDeroissant = new JRadioButton("Décroissant");
    private static JButton buttonClear = new JButton("Effacer");
    private static JButton buttonExit = new JButton("Quitter");
    private static JTextArea textArea = new JTextArea(16, 58);

    public MyInterface(List<Personne> tribu) {
        MyInterface.tribu = tribu;
        // Couleurs
        Color mycolor = new Color(50, 50, 50);
        Color mycolor2 = new Color(255, 255, 255);

        // Frame qui contient le Panel main
        JFrame frame = new JFrame("Base de données");

        // Panel qui contient tout les autres Panel
        JPanel main = new JPanel(new FlowLayout(FlowLayout.CENTER, 0, 0));

        // Panel 1
        JPanel newPanel1 = new JPanel(new GridBagLayout());
        GridBagConstraints constraints = new GridBagConstraints();
        constraints.anchor = GridBagConstraints.WEST;
        constraints.insets = new Insets(10, 10, 10, 10);

        // Radio btn
        ButtonGroup bg = new ButtonGroup();
        bg.add(buttonCroissant);
        bg.add(buttonDeroissant);
        buttonCroissant.setSelected(true);

        // Bordure du Panel et son nom
        newPanel1.setBorder(
                BorderFactory.createTitledBorder(null, "Choisir un tri !", TitledBorder.LEFT, TitledBorder.TOP,
                        new Font("", Font.BOLD, 14), Color.WHITE));

        // Composant ajouter au Panel
        constraints.anchor = GridBagConstraints.WEST;
        constraints.gridx = 0;
        constraints.gridy = 0;
        newPanel1.add(buttonAgeAuDeces, constraints);

        constraints.gridx = 1;
        newPanel1.add(buttonAnneeDeNaissance, constraints);

        constraints.gridx = 2;
        newPanel1.add(buttonAnneeDeNaissance, constraints);

        constraints.gridx = 3;
        newPanel1.add(buttonAnneeDeces, constraints);

        constraints.gridx = 4;
        newPanel1.add(buttonCroissant, constraints);

        constraints.gridx = 5;
        newPanel1.add(buttonDeroissant, constraints);

        constraints.gridx = 6;
        newPanel1.add(buttonClear, constraints);

        constraints.gridx = 7;
        newPanel1.add(buttonExit, constraints);

        JPanel middlePanel = new JPanel();
        middlePanel.setBorder(new TitledBorder(new EtchedBorder(), "Display Area"));

        // Panel 2
        JScrollPane newPanel2 = new JScrollPane(textArea);
        newPanel2.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
        textArea.setEditable(false);

        // set data
        for (int i = 0; i < tribu.size(); i++) {
            textArea.append(tribu.get(i).toString());
        }
        // Couleur de Background
        newPanel1.setBackground(mycolor);
        newPanel2.setBackground(mycolor);

        // Couleur de la police
        // labelChoisiruUnTri.setForeground(mycolor2);

        // Couleur du background
        main.setBackground(mycolor);
        main.setForeground(mycolor2);

        middlePanel.add(newPanel2);
        // Ajout des Panel au Panel main
        main.add(newPanel1);
        main.add(middlePanel);

        buttonClear.addActionListener(this);
        buttonExit.addActionListener(this);
        buttonAgeAuDeces.addActionListener(this);
        buttonAnneeDeNaissance.addActionListener(this);
        buttonAnneeDeces.addActionListener(this);

        // Parametre de la Frame
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(1200, 600);
        frame.getContentPane().add(main, BorderLayout.CENTER);
        frame.getContentPane().setBackground(mycolor);

        frame.setVisible(true);
        frame.setLocationRelativeTo(null);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == buttonClear) {
            textArea.setText("");
        }

        if (e.getSource() == buttonExit) {
            System.exit(0);
        }

        if (e.getSource() == buttonAgeAuDeces) {
            textArea.setText("");
            if (buttonCroissant.isSelected())
                tribu.sort(Comparator.comparing(Personne::getAge));
            else
                tribu.sort(Comparator.comparing(Personne::getAge).reversed());

            // set data
            for (int i = 0; i < tribu.size(); i++) {
                textArea.append(tribu.get(i).toString());
            }
        }
        if (e.getSource() == buttonAnneeDeNaissance) {
            textArea.setText("");
            if (buttonCroissant.isSelected())
                tribu.sort(Comparator.comparing(Personne::getAnneeNaissance));
            else
                tribu.sort(Comparator.comparing(Personne::getAnneeNaissance).reversed());

            // set data
            for (int i = 0; i < tribu.size(); i++) {
                textArea.append(tribu.get(i).toString());
            }
        }

        if (e.getSource() == buttonAnneeDeces) {
            textArea.setText("");
            if (buttonCroissant.isSelected())
                tribu.sort(Comparator.comparing(Personne::getAnneeDeces));
            else
                tribu.sort(Comparator.comparing(Personne::getAnneeDeces).reversed());
            // set data
            for (int i = 0; i < tribu.size(); i++) {
                textArea.append(tribu.get(i).toString());

            }
        }
    }

}
