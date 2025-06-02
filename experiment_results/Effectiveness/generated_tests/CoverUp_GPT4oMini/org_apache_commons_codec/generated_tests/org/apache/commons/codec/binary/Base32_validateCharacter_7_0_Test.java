package org.apache.commons.codec.binary;

import org.apache.commons.codec.CodecPolicy;
import java.lang.reflect.Method;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import java.util.Objects;
import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

class Base32_validateCharacter_7_0_Test {

    private Base32 base32;

    @BeforeEach
    void setUp() {
        base32 = new Base32();
    }

    @Test
    void testValidateCharacter_throwsIllegalArgumentException_whenStrictDecodingAndInvalidBits() throws Exception {
        long emptyBitsMask = 0x1L;
        Context context = new Context();
        context.lbitWorkArea = 0x1L;
        Method method = Base32.class.getDeclaredMethod("validateCharacter", long.class, Context.class);
        method.setAccessible(true);
        assertThrows(IllegalArgumentException.class, () -> {
            method.invoke(base32, emptyBitsMask, context);
        });
    }

    @Test
    void testValidateCharacter_doesNotThrow_whenStrictDecodingAndValidBits() throws Exception {
        long emptyBitsMask = 0x1L;
        Context context = new Context();
        context.lbitWorkArea = 0x0L;
        Method method = Base32.class.getDeclaredMethod("validateCharacter", long.class, Context.class);
        method.setAccessible(true);
        // Should not throw an exception
        method.invoke(base32, emptyBitsMask, context);
    }

    // Dummy Context class to mimic the original Context used in the Base32 class
    static class Context {

        long lbitWorkArea;
    }
}
