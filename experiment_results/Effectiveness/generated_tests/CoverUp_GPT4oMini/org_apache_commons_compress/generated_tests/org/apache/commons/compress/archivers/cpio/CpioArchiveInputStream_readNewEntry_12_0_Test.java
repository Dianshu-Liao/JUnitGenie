package org.apache.commons.compress.archivers.cpio;

import org.apache.commons.compress.archivers.cpio.CpioArchiveEntry;
import org.apache.commons.compress.archivers.cpio.CpioArchiveInputStream;
import org.apache.commons.compress.utils.ArchiveUtils;
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
import org.apache.commons.compress.utils.IOUtils;
import org.apache.commons.compress.utils.ParsingUtils;

public class CpioArchiveInputStream_readNewEntry_12_0_Test {

    private CpioArchiveInputStream cpioInputStream;

    @BeforeEach
    public void setUp() {
        // Initialize with a sample input stream
        byte[] sampleData = new byte[4096];
        ByteArrayInputStream inputStream = new ByteArrayInputStream(sampleData);
        cpioInputStream = new CpioArchiveInputStream(inputStream);
    }

    @Test
    public void testReadNewEntryWithCrc() throws Exception {
        byte[] inputData = createValidCpioEntryData(true);
        cpioInputStream = new CpioArchiveInputStream(new ByteArrayInputStream(inputData));
        CpioArchiveEntry entry = invokeReadNewEntry(cpioInputStream, true);
        assertNotNull(entry);
        assertEquals("expectedName", entry.getName());
        assertEquals(12345, entry.getSize());
    }

    @Test
    public void testReadNewEntryWithoutCrc() throws Exception {
        byte[] inputData = createValidCpioEntryData(false);
        cpioInputStream = new CpioArchiveInputStream(new ByteArrayInputStream(inputData));
        CpioArchiveEntry entry = invokeReadNewEntry(cpioInputStream, false);
        assertNotNull(entry);
        assertEquals("expectedName", entry.getName());
        assertEquals(12345, entry.getSize());
    }

    @Test
    public void testReadNewEntryWithNegativeSize() {
        byte[] inputData = createInvalidCpioEntryDataWithNegativeSize();
        cpioInputStream = new CpioArchiveInputStream(new ByteArrayInputStream(inputData));
        assertThrows(IOException.class, () -> {
            invokeReadNewEntry(cpioInputStream, false);
        });
    }

    @Test
    public void testReadNewEntryWithInvalidNameSize() {
        byte[] inputData = createInvalidCpioEntryDataWithInvalidNameSize();
        cpioInputStream = new CpioArchiveInputStream(new ByteArrayInputStream(inputData));
        assertThrows(IOException.class, () -> {
            invokeReadNewEntry(cpioInputStream, false);
        });
    }

    private byte[] createValidCpioEntryData(boolean hasCrc) {
        // Construct valid CPIO entry data for testing
        return new byte[] {/* valid entry bytes */
        };
    }

    private byte[] createInvalidCpioEntryDataWithNegativeSize() {
        // Construct invalid CPIO entry data with a negative size
        return new byte[] {/* invalid entry bytes */
        };
    }

    private byte[] createInvalidCpioEntryDataWithInvalidNameSize() {
        // Construct invalid CPIO entry data with an invalid name size
        return new byte[] {/* invalid entry bytes */
        };
    }

    private CpioArchiveEntry invokeReadNewEntry(CpioArchiveInputStream stream, boolean hasCrc) throws Exception {
        Method method = CpioArchiveInputStream.class.getDeclaredMethod("readNewEntry", boolean.class);
        method.setAccessible(true);
        return (CpioArchiveEntry) method.invoke(stream, hasCrc);
    }
}
