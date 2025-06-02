package org.apache.commons.compress.archivers.cpio;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.lang.reflect.Method;
import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import java.io.EOFException;
import java.io.InputStream;
import org.apache.commons.compress.archivers.ArchiveInputStream;
import org.apache.commons.compress.archivers.zip.ZipEncoding;
import org.apache.commons.compress.archivers.zip.ZipEncodingHelper;
import org.apache.commons.compress.utils.ArchiveUtils;
import org.apache.commons.compress.utils.IOUtils;
import org.apache.commons.compress.utils.ParsingUtils;

public class CpioArchiveInputStream_readNewEntry_12_0_Test {

    private CpioArchiveInputStream cpioArchiveInputStream;

    @BeforeEach
    public void setUp() {
        byte[] inputBytes = new byte[] { (byte) 0x30, (byte) 0x32, (byte) 0x00, (byte) 0x00, (byte) 0x00, (byte) 0x00, (byte) 0x00, (byte) 0x00 };
        ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(inputBytes);
        cpioArchiveInputStream = new CpioArchiveInputStream(byteArrayInputStream);
    }

    @Test
    public void testReadNewEntry_WithCrc() throws Exception {
        Method method = CpioArchiveInputStream.class.getDeclaredMethod("readNewEntry", boolean.class);
        method.setAccessible(true);
        CpioArchiveEntry entry = (CpioArchiveEntry) method.invoke(cpioArchiveInputStream, true);
        assertEquals(CpioConstants.FORMAT_NEW_CRC, entry.getFormat());
    }

    @Test
    public void testReadNewEntry_WithoutCrc() throws Exception {
        Method method = CpioArchiveInputStream.class.getDeclaredMethod("readNewEntry", boolean.class);
        method.setAccessible(true);
        CpioArchiveEntry entry = (CpioArchiveEntry) method.invoke(cpioArchiveInputStream, false);
        assertEquals(CpioConstants.FORMAT_NEW, entry.getFormat());
    }

    @Test
    public void testReadNewEntry_ThrowsIOException_NegativeSize() throws Exception {
        byte[] inputBytes = new byte[] { (byte) 0x30, (byte) 0x32, (byte) 0x00, (byte) 0x00, (byte) 0xFF, (byte) 0xFF, (byte) 0xFF };
        ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(inputBytes);
        cpioArchiveInputStream = new CpioArchiveInputStream(byteArrayInputStream);
        Method method = CpioArchiveInputStream.class.getDeclaredMethod("readNewEntry", boolean.class);
        method.setAccessible(true);
        assertThrows(IOException.class, () -> {
            method.invoke(cpioArchiveInputStream, false);
        });
    }

    @Test
    public void testReadNewEntry_ThrowsIOException_NegativeNameLength() throws Exception {
        byte[] inputBytes = new byte[] { (byte) 0x30, (byte) 0x32, (byte) 0x00, (byte) 0x00, (byte) 0x00, (byte) 0x00, (byte) 0x00 };
        ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(inputBytes);
        cpioArchiveInputStream = new CpioArchiveInputStream(byteArrayInputStream);
        Method method = CpioArchiveInputStream.class.getDeclaredMethod("readNewEntry", boolean.class);
        method.setAccessible(true);
        assertThrows(IOException.class, () -> {
            method.invoke(cpioArchiveInputStream, true);
        });
    }
}
