package org.apache.commons.compress.archivers.tar;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.lang.reflect.Method;
import java.nio.ByteBuffer;
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

class TarArchiveOutputStream_handleLongName_18_0_Test {

    private TarArchiveOutputStream tarArchiveOutputStream;

    private ByteArrayOutputStream outputStream;

    private TarArchiveEntry entry;

    @BeforeEach
    void setUp() {
        outputStream = new ByteArrayOutputStream();
        tarArchiveOutputStream = new TarArchiveOutputStream(outputStream);
        entry = new TarArchiveEntry("testFile.txt");
        tarArchiveOutputStream.setLongFileMode(TarArchiveOutputStream.LONGFILE_GNU);
    }

    private boolean invokeHandleLongName(TarArchiveEntry entry, String name, Map<String, String> paxHeaders, String paxHeaderName, byte linkType, String fieldName) throws Exception {
        Method method = TarArchiveOutputStream.class.getDeclaredMethod("handleLongName", TarArchiveEntry.class, String.class, Map.class, String.class, byte.class, String.class);
        method.setAccessible(true);
        return (boolean) method.invoke(tarArchiveOutputStream, entry, name, paxHeaders, paxHeaderName, linkType, fieldName);
    }

    @Test
    void testHandleLongName_WithLongName_GNU() throws Exception {
        Map<String, String> paxHeaders = new HashMap<>();
        String longName = "a_very_long_file_name_that_exceeds_the_limit_of_thirty_two_characters.txt";
        byte linkType = 0;
        boolean result = invokeHandleLongName(entry, longName, paxHeaders, "path", linkType, "file name");
        assertTrue(result);
        assertTrue(paxHeaders.containsKey("path"));
        assertEquals(longName, paxHeaders.get("path"));
    }

    @Test
    void testHandleLongName_WithShortName() throws Exception {
        Map<String, String> paxHeaders = new HashMap<>();
        String shortName = "short.txt";
        byte linkType = 0;
        boolean result = invokeHandleLongName(entry, shortName, paxHeaders, "path", linkType, "file name");
        assertFalse(result);
        assertFalse(paxHeaders.containsKey("path"));
    }

    @Test
    void testHandleLongName_WithLongName_Posix() throws Exception {
        tarArchiveOutputStream.setLongFileMode(TarArchiveOutputStream.LONGFILE_POSIX);
        Map<String, String> paxHeaders = new HashMap<>();
        String longName = "another_very_long_file_name_that_exceeds_limit.txt";
        byte linkType = 0;
        boolean result = invokeHandleLongName(entry, longName, paxHeaders, "path", linkType, "file name");
        assertTrue(result);
        assertTrue(paxHeaders.containsKey("path"));
        assertEquals(longName, paxHeaders.get("path"));
    }

    @Test
    void testHandleLongName_WithLongName_Error() {
        tarArchiveOutputStream.setLongFileMode(TarArchiveOutputStream.LONGFILE_ERROR);
        Map<String, String> paxHeaders = new HashMap<>();
        String longName = "this_name_is_way_too_long_for_the_tar_format.txt";
        byte linkType = 0;
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> {
            invokeHandleLongName(entry, longName, paxHeaders, "path", linkType, "file name");
        });
    }
}
