package org.apache.commons.codec.cli;

import org.apache.commons.codec.digest.DigestUtils;
import org.apache.commons.codec.digest.MessageDigestAlgorithms;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.util.Locale;
import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import java.io.File;
import java.nio.charset.Charset;
import java.util.Arrays;
import java.util.Objects;
import org.apache.commons.codec.binary.Hex;

class Digest_run_3_1_Test {

    private Digest digest;

    @BeforeEach
    void setUp() throws Exception {
        String[] args = { MessageDigestAlgorithms.SHA_256, "testInput" };
        Constructor<Digest> constructor = Digest.class.getDeclaredConstructor(String[].class);
        constructor.setAccessible(true);
        digest = constructor.newInstance((Object) args);
    }

    @Test
    void testRunWithValidAlgorithm() throws Exception {
        invokeRunMethod();
        // Add assertions to validate the expected behavior
    }

    @Test
    void testRunWithAllAlgorithms() throws Exception {
        String[] args = { "ALL", "testInput" };
        Constructor<Digest> constructor = Digest.class.getDeclaredConstructor(String[].class);
        constructor.setAccessible(true);
        digest = constructor.newInstance((Object) args);
        invokeRunMethod();
        // Add assertions to validate the expected behavior
    }

    @Test
    void testRunWithStarAlgorithm() throws Exception {
        String[] args = { "*", "testInput" };
        Constructor<Digest> constructor = Digest.class.getDeclaredConstructor(String[].class);
        constructor.setAccessible(true);
        digest = constructor.newInstance((Object) args);
        invokeRunMethod();
        // Add assertions to validate the expected behavior
    }

    @Test
    void testRunWithInvalidAlgorithm() throws Exception {
        String[] args = { "INVALID_ALGORITHM", "testInput" };
        Constructor<Digest> constructor = Digest.class.getDeclaredConstructor(String[].class);
        constructor.setAccessible(true);
        digest = constructor.newInstance((Object) args);
        assertThrows(IOException.class, this::invokeRunMethod);
    }

    private void invokeRunMethod() throws Exception {
        Method runMethod = Digest.class.getDeclaredMethod("run");
        runMethod.setAccessible(true);
        runMethod.invoke(digest);
    }

    private void simulateInputStream(String input) {
        InputStream in = new ByteArrayInputStream(input.getBytes(StandardCharsets.UTF_8));
        System.setIn(in);
    }
}
