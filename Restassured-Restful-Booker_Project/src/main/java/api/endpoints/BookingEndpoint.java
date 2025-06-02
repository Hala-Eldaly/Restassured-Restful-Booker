package api.endpoints;

import api.models.Booking;
import api.utils.ConfigManager;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import static io.restassured.RestAssured.given;

public class BookingEndpoint {
    private static final String BOOKING_PATH = "/booking";

    public Response getBookingIds() {
        return given()
                .get(ConfigManager.getBaseUrl() + BOOKING_PATH);
    }

    public Response getBooking(String bookingId) {
        return given()
                .header("Accept", "application/json")
                .get(ConfigManager.getBaseUrl() + BOOKING_PATH + "/" + bookingId);
    }

    public Response createBooking(Booking booking) {
        return given()
                .contentType(ContentType.JSON)
                .header("Accept", "application/json")
                .body(booking)
                .post(ConfigManager.getBaseUrl() + BOOKING_PATH);
    }

    public Response updateBooking(String bookingId, Booking booking, String token) {
        return given()
                .contentType(ContentType.JSON)
                .header("Accept", "application/json")
                .header("Cookie", "token=" + token)
                .body(booking)
                .put(ConfigManager.getBaseUrl() + BOOKING_PATH + "/" + bookingId);
    }

    public Response partialUpdateBooking(String bookingId, String jsonBody, String token) {
        return given()
                .contentType(ContentType.JSON)
                .header("Cookie", "token=" + token)
                .body(jsonBody)
                .patch(ConfigManager.getBaseUrl() + BOOKING_PATH + "/" + bookingId);
    }

    public Response deleteBooking(String bookingId, String token) {
        return given()
                .header("Cookie", "token=" + token)
                .delete(ConfigManager.getBaseUrl() + BOOKING_PATH + "/" + bookingId);
    }
}