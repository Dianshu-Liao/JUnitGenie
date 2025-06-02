package org.apache.commons.codec.cli;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.PrintStream;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.lang.reflect.InvocationTargetException;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import java.nio.charset.Charset;
import java.util.Arrays;
import java.util.Locale;
import java.util.Objects;
import org.apache.commons.codec.binary.Hex;
import org.apache.commons.codec.digest.DigestUtils;
import org.apache.commons.codec.digest.MessageDigestAlgorithms;
import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

class Digest_run_5_0_Test {

    private Digest digest;

    private MessageDigest messageDigest;

    private File[] files;

    @BeforeEach
    void setUp() throws NoSuchAlgorithmException, NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {
        // Access the constructor of Digest
        java.lang.reflect.Constructor<Digest> constructor = Digest.class.getDeclaredConstructor(String[].class);
        constructor.setAccessible(true);
        digest = constructor.newInstance((Object) new String[] { "arg1", "arg2" });
        // Mock MessageDigest
        messageDigest = MessageDigest.getInstance("SHA-256");
        // Create mock files
        File file1 = mock(File.class);
        when(file1.isFile()).thenReturn(true);
        when(file1.getName()).thenReturn("file1.txt");
        File file2 = mock(File.class);
        // This will be ignored in the run method
        when(file2.isFile()).thenReturn(false);
        when(file2.getName()).thenReturn("dir1");
        File file3 = mock(File.class);
        when(file3.isFile()).thenReturn(true);
        when(file3.getName()).thenReturn("file2.txt");
        files = new File[] { file1, file2, file3 };
    }

    @Test
    void testRunWithValidFiles() throws Exception {
        // Use reflection to access the private method
        java.lang.reflect.Method method = Digest.class.getDeclaredMethod("run", String.class, MessageDigest.class, File[].class);
        method.setAccessible(true);
        // Capture the output
        PrintStream originalOut = System.out;
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStream));
        // Invoke the method
        method.invoke(digest, "Prefix: ", messageDigest, files);
        // Restore original output
        System.setOut(originalOut);
        // Verify output contains expected results
        String output = outputStream.toString();
        assertTrue(output.contains("Prefix: ") && output.contains("file1.txt") && output.contains("file2.txt"));
        // Ensure the directory is not processed
        assertFalse(output.contains("dir1"));
    }

    @Test
    void testRunWithNoFiles() throws Exception {
        File[] emptyFiles = new File[] {};
        // Use reflection to access the private method
        java.lang.reflect.Method method = Digest.class.getDeclaredMethod("run", String.class, MessageDigest.class, File[].class);
        method.setAccessible(true);
        // Capture the output
        PrintStream originalOut = System.out;
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStream));
        // Invoke the method
        method.invoke(digest, "Prefix: ", messageDigest, emptyFiles);
        // Restore original output
        System.setOut(originalOut);
        // Verify no output is produced
        String output = outputStream.toString();
        assertTrue(output.isEmpty());
    }
}
