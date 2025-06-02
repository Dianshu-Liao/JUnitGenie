package org.apache.commons.compress.archivers.tar;

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

public class TarArchiveEntry_equals_5_0_Test {

    private TarArchiveEntry entry1;

    private TarArchiveEntry entry2;

    private TarArchiveEntry entry3;

    @BeforeEach
    public void setUp() {
        entry1 = new TarArchiveEntry("file1.txt");
        entry2 = new TarArchiveEntry("file1.txt");
        entry3 = new TarArchiveEntry("file2.txt");
    }

    @Test
    public void testEquals_SameObject() {
        assertTrue(entry1.equals(entry1), "An object should be equal to itself.");
    }

    @Test
    public void testEquals_NullObject() {
        assertFalse(entry1.equals(null), "An object should not be equal to null.");
    }

    @Test
    public void testEquals_DifferentClass() {
        assertFalse(entry1.equals("Not a TarArchiveEntry"), "An object should not be equal to an instance of another class.");
    }

    @Test
    public void testEquals_SameValues() {
        assertTrue(entry1.equals(entry2), "Two TarArchiveEntry objects with the same name should be equal.");
    }

    @Test
    public void testEquals_DifferentValues() {
        assertFalse(entry1.equals(entry3), "Two TarArchiveEntry objects with different names should not be equal.");
    }

    @Test
    public void testEquals_DifferentAttributes() {
        entry1.setSize(100);
        entry2.setSize(100);
        entry3.setSize(200);
        assertTrue(entry1.equals(entry2), "Two TarArchiveEntry objects with the same name and size should be equal.");
        assertFalse(entry1.equals(entry3), "Two TarArchiveEntry objects with different sizes should not be equal.");
    }
}
