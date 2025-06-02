package org.apache.commons.compress.archivers.tar;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import java.io.UncheckedIOException;
import java.math.BigDecimal;
import java.nio.file.DirectoryStream;
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

public class TarArchiveEntry_TarArchiveEntry_104_0_Test {

    @Test
    public void testConstructorWithPreserveAbsolutePathTrue() {
        TarArchiveEntry entry = new TarArchiveEntry("dummy", true);
        assertNotNull(entry);
        assertEquals("dummy", entry.getName());
        assertFalse(entry.getPath() != null);
    }

    @Test
    public void testConstructorWithPreserveAbsolutePathFalse() {
        TarArchiveEntry entry = new TarArchiveEntry("dummy", false);
        assertNotNull(entry);
        assertEquals("dummy", entry.getName());
        assertFalse(entry.getPath() != null);
    }

    @Test
    public void testConstructorWithNameAndPreserveAbsolutePath() {
        TarArchiveEntry entry = new TarArchiveEntry("testFile.txt", false);
        assertNotNull(entry);
        assertEquals("testFile.txt", entry.getName());
        assertEquals(TarArchiveEntry.DEFAULT_FILE_MODE, entry.getMode());
    }

    @Test
    public void testConstructorWithNameAndLinkFlag() {
        TarArchiveEntry entry = new TarArchiveEntry("testDir/", TarArchiveEntry.LF_DIR, false);
        assertNotNull(entry);
        assertEquals("testDir/", entry.getName());
        assertEquals(TarArchiveEntry.DEFAULT_DIR_MODE, entry.getMode());
        assertEquals(TarArchiveEntry.LF_DIR, entry.getLinkFlag());
    }

    @Test
    public void testConstructorWithFile() {
        File tempFile = new File("tempFile.txt");
        try {
            assertTrue(tempFile.createNewFile());
            TarArchiveEntry entry = new TarArchiveEntry(tempFile);
            assertNotNull(entry);
            assertEquals(tempFile.getName(), entry.getName());
            assertEquals(tempFile.length(), entry.getSize());
        } catch (IOException e) {
            fail("IOException should not have been thrown: " + e.getMessage());
        } finally {
            tempFile.delete();
        }
    }

    @Test
    public void testSetUserName() {
        TarArchiveEntry entry = new TarArchiveEntry("dummy", false);
        entry.setUserName("testUser");
        assertEquals("testUser", entry.getUserName());
    }

    @Test
    public void testSetGroupName() {
        TarArchiveEntry entry = new TarArchiveEntry("dummy", false);
        entry.setGroupName("testGroup");
        assertEquals("testGroup", entry.getGroupName());
    }

    @Test
    public void testSetSize() {
        TarArchiveEntry entry = new TarArchiveEntry("dummy", false);
        entry.setSize(1024);
        assertEquals(1024, entry.getSize());
    }

    @Test
    public void testSetMode() {
        TarArchiveEntry entry = new TarArchiveEntry("dummy", false);
        entry.setMode(TarArchiveEntry.DEFAULT_FILE_MODE);
    }
}
