package org.apache.commons.compress.archivers.zip;

import java.lang.reflect.Method;
import java.util.Date;
import org.apache.commons.compress.archivers.zip.ZipShort;
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

class X000A_NTFS_dateToZip_0_0_Test {

    private X000A_NTFS instance;

    @BeforeEach
    void setUp() {
        instance = new X000A_NTFS();
    }

    @Test
    void testDateToZip_NullDate() throws Exception {
        // Invoke the private method using reflection
        Method method = X000A_NTFS.class.getDeclaredMethod("dateToZip", Date.class);
        method.setAccessible(true);
        ZipEightByteInteger result = (ZipEightByteInteger) method.invoke(instance, (Object) null);
        assertNull(result);
    }

    @Test
    void testDateToZip_ValidDate() throws Exception {
        // Create a valid Date object
        // Epoch time for testing
        Date date = new Date(0);
        // Invoke the private method using reflection
        Method method = X000A_NTFS.class.getDeclaredMethod("dateToZip", Date.class);
        method.setAccessible(true);
        ZipEightByteInteger result = (ZipEightByteInteger) method.invoke(instance, date);
        // Assuming FileTimes.toNtfsTime(date) returns a long value
        long expectedNtfsTime = FileTimes.toNtfsTime(date);
        assertEquals(new ZipEightByteInteger(expectedNtfsTime), result);
    }
}
