// Test method
package org.apache.commons.compress.archivers.cpio;

import java.io.ByteArrayInputStream;
import java.io.EOFException;
import java.io.IOException;
import java.io.InputStream;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.apache.commons.compress.archivers.ArchiveInputStream;
import org.apache.commons.compress.archivers.zip.ZipEncoding;
import org.apache.commons.compress.archivers.zip.ZipEncodingHelper;
import org.apache.commons.compress.utils.ArchiveUtils;
import org.apache.commons.compress.utils.IOUtils;
import org.apache.commons.compress.utils.ParsingUtils;
import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

public class CpioArchiveInputStream_readRange_15_1_Test {

    private CpioArchiveInputStream cpioArchiveInputStream;

    @BeforeEach
    public void setUp() {
        InputStream in = new ByteArrayInputStream(new byte[] { 0, 1, 2, 3, 4, 5, 6, 7, 8, 9 });
        cpioArchiveInputStream = new CpioArchiveInputStream(in, 5);
    }

    @Test
    public void testReadRangeSuccessful() throws Exception {
        byte[] result = invokeReadRange(5);
        byte[] expected = new byte[] { 0, 1, 2, 3, 4 };
        assertArrayEquals(expected, result);
    }

    @Test
    public void testReadRangeEOFException() {
        assertThrows(EOFException.class, () -> invokeReadRange(15));
    }

    private byte[] invokeReadRange(int len) throws Exception {
        // Fixed Buggy Line
        java.lang.reflect.Method method = CpioArchiveInputStream.class.getDeclaredMethod("readRange", int.class);
        method.setAccessible(true);
        return (byte[]) method.invoke(cpioArchiveInputStream, len);
    }
}
