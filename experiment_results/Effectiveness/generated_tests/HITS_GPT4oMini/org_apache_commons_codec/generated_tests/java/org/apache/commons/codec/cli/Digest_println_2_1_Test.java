package org.apache.commons.codec.cli;

import org.apache.commons.codec.binary.Hex;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.lang.reflect.Method;
import org.mockito.junit.jupiter.MockitoExtension;
import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.extension.ExtendWith;
import java.io.File;
import java.io.IOException;
import java.nio.charset.Charset;
import java.security.MessageDigest;
import java.util.Arrays;
import java.util.Locale;
import java.util.Objects;
import org.apache.commons.codec.digest.DigestUtils;
import org.apache.commons.codec.digest.MessageDigestAlgorithms;

@ExtendWith(MockitoExtension.class)
public class Digest_println_2_1_Test {

    @Test
    public void testPrintln_withValidInput() throws Exception {
        // Arrange
        Digest digest = mock(Digest.class);
        String prefix = "Digest: ";
        byte[] inputDigest = new byte[] { (byte) 0x5a, (byte) 0x7b, (byte) 0x9c, (byte) 0x8d };
        String fileName = "example.txt";
        // Capture the output
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        PrintStream originalOut = System.out;
        System.setOut(new PrintStream(outputStream));
        // Access the private println method using reflection
        Method printlnMethod = Digest.class.getDeclaredMethod("println", String.class, byte[].class, String.class);
        printlnMethod.setAccessible(true);
        // Act
        printlnMethod.invoke(digest, prefix, inputDigest, fileName);
        // Assert
        String expectedHexString = Hex.encodeHexString(inputDigest);
        String expectedOutput = prefix + expectedHexString + "  " + fileName + System.lineSeparator();
        assertEquals(expectedOutput, outputStream.toString());
        // Restore the original System.out
        System.setOut(originalOut);
    }

    @Test
    public void testPrintln_withNullFileName() throws Exception {
        // Arrange
        Digest digest = mock(Digest.class);
        String prefix = "Digest: ";
        byte[] inputDigest = new byte[] { (byte) 0x5a, (byte) 0x7b, (byte) 0x9c, (byte) 0x8d };
        String fileName = null;
        // Capture the output
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        PrintStream originalOut = System.out;
        System.setOut(new PrintStream(outputStream));
        // Access the private println method using reflection
        Method printlnMethod = Digest.class.getDeclaredMethod("println", String.class, byte[].class, String.class);
        printlnMethod.setAccessible(true);
        // Act
        printlnMethod.invoke(digest, prefix, inputDigest, fileName);
        // Assert
        String expectedHexString = Hex.encodeHexString(inputDigest);
        String expectedOutput = prefix + expectedHexString + System.lineSeparator();
        assertEquals(expectedOutput, outputStream.toString());
        // Restore the original System.out
        System.setOut(originalOut);
    }
}
