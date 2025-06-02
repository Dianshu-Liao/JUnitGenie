package org.apache.commons.codec.cli;

import org.apache.commons.codec.digest.DigestUtils;
import java.io.File;
import java.io.IOException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.nio.charset.Charset;
import java.lang.reflect.Method;
import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import java.util.Arrays;
import java.util.Locale;
import java.util.Objects;
import org.apache.commons.codec.binary.Hex;
import org.apache.commons.codec.digest.MessageDigestAlgorithms;

class Digest_run_4_1_Test {

    private Digest digest;

    @BeforeEach
    void setUp() {
        String[] args = { "SHA-256", "test.txt" };
        digest = createDigestInstance(args);
    }

    private Digest createDigestInstance(String[] args) {
        try {
            java.lang.reflect.Constructor<Digest> constructor = Digest.class.getDeclaredConstructor(String[].class);
            constructor.setAccessible(true);
            return constructor.newInstance((Object) args);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    private void invokeRun(String prefix, MessageDigest messageDigest) throws Exception {
        Method runMethod = Digest.class.getDeclaredMethod("run", String.class, MessageDigest.class);
        runMethod.setAccessible(true);
        runMethod.invoke(digest, prefix, messageDigest);
    }

    @Test
    void testRunWithNullInputs() throws IOException, NoSuchAlgorithmException, Exception {
        String[] args = { "SHA-256" };
        Digest digestWithNullInputs = createDigestInstance(args);
        MessageDigest messageDigest = MessageDigest.getInstance("SHA-256");
        assertDoesNotThrow(() -> invokeRun("Prefix: ", messageDigest));
    }

    @Test
    void testRunWithValidFile() throws IOException, NoSuchAlgorithmException, Exception {
        File tempFile = File.createTempFile("test", ".txt");
        tempFile.deleteOnExit();
        String content = "Hello, World!";
        java.nio.file.Files.write(tempFile.toPath(), content.getBytes());
        String[] args = { "SHA-256", tempFile.getAbsolutePath() };
        Digest digestWithFile = createDigestInstance(args);
        MessageDigest messageDigest = MessageDigest.getInstance("SHA-256");
        assertDoesNotThrow(() -> invokeRun("Prefix: ", messageDigest));
    }
}
