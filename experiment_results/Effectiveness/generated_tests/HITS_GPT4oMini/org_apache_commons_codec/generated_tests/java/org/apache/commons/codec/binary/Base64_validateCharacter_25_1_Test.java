package org.apache.commons.codec.binary;

import org.apache.commons.codec.binary.BaseNCodec;
import java.lang.reflect.Method;
import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import java.math.BigInteger;
import java.util.Arrays;
import java.util.Objects;
import org.apache.commons.codec.CodecPolicy;

class Base64_validateCharacter_25_1_Test {

    private static class Base64TestWrapper extends Base64 {

        public void testValidateCharacter(int emptyBitsMask, BaseNCodec.Context context) throws Exception {
            Method method = Base64.class.getDeclaredMethod("validateCharacter", int.class, BaseNCodec.Context.class);
            // Make the private method accessible
            method.setAccessible(true);
            method.invoke(this, emptyBitsMask, context);
        }
    }

    @Test
    void testValidateCharacter_ValidInput_NoException() throws Exception {
        Base64TestWrapper base64 = new Base64TestWrapper();
        BaseNCodec.Context context = new BaseNCodec.Context();
        assertDoesNotThrow(() -> base64.testValidateCharacter(0b11111100, context));
    }

    @Test
    void testValidateCharacter_InvalidInput_ThrowsException() throws Exception {
        Base64TestWrapper base64 = new Base64TestWrapper();
        BaseNCodec.Context context = new BaseNCodec.Context();
        context.ibitWorkArea = 0b00000011;
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> base64.testValidateCharacter(0b11111100, context));
        assertEquals("Strict decoding: Last encoded character (before the paddings if any) is a valid base 64 alphabet but not a possible encoding. Expected the discarded bits from the character to be zero.", exception.getMessage());
    }

    @Test
    void testValidateCharacter_StrictDecoding_ValidInput_NoException() throws Exception {
        Base64TestWrapper base64 = new Base64TestWrapper();
        BaseNCodec.Context context = new BaseNCodec.Context();
        // Assuming isStrictDecoding() returns true for this test
        assertDoesNotThrow(() -> base64.testValidateCharacter(0b11111100, context));
    }

    @Test
    void testValidateCharacter_StrictDecoding_InvalidInput_ThrowsException() throws Exception {
        Base64TestWrapper base64 = new Base64TestWrapper();
        BaseNCodec.Context context = new BaseNCodec.Context();
        context.ibitWorkArea = 0b00000011;
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> base64.testValidateCharacter(0b11111100, context));
        assertEquals("Strict decoding: Last encoded character (before the paddings if any) is a valid base 64 alphabet but not a possible encoding. Expected the discarded bits from the character to be zero.", exception.getMessage());
    }
}
