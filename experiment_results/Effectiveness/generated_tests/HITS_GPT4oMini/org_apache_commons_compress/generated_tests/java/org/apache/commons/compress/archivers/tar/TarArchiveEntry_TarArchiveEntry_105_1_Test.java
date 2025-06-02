package org.apache.commons.compress.archivers.tar;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
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
import org.apache.commons.compress.archivers.zip.ZipEncoding;
import org.apache.commons.compress.utils.ArchiveUtils;
import org.apache.commons.compress.utils.IOUtils;
import org.apache.commons.compress.utils.ParsingUtils;
import org.apache.commons.compress.utils.TimeUtils;
import org.apache.commons.io.file.attribute.FileTimes;
import org.apache.commons.lang3.SystemProperties;

public class TarArchiveEntry_TarArchiveEntry_105_1_Test {

    @Test
    public void testTarArchiveEntryWithValidHeader() {
        // Example of a valid tar header
        byte[] validHeader = new byte[100];
        // Populate validHeader with valid tar header data (this is a placeholder)
        TarArchiveEntry entry = new TarArchiveEntry(validHeader);
        assertNotNull(entry);
    }

    @Test
    public void testTarArchiveEntryWithInvalidHeader() {
        // Example of an invalid tar header
        byte[] invalidHeader = new byte[100];
        // Populate invalidHeader with invalid tar header data (this is a placeholder)
        assertThrows(IOException.class, () -> {
            new TarArchiveEntry(invalidHeader);
        });
    }

    @Test
    public void testTarArchiveEntryWithNullHeader() {
        assertThrows(NullPointerException.class, () -> {
            new TarArchiveEntry((byte[]) null);
        });
    }

    @Test
    public void testTarArchiveEntryWithEmptyHeader() {
        byte[] emptyHeader = new byte[0];
        assertThrows(IOException.class, () -> {
            new TarArchiveEntry(emptyHeader);
        });
    }

    @Test
    public void testTarArchiveEntryNameInitialization() {
        String name = "testFile.txt";
        byte[] headerBuf = createHeaderWithName(name);
        TarArchiveEntry entry = new TarArchiveEntry(headerBuf);
        assertEquals(name, entry.getName());
    }

    @Test
    public void testTarArchiveEntryModeInitialization() {
        // Example mode
        byte[] headerBuf = createHeaderWithMode(0100644);
        TarArchiveEntry entry = new TarArchiveEntry(headerBuf);
        assertEquals(0100644, entry.getMode());
    }

    private byte[] createHeaderWithName(String name) {
        // Assuming 100 bytes for the header
        byte[] header = new byte[100];
        // Populate header with the name (this is a placeholder)
        byte[] nameBytes = name.getBytes(StandardCharsets.UTF_8);
        System.arraycopy(nameBytes, 0, header, 0, nameBytes.length);
        return header;
    }

    private byte[] createHeaderWithMode(int mode) {
        // Assuming 100 bytes for the header
        byte[] header = new byte[100];
        // Populate header with the mode (this is a placeholder)
        header[0] = (byte) (mode >> 24);
        header[1] = (byte) (mode >> 16);
        header[2] = (byte) (mode >> 8);
        header[3] = (byte) mode;
        return header;
    }
}
