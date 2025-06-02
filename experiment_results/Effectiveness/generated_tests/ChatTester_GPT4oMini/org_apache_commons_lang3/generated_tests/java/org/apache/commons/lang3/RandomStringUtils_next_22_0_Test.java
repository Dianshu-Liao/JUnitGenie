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

class RandomStringUtils_next_22_0_Test {

    private RandomStringUtils randomStringUtils;

    @BeforeEach
    void setUp() {
        // Using default constructor for testing
        randomStringUtils = new RandomStringUtils();
    }

    @Test
    void testNextWithPositiveCount() throws Exception {
        String result = invokeNextMethod(10);
        assertNotNull(result);
        assertEquals(10, result.length());
        assertTrue(result.chars().allMatch(c -> (c >= 'a' && c <= 'z') || (c >= 'A' && c <= 'Z') || (c >= '0' && c <= '9')));
    }

    @Test
    void testNextWithZeroCount() throws Exception {
        String result = invokeNextMethod(0);
        assertNotNull(result);
        assertEquals("", result);
    }

    @Test
    void testNextWithNegativeCount() throws Exception {
        assertThrows(IllegalArgumentException.class, () -> invokeNextMethod(-1));
    }

    private String invokeNextMethod(int count) throws Exception {
        Method method = RandomStringUtils.class.getDeclaredMethod("next", int.class);
        method.setAccessible(true);
        return (String) method.invoke(randomStringUtils, count);
    }
}
