package src;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

import static src.SlangWordApplication.listSlangWord;
import static src.SlangWordApplication.model;

public class SlangWordEvents implements ActionListener {

    String test[][] = {{"Hello","Nice to meet you","Hi"},
            {"Hello","Nice to meet you","Hi"},
            {"Hello","Nice to meet you","Hi"}};

//    public static String[][] search(String text){
//
//    }

    public void actionPerformed(ActionEvent ae){

        String getCommand = ae.getActionCommand();
        if(getCommand == "history")
            System.out.println("history");
        if(getCommand == "search")
            System.out.println("search");
        if(getCommand == "add")
            System.out.println("add");
        if(getCommand == "edit")
            System.out.println("edit");
        if(getCommand == "delete")
            System.out.println("delete");
        if(getCommand == "reset"){
//            System.out.println(listSlangWord.getSelectedRow());
            model.setRowCount(0);
            for( int i = 0; i < test.length; i++){
                model.addRow(test[i]);
            }
        }
        if(getCommand == "random")
            System.out.println("random");
        if(getCommand == "save")
            System.out.println("save");
        if(getCommand == "showAnswer")
            System.out.println("showAnswer");
        if(getCommand == "stop")
            System.out.println("stop");
        if(getCommand == "next")
            System.out.println("next");

    }
}
