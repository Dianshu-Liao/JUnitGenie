package com.fasterxml.jackson.core;
import com.fasterxml.jackson.core.Base64Variant;
import org.junit.Test;
import static org.junit.Assert.assertFalse;

public class Base64Variant_usesPaddingChar_int_cfg_path_1_Test {

    @Test(timeout = 4000)
    public void testUsesPaddingCharReturnsFalseWhenChDoesNotEqualPaddingChar() {
        // Arrange
        char paddingChar = 'A'; // Example padding character
        String base64Alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789+/"; // Correct Base64 alphabet
        Base64Variant base64Variant = new Base64Variant("test", base64Alphabet, false, paddingChar, 0);
        
        // Act
        boolean result = base64Variant.usesPaddingChar('B'); // 'B' is not equal to 'A'

        // Assert
        assertFalse(result);
    }


}