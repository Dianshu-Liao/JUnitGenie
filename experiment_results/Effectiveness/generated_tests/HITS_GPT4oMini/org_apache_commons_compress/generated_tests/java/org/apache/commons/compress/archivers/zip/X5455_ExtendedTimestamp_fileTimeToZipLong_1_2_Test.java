package org.apache.commons.compress.archivers.zip;

import org.apache.commons.compress.utils.TimeUtils;
import java.nio.file.attribute.FileTime;
import java.lang.reflect.Method;
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

public class X5455_ExtendedTimestamp_fileTimeToZipLong_1_2_Test {

    private Method fileTimeToZipLongMethod;

    @BeforeEach
    public void setUp() throws NoSuchMethodException {
        fileTimeToZipLongMethod = X5455_ExtendedTimestamp.class.getDeclaredMethod("fileTimeToZipLong", FileTime.class);
        // Allow access to the private method
        fileTimeToZipLongMethod.setAccessible(true);
    }

    @Test
    public void testFileTimeToZipLong_NullInput() throws Exception {
        // Test with null FileTime
        FileTime input = null;
        ZipLong result = (ZipLong) fileTimeToZipLongMethod.invoke(null, input);
        assertNull(result, "Expected null ZipLong for null FileTime input");
    }

    @Test
    public void testFileTimeToZipLong_ValidFileTime() throws Exception {
        // Test with a valid FileTime
        long currentTimeMillis = System.currentTimeMillis();
        FileTime input = FileTime.fromMillis(currentTimeMillis);
        ZipLong result = (ZipLong) fileTimeToZipLongMethod.invoke(null, input);
        long expectedUnixTime = TimeUtils.toUnixTime(input);
        assertEquals(new ZipLong(expectedUnixTime), result, "Expected ZipLong to match the Unix time converted from FileTime");
    }

    @Test
    public void testFileTimeToZipLong_MinimumFileTime() throws Exception {
        // Test with minimum FileTime
        FileTime input = FileTime.fromMillis(Long.MIN_VALUE);
        ZipLong result = (ZipLong) fileTimeToZipLongMethod.invoke(null, input);
        long expectedUnixTime = TimeUtils.toUnixTime(input);
        assertEquals(new ZipLong(expectedUnixTime), result, "Expected ZipLong to match the Unix time converted from minimum FileTime");
    }

    @Test
    public void testFileTimeToZipLong_MaximumFileTime() throws Exception {
        // Test with maximum FileTime
        FileTime input = FileTime.fromMillis(Long.MAX_VALUE);
        ZipLong result = (ZipLong) fileTimeToZipLongMethod.invoke(null, input);
        long expectedUnixTime = TimeUtils.toUnixTime(input);
        assertEquals(new ZipLong(expectedUnixTime), result, "Expected ZipLong to match the Unix time converted from maximum FileTime");
    }
}
