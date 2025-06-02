package org.apache.commons.compress.archivers.zip;

import java.lang.reflect.Method;
import java.util.Date;
import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import java.nio.file.attribute.FileTime;
import java.util.Objects;
import java.util.zip.ZipException;
import org.apache.commons.io.file.attribute.FileTimes;

public class X000A_NTFS_dateToZip_0_0_Test {

    private X000A_NTFS x000A_ntfs;

    @BeforeEach
    public void setUp() {
        x000A_ntfs = new X000A_NTFS();
    }

    @Test
    public void testDateToZip_withValidDate() throws Exception {
        // Arrange
        // epoch time
        Date date = new Date(0);
        Method method = X000A_NTFS.class.getDeclaredMethod("dateToZip", Date.class);
        method.setAccessible(true);
        // Act
        ZipEightByteInteger result = (ZipEightByteInteger) method.invoke(x000A_ntfs, date);
        // Assert
        assertEquals(new ZipEightByteInteger(FileTimes.toNtfsTime(date)), result);
    }

    @Test
    public void testDateToZip_withNullDate() throws Exception {
        // Arrange
        Method method = X000A_NTFS.class.getDeclaredMethod("dateToZip", Date.class);
        method.setAccessible(true);
        // Act
        ZipEightByteInteger result = (ZipEightByteInteger) method.invoke(x000A_ntfs, (Date) null);
        // Assert
        assertNull(result);
    }
}
