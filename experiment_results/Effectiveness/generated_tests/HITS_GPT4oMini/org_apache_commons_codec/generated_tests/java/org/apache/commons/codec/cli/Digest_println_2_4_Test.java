package org.apache.commons.codec.cli;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
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

public class Digest_println_2_4_Test {

    private Digest digest;

    private Method printlnMethod;

    @BeforeEach
    public void setUp() throws Exception {
        // Access the private constructor using reflection
        Class<Digest> digestClass = Digest.class;
        digest = digestClass.getDeclaredConstructor(String[].class).newInstance((Object) new String[] {});
        // Access the private println method using reflection
        printlnMethod = digestClass.getDeclaredMethod("println", String.class, byte[].class, String.class);
        printlnMethod.setAccessible(true);
    }

    @Test
    public void testPrintlnWithValidInputs() throws Exception {
        // Arrange
        String prefix = "SHA-256: ";
        byte[] digestBytes = new byte[] { (byte) 0xBA, (byte) 0xAD, (byte) 0xF0, (byte) 0x0D, (byte) 0xBE, (byte) 0xEF };
        String fileName = "testfile.txt";
        // Capture output
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        PrintStream originalOut = System.out;
        System.setOut(new PrintStream(outputStream));
        // Act
        printlnMethod.invoke(digest, prefix, digestBytes, fileName);
        // Assert
        String expectedOutput = prefix + "badf00dbeef  " + fileName;
        assertEquals(expectedOutput, outputStream.toString().trim());
        // Restore original output
        System.setOut(originalOut);
    }

    @Test
    public void testPrintlnWithNullFileName() throws Exception {
        // Arrange
        String prefix = "SHA-256: ";
        byte[] digestBytes = new byte[] { (byte) 0xBA, (byte) 0xAD, (byte) 0xF0, (byte) 0x0D, (byte) 0xBE, (byte) 0xEF };
        String fileName = null;
        // Capture output
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        PrintStream originalOut = System.out;
        System.setOut(new PrintStream(outputStream));
        // Act
        printlnMethod.invoke(digest, prefix, digestBytes, fileName);
        // Assert
        String expectedOutput = prefix + "badf00dbeef";
        assertEquals(expectedOutput, outputStream.toString().trim());
        // Restore original output
        System.setOut(originalOut);
    }

    @Test
    public void testPrintlnWithEmptyPrefix() throws Exception {
        // Arrange
        String prefix = "";
        byte[] digestBytes = new byte[] { (byte) 0xBA, (byte) 0xAD, (byte) 0xF0, (byte) 0x0D, (byte) 0xBE, (byte) 0xEF };
        String fileName = "testfile.txt";
        // Capture output
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        PrintStream originalOut = System.out;
        System.setOut(new PrintStream(outputStream));
        // Act
        printlnMethod.invoke(digest, prefix, digestBytes, fileName);
        // Assert
        String expectedOutput = "badf00dbeef  " + fileName;
        assertEquals(expectedOutput, outputStream.toString().trim());
        // Restore original output
        System.setOut(originalOut);
    }
}
