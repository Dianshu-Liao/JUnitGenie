package org.apache.commons.codec.digest;

import java.lang.reflect.Method;
import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.util.Arrays;
import java.util.Random;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Sha2Crypt_sha256Crypt_1_0_Test {

    private Sha2Crypt sha2Crypt;

    @BeforeEach
    public void setUp() {
        sha2Crypt = new Sha2Crypt();
    }

    @Test
    public void testSha256Crypt_WithNullSalt() throws Exception {
        byte[] keyBytes = "testKey".getBytes();
        // Invoke the focal method using reflection
        Method method = Sha2Crypt.class.getDeclaredMethod("sha256Crypt", byte[].class, String.class);
        method.setAccessible(true);
        String result = (String) method.invoke(null, keyBytes, null);
        // Validate that the result is not null and starts with the SHA256_PREFIX
        Assertions.assertNotNull(result);
        Assertions.assertTrue(result.startsWith(Sha2Crypt.SHA256_PREFIX));
    }

    @Test
    public void testSha256Crypt_WithValidSalt() throws Exception {
        byte[] keyBytes = "testKey".getBytes();
        String salt = "$5$rounds=5000$abcdefgh";
        // Invoke the focal method using reflection
        Method method = Sha2Crypt.class.getDeclaredMethod("sha256Crypt", byte[].class, String.class);
        method.setAccessible(true);
        String result = (String) method.invoke(null, keyBytes, salt);
        // Validate that the result is not null and matches expected output format
        Assertions.assertNotNull(result);
        Assertions.assertTrue(result.startsWith(Sha2Crypt.SHA256_PREFIX));
        Assertions.assertTrue(result.contains(salt));
    }

    @Test
    public void testSha256Crypt_WithEmptySalt() throws Exception {
        byte[] keyBytes = "testKey".getBytes();
        String salt = "";
        // Invoke the focal method using reflection
        Method method = Sha2Crypt.class.getDeclaredMethod("sha256Crypt", byte[].class, String.class);
        method.setAccessible(true);
        String result = (String) method.invoke(null, keyBytes, salt);
        // Validate that the result is not null and starts with the SHA256_PREFIX
        Assertions.assertNotNull(result);
        Assertions.assertTrue(result.startsWith(Sha2Crypt.SHA256_PREFIX));
    }

    @Test
    public void testSha256Crypt_WithShortSalt() throws Exception {
        byte[] keyBytes = "testKey".getBytes();
        String salt = "$5$rounds=5000$";
        // Invoke the focal method using reflection
        Method method = Sha2Crypt.class.getDeclaredMethod("sha256Crypt", byte[].class, String.class);
        method.setAccessible(true);
        String result = (String) method.invoke(null, keyBytes, salt);
        // Validate that the result is not null and starts with the SHA256_PREFIX
        Assertions.assertNotNull(result);
        Assertions.assertTrue(result.startsWith(Sha2Crypt.SHA256_PREFIX));
        Assertions.assertTrue(result.contains(salt));
    }
}
