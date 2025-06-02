package org.apache.commons.codec.cli;

import org.apache.commons.codec.cli.Digest;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import java.io.File;
import java.io.IOException;
import java.nio.charset.Charset;
import java.security.MessageDigest;
import java.util.Arrays;
import java.util.Locale;
import java.util.Objects;
import org.apache.commons.codec.binary.Hex;
import org.apache.commons.codec.digest.DigestUtils;
import org.apache.commons.codec.digest.MessageDigestAlgorithms;

public class Digest_println_1_0_Test {

    private Digest digest;

    private ByteArrayOutputStream outputStream;

    private PrintStream originalOut;

    @BeforeEach
    public void setUp() {
        // Redirecting System.out to capture output for testing
        outputStream = new ByteArrayOutputStream();
        originalOut = System.out;
        System.setOut(new PrintStream(outputStream));
        // Initialize the Digest class with a valid algorithm
        String[] args = { "SHA-256", "input1", "input2" };
        digest = createDigest(args);
    }

    private Digest createDigest(String[] args) {
        try {
            // Use reflection to create an instance of Digest
            Constructor<Digest> constructor = Digest.class.getDeclaredConstructor(String[].class);
            constructor.setAccessible(true);
            return constructor.newInstance((Object) args);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Test
    public void testPrintlnWithValidDigest() throws Exception {
        // Given
        String prefix = "Digest: ";
        byte[] digestBytes = new byte[] { (byte) 0xA0, (byte) 0xB1, (byte) 0xC2, (byte) 0xD3 };
        // When
        invokePrivatePrintlnMethod(prefix, digestBytes);
        // Then
        String expectedOutput = prefix + "a0b1c2d3";
        assertEquals(expectedOutput, outputStream.toString().trim());
    }

    @Test
    public void testPrintlnWithEmptyDigest() throws Exception {
        // Given
        String prefix = "Digest: ";
        byte[] digestBytes = new byte[] {};
        // When
        invokePrivatePrintlnMethod(prefix, digestBytes);
        // Then
        String expectedOutput = prefix + "";
        assertEquals(expectedOutput, outputStream.toString().trim());
    }

    private void invokePrivatePrintlnMethod(String prefix, byte[] digest) throws Exception {
        // Use reflection to invoke the private println method
        Method method = Digest.class.getDeclaredMethod("println", String.class, byte[].class);
        method.setAccessible(true);
        method.invoke(this.digest, prefix, digest);
    }

    @AfterEach
    public void tearDown() {
        // Restore original System.out
        System.setOut(originalOut);
    }
}
