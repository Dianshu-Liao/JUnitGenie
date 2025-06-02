package org.apache.commons.codec.cli;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.lang.reflect.Method;
import java.nio.charset.StandardCharsets;
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

    private Digest createDigestInstance(String[] args) throws Exception {
        // Use reflection to create an instance of Digest
        Class<Digest> digestClass = Digest.class;
        return digestClass.getDeclaredConstructor(String[].class).newInstance((Object) args);
    }

    private void invokePrintln(Digest digestInstance, String prefix, byte[] digest, String fileName) throws Exception {
        // Use reflection to invoke the println method
        Method printlnMethod = Digest.class.getDeclaredMethod("println", String.class, byte[].class, String.class);
        printlnMethod.setAccessible(true);
        printlnMethod.invoke(digestInstance, prefix, digest, fileName);
    }

    @Test
    public void testPrintlnWithValidInput() throws Exception {
        // Arrange
        String prefix = "Digest: ";
        byte[] digest = "test".getBytes(StandardCharsets.UTF_8);
        String expectedOutput = prefix + "74657374";
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));
        Digest digestInstance = createDigestInstance(new String[] { "SHA-256", "inputString" });
        // Act
        invokePrintln(digestInstance, prefix, digest, null);
        // Assert
        assertEquals(expectedOutput, outContent.toString().trim());
        System.setOut(System.out);
    }

    @Test
    public void testPrintlnWithFileName() throws Exception {
        // Arrange
        String prefix = "Digest: ";
        byte[] digest = "example".getBytes(StandardCharsets.UTF_8);
        String fileName = "example.txt";
        String expectedOutput = prefix + "6578616D706C65  example.txt";
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));
        Digest digestInstance = createDigestInstance(new String[] { "SHA-256", "inputString" });
        // Act
        invokePrintln(digestInstance, prefix, digest, fileName);
        // Assert
        assertEquals(expectedOutput, outContent.toString().trim());
        System.setOut(System.out);
    }
}
