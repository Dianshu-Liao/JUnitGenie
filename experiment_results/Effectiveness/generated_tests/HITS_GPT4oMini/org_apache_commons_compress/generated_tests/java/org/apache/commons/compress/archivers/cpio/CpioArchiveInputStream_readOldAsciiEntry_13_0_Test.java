package org.apache.commons.compress.archivers.cpio;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
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

class CpioArchiveInputStream_readOldAsciiEntry_13_0_Test {

    private CpioArchiveInputStream cpioInputStream;

    @BeforeEach
    void setUp() {
        // Mock input for CPIO format
        String mockCpioEntry = "07070100000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000";
        byte[] inputBytes = mockCpioEntry.getBytes(StandardCharsets.US_ASCII);
        ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(inputBytes);
        cpioInputStream = new CpioArchiveInputStream(byteArrayInputStream);
    }

    @Test
    void testReadOldAsciiEntry_validEntry() throws IOException {
        CpioArchiveEntry entry = cpioInputStream.getNextCPIOEntry();
        assertEquals(0, entry.getDevice());
        assertEquals(0, entry.getInode());
        assertEquals(0, entry.getMode());
        assertEquals(0, entry.getUID());
        assertEquals(0, entry.getGID());
        assertEquals(0, entry.getNumberOfLinks());
        assertEquals(0, entry.getRemoteDevice());
        assertEquals(0, entry.getTime());
        assertEquals(0, entry.getSize());
        assertEquals("", entry.getName());
    }

    @Test
    void testReadOldAsciiEntry_negativeNameSize() {
        String invalidCpioEntry = "07070100000000000000000000000000000000000000000000000000000000000000000000000000000000000000000001";
        byte[] inputBytes = invalidCpioEntry.getBytes(StandardCharsets.US_ASCII);
        ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(inputBytes);
        cpioInputStream = new CpioArchiveInputStream(byteArrayInputStream);
        assertThrows(IOException.class, () -> cpioInputStream.getNextCPIOEntry());
    }

    @Test
    void testReadOldAsciiEntry_negativeSize() {
        String invalidCpioEntry = "07070100000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000";
        byte[] inputBytes = invalidCpioEntry.getBytes(StandardCharsets.US_ASCII);
        ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(inputBytes);
        cpioInputStream = new CpioArchiveInputStream(byteArrayInputStream);
        assertThrows(IOException.class, () -> cpioInputStream.getNextCPIOEntry());
    }

    @Test
    void testReadOldAsciiEntry_modeZeroNotTrailer() {
        String invalidCpioEntry = "07070100000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000";
        byte[] inputBytes = invalidCpioEntry.getBytes(StandardCharsets.US_ASCII);
        ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(inputBytes);
        cpioInputStream = new CpioArchiveInputStream(byteArrayInputStream);
        assertThrows(IOException.class, () -> cpioInputStream.getNextCPIOEntry());
    }
}
