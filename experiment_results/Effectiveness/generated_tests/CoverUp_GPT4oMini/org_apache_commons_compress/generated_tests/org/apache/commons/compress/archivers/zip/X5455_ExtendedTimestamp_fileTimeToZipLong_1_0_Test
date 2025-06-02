package org.apache.commons.compress.archivers.zip;

import java.nio.file.attribute.FileTime;
import java.lang.reflect.Method;
import org.apache.commons.compress.archivers.zip.X5455_ExtendedTimestamp;
import org.apache.commons.compress.archivers.zip.ZipLong;
import org.apache.commons.compress.utils.TimeUtils;
import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import java.io.Serializable;
import java.util.Arrays;
import java.util.Date;
import java.util.Objects;
import java.util.zip.ZipException;
import org.apache.commons.io.file.attribute.FileTimes;

public class X5455_ExtendedTimestamp_fileTimeToZipLong_1_0_Test {

    private X5455_ExtendedTimestamp timestamp;

    @BeforeEach
    public void setUp() {
        timestamp = new X5455_ExtendedTimestamp();
    }

    @Test
    public void testFileTimeToZipLong_NullInput() throws Exception {
        Method method = X5455_ExtendedTimestamp.class.getDeclaredMethod("fileTimeToZipLong", FileTime.class);
        method.setAccessible(true);
        ZipLong result = (ZipLong) method.invoke(null, (FileTime) null);
        assertNull(result);
    }

    @Test
    public void testFileTimeToZipLong_ValidInput() throws Exception {
        Method method = X5455_ExtendedTimestamp.class.getDeclaredMethod("fileTimeToZipLong", FileTime.class);
        method.setAccessible(true);
        FileTime fileTime = FileTime.fromMillis(1000);
        ZipLong result = (ZipLong) method.invoke(null, fileTime);
        assertNotNull(result);
        // Assuming the conversion is correct
        assertEquals(1, result.getValue());
    }

    @Test
    public void testFileTimeToZipLong_InvalidInput() throws Exception {
        Method method = X5455_ExtendedTimestamp.class.getDeclaredMethod("fileTimeToZipLong", FileTime.class);
        method.setAccessible(true);
        // Create a FileTime that would lead to an invalid Unix timestamp
        // This will depend on your implementation of TimeUtils.toUnixTime
        // For example, if FileTimes.toUnixTime returns an invalid value
        FileTime fileTime = mock(FileTime.class);
        // Invalid for Unix time
        when(fileTime.toMillis()).thenReturn(Long.MAX_VALUE);
        assertThrows(IllegalArgumentException.class, () -> method.invoke(null, fileTime));
    }
}
