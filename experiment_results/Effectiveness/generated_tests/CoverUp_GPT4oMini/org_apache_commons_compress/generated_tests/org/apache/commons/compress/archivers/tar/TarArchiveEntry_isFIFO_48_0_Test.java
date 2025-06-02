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

public class TarArchiveEntry_isFIFO_48_0_Test {

    @Test
    public void testIsFIFO_whenLinkFlagIsFIFO_returnsTrue() throws Exception {
        // Assuming 0x01 represents LF_FIFO
        TarArchiveEntry entry = new TarArchiveEntry("fifoEntry", (byte) 0x01);
        Method isFIFO = TarArchiveEntry.class.getDeclaredMethod("isFIFO");
        isFIFO.setAccessible(true);
        boolean result = (boolean) isFIFO.invoke(entry);
        assertTrue(result);
    }

    @Test
    public void testIsFIFO_whenLinkFlagIsNotFIFO_returnsFalse() throws Exception {
        // Assuming 0x00 represents a normal file
        TarArchiveEntry entry = new TarArchiveEntry("normalFile", (byte) 0x00);
        Method isFIFO = TarArchiveEntry.class.getDeclaredMethod("isFIFO");
        isFIFO.setAccessible(true);
        boolean result = (boolean) isFIFO.invoke(entry);
        assertFalse(result);
    }

    @Test
    public void testIsFIFO_whenLinkFlagIsNull_returnsFalse() throws Exception {
        // Assuming 0x00 represents a normal file
        TarArchiveEntry entry = new TarArchiveEntry("nullLinkFlagEntry", (byte) 0x00);
        Method isFIFO = TarArchiveEntry.class.getDeclaredMethod("isFIFO");
        isFIFO.setAccessible(true);
        boolean result = (boolean) isFIFO.invoke(entry);
        assertFalse(result);
    }

    @Test
    public void testIsFIFO_whenLinkFlagIsSymbolicLink_returnsFalse() throws Exception {
        // Assuming 0x02 represents LF_SYMLINK
        TarArchiveEntry entry = new TarArchiveEntry("symlinkEntry", (byte) 0x02);
        Method isFIFO = TarArchiveEntry.class.getDeclaredMethod("isFIFO");
        isFIFO.setAccessible(true);
        boolean result = (boolean) isFIFO.invoke(entry);
        assertFalse(result);
    }
}
