package com.fasterxml.jackson.core;
import com.fasterxml.jackson.core.Base64Variant;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class Base64Variant_encode_byte_____boolean_cfg_path_22_Test {
    
    @Test(timeout = 4000)
    public void testEncodeWithQuotes() {
        Base64Variant base64Variant = new Base64Variant("test", "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789+/", true, ' ', 76);
        byte[] input = { (byte) 0xF0, (byte) 0x9F, (byte) 0x92, (byte) 0xA9 }; // Example input
        String expectedOutput = "\"8J+YgPCfmPog=\""; // Expected output based on encoding
        
        String result = base64Variant.encode(input, true);

        assertEquals(expectedOutput, result);
    }

    @Test(timeout = 4000)
    public void testEncodeWithoutQuotes() {
        Base64Variant base64Variant = new Base64Variant("test", "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789+/", true, ' ', 76);
        byte[] input = { (byte) 0xE2, (byte) 0x9C, (byte) 0x94 }; // Example input
        String expectedOutput = "4oCU"; // Expected output based on encoding
        
        String result = base64Variant.encode(input, false);

        assertEquals(expectedOutput, result);
    }

    @Test(timeout = 4000)
    public void testEncodeEmptyInputWithQuotes() {
        Base64Variant base64Variant = new Base64Variant("test", "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789+/", true, ' ', 76);
        byte[] input = {}; // Empty input
        String expectedOutput = "\"\""; // Expected output as empty string with quotes
        
        String result = base64Variant.encode(input, true);

        assertEquals(expectedOutput, result);
    }

    @Test(timeout = 4000)
    public void testEncodeEmptyInputWithoutQuotes() {
        Base64Variant base64Variant = new Base64Variant("test", "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789+/", true, ' ', 76);
        byte[] input = {}; // Empty input
        String expectedOutput = ""; // Expected output as empty string without quotes
        
        String result = base64Variant.encode(input, false);

        assertEquals(expectedOutput, result);
    }


}