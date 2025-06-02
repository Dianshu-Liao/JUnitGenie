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

public class Base32_validateCharacter_7_2_Test {

    private Base32 base32;

    private Context context;

    @BeforeEach
    public void setUp() {
        base32 = new Base32();
        context = new Context();
    }

    @Test
    public void testValidateCharacter_ValidCharacter() throws Exception {
        // Arrange
        long emptyBitsMask = 0L;
        context.lbitWorkArea = 0L;
        // Act
        invokeValidateCharacter(emptyBitsMask, context);
        // Assert
        // No exception should be thrown
    }

    @Test
    public void testValidateCharacter_InvalidCharacter() throws Exception {
        // Arrange
        long emptyBitsMask = 0b0001;
        context.lbitWorkArea = 0b0001;
        // Act & Assert
        IllegalArgumentException thrown = assertThrows(IllegalArgumentException.class, () -> {
            invokeValidateCharacter(emptyBitsMask, context);
        });
        assertEquals("Strict decoding: Last encoded character (before the paddings if any) is a valid base 32 alphabet but not a possible encoding. Expected the discarded bits from the character to be zero.", thrown.getMessage());
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
