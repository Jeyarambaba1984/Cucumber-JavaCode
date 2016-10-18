package BaseFiles;

import org.openqa.selenium.remote.RemoteWebDriver.When;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class SeleniumCommonSteps {

    static WebDriver Browser = null;
    public SeleniumCommonSteps()

    {
        BrowserProperties Browser = new BrowserProperties();
    }
    //public static WebElement Locator;
    public static WebElement GetElement(String element, String Page)

    {
        String ElementInfo = JSONReader.RetrieveElementProperty(element, Page);
        System.out.println("Element "+ ElementInfo );
        WebElement ActualElement = Browser.findElement(JSONReader.FindBy(ElementInfo));
        WebElement foundelement = null;
        //Console.WriteLine("locator value is " + locator.ToString());
        return ActualElement;

    }

    public WebDriver GetMeDriver()
    {
        return  Browser;
    }
    public static boolean IsElementpresent(String element, String page)
    {
        WebElement Xpression = SeleniumCommonSteps.GetElement(element, page);

        if (Xpression != null)
        {
            return  false;
        }
        else
        {
            return true;
        }
    }

    }




