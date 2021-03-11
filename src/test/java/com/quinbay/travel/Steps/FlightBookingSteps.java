package com.quinbay.travel.Steps;

import com.quinbay.travel.pages.DetailPageXPaths;
import com.quinbay.travel.pages.HomePageXPaths;
import com.quinbay.travel.pages.PaymentPageXPaths;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.hu.De;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import static org.junit.Assert.*;

import org.openqa.selenium.support.ui.Select;

import java.util.LinkedHashMap;

public class FlightBookingSteps {
    static WebDriver driver;
    JavascriptExecutor js;

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
        WebElement place = driver.findElement(By.xpath(HomePageXPaths.place));
        place.sendKeys("Surabaya");
        place.sendKeys(Keys.ENTER);
        driver.findElement(By.xpath(HomePageXPaths.dateBtn)).click();
        Thread.sleep(2000);

        driver.findElement(By.xpath(HomePageXPaths.selectDate)).click();
        Thread.sleep(3000);
        System.out.println("The details are entered");

    }

    @And("Click book a flight")
    public void clickBookAFlight() throws InterruptedException {
        System.out.println("Click on book button");
        driver.findElement(By.xpath(HomePageXPaths.book)).click();
        Thread.sleep(3000);
    }

    @And("Scroll the page until the flights are visible")
    public void scrollThePageUntilTheFlightsAreVisible() throws InterruptedException {
        js = (JavascriptExecutor) driver;
        Thread.sleep(5000);

        js.executeScript("window.scrollBy(0,1500)");
    }

    @And("click on the detail link and store details in map")
    public void clickOnTheDetailLink() {
        System.out.println("Store the details in a map");
        driver.findElement(By.xpath(DetailPageXPaths.detail1)).click();
        map.put("source", driver.findElement(By.xpath(DetailPageXPaths.source)).getText());
        map.put("destination", driver.findElement(By.xpath(DetailPageXPaths.destination)).getText());
        map.put("Airline-code", driver.findElement(By.xpath(DetailPageXPaths.airlineCode)).getText());
        map.put("start-time", driver.findElement(By.xpath(DetailPageXPaths.startTime)).getText());
        map.put("end-time", driver.findElement(By.xpath(DetailPageXPaths.endTime)).getText());
        System.out.println("The details are stored in a map");

    }


    @And("Click on the select go button")
    public void clickOnTheSelectGoButton() {
        driver.findElement(By.xpath(DetailPageXPaths.selectGo1)).click();
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
        driver.findElement(By.xpath(DetailPageXPaths.check)).click();
        Thread.sleep(3000);
        System.out.println("The details are entered");
    }

    @And("Click on the detail section and verify")
    public void clickOnTheDetailSectionAndVerify() throws InterruptedException {
        System.out.println("Assert the details in detail page");
        Thread.sleep(10000);
        driver.findElement(By.xpath(DetailPageXPaths.detail)).click();
        Thread.sleep(3000);
        assertEquals(map.get("source"), driver.findElement(By.xpath(DetailPageXPaths.source)).getText());
        assertEquals(map.get("destination"), driver.findElement(By.xpath(DetailPageXPaths.destination)).getText());
        assertEquals(map.get("Airline-code"), driver.findElement(By.xpath(DetailPageXPaths.airlineCode)).getText());
        assertEquals(map.get("start-time"), driver.findElement(By.xpath(DetailPageXPaths.startTime)).getText());
        assertEquals(map.get("end-time"), driver.findElement(By.xpath(DetailPageXPaths.endTime)).getText());

        Thread.sleep(3000);
        driver.findElement(By.xpath(DetailPageXPaths.back)).click();
        System.out.println("Asserted the details in detail page");


    }

    @And("Click on continue ordering")
    public void clickOnContinueOrdering() throws InterruptedException {
        System.out.println("Confirm booking");
        driver.findElement(By.xpath(PaymentPageXPaths.confirm)).click();
        Thread.sleep(5000);
        driver.findElement(By.xpath(PaymentPageXPaths.proceed)).click();
        Thread.sleep(10000);
        js.executeScript("window.scrollBy(0,600)");
    }

    @And("Click on the detail section and verify the values")
    public void clickOnTheDetailSectionAndVerifyTheValues() throws InterruptedException {
        System.out.println("Assert the details in the payment page");
        driver.findElement(By.xpath(PaymentPageXPaths.details)).click();
        Thread.sleep(3000);
        assertEquals(map.get("source"), driver.findElement(By.xpath(PaymentPageXPaths.source)).getText());
        assertEquals(map.get("destination"), driver.findElement(By.xpath(PaymentPageXPaths.destination)).getText());
        assertEquals(map.get("Airline-code"), driver.findElement(By.xpath(PaymentPageXPaths.airlineCode)).getText());
        assertEquals(map.get("start-time"), driver.findElement(By.xpath(PaymentPageXPaths.startTime)).getText());
        assertEquals(map.get("end-time"), driver.findElement(By.xpath(PaymentPageXPaths.endTime)).getText());
        driver.findElement(By.xpath(PaymentPageXPaths.cancel)).click();
        System.out.println("Assert the details in the payment page");
    }
}
