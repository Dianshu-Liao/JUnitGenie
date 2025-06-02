package org.apache.commons.compress.archivers.zip;

import java.nio.file.attribute.FileTime;
import java.lang.reflect.Method;
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
        // Arrange
        FileTime time = null;
        // Act
        ZipEightByteInteger result = invokeFileTimeToZip(time);
        // Assert
        assertNull(result);
    }

    @Test
    public void testFileTimeToZip_ValidInput() throws Exception {
        // Arrange
        FileTime time = FileTime.fromMillis(System.currentTimeMillis());
        // Act
        ZipEightByteInteger result = invokeFileTimeToZip(time);
        // Assert
        assertEquals(new ZipEightByteInteger(FileTimes.toNtfsTime(time)), result);
    }

    private ZipEightByteInteger invokeFileTimeToZip(FileTime time) throws Exception {
        Method method = X000A_NTFS.class.getDeclaredMethod("fileTimeToZip", FileTime.class);
        method.setAccessible(true);
        return (ZipEightByteInteger) method.invoke(null, time);
    }
}
