package org.apache.commons.compress.archivers.zip;

import java.io.IOException;
import java.lang.reflect.Method;
import java.nio.file.attribute.FileTime;
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
import org.apache.commons.compress.utils.TimeUtils;
import org.apache.commons.io.file.attribute.FileTimes;

public class X5455_ExtendedTimestamp_fileTimeToZipLong_1_0_Test {

    private X5455_ExtendedTimestamp instance;

    @BeforeEach
    public void setUp() {
        instance = new X5455_ExtendedTimestamp();
    }

    @Test
    public void testFileTimeToZipLong_NullInput() throws Exception {
        Method method = X5455_ExtendedTimestamp.class.getDeclaredMethod("fileTimeToZipLong", FileTime.class);
        method.setAccessible(true);
        ZipLong result = (ZipLong) method.invoke(instance, (FileTime) null);
        assertNull(result);
    }

    @Test
    public void testFileTimeToZipLong_ValidInput() throws Exception {
        Method method = X5455_ExtendedTimestamp.class.getDeclaredMethod("fileTimeToZipLong", FileTime.class);
        method.setAccessible(true);
        // Example timestamp
        FileTime fileTime = FileTime.fromMillis(1625074800000L);
        // Corresponding ZipLong
        ZipLong expected = unixTimeToZipLong(1625074800L);
        ZipLong result = (ZipLong) method.invoke(instance, fileTime);
        assertEquals(expected, result);
    }

    // Helper method to mimic the conversion from Unix time to ZipLong
    private ZipLong unixTimeToZipLong(long unixTime) {
        // Example conversion
        return new ZipLong(unixTime * 1000);
    }
}
