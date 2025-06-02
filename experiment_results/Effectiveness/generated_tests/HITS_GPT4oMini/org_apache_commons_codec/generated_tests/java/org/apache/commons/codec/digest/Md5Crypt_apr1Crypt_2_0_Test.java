package org.apache.commons.codec.digest;

import java.nio.charset.StandardCharsets;
import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import java.security.MessageDigest;
import java.security.SecureRandom;
import java.util.Arrays;
import java.util.Objects;
import java.util.Random;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Md5Crypt_apr1Crypt_2_0_Test {

    @Test
    public void testApr1Crypt_WithNullSalt() {
        byte[] keyBytes = "testKey".getBytes(StandardCharsets.UTF_8);
        String result = Md5Crypt.apr1Crypt(keyBytes, (String) null);
        // The salt should be $apr1$ since null is provided
        assertEquals("$apr1$", result.substring(0, 6), "Salt should default to $apr1$ when null is provided");
    }

    @Test
    public void testApr1Crypt_WithValidSalt() {
        byte[] keyBytes = "testKey".getBytes(StandardCharsets.UTF_8);
        String salt = "$apr1$validSalt";
        String result = Md5Crypt.apr1Crypt(keyBytes, salt);
        // The salt should remain unchanged as it already starts with $apr1$
        assertEquals(salt, result.substring(0, salt.length()), "Salt should remain unchanged when valid");
    }

    @Test
    public void testApr1Crypt_WithInvalidSalt() {
        byte[] keyBytes = "testKey".getBytes(StandardCharsets.UTF_8);
        String salt = "invalidSalt";
        String result = Md5Crypt.apr1Crypt(keyBytes, salt);
        // The salt should be prepended with $apr1$
        assertEquals("$apr1$" + salt, result.substring(0, ("$apr1$" + salt).length()), "Salt should be prepended with $apr1$ when invalid");
    }

    @Test
    public void testApr1Crypt_WithEmptySalt() {
        byte[] keyBytes = "testKey".getBytes(StandardCharsets.UTF_8);
        String salt = "";
        String result = Md5Crypt.apr1Crypt(keyBytes, salt);
        // The salt should be $apr1$ since empty string is provided
        assertEquals("$apr1$", result.substring(0, 6), "Salt should default to $apr1$ when empty string is provided");
    }
}
