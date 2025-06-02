package api.utils;

import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Properties;

public class ConfigManager {
    private static final Properties properties = new Properties();

    static {
        try (InputStream input = ConfigManager.class.getClassLoader().getResourceAsStream("config.properties")) {
            if (input == null) {
                throw new IOException("Unable to find config.properties");
            }
            properties.load(input);
        } catch (IOException e) {
            throw new RuntimeException("Failed to load configuration", e);
        }
    }

    public static String getBaseUrl() {
        String baseUrl = properties.getProperty("baseUrl");
        if (baseUrl == null || baseUrl.trim().isEmpty()) {
            throw new IllegalStateException("baseUrl is not set in config.properties");
        }
        baseUrl = baseUrl.trim();
        // Validate URL format
        try {
            new URL(baseUrl);
        } catch (MalformedURLException e) {
            throw new IllegalStateException("Invalid baseUrl format in config.properties: " + baseUrl, e);
        }
        return baseUrl;
    }

    public static String getUsername() {
        String username = properties.getProperty("username");
        if (username == null || username.trim().isEmpty()) {
            throw new IllegalStateException("username is not set in config.properties");
        }
        return username.trim();
    }

    public static String getPassword() {
        String password = properties.getProperty("password");
        if (password == null || password.trim().isEmpty()) {
            throw new IllegalStateException("password is not set in config.properties");
        }
        return password.trim();
    }

    public static String getBookingId() {
        String bookingId = properties.getProperty("bookingId");
        if (bookingId == null || bookingId.trim().isEmpty()) {
            throw new IllegalStateException("bookingId is not set in config.properties");
        }
        return bookingId.trim();
    }
}