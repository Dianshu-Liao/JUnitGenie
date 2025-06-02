package org.apache.commons.lang3;

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

    private RandomStringUtils randomStringUtils;

    @BeforeEach
    public void setUp() {
        randomStringUtils = new RandomStringUtils();
    }

    @Test
    public void testNextWithLettersAndNumbers() throws Exception {
        String result = invokeNextMethod(10, true, true);
        assertEquals(10, result.length());
        assertTrue(result.chars().allMatch(c -> (c >= 'a' && c <= 'z') || (c >= 'A' && c <= 'Z') || (c >= '0' && c <= '9')));
    }

    @Test
    public void testNextWithOnlyLetters() throws Exception {
        String result = invokeNextMethod(10, true, false);
        assertEquals(10, result.length());
        assertTrue(result.chars().allMatch(c -> (c >= 'a' && c <= 'z') || (c >= 'A' && c <= 'Z')));
    }

    @Test
    public void testNextWithOnlyNumbers() throws Exception {
        String result = invokeNextMethod(10, false, true);
        assertEquals(10, result.length());
        assertTrue(result.chars().allMatch(c -> (c >= '0' && c <= '9')));
    }

    @Test
    public void testNextWithNoLettersOrNumbers() throws Exception {
        String result = invokeNextMethod(10, false, false);
        assertEquals(0, result.length());
    }

    private String invokeNextMethod(int count, boolean letters, boolean numbers) throws Exception {
        Method nextMethod = RandomStringUtils.class.getDeclaredMethod("next", int.class, boolean.class, boolean.class);
        nextMethod.setAccessible(true);
        return (String) nextMethod.invoke(randomStringUtils, count, letters, numbers);
    }
}
