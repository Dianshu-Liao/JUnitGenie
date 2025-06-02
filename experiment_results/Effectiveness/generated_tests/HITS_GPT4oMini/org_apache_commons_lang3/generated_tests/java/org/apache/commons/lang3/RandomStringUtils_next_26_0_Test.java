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

public class RandomStringUtils_next_26_0_Test {

    private final RandomStringUtils randomStringUtils = new RandomStringUtils();

    @Test
    public void testNextWithZeroCount() {
        String result = randomStringUtils.next(0, 0, 0, true, true);
        assertEquals("", result, "Expected an empty string when count is zero");
    }

    @Test
    public void testNextWithNegativeCount() {
        IllegalArgumentException thrown = assertThrows(IllegalArgumentException.class, () -> {
            randomStringUtils.next(-1, 0, 0, true, true);
        });
        assertEquals("Requested random string length -1 is less than 0.", thrown.getMessage());
    }

    @Test
    public void testNextWithEmptyCharsArray() {
        IllegalArgumentException thrown = assertThrows(IllegalArgumentException.class, () -> {
            randomStringUtils.next(5, 0, 0, true, true, new char[] {});
        });
        assertEquals("The chars array must not be empty", thrown.getMessage());
    }

    @Test
    public void testNextWithEndLessThanStart() {
        IllegalArgumentException thrown = assertThrows(IllegalArgumentException.class, () -> {
            randomStringUtils.next(5, 10, 5, true, true);
        });
        assertEquals("Parameter end (5) must be greater than start (10)", thrown.getMessage());
    }

    @Test
    public void testNextWithValidParameters() {
        String result = randomStringUtils.next(10, 0, 0, true, true);
        assertNotNull(result, "Result should not be null");
        assertEquals(10, result.length(), "Result length should match the requested count");
    }

    @Test
    public void testNextWithOnlyLetters() {
        String result = randomStringUtils.next(10, 'A', 'z', true, false);
        assertNotNull(result);
        assertTrue(result.chars().allMatch(Character::isLetter), "Result should contain only letters");
    }

    @Test
    public void testNextWithOnlyNumbers() {
        String result = randomStringUtils.next(10, '0', '9', false, true);
        assertNotNull(result);
        assertTrue(result.chars().allMatch(Character::isDigit), "Result should contain only numbers");
    }

    @Test
    public void testNextWithCustomChars() {
        char[] customChars = { 'a', 'b', 'c', '1', '2', '3' };
        String result = randomStringUtils.next(10, 0, 0, false, false, customChars);
        assertNotNull(result);
        assertEquals(10, result.length(), "Result length should match the requested count");
        assertTrue(result.chars().allMatch(c -> new String(customChars).indexOf(c) != -1), "Result should only contain characters from the custom array");
    }

    @Test
    public void testNextWithAllParameters() {
        String result = randomStringUtils.next(10, 0, 100, true, true, 'a', 'b', 'c', '1', '2', '3');
        assertNotNull(result);
        assertEquals(10, result.length(), "Result length should match the requested count");
    }

    @Test
    public void testNextWithNonAlphanumericRange() {
        String result = randomStringUtils.next(5, 100, 200, false, false);
        assertNotNull(result);
        assertEquals(5, result.length(), "Result length should match the requested count");
        // Additional checks can be added based on expected character range behavior
    }
}
