package org.apache.commons.compress.archivers.tar;

import org.apache.commons.compress.archivers.tar.TarArchiveEntry;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import java.io.File;
import java.io.IOException;
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

class TarArchiveEntry_TarArchiveEntry_118_0_Test {

    @Test
    void testConstructorWithValidParameters() {
        String name = "testFile.txt";
        // Assuming LF_NORMAL
        byte linkFlag = 0;
        boolean preserveAbsolutePath = false;
        TarArchiveEntry entry = new TarArchiveEntry(name, linkFlag, preserveAbsolutePath);
        assertEquals(name, entry.getName());
        assertEquals(linkFlag, entry.getLinkFlag());
        assertFalse(entry.getUserName().isEmpty());
    }

    @Test
    void testConstructorWithGnuLongName() {
        String name = "testFile.txt";
        // Assuming this constant exists
        byte linkFlag = TarArchiveEntry.LF_GNUTYPE_LONGNAME;
        boolean preserveAbsolutePath = true;
        TarArchiveEntry entry = new TarArchiveEntry(name, linkFlag, preserveAbsolutePath);
        assertEquals(name, entry.getName());
        assertEquals(linkFlag, entry.getLinkFlag());
        assertFalse(entry.getUserName().isEmpty());
    }

    @Test
    void testConstructorWithEmptyName() {
        String name = "";
        // Assuming LF_NORMAL
        byte linkFlag = 0;
        boolean preserveAbsolutePath = false;
        TarArchiveEntry entry = new TarArchiveEntry(name, linkFlag, preserveAbsolutePath);
        assertEquals(name, entry.getName());
        assertEquals(linkFlag, entry.getLinkFlag());
    }

    @Test
    void testConstructorWithNullName() {
        String name = null;
        // Assuming LF_NORMAL
        byte linkFlag = 0;
        boolean preserveAbsolutePath = false;
        TarArchiveEntry entry = new TarArchiveEntry(name, linkFlag, preserveAbsolutePath);
        assertNull(entry.getName());
        assertEquals(linkFlag, entry.getLinkFlag());
    }

    @Test
    void testConstructorWithInvalidLinkFlag() {
        String name = "testFile.txt";
        // Invalid link flag
        byte linkFlag = -1;
        boolean preserveAbsolutePath = false;
        TarArchiveEntry entry = new TarArchiveEntry(name, linkFlag, preserveAbsolutePath);
        assertEquals(name, entry.getName());
        assertEquals(linkFlag, entry.getLinkFlag());
    }

    @Test
    void testPrivateConstructor() throws NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException {
        Constructor<TarArchiveEntry> constructor = TarArchiveEntry.class.getDeclaredConstructor(boolean.class);
        constructor.setAccessible(true);
        TarArchiveEntry entry = constructor.newInstance(true);
        assertNotNull(entry);
    }
}
