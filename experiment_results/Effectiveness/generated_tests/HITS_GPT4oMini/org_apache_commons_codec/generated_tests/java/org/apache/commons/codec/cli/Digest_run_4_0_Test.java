package org.apache.commons.codec.cli;

import org.apache.commons.codec.digest.DigestUtils;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.PrintStream;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Objects;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import java.nio.charset.Charset;
import java.util.Arrays;
import java.util.Locale;
import org.apache.commons.codec.binary.Hex;
import org.apache.commons.codec.digest.MessageDigestAlgorithms;
import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

public class Digest_run_4_0_Test {

    private PrintStream originalOut;

    private ByteArrayOutputStream outputStream;

    private Digest digest;

    @BeforeEach
    public void setUp() throws Exception {
        originalOut = System.out;
        outputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStream));
        String[] args = { "MD5", "src/test/resources/testfile.txt" };
        Constructor<Digest> constructor = Digest.class.getDeclaredConstructor(String[].class);
        constructor.setAccessible(true);
        digest = constructor.newInstance((Object) args);
    }

    @AfterEach
    public void tearDown() {
        System.setOut(originalOut);
    }

    private void invokeRunMethod(String prefix, MessageDigest messageDigest) throws Exception {
        Method runMethod = Digest.class.getDeclaredMethod("run", String.class, MessageDigest.class);
        runMethod.setAccessible(true);
        runMethod.invoke(digest, prefix, messageDigest);
    }

    @Test
    public void testRunWithFileInput() throws Exception {
        // Arrange
        MessageDigest messageDigest = DigestUtils.getMd5Digest();
        // Act
        invokeRunMethod("MD5: ", messageDigest);
        // Assert
        String output = outputStream.toString().trim();
        assertFalse(output.isEmpty());
        assertTrue(output.startsWith("MD5: "));
    }

    @Test
    public void testRunWithStringInput() throws Exception {
        // Arrange
        String[] args = { "SHA-256", "Hello World" };
        Constructor<Digest> constructor = Digest.class.getDeclaredConstructor(String[].class);
        constructor.setAccessible(true);
        digest = constructor.newInstance((Object) args);
        MessageDigest messageDigest = DigestUtils.getSha256Digest();
        // Act
        invokeRunMethod("SHA-256: ", messageDigest);
        // Assert
        String output = outputStream.toString().trim();
        assertFalse(output.isEmpty());
        assertTrue(output.startsWith("SHA-256: "));
    }

    @Test
    public void testRunWithDirectoryInput() throws Exception {
        // Arrange
        String[] args = { "SHA-1", "src/test/resources" };
        Constructor<Digest> constructor = Digest.class.getDeclaredConstructor(String[].class);
        constructor.setAccessible(true);
        digest = constructor.newInstance((Object) args);
        MessageDigest messageDigest = DigestUtils.getSha1Digest();
        // Act
        invokeRunMethod("SHA-1: ", messageDigest);
        // Assert
        String output = outputStream.toString().trim();
        assertFalse(output.isEmpty());
        assertTrue(output.startsWith("SHA-1: "));
    }
}
