package com.quinbay.travel.Steps;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.Select;

import java.util.LinkedHashMap;
import static org.junit.Assert.assertEquals;

public class FlightBookingWithTransit {
    static WebDriver driver;
    JavascriptExecutor js;
    String source1="//div[contains(text(),'Jakarta (CGK)')]";
    String destination1="//div[contains(text(),'Surabaya (SUB)')]";
    String airlineCode1="//div[@class=\"route__departure-airline-code\"]";
    String startTime1="//div[@class=\"route__departure-time\"]/span[contains(text(),'10:00')]",endTime1="//div[@class=\"route__arrival-time\"]/span[contains(text(),'11:35')]",source2="//div[contains(text(),'Surabaya (SUB)')]",destination2="//div[@class=\"route__arrival-city padding-top-10\"][contains(text(),'Denpasar (DPS)')]",airlineCode2="//div[@class=\"route__departure-airline-code\"][contains(text(),'QZ-629')]",startTime2="//div[@class=\"route__departure-time\"]/span[contains(text(),'13:50')]",endTime2="//div[@class=\"route__arrival-time\"]/span[contains(text(),'15:45')]";
    LinkedHashMap<String, String> map=new LinkedHashMap<String, String>();
    @Given("User should go to the home page of the blibli travel website")
    public void theUserShouldGoToTheHomePageOfTheBlibliTravelWebsite() {
        System.out.println("Navigating to blibli travel website");
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--disable-notifications");
        System.setProperty("webdriver.chrome.driver","path/to/driver/exe");
        System.setProperty("webdriver.chrome.driver","src/main/resources/driver/chromedriver");
        driver=new ChromeDriver(options);
        driver.manage().window().maximize();
        driver.get("https://www.blibli.com/travel");
        System.out.println("User is on blibli travel website");

    }
    @Then("Enter the details to book")
    public void enterTheDetailsToBook() throws InterruptedException {
        System.out.println("User enters the details");
        Thread.sleep(2000);
        WebElement place=driver.findElement(By.xpath("//input[@placeholder='Pilih kota tujuan']"));
        place.sendKeys("Denpasar");
        place.sendKeys(Keys.ENTER);
        driver.findElement(By.xpath("//button[@class=\"date__text--btn\"]")).click();
        Thread.sleep(2000);

        driver.findElement(By.xpath("//button[@data-pika-month='3'][@data-pika-day='30']")).click();
        Thread.sleep(3000);
        System.out.println("The details are entered");
    }

    @And("Click book a flight to book")
    public void clickBookAFlightToBook() throws InterruptedException {
        System.out.println("Click book a flight");
        driver.findElement(By.xpath("//button[@class=\"button button--orange button--big button--full form__button\"]")).click();
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
        driver.findElement(By.xpath("//*[@id=\"travel-blibli-app\"]/div/main/div[1]/section/div/div[3]/div[2]/div[2]/div[3]/div[3]/div[6]/div/div/div[1]/div[2]/div/ul/li[1]/a")).click();
        map.put("source1",driver.findElement(By.xpath(source1)).getText());
        map.put("destination1",driver.findElement(By.xpath(destination1)).getText());
        map.put("airlineCode1",driver.findElement(By.xpath(airlineCode1)).getText());
        map.put("startTime1",driver.findElement(By.xpath(startTime1)).getText());
        map.put("endTime1",driver.findElement(By.xpath(endTime1)).getText());
        map.put("source2",driver.findElement(By.xpath(source2)).getText());
        map.put("destination2",driver.findElement(By.xpath(destination2)).getText());
        map.put("airlineCode2",driver.findElement(By.xpath(airlineCode2)).getText());
        map.put("startTime2",driver.findElement(By.xpath(startTime2)).getText());
        map.put("endTime2",driver.findElement(By.xpath(endTime2)).getText());
        System.out.println("The details are stored in map");


    }

    @And("Click on select go button")
    public void clickOnSelectGoButton() {
        System.out.println("Click on select go button");
        driver.findElement(By.xpath("//*[@id=\"travel-blibli-app\"]/div/main/div[1]/section/div/div[3]/div[2]/div[2]/div[3]/div[3]/div[6]/div/div/div[2]/button")).click();
    }

    @And("Click on the detail section and verify details")
    public void clickOnTheDetailSectionAndVerifyDetails() throws InterruptedException {
        Thread.sleep(3000);
        driver.findElement(By.xpath("//a[@class=\"order-header-right-value\"]")).click();
        Thread.sleep(3000);
        System.out.println("Assert the details in detail page");
        assertEquals(map.get("source1"),driver.findElement(By.xpath(source1)).getText());
        assertEquals(map.get("destination1"),driver.findElement(By.xpath(destination1)).getText());
        assertEquals(map.get("airlineCode1"),driver.findElement(By.xpath(airlineCode1)).getText());
        assertEquals(map.get("startTime1"),driver.findElement(By.xpath(startTime1)).getText());
        assertEquals(map.get("endTime1"),driver.findElement(By.xpath(endTime1)).getText());
        assertEquals(map.get("source2"),driver.findElement(By.xpath(source2)).getText());
        assertEquals(map.get("destination2"),driver.findElement(By.xpath(destination2)).getText());
        assertEquals(map.get("airlineCode2"),driver.findElement(By.xpath(airlineCode2)).getText());
        assertEquals(map.get("startTime2"),driver.findElement(By.xpath(startTime2)).getText());
        assertEquals(map.get("endTime2"),driver.findElement(By.xpath(endTime2)).getText());
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
        driver.findElement(By.xpath("//*[@id=\"travel-blibli-app\"]/div/main/div[1]/section/div/div[2]/div[1]/div[4]/div[1]/div[1]/div[2]/label")).click();
        Thread.sleep(3000);
        Select date = new Select(driver.findElement(By.xpath("//*[@id=\"travel-blibli-app\"]/div/main/div[1]/section/div/div[2]/div[1]/div[4]/div[1]/div[2]/div/div[3]/div/div/ul/li[1]/select")));
        date.selectByVisibleText("12");

        Select month=new Select(driver.findElement(By.xpath("//*[@id=\"travel-blibli-app\"]/div/main/div[1]/section/div/div[2]/div[1]/div[4]/div[1]/div[2]/div/div[3]/div/div/ul/li[2]/select")));
        month.selectByVisibleText("Jun");

        Select year=new Select(driver.findElement(By.xpath("//*[@id=\"travel-blibli-app\"]/div/main/div[1]/section/div/div[2]/div[1]/div[4]/div[1]/div[2]/div/div[3]/div/div/ul/li[3]/select")));
        year.selectByVisibleText("1999");
        Thread.sleep(2000);
        System.out.println("The details are entered");


    }

    @And("Click on continue ordering to book")
    public void clickOnContinueOrderingToBook() {
        System.out.println("Confirm booking");
        driver.findElement(By.xpath("//button[contains(text(),'Lanjutkan pemesanan')]")).click();
        driver.findElement(By.xpath("//button[contains(text(),'Yakin, lanjutkan')]")).click();
    }

    @And("Click on the detail section and verify the details")
    public void clickOnTheDetailSectionAndVerifyTheDetails() throws InterruptedException {
        System.out.println("Assert the details on payment page");
        Thread.sleep(5000);
        js.executeScript("window.scrollBy(0,500)");
        Thread.sleep(3000);
        driver.findElement(By.xpath("//a[@class=\"order-header-right-value\"]")).click();
        assertEquals(map.get("source1"),driver.findElement(By.xpath(source1)).getText());
        assertEquals(map.get("destination1"),driver.findElement(By.xpath(destination1)).getText());
        assertEquals(map.get("airlineCode1"),driver.findElement(By.xpath(airlineCode1)).getText());
        assertEquals(map.get("startTime1"),driver.findElement(By.xpath(startTime1)).getText());
        assertEquals(map.get("endTime1"),driver.findElement(By.xpath(endTime1)).getText());
        assertEquals(map.get("source2"),driver.findElement(By.xpath(source2)).getText());
        assertEquals(map.get("destination2"),driver.findElement(By.xpath(destination2)).getText());
        assertEquals(map.get("airlineCode2"),driver.findElement(By.xpath(airlineCode2)).getText());
        assertEquals(map.get("startTime2"),driver.findElement(By.xpath(startTime2)).getText());
        assertEquals(map.get("endTime2"),driver.findElement(By.xpath(endTime2)).getText());
        driver.findElement(By.xpath("//b[contains(text(),'×')]")).click();
        System.out.println("Asserted the details on payment page");
    }
}
