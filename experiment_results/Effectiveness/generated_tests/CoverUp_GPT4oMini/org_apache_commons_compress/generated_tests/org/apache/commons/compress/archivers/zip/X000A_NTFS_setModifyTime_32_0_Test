package org.apache.commons.compress.archivers.zip;

import org.apache.commons.compress.archivers.zip.ZipEightByteInteger;
import java.lang.reflect.Method;
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
    public void testSetModifyTimeWithNonNullValue() throws Exception {
        ZipEightByteInteger newTime = new ZipEightByteInteger(12345678L);
        x000A_ntfs.setModifyTime(newTime);
        // Using reflection to access the private field modifyTime
        Method getModifyTimeMethod = X000A_NTFS.class.getDeclaredMethod("getModifyTime");
        getModifyTimeMethod.setAccessible(true);
        ZipEightByteInteger modifyTimeValue = (ZipEightByteInteger) getModifyTimeMethod.invoke(x000A_ntfs);
        assertEquals(newTime.getLongValue(), modifyTimeValue.getLongValue());
    }

    @Test
    public void testSetModifyTimeWithNullValue() throws Exception {
        x000A_ntfs.setModifyTime(null);
        // Using reflection to access the private field modifyTime
        Method getModifyTimeMethod = X000A_NTFS.class.getDeclaredMethod("getModifyTime");
        getModifyTimeMethod.setAccessible(true);
        ZipEightByteInteger modifyTimeValue = (ZipEightByteInteger) getModifyTimeMethod.invoke(x000A_ntfs);
        assertEquals(ZipEightByteInteger.ZERO.getLongValue(), modifyTimeValue.getLongValue());
    }
}
