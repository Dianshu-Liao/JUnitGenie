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

public class RandomStringUtils_next_23_0_Test {

    @Test
    public void testNext_WithLettersOnly() {
        RandomStringUtils randomStringUtils = new RandomStringUtils();
        String result = randomStringUtils.next(10, true, false);
        assertEquals(10, result.length());
        assertTrue(result.chars().allMatch(Character::isLetter));
    }

    @Test
    public void testNext_WithNumbersOnly() {
        RandomStringUtils randomStringUtils = new RandomStringUtils();
        String result = randomStringUtils.next(10, false, true);
        assertEquals(10, result.length());
        assertTrue(result.chars().allMatch(Character::isDigit));
    }

    @Test
    public void testNext_WithLettersAndNumbers() {
        RandomStringUtils randomStringUtils = new RandomStringUtils();
        String result = randomStringUtils.next(10, true, true);
        assertEquals(10, result.length());
        assertTrue(result.chars().anyMatch(Character::isLetter));
        assertTrue(result.chars().anyMatch(Character::isDigit));
    }

    @Test
    public void testNext_WithZeroCount() {
        RandomStringUtils randomStringUtils = new RandomStringUtils();
        String result = randomStringUtils.next(0, true, true);
        assertEquals(0, result.length());
    }

    @Test
    public void testNext_WithNegativeCount() {
        RandomStringUtils randomStringUtils = new RandomStringUtils();
        assertThrows(IllegalArgumentException.class, () -> {
            randomStringUtils.next(-1, true, true);
        });
    }

    @Test
    public void testNext_WithOnlyLettersAndZeroCount() {
        RandomStringUtils randomStringUtils = new RandomStringUtils();
        String result = randomStringUtils.next(0, true, false);
        assertEquals(0, result.length());
    }

    @Test
    public void testNext_WithOnlyNumbersAndZeroCount() {
        RandomStringUtils randomStringUtils = new RandomStringUtils();
        String result = randomStringUtils.next(0, false, true);
        assertEquals(0, result.length());
    }

    @Test
    public void testNext_WithBothFalse() {
        RandomStringUtils randomStringUtils = new RandomStringUtils();
        String result = randomStringUtils.next(10, false, false);
        assertEquals(10, result.length());
        assertTrue(result.chars().noneMatch(Character::isLetter));
        assertTrue(result.chars().noneMatch(Character::isDigit));
    }
}
