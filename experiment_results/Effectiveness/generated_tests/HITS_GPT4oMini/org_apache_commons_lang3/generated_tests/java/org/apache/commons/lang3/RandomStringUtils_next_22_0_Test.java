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

public class RandomStringUtils_next_22_0_Test {

    @Test
    public void testNextWithCountZero() {
        RandomStringUtils randomStringUtils = new RandomStringUtils();
        String result = randomStringUtils.next(0);
        assertEquals("", result, "Expected empty string for count 0");
    }

    @Test
    public void testNextWithPositiveCount() {
        RandomStringUtils randomStringUtils = new RandomStringUtils();
        String result = randomStringUtils.next(10);
        assertEquals(10, result.length(), "Expected string length to be 10");
    }

    @Test
    public void testNextWithLargeCount() {
        RandomStringUtils randomStringUtils = new RandomStringUtils();
        String result = randomStringUtils.next(1000);
        assertEquals(1000, result.length(), "Expected string length to be 1000");
    }

    @Test
    public void testNextWithCountOne() {
        RandomStringUtils randomStringUtils = new RandomStringUtils();
        String result = randomStringUtils.next(1);
        assertEquals(1, result.length(), "Expected string length to be 1");
    }

    @Test
    public void testNextWithNegativeCount() {
        RandomStringUtils randomStringUtils = new RandomStringUtils();
        assertThrows(IllegalArgumentException.class, () -> {
            randomStringUtils.next(-1);
        }, "Expected IllegalArgumentException for negative count");
    }

    @Test
    public void testNextWithCountAndAssertions() {
        RandomStringUtils randomStringUtils = new RandomStringUtils();
        String result = randomStringUtils.next(10);
        assertNotNull(result, "Result should not be null");
        assertFalse(result.isEmpty(), "Result should not be empty");
        assertTrue(result.length() == 10, "Result length should be 10");
    }
}
