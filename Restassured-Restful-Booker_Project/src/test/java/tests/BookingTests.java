package tests;

import api.endpoints.AuthEndpoint;
import api.endpoints.BookingEndpoint;
import api.models.AuthRequest;
import api.models.Booking;
import api.utils.ConfigManager;
import api.utils.ResponseValidator;
import api.utils.TestDataGenerator;
import base.BaseTest;
import io.restassured.response.Response;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import java.util.Map;
import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class BookingTests extends BaseTest {
    private final BookingEndpoint bookingEndpoint = new BookingEndpoint();
    private final AuthEndpoint authEndpoint = new AuthEndpoint();
    private String token;
    private String bookingId;

    @BeforeClass
    public void setupToken() {
        AuthRequest authRequest = new AuthRequest(ConfigManager.getUsername(), ConfigManager.getPassword());
        Response authResponse = authEndpoint.createToken(authRequest);
        token = authResponse.jsonPath().getString("token");
    }

    @Test
    public void testGetBookingIds() {
        Response response = bookingEndpoint.getBookingIds();

        ResponseValidator.validateStatusCode(response, 200);
        ResponseValidator.validateResponseArray(response);

        assertTrue(response.jsonPath().getList("").stream()
                        .allMatch(item -> ((Map<?, ?>) item).containsKey("bookingid")),
                "All items should have bookingid");
    }

    @Test
    public void testGetBooking() {
        Response response = bookingEndpoint.getBooking(ConfigManager.getBookingId());

        ResponseValidator.validateStatusCode(response, 200);
        ResponseValidator.validateResponseContains(response, "firstname");
        ResponseValidator.validateResponseContains(response, "lastname");
        ResponseValidator.validateResponseContains(response, "totalprice");
        ResponseValidator.validateResponseContains(response, "depositpaid");
        ResponseValidator.validateResponseContains(response, "bookingdates");

        assertTrue(response.jsonPath().getMap("bookingdates").containsKey("checkin"),
                "Booking dates should have checkin");
        assertTrue(response.jsonPath().getMap("bookingdates").containsKey("checkout"),
                "Booking dates should have checkout");
    }

    @Test
    public void testCreateBooking() {
        Booking booking = TestDataGenerator.createBooking();
        Response response = bookingEndpoint.createBooking(booking);

        ResponseValidator.validateStatusCode(response, 200);
        ResponseValidator.validateResponseContains(response, "bookingid");

        assertTrue(response.jsonPath().getInt("bookingid") > 0, "Booking ID should be a number");
        assertEquals(response.jsonPath().getString("booking.firstname"), "Hala");
        assertEquals(response.jsonPath().getString("booking.lastname"), "Eldaly");
        assertEquals(response.jsonPath().getInt("booking.totalprice"), 111);

        bookingId = response.jsonPath().getString("bookingid");
    }

    @Test(dependsOnMethods = "testCreateBooking")
    public void testUpdateBooking() {
        Booking updatedBooking = TestDataGenerator.createUpdatedBooking();
        Response response = bookingEndpoint.updateBooking(bookingId, updatedBooking, token);

        ResponseValidator.validateStatusCode(response, 200);
        assertEquals(response.jsonPath().getString("firstname"), "Hala");
        assertEquals(response.jsonPath().getString("lastname"), "Eldaly");
        assertEquals(response.jsonPath().getInt("totalprice"), 222);
    }

    @Test(dependsOnMethods = "testCreateBooking")
    public void testPartialUpdateBooking() {
        String updateBody = "{\"firstname\": \"Janet\"}";
        Response response = bookingEndpoint.partialUpdateBooking(bookingId, updateBody, token);

        ResponseValidator.validateStatusCode(response, 200);
        assertEquals(response.jsonPath().getString("firstname"), "Janet");
    }

    @Test(dependsOnMethods = {"testCreateBooking", "testUpdateBooking", "testPartialUpdateBooking"})
    public void testDeleteBooking() {
        Response response = bookingEndpoint.deleteBooking(bookingId, token);

        ResponseValidator.validateStatusCode(response, 201);
        assertEquals(response.asString(), "Created", "Response should contain 'Created'");
    }
}