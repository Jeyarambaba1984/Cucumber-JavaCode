package stepdef;

import BaseFiles.BrowserProperties;
import BaseFiles.SeleniumCommonSteps;
import com.google.common.collect.Table;
import cucumber.api.DataTable;
import cucumber.api.PendingException;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.When;
import cucumber.api.java.it.Ma;
import net.sourceforge.htmlunit.corejs.javascript.tools.shell.Environment;
import org.apache.xerces.util.SynchronizedSymbolTable;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.rmi.registry.Registry;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import static BaseFiles.BrowserProperties.DriverReader;
import static java.lang.System.*;
import static java.net.InetAddress.*;

public class UtilizationManagement extends SeleniumCommonSteps {
    public WebElement App;
    public WebDriver Browser = null;



    @When("^I enter \"([^\"]*)\" in \"([^\"]*)\" in \"([^\"]*)\"$")
    public void iEnterInIn(String data, String element, String page) {
        SeleniumCommonSteps.GetElement(element, page).sendKeys(data);
    }


    @And("^I click on \"([^\"]*)\" in \"([^\"]*)\"$")
    public void iClickOnIn(String element, String page) {
        SeleniumCommonSteps.GetElement(element, page).click();
    }

//        @Given("^I open CAE using  \"([^\"]*)\" Browser$")
//    public void iOpenCAEUsingBrowser(String BrowserType)
//    {
//        out.println("Opening CAE Page");
//        Browser = BrowserProperties.SafeInvokeDriver(BrowserType);
//        Browser.navigate().to("http://abn-ode-web-c12.ode.trizetto.com/carekeyex/Login/login.aspx");
//    }




    @Given("^I open \"([^\"]*)\" Application using given Browser$")
    public void iOpenCAEApplicationUsingGivenBrowser(String Application, DataTable Table)
    {
        String BrowserType = "";
        String tempoptions = "";
        String options = "";
        List<String> IEOption = new  ArrayList<String>();
        List<List<String>> Data = Table.raw();
        //System.out.println("Row Count " + Data.size());

        for (int i = 0; i < Data.size() - 1; i++) {
            //System.out.println("Column Count " + Data.get(0).size());
            for (int j = 0; j < Data.get(i).size(); j++) {
                if (Data.get(i).get(j).toLowerCase().contains("browsertype")) {
                    BrowserType = Data.get(i + 1).get(j);
                    //System.out.println("Browser Type " + Data.get(i + 1).get(j));
                } else if (Data.get(i).get(j).toLowerCase().contains("option")) {
                    //System.out.println("Options " + Data.get(i + 1).get(j));
                    tempoptions = Data.get(i + 1).get(j);
                    options = options + "|" + tempoptions;
                    IEOption.add(Data.get(i + 1).get(j));
                }
            }
        }
        System.out.println("Size of Options List " + IEOption.size());


        {
//            Registry rKey = null;
//            String serverName = null;
//            try {
//                serverName = getLocalHost().getHostName().toLowerCase();
//
//
//            } catch (UnknownHostException e) {
//                e.printStackTrace();
//            }
//            System.out.println(serverName );
//            String configField = "Enabled";
//
//            if (serverName.toLowerCase().contains("csn-"))
//            {
//
//            }
//            else
//            //serverName =
        }


        Browser = BrowserProperties.SafeInvokeDriver(BrowserType, IEOption, "Path");
        String URL = DriverReader(Application, "ApplicationProperties", "URL");
        System.out.println("URL Retrieved "+URL);
        Browser.navigate().to(URL);

    }

    @When("^I switch to \"([^\"]*)\" in \"([^\"]*)\" Application$")
    public void iSwitchToInApplication(String Frame, String Page)
    {
        if (Frame.toLowerCase().contains("frame"))
        {
            Browser.switchTo().frame(Frame);
        }
        else if (Frame.toLowerCase().contains("default"))
        {
            Browser.switchTo().parentFrame();
        }
        else
        {

        }

    }




}
