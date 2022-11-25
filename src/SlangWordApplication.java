package src;
import javax.swing.*;
import java.awt.*;

public class SlangWordApplication extends JPanel {


    SlangWordApplication (){
        setLayout(new BorderLayout());

        // top panel
        JPanel topPanel = new JPanel();
        topPanel.setLayout(new FlowLayout());

        JButton btnSearch = new JButton("Search");
        btnSearch.setAlignmentX(0);

        JTextField fieldSearch = new JTextField("",20);

        String listOption[] = {"Slang Word to Definition", "Definition to Slang Word"};
        JComboBox cbbSelectOptionSearch = new JComboBox(listOption);
        cbbSelectOptionSearch.setAlignmentX(1);

        JButton btnHistory = new JButton("History");

        topPanel.add(btnHistory);
        topPanel.add(cbbSelectOptionSearch);
        topPanel.add(fieldSearch);
        topPanel.add(btnSearch);


        // Center left panel, add feature add, edit, delete slang word
        JPanel centerPanel = new JPanel(new FlowLayout());

        JPanel centerPanel1 = new JPanel();
        centerPanel1.setLayout(new BoxLayout(centerPanel1, BoxLayout.Y_AXIS));

        JPanel panelSlangWordField = new JPanel();
        panelSlangWordField.setLayout(new FlowLayout());
        JLabel slangWordLabel = new JLabel("Slang Word ");
        JTextField slangWordTextField = new JTextField(10);
        panelSlangWordField.add(slangWordLabel);
        panelSlangWordField.add(slangWordTextField);

        JPanel panelDefinitionField = new JPanel();
        panelDefinitionField.setLayout(new FlowLayout());
        JLabel definitionLabel = new JLabel("Definition   ");
        JTextField definitionTextField = new JTextField(10);
        panelDefinitionField.add(definitionLabel);
        panelDefinitionField.add(definitionTextField);

        panelSlangWordField.setPreferredSize(new Dimension(250, 40));
        panelSlangWordField.setMaximumSize(new Dimension(250, 35));  // hardCoded sizing
        panelSlangWordField.setMinimumSize(new Dimension(200, 35));  // hardCoded sizing

        panelDefinitionField.setPreferredSize(new Dimension(50, 40));
        panelDefinitionField.setMaximumSize(new Dimension(250, 35));  // hardCoded sizing
        panelDefinitionField.setMinimumSize(new Dimension(200, 35));  // hardCoded sizing

        panelSlangWordField.setBorder(BorderFactory.createLineBorder(Color.cyan));
        panelDefinitionField.setBorder(BorderFactory.createLineBorder(Color.cyan));

        centerPanel1.add(panelSlangWordField);
        centerPanel1.add(panelDefinitionField);

        // add 3 button add, delete, edit
        JPanel centerPanel2 = new JPanel();
        centerPanel2.setLayout(new FlowLayout());

        JButton btnAdd = new JButton("Add");
        JButton btnEdit = new JButton("Edit");
        JButton btnDelete = new JButton("Delete");

        centerPanel2.add(btnAdd);
        centerPanel2.add(Box.createRigidArea(new Dimension(20,0)));
        centerPanel2.add(btnEdit);
        centerPanel2.add(Box.createRigidArea(new Dimension(19,0)));
        centerPanel2.add(btnDelete);

        centerPanel2.setBorder(BorderFactory.createLineBorder(Color.cyan));
        centerPanel2.setPreferredSize(new Dimension(50, 40));
        centerPanel2.setMaximumSize(new Dimension(250, 35));  // hardCoded sizing
        centerPanel2.setMinimumSize(new Dimension(200, 35));  // hardCoded sizing


        centerPanel1.add(centerPanel2);
        //


        add(topPanel, BorderLayout.NORTH);
        add(centerPanel1, BorderLayout.CENTER);

    }

    public static void createShowGUI(){
        JFrame frame = new JFrame("Slang Word Dictionary!");
        frame.setDefaultCloseOperation(frame.EXIT_ON_CLOSE);

        SlangWordApplication newPanel = new SlangWordApplication();

        newPanel.setOpaque(true);

        frame.setContentPane(newPanel);

        frame.setVisible(true);
        frame.pack();
    }

    public static void main(String []args){
        createShowGUI();
    }

}
