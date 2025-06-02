package api.utils;

import api.models.Booking;
import api.models.BookingDates;

public class TestDataGenerator {
    public static Booking createBooking() {
        return new Booking(
                "Hala",
                "Eldaly",
                111,
                true,
                new BookingDates("2018-01-01", "2019-01-01"),
                "Breakfast"
        );
    }

    public static Booking createUpdatedBooking() {
        return new Booking(
                "Hala",
                "Eldaly",
                222,
                true,
                new BookingDates("2018-01-01", "2019-01-01"),
                "Breakfast"
        );
    }
}