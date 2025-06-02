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

public class RandomStringUtils_next_23_0_Test {

    @Test
    public void testNextWithValidParameters() throws Exception {
        RandomStringUtils randomStringUtils = new RandomStringUtils();
        String result = invokeNext(randomStringUtils, 10, true, true);
        assertEquals(10, result.length());
        // Additional assertions can be added to check for letters and numbers in the result.
    }

    @Test
    public void testNextWithOnlyLetters() throws Exception {
        RandomStringUtils randomStringUtils = new RandomStringUtils();
        String result = invokeNext(randomStringUtils, 10, true, false);
        assertEquals(10, result.length());
        // Check if the result contains only letters
        assertEquals(result.replaceAll("[a-zA-Z]", ""), "");
    }

    @Test
    public void testNextWithOnlyNumbers() throws Exception {
        RandomStringUtils randomStringUtils = new RandomStringUtils();
        String result = invokeNext(randomStringUtils, 10, false, true);
        assertEquals(10, result.length());
        // Check if the result contains only numbers
        assertEquals(result.replaceAll("[0-9]", ""), "");
    }

    @Test
    public void testNextWithZeroCount() throws Exception {
        RandomStringUtils randomStringUtils = new RandomStringUtils();
        String result = invokeNext(randomStringUtils, 0, true, true);
        assertEquals("", result);
    }

    @Test
    public void testNextWithNegativeCount() throws Exception {
        RandomStringUtils randomStringUtils = new RandomStringUtils();
        assertThrows(IllegalArgumentException.class, () -> {
            invokeNext(randomStringUtils, -1, true, true);
        });
    }

    private String invokeNext(RandomStringUtils randomStringUtils, int count, boolean letters, boolean numbers) throws Exception {
        Method method = RandomStringUtils.class.getDeclaredMethod("next", int.class, boolean.class, boolean.class);
        method.setAccessible(true);
        return (String) method.invoke(randomStringUtils, count, letters, numbers);
    }
}
