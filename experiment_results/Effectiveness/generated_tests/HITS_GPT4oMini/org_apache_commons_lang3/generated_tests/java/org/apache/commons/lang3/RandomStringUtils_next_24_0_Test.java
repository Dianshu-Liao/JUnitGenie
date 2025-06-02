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

public class RandomStringUtils_next_24_0_Test {

    private final RandomStringUtils randomStringUtils = new RandomStringUtils();

    @Test
    public void testNextWithNullCharsAndCountZero() {
        String result = randomStringUtils.next(0, (char[]) null);
        assertEquals("", result, "Expected empty string when count is zero");
    }

    @Test
    public void testNextWithNullCharsAndCountOne() {
        String result = randomStringUtils.next(1, (char[]) null);
        assertEquals(1, result.length(), "Expected string length to be 1 when count is one");
    }

    @Test
    public void testNextWithNullCharsAndCountGreaterThanOne() {
        int count = 5;
        String result = randomStringUtils.next(count, (char[]) null);
        assertEquals(count, result.length(), "Expected string length to match count when count is greater than one");
    }

    @Test
    public void testNextWithNullCharsAndNegativeCount() {
        IllegalArgumentException thrown = assertThrows(IllegalArgumentException.class, () -> {
            randomStringUtils.next(-1, (char[]) null);
        });
        assertEquals("Requested random string length -1 is less than 0.", thrown.getMessage());
    }
}
