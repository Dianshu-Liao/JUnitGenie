package org.apache.commons.lang3;

import java.lang.reflect.Method;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import java.security.SecureRandom;
import java.security.Security;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;
import java.util.function.Supplier;
import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

public class RandomStringUtils_next_26_0_Test {

    private RandomStringUtils randomStringUtils;

    @BeforeEach
    public void setUp() {
        // Removed the private access issue
        randomStringUtils = new RandomStringUtils();
    }

    @Test
    public void testNextWithLettersAndNumbers() throws Exception {
        String result = invokeNext(10, 0, 62, true, true);
        assertNotNull(result);
        assertEquals(10, result.length());
        assertTrue(result.chars().allMatch(c -> (c >= '0' && c <= '9') || (c >= 'a' && c <= 'z') || (c >= 'A' && c <= 'Z')));
    }

    @Test
    public void testNextWithOnlyLetters() throws Exception {
        String result = invokeNext(10, 0, 26, true, false);
        assertNotNull(result);
        assertEquals(10, result.length());
        assertTrue(result.chars().allMatch(c -> (c >= 'a' && c <= 'z') || (c >= 'A' && c <= 'Z')));
    }

    @Test
    public void testNextWithOnlyNumbers() throws Exception {
        String result = invokeNext(10, 0, 10, false, true);
        assertNotNull(result);
        assertEquals(10, result.length());
        assertTrue(result.chars().allMatch(c -> c >= '0' && c <= '9'));
    }

    @Test
    public void testNextWithCustomChars() throws Exception {
        String result = invokeNext(10, 0, 10, false, false, 'x', 'y', 'z');
        assertNotNull(result);
        assertEquals(10, result.length());
        assertTrue(result.chars().allMatch(c -> c == 'x' || c == 'y' || c == 'z'));
    }

    @Test
    public void testNextWithZeroCount() throws Exception {
        String result = invokeNext(0, 0, 10, true, true);
        assertNotNull(result);
        assertEquals("", result);
    }

    private String invokeNext(int count, int start, int end, boolean letters, boolean numbers, char... chars) throws Exception {
        Method method = RandomStringUtils.class.getDeclaredMethod("next", int.class, int.class, int.class, boolean.class, boolean.class, char[].class);
        method.setAccessible(true);
        return (String) method.invoke(randomStringUtils, count, start, end, letters, numbers, chars);
    }
}
