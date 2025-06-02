package org.apache.commons.codec.binary;

import java.lang.reflect.Method;
import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import java.util.Objects;
import org.apache.commons.codec.CodecPolicy;

class Base32_validateCharacter_7_0_Test {

    private Method validateCharacterMethod;

    @BeforeEach
    void setUp() throws NoSuchMethodException {
        validateCharacterMethod = Base32.class.getDeclaredMethod("validateCharacter", long.class, BaseNCodec.Context.class);
        validateCharacterMethod.setAccessible(true);
    }

    @Test
    void testValidateCharacter_StrictDecoding_ValidCharacter() throws Exception {
        Base32 base32 = new Base32();
        BaseNCodec.Context context = new BaseNCodec.Context();
        context.lbitWorkArea = 0;
        assertDoesNotThrow(() -> validateCharacterMethod.invoke(base32, 0L, context));
    }

    @Test
    void testValidateCharacter_StrictDecoding_InvalidCharacter() throws Exception {
        Base32 base32 = new Base32();
        BaseNCodec.Context context = new BaseNCodec.Context();
        context.lbitWorkArea = 1;
        IllegalArgumentException thrown = assertThrows(IllegalArgumentException.class, () -> {
            validateCharacterMethod.invoke(base32, 1L, context);
        });
        assertEquals("Strict decoding: Last encoded character (before the paddings if any) is a valid base 32 alphabet but not a possible encoding. Expected the discarded bits from the character to be zero.", thrown.getMessage());
    }

    @Test
    void testValidateCharacter_NonStrictDecoding_ValidCharacter() throws Exception {
        Base32 base32 = new Base32();
        BaseNCodec.Context context = new BaseNCodec.Context();
        context.lbitWorkArea = 0;
        assertDoesNotThrow(() -> validateCharacterMethod.invoke(base32, 0L, context));
    }

    @Test
    void testValidateCharacter_NonStrictDecoding_ValidCharacterWithNonZeroBits() throws Exception {
        Base32 base32 = new Base32();
        BaseNCodec.Context context = new BaseNCodec.Context();
        context.lbitWorkArea = 2;
        assertDoesNotThrow(() -> validateCharacterMethod.invoke(base32, 2L, context));
    }

    @Test
    void testValidateCharacter_NonStrictDecoding_InvalidCharacter() throws Exception {
        Base32 base32 = new Base32();
        BaseNCodec.Context context = new BaseNCodec.Context();
        context.lbitWorkArea = 3;
        // Should not throw in non-strict mode
        assertDoesNotThrow(() -> validateCharacterMethod.invoke(base32, 3L, context));
    }
}
