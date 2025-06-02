package api.endpoints;

import api.models.AuthRequest;
import api.utils.ConfigManager;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import static io.restassured.RestAssured.given;

public class AuthEndpoint {
    private static final String AUTH_PATH = "/auth";

    public Response createToken(AuthRequest authRequest) {
        return given()
                .contentType(ContentType.JSON)
                .body(authRequest)
                .post(ConfigManager.getBaseUrl() + AUTH_PATH);
    }
}