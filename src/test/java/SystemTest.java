import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;


import java.io.IOException;

public class SystemTest {
    public WebDriver driver;

    @BeforeTest
    public void openBrowser() throws InterruptedException {
        //1- driver path
        String chromePath = System.getProperty("user.dir")+"\\src\\main\\resources\\chromedriver.exe";
        System.setProperty("webdriver.chrome.driver", chromePath);
        //2- new object of WebDriver
        WebDriver driver = new ChromeDriver();
        //3-Navigate to the website
        driver.navigate().to("https://weathershopper.pythonanywhere.com/");
        driver.manage().window().maximize();
        Thread.sleep(3000);
    }


    public void click(WebElement e){
        e.click();
    }
    public void sendKeys(WebElement e, String txt){
        e.sendKeys(txt);
    }
    public String getAttribute(WebElement e, String attribute){
        return e.getAttribute(attribute);
    }
    public WebDriver getDriver(){
        return driver;
    }


    String[] temperature;
    String currentTemperature;

    By currentTemp = By.xpath("//span[@id='temperature']");
    By moisturizers = By.xpath("//button[normalize-space()='Buy moisturizers']");
    By sunscreens = By.xpath("(//button[@class='btn btn-primary'])[2]");
    By addMoisturizer = By.xpath("//body/div[@class='container']/div[2]/div[2]/button[1]");


    //get current temperature .
    public String getCurrentTemperature() {

        if(driver.findElement(currentTemp).getText().contains("℃")){

            temperature = driver.findElement(currentTemp).getText().split("℃");
            currentTemperature = temperature[0].trim();

        }else if(driver.findElement(currentTemp).getText().contains("°C")) {

            temperature = driver.findElement(currentTemp).getText().split("°C");
            currentTemperature = temperature[0].trim();

        }
        return currentTemperature;
    }


    public void clickBuyMoisturizer(){
        click((WebElement) moisturizers);
    }
    public void addItemsMoisturizer(){
        click((WebElement) addMoisturizer);
    }

    @Test
    public void setAddMoisturizer(){
        clickBuyMoisturizer();;

    }


}
