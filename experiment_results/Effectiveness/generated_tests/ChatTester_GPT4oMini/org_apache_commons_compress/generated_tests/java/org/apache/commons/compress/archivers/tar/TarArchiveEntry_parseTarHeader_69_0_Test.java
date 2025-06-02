package org.apache.commons.compress.archivers.tar;

import java.io.IOException;
import java.lang.reflect.Method;
import java.nio.charset.StandardCharsets;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
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

@ExtendWith(MockitoExtension.class)
public class TarArchiveEntry_parseTarHeader_69_0_Test {

    private TarArchiveEntry tarArchiveEntry;

    @Mock
    private ZipEncoding zipEncodingMock;

    @BeforeEach
    public void setUp() {
        // Correcting the constructor call to use a valid byte array
        tarArchiveEntry = new TarArchiveEntry(new byte[0]);
    }

    @Test
    public void testParseTarHeader_ValidInput() throws Exception {
        byte[] header = "ValidHeaderData".getBytes(StandardCharsets.UTF_8);
        // Invoke the private method using reflection
        Method method = TarArchiveEntry.class.getDeclaredMethod("parseTarHeader", byte[].class, ZipEncoding.class, boolean.class, boolean.class);
        method.setAccessible(true);
        // Call the method
        assertDoesNotThrow(() -> method.invoke(tarArchiveEntry, header, zipEncodingMock, false, false));
    }

    @Test
    public void testParseTarHeader_NullHeader() throws Exception {
        // Invoke the private method using reflection
        Method method = TarArchiveEntry.class.getDeclaredMethod("parseTarHeader", byte[].class, ZipEncoding.class, boolean.class, boolean.class);
        method.setAccessible(true);
        // Call the method and expect an exception
        assertThrows(IOException.class, () -> method.invoke(tarArchiveEntry, null, zipEncodingMock, false, false));
    }

    @Test
    public void testParseTarHeader_EmptyHeader() throws Exception {
        byte[] header = new byte[0];
        // Invoke the private method using reflection
        Method method = TarArchiveEntry.class.getDeclaredMethod("parseTarHeader", byte[].class, ZipEncoding.class, boolean.class, boolean.class);
        method.setAccessible(true);
        // Call the method and expect an exception
        assertThrows(IOException.class, () -> method.invoke(tarArchiveEntry, header, zipEncodingMock, false, false));
    }

    @Test
    public void testParseTarHeader_OldStyleTrue() throws Exception {
        byte[] header = "OldStyleHeaderData".getBytes(StandardCharsets.UTF_8);
        // Invoke the private method using reflection
        Method method = TarArchiveEntry.class.getDeclaredMethod("parseTarHeader", byte[].class, ZipEncoding.class, boolean.class, boolean.class);
        method.setAccessible(true);
        // Call the method and ensure it does not throw an exception
        assertDoesNotThrow(() -> method.invoke(tarArchiveEntry, header, zipEncodingMock, true, false));
    }

    @Test
    public void testParseTarHeader_LenientTrue() throws Exception {
        byte[] header = "LenientHeaderData".getBytes(StandardCharsets.UTF_8);
        // Invoke the private method using reflection
        Method method = TarArchiveEntry.class.getDeclaredMethod("parseTarHeader", byte[].class, ZipEncoding.class, boolean.class, boolean.class);
        method.setAccessible(true);
        // Call the method and ensure it does not throw an exception
        assertDoesNotThrow(() -> method.invoke(tarArchiveEntry, header, zipEncodingMock, false, true));
    }
}
