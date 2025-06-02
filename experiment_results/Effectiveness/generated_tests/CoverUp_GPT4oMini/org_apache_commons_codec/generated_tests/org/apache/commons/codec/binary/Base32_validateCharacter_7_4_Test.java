package org.apache.commons.codec.binary;

import org.apache.commons.codec.CodecPolicy;
import java.lang.reflect.Method;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import java.util.Objects;

@ExtendWith(MockitoExtension.class)
class Base32_validateCharacter_7_4_Test {

    private Base32 base32;

    private Context context;

    @BeforeEach
    void setUp() {
        base32 = new Base32();
        context = new Context();
    }

    @Test
    void testValidateCharacter_throwsIllegalArgumentException_whenStrictDecodingAndBitsAreNotZero() throws Exception {
        // Arrange
        long emptyBitsMask = 0x1;
        context.lbitWorkArea = 1;
        // Act & Assert
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> {
            invokeValidateCharacter(emptyBitsMask, context);
        });
        assertEquals("Strict decoding: Last encoded character (before the paddings if any) is a valid base 32 alphabet but not a possible encoding. Expected the discarded bits from the character to be zero.", exception.getMessage());
    }

    @Test
    void testValidateCharacter_doesNotThrow_whenStrictDecodingAndBitsAreZero() throws Exception {
        // Arrange
        long emptyBitsMask = 0x1;
        context.lbitWorkArea = 0;
        // Act
        invokeValidateCharacter(emptyBitsMask, context);
        // Assert: No exception thrown
    }

    private void invokeValidateCharacter(long emptyBitsMask, Context context) throws Exception {
        Method method = Base32.class.getDeclaredMethod("validateCharacter", long.class, Context.class);
        method.setAccessible(true);
        method.invoke(base32, emptyBitsMask, context);
    }

    private static class Context {

        long lbitWorkArea;
    }
}
