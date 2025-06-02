package com.fasterxml.jackson.core;
import com.fasterxml.jackson.core.Base64Variant;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class Base64Variant_encode_byte_____boolean_cfg_path_29_Test {

    @Test(timeout = 4000)
    public void testEncodeWithQuotes() {
        Base64Variant base64Variant = new Base64Variant("test", "test", true, 'A', 0);
        byte[] input = {1, 2, 3, 4, 5};
        String expectedOutput = "\"AQIDBAU=\""; // Expected output based on the encoding logic
        String actualOutput = base64Variant.encode(input, true);
        assertEquals(expectedOutput, actualOutput);
    }

    @Test(timeout = 4000)
    public void testEncodeWithoutQuotes() {
        Base64Variant base64Variant = new Base64Variant("test", "test", true, 'A', 0);
        byte[] input = {1, 2, 3, 4, 5};
        String expectedOutput = "AQIDBAU="; // Expected output based on the encoding logic
        String actualOutput = base64Variant.encode(input, false);
        assertEquals(expectedOutput, actualOutput);
    }

    @Test(timeout = 4000)
    public void testEncodeEmptyInput() {
        Base64Variant base64Variant = new Base64Variant("test", "test", true, 'A', 0);
        byte[] input = {};
        String expectedOutput = "\"\""; // Expected output for empty input with quotes
        String actualOutput = base64Variant.encode(input, true);
        assertEquals(expectedOutput, actualOutput);
    }

    @Test(timeout = 4000)
    public void testEncodeSingleByteInput() {
        Base64Variant base64Variant = new Base64Variant("test", "test", true, 'A', 0);
        byte[] input = {1};
        String expectedOutput = "\"AQ==\""; // Expected output for single byte input
        String actualOutput = base64Variant.encode(input, true);
        assertEquals(expectedOutput, actualOutput);
    }

    @Test(timeout = 4000)
    public void testEncodeTwoBytesInput() {
        Base64Variant base64Variant = new Base64Variant("test", "test", true, 'A', 0);
        byte[] input = {1, 2};
        String expectedOutput = "\"AQI=\""; // Expected output for two bytes input
        String actualOutput = base64Variant.encode(input, true);
        assertEquals(expectedOutput, actualOutput);
    }

    // Additional test to ensure Base64Variant is initialized correctly
    @Test(timeout = 4000)
    public void testBase64VariantInitialization() {
        // Correct initialization of Base64Variant with a valid Base64 alphabet
        Base64Variant base64Variant = new Base64Variant("test", "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789+/", true, 'A', 0);
        assertEquals("test", base64Variant.getName());
    }

}