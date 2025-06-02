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

public class RandomStringUtils_next_22_0_Test {

    @Test
    public void testNextWithPositiveCount() throws Exception {
        RandomStringUtils randomStringUtils = new RandomStringUtils();
        Method nextMethod = RandomStringUtils.class.getDeclaredMethod("next", int.class);
        nextMethod.setAccessible(true);
        String result = (String) nextMethod.invoke(randomStringUtils, 10);
        assertNotNull(result);
        assertTrue(result.length() == 10);
    }

    @Test
    public void testNextWithZeroCount() throws Exception {
        RandomStringUtils randomStringUtils = new RandomStringUtils();
        Method nextMethod = RandomStringUtils.class.getDeclaredMethod("next", int.class);
        nextMethod.setAccessible(true);
        String result = (String) nextMethod.invoke(randomStringUtils, 0);
        assertNotNull(result);
        assertTrue(result.isEmpty());
    }

    @Test
    public void testNextWithNegativeCount() throws Exception {
        RandomStringUtils randomStringUtils = new RandomStringUtils();
        Method nextMethod = RandomStringUtils.class.getDeclaredMethod("next", int.class);
        nextMethod.setAccessible(true);
        String result = (String) nextMethod.invoke(randomStringUtils, -5);
        assertNotNull(result);
        assertTrue(result.isEmpty());
    }
}
