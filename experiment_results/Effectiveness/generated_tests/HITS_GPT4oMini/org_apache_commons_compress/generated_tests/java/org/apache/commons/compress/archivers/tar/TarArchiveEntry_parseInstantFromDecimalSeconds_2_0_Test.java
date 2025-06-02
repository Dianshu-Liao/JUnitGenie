package org.apache.commons.compress.archivers.tar;

import java.io.IOException;
import java.lang.reflect.Method;
import java.time.Instant;
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
import java.nio.file.attribute.FileTime;
import java.nio.file.attribute.PosixFileAttributes;
import java.time.DateTimeException;
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

public class TarArchiveEntry_parseInstantFromDecimalSeconds_2_0_Test {

    private Instant invokeParseInstantFromDecimalSeconds(String input) throws Exception {
        Method method = TarArchiveEntry.class.getDeclaredMethod("parseInstantFromDecimalSeconds", String.class);
        method.setAccessible(true);
        return (Instant) method.invoke(null, input);
    }

    @Test
    public void testParseInstantFromDecimalSeconds_ValidIntegerSeconds() throws Exception {
        // Corresponds to 2021-10-01T00:00:00Z
        String input = "1633046400";
        Instant expected = Instant.ofEpochSecond(1633046400);
        Instant actual = invokeParseInstantFromDecimalSeconds(input);
        assertEquals(expected, actual);
    }

    @Test
    public void testParseInstantFromDecimalSeconds_ValidDecimalSeconds() throws Exception {
        // Corresponds to 2021-10-01T00:00:00.123456789Z
        String input = "1633046400.123456789";
        Instant expected = Instant.ofEpochSecond(1633046400, 123456789);
        Instant actual = invokeParseInstantFromDecimalSeconds(input);
        assertEquals(expected, actual);
    }

    @Test
    public void testParseInstantFromDecimalSeconds_NegativeSeconds() throws Exception {
        // Corresponds to a negative epoch time
        String input = "-1633046400";
        Instant expected = Instant.ofEpochSecond(-1633046400);
        Instant actual = invokeParseInstantFromDecimalSeconds(input);
        assertEquals(expected, actual);
    }

    @Test
    public void testParseInstantFromDecimalSeconds_InvalidFormat_ThrowsIOException() {
        String input = "invalid_format";
        IOException exception = assertThrows(IOException.class, () -> {
            invokeParseInstantFromDecimalSeconds(input);
        });
        assertEquals("Corrupted PAX header. Time field value is invalid 'invalid_format'", exception.getMessage());
    }
}
