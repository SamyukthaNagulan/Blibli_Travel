package com.quinbay.travel.Steps;

import com.quinbay.travel.pages.DetailPageXPaths;
import com.quinbay.travel.pages.HomePageXPaths;
import com.quinbay.travel.pages.PaymentPageXPaths;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.Select;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class FlightBookingWithTransit {
    static WebDriver driver;
    JavascriptExecutor js;
    LinkedHashMap<String, String> map = new LinkedHashMap<String, String>();

    @Given("User should go to the home page of the blibli travel website")
    public void theUserShouldGoToTheHomePageOfTheBlibliTravelWebsite() {
        System.out.println("Navigating to blibli travel website");
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--disable-notifications");
        System.setProperty("webdriver.chrome.driver", "path/to/driver/exe");
        System.setProperty("webdriver.chrome.driver", "src/main/resources/driver/chromedriver");
        driver = new ChromeDriver(options);
        driver.manage().window().maximize();
        driver.get("https://www.blibli.com/travel");
        System.out.println("User is on blibli travel website");

    }

    @Then("Enter the details to book")
    public void enterTheDetailsToBook() throws InterruptedException {
        System.out.println("User enters the details");
        Thread.sleep(2000);
        WebElement place = driver.findElement(By.xpath(HomePageXPaths.place));
        place.sendKeys("Denpasar");
        place.sendKeys(Keys.ENTER);
        driver.findElement(By.xpath(HomePageXPaths.dateBtn)).click();
        Thread.sleep(2000);

        driver.findElement(By.xpath(HomePageXPaths.selectDate)).click();
        Thread.sleep(3000);
        System.out.println("The details are entered");
    }

    @And("Click book a flight to book")
    public void clickBookAFlightToBook() throws InterruptedException {
        System.out.println("Click book a flight");
        driver.findElement(By.xpath(HomePageXPaths.book)).click();
        Thread.sleep(3000);
        System.out.println("Clicked the book a flight button");
    }

    @And("Scroll the page until the required flight is seen")
    public void scrollThePageUntilTheRequiredFlightIsSeen() throws InterruptedException {

        Thread.sleep(3000);
        js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,1500)");
        Thread.sleep(3000);
    }

    @And("Click on the detail section and store details in map")
    public void clickOnTheDetailSectionAndStoreDetailsInMap() throws InterruptedException {
        System.out.println("Store details in map");
        Thread.sleep(5000);
        driver.findElement(By.xpath(DetailPageXPaths.detail1)).click();
        map.put("source1", driver.findElements(By.xpath(DetailPageXPaths.source)).get(0).getText());
        map.put("destination1", driver.findElements(By.xpath(DetailPageXPaths.destination)).get(0).getText());
        map.put("airlineCode1", driver.findElements(By.xpath(DetailPageXPaths.airlineCode)).get(0).getText());
        map.put("startTime1", driver.findElements(By.xpath(DetailPageXPaths.startTime)).get(0).getText());
        map.put("endTime1", driver.findElements(By.xpath(DetailPageXPaths.endTime)).get(0).getText());
        map.put("source2", driver.findElements(By.xpath(DetailPageXPaths.source)).get(1).getText());
        map.put("destination2", driver.findElements(By.xpath(DetailPageXPaths.destination)).get(1).getText());
        map.put("airlineCode2", driver.findElements(By.xpath(DetailPageXPaths.airlineCode)).get(1).getText());
        map.put("startTime2", driver.findElements(By.xpath(DetailPageXPaths.startTime)).get(1).getText());
        map.put("endTime2", driver.findElements(By.xpath(DetailPageXPaths.endTime)).get(1).getText());
        System.out.println("The details are stored in map");


    }

    @And("Click on select go button")
    public void clickOnSelectGoButton() {
        System.out.println("Click on select go button");
        driver.findElement(By.xpath(DetailPageXPaths.selectGo1)).click();
    }

    @And("Click on the detail section and verify details")
    public void clickOnTheDetailSectionAndVerifyDetails() throws InterruptedException {
        Thread.sleep(3000);
        driver.findElement(By.xpath(DetailPageXPaths.detail)).click();
        Thread.sleep(3000);
        System.out.println("Assert the details in detail page");
        assertEquals(map.get("source1"), driver.findElements(By.xpath(DetailPageXPaths.source)).get(0).getText());
        assertEquals(map.get("destination1"), driver.findElements(By.xpath(DetailPageXPaths.destination)).get(0).getText());
        assertEquals(map.get("airlineCode1"), driver.findElements(By.xpath(DetailPageXPaths.airlineCode)).get(0).getText());
        assertEquals(map.get("startTime1"), driver.findElements(By.xpath(DetailPageXPaths.startTime)).get(0).getText());
        assertEquals(map.get("endTime1"), driver.findElements(By.xpath(DetailPageXPaths.endTime)).get(0).getText());
        assertEquals(map.get("source2"), driver.findElements(By.xpath(DetailPageXPaths.source)).get(1).getText());
        assertEquals(map.get("destination2"), driver.findElements(By.xpath(DetailPageXPaths.destination)).get(1).getText());
        assertEquals(map.get("airlineCode2"), driver.findElements(By.xpath(DetailPageXPaths.airlineCode)).get(1).getText());
        assertEquals(map.get("startTime2"), driver.findElements(By.xpath(DetailPageXPaths.startTime)).get(1).getText());
        assertEquals(map.get("endTime2"), driver.findElements(By.xpath(DetailPageXPaths.endTime)).get(1).getText());
        driver.findElement(By.xpath("//b[contains(text(),'×')]")).click();
        System.out.println("Asserted the details in detail page");

    }

    @And("Enter the details to proceed to order")
    public void enterTheDetailsToProceedToOrder() throws InterruptedException {
        System.out.println("Enter the details of user");
        Thread.sleep(3000);
        Select surname = new Select(driver.findElement(By.name("title")));
        surname.selectByVisibleText("Nona");
        driver.findElement(By.name("fullName")).sendKeys("Samyuktha");
        driver.findElement(By.name("phoneNumber")).sendKeys("08594389534");
        driver.findElement(By.name("email")).sendKeys("samyuktha@gmail.com");
        js.executeScript("window.scrollBy(0,700)");
        driver.findElement(By.xpath(DetailPageXPaths.check)).click();
        Thread.sleep(3000);
        Select date = new Select(driver.findElement(By.xpath(DetailPageXPaths.date)));
        date.selectByVisibleText("12");

        Select month = new Select(driver.findElement(By.xpath(DetailPageXPaths.month)));
        month.selectByVisibleText("Jun");

        Select year = new Select(driver.findElement(By.xpath(DetailPageXPaths.year)));
        year.selectByVisibleText("1999");
        Thread.sleep(2000);
        System.out.println("The details are entered");


    }

    @And("Click on continue ordering to book")
    public void clickOnContinueOrderingToBook() {
        System.out.println("Confirm booking");
        driver.findElement(By.xpath(PaymentPageXPaths.confirm)).click();
        driver.findElement(By.xpath(PaymentPageXPaths.proceed)).click();
    }

    @And("Click on the detail section and verify the details")
    public void clickOnTheDetailSectionAndVerifyTheDetails() throws InterruptedException {
        System.out.println("Assert the details on payment page");
        Thread.sleep(5000);
        js.executeScript("window.scrollBy(0,500)");
        Thread.sleep(3000);
        driver.findElement(By.xpath(PaymentPageXPaths.details)).click();
        assertEquals(map.get("source1"), driver.findElements(By.xpath(DetailPageXPaths.source)).get(0).getText());
        assertEquals(map.get("destination1"), driver.findElements(By.xpath(DetailPageXPaths.destination)).get(0).getText());
        assertEquals(map.get("airlineCode1"), driver.findElements(By.xpath(DetailPageXPaths.airlineCode)).get(0).getText());
        assertEquals(map.get("startTime1"), driver.findElements(By.xpath(DetailPageXPaths.startTime)).get(0).getText());
        assertEquals(map.get("endTime1"), driver.findElements(By.xpath(DetailPageXPaths.endTime)).get(0).getText());
        assertEquals(map.get("source2"), driver.findElements(By.xpath(DetailPageXPaths.source)).get(1).getText());
        assertEquals(map.get("destination2"), driver.findElements(By.xpath(DetailPageXPaths.destination)).get(1).getText());
        assertEquals(map.get("airlineCode2"), driver.findElements(By.xpath(DetailPageXPaths.airlineCode)).get(1).getText());
        assertEquals(map.get("startTime2"), driver.findElements(By.xpath(DetailPageXPaths.startTime)).get(1).getText());
        assertEquals(map.get("endTime2"), driver.findElements(By.xpath(DetailPageXPaths.endTime)).get(1).getText());
        driver.findElement(By.xpath(PaymentPageXPaths.cancel)).click();
        System.out.println("Asserted the details on payment page");
    }
}
