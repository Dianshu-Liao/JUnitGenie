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

public class RandomStringUtils_next_27_0_Test {

    // Using the default constructor
    private final RandomStringUtils randomStringUtils = new RandomStringUtils();

    @Test
    public void testNext_WithValidCountAndChars_ReturnsStringOfCorrectLength() {
        String result = randomStringUtils.next(10, "abc".toCharArray());
        assertEquals(10, result.length());
        for (char c : result.toCharArray()) {
            assertTrue("abc".indexOf(c) != -1, "Result contains invalid character: " + c);
        }
    }

    @Test
    public void testNext_WithCountZero_ReturnsEmptyString() {
        String result = randomStringUtils.next(0, "abc".toCharArray());
        assertEquals("", result);
    }

    @Test
    public void testNext_WithCountNegative_ThrowsIllegalArgumentException() {
        assertThrows(IllegalArgumentException.class, () -> {
            randomStringUtils.next(-1, "abc".toCharArray());
        });
    }

    @Test
    public void testNext_WithNullChars_ReturnsStringOfValidLength() {
        String result = randomStringUtils.next(10, (char[]) null);
        assertEquals(10, result.length());
    }

    @Test
    public void testNext_WithEmptyCharsArray_ThrowsIllegalArgumentException() {
        assertThrows(IllegalArgumentException.class, () -> {
            randomStringUtils.next(10, new char[0]);
        });
    }

    @Test
    public void testNext_WithCountAndValidChars_ReturnsOnlySpecifiedChars() {
        String result = randomStringUtils.next(100, "xyz".toCharArray());
        assertEquals(100, result.length());
        for (char c : result.toCharArray()) {
            assertTrue("xyz".indexOf(c) != -1, "Result contains invalid character: " + c);
        }
    }

    @Test
    public void testNext_WithCountAndMixedChars_ReturnsOnlySpecifiedChars() {
        String result = randomStringUtils.next(50, "abcXYZ123".toCharArray());
        assertEquals(50, result.length());
        for (char c : result.toCharArray()) {
            assertTrue("abcXYZ123".indexOf(c) != -1, "Result contains invalid character: " + c);
        }
    }

    @Test
    public void testNext_WithCountAndSpecialChars_ReturnsOnlySpecifiedChars() {
        String result = randomStringUtils.next(30, "!@#$%^&*()".toCharArray());
        assertEquals(30, result.length());
        for (char c : result.toCharArray()) {
            assertTrue("!@#$%^&*()".indexOf(c) != -1, "Result contains invalid character: " + c);
        }
    }

    @Test
    public void testNext_WithCountAndEmptyChars_ReturnsStringOfValidLength() {
        String result = randomStringUtils.next(10, new char[0]);
        assertEquals(0, result.length());
    }
}
