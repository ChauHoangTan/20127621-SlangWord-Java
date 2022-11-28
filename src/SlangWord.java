package src;

import java.nio.charset.StandardCharsets;
import java.util.*;
import java.io.*;


public class SlangWord {

    public static TreeMap<String, String> treeMap = new TreeMap<>();

    public static String[][] rootData;


    static String  fileName = "data.txt";

    public static String convertListToString(List<String> list){
        String line = "";
        for(int i = 0; i < list.size(); i++){
           line += list.get(i) + ", ";
           if(i < list.size()-1){
               line += ", ";
           }
        }

        return line;
    }

    public static void readDataFromFile(){

        FileInputStream fis = null;
        InputStreamReader isr = null;
        BufferedReader br = null;

        try{

            fis =new FileInputStream(fileName);
            isr = new InputStreamReader(fis, StandardCharsets.UTF_8);
            br = new BufferedReader(isr);

            String lineInfo = null;

            int index = 0;
            while((lineInfo = br.readLine()) != null ) {

                InfoMapElement map = new InfoMapElement();
                map.getInfo(lineInfo);
                treeMap.put(map.getKey(), map.getValue());


            }



            fis.close();
            isr.close();
            br.close();


        }catch (Exception e){
            e.printStackTrace();

        }

    }

    public static void writeDataToFile(){

        FileOutputStream fos = null;

        try{
            fos = new FileOutputStream(fileName);

            int index = 1;
            Set<String> keySet = treeMap.keySet();
            for(String key : keySet){
                byte b[];
                String lineInfo = key + "`" + treeMap.get(key);
                if(index < treeMap.size()){
                    lineInfo += "\n";
                }
                b = lineInfo.getBytes("utf8");
                fos.write(b);
                index++;
            }

            fos.close();
        }catch (Exception e){
            e.printStackTrace();
        }
    }



}