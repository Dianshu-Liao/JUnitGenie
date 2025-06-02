package org.apache.commons.compress.archivers.cpio;

import org.apache.commons.compress.utils.IOUtils;
import java.io.ByteArrayInputStream;
import java.io.EOFException;
import java.io.IOException;
import java.lang.reflect.Method;
import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import java.io.InputStream;
import org.apache.commons.compress.archivers.ArchiveInputStream;
import org.apache.commons.compress.archivers.zip.ZipEncoding;
import org.apache.commons.compress.archivers.zip.ZipEncodingHelper;
import org.apache.commons.compress.utils.ArchiveUtils;
import org.apache.commons.compress.utils.ParsingUtils;

class CpioArchiveInputStream_readRange_15_0_Test {

    private CpioArchiveInputStream cpioArchiveInputStream;

    @BeforeEach
    void setUp() {
        byte[] data = "Test data for readRange method.".getBytes();
        ByteArrayInputStream inputStream = new ByteArrayInputStream(data);
        cpioArchiveInputStream = new CpioArchiveInputStream(inputStream);
    }

    private byte[] invokeReadRange(int length) throws Exception {
        Method method = CpioArchiveInputStream.class.getDeclaredMethod("readRange", int.class);
        method.setAccessible(true);
        return (byte[]) method.invoke(cpioArchiveInputStream, length);
    }

    @Test
    void testReadRange_ValidLength() throws Exception {
        byte[] result = invokeReadRange(10);
        assertNotNull(result);
        assertEquals(10, result.length);
        assertArrayEquals("Test data".getBytes(), result);
    }

    @Test
    void testReadRange_LengthLessThanInput() throws Exception {
        byte[] result = invokeReadRange(5);
        assertNotNull(result);
        assertEquals(5, result.length);
        assertArrayEquals("Test ".getBytes(), result);
    }

    @Test
    void testReadRange_ExactLength() throws Exception {
        byte[] result = invokeReadRange(32);
        assertNotNull(result);
        assertEquals(32, result.length);
        assertArrayEquals("Test data for readRange method.".getBytes(), result);
    }

    @Test
    void testReadRange_LengthGreaterThanInput() {
        assertThrows(EOFException.class, () -> {
            invokeReadRange(50);
        });
    }

    @Test
    void testReadRange_ZeroLength() throws Exception {
        byte[] result = invokeReadRange(0);
        assertNotNull(result);
        assertEquals(0, result.length);
    }

    @Test
    void testReadRange_NegativeLength() {
        assertThrows(IllegalArgumentException.class, () -> {
            invokeReadRange(-5);
        });
    }
}
