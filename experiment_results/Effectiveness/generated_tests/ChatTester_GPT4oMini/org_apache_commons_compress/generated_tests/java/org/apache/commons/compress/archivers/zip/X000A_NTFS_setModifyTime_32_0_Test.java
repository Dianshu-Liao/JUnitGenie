package org.apache.commons.compress.archivers.zip;

import java.lang.reflect.Field;
import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import java.nio.file.attribute.FileTime;
import java.util.Date;
import java.util.Objects;
import java.util.zip.ZipException;
import org.apache.commons.io.file.attribute.FileTimes;

public class X000A_NTFS_setModifyTime_32_0_Test {

    private X000A_NTFS x000A_ntfs;

    @BeforeEach
    public void setUp() {
        x000A_ntfs = new X000A_NTFS();
    }

    @Test
    public void testSetModifyTime_NonNullValue() throws Exception {
        ZipEightByteInteger testValue = new ZipEightByteInteger(123456789L);
        x000A_ntfs.setModifyTime(testValue);
        Field modifyTimeField = X000A_NTFS.class.getDeclaredField("modifyTime");
        modifyTimeField.setAccessible(true);
        ZipEightByteInteger modifyTime = (ZipEightByteInteger) modifyTimeField.get(x000A_ntfs);
        assertEquals(testValue, modifyTime);
    }

    @Test
    public void testSetModifyTime_NullValue() throws Exception {
        x000A_ntfs.setModifyTime(null);
        Field modifyTimeField = X000A_NTFS.class.getDeclaredField("modifyTime");
        modifyTimeField.setAccessible(true);
        ZipEightByteInteger modifyTime = (ZipEightByteInteger) modifyTimeField.get(x000A_ntfs);
        assertNotNull(modifyTime);
        assertEquals(ZipEightByteInteger.ZERO, modifyTime);
    }
}
