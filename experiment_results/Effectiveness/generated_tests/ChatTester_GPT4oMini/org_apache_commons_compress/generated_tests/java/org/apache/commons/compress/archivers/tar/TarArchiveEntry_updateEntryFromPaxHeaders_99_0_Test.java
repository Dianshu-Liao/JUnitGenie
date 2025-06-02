package org.apache.commons.compress.archivers.tar;

import java.io.IOException;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;
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
import java.util.List;
import java.util.Locale;
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
import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

public class TarArchiveEntry_updateEntryFromPaxHeaders_99_0_Test {

    private TarArchiveEntry tarArchiveEntry;

    @BeforeEach
    public void setUp() {
        // Use a valid constructor for TarArchiveEntry
        tarArchiveEntry = new TarArchiveEntry("testEntry");
    }

    @Test
    public void testUpdateEntryFromPaxHeaders() throws Exception {
        // Prepare test data
        Map<String, String> headers = new HashMap<>();
        headers.put("user.name", "testUser");
        headers.put("group.name", "testGroup");
        headers.put("size", "12345");
        // Invoke the private method using reflection
        Method method = TarArchiveEntry.class.getDeclaredMethod("updateEntryFromPaxHeaders", Map.class);
        method.setAccessible(true);
        // Execute the method
        assertDoesNotThrow(() -> method.invoke(tarArchiveEntry, headers));
        // Check the expected state after method execution
        assertEquals("testUser", tarArchiveEntry.getUserName());
        assertEquals("testGroup", tarArchiveEntry.getGroupName());
        assertEquals(12345, tarArchiveEntry.getSize());
    }

    @Test
    public void testUpdateEntryFromPaxHeadersWithEmptyMap() throws Exception {
        // Prepare empty headers
        Map<String, String> headers = new HashMap<>();
        // Invoke the private method using reflection
        Method method = TarArchiveEntry.class.getDeclaredMethod("updateEntryFromPaxHeaders", Map.class);
        method.setAccessible(true);
        // Execute the method
        assertDoesNotThrow(() -> method.invoke(tarArchiveEntry, headers));
    }

    @Test
    public void testUpdateEntryFromPaxHeadersWithNull() throws Exception {
        // Invoke the private method using reflection
        Method method = TarArchiveEntry.class.getDeclaredMethod("updateEntryFromPaxHeaders", Map.class);
        method.setAccessible(true);
        assertThrows(NullPointerException.class, () -> method.invoke(tarArchiveEntry, (Object) null));
    }
}
