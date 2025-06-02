package org.apache.commons.codec.cli;

import java.io.IOException;
import java.lang.reflect.Method;
import java.security.MessageDigest;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.apache.commons.codec.digest.DigestUtils;
import java.io.File;
import java.nio.charset.Charset;
import java.util.Arrays;
import java.util.Locale;
import java.util.Objects;
import org.apache.commons.codec.binary.Hex;
import org.apache.commons.codec.digest.MessageDigestAlgorithms;
import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
public class Digest_run_3_0_Test {

    private Digest digest;

    @BeforeEach
    public void setUp() {
        // Initialize the Digest class with a dummy argument
        String[] args = new String[] { "dummyArg" };
        // Access the private constructor using reflection
        try {
            Class<?> digestClass = Digest.class;
            java.lang.reflect.Constructor<?> constructor = digestClass.getDeclaredConstructor(String[].class);
            constructor.setAccessible(true);
            digest = (Digest) constructor.newInstance((Object) args);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Test
    public void testRunWithAllAlgorithm() throws Exception {
        // Set the algorithm to "ALL"
        setAlgorithm("ALL");
        // Invoke the private run method
        invokeRunMethod();
        // Add assertions as necessary to verify expected outcomes
    }

    @Test
    public void testRunWithWildcardAlgorithm() throws Exception {
        // Set the algorithm to "*"
        setAlgorithm("*");
        // Invoke the private run method
        invokeRunMethod();
        // Add assertions as necessary to verify expected outcomes
    }

    @Test
    public void testRunWithValidAlgorithm() throws Exception {
        // Set a valid algorithm
        setAlgorithm("SHA-256");
        // Mock the behavior of DigestUtils.getDigest
        MessageDigest mockDigest = Mockito.mock(MessageDigest.class);
        when(DigestUtils.getDigest("SHA-256")).thenReturn(mockDigest);
        // Invoke the private run method
        invokeRunMethod();
        // Add assertions as necessary to verify expected outcomes
    }

    @Test
    public void testRunWithInvalidAlgorithm() throws Exception {
        // Set an invalid algorithm
        setAlgorithm("INVALID_ALGORITHM");
        // Mock the behavior of DigestUtils.getDigest
        when(DigestUtils.getDigest("INVALID_ALGORITHM")).thenReturn(null);
        // Invoke the private run method
        invokeRunMethod();
        // Add assertions as necessary to verify expected outcomes
    }

    @Test
    public void testRunThrowsIOException() {
        // Set the algorithm to a case that would lead to an IOException
        setAlgorithm("THROW_IO_EXCEPTION");
        // Assert that invoking run() throws an IOException
        assertThrows(IOException.class, () -> invokeRunMethod());
    }

    private void setAlgorithm(String algorithm) {
        // Use reflection to set the private 'algorithm' field
        try {
            java.lang.reflect.Field algorithmField = Digest.class.getDeclaredField("algorithm");
            algorithmField.setAccessible(true);
            algorithmField.set(digest, algorithm);
        } catch (NoSuchFieldException | IllegalAccessException e) {
            throw new RuntimeException(e);
        }
    }

    private void invokeRunMethod() throws Exception {
        // Use reflection to invoke the private 'run' method
        Method runMethod = Digest.class.getDeclaredMethod("run");
        runMethod.setAccessible(true);
        runMethod.invoke(digest);
    }
}
