package org.apache.commons.lang3;

import org.apache.commons.lang3.RandomStringUtils;
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

class RandomStringUtils_next_27_0_Test {

    @Test
    void testNextWithNullChars() throws Exception {
        RandomStringUtils randomStringUtils = new RandomStringUtils();
        String result = invokeNext(randomStringUtils, 5, null);
        assertNotNull(result);
        assertEquals(5, result.length());
    }

    @Test
    void testNextWithEmptyChars() throws Exception {
        RandomStringUtils randomStringUtils = new RandomStringUtils();
        String result = invokeNext(randomStringUtils, 5, "");
        assertNotNull(result);
        assertEquals(5, result.length());
    }

    @Test
    void testNextWithValidChars() throws Exception {
        RandomStringUtils randomStringUtils = new RandomStringUtils();
        String chars = "abc";
        String result = invokeNext(randomStringUtils, 5, chars);
        assertNotNull(result);
        assertEquals(5, result.length());
        for (char c : result.toCharArray()) {
            assertTrue(chars.indexOf(c) >= 0);
        }
    }

    @Test
    void testNextWithCountZero() throws Exception {
        RandomStringUtils randomStringUtils = new RandomStringUtils();
        String result = invokeNext(randomStringUtils, 0, "abc");
        assertNotNull(result);
        assertEquals("", result);
    }

    @Test
    void testNextWithNegativeCount() throws Exception {
        RandomStringUtils randomStringUtils = new RandomStringUtils();
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            invokeNext(randomStringUtils, -1, "abc");
        });
        assertEquals("Requested random string length -1 is less than 0.", exception.getMessage());
    }

    private String invokeNext(RandomStringUtils instance, int count, String chars) throws Exception {
        Method method = RandomStringUtils.class.getDeclaredMethod("next", int.class, String.class);
        method.setAccessible(true);
        return (String) method.invoke(instance, count, chars);
    }
}
