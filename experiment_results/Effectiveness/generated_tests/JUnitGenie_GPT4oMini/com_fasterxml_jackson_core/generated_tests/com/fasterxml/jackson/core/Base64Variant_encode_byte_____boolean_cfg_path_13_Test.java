package com.fasterxml.jackson.core;
import com.fasterxml.jackson.core.Base64Variant;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class Base64Variant_encode_byte_____boolean_cfg_path_13_Test {

    @Test(timeout = 4000)
    public void testEncodeWithQuotes() {
        // Arrange
        Base64Variant base64Variant = new Base64Variant("test", "test", true, 'A', 76);
        byte[] input = {1, 2, 3, 4, 5};
        boolean addQuotes = true;

        // Act
        String result = base64Variant.encode(input, addQuotes);

        // Assert
        String expected = "\"AQIDBAU=\""; // Expected output based on the input
        assertEquals(expected, result);
    }

    @Test(timeout = 4000)
    public void testEncodeWithoutQuotes() {
        // Arrange
        Base64Variant base64Variant = new Base64Variant("test", "test", true, 'A', 76);
        byte[] input = {1, 2, 3, 4, 5};
        boolean addQuotes = false;

        // Act
        String result = base64Variant.encode(input, addQuotes);

        // Assert
        String expected = "AQIDBAU="; // Expected output based on the input
        assertEquals(expected, result);
    }

    @Test(timeout = 4000)
    public void testEncodeWithEmptyInput() {
        // Arrange
        Base64Variant base64Variant = new Base64Variant("test", "test", true, 'A', 76);
        byte[] input = {};
        boolean addQuotes = true;

        // Act
        String result = base64Variant.encode(input, addQuotes);

        // Assert
        String expected = "\"\""; // Expected output for empty input
        assertEquals(expected, result);
    }

    @Test(timeout = 4000)
    public void testEncodeWithSingleByte() {
        // Arrange
        Base64Variant base64Variant = new Base64Variant("test", "test", true, 'A', 76);
        byte[] input = {1};
        boolean addQuotes = true;

        // Act
        String result = base64Variant.encode(input, addQuotes);

        // Assert
        String expected = "\"AQ==\""; // Expected output for single byte
        assertEquals(expected, result);
    }

    @Test(timeout = 4000)
    public void testEncodeWithTwoBytes() {
        // Arrange
        Base64Variant base64Variant = new Base64Variant("test", "test", true, 'A', 76);
        byte[] input = {1, 2};
        boolean addQuotes = true;

        // Act
        String result = base64Variant.encode(input, addQuotes);

        // Assert
        String expected = "\"AQI=\""; // Expected output for two bytes
        assertEquals(expected, result);
    }

    // Additional test to ensure Base64Variant is initialized correctly
    @Test(expected = IllegalArgumentException.class)
    public void testBase64VariantInitialization() {
        // This test will check if the Base64Variant constructor throws an exception
        // when the Base64 alphabet is not valid.
        new Base64Variant("test", "test", true, 'A', 4); // Invalid length
    }

}