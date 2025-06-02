package org.apache.commons.codec.digest;

import org.apache.commons.codec.digest.B64;
import org.apache.commons.codec.digest.Sha2Crypt;
import java.lang.reflect.Method;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.util.Random;
import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

class Sha2Crypt_sha512Crypt_6_0_Test {

    private final Random random = new SecureRandom();

    @Test
    void testSha512CryptWithValidSalt() throws Exception {
        byte[] keyBytes = "testPassword".getBytes(StandardCharsets.UTF_8);
        String salt = "$6$rounds=5000$abcdefghijklmnop";
        String result = invokeSha512Crypt(keyBytes, salt, random);
        assertNotNull(result);
        assertTrue(result.startsWith("$6$"));
        assertTrue(result.contains("abcdefghijklmnop"));
    }

    @Test
    void testSha512CryptWithNullSalt() throws Exception {
        byte[] keyBytes = "testPassword".getBytes(StandardCharsets.UTF_8);
        String result = invokeSha512Crypt(keyBytes, null, random);
        assertNotNull(result);
        assertTrue(result.startsWith("$6$"));
        // Ensure it generates a valid hash
        assertTrue(result.length() > 20);
    }

    @Test
    void testSha512CryptWithInvalidSalt() {
        byte[] keyBytes = "testPassword".getBytes(StandardCharsets.UTF_8);
        String salt = "invalid_salt";
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            invokeSha512Crypt(keyBytes, salt, random);
        });
        assertEquals("Invalid salt value: " + salt, exception.getMessage());
    }

    @Test
    void testSha512CryptWithCustomRounds() throws Exception {
        byte[] keyBytes = "testPassword".getBytes(StandardCharsets.UTF_8);
        String salt = "$6$rounds=1000$abcdefghijklmnop";
        String result = invokeSha512Crypt(keyBytes, salt, random);
        assertNotNull(result);
        assertTrue(result.startsWith("$6$"));
        assertTrue(result.contains("abcdefghijklmnop"));
    }

    private String invokeSha512Crypt(byte[] keyBytes, String salt, Random random) throws Exception {
        Method method = Sha2Crypt.class.getDeclaredMethod("sha512Crypt", byte[].class, String.class, Random.class);
        method.setAccessible(true);
        return (String) method.invoke(null, keyBytes, salt, random);
    }
}
