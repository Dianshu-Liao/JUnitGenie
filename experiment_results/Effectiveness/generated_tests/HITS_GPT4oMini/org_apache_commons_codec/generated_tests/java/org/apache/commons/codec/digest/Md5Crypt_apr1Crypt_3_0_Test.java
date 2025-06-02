package org.apache.commons.codec.digest;

import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.SecureRandom;
import java.util.Arrays;
import java.util.Objects;
import java.util.Random;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Md5Crypt_apr1Crypt_3_0_Test {

    @Test
    public void testApr1Crypt_NonEmptyString() {
        String input = "testPassword";
        String result = Md5Crypt.apr1Crypt(input);
        assertNotNull(result, "The result should not be null");
        assertTrue(result.startsWith(Md5Crypt.APR1_PREFIX), "The result should start with APR1_PREFIX");
    }

    @Test
    public void testApr1Crypt_EmptyString() {
        String input = "";
        String result = Md5Crypt.apr1Crypt(input);
        assertNotNull(result, "The result should not be null");
        assertTrue(result.startsWith(Md5Crypt.APR1_PREFIX), "The result should start with APR1_PREFIX");
    }

    @Test
    public void testApr1Crypt_NullInput() {
        String input = null;
        String result = Md5Crypt.apr1Crypt(input);
        assertNotNull(result, "The result should not be null");
        assertTrue(result.startsWith(Md5Crypt.APR1_PREFIX), "The result should start with APR1_PREFIX");
    }

    @Test
    public void testApr1Crypt_DifferentInputs() {
        String input1 = "password1";
        String input2 = "password2";
        String result1 = Md5Crypt.apr1Crypt(input1);
        String result2 = Md5Crypt.apr1Crypt(input2);
        assertNotNull(result1, "The result for input1 should not be null");
        assertNotNull(result2, "The result for input2 should not be null");
        assertTrue(!result1.equals(result2), "The results for different inputs should be different");
    }
}
