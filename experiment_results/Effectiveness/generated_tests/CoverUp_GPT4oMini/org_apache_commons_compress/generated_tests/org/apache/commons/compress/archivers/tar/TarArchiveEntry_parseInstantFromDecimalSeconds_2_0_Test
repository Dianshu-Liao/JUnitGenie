package org.apache.commons.compress.archivers.tar;

import java.io.IOException;
import java.lang.reflect.Method;
import java.math.BigDecimal;
import java.time.Instant;
import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import java.io.File;
import java.io.UncheckedIOException;
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

    @Test
    public void testParseInstantFromDecimalSeconds_ValidInput() throws Exception {
        // Represents a valid Instant
        String decimalSeconds = "1610000000.123456789";
        Instant expectedInstant = Instant.ofEpochSecond(1610000000L, 123456789);
        Instant result = invokeParseInstantFromDecimalSeconds(decimalSeconds);
        assertEquals(expectedInstant, result);
    }

    @Test
    public void testParseInstantFromDecimalSeconds_InvalidInput() {
        // Not a valid decimal
        String invalidInput = "invalid";
        assertThrows(IOException.class, () -> invokeParseInstantFromDecimalSeconds(invalidInput));
    }

    @Test
    public void testParseInstantFromDecimalSeconds_Overflow() {
        // Exceeds the maximum Instant
        String overflowInput = "9999999999999999999.999999999";
        assertThrows(IOException.class, () -> invokeParseInstantFromDecimalSeconds(overflowInput));
    }

    @Test
    public void testParseInstantFromDecimalSeconds_NegativeInput() throws Exception {
        // Represents a valid Instant
        String negativeInput = "-1610000000.123456789";
        Instant expectedInstant = Instant.ofEpochSecond(-1610000000L, 123456789);
        Instant result = invokeParseInstantFromDecimalSeconds(negativeInput);
        assertEquals(expectedInstant, result);
    }

    private Instant invokeParseInstantFromDecimalSeconds(String value) throws Exception {
        Method method = TarArchiveEntry.class.getDeclaredMethod("parseInstantFromDecimalSeconds", String.class);
        method.setAccessible(true);
        return (Instant) method.invoke(null, value);
    }
}
