package org.apache.commons.codec.cli;

import org.apache.commons.codec.binary.Hex;
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
import org.apache.commons.codec.digest.DigestUtils;
import org.apache.commons.codec.digest.MessageDigestAlgorithms;

public class Digest_println_2_0_Test {

    private Digest digest;

    private final ByteArrayOutputStream outputStreamCaptor = new ByteArrayOutputStream();

    private final PrintStream originalOut = System.out;

    @BeforeEach
    public void setUp() {
        System.setOut(new PrintStream(outputStreamCaptor));
        // Use reflection to access the private constructor
        try {
            Constructor<Digest> constructor = Digest.class.getDeclaredConstructor(String[].class);
            constructor.setAccessible(true);
            digest = constructor.newInstance((Object) new String[] {});
        } catch (Exception e) {
            fail("Failed to create instance of Digest", e);
        }
    }

    @AfterEach
    public void tearDown() {
        System.setOut(originalOut);
    }

    @Test
    public void testPrintln_withFileName() throws Exception {
        // Arrange
        String prefix = "Prefix: ";
        byte[] digestBytes = new byte[] { 0x1, 0x2, 0x3, 0x4, 0x5 };
        String fileName = "test.txt";
        // Act
        invokePrivatePrintln(prefix, digestBytes, fileName);
        // Assert
        String expectedOutput = prefix + Hex.encodeHexString(digestBytes) + "  " + fileName;
        assertEquals(expectedOutput, outputStreamCaptor.toString().trim());
    }

    @Test
    public void testPrintln_withoutFileName() throws Exception {
        // Arrange
        String prefix = "Prefix: ";
        byte[] digestBytes = new byte[] { 0x1, 0x2, 0x3, 0x4, 0x5 };
        String fileName = null;
        // Act
        invokePrivatePrintln(prefix, digestBytes, fileName);
        // Assert
        String expectedOutput = prefix + Hex.encodeHexString(digestBytes);
        assertEquals(expectedOutput, outputStreamCaptor.toString().trim());
    }

    private void invokePrivatePrintln(String prefix, byte[] digest, String fileName) throws Exception {
        Method method = Digest.class.getDeclaredMethod("println", String.class, byte[].class, String.class);
        method.setAccessible(true);
        method.invoke(this.digest, prefix, digest, fileName);
    }
}
