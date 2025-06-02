package api.endpoints;

import api.utils.ConfigManager;
import io.restassured.response.Response;
import static io.restassured.RestAssured.given;

public class PingEndpoint {
    private static final String PING_PATH = "/ping";

    public Response healthCheck() {
        return given()
                .get(ConfigManager.getBaseUrl() + PING_PATH);
    }
}