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

        // create table from file data.txt

        JPanel centerPanel3 = new JPanel();
        centerPanel3.setLayout(new BoxLayout(centerPanel3, BoxLayout.Y_AXIS));


        String[] columnNames = {"STT","SLang Word", "Definition"};
        String data[][] ={{"1","2","3"}};


        //create table with data

        JTable listSlangWord = new JTable(data,columnNames);

        listSlangWord.getColumnModel().getColumn(0).setPreferredWidth(50);
        listSlangWord.getColumnModel().getColumn(1).setPreferredWidth(200);
        listSlangWord.getColumnModel().getColumn(2).setPreferredWidth(200);

        JScrollPane scrollPane = new JScrollPane(listSlangWord);

        // create 2 button reset and random

        JButton btnReset = new JButton("Reset");
        JButton btnRandom = new JButton("Random");

        JPanel centerPanel31 = new JPanel();
        centerPanel31.setLayout(new FlowLayout());

        //JScrollPane scrollPane = new JScrollPane(listSlangWord);
//        listSlangWord.setFillsViewportHeight(true);

        centerPanel31.add(btnReset);
        centerPanel31.add(Box.createRigidArea(new Dimension(20,10)));
        centerPanel31.add(btnRandom);

        centerPanel31.setBorder(BorderFactory.createLineBorder(Color.cyan));

        centerPanel3.add(scrollPane);
        centerPanel3.add(centerPanel31);

        centerPanel3.setPreferredSize(new Dimension(550, 200));
        centerPanel3.setMaximumSize(new Dimension(550, 300));  // hardCoded sizing
        centerPanel3.setMinimumSize(new Dimension(550, 300));  // hardCoded sizing

        centerPanel1.add(centerPanel3);



        // create bot panel
        JPanel botPanel = new JPanel();
        botPanel.setLayout(new BoxLayout(botPanel, BoxLayout.Y_AXIS));


        // creaye label đố vui mà combobox chọn câu hỏi tìm slang word hoặc tìm definition
        JPanel botPanel1 = new JPanel();
        botPanel1.setLayout(new FlowLayout());
        JLabel labelQuiz = new JLabel("Đố vui ");
        String listOptionQuiz[] = {"Tìm Slang word", "Tìm Definition"};
        JComboBox cbbQuiz = new JComboBox(listOptionQuiz);
        botPanel1.add(labelQuiz);
        botPanel1.add(Box.createRigidArea(new Dimension(20,0)));
        botPanel1.add(cbbQuiz);

        // tạo label question và câu hỏi
        JPanel botPanel2 = new JPanel();
        botPanel2.setLayout(new FlowLayout());
        JLabel labelQuestion = new JLabel("Question : ");
        JLabel textQuestion = new JLabel("My name is ?");
        botPanel2.add(labelQuestion);
        botPanel2.add(Box.createRigidArea(new Dimension(20,0)));
        botPanel2.add(textQuestion);

        // tạo 4 đáp án cho người dùng chọn
        JPanel botPanel3 = new JPanel(new GridLayout(2,2));

        JRadioButton answer1 = new JRadioButton("A");
        JRadioButton answer2 = new JRadioButton("B");
        JRadioButton answer3 = new JRadioButton("C");
        JRadioButton answer4 = new JRadioButton("D");

        botPanel3.add(answer1);
        botPanel3.add(answer2);
        botPanel3.add(answer3);
        botPanel3.add(answer4);

        botPanel3.setPreferredSize(new Dimension(360, 200));
        botPanel3.setMaximumSize(new Dimension(360, 300));  // hardCoded sizing
        botPanel3.setMinimumSize(new Dimension(360, 300));  // hardCoded sizing


        // tạo nút next để qua câu hỏi khác, nút answer để xem đáp án, nút stop để kết thúc
        JPanel botPanel4 = new JPanel(new FlowLayout());
        JButton btnShowAnswer = new JButton("Show answer ");
        JButton btnStop = new JButton("Stop");
        JButton btnNext = new JButton("Next");

        botPanel4.add(btnShowAnswer);
        botPanel4.add(Box.createRigidArea(new Dimension(20,10)));
        botPanel4.add(btnStop);
        botPanel4.add(Box.createRigidArea(new Dimension(20,10)));
        botPanel4.add(btnNext);


        // add 4 panel vào bot panel
        botPanel.add(botPanel1);
        botPanel.add(botPanel2);
        botPanel.add(botPanel3);
        botPanel.add(botPanel4);

        add(topPanel, BorderLayout.NORTH);
        add(centerPanel1, BorderLayout.CENTER);
        add(botPanel, BorderLayout.PAGE_END);


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
