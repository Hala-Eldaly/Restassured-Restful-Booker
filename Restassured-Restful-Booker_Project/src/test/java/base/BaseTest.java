package base;

import io.restassured.RestAssured;
import org.testng.annotations.BeforeSuite;

public class BaseTest {
    @BeforeSuite
    public void setup() {
        RestAssured.baseURI = api.utils.ConfigManager.getBaseUrl();
    }
}