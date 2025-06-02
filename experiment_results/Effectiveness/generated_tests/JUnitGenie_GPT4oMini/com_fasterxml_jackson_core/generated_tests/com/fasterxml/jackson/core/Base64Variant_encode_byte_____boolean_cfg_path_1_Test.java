package com.fasterxml.jackson.core;
import com.fasterxml.jackson.core.Base64Variant;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class Base64Variant_encode_byte_____boolean_cfg_path_1_Test {

    @Test(timeout = 4000)
    public void testEncode_withQuotes() {
        try {
            Base64Variant base64Variant = new Base64Variant("MIME", "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789+/", true, '=', 76);
            byte[] input = new byte[] { (byte) 65, (byte) 66, (byte) 67 }; // ABC
            String expectedOutput = "\"QUJD\""; // Expected Base64 encoded string with quotes
            String actualOutput = base64Variant.encode(input, true);
            assertEquals(expectedOutput, actualOutput);
        } catch (Exception e) {
            // Handle the exception if it occurs
            e.printStackTrace();
        }
    }

    @Test(timeout = 4000)
    public void testEncode_withoutQuotes() {
        try {
            Base64Variant base64Variant = new Base64Variant("MIME", "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789+/", true, '=', 76);
            byte[] input = new byte[] { (byte) 65, (byte) 66, (byte) 67 }; // ABC
            String expectedOutput = "QUJD"; // Expected Base64 encoded string without quotes
            String actualOutput = base64Variant.encode(input, false);
            assertEquals(expectedOutput, actualOutput);
        } catch (Exception e) {
            // Handle the exception if it occurs
            e.printStackTrace();
        }
    }


}