package org.apache.commons.lang3;

import org.apache.commons.lang3.RandomStringUtils;
import java.lang.reflect.Method;
import java.util.Random;
import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import java.security.SecureRandom;
import java.security.Security;
import java.util.concurrent.ThreadLocalRandom;
import java.util.function.Supplier;

class RandomStringUtils_next_24_0_Test {

    @Test
    void testNextWithNullChars() throws Exception {
        RandomStringUtils randomStringUtils = new RandomStringUtils();
        String result = invokeNext(randomStringUtils, 5, (char[]) null);
        assertNotNull(result);
        assertEquals(5, result.length());
    }

    @Test
    void testNextWithEmptyChars() throws Exception {
        RandomStringUtils randomStringUtils = new RandomStringUtils();
        assertThrows(IllegalArgumentException.class, () -> {
            invokeNext(randomStringUtils, 5, new char[] {});
        });
    }

    @Test
    void testNextWithValidChars() throws Exception {
        RandomStringUtils randomStringUtils = new RandomStringUtils();
        String result = invokeNext(randomStringUtils, 10, new char[] { 'a', 'b', 'c', '1', '2', '3' });
        assertNotNull(result);
        assertEquals(10, result.length());
        for (char c : result.toCharArray()) {
            assertTrue("abc123".indexOf(c) >= 0);
        }
    }

    @Test
    void testNextWithZeroCount() throws Exception {
        RandomStringUtils randomStringUtils = new RandomStringUtils();
        String result = invokeNext(randomStringUtils, 0, new char[] { 'a', 'b', 'c' });
        assertEquals("", result);
    }

    @Test
    void testNextWithNegativeCount() throws Exception {
        RandomStringUtils randomStringUtils = new RandomStringUtils();
        assertThrows(IllegalArgumentException.class, () -> {
            invokeNext(randomStringUtils, -1, new char[] { 'a', 'b', 'c' });
        });
    }

    private String invokeNext(RandomStringUtils randomStringUtils, int count, char... chars) throws Exception {
        Method method = RandomStringUtils.class.getDeclaredMethod("next", int.class, char[].class);
        method.setAccessible(true);
        return (String) method.invoke(randomStringUtils, count, chars);
    }
}
