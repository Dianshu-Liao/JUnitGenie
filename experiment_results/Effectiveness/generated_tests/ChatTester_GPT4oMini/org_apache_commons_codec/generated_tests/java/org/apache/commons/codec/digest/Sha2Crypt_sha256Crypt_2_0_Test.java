package org.apache.commons.codec.digest;

import java.lang.reflect.Method;
import java.security.SecureRandom;
import java.util.Random;
import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

class Sha2Crypt_sha256Crypt_2_0_Test {

    private Sha2Crypt sha2Crypt;

    @BeforeEach
    void setUp() {
        sha2Crypt = new Sha2Crypt();
    }

    @Test
    void testSha256Crypt_WithNullSalt() throws Exception {
        byte[] keyBytes = "testKey".getBytes();
        Random random = new SecureRandom();
        String result = invokeSha256Crypt(keyBytes, null, random);
        assertNotNull(result);
        assertTrue(result.startsWith(Sha2Crypt.SHA256_PREFIX));
    }

    @Test
    void testSha256Crypt_WithValidSalt() throws Exception {
        byte[] keyBytes = "testKey".getBytes();
        String salt = "$5$rounds=5000$abcdefgh";
        Random random = new SecureRandom();
        String result = invokeSha256Crypt(keyBytes, salt, random);
        assertNotNull(result);
        assertEquals(salt, result.substring(0, salt.length()));
    }

    @Test
    void testSha256Crypt_WithEmptySalt() throws Exception {
        byte[] keyBytes = "testKey".getBytes();
        String salt = "";
        Random random = new SecureRandom();
        String result = invokeSha256Crypt(keyBytes, salt, random);
        assertNotNull(result);
        assertTrue(result.startsWith(Sha2Crypt.SHA256_PREFIX));
    }

    @Test
    void testSha256Crypt_WithRandomSalt() throws Exception {
        byte[] keyBytes = "testKey".getBytes();
        Random random = new SecureRandom();
        String result = invokeSha256Crypt(keyBytes, null, random);
        assertNotNull(result);
        assertTrue(result.startsWith(Sha2Crypt.SHA256_PREFIX));
        assertTrue(result.length() > 0);
    }

    private String invokeSha256Crypt(byte[] keyBytes, String salt, Random random) throws Exception {
        Method method = Sha2Crypt.class.getDeclaredMethod("sha256Crypt", byte[].class, String.class, Random.class);
        method.setAccessible(true);
        return (String) method.invoke(null, keyBytes, salt, random);
    }
}
