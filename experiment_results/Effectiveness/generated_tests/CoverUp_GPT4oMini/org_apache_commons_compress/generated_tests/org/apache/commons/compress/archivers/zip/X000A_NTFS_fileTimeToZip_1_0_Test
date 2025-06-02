package org.apache.commons.compress.archivers.zip;

import java.nio.file.attribute.FileTime;
import java.lang.reflect.Method;
import org.apache.commons.compress.archivers.zip.ZipEightByteInteger;
import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import java.util.Date;
import java.util.Objects;
import java.util.zip.ZipException;
import org.apache.commons.io.file.attribute.FileTimes;

public class X000A_NTFS_fileTimeToZip_1_0_Test {

    private X000A_NTFS x000A_ntfs;

    @BeforeEach
    public void setUp() {
        x000A_ntfs = new X000A_NTFS();
    }

    @Test
    public void testFileTimeToZip_NullInput() throws Exception {
        // Invoke the private method fileTimeToZip with null
        Method method = X000A_NTFS.class.getDeclaredMethod("fileTimeToZip", FileTime.class);
        method.setAccessible(true);
        ZipEightByteInteger result = (ZipEightByteInteger) method.invoke(null, (FileTime) null);
        assertNull(result);
    }

    @Test
    public void testFileTimeToZip_ValidInput() throws Exception {
        // Create a valid FileTime instance
        FileTime fileTime = FileTime.fromMillis(System.currentTimeMillis());
        // Invoke the private method fileTimeToZip
        Method method = X000A_NTFS.class.getDeclaredMethod("fileTimeToZip", FileTime.class);
        method.setAccessible(true);
        ZipEightByteInteger result = (ZipEightByteInteger) method.invoke(null, fileTime);
        // Check the result is not null and matches expected value
        assertEquals(new ZipEightByteInteger(FileTimes.toNtfsTime(fileTime)), result);
    }
}
