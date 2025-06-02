package org.apache.commons.compress.archivers.cpio;

import org.apache.commons.compress.archivers.cpio.CpioArchiveEntry;
import org.apache.commons.compress.archivers.cpio.CpioArchiveInputStream;
import org.apache.commons.compress.utils.ArchiveUtils;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import java.io.EOFException;
import java.lang.reflect.Method;
import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import org.apache.commons.compress.archivers.ArchiveInputStream;
import org.apache.commons.compress.archivers.zip.ZipEncoding;
import org.apache.commons.compress.archivers.zip.ZipEncodingHelper;
import org.apache.commons.compress.utils.IOUtils;
import org.apache.commons.compress.utils.ParsingUtils;

class CpioArchiveInputStream_readOldAsciiEntry_13_1_Test {

    private CpioArchiveInputStream cpioArchiveInputStream;

    private InputStream inputStream;

    @BeforeEach
    void setUp() {
        // Mock input stream data for a valid CPIO OLD ASCII entry
        byte[] validEntryData = new byte[] { 0x0A, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 't', 'e', 's', 't', 0x00 };
        inputStream = new ByteArrayInputStream(validEntryData);
        cpioArchiveInputStream = new CpioArchiveInputStream(inputStream);
    }

    @Test
    void testReadOldAsciiEntry() throws Exception {
        Method method = CpioArchiveInputStream.class.getDeclaredMethod("readOldAsciiEntry");
        method.setAccessible(true);
        CpioArchiveEntry entry = (CpioArchiveEntry) method.invoke(cpioArchiveInputStream);
        assertNotNull(entry);
        assertEquals("test", entry.getName());
        assertEquals(0x0A, entry.getDevice());
        assertEquals(0x00, entry.getInode());
        assertEquals(0x00, entry.getMode());
        assertEquals(0x00, entry.getUID());
        assertEquals(0x00, entry.getGID());
        assertEquals(0x00, entry.getNumberOfLinks());
        assertEquals(0x00, entry.getRemoteDevice());
        assertEquals(0x00, entry.getTime());
        assertEquals(0x00, entry.getSize());
    }
}
