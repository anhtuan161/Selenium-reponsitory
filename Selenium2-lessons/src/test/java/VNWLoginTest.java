

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static org.fest.assertions.api.Assertions.assertThat;

/**
 * Created by Admin on 7/13/2016.
 */
public class VNWLoginTest {
    @Test(dataProvider = "invalidLoginData")
    public void invalidCredentialTest(String username, String password) {
        WebDriver browser = new FirefoxDriver();
        browser.get("https://tinhte.vn/login/");
        // browser.get("https://tinhte.vn/login");
        // declare the login form items
        WebElement txtUserName, txtPassword, btnLogin;

        //Find there element
        txtUserName = browser.findElement(By.cssSelector("#pageLogin > dl.ctrlUnit > dd > #ctrl_pageLogin_login"));
        txtPassword = browser.findElement(By.cssSelector("#ctrl_pageLogin_registered_Disabler > #ctrl_pageLogin_password"));
        btnLogin = browser.findElement(By.cssSelector("#pageLogin > dl.ctrlUnit.submitUnit > dd > input.button.primary"));

        // txtUserName = browser.findElement(By.name("form[username]"));
        // txtPassword = browser.findElement(By.name("form[password]"));
        // btnLogin = browser.findElement(By.name("form[sign_in]"));


        // perform login
        txtUserName.sendKeys(username);
        txtPassword.sendKeys(password);
        btnLogin.click();

        //get the error elenment
        // using cssselector since it doesn't contain any of id or name
        WebElement eleError = browser.findElement(By.xpath(".//*[@id='pageLogin']/div/span"));

        //Verify if the error message is correct
        String error = eleError.getText();
        assertThat(error)
                .as("Error message")
                .isEqualTo("The requested user '"+ username+ "' could not be found.");
        // done , close browsers
        browser.quit();
    }

    //provide data test

    @DataProvider(name = "invalidLoginData")
    String[][] invalidLoginData(){
        return new String[][]{
                {"anhtuan@gmail,com", "password"}
                , {"abc@gmail,com", "password"}
                , {"123@gmail,com", "password"}
        };
    }
}

