package org.apache.commons.compress.archivers.tar;

import org.apache.commons.compress.archivers.tar.TarArchiveEntry;
import java.lang.reflect.Method;
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

class TarArchiveEntry_equals_5_0_Test {

    @Test
    void testEqualsWithNull() {
        TarArchiveEntry entry = new TarArchiveEntry("test");
        assertFalse(entry.equals(null));
    }

    @Test
    void testEqualsWithDifferentClass() {
        TarArchiveEntry entry = new TarArchiveEntry("test");
        assertFalse(entry.equals(new Object()));
    }

    @Test
    void testEqualsWithSameName() {
        TarArchiveEntry entry1 = new TarArchiveEntry("test");
        TarArchiveEntry entry2 = new TarArchiveEntry("test");
        assertTrue(entry1.equals(entry2));
    }

    @Test
    void testEqualsWithDifferentName() {
        TarArchiveEntry entry1 = new TarArchiveEntry("test1");
        TarArchiveEntry entry2 = new TarArchiveEntry("test2");
        assertFalse(entry1.equals(entry2));
    }

    @Test
    void testEqualsWithDifferentProperties() {
        TarArchiveEntry entry1 = new TarArchiveEntry("test");
        entry1.setUserName("user1");
        TarArchiveEntry entry2 = new TarArchiveEntry("test");
        entry2.setUserName("user2");
        // Should still be true as only name matters
        assertTrue(entry1.equals(entry2));
    }

    @Test
    void testEqualsWithSameObject() {
        TarArchiveEntry entry = new TarArchiveEntry("test");
        assertTrue(entry.equals(entry));
    }

    @Test
    void testPrivateEqualsMethod() throws Exception {
        TarArchiveEntry entry1 = new TarArchiveEntry("test");
        TarArchiveEntry entry2 = new TarArchiveEntry("test");
        Method privateEqualsMethod = TarArchiveEntry.class.getDeclaredMethod("equals", TarArchiveEntry.class);
        privateEqualsMethod.setAccessible(true);
        boolean result = (boolean) privateEqualsMethod.invoke(entry1, entry2);
        assertTrue(result);
    }
}
