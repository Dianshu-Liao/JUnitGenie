// Test method
package org.apache.commons.compress.archivers.tar;

import java.io.IOException;
import java.nio.file.attribute.FileTime;
import java.lang.reflect.Field;
import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
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

public class TarArchiveEntry_TarArchiveEntry_116_0_Test {

    private TarArchiveEntry tarEntry;

    @BeforeEach
    public void setUp() {
        // Setup method to initialize TarArchiveEntry instances
    }

    @Test
    public void testConstructorWithDirectoryName() {
        String dirName = "testDir/";
        tarEntry = new TarArchiveEntry(dirName, true);
        assertEquals(dirName, invokeGetName(tarEntry));
        assertEquals(TarArchiveEntry.DEFAULT_DIR_MODE, invokeGetMode(tarEntry));
        assertEquals(TarArchiveEntry.LF_DIR, invokeGetLinkFlag(tarEntry));
        assertNotNull(invokeGetMTime(tarEntry));
    }

    @Test
    public void testConstructorWithFileName() {
        String fileName = "testFile.txt";
        tarEntry = new TarArchiveEntry(fileName, false);
        assertEquals(fileName, invokeGetName(tarEntry));
        assertEquals(TarArchiveEntry.DEFAULT_FILE_MODE, invokeGetMode(tarEntry));
        assertEquals(TarArchiveEntry.LF_NORMAL, invokeGetLinkFlag(tarEntry));
        assertNotNull(invokeGetMTime(tarEntry));
    }

    @Test
    public void testConstructorWithEmptyName() {
        String emptyName = "";
        tarEntry = new TarArchiveEntry(emptyName, false);
        assertEquals("", invokeGetName(tarEntry));
        assertEquals(TarArchiveEntry.DEFAULT_FILE_MODE, invokeGetMode(tarEntry));
        assertEquals(TarArchiveEntry.LF_NORMAL, invokeGetLinkFlag(tarEntry));
        assertNotNull(invokeGetMTime(tarEntry));
    }

    // Reflection methods to access private fields
    private String invokeGetName(TarArchiveEntry entry) {
        try {
            Field field = TarArchiveEntry.class.getDeclaredField("name");
            field.setAccessible(true);
            return (String) field.get(entry);
        } catch (Exception e) {
            fail("Reflection failed to access name field");
            return null;
        }
    }

    private int invokeGetMode(TarArchiveEntry entry) {
        try {
            Field field = TarArchiveEntry.class.getDeclaredField("mode");
            field.setAccessible(true);
            return (int) field.get(entry);
        } catch (Exception e) {
            fail("Reflection failed to access mode field");
            return -1;
        }
    }

    private byte invokeGetLinkFlag(TarArchiveEntry entry) {
        try {
            Field field = TarArchiveEntry.class.getDeclaredField("linkFlag");
            field.setAccessible(true);
            return (byte) field.get(entry);
        } catch (Exception e) {
            fail("Reflection failed to access linkFlag field");
            return -1;
        }
    }

    private FileTime invokeGetMTime(TarArchiveEntry entry) {
        try {
            Field field = TarArchiveEntry.class.getDeclaredField("mTime");
            field.setAccessible(true);
            return (FileTime) field.get(entry);
        } catch (Exception e) {
            fail("Reflection failed to access mTime field");
            return null;
        }
    }
}
