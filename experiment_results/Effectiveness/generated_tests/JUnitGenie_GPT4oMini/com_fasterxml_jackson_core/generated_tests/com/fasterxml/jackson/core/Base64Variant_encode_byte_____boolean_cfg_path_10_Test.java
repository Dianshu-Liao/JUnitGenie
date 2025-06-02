package com.fasterxml.jackson.core;
import com.fasterxml.jackson.core.Base64Variant;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class Base64Variant_encode_byte_____boolean_cfg_path_10_Test {

    @Test(timeout = 4000)
    public void testEncodeWithQuotes() {
        Base64Variant base64Variant = new Base64Variant("test", "test", true, 'A', 0);
        byte[] input = {1, 2, 3, 4, 5};
        String expectedOutput = "\"AQIDBAU=\""; // Replace with the expected Base64 encoded string
        String actualOutput = base64Variant.encode(input, true);
        assertEquals(expectedOutput, actualOutput);
    }

    @Test(timeout = 4000)
    public void testEncodeWithoutQuotes() {
        Base64Variant base64Variant = new Base64Variant("test", "test", true, 'A', 0);
        byte[] input = {1, 2, 3, 4, 5};
        String expectedOutput = "AQIDBAU="; // Replace with the expected Base64 encoded string
        String actualOutput = base64Variant.encode(input, false);
        assertEquals(expectedOutput, actualOutput);
    }

    @Test(timeout = 4000)
    public void testEncodeWithEmptyInput() {
        Base64Variant base64Variant = new Base64Variant("test", "test", true, 'A', 0);
        byte[] input = {};
        String expectedOutput = "\"\""; // Expected output for empty input with quotes
        String actualOutput = base64Variant.encode(input, true);
        assertEquals(expectedOutput, actualOutput);
    }

    @Test(timeout = 4000)
    public void testEncodeWithNullInput() {
        Base64Variant base64Variant = new Base64Variant("test", "test", true, 'A', 0);
        byte[] input = null;
        try {
            base64Variant.encode(input, true);
        } catch (IllegalArgumentException e) {
            // Handle the exception as needed
            assertEquals("Input byte array cannot be null", e.getMessage());
        }
    }


}