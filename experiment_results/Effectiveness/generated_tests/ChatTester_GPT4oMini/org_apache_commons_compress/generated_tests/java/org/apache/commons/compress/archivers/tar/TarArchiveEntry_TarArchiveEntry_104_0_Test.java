// Test method
package org.apache.commons.compress.archivers.tar;

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

public class TarArchiveEntry_TarArchiveEntry_104_0_Test {

    private Constructor<TarArchiveEntry> constructor;

    @BeforeEach
    public void setUp() throws NoSuchMethodException {
        // Access the private constructor using reflection
        constructor = TarArchiveEntry.class.getDeclaredConstructor(boolean.class);
        constructor.setAccessible(true);
    }

    @Test
    public void testTarArchiveEntryWithPreserveAbsolutePathTrue() {
        try {
            TarArchiveEntry entry = constructor.newInstance(true);
            assertEquals(System.getProperty("user.name", "").substring(0, Math.min(System.getProperty("user.name", "").length(), TarArchiveEntry.MAX_NAMELEN)), entry.getUserName());
        } catch (InstantiationException | IllegalAccessException | InvocationTargetException e) {
            fail("Exception should not be thrown: " + e.getMessage());
        }
    }

    @Test
    public void testTarArchiveEntryWithPreserveAbsolutePathFalse() {
        try {
            TarArchiveEntry entry = constructor.newInstance(false);
            assertEquals(System.getProperty("user.name", "").substring(0, Math.min(System.getProperty("user.name", "").length(), TarArchiveEntry.MAX_NAMELEN)), entry.getUserName());
        } catch (InstantiationException | IllegalAccessException | InvocationTargetException e) {
            fail("Exception should not be thrown: " + e.getMessage());
        }
    }

    @Test
    public void testTarArchiveEntryUserNameLengthExceedsMax() {
        System.setProperty("user.name", "ThisUserNameIsDefinitelyLongerThanTheMaxLength");
        try {
            TarArchiveEntry entry = constructor.newInstance(true);
            assertEquals("ThisUserNameIsDefinitelyLongerThanTheMaxLength".substring(0, TarArchiveEntry.MAX_NAMELEN), entry.getUserName());
        } catch (InstantiationException | IllegalAccessException | InvocationTargetException e) {
            fail("Exception should not be thrown: " + e.getMessage());
        }
    }

    @Test
    public void testTarArchiveEntryUserNameDefault() {
        System.clearProperty("user.name");
        try {
            TarArchiveEntry entry = constructor.newInstance(true);
            assertEquals("", entry.getUserName());
        } catch (InstantiationException | IllegalAccessException | InvocationTargetException e) {
            fail("Exception should not be thrown: " + e.getMessage());
        }
    }
}
