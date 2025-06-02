package org.apache.commons.compress.archivers.sevenz;

import org.apache.commons.compress.archivers.sevenz.AES256Options;
import javax.crypto.Cipher;
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
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

class AES256Options_AES256Options_6_0_Test {

    private AES256Options aes256Options;

    @BeforeEach
    void setUp() {
        aes256Options = new AES256Options("testPassword".toCharArray());
    }

    @Test
    void testConstructorWithValidPassword() {
        assertNotNull(aes256Options);
        assertNotNull(aes256Options.getCipher());
        assertNotNull(aes256Options.getIv());
        assertNotNull(aes256Options.getSalt());
        assertNotNull(aes256Options.getNumCyclesPower());
    }

    @Test
    void testCipherInitialization() {
        Cipher cipher = aes256Options.getCipher();
        assertNotNull(cipher);
        assertArrayEquals(new byte[16], aes256Options.getIv());
    }

    @Test
    void testConstructorWithNullPassword() {
        assertThrows(NullPointerException.class, () -> {
            new AES256Options(null);
        });
    }

    @Test
    void testConstructorWithEmptyPassword() {
        AES256Options emptyPasswordOptions = new AES256Options("".toCharArray());
        assertNotNull(emptyPasswordOptions);
        assertNotNull(emptyPasswordOptions.getCipher());
    }

    @Test
    void testConstructorWithSaltAndIv() {
        byte[] salt = new byte[16];
        byte[] iv = new byte[16];
        AES256Options customOptions = new AES256Options("testPassword".toCharArray(), salt, iv, 19);
        assertNotNull(customOptions);
        assertArrayEquals(salt, customOptions.getSalt());
        assertArrayEquals(iv, customOptions.getIv());
    }

    @Test
    void testCipherExceptionHandling() {
        assertThrows(IllegalStateException.class, () -> {
            // This simulates an exception during cipher initialization
            new AES256Options("invalidPassword".toCharArray(), new byte[16], new byte[16], -1);
        });
    }
}
