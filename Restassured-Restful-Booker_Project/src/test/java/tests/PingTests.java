package tests;

import api.endpoints.PingEndpoint;
import api.utils.ResponseValidator;
import base.BaseTest;
import io.restassured.response.Response;
import org.testng.annotations.Test;
import static org.testng.Assert.assertEquals;

public class PingTests extends BaseTest {
    private final PingEndpoint pingEndpoint = new PingEndpoint();

    @Test
    public void testHealthCheck() {
        Response response = pingEndpoint.healthCheck();

        ResponseValidator.validateStatusCode(response, 201);
        assertEquals(response.asString(), "Created", "Response should be 'Created'");
    }
}