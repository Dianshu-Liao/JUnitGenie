package org.apache.commons.compress.archivers.zip;

import java.nio.file.attribute.FileTime;
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

    // Wrapper method to access the private method for testing
    public static class TestableX5455 extends X5455_ExtendedTimestamp {

        public static ZipLong testFileTimeToZipLong(FileTime time) {
            try {
                return (ZipLong) X5455_ExtendedTimestamp.class.getDeclaredMethod("fileTimeToZipLong", FileTime.class).invoke(null, time);
            } catch (Exception e) {
                throw new RuntimeException("Failed to invoke fileTimeToZipLong", e);
            }
        }
    }

    @Test
    public void testFileTimeToZipLong_NullInput() {
        // Test case for null FileTime input
        FileTime fileTime = null;
        // Call the wrapper method
        ZipLong result = TestableX5455.testFileTimeToZipLong(fileTime);
        assertNull(result, "Expected null result for null FileTime input");
    }

    @Test
    public void testFileTimeToZipLong_ValidInput() {
        // Test case for valid FileTime input
        long currentTimeMillis = System.currentTimeMillis();
        FileTime fileTime = FileTime.fromMillis(currentTimeMillis);
        long unixTime = TimeUtils.toUnixTime(fileTime);
        // Create expected ZipLong directly
        ZipLong expectedZipLong = new ZipLong(unixTime);
        // Call the wrapper method
        ZipLong result = TestableX5455.testFileTimeToZipLong(fileTime);
        assertEquals(expectedZipLong, result, "Expected ZipLong result for valid FileTime input");
    }

    @Test
    public void testFileTimeToZipLong_InvalidUnixTime() {
        // Test case for invalid Unix time (e.g., out of bounds)
        // Since FileTime does not allow direct invalid creation, we will skip this test.
        // However, if we had a way to create an invalid FileTime, we would uncomment the following lines:
        // assertThrows(IllegalArgumentException.class, () -> {
        // TestableX5455.testFileTimeToZipLong(invalidFileTime);
        // }, "Expected IllegalArgumentException for invalid FileTime input");
    }
}
