package org.apache.commons.codec.binary;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import java.util.Objects;
import org.apache.commons.codec.CodecPolicy;

public class Base32_validateCharacter_7_3_Test {

    private Base32 base32;

    private Context context;

    @BeforeEach
    public void setUp() {
        base32 = new Base32();
        context = new Context();
    }

    @Test
    public void testValidateCharacterWithStrictDecodingAndInvalidBits() throws Exception {
        // Arrange
        long emptyBitsMask = 0b0001;
        context.lbitWorkArea = 0b0001;
        // Act & Assert
        assertThrows(IllegalArgumentException.class, () -> invokeValidateCharacter(emptyBitsMask, context));
    }

    @Test
    public void testValidateCharacterWithStrictDecodingAndValidBits() throws Exception {
        // Arrange
        long emptyBitsMask = 0b0001;
        context.lbitWorkArea = 0b0000;
        // Act
        invokeValidateCharacter(emptyBitsMask, context);
        // Assert
        // No exception should be thrown
    }

    @Test
    public void testValidateCharacterWithNonStrictDecoding() throws Exception {
        // Arrange
        long emptyBitsMask = 0b0001;
        context.lbitWorkArea = 0b0001;
        setStrictDecoding(false);
        // Act
        invokeValidateCharacter(emptyBitsMask, context);
        // Assert
        // No exception should be thrown
    }

    private void invokeValidateCharacter(long emptyBitsMask, Context context) throws Exception {
        Method method = Base32.class.getDeclaredMethod("validateCharacter", long.class, Context.class);
        method.setAccessible(true);
        method.invoke(base32, emptyBitsMask, context);
    }

    private void setStrictDecoding(boolean value) throws Exception {
        Constructor<Base32> constructor = Base32.class.getDeclaredConstructor(boolean.class);
        constructor.setAccessible(true);
        base32 = constructor.newInstance(value);
    }

    private static class Context {

        long lbitWorkArea;
    }
}
