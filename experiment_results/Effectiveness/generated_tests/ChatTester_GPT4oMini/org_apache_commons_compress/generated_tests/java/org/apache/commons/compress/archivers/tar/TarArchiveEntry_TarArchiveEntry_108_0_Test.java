// Test method
package org.apache.commons.compress.archivers.tar;

import java.io.IOException;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import java.io.File;
import java.io.UncheckedIOException;
import java.math.BigDecimal;
import java.nio.file.DirectoryStream;
import java.nio.file.Files;
import java.nio.file.LinkOption;
import java.nio.file.Path;
import java.nio.file.attribute.BasicFileAttributes;
import java.nio.file.attribute.DosFileAttributes;
import java.nio.file.attribute.FileTime;
import java.nio.file.attribute.PosixFileAttributes;
import java.time.DateTimeException;
import java.time.Instant;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import org.apache.commons.compress.archivers.ArchiveEntry;
import org.apache.commons.compress.archivers.EntryStreamOffsets;
import org.apache.commons.compress.archivers.zip.ZipEncoding;
import org.apache.commons.compress.utils.ArchiveUtils;
import org.apache.commons.compress.utils.IOUtils;
import org.apache.commons.compress.utils.ParsingUtils;
import org.apache.commons.compress.utils.TimeUtils;
import org.apache.commons.io.file.attribute.FileTimes;
import org.apache.commons.lang3.SystemProperties;
import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

class TarArchiveEntry_TarArchiveEntry_108_0_Test {

    private TarArchiveEntry tarArchiveEntry;

    private byte[] headerBuf;

    private ZipEncoding encoding;

    private boolean lenient;

    private long dataOffset;

    @BeforeEach
    void setUp() {
        // Initialize the byte array and other parameters for the test
        // Example header buffer
        headerBuf = new byte[] { 0, 1, 2, 3 };
        // Create a mock ZipEncoding since it's abstract and cannot be instantiated
        encoding = mock(ZipEncoding.class);
        // Example value for lenient
        lenient = true;
        // Example data offset
        dataOffset = 100L;
    }

    @Test
    void testTarArchiveEntryInitialization() throws IOException {
        // Create an instance of TarArchiveEntry using the focal method
        tarArchiveEntry = new TarArchiveEntry(headerBuf, encoding, lenient, dataOffset);
        // Verify that the TarArchiveEntry is initialized correctly
        assertNotNull(tarArchiveEntry);
        assertEquals(dataOffset, tarArchiveEntry.getDataOffset());
        // Additional assertions can be added here to check the state of tarArchiveEntry
    }

    @Test
    void testSetDataOffset() throws Exception {
        // Use reflection to access the private setDataOffset method
        java.lang.reflect.Method setDataOffsetMethod = TarArchiveEntry.class.getDeclaredMethod("setDataOffset", long.class);
        setDataOffsetMethod.setAccessible(true);
        // Invoke the method to set data offset
        setDataOffsetMethod.invoke(tarArchiveEntry, dataOffset);
        // Verify that the dataOffset was set correctly
        long retrievedDataOffset = (long) TarArchiveEntry.class.getDeclaredMethod("getDataOffset").invoke(tarArchiveEntry);
        assertEquals(dataOffset, retrievedDataOffset);
    }

    @Test
    void testConstructorWithNegativeDataOffset() {
        long negativeDataOffset = -1L;
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            new TarArchiveEntry(headerBuf, encoding, lenient, negativeDataOffset);
        });
        String expectedMessage = "The offset cannot be smaller than 0";
        String actualMessage = exception.getMessage();
        assertTrue(actualMessage.contains(expectedMessage));
    }
}
