package org.apache.commons.compress.archivers.sevenz;

import javax.crypto.Cipher;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
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

    private char[] password;

    @BeforeEach
    void setUp() {
        password = "testPassword".toCharArray();
        aes256Options = new AES256Options(password);
    }

    @Test
    void testConstructorWithPassword() {
        assertNotNull(aes256Options);
    }

    @Test
    void testConstructorWithPasswordAndDefaultValues() throws Exception {
        Constructor<AES256Options> constructor = AES256Options.class.getDeclaredConstructor(char[].class, byte[].class, byte[].class, int.class);
        constructor.setAccessible(true);
        AES256Options instance = constructor.newInstance(password, new byte[0], new byte[16], 19);
        assertNotNull(instance);
    }

    @Test
    void testEmptyByteArray() throws Exception {
        Constructor<AES256Options> constructor = AES256Options.class.getDeclaredConstructor(char[].class);
        constructor.setAccessible(true);
        AES256Options instance = constructor.newInstance(password);
        byte[] expectedSalt = new byte[0];
        byte[] expectedIv = (byte[]) AES256Options.class.getDeclaredField("iv").get(instance);
        assertArrayEquals(expectedSalt, expectedIv);
    }

    @Test
    void testInitializationWithRandomBytes() throws Exception {
        Constructor<AES256Options> constructor = AES256Options.class.getDeclaredConstructor(char[].class);
        constructor.setAccessible(true);
        AES256Options instance = constructor.newInstance(password);
        byte[] iv = (byte[]) AES256Options.class.getDeclaredField("iv").get(instance);
        assertNotNull(iv);
        // Assuming randomBytes(16) returns a byte array of length 16
        assertArrayEquals(new byte[16], iv);
    }

    @Test
    void testCipherInitialization() throws Exception {
        Constructor<AES256Options> constructor = AES256Options.class.getDeclaredConstructor(char[].class);
        constructor.setAccessible(true);
        AES256Options instance = constructor.newInstance(password);
        Cipher cipher = instance.getCipher();
        assertNotNull(cipher);
        assertArrayEquals("AES".getBytes(), AES256Options.ALGORITHM.getBytes());
    }
}
