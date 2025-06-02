package org.apache.commons.codec.cli;

import org.apache.commons.codec.digest.MessageDigestAlgorithms;
import org.apache.commons.codec.digest.DigestUtils;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.lang.reflect.Constructor;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import java.nio.charset.Charset;
import java.util.Arrays;
import java.util.Locale;
import java.util.Objects;
import org.apache.commons.codec.binary.Hex;
import java.nio.file.Files;
import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

class Digest_run_3_0_Test {

    private Digest digest;

    private Constructor<Digest> constructor;

    @BeforeEach
    void setUp() throws Exception {
        // Use reflection to access the private constructor of Digest
        constructor = Digest.class.getDeclaredConstructor(String[].class);
        constructor.setAccessible(true);
        // Setup with MD5 algorithm and a dummy input
        digest = constructor.newInstance(new String[] { "MD5", "testInput" });
    }

    @Test
    void testRunWithValidAlgorithm() throws Exception {
        // Testing the run method with a valid algorithm
        assertDoesNotThrow(() -> {
            digest.getClass().getDeclaredMethod("run", String[].class).invoke(digest, (Object) new String[] {});
        });
    }

    @Test
    void testRunWithAllAlgorithms() throws Exception {
        // Setup Digest with "ALL" to test all algorithms
        digest = constructor.newInstance(new String[] { "ALL" });
        assertDoesNotThrow(() -> {
            digest.getClass().getDeclaredMethod("run", String[].class).invoke(digest, (Object) new String[] {});
        });
    }

    @Test
    void testRunWithInvalidAlgorithm() throws Exception {
        // Setup Digest with an invalid algorithm
        digest = constructor.newInstance(new String[] { "INVALID_ALGORITHM" });
        assertThrows(IllegalArgumentException.class, () -> {
            digest.getClass().getDeclaredMethod("run", String[].class).invoke(digest, (Object) new String[] {});
        });
    }

    @Test
    void testRunWithEmptyInput() throws Exception {
        // Setup Digest with no input files
        digest = constructor.newInstance(new String[] { "MD5" });
        assertDoesNotThrow(() -> {
            digest.getClass().getDeclaredMethod("run", String[].class).invoke(digest, (Object) new String[] {});
        });
    }
}
