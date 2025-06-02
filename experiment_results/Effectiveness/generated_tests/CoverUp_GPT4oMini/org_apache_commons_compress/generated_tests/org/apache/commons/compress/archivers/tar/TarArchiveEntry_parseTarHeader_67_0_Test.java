package org.apache.commons.compress.archivers.tar;

import org.apache.commons.compress.archivers.tar.TarArchiveEntry;
import org.apache.commons.compress.archivers.zip.ZipEncoding;
import java.io.IOException;
import java.lang.reflect.Method;
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
import org.apache.commons.compress.utils.ArchiveUtils;
import org.apache.commons.compress.utils.IOUtils;
import org.apache.commons.compress.utils.ParsingUtils;
import org.apache.commons.compress.utils.TimeUtils;
import org.apache.commons.io.file.attribute.FileTimes;
import org.apache.commons.lang3.SystemProperties;

class TarArchiveEntry_parseTarHeader_67_0_Test {

    @Test
    void testParseTarHeaderValid() throws Exception {
        // Arrange
        // Replace with actual valid TAR header bytes
        byte[] validHeader = new byte[100];
        TarArchiveEntry entry = new TarArchiveEntry(validHeader);
        // Act
        invokeParseTarHeader(entry, validHeader);
        // Assert
        // Add assertions to check the state of the entry after parsing
        // Example assertion
        assertNotNull(entry.getName());
    }

    @Test
    void testParseTarHeaderIOException() throws Exception {
        // Arrange
        // Replace with actual invalid TAR header bytes
        byte[] invalidHeader = new byte[100];
        TarArchiveEntry entry = new TarArchiveEntry(invalidHeader);
        // Act & Assert
        assertThrows(IOException.class, () -> invokeParseTarHeader(entry, invalidHeader));
    }

    @Test
    void testParseTarHeaderUncheckedIOException() throws Exception {
        // Arrange
        // Replace with actual invalid TAR header bytes
        byte[] invalidHeader = new byte[100];
        TarArchiveEntry entry = new TarArchiveEntry(invalidHeader);
        // Act & Assert
        assertThrows(UncheckedIOException.class, () -> invokeParseTarHeader(entry, invalidHeader));
    }

    private void invokeParseTarHeader(TarArchiveEntry entry, byte[] header) throws Exception {
        Method method = TarArchiveEntry.class.getDeclaredMethod("parseTarHeader", byte[].class);
        method.setAccessible(true);
        method.invoke(entry, (Object) header);
    }
}
