package com.quinbay.travel.Steps;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import static org.junit.Assert.*;
import org.openqa.selenium.support.ui.Select;
import java.util.LinkedHashMap;

public class FlightBookingSteps {
    static WebDriver driver;
    JavascriptExecutor js;
    String source = "//div[contains(text(),'Jakarta (CGK)')]";
    String destination = "//div[@class=\"hub__flight-detail-right__arrival\"]/div[contains(text(),'Surabaya (SUB)')]";
    String airlineCode = "//div[@class=\"route__departure-airline-code\"]";
    String startTime = "//div[@class=\"route__departure-time\"]";
    String endTime = "//div[@class=\"route__arrival-time\"]";

    LinkedHashMap map = new LinkedHashMap();

    @Given("The user should go to the home page of the blibli travel website")
    public void theUserShouldGoToTheHomePageOfTheBlibliTravelWebsite() {
        System.out.println("Navigate to blibli travel website");
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--disable-notifications");
        System.setProperty("webdriver.chrome.driver", "path/to/driver/exe");
        System.setProperty("webdriver.chrome.driver", "src/main/resources/driver/chromedriver");
        driver = new ChromeDriver(options);
        driver.manage().window().maximize();
        driver.get("https://www.blibli.com/travel");
        System.out.println("Navigated to blibli travel website");


    }

    @Then("Enter the details to book a flight")
    public void enterTheDetailsToBookAFlight() throws InterruptedException {
        System.out.println("Enter the details to book");
        Thread.sleep(2000);
        WebElement place = driver.findElement(By.xpath("//input[@placeholder='Pilih kota tujuan']"));
        place.sendKeys("Surabaya");
        place.sendKeys(Keys.ENTER);
        driver.findElement(By.xpath("//button[@class=\"date__text--btn\"]")).click();
        Thread.sleep(2000);

        driver.findElement(By.xpath("//button[@data-pika-month='3'][@data-pika-day='30']")).click();
        Thread.sleep(3000);
        System.out.println("The details are entered");

    }

    @And("Click book a flight")
    public void clickBookAFlight() throws InterruptedException {
        System.out.println("Click on book button");
        driver.findElement(By.xpath("//button[@class=\"button button--orange button--big button--full form__button\"]")).click();
        Thread.sleep(3000);
    }

    @And("Scroll the page until the flights are visible")
    public void scrollThePageUntilTheFlightsAreVisible() throws InterruptedException {
        js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,1500)");
        Thread.sleep(3000);
    }

    @And("click on the detail link and store details in map")
    public void clickOnTheDetailLink() {
        System.out.println("Store the details in a map");
        driver.findElement(By.xpath("//*[@id=\"travel-blibli-app\"]/div/main/div[1]/section/div/div[3]/div[2]/div[2]/div[3]/div[3]/div[6]/div/div/div[1]/div[2]/div/ul/li[1]/a")).click();
        map.put("source", driver.findElement(By.xpath(source)).getText());
        map.put("destination", driver.findElement(By.xpath(destination)).getText());
        map.put("Airline-code", driver.findElement(By.xpath(airlineCode)).getText());
        map.put("start-time", driver.findElement(By.xpath(startTime)).getText());
        map.put("end-time", driver.findElement(By.xpath(endTime)).getText());
        System.out.println("The details are stored in a map");

    }


    @And("Click on the select go button")
    public void clickOnTheSelectGoButton() {
        driver.findElement(By.xpath("//*[@id=\"travel-blibli-app\"]/div/main/div[1]/section/div/div[3]/div[2]/div[2]/div[3]/div[3]/div[6]/div/div/div[2]/button")).click();
    }

    @And("Enter the details to proceed")
    public void enterTheDetailsToProceed() throws InterruptedException {
        System.out.println("Enter the details to proceed");
        Thread.sleep(3000);
        Select surname = new Select(driver.findElement(By.name("title")));
        surname.selectByVisibleText("Nona");
        driver.findElement(By.name("fullName")).sendKeys("Samyuktha");
        driver.findElement(By.name("phoneNumber")).sendKeys("08594389534");
        driver.findElement(By.name("email")).sendKeys("samyuktha@gmail.com");
        js.executeScript("window.scrollBy(0,700)");
        driver.findElement(By.xpath("//*[@id=\"travel-blibli-app\"]/div/main/div[1]/section/div/div[2]/div[1]/div[4]/div[1]/div[1]/div[2]/label")).click();
        Thread.sleep(3000);
        System.out.println("The details are entered");
    }

    @And("Click on the detail section and verify")
    public void clickOnTheDetailSectionAndVerify() throws InterruptedException {
        System.out.println("Assert the details in detail page");
        Thread.sleep(5000);
        driver.findElement(By.xpath("//a[@class=\"order-header-right-value\"]")).click();
        Thread.sleep(3000);
        assertEquals(map.get("source"), driver.findElement(By.xpath(source)).getText());
        assertEquals(map.get("destination"), driver.findElement(By.xpath(destination)).getText());
        assertEquals(map.get("Airline-code"), driver.findElement(By.xpath(airlineCode)).getText());
        assertEquals(map.get("start-time"), driver.findElement(By.xpath(startTime)).getText());
        assertEquals(map.get("end-time"), driver.findElement(By.xpath(endTime)).getText());

        Thread.sleep(3000);
        driver.findElement(By.xpath("//b[contains(text(),'×')]")).click();
        System.out.println("Asserted the details in detail page");


    }

    @And("Click on continue ordering")
    public void clickOnContinueOrdering() throws InterruptedException {
        System.out.println("Confirm booking");
        driver.findElement(By.xpath("//button[contains(text(),'Lanjutkan pemesanan')]")).click();
        Thread.sleep(5000);
        driver.findElement(By.xpath("//button[contains(text(),'Yakin, lanjutkan')]")).click();
        Thread.sleep(5000);
        js.executeScript("window.scrollBy(0,600)");
    }

    @And("Click on the detail section and verify the values")
    public void clickOnTheDetailSectionAndVerifyTheValues() throws InterruptedException {
        System.out.println("Assert the details in the payment page");
        driver.findElement(By.xpath("//*[@id=\"travel-blibli-app\"]/div/main/div[1]/section/div/div[3]/div[2]/div[2]/div[3]/div[3]/div[6]/div/div/div[1]/div[2]/div/ul/li[1]/a")).click();
        Thread.sleep(3000);
        assertEquals(map.get("source"), driver.findElement(By.xpath(source)).getText());
        assertEquals(map.get("destination"), driver.findElement(By.xpath(destination)).getText());
        assertEquals(map.get("Airline-code"), driver.findElement(By.xpath(airlineCode)).getText());
        assertEquals(map.get("start-time"), driver.findElement(By.xpath(startTime)).getText());
        assertEquals(map.get("end-time"), driver.findElement(By.xpath(endTime)).getText());
        driver.findElement(By.xpath("//b[contains(text(),'×')]")).click();
        System.out.println("Assert the details in the payment page");
    }
}
