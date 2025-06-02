package org.apache.commons.codec.binary;

import org.apache.commons.codec.binary.BaseNCodec.Context;
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

class Base64_validateCharacter_25_0_Test {

    private Base64 base64;

    private Context context;

    @BeforeEach
    void setUp() {
        base64 = new Base64();
        context = new Context();
    }

    private void invokeValidateCharacter(int emptyBitsMask, Context context) throws Exception {
        Method method = Base64.class.getDeclaredMethod("validateCharacter", int.class, Context.class);
        method.setAccessible(true);
        method.invoke(base64, emptyBitsMask, context);
    }

    @Test
    void testValidateCharacterWhenStrictDecodingIsEnabledAndEmptyBitsAreValid() throws Exception {
        // Arrange
        context.ibitWorkArea = 0;
        int emptyBitsMask = 0b11111100;
        // Act & Assert
        assertDoesNotThrow(() -> invokeValidateCharacter(emptyBitsMask, context));
    }

    @Test
    void testValidateCharacterWhenStrictDecodingIsEnabledAndEmptyBitsAreInvalid() throws Exception {
        // Arrange
        context.ibitWorkArea = 1;
        int emptyBitsMask = 0b11111100;
        // Act & Assert
        IllegalArgumentException thrown = assertThrows(IllegalArgumentException.class, () -> invokeValidateCharacter(emptyBitsMask, context));
        assertEquals("Strict decoding: Last encoded character (before the paddings if any) is a valid base 64 alphabet but not a possible encoding. Expected the discarded bits from the character to be zero.", thrown.getMessage());
    }

    @Test
    void testValidateCharacterWhenStrictDecodingIsDisabled() throws Exception {
        // Arrange
        context.ibitWorkArea = 1;
        int emptyBitsMask = 0b11111100;
        // Act & Assert
        assertDoesNotThrow(() -> invokeValidateCharacter(emptyBitsMask, context));
    }
}
