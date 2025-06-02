package api.utils;

import io.restassured.response.Response;
import org.testng.Assert;

public class ResponseValidator {
    public static void validateStatusCode(Response response, int expectedCode) {
        Assert.assertEquals(response.getStatusCode(), expectedCode, "Status code is not as expected");
    }

    public static void validateResponseContains(Response response, String key) {
        Assert.assertTrue(response.jsonPath().getMap("").containsKey(key), "Response does not contain key: " + key);
    }

    public static void validateResponseArray(Response response) {
        Assert.assertTrue(response.jsonPath().getList("").size() > 0, "Response array is empty");
    }
}