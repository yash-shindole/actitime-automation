package com.orangehrm.automation;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.function.Function;

import static com.google.common.util.concurrent.Futures.withTimeout;

public class CommonFunction {
    WebDriver driver;
public CommonFunction(WebDriver driver){
    this.driver=driver;
}

    //launch the browser
    public WebDriver launchBrowser(String name) {
        if (name.toLowerCase().equals("chrome")) {
            ChromeOptions options = new ChromeOptions();
            options.setBrowserVersion("121");
            options.addArguments("--remote-allow-origins=*");
            driver = new ChromeDriver(options);

        }
        return driver;
    }
    public void click(WebElement loginButton){


    }

    public void waitElementToPresent(By by) {

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOf(driver.findElement(by)));

    }
    public void waitElementToeClickable(WebElement element){
        WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.elementToBeClickable(element));

    }
    public void waitElementToClickable(By by){
        WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(10));

    }
    public void fluentWait(By by) {
        Wait<WebDriver> fluentWait = new FluentWait<>(driver);
        //pollingEvery(Duration.ofSeconds(5))
        //  withTimeout(Duration.ofSeconds(25))


        Function<WebDriver, WebElement> function = (var) -> {
            System.out.println("Wait until the element is avalible");
            waitElementToClickable((By) driver.findElement(by));
            return  driver.findElement(by);


        };
        fluentWait.until(function);



        }
        public void entertextWithJs(String text, WebElement element){
        JavascriptExecutor js=(JavascriptExecutor) driver;
        js.executeScript("arguments[0].value='"+text+"';", element);
        }
        public void clickUsingJS(WebElement element){
        JavascriptExecutor js=(JavascriptExecutor) driver;
        js.executeScript("arguments[0].click();", element);

        }
        public void scrollToElement(WebElement element){
        JavascriptExecutor js=(JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView();", element);



        }
        public void scrollBy(int x, int y){
        JavascriptExecutor js=(JavascriptExecutor) driver;
        js.executeScript("window.scrollBy("+x+","+y+");");
        }
      //  public void click(WebElement element){


        }

















