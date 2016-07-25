import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

import static org.fest.assertions.api.Assertions.assertThat;


/**
 * Created by Admin on 7/13/2016.
 */
public class GoogleTestWithTtestNG {

    //This annotation to let TestNG knoes it is a test method
    @Test
    public void testTitle(){
        WebDriver browsers = new FirefoxDriver();
        browsers.get("http://google.com");

        //Get the page's title
        String title = browsers.getTitle();

        //Verify that the title should be 'google' by TestNG assert
        assertThat(title).as("google page's title")// a friendly name
                .isEqualToIgnoringCase("Google"); //equal but ignoring case




        browsers.close();
    }
}
