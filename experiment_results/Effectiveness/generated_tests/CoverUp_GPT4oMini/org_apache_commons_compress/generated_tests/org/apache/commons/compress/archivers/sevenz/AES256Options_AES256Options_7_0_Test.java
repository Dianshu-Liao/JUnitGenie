package org.apache.commons.compress.archivers.sevenz;

import org.apache.commons.compress.archivers.sevenz.AES256Options;
import org.apache.commons.compress.archivers.sevenz.AES256SHA256Decoder;
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

class AES256Options_AES256Options_7_0_Test {

    private char[] password;

    private byte[] salt;

    private byte[] iv;

    private int numCyclesPower;

    @BeforeEach
    void setUp() {
        password = "testPassword".toCharArray();
        salt = new byte[] { 1, 2, 3, 4, 5, 6, 7, 8 };
        iv = new byte[] { 9, 10, 11, 12, 13, 14, 15, 16 };
        numCyclesPower = 19;
    }

    @Test
    void testAES256Options_ValidInput() {
        AES256Options options = new AES256Options(password, salt, iv, numCyclesPower);
        assertNotNull(options.getCipher());
        assertNotNull(options.getIv());
        assertNotNull(options.getSalt());
        assertNotNull(options.getNumCyclesPower());
    }

    @Test
    void testAES256Options_NullPassword() {
        assertThrows(NullPointerException.class, () -> {
            new AES256Options(null, salt, iv, numCyclesPower);
        });
    }

    @Test
    void testAES256Options_InvalidCipherTransformation() {
        // Here we would need to mock or manipulate the Cipher to throw an exception
        // This is a bit tricky since Cipher.getInstance() is static.
        // We will check for IllegalStateException which is thrown on failure.
        assertThrows(IllegalStateException.class, () -> {
            // Reflection to invoke the constructor with invalid parameters
            AES256Options options = new AES256Options(password, salt, iv, -1);
        });
    }

    @Test
    void testAES256Options_EmptySalt() {
        AES256Options options = new AES256Options(password, new byte[] {}, iv, numCyclesPower);
        assertNotNull(options.getCipher());
    }

    @Test
    void testAES256Options_EmptyIV() {
        AES256Options options = new AES256Options(password, salt, new byte[] {}, numCyclesPower);
        assertNotNull(options.getCipher());
    }
}
