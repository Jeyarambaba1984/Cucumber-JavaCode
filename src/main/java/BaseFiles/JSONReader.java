package BaseFiles;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import java.lang.*;
import java.util.Iterator;

//public class JSONReader {
//
//
//    public static JSONObject JsonObject;
//    public static JSONArray PageObjects;
//
//    public static String RetrieveElementProperty(String Property, String Page)
//    {
//        //Property = "Login button";
//        //Page = "Login";
//        StringBuffer Locator = new StringBuffer();
//        Iterator IT;
//
//        JSONHelper JReader = new JSONHelper();
//        System.out.println("In RetrieveElementProperty");
//        PageObjects = JSONHelper.RetrieveJobject(Property, Page);
//
//        // take the elements of the json array
//        for (int i = 0; !(i >= PageObjects.size()); i++)
//        {
//            System.out.println("The " + i + " element of the array: " + PageObjects.get(i));
//
//            IT = PageObjects.iterator();
//
//            // take each value from the json array separately
//            while (IT.hasNext())
//            {
//                JSONObject innerObj = (JSONObject) IT.next();
//                if (innerObj.containsKey(Property))
//                {
//
//                    System.out.println("Value of " + Page + ": " + innerObj.get(Property));
////                    JsonObject = (JSONObject) innerObj.get(Page);
////                    Locator = (WebElement) JsonObject;
//                    System.out.println("Locator "+ Locator);
//                    System.out.println("Locator innerobject  "+innerObj.get(Property));
//                    Locator.append( innerObj.get(Property).toString());
//                }
//            }
//        }
//        return Locator.toString().replaceAll("\\\\","");
//    }
//
//    public static By FindBy(String ElementInfo)
//    {
//
//        String[] LocatorType = ElementInfo.split(":");
//        By ElementBy = null;
//        switch (LocatorType[1].toLowerCase().trim().replaceAll("\"", "")){
//            case "id": ElementBy = By.id(LocatorType[2].trim().replace("\"}", "")); break;
//            case "xpath": ElementBy = By.xpath(LocatorType[2].trim().replace("\"}", ""));break;
//            case "name":  ElementBy = By.name(LocatorType[1].replace("\"}", ""));break;
//            case "tagname": ElementBy = By.tagName(LocatorType[2].replace("\"}", ""));break;
//            case "link": ElementBy = By.linkText(LocatorType[2].replace("\"}", ""));break;
//            case "partial": ElementBy = By.partialLinkText(LocatorType[2].replace("\"}", ""));break;
//        }
//        return ElementBy;
//    }
//
//}