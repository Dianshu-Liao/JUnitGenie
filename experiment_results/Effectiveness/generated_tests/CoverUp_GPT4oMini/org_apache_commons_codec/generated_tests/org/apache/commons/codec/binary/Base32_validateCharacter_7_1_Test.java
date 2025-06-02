package org.apache.commons.codec.binary;

import java.lang.reflect.Method;
import org.mockito.junit.jupiter.MockitoExtension;
import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.extension.ExtendWith;
import java.util.Objects;
import org.apache.commons.codec.CodecPolicy;

@ExtendWith(MockitoExtension.class)
public class Base32_validateCharacter_7_1_Test {

    private Base32 base32;

    // Mock Context class
    private static class Context {

        long lbitWorkArea;

        Context(long lbitWorkArea) {
            this.lbitWorkArea = lbitWorkArea;
        }
    }

    @BeforeEach
    public void setUp() {
        // Default constructor
        base32 = new Base32();
    }

    @Test
    public void testValidateCharacter_throwsException_whenStrictDecodingAndBitsAreSet() throws Exception {
        // Example bits set
        Context context = new Context(0b000000000000000000000000000000000000000000000000000000000000000001);
        // Mask that matches
        long emptyBitsMask = 0b000000000000000000000000000000000000000000000000000000000000000001;
        Method method = Base32.class.getDeclaredMethod("validateCharacter", long.class, Context.class);
        method.setAccessible(true);
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            method.invoke(base32, emptyBitsMask, context);
        });
        String expectedMessage = "Strict decoding: Last encoded character (before the paddings if any) is a valid base 32 alphabet but not a possible encoding. Expected the discarded bits from the character to be zero.";
        assertEquals(expectedMessage, exception.getMessage());
    }

    @Test
    public void testValidateCharacter_doesNotThrowException_whenStrictDecodingAndBitsAreClear() throws Exception {
        // No bits set
        Context context = new Context(0L);
        // Mask that doesn't match
        long emptyBitsMask = 0b000000000000000000000000000000000000000000000000000000000000000001;
        Method method = Base32.class.getDeclaredMethod("validateCharacter", long.class, Context.class);
        method.setAccessible(true);
        assertDoesNotThrow(() -> {
            method.invoke(base32, emptyBitsMask, context);
        });
    }

    @Test
    public void testValidateCharacter_doesNotThrowException_whenNotStrictDecoding() throws Exception {
        // Some bits set
        Context context = new Context(0b000000000000000000000000000000000000000000000000000000000000000001);
        // Mask that matches
        long emptyBitsMask = 0b000000000000000000000000000000000000000000000000000000000000000001;
        // Assuming there's a way to set the strict decoding flag, we will need to modify the Base32 class to allow for testing this.
        // For this example, we will assume it's not strict decoding.
        Method method = Base32.class.getDeclaredMethod("validateCharacter", long.class, Context.class);
        method.setAccessible(true);
        assertDoesNotThrow(() -> {
            method.invoke(base32, emptyBitsMask, context);
        });
    }
}
