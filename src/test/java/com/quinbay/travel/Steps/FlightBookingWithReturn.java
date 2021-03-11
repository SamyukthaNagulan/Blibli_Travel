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

public class FlightBookingWithReturn {
    static WebDriver driver;
    JavascriptExecutor js;
    LinkedHashMap<String, String> map = new LinkedHashMap<>();


    @Given("The user should go to the home page of the travel website")
    public void theUserShouldGoToTheHomePageOfTheBlibliTravelWebsite() {
        System.out.println("Navigate to the blibli travel website");
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--disable-notifications");
        System.setProperty("webdriver.chrome.driver", "path/to/driver/exe");
        System.setProperty("webdriver.chrome.driver", "src/main/resources/driver/chromedriver");
        driver = new ChromeDriver(options);
        driver.manage().window().maximize();
        driver.get("https://www.blibli.com/travel");
        System.out.println("Navigated to the blibli travel website");


    }

    @Then("Enter the details to book the flight")
    public void enterTheDetailsToBookAFlight() throws InterruptedException {
        System.out.println("User enters the details");
        Thread.sleep(2000);
        WebElement place = driver.findElement(By.xpath(HomePageXPaths.place));
        place.sendKeys("Surabaya");
        place.sendKeys(Keys.ENTER);
        driver.findElement(By.xpath(HomePageXPaths.dateBtn)).click();
        driver.findElement(By.xpath(HomePageXPaths.selectDate)).click();

        Thread.sleep(5000);
        driver.findElement(By.xpath(HomePageXPaths.twoWay)).click();
        Thread.sleep(3000);
        System.out.println("The details are entered");

    }

    @And("Click book a plane")
    public void clickBookAFlight() throws InterruptedException {
        System.out.println("User clicks book flight button");
        driver.findElement(By.xpath(HomePageXPaths.book)).click();
        Thread.sleep(3000);
        System.out.println("Book button was clicked by user");
    }

    @And("Scroll the page until the planes are visible")
    public void scrollThePageUntilTheFlightsAreVisible() throws InterruptedException {
        js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,1500)");
        Thread.sleep(3000);
    }

    @And("click on the details link and store details in map")
    public void clickOnTheDetailLink() throws InterruptedException {
        System.out.println("Click on the detail section and store details in a map");
        Thread.sleep(5000);
        driver.findElement(By.xpath(DetailPageXPaths.detail1)).click();
        map.put("source1", driver.findElement(By.xpath(DetailPageXPaths.source)).getText());
        map.put("destination1", driver.findElement(By.xpath(DetailPageXPaths.destination)).getText());
        map.put("Airline-code1", driver.findElement(By.xpath(DetailPageXPaths.airlineCode)).getText());
        map.put("start-time1", driver.findElement(By.xpath(DetailPageXPaths.startTime)).getText());
        map.put("end-time1", driver.findElement(By.xpath(DetailPageXPaths.endTime)).getText());
        System.out.println("Map" + map);
        System.out.println("The details are stored in a map");
    }


    @And("Click on the go button")
    public void clickOnTheSelectGoButton() {
        driver.findElement(By.xpath(DetailPageXPaths.selectGo1)).click();
    }

    @And("Click on the details section for return and verify")
    public void clickOnTheDetailSectionForReturnAndVerifyTheValues() throws InterruptedException {
        System.out.println("Click on details section for return and verify the details");
        Thread.sleep(3000);
        Thread.sleep(3000);
        driver.findElement(By.xpath(DetailPageXPaths.detail2)).click();
        map.put("source2", driver.findElements(By.xpath(DetailPageXPaths.source)).get(1).getText());
        map.put("destination2", driver.findElements(By.xpath(DetailPageXPaths.destination)).get(1).getText());
        map.put("Airline-code2", driver.findElements(By.xpath(DetailPageXPaths.airlineCode)).get(1).getText());
        map.put("start-time2", driver.findElements(By.xpath(DetailPageXPaths.startTime)).get(1).getText());
        map.put("end-time2", driver.findElements(By.xpath(DetailPageXPaths.endTime)).get(1).getText());
        System.out.println("The details are verified");
    }

    @And("Click on the select go button for return")
    public void click_on_the_select_go_button_for_return() throws InterruptedException {
        System.out.println("Click on select go button");
        driver.findElement(By.xpath(DetailPageXPaths.selectGo2)).click();
        driver.findElement(By.xpath(DetailPageXPaths.orderTicket)).click();
        Thread.sleep(5000);

    }

    @And("Enter the details to book a plane")
    public void enterTheDetailsToProceed() throws InterruptedException {
        System.out.println("User enters the details");
        Thread.sleep(3000);
        Select surname = new Select(driver.findElement(By.name("title")));
        surname.selectByVisibleText("Nona");
        driver.findElement(By.name("fullName")).sendKeys("Samyuktha");
        driver.findElement(By.name("phoneNumber")).sendKeys("08594389534");
        driver.findElement(By.name("email")).sendKeys("samyuktha@gmail.com");
        js.executeScript("window.scrollBy(0,700)");
        driver.findElement(By.xpath(DetailPageXPaths.check)).click();
        Thread.sleep(10000);
        System.out.println("The details are entered");
    }

    @And("Click on the details section and verify detail")
    public void clickOnTheDetailSectionAndVerify() throws InterruptedException {
        System.out.println("Click on detail section and verify details");
        //detail= prop.getProperty("detail1");
        driver.findElement(By.xpath(DetailPageXPaths.detail)).click();
        //driver.findElement(By.xpath(detail)).click();
        Thread.sleep(3000);
        assertEquals(map.get("source1"), driver.findElement(By.xpath(DetailPageXPaths.source)).getText());
        assertEquals(map.get("destination1"), driver.findElement(By.xpath(DetailPageXPaths.destination)).getText());
        assertEquals(map.get("Airline-code1"), driver.findElement(By.xpath(DetailPageXPaths.airlineCode)).getText());
        assertEquals(map.get("start-time1"), driver.findElement(By.xpath(DetailPageXPaths.startTime)).getText());
        assertEquals(map.get("end-time1"), driver.findElement(By.xpath(DetailPageXPaths.endTime)).getText());
        Thread.sleep(3000);
        driver.findElement(By.xpath(DetailPageXPaths.back)).click();
        System.out.println("The details are verified");

    }

    @And("Click on the detail section for return")
    public void clickOnTheDetailSectionForReturn() throws InterruptedException {
        System.out.println("Click on details section for return and verify the details");
        Thread.sleep(5000);
        // detail= prop.getProperty("detail1");
        driver.findElements(By.xpath(DetailPageXPaths.detail)).get(1).click();
        //driver.findElement(By.xpath(detail)).click();
        Thread.sleep(3000);
        System.out.println(map);
        assertEquals(map.get("source2"), driver.findElement(By.xpath(DetailPageXPaths.source)).getText());
        assertEquals(map.get("destination2"), driver.findElement(By.xpath(DetailPageXPaths.destination)).getText());
        assertEquals(map.get("Airline-code2"), driver.findElement(By.xpath(DetailPageXPaths.airlineCode)).getText());
        assertEquals(map.get("start-time2"), driver.findElement(By.xpath(DetailPageXPaths.startTime)).getText());
        assertEquals(map.get("end-time2"), driver.findElement(By.xpath(DetailPageXPaths.endTime)).getText());
        Thread.sleep(3000);
        driver.findElement(By.xpath(DetailPageXPaths.back)).click();
        System.out.println("The details are verified for return");
    }

    @And("Click on continue ordering to book flight")
    public void clickOnContinueOrdering() throws InterruptedException {
        System.out.println("Click on continue to continue booking");
        driver.findElement(By.xpath(PaymentPageXPaths.confirm)).click();
        Thread.sleep(5000);
        driver.findElement(By.xpath(PaymentPageXPaths.proceed)).click();
        Thread.sleep(5000);
        js.executeScript("window.scrollBy(0,600)");
    }

    @And("Click on the details section and verify the values")
    public void clickOnTheDetailSectionAndVerifyTheValues() throws InterruptedException {
        System.out.println("Click on details section and verify the details");
        Thread.sleep(3000);
        driver.findElement(By.xpath(PaymentPageXPaths.details)).click();
        Thread.sleep(3000);
        assertEquals(map.get("source1"), driver.findElement(By.xpath(DetailPageXPaths.source)).getText());
        assertEquals(map.get("destination1"), driver.findElement(By.xpath(DetailPageXPaths.destination)).getText());
        assertEquals(map.get("Airline-code1"), driver.findElement(By.xpath(DetailPageXPaths.airlineCode)).getText());
        assertEquals(map.get("start-time1"), driver.findElement(By.xpath(DetailPageXPaths.startTime)).getText());
        //Thread.sleep(3000);
        assertEquals(map.get("end-time1"), driver.findElement(By.xpath(DetailPageXPaths.endTime)).getText());

        driver.findElement(By.xpath(PaymentPageXPaths.cancel)).click();
        System.out.println("The details are verified");

    }


    @And("Click on the detail section and verify the values for return")
    public void clickOnTheDetailSectionAndVerifyTheValuesForReturn() throws InterruptedException {
        System.out.println("Click on details section for return and verify the details");
        Thread.sleep(3000);
        driver.findElements(By.xpath(PaymentPageXPaths.details)).get(1).click();
        Thread.sleep(3000);
        assertEquals(map.get("source2"), driver.findElement(By.xpath(DetailPageXPaths.source)).getText());
        assertEquals(map.get("destination2"), driver.findElement(By.xpath(DetailPageXPaths.destination)).getText());
        assertEquals(map.get("Airline-code2"), driver.findElement(By.xpath(DetailPageXPaths.airlineCode)).getText());
        assertEquals(map.get("start-time2"), driver.findElement(By.xpath(DetailPageXPaths.startTime)).getText());
        assertEquals(map.get("end-time2"), driver.findElement(By.xpath(DetailPageXPaths.endTime)).getText());

        driver.findElement(By.xpath(PaymentPageXPaths.cancel)).click();
        System.out.println("The details are verified for return");
    }

}
