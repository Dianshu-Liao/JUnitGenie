package org.apache.commons.lang3;

import java.lang.reflect.Method;
import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import java.security.SecureRandom;
import java.security.Security;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;
import java.util.function.Supplier;

public class RandomStringUtils_next_27_0_Test {

    private RandomStringUtils randomStringUtils;

    @BeforeEach
    public void setUp() {
        randomStringUtils = new RandomStringUtils();
    }

    @Test
    public void testNextWithNullChars() throws Exception {
        String result = invokeNextMethod(5, null);
        assertNotNull(result);
        assertEquals(5, result.length());
    }

    @Test
    public void testNextWithEmptyChars() throws Exception {
        String result = invokeNextMethod(5, "");
        assertNotNull(result);
        assertEquals(5, result.length());
    }

    @Test
    public void testNextWithValidChars() throws Exception {
        String chars = "abc";
        String result = invokeNextMethod(10, chars);
        assertNotNull(result);
        assertEquals(10, result.length());
        for (char c : result.toCharArray()) {
            assertTrue(chars.indexOf(c) >= 0);
        }
    }

    @Test
    public void testNextWithZeroCount() throws Exception {
        String result = invokeNextMethod(0, "abc");
        assertNotNull(result);
        assertEquals(0, result.length());
    }

    @Test
    public void testNextWithNegativeCount() throws Exception {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            invokeNextMethod(-5, "abc");
        });
        assertEquals("Count must be non-negative", exception.getMessage());
    }

    private String invokeNextMethod(int count, String chars) throws Exception {
        Method nextMethod = RandomStringUtils.class.getDeclaredMethod("next", int.class, String.class);
        nextMethod.setAccessible(true);
        return (String) nextMethod.invoke(randomStringUtils, count, chars);
    }
}
