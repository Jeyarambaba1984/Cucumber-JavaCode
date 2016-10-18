package BaseFiles;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.File;
import java.util.List;

public class BrowserProperties {

    static WebDriver Browser=null;
    static String  Path;
    //static String DriverPath;

    public static WebDriver SafeInvokeDriver(String BrowserType, List<String> Options, String Path)
    {

        String Dirpath="";
        String Driverpath="";
        if (Browser == null)

        {
            if (!BrowserType.toLowerCase().equals("firefox")) {
                Dirpath = WorkingDir();
                Path = DriverReader(BrowserType, "BrowserProperties", Path);
                Driverpath = Dirpath + Path;
                System.out.println("Path of " + BrowserType + " Browser is " + Dirpath + Path);
            }
            Browser = InvokeDriver(BrowserType, Driverpath, Options);
        }
        return Browser;
    }

    public static WebDriver InvokeDriver(String type, String Path, List<String> Options)
    {
        WebDriver webdriver;
        switch (type.toLowerCase().trim())        {
            case "firefox":
                webdriver = new FirefoxDriver();
                break;

            case "chrome":
                System.setProperty("webdriver.chrome.driver", Path);
                webdriver = new ChromeDriver();
                break;

            case "ie64":
                System.setProperty("webdriver.ie.driver", Path);
                webdriver = new InternetExplorerDriver(IEOptionString(Options));
                break;

            case "ie32":
                System.setProperty("webdriver.ie.driver", Path);
                webdriver = new InternetExplorerDriver(IEOptionString(Options));
                break;

            default:
                System.setProperty("webdriver.ie.driver", Path);
                webdriver = new InternetExplorerDriver(IEOptionString(Options));
                break;
        }
        //Application = webdriver;
        //Application.manage().window().fullscreen();
        webdriver.manage().window().maximize();
        return webdriver;
    }

    public static DesiredCapabilities IEOptionString(List<String> Options) {
        DesiredCapabilities IEOptions = DesiredCapabilities.internetExplorer();
        IEOptions.setCapability(InternetExplorerDriver.ENABLE_PERSISTENT_HOVERING, true);
//        for (String value : Options) {
//            //System.out.println("Values = "+value);
//            switch (value.toLowerCase().trim())
//            {
//                case "hover":
//                    IEOptions.setCapability(InternetExplorerDriver.ENABLE_PERSISTENT_HOVERING, true);
//                    break;
//                case "protected mode":
//                    IEOptions.setCapability(InternetExplorerDriver.INTRODUCE_FLAKINESS_BY_IGNORING_SECURITY_DOMAINS, true);
//                    break;
//
//                case "clean session":
//                    IEOptions.setCapability(InternetExplorerDriver.IE_ENSURE_CLEAN_SESSION, true);
//                    break;
//
//                case "native events":
//                    IEOptions.setCapability(InternetExplorerDriver.NATIVE_EVENTS, true);
//                    break;
//
//                case "clean cache":
//                    IEOptions.setCapability(InternetExplorerDriver.ENABLE_ELEMENT_CACHE_CLEANUP, true);
//                    break;
//
//                case "accept alert":
//                    IEOptions.setCapability(CapabilityType.UNEXPECTED_ALERT_BEHAVIOUR, true);
//                    break;
//
//                default:
//                    break;
//            }
//        }

        return IEOptions;
    }


    public static String WorkingDir()
    {
        String WorkingDir = System.getProperty("user.dir");
        System.out.println("Working Directory " + WorkingDir);
        return  WorkingDir;
    }

    public static String DriverReader(String ChildNode, String prop, String NodeElement)
    {
        String DriverPath ="";
        String FileName = "";
        String TagName = "";
        File fXmlFile=null;

        try {
            String FilePath = WorkingDir() + "\\src\\test\\resources\\Properties\\";
            System.out.println("Working Directory " + FilePath);

            if (prop.toLowerCase().contains("browserproperties"))
            {
                //fXmlFile = new File(FilePath + "\\BrowserProperties.xml");
                FileName = "BrowserProperties.xml";
                TagName= "Browser";

            }
            else if(prop.toLowerCase().contains("applicationproperties"))
            {
                //fXmlFile = new File(FilePath + "\\ApplicationProperties.xml");
                FileName = "ApplicationProperties.xml";
                TagName= "App";
            }
            fXmlFile = new File(FilePath + FileName);

            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            Document doc = dBuilder.parse(fXmlFile);
            doc.getDocumentElement().normalize();
            String RootElement = doc.getDocumentElement().getNodeName();
            System.out.println("Root element :" + RootElement);
            System.out.println("***************");
            NodeList nList = doc.getElementsByTagName(TagName);
            System.out.println("----------------------------");

            for (int temp = 0; temp < nList.getLength(); temp++)
            {

                Node nNode = nList.item(temp);
                if (nNode.getNodeType() == Node.ELEMENT_NODE)
                {
                    Element eElement = (Element) nNode;
                    String ParentElement = eElement.getAttribute("Type");

                    if (ParentElement.contains(ChildNode))
                    {
                        System.out.println("Browser Type- " + ParentElement);
                        DriverPath = eElement.getElementsByTagName(NodeElement).item(0).getTextContent();
                        eElement.getTextContent();
                        System.out.println("NodeElement Retrieved : " + DriverPath);
                        break;
                    }
                }
            }
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        return DriverPath;
    }
}
