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

public class RandomStringUtils_next_25_0_Test {

    private final RandomStringUtils randomStringUtils = new RandomStringUtils();

    @Test
    public void testNextWithLettersAndNumbers() {
        String result = randomStringUtils.next(10, 0, 0, true, true);
        assertEquals(10, result.length());
        assertTrue(result.chars().anyMatch(Character::isLetter));
        assertTrue(result.chars().anyMatch(Character::isDigit));
    }

    @Test
    public void testNextWithOnlyLetters() {
        String result = randomStringUtils.next(10, 0, 0, true, false);
        assertEquals(10, result.length());
        assertTrue(result.chars().allMatch(Character::isLetter));
    }

    @Test
    public void testNextWithOnlyNumbers() {
        String result = randomStringUtils.next(10, 0, 0, false, true);
        assertEquals(10, result.length());
        assertTrue(result.chars().allMatch(Character::isDigit));
    }

    @Test
    public void testNextWithEmptyString() {
        String result = randomStringUtils.next(0, 0, 0, true, true);
        assertEquals("", result);
    }

    @Test
    public void testNextWithNegativeCount() {
        IllegalArgumentException thrown = assertThrows(IllegalArgumentException.class, () -> {
            randomStringUtils.next(-1, 0, 0, true, true);
        });
        assertEquals("Requested random string length -1 is less than 0.", thrown.getMessage());
    }

    @Test
    public void testNextWithInvalidRange() {
        IllegalArgumentException thrown = assertThrows(IllegalArgumentException.class, () -> {
            randomStringUtils.next(10, 5, 5, true, true);
        });
        assertEquals("Parameter end (5) must be greater than start (5)", thrown.getMessage());
    }

    @Test
    public void testNextWithCustomCharacterSet() {
        char[] customChars = { 'a', 'b', 'c', '1', '2', '3' };
        String result = randomStringUtils.next(10, 0, 0, false, false, customChars);
        assertEquals(10, result.length());
        assertTrue(result.chars().allMatch(c -> new String(customChars).indexOf(c) != -1));
    }

    @Test
    public void testNextWithInvalidCharactersArray() {
        IllegalArgumentException thrown = assertThrows(IllegalArgumentException.class, () -> {
            randomStringUtils.next(10, 0, 0, false, false, new char[0]);
        });
        assertEquals("The chars array must not be empty", thrown.getMessage());
    }

    @Test
    public void testNextWithBounds() {
        // ASCII A-Z
        String result = randomStringUtils.next(10, 65, 91, true, false);
        assertEquals(10, result.length());
        assertTrue(result.chars().allMatch(c -> c >= 65 && c < 91));
    }
}
