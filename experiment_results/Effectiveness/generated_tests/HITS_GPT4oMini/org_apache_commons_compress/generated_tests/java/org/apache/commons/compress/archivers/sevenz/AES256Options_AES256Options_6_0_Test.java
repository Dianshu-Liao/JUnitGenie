package org.apache.commons.compress.archivers.sevenz;

import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import java.security.GeneralSecurityException;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;

class AES256Options_AES256Options_6_0_Test {

    private AES256Options aes256Options;

    private char[] password;

    @BeforeEach
    void setUp() {
        password = "securePassword".toCharArray();
        aes256Options = new AES256Options(password);
    }

    @Test
    void testConstructorWithValidPassword() {
        assertNotNull(aes256Options);
        assertNotNull(aes256Options.getCipher());
        assertNotNull(aes256Options.getIv());
        assertNotNull(aes256Options.getSalt());
        assertEquals(19, aes256Options.getNumCyclesPower());
    }

    @Test
    void testCipherInitialization() {
        Cipher cipher = aes256Options.getCipher();
        assertEquals("AES/CBC/NoPadding", cipher.getAlgorithm());
    }

    @Test
    void testIvNotEmpty() {
        byte[] iv = aes256Options.getIv();
        assertNotNull(iv);
        assertEquals(16, iv.length);
    }

    @Test
    void testSaltNotEmpty() {
        byte[] salt = aes256Options.getSalt();
        assertNotNull(salt);
        assertTrue(salt.length > 0);
    }

    @Test
    void testNumCyclesPowerValue() {
        assertEquals(19, aes256Options.getNumCyclesPower());
    }

    @Test
    void testCipherIsInitializedCorrectly() {
        Cipher cipher = aes256Options.getCipher();
        assertNotNull(cipher);
        assertNotNull(cipher.getParameters());
        try {
            IvParameterSpec ivParams = (IvParameterSpec) cipher.getParameters().getParameterSpec(IvParameterSpec.class);
            assertNotNull(ivParams);
        } catch (Exception e) {
            fail("Cipher parameters are not valid: " + e.getMessage());
        }
    }

    @Test
    void testCipherEncryption() {
        String plaintext = "Hello, World!";
        byte[] plaintextBytes = plaintext.getBytes();
        try {
            byte[] encrypted = aes256Options.getCipher().doFinal(plaintextBytes);
            assertNotNull(encrypted);
            assertNotEquals(plaintext, new String(encrypted));
        } catch (Exception e) {
            fail("Encryption failed with exception: " + e.getMessage());
        }
    }
}
