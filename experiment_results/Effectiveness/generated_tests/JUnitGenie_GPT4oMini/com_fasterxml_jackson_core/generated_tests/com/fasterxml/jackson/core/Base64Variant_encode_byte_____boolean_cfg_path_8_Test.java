package com.fasterxml.jackson.core;
import com.fasterxml.jackson.core.Base64Variant;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class Base64Variant_encode_byte_____boolean_cfg_path_8_Test {

    @Test(timeout = 4000)
    public void testEncodeWithoutQuotes() {
        Base64Variant base64Variant = new Base64Variant("Base64", "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789+/", true, '=', 76);
        byte[] input = new byte[]{1, 2, 3, 4}; // Example input
        String expectedOutput = "AQIDBA=="; // Expected base64 output without quotes
        String actualOutput = base64Variant.encode(input, false);
        assertEquals(expectedOutput, actualOutput);
    }

    @Test(timeout = 4000)
    public void testEncodeWithQuotes() {
        Base64Variant base64Variant = new Base64Variant("Base64", "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789+/", true, '=', 76);
        byte[] input = new byte[]{1, 2, 3, 4}; // Example input
        String expectedOutput = "\"AQIDBA==\""; // Expected base64 output with quotes
        String actualOutput = base64Variant.encode(input, true);
        assertEquals(expectedOutput, actualOutput);
    }

    @Test(timeout = 4000)
    public void testEncodeWithInsufficientBytes() {
        Base64Variant base64Variant = new Base64Variant("Base64", "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789+/", true, '=', 76);
        byte[] input = new byte[]{1}; // Insufficient bytes
        String expectedOutput = "AQ=="; // Expected base64 output for one byte
        String actualOutput = base64Variant.encode(input, false);
        assertEquals(expectedOutput, actualOutput);
    }

    @Test(timeout = 4000)
    public void testEncodeWithTwoInsufficientBytes() {
        Base64Variant base64Variant = new Base64Variant("Base64", "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789+/", true, '=', 76);
        byte[] input = new byte[]{1, 2}; // Two bytes
        String expectedOutput = "AQI="; // Expected base64 output for two bytes
        String actualOutput = base64Variant.encode(input, false);
        assertEquals(expectedOutput, actualOutput);
    }

    @Test(timeout = 4000)
    public void testEncodeEmptyInput() {
        Base64Variant base64Variant = new Base64Variant("Base64", "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789+/", true, '=', 76);
        byte[] input = new byte[]{}; // Empty input
        String expectedOutput = ""; // Expected output for empty input
        String actualOutput = base64Variant.encode(input, false);
        assertEquals(expectedOutput, actualOutput);
    }


}