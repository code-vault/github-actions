import io.restassured.response.Response;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.List;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.hasItem;

public class DemoTest {

    @BeforeClass
    public void loginUser(){
//        Response users = given().get();
    }


    @Test
    public void demo(){
        Response response = given().baseUri("https://dummy.restapiexample.com/api/v1")
                .when()
                .get("/employees")
                .then()
                .statusCode(200)
                .log().all()
                .extract().response();

        System.out.println(response);
        response.then()
                .body("data.id", hasItem(6))
                .body("data.find { it.id == '6'  }.employee_salary", equalTo("372000"));
//        List<String> price = response.jsonPath().getList("data").get();
//        System.out.println(price);
    }

    @Test
    public void openGoogle(){
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.google.com");
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        driver.quit();
    }


}
