package com.fasterxml.jackson.core;
import com.fasterxml.jackson.core.Base64Variant;
import org.junit.Test;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class Base64Variant_usesPaddingChar_int_cfg_path_2_Test {

    @Test(timeout = 4000)
    public void testUsesPaddingChar() {
        // Correctly initialize Base64Variant with a valid Base64 alphabet
        String base64Alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789+/"; // 64 characters
        Base64Variant variant = new Base64Variant("test", base64Alphabet, false, 'P', 0);

        // Test case where the input matches the padding character
        int paddingCharMatch = 'P';
        assertTrue(variant.usesPaddingChar(paddingCharMatch));

        // Test case where the input does not match the padding character
        int paddingCharNoMatch = 'A';
        assertFalse(variant.usesPaddingChar(paddingCharNoMatch));
    }


}