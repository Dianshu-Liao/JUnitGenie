package org.apache.commons.codec.digest;

import java.lang.reflect.Method;
import java.security.MessageDigest;
import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.file.Files;
import java.nio.file.OpenOption;
import java.nio.file.Path;
import java.security.NoSuchAlgorithmException;
import org.apache.commons.codec.binary.Hex;
import org.apache.commons.codec.binary.StringUtils;

public class DigestUtils_isAvailable_22_0_Test {

    @Test
    public void testIsAvailableWithValidAlgorithm() throws Exception {
        String validAlgorithm = "SHA-256";
        boolean result = invokeIsAvailable(validAlgorithm);
        assertTrue(result);
    }

    @Test
    public void testIsAvailableWithInvalidAlgorithm() throws Exception {
        String invalidAlgorithm = "INVALID_ALGORITHM";
        boolean result = invokeIsAvailable(invalidAlgorithm);
        assertFalse(result);
    }

    @Test
    public void testIsAvailableWithNullAlgorithm() throws Exception {
        boolean result = invokeIsAvailable(null);
        assertFalse(result);
    }

    private boolean invokeIsAvailable(String algorithm) throws Exception {
        Method method = DigestUtils.class.getDeclaredMethod("isAvailable", String.class);
        method.setAccessible(true);
        return (boolean) method.invoke(null, algorithm);
    }
}
