package org.apache.commons.compress.archivers.tar;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import static java.nio.charset.StandardCharsets.UTF_8;
import java.io.OutputStream;
import java.lang.reflect.Method;
import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import java.io.File;
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

public class TarArchiveOutputStream_handleLongName_18_0_Test {

    private TarArchiveOutputStream tarArchiveOutputStream;

    private ByteArrayOutputStream outputStream;

    @BeforeEach
    public void setUp() {
        outputStream = new ByteArrayOutputStream();
        tarArchiveOutputStream = new TarArchiveOutputStream(outputStream);
    }

    @Test
    public void testHandleLongName_PosixMode() throws Exception {
        TarArchiveEntry entry = new TarArchiveEntry("very_long_file_name_that_exceeds_the_maximum_length");
        tarArchiveOutputStream.setLongFileMode(TarArchiveOutputStream.LONGFILE_POSIX);
        Map<String, String> paxHeaders = new HashMap<>();
        boolean result = invokeHandleLongName(entry, "very_long_file_name_that_exceeds_the_maximum_length", paxHeaders, "path", (byte) 0, "file name");
        assertTrue(result);
        assertEquals("very_long_file_name_that_exceeds_the_maximum_length", paxHeaders.get("path"));
    }

    @Test
    public void testHandleLongName_GnuMode() throws Exception {
        TarArchiveEntry entry = new TarArchiveEntry("another_very_long_file_name_that_exceeds_the_maximum_length");
        tarArchiveOutputStream.setLongFileMode(TarArchiveOutputStream.LONGFILE_GNU);
        Map<String, String> paxHeaders = new HashMap<>();
        boolean result = invokeHandleLongName(entry, "another_very_long_file_name_that_exceeds_the_maximum_length", paxHeaders, "path", (byte) 0, "file name");
        assertFalse(result);
        // Check if data was written for long link
        assertTrue(outputStream.toByteArray().length > 0);
    }

    @Test
    public void testHandleLongName_ErrorMode() {
        TarArchiveEntry entry = new TarArchiveEntry("too_long_file_name_that_exceeds_the_maximum_length");
        tarArchiveOutputStream.setLongFileMode(TarArchiveOutputStream.LONGFILE_ERROR);
        Map<String, String> paxHeaders = new HashMap<>();
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            invokeHandleLongName(entry, "too_long_file_name_that_exceeds_the_maximum_length", paxHeaders, "path", (byte) 0, "file name");
        });
        String expectedMessage = "file name 'too_long_file_name_that_exceeds_the_maximum_length' is too long ( > " + TarConstants.NAMELEN + " bytes)";
        assertEquals(expectedMessage, exception.getMessage());
    }

    private boolean invokeHandleLongName(TarArchiveEntry entry, String name, Map<String, String> paxHeaders, String paxHeaderName, byte linkType, String fieldName) throws Exception {
        Method method = TarArchiveOutputStream.class.getDeclaredMethod("handleLongName", TarArchiveEntry.class, String.class, Map.class, String.class, byte.class, String.class);
        method.setAccessible(true);
        return (boolean) method.invoke(tarArchiveOutputStream, entry, name, paxHeaders, paxHeaderName, linkType, fieldName);
    }
}
