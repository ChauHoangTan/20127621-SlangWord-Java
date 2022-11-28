package src;
import javax.swing.*;
import javax.swing.event.AncestorEvent;
import javax.swing.event.AncestorListener;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Map;
import java.util.Set;
import javax.swing.table.*;

import static src.SlangWord.*;
import static src.SlangWordEvents.history;
import static src.SlangWordEvents.loadDataTable;

public class SlangWordApplication extends JPanel {
    static JFrame frame;
    JPanel topPanel,centerPanel1,panelSlangWordField,panelDefinitionField,centerPanel2,centerPanel3,centerPanel31,
            botPanel,botPanel1,botPanel2,botPanel3,botPanel4,botPanel5;
    JButton btnSearch,btnHistory,btnAdd,btnEdit,btnDelete,btnReset,btnRandom,btnSave,btnShowAnswer,btnNext,btnStop,btnStart,btnResetRandom;

    static JLabel slangWordLabel,definitionLabel,labelQuiz,labelQuestion,textQuestion;

    static JRadioButton answer1,answer2,answer3,answer4;

    static ButtonGroup btg;
    static JTextField fieldSearch,slangWordTextField,definitionTextField;

    static TableModel tableModel;
    static JTable listSlangWord;

    static DefaultTableModel model;

    static JComboBox cbbSelectOptionSearch,cbbQuiz;

    static SlangWordEvents swe = new SlangWordEvents();

    SlangWordApplication (){


        setLayout(new BorderLayout());

        // top panel
        topPanel = new JPanel();
        topPanel.setLayout(new FlowLayout());

        btnSearch = new JButton("Search");
        btnSearch.setAlignmentX(0);
        btnSearch.addActionListener(swe);
        btnSearch.setActionCommand("search");


        fieldSearch = new JTextField("",20);

        String listOption[] = {"Slang Word to Definition", "Definition to Slang Word"};
        cbbSelectOptionSearch = new JComboBox(listOption);
        cbbSelectOptionSearch.setAlignmentX(1);

        btnHistory = new JButton("History");

        btnHistory.addActionListener(swe);
        btnHistory.setActionCommand("history");

        topPanel.add(btnHistory);
        topPanel.add(cbbSelectOptionSearch);
        topPanel.add(fieldSearch);
        topPanel.add(btnSearch);


        // Center left panel, add feature add, edit, delete slang word

        centerPanel1 = new JPanel();
        centerPanel1.setLayout(new BoxLayout(centerPanel1, BoxLayout.Y_AXIS));

        panelSlangWordField = new JPanel();
        panelSlangWordField.setLayout(new FlowLayout());
        slangWordLabel = new JLabel("Slang Word ");
        slangWordTextField = new JTextField(15);
        panelSlangWordField.add(slangWordLabel);
        panelSlangWordField.add(slangWordTextField);

        panelDefinitionField = new JPanel();
        panelDefinitionField.setLayout(new FlowLayout());
        definitionLabel = new JLabel("Definition   ");
        definitionTextField = new JTextField(15);
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
        centerPanel2 = new JPanel();
        centerPanel2.setLayout(new FlowLayout());

        btnAdd = new JButton("Add");
        btnEdit = new JButton("Edit");
        btnDelete = new JButton("Delete");

        // thêm vào xử lý sự kiện cho add, edit, delete
        btnAdd.addActionListener(swe);
        btnAdd.setActionCommand("add");

        btnEdit.addActionListener(swe);
        btnEdit.setActionCommand("edit");

        btnDelete.addActionListener(swe);
        btnDelete.setActionCommand("delete");


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

        centerPanel3 = new JPanel();
        centerPanel3.setLayout(new BoxLayout(centerPanel3, BoxLayout.Y_AXIS));


        String[] columnNames = {"STT","SLang Word", "Definition"};


        //create table with data
        model = new DefaultTableModel(rootData,columnNames);

        listSlangWord = new JTable(model);

        listSlangWord.getColumnModel().getColumn(0).setPreferredWidth(50);
        listSlangWord.getColumnModel().getColumn(1).setPreferredWidth(200);
        listSlangWord.getColumnModel().getColumn(2).setPreferredWidth(200);


        JScrollPane scrollPane = new JScrollPane(listSlangWord);

        listSlangWord.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {
                if(listSlangWord.getSelectedRow() != -1){
                    int selectionEdit = listSlangWord.getSelectedRow();
                    slangWordTextField.setText((String)listSlangWord.getValueAt(selectionEdit,1));
                    definitionTextField.setText((String)listSlangWord.getValueAt(selectionEdit,2));
                }
            }
        });

        // create 2 button reset and random

        btnReset = new JButton("Reset");
        btnRandom = new JButton("Random");
        btnResetRandom = new JButton("Reset Random");

        centerPanel31 = new JPanel();
        centerPanel31.setLayout(new FlowLayout());

        //JScrollPane scrollPane = new JScrollPane(listSlangWord);
//        listSlangWord.setFillsViewportHeight(true);

        centerPanel31.add(btnReset);
        centerPanel31.add(Box.createRigidArea(new Dimension(20,10)));
        centerPanel31.add(btnRandom);
        centerPanel31.add(Box.createRigidArea(new Dimension(20,10)));
        centerPanel31.add(btnResetRandom);

        btnRandom.addActionListener(swe);
        btnReset.addActionListener(swe);
        btnRandom.setActionCommand("random");
        btnReset.setActionCommand("reset");
        btnResetRandom.addActionListener(swe);
        btnResetRandom.setActionCommand("resetRandom");

        centerPanel31.setBorder(BorderFactory.createLineBorder(Color.cyan));

        centerPanel3.add(scrollPane);
        centerPanel3.add(centerPanel31);

        centerPanel3.setPreferredSize(new Dimension(550, 200));
        centerPanel3.setMaximumSize(new Dimension(550, 300));  // hardCoded sizing
        centerPanel3.setMinimumSize(new Dimension(550, 300));  // hardCoded sizing

        centerPanel1.add(centerPanel3);



        // create bot panel
        botPanel = new JPanel();
        botPanel.setLayout(new BoxLayout(botPanel, BoxLayout.Y_AXIS));


        // creaye label đố vui mà combobox chọn câu hỏi tìm slang word hoặc tìm definition
        botPanel1 = new JPanel();
        botPanel1.setLayout(new FlowLayout());
        labelQuiz = new JLabel("Đố vui ");
        String listOptionQuiz[] = {"Slang word", "Definition"};
        cbbQuiz = new JComboBox(listOptionQuiz);

        btnStart = new JButton("Start");
        btnStart.addActionListener(swe);
        btnStart.setActionCommand("start");

        botPanel1.add(labelQuiz);
        botPanel1.add(Box.createRigidArea(new Dimension(20,0)));
        botPanel1.add(cbbQuiz);
        botPanel1.add(Box.createRigidArea(new Dimension(20,0)));
        botPanel1.add(btnStart);
        // tạo label question và câu hỏi
        botPanel2 = new JPanel();
        botPanel2.setLayout(new FlowLayout());
        labelQuestion = new JLabel("Question : ");
        textQuestion = new JLabel("My name is ?");
        botPanel2.add(labelQuestion);
        botPanel2.add(Box.createRigidArea(new Dimension(20,0)));
        botPanel2.add(textQuestion);

        // tạo 4 đáp án cho người dùng chọn
        botPanel3 = new JPanel(new GridLayout(2,2));

        answer1 = new JRadioButton("A");
        answer2 = new JRadioButton("B");
        answer3 = new JRadioButton("C");
        answer4 = new JRadioButton("D");

        btg = new ButtonGroup();
        btg.add(answer1);
        btg.add(answer2);
        btg.add(answer3);
        btg.add(answer4);

        botPanel3.add(answer1);
        botPanel3.add(answer2);
        botPanel3.add(answer3);
        botPanel3.add(answer4);

        botPanel3.setPreferredSize(new Dimension(360, 200));
        botPanel3.setMaximumSize(new Dimension(360, 300));  // hardCoded sizing
        botPanel3.setMinimumSize(new Dimension(360, 300));  // hardCoded sizing


        // tạo nút next để qua câu hỏi khác, nút answer để xem đáp án, nút stop để kết thúc
        botPanel4 = new JPanel(new FlowLayout());
        btnShowAnswer = new JButton("Show answer ");
        btnStop = new JButton("Stop");
        btnNext = new JButton("Next");

        btnShowAnswer.addActionListener(swe);
        btnShowAnswer.setActionCommand("showAnswer");

        btnStop.addActionListener(swe);
        btnStop.setActionCommand("stop");

        btnNext.addActionListener(swe);
        btnNext.setActionCommand("next");

        botPanel4.add(btnShowAnswer);
        botPanel4.add(Box.createRigidArea(new Dimension(20,10)));
        botPanel4.add(btnStop);
        botPanel4.add(Box.createRigidArea(new Dimension(20,10)));
        botPanel4.add(btnNext);

        botPanel5 = new JPanel(new FlowLayout(FlowLayout.RIGHT));
        btnSave = new JButton("Save");

        btnSave.addActionListener(swe);
        btnSave.setActionCommand("save");

        botPanel5.add(btnSave);

        // add 4 panel vào bot panel
        botPanel.add(botPanel1);
        botPanel.add(botPanel2);
        botPanel.add(botPanel3);
        botPanel.add(botPanel4);
        botPanel.add(botPanel5);

        add(topPanel, BorderLayout.NORTH);
        add(centerPanel1, BorderLayout.CENTER);
        add(botPanel, BorderLayout.PAGE_END);



    }

    public static void createFrameHistory(){
        JFrame frame = new JFrame("History");


        JPanel panelHistory = new JPanel();

        String field[] = {"STT", "Slang Word","Definition"};

        ArrayList<String[]> data = history;

        String dataHistory[][] = new String[data.size()][3];
        for(int i = 0; i < data.size(); i++){
            dataHistory[i][0] = data.get(i)[0];
            dataHistory[i][1] = data.get(i)[1];
            dataHistory[i][2] = data.get(i)[2];
        }
        JTable tableHistory = new JTable(dataHistory,field);
        JScrollPane scrollPane = new JScrollPane(tableHistory);

        tableHistory.getColumnModel().getColumn(0).setPreferredWidth(50);
        tableHistory.getColumnModel().getColumn(1).setPreferredWidth(200);
        tableHistory.getColumnModel().getColumn(2).setPreferredWidth(200);

        panelHistory.setPreferredSize(new Dimension(550, 500));
        panelHistory.setMaximumSize(new Dimension(550, 100));  // hardCoded sizing
        panelHistory.setMinimumSize(new Dimension(550, 500));  // hardCoded sizing

        panelHistory.add(scrollPane);

        panelHistory.setOpaque(true);

        frame.setContentPane(panelHistory);
        frame.setVisible(true);
        frame.pack();
    }

    public static void createDialogForAdd(String slangText, String defiText, String key){

        JDialog dialog = new JDialog(frame,"Dialog add button");

        JPanel panelDialog = new JPanel();
        panelDialog.setLayout(new BoxLayout(panelDialog,BoxLayout.Y_AXIS));

        JLabel label = new JLabel("What do you want, overwrite or duplicate this slang word ?");

        JPanel panelBtn = new JPanel(new FlowLayout());
        JButton overwrite = new JButton("Overwrite");
        overwrite.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                treeMap.put(key,defiText);

                loadDataTable();
                dialog.setVisible(false);
            }
        });

        JButton duplicate = new JButton("Duplicate");
        duplicate.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String newValue = treeMap.get(key) + "| "+ defiText;
                treeMap.put(key,newValue);

                loadDataTable();
                dialog.setVisible(false);
            }
        });


        JButton cancel = new JButton("Cancel");
        cancel.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                slangWordTextField.setText("");
                definitionTextField.setText("");
                dialog.setVisible(false);
            }
        });


        panelBtn.add(overwrite);
        panelBtn.add(duplicate);
        panelBtn.add(cancel);

        panelDialog.add(label);
        panelDialog.add(panelBtn);

        dialog.add(panelDialog);

        dialog.setSize(400, 400);

        dialog.setVisible(true);
        dialog.pack();

    }


    public static void createDialogForDelete(String key){

        JDialog dialog = new JDialog(frame,"Dialog delete button");

        JPanel panelDialog = new JPanel();
        panelDialog.setLayout(new BoxLayout(panelDialog,BoxLayout.Y_AXIS));

        JLabel label = new JLabel("Are you sure to delete this slang word ???");

        JPanel panelBtn = new JPanel(new FlowLayout());
        JButton yes = new JButton("Yes");
        yes.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                treeMap.remove(key);

                loadDataTable();
                dialog.setVisible(false);
            }
        });

        JButton no = new JButton("No");
        no.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                slangWordTextField.setText("");
                definitionTextField.setText("");
                dialog.setVisible(false);
            }
        });

        panelBtn.add(yes);
        panelBtn.add(no);

        panelDialog.add(label);
        panelDialog.add(panelBtn);

        dialog.add(panelDialog);

        dialog.setSize(400, 400);

        dialog.setVisible(true);
        dialog.pack();

    }

    public static void createShowGUI(){
        frame = new JFrame("Slang Word Dictionary!");
        frame.setDefaultCloseOperation(frame.EXIT_ON_CLOSE);

        SlangWordApplication newPanel = new SlangWordApplication();

        newPanel.setOpaque(true);

        frame.setContentPane(newPanel);

        frame.setVisible(true);
        frame.pack();


    }

    public static void main(String []args){
        readDataFromFile();
        rootData = new String[SlangWord.treeMap.size()][3];
        int i = 0;
        for (Map.Entry<String, String> entry : SlangWord.treeMap.entrySet()) {

            rootData[i][0] = String.valueOf(i+1);
            rootData[i][1] = entry.getKey();
            rootData[i][2] = entry.getValue();
            i++;
        }


        createShowGUI();
    }

}
