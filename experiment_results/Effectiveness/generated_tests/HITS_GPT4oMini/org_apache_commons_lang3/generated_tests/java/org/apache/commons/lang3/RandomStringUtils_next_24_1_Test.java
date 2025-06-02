package org.apache.commons.lang3;

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

public class RandomStringUtils_next_24_1_Test {

    @Test
    public void testNextWithValidCountAndChars() {
        RandomStringUtils randomStringUtils = new RandomStringUtils();
        String result = randomStringUtils.next(10, 'a', 'b', 'c', 'd', 'e');
        assertEquals(10, result.length());
        for (char c : result.toCharArray()) {
            assertTrue(c >= 'a' && c <= 'e', "Character " + c + " is not in the expected range.");
        }
    }

    @Test
    public void testNextWithZeroCount() {
        RandomStringUtils randomStringUtils = new RandomStringUtils();
        String result = randomStringUtils.next(0, 'a', 'b', 'c');
        assertEquals("", result);
    }

    @Test
    public void testNextWithNullChars() {
        RandomStringUtils randomStringUtils = new RandomStringUtils();
        String result = randomStringUtils.next(10, (char[]) null);
        assertEquals(10, result.length());
    }

    @Test
    public void testNextWithNegativeCount() {
        RandomStringUtils randomStringUtils = new RandomStringUtils();
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            randomStringUtils.next(-1, 'a', 'b', 'c');
        });
        assertEquals("Requested random string length -1 is less than 0.", exception.getMessage());
    }

    @Test
    public void testNextWithEmptyCharsArray() {
        RandomStringUtils randomStringUtils = new RandomStringUtils();
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            randomStringUtils.next(10, new char[] {});
        });
        assertEquals("The chars array must not be empty", exception.getMessage());
    }

    @Test
    public void testNextWithCountGreaterThanZeroAndChars() {
        RandomStringUtils randomStringUtils = new RandomStringUtils();
        String result = randomStringUtils.next(5, '1', '2', '3', '4', '5');
        assertEquals(5, result.length());
        for (char c : result.toCharArray()) {
            assertTrue(c >= '1' && c <= '5', "Character " + c + " is not in the expected range.");
        }
    }

    @Test
    public void testNextWithAllLetters() {
        RandomStringUtils randomStringUtils = new RandomStringUtils();
        String result = randomStringUtils.next(15, 'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p');
        assertEquals(15, result.length());
        for (char c : result.toCharArray()) {
            assertTrue(c >= 'a' && c <= 'p', "Character " + c + " is not in the expected range.");
        }
    }

    @Test
    public void testNextWithLargeCount() {
        RandomStringUtils randomStringUtils = new RandomStringUtils();
        String result = randomStringUtils.next(1000, 'x', 'y', 'z');
        assertEquals(1000, result.length());
    }
}
