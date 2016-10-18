package BaseFiles;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.openqa.selenium.By;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Iterator;

/**
 * Created by jeyaram.baba on 8/9/2016.
 */
public class JSONHelper {

    //public static JSONArray OR;
    public static JSONArray Jsonarray;
    public static JSONObject JsonObject;
    public static JSONArray RetrieveJobject(String Property, String Page)
    {

        try {

            String FilePath = System.getProperty("user.dir") + "\\src\\test\\resources\\PageObjectRepository\\" +Page;
            System.out.println("Working Directory " + FilePath);

            FileReader Reader = new FileReader(FilePath);
            JsonObject = (JSONObject) new JSONParser().parse(Reader);
            Jsonarray = (JSONArray) JsonObject.get(Page);
            for (int i=0;i<Jsonarray.size();i++)
            {
                System.out.println("Got Elements from "+Page+" : "+Jsonarray.get(i));
            }
            System.out.println("Got Page Objects");
        } catch (FileNotFoundException ex) {
            ex.printStackTrace();
        } catch (IOException ex) {
            ex.printStackTrace();
        } catch (ParseException ex) {
            ex.printStackTrace();
        } catch (NullPointerException ex) {
            ex.printStackTrace();
        }
        return Jsonarray;
    }


}

