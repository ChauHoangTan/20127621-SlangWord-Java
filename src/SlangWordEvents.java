package src;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Locale;
import java.util.Random;
import java.util.Set;
import javax.swing.*;

import static src.SlangWord.*;
import static src.SlangWordApplication.*;

public class SlangWordEvents implements ActionListener {

    static ArrayList<String[]> history = new ArrayList<>();

    static int indexAnswer ;

    public static String[][] searchFollowSlangWord(String text){


        ArrayList<ArrayList<String>> list = new ArrayList<>();

        text = text.toLowerCase();

        Set<String> keySet = treeMap.keySet();

        for (String key : keySet) {
            String tempSlangWord = key.toLowerCase();
//            System.out.println(index);
            if( tempSlangWord.indexOf(text) != -1 ){

                ArrayList<String> tmp = new ArrayList<>();
                tmp.add(key);
                tmp.add(treeMap.get(key));
                list.add(tmp);


            }

        }
        String dataSearch[][] = new String[list.size()][3];
        for(int i = 0; i < list.size(); i++){
            dataSearch[i][0] = String.valueOf(i+1);
            dataSearch[i][1] = list.get(i).get(0);
            dataSearch[i][2] = list.get(i).get(1);

        }

        return dataSearch;

    }


    public static String[][] searchFollowDefinition(String text){


        ArrayList<ArrayList<String>> list = new ArrayList<>();

        text = text.toLowerCase();

        Set<String> keySet = treeMap.keySet();
        int index = 0;
        for (String key : keySet) {
            String tempDefinition = treeMap.get(key).toLowerCase();
//            System.out.println(index);
            if( tempDefinition.indexOf(text) != -1 ){

                ArrayList<String> tmp = new ArrayList<>();
                tmp.add(key);
                tmp.add(treeMap.get(key));
                list.add(tmp);

                index ++;

            }

        }
        String dataSearch[][] = new String[list.size()][3];
        for(int i = 0; i < list.size(); i++){
            dataSearch[i][0] = String.valueOf(i+1);
            dataSearch[i][1] = list.get(i).get(0);
            dataSearch[i][2] = list.get(i).get(1);

        }

        return dataSearch;

    }


    public void handleAddButton(String slangText, String defiText){
        Set<String> keySet = treeMap.keySet();

        for (String key : keySet) {

//            System.out.println(index);
            if( slangText.equals(key)){

                createDialogForAdd(slangText,defiText, key);
                return;
            }

        }

        treeMap.put(slangText,defiText);
    }

    public static void loadDataTable(){
        Set<String> keySet = treeMap.keySet();

        String data[][] = new String[treeMap.size()][3];
        int index = 0;
        for (String key : keySet) {
            data[index][0] = String.valueOf(index+1);
            data[index][1] = key;
            data[index][2] = treeMap.get(key);
            index++;

        }
        model.setRowCount(0);
        for( int i = 0; i < treeMap.size(); i++) {
            model.addRow(data[i]);
        }
    }

    public static void quiz() {
        int selection = cbbQuiz.getSelectedIndex();
        int size = treeMap.size();


        Random generator = new Random();
        int indexQuestion = generator.nextInt(size);

        ArrayList<Integer> list = new ArrayList<>();
        list.add(indexQuestion);
        while(list.size() < 4){
            int rand = generator.nextInt(size);
            for(int i = 0; i < list.size(); i++){
                if(list.get(i) == rand){
                    break;
                }
            }
            list.add(rand);

        }


        list.remove(0);
        indexAnswer = generator.nextInt(4);
        list.add(indexAnswer,indexQuestion);

        Set<String> keySet = treeMap.keySet();
        String data[][] = new String[treeMap.size()][3];
        int index = 0;
        for (String key : keySet) {
            data[index][0] = String.valueOf(index+1);
            data[index][1] = key;
            data[index][2] = treeMap.get(key);
            index++;
        }
        if(selection == 0){

            textQuestion.setText(data[indexQuestion][1]);

            answer1.setText(data[list.get(0)][2]);
            answer2.setText(data[list.get(1)][2]);
            answer3.setText(data[list.get(2)][2]);
            answer4.setText(data[list.get(3)][2]);

        }
        else{
            textQuestion.setText(data[indexQuestion][2]);

            answer1.setText(data[list.get(0)][1]);
            answer2.setText(data[list.get(1)][1]);
            answer3.setText(data[list.get(2)][1]);
            answer4.setText(data[list.get(3)][1]);
        }
    }


    public void actionPerformed(ActionEvent ae){


        String getCommand = ae.getActionCommand();
        if(getCommand == "history") {
            createFrameHistory();
        }
        if(getCommand == "search") {

            model.setRowCount(0);
            int selection = cbbSelectOptionSearch.getSelectedIndex();

            // nếu index của cbb là 0 thì search theo slang word, 1 thì theo definition
            if(selection == 1){
                String listData[][] = searchFollowSlangWord(fieldSearch.getText());
                for( int i = 0; i < listData.length; i++){
                    model.addRow(listData[i]);
                    history.add(listData[i]);
                }
            }
            else{
                String listData[][] = searchFollowDefinition(fieldSearch.getText());
                for( int i = 0; i < listData.length; i++){
                    model.addRow(listData[i]);
                    history.add(listData[i]);
                }
            }

        }
        if(getCommand == "add") {

            handleAddButton(slangWordTextField.getText(),definitionTextField.getText());
            loadDataTable();
        }
        if(getCommand == "edit") {
            // chọn vào 1 ô trong table thì giá trị trong ô đó sẽ hiển thị trên text field, sau đó muốn edit thì nhập
            // text field đó

            treeMap.put(slangWordTextField.getText(),definitionTextField.getText());
            loadDataTable();

        }
        if(getCommand == "delete") {
            createDialogForDelete(slangWordTextField.getText());
        }
        if(getCommand == "reset"){

            model.setRowCount(0);
            for( int i = 0; i < rootData.length; i++){
                model.addRow(rootData[i]);
            }
        }
        if(getCommand == "random") {
            int size = treeMap.size();
            Random generator = new Random();
            int value = generator.nextInt(size);

            Set<String> keySet = treeMap.keySet();
            String data[][] = new String[treeMap.size()][3];
            int index = 0;
            for (String key : keySet) {
                data[index][0] = String.valueOf(index+1);
                data[index][1] = key;
                data[index][2] = treeMap.get(key);
                index++;
            }

            model.setRowCount(0);
            model.addRow(data[value]);
        }
        if(getCommand == "resetRandom"){
            loadDataTable();
        }

        if(getCommand == "start"){

            quiz();
        }

        if(getCommand == "showAnswer"){


            if(answer1.isSelected()){
                answer1.setForeground(Color.red);
            }
            else if(answer2.isSelected()){
                answer2.setForeground(Color.red);
            }
            else if(answer3.isSelected()){
                answer3.setForeground(Color.red);
            }
            else{
                answer4.setForeground(Color.red);
            }

            if(indexAnswer == 0){
                answer1.setForeground(Color.blue);
            }
            else if(indexAnswer == 1){
                answer2.setForeground(Color.blue);
            }
            else if(indexAnswer == 2){
                answer3.setForeground(Color.blue);
            }
            else{
                answer4.setForeground(Color.blue);
            }

        }

        if(getCommand == "stop"){

            textQuestion.setText("");
            answer1.setText("");
            answer2.setText("");
            answer3.setText("");
            answer4.setText("");

        }

        if(getCommand == "next"){
            answer1.setForeground(Color.black);
            answer2.setForeground(Color.black);
            answer3.setForeground(Color.black);
            answer4.setForeground(Color.black);

            quiz();
        }
        if(getCommand == "save")
            writeDataToFile();


    }
}
