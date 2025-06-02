package org.apache.commons.compress.archivers.sevenz;

import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.spec.IvParameterSpec;
import java.lang.reflect.Constructor;
import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import java.security.GeneralSecurityException;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import javax.crypto.spec.SecretKeySpec;

class AES256Options_AES256Options_7_0_Test {

    private static final char[] PASSWORD = "password".toCharArray();

    private static final byte[] SALT = new byte[] { 1, 2, 3, 4, 5, 6, 7, 8 };

    private static final byte[] IV = new byte[] { 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15 };

    private static final int NUM_CYCLES_POWER = 10;

    private AES256Options aes256Options;

    @BeforeEach
    void setUp() {
        aes256Options = createAES256Options(PASSWORD, SALT, IV, NUM_CYCLES_POWER);
    }

    private AES256Options createAES256Options(char[] password, byte[] salt, byte[] iv, int numCyclesPower) {
        try {
            Constructor<AES256Options> constructor = AES256Options.class.getDeclaredConstructor(char[].class, byte[].class, byte[].class, int.class);
            constructor.setAccessible(true);
            return constructor.newInstance(password, salt, iv, numCyclesPower);
        } catch (Exception e) {
            fail("Failed to create AES256Options instance", e);
            return null;
        }
    }

    @Test
    void testConstructorWithValidParameters() {
        assertNotNull(aes256Options);
        assertArrayEquals(SALT, aes256Options.getSalt());
        assertArrayEquals(IV, aes256Options.getIv());
        assertEquals(NUM_CYCLES_POWER, aes256Options.getNumCyclesPower());
        assertNotNull(aes256Options.getCipher());
    }

    @Test
    void testConstructorHandlesEncryptionError() {
        // Invalid IV
        byte[] invalidIv = new byte[0];
        Exception exception = assertThrows(IllegalStateException.class, () -> {
            createAES256Options(PASSWORD, SALT, invalidIv, NUM_CYCLES_POWER);
        });
        String expectedMessage = "Encryption error (do you have the JCE Unlimited Strength Jurisdiction Policy Files installed?)";
        assertTrue(exception.getMessage().contains(expectedMessage));
    }

    @Test
    void testConstructorWithNullPassword() {
        Exception exception = assertThrows(NullPointerException.class, () -> {
            createAES256Options(null, SALT, IV, NUM_CYCLES_POWER);
        });
        assertEquals("password cannot be null", exception.getMessage());
    }

    @Test
    void testConstructorWithNullSalt() {
        Exception exception = assertThrows(NullPointerException.class, () -> {
            createAES256Options(PASSWORD, null, IV, NUM_CYCLES_POWER);
        });
        assertEquals("salt cannot be null", exception.getMessage());
    }

    @Test
    void testConstructorWithNullIv() {
        Exception exception = assertThrows(NullPointerException.class, () -> {
            createAES256Options(PASSWORD, SALT, null, NUM_CYCLES_POWER);
        });
        assertEquals("iv cannot be null", exception.getMessage());
    }

    @Test
    void testConstructorWithNegativeNumCyclesPower() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            createAES256Options(PASSWORD, SALT, IV, -1);
        });
        assertEquals("numCyclesPower must be a non-negative integer", exception.getMessage());
    }
}
