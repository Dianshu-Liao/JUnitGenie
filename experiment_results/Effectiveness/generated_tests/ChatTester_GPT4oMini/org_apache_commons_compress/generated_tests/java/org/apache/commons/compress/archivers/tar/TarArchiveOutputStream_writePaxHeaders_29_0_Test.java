package org.apache.commons.compress.archivers.tar;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;
import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import static java.nio.charset.StandardCharsets.UTF_8;
import java.io.File;
import java.io.OutputStream;
import java.io.StringWriter;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.nio.ByteBuffer;
import java.nio.charset.StandardCharsets;
import java.nio.file.LinkOption;
import java.nio.file.Path;
import java.nio.file.attribute.FileTime;
import java.time.Instant;
import org.apache.commons.compress.archivers.ArchiveOutputStream;
import org.apache.commons.compress.archivers.zip.ZipEncoding;
import org.apache.commons.compress.archivers.zip.ZipEncodingHelper;
import org.apache.commons.compress.utils.FixedLengthBlockOutputStream;
import org.apache.commons.compress.utils.TimeUtils;
import org.apache.commons.io.Charsets;
import org.apache.commons.io.file.attribute.FileTimes;
import org.apache.commons.io.output.CountingOutputStream;
import org.apache.commons.lang3.ArrayFill;

class TarArchiveOutputStream_writePaxHeaders_29_0_Test {

    private TarArchiveOutputStream tarOutputStream;

    private ByteArrayOutputStream byteArrayOutputStream;

    @BeforeEach
    void setUp() {
        byteArrayOutputStream = new ByteArrayOutputStream();
        tarOutputStream = new TarArchiveOutputStream(byteArrayOutputStream);
    }

    @Test
    void testWritePaxHeaders_withValidEntry() throws Exception {
        // Arrange
        TarArchiveEntry entry = mock(TarArchiveEntry.class);
        String entryName = "validEntryName";
        Map<String, String> headers = new HashMap<>();
        headers.put("key1", "value1");
        headers.put("key2", "value2");
        // Use reflection to access the private method
        Method writePaxHeadersMethod = TarArchiveOutputStream.class.getDeclaredMethod("writePaxHeaders", TarArchiveEntry.class, String.class, Map.class);
        writePaxHeadersMethod.setAccessible(true);
        // Act
        writePaxHeadersMethod.invoke(tarOutputStream, entry, entryName, headers);
        // Assert
        byte[] output = byteArrayOutputStream.toByteArray();
        assertNotNull(output);
        // Ensure something was written
        assertTrue(output.length > 0);
        // Additional assertions can be made here to check the content of the byteArrayOutputStream
    }

    @Test
    void testWritePaxHeaders_entryNameTooLong() throws Exception {
        // Arrange
        TarArchiveEntry entry = mock(TarArchiveEntry.class);
        String entryName = "thisIsAReallyLongEntryNameThatExceedsTheLimitOfTarConstantsNAMELEN";
        Map<String, String> headers = new HashMap<>();
        Method writePaxHeadersMethod = TarArchiveOutputStream.class.getDeclaredMethod("writePaxHeaders", TarArchiveEntry.class, String.class, Map.class);
        writePaxHeadersMethod.setAccessible(true);
        // Act
        writePaxHeadersMethod.invoke(tarOutputStream, entry, entryName, headers);
        // Assert
        // Check that the name was truncated correctly
        // Additional assertions can be added here
    }

    @Test
    void testWritePaxHeaders_emptyHeaders() throws Exception {
        // Arrange
        TarArchiveEntry entry = mock(TarArchiveEntry.class);
        String entryName = "emptyHeadersEntry";
        Map<String, String> headers = new HashMap<>();
        Method writePaxHeadersMethod = TarArchiveOutputStream.class.getDeclaredMethod("writePaxHeaders", TarArchiveEntry.class, String.class, Map.class);
        writePaxHeadersMethod.setAccessible(true);
        // Act
        writePaxHeadersMethod.invoke(tarOutputStream, entry, entryName, headers);
        // Assert
        byte[] output = byteArrayOutputStream.toByteArray();
        assertNotNull(output);
        // Ensure something was written
        assertTrue(output.length > 0);
        // Additional assertions can be made here to check the content of the byteArrayOutputStream
    }

    @Test
    void testWritePaxHeaders_withSpecialCharacters() throws Exception {
        // Arrange
        TarArchiveEntry entry = mock(TarArchiveEntry.class);
        String entryName = "entryWithSpecialChars!@#$%^&*()";
        Map<String, String> headers = new HashMap<>();
        headers.put("key1", "value1");
        Method writePaxHeadersMethod = TarArchiveOutputStream.class.getDeclaredMethod("writePaxHeaders", TarArchiveEntry.class, String.class, Map.class);
        writePaxHeadersMethod.setAccessible(true);
        // Act
        writePaxHeadersMethod.invoke(tarOutputStream, entry, entryName, headers);
        // Assert
        byte[] output = byteArrayOutputStream.toByteArray();
        assertNotNull(output);
        // Ensure something was written
        assertTrue(output.length > 0);
        // Additional assertions can be made here to check the content of the byteArrayOutputStream
    }
}
