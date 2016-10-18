import com.sun.deploy.Environment;
import net.masterthought.cucumber.ReportBuilder;
import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;
import java.lang.reflect.InvocationTargetException;
import java.io.*;
import java.lang.reflect.Method;
import java.rmi.registry.Registry;
import java.util.prefs.BackingStoreException;
import java.util.prefs.Preferences;




/**
 * Created by jeyaram.baba on 8/5/2016.
 */
@RunWith(Cucumber.class)
@CucumberOptions(
        features = "C:\\Users\\jeyaram.baba\\JavaProjects\\Cucumber-Java\\src\\test\\",
        format = {"pretty", "html:build/cucumber-html-report", "json-pretty:build/cucumber-report.json"}
        //format = {"html:output"}
        //format = {"SimpleHtmlReport:report/smokeTest.html"}
        //format = {"pretty", "html:target/cucumber"}
        //format = {"pretty","html:target/cucumber","json:target/cucumber.json"}
)
public class RunCukeTest {
    @BeforeClass
    public static void setUp()
    {
        Registry  rKey = null;
        String serverName = System.getProperty("user.name");
        //serverName =
    }

}
