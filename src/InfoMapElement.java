package src;
import java.util.*;
public class InfoMapElement {

    private String key;
    private String value;

    public void setKey(String key){
        this.key = key;
    }

    public void setValue(String value){
        this.value = value;
    }

    public String getKey(){
        return key;
    }

    public String getValue() {
        return value;
    }

    public void getInfo(String line){
        String listLine[] = line.split("`");

        InfoMapElement element = new InfoMapElement();
        this.key = listLine[0];

        this.value = listLine[1];


    }
}
