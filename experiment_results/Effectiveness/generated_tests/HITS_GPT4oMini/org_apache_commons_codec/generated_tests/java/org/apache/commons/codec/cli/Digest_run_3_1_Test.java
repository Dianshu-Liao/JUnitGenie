package org.apache.commons.codec.cli;

import org.apache.commons.codec.digest.MessageDigestAlgorithms;
import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import java.nio.charset.Charset;
import java.util.Arrays;
import java.util.Locale;
import java.util.Objects;
import org.apache.commons.codec.binary.Hex;
import org.apache.commons.codec.digest.DigestUtils;
import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

public class Digest_run_3_1_Test {

    private Digest digest;

    private Digest createDigest(String[] args) throws Exception {
        java.lang.reflect.Constructor<Digest> constructor = Digest.class.getDeclaredConstructor(String[].class);
        constructor.setAccessible(true);
        return constructor.newInstance((Object) args);
    }

    @BeforeEach
    public void setUp() throws Exception {
        String[] args = { MessageDigestAlgorithms.MD5, "testInput" };
        digest = createDigest(args);
    }

    @Test
    public void testRun_WithValidAlgorithm() throws Exception {
        MessageDigest mockMessageDigest = mock(MessageDigest.class);
        when(mockMessageDigest.digest(any(byte[].class))).thenReturn(new byte[] { 1, 2, 3, 4 });
        // Use reflection to access the private run method
        java.lang.reflect.Method runMethod = Digest.class.getDeclaredMethod("run", String.class, MessageDigest.class);
        runMethod.setAccessible(true);
        runMethod.invoke(digest, MessageDigestAlgorithms.MD5, mockMessageDigest);
        verify(mockMessageDigest, times(1)).digest(any(byte[].class));
    }

//    @Test
//    public void testRun_WithAllAlgorithms() throws Exception {
//        String[] args = { "ALL" };
//        digest = createDigest(args);
//        java.lang.reflect.Method runMethod = Digest.class.getDeclaredMethod("run", String[].class);
//        runMethod.setAccessible(true);
//        runMethod.invoke(digest, (Object) MessageDigestAlgorithms.values());
//        for (String algorithm : MessageDigestAlgorithms.values()) {
//            if (DigestUtils.isAvailable(algorithm)) {
//                // Add verifications as needed based on implementation
//            }
//        }
//    }

    @Test
    public void testRun_WithInvalidAlgorithm() throws Exception {
        String[] args = { "INVALID_ALGORITHM" };
        digest = createDigest(args);
        assertThrows(IOException.class, () -> {
            java.lang.reflect.Method runMethod = Digest.class.getDeclaredMethod("run");
            runMethod.setAccessible(true);
            runMethod.invoke(digest);
        });
    }

    @Test
    public void testConstructor_WithEmptyArgs() {
        String[] args = {};
        assertThrows(IllegalArgumentException.class, () -> createDigest(args));
    }

    @Test
    public void testConstructor_WithNullArgs() {
        assertThrows(NullPointerException.class, () -> createDigest(null));
    }

    @Test
    public void testRun_WithFileInput() throws Exception {
        File tempFile = File.createTempFile("testFile", ".txt");
        tempFile.deleteOnExit();
        String[] args = { MessageDigestAlgorithms.MD5, tempFile.getAbsolutePath() };
        digest = createDigest(args);
        java.lang.reflect.Method runMethod = Digest.class.getDeclaredMethod("run", String.class, MessageDigest.class);
        runMethod.setAccessible(true);
        runMethod.invoke(digest, MessageDigestAlgorithms.MD5, null);
        assertNotNull(digest);
    }
}
