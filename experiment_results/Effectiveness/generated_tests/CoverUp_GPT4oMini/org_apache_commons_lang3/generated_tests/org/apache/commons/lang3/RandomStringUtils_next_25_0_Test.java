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

class RandomStringUtils_next_25_0_Test {

    private RandomStringUtils randomStringUtils;

    @BeforeEach
    void setUp() {
        randomStringUtils = new RandomStringUtils();
    }

    @Test
    void testNextWithLettersAndNumbers() throws Exception {
        String result = invokeNextMethod(10, 0, 0, true, true);
        assertNotNull(result);
        assertEquals(10, result.length());
        assertTrue(result.chars().allMatch(c -> (Character.isLetter(c) || Character.isDigit(c))));
    }

    @Test
    void testNextWithOnlyLetters() throws Exception {
        String result = invokeNextMethod(10, 0, 0, true, false);
        assertNotNull(result);
        assertEquals(10, result.length());
        assertTrue(result.chars().allMatch(Character::isLetter));
    }

    @Test
    void testNextWithOnlyNumbers() throws Exception {
        String result = invokeNextMethod(10, 0, 0, false, true);
        assertNotNull(result);
        assertEquals(10, result.length());
        assertTrue(result.chars().allMatch(Character::isDigit));
    }

    @Test
    void testNextWithZeroCount() throws Exception {
        String result = invokeNextMethod(0, 0, 0, true, true);
        assertEquals("", result);
    }

    @Test
    void testNextWithNegativeCount() {
        assertThrows(IllegalArgumentException.class, () -> invokeNextMethod(-1, 0, 0, true, true));
    }

    @Test
    void testNextWithInvalidRanges() {
        assertThrows(IllegalArgumentException.class, () -> invokeNextMethod(10, 5, 5, true, true));
        assertThrows(IllegalArgumentException.class, () -> invokeNextMethod(10, -1, 5, true, true));
        assertThrows(IllegalArgumentException.class, () -> invokeNextMethod(10, 5, -1, true, true));
    }

    private String invokeNextMethod(int count, int start, int end, boolean letters, boolean numbers) throws Exception {
        Method nextMethod = RandomStringUtils.class.getDeclaredMethod("next", int.class, int.class, int.class, boolean.class, boolean.class);
        nextMethod.setAccessible(true);
        return (String) nextMethod.invoke(randomStringUtils, count, start, end, letters, numbers);
    }
}
