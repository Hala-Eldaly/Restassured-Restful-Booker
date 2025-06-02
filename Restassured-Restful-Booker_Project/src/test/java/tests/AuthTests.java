package tests;

import api.endpoints.AuthEndpoint;
import api.models.AuthRequest;
import api.models.AuthResponse;
import api.utils.ConfigManager;
import api.utils.ResponseValidator;
import base.BaseTest;
import io.restassured.response.Response;
import org.testng.annotations.Test;

import static org.testng.Assert.assertTrue;

public class AuthTests extends BaseTest {
    private final AuthEndpoint authEndpoint = new AuthEndpoint();

    @Test
    public void testCreateToken() {
        AuthRequest authRequest = new AuthRequest(ConfigManager.getUsername(), ConfigManager.getPassword());
        Response response = authEndpoint.createToken(authRequest);

        ResponseValidator.validateStatusCode(response, 200);
        ResponseValidator.validateResponseContains(response, "token");

        AuthResponse authResponse = response.as(AuthResponse.class);
        assertTrue(authResponse.getToken().length() > 10, "Token length should be greater than 10");
    }
}