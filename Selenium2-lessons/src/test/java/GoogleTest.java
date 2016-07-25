import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

/**
 * Created by Admin on 7/13/2016.
 */
public class GoogleTest {
 public static void main(String[] args){
     //System.out.println("this is just for demo test....");
     WebDriver browsers = new FirefoxDriver();
     browsers.get("http://google.com");
     browsers.close();
 }
}
