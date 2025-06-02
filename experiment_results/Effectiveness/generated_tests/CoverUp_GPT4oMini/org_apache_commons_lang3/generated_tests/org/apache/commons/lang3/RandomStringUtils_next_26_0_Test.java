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

class RandomStringUtils_next_26_0_Test {

    @Test
    void testNextWithOnlyLetters() throws Exception {
        RandomStringUtils instance = new RandomStringUtils();
        String result = invokeNext(instance, 10, 0, 0, true, false, null);
        assertNotNull(result);
        assertEquals(10, result.length());
        assertTrue(result.chars().allMatch(Character::isLetter));
    }

    @Test
    void testNextWithOnlyNumbers() throws Exception {
        RandomStringUtils instance = new RandomStringUtils();
        String result = invokeNext(instance, 10, 0, 0, false, true, null);
        assertNotNull(result);
        assertEquals(10, result.length());
        assertTrue(result.chars().allMatch(Character::isDigit));
    }

    @Test
    void testNextWithLettersAndNumbers() throws Exception {
        RandomStringUtils instance = new RandomStringUtils();
        String result = invokeNext(instance, 10, 0, 0, true, true, null);
        assertNotNull(result);
        assertEquals(10, result.length());
        assertTrue(result.chars().anyMatch(Character::isLetter));
        assertTrue(result.chars().anyMatch(Character::isDigit));
    }

    @Test
    void testNextWithCustomChars() throws Exception {
        RandomStringUtils instance = new RandomStringUtils();
        char[] customChars = { 'x', 'y', 'z' };
        String result = invokeNext(instance, 10, 0, 0, false, false, customChars);
        assertNotNull(result);
        assertEquals(10, result.length());
        assertTrue(result.chars().allMatch(c -> c == 'x' || c == 'y' || c == 'z'));
    }

    @Test
    void testNextWithCountZero() throws Exception {
        RandomStringUtils instance = new RandomStringUtils();
        String result = invokeNext(instance, 0, 0, 0, true, true, null);
        assertEquals("", result);
    }

    @Test
    void testNextWithNegativeCount() {
        RandomStringUtils instance = new RandomStringUtils();
        assertThrows(IllegalArgumentException.class, () -> invokeNext(instance, -1, 0, 0, true, true, null));
    }

    @Test
    void testNextWithEmptyChars() {
        RandomStringUtils instance = new RandomStringUtils();
        assertThrows(IllegalArgumentException.class, () -> invokeNext(instance, 10, 0, 0, false, false, new char[] {}));
    }

    @Test
    void testNextWithEndLessThanStart() {
        RandomStringUtils instance = new RandomStringUtils();
        assertThrows(IllegalArgumentException.class, () -> invokeNext(instance, 10, 5, 1, true, false, null));
    }

    private String invokeNext(RandomStringUtils instance, int count, int start, int end, boolean letters, boolean numbers, char... chars) throws Exception {
        Method method = RandomStringUtils.class.getDeclaredMethod("next", int.class, int.class, int.class, boolean.class, boolean.class, char[].class);
        method.setAccessible(true);
        return (String) method.invoke(instance, count, start, end, letters, numbers, chars);
    }
}
