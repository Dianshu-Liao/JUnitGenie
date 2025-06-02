package org.apache.commons.compress.archivers.zip;

import java.lang.reflect.Method;
import java.nio.file.attribute.FileTime;
import java.util.concurrent.TimeUnit;
import org.apache.commons.io.file.attribute.FileTimes;
import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import java.util.Date;
import java.util.Objects;
import java.util.zip.ZipException;

public class X000A_NTFS_fileTimeToZip_1_0_Test {

    private ZipEightByteInteger invokeFileTimeToZip(FileTime time) throws Exception {
        Method method = X000A_NTFS.class.getDeclaredMethod("fileTimeToZip", FileTime.class);
        method.setAccessible(true);
        return (ZipEightByteInteger) method.invoke(null, time);
    }

    @Test
    public void testFileTimeToZip_NullInput() throws Exception {
        ZipEightByteInteger result = invokeFileTimeToZip(null);
        assertNull(result, "Expected null for null FileTime input");
    }

    @Test
    public void testFileTimeToZip_ValidFileTime() throws Exception {
        long currentTimeMillis = System.currentTimeMillis();
        FileTime fileTime = FileTime.from(currentTimeMillis, TimeUnit.MILLISECONDS);
        ZipEightByteInteger result = invokeFileTimeToZip(fileTime);
        long expectedNtfsTime = FileTimes.toNtfsTime(fileTime);
        assertEquals(expectedNtfsTime, result.getValue(), "Expected the NTFS time to match");
    }

    @Test
    public void testFileTimeToZip_EpochFileTime() throws Exception {
        FileTime fileTime = FileTime.fromMillis(0);
        ZipEightByteInteger result = invokeFileTimeToZip(fileTime);
        long expectedNtfsTime = FileTimes.toNtfsTime(fileTime);
        assertEquals(expectedNtfsTime, result.getValue(), "Expected the NTFS time for epoch to match");
    }

    @Test
    public void testFileTimeToZip_MaxFileTime() throws Exception {
        FileTime fileTime = FileTime.fromMillis(Long.MAX_VALUE);
        ZipEightByteInteger result = invokeFileTimeToZip(fileTime);
        long expectedNtfsTime = FileTimes.toNtfsTime(fileTime);
        assertEquals(expectedNtfsTime, result.getValue(), "Expected the NTFS time for maximum value to match");
    }
}
