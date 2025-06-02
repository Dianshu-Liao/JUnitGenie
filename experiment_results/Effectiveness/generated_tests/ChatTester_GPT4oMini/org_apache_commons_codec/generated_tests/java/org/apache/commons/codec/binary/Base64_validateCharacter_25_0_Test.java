package org.apache.commons.codec.binary;

import org.junit.jupiter.api.function.Executable;
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

public class Base64_validateCharacter_25_0_Test {

    private Base64 base64;

    @Test
    public void testValidateCharacter_throwsIllegalArgumentException_whenStrictDecodingAndInvalidBits() throws Exception {
        // Arrange
        // Initialize Base64 instance
        base64 = new Base64();
        Context context = new Context();
        // Set to a value that triggers the exception
        context.ibitWorkArea = 1;
        // Use a mask that will lead to the exception being thrown
        int emptyBitsMask = 0;
        // Use reflection to access the private method
        Method validateCharacterMethod = Base64.class.getDeclaredMethod("validateCharacter", int.class, Context.class);
        validateCharacterMethod.setAccessible(true);
        // Act & Assert
        assertThrows(IllegalArgumentException.class, () -> {
            validateCharacterMethod.invoke(base64, emptyBitsMask, context);
        });
    }

    @Test
    public void testValidateCharacter_doesNotThrow_whenStrictDecodingAndValidBits() throws Exception {
        // Arrange
        // Initialize Base64 instance
        base64 = new Base64();
        Context context = new Context();
        // Set to a value that does not trigger the exception
        context.ibitWorkArea = 0;
        // Use a mask that will not lead to the exception
        int emptyBitsMask = 1;
        // Use reflection to access the private method
        Method validateCharacterMethod = Base64.class.getDeclaredMethod("validateCharacter", int.class, Context.class);
        validateCharacterMethod.setAccessible(true);
        // Act & Assert
        // Should not throw
        validateCharacterMethod.invoke(base64, emptyBitsMask, context);
    }

    // Context class as a placeholder for the actual implementation
    private static class Context {

        int ibitWorkArea;
    }
}
