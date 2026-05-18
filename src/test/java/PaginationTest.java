import io.cucumber.java.BeforeAll;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

public class PaginationTest {

//    WebDriver driver;
//
//    @BeforeClass
//    public void setup(){
//        this.driver = new ChromeDriver();
//    }

    @Test
    public void testPagination(){
        WebDriver driver = new ChromeDriver();
        String price = "";
        driver.get("https://testautomationpractice.blogspot.com/");


        price = getPrice(driver, "Television");

        System.out.println("The product price is : " + price);
        driver.quit();
    }

    public String getPrice(WebDriver driver, String productName){
        List<WebElement> pages = driver.findElements(By.xpath("//ul[@id ='pagination']//li"));
        for(int i = 1; i < pages.size()+2; i++){
            List<WebElement> productsOnPage = driver.findElements(By.xpath(String.format("//table[@id='productTable']//tr/td[text() = '%s']", productName)));
            if (!productsOnPage.isEmpty()){
                WebElement priceEl = driver.findElement(By.xpath(String.format("(//table[@id='productTable']//tr/td[text() = '%s']/following-sibling::td)[1]", productName)));
                return priceEl.getText();
            }
            pages.get(i).click();
        }
        return "Price Not Found";
    }


}
