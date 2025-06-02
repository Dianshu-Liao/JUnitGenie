package org.apache.commons.compress.archivers.tar;

import java.io.IOException;
import java.lang.reflect.Method;
import java.math.BigDecimal;
import java.time.Instant;
import java.time.DateTimeException;
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
        // Arrange
        // Represents a valid timestamp
        String validInput = "1625078400.123456789";
        Method method = TarArchiveEntry.class.getDeclaredMethod("parseInstantFromDecimalSeconds", String.class);
        method.setAccessible(true);
        // Act
        Instant result = (Instant) method.invoke(null, validInput);
        // Assert
        assertNotNull(result);
        assertEquals(1625078400, result.getEpochSecond());
        assertEquals(123456789, result.getNano());
    }

    @Test
    public void testParseInstantFromDecimalSeconds_InvalidInput() throws Exception {
        // Arrange
        String invalidInput = "invalid_timestamp";
        Method method = TarArchiveEntry.class.getDeclaredMethod("parseInstantFromDecimalSeconds", String.class);
        method.setAccessible(true);
        // Act & Assert
        IOException thrown = assertThrows(IOException.class, () -> {
            method.invoke(null, invalidInput);
        });
        assertTrue(thrown.getMessage().contains("Corrupted PAX header. Time field value is invalid"));
    }

    @Test
    public void testParseInstantFromDecimalSeconds_OverflowInput() throws Exception {
        // Arrange
        // Exceeds long value
        String overflowInput = "99999999999999999999999999999999999999999999";
        Method method = TarArchiveEntry.class.getDeclaredMethod("parseInstantFromDecimalSeconds", String.class);
        method.setAccessible(true);
        // Act & Assert
        IOException thrown = assertThrows(IOException.class, () -> {
            method.invoke(null, overflowInput);
        });
        assertTrue(thrown.getMessage().contains("Corrupted PAX header. Time field value is invalid"));
    }

    @Test
    public void testParseInstantFromDecimalSeconds_NegativeInput() throws Exception {
        // Arrange
        // Represents a valid negative timestamp
        String negativeInput = "-1625078400.123456789";
        Method method = TarArchiveEntry.class.getDeclaredMethod("parseInstantFromDecimalSeconds", String.class);
        method.setAccessible(true);
        // Act
        Instant result = (Instant) method.invoke(null, negativeInput);
        // Assert
        assertNotNull(result);
        assertEquals(-1625078400, result.getEpochSecond());
        assertEquals(123456789, result.getNano());
    }

    @Test
    public void testParseInstantFromDecimalSeconds_ZeroInput() throws Exception {
        // Arrange
        // Represents the epoch
        String zeroInput = "0";
        Method method = TarArchiveEntry.class.getDeclaredMethod("parseInstantFromDecimalSeconds", String.class);
        method.setAccessible(true);
        // Act
        Instant result = (Instant) method.invoke(null, zeroInput);
        // Assert
        assertNotNull(result);
        assertEquals(0, result.getEpochSecond());
        assertEquals(0, result.getNano());
    }

    @Test
    public void testParseInstantFromDecimalSeconds_NegativeDecimalInput() throws Exception {
        // Arrange
        // Represents a negative timestamp
        String negativeDecimalInput = "-1.123456789";
        Method method = TarArchiveEntry.class.getDeclaredMethod("parseInstantFromDecimalSeconds", String.class);
        method.setAccessible(true);
        // Act
        Instant result = (Instant) method.invoke(null, negativeDecimalInput);
        // Assert
        assertNotNull(result);
        assertEquals(-1, result.getEpochSecond());
        assertEquals(123456789, result.getNano());
    }
}
