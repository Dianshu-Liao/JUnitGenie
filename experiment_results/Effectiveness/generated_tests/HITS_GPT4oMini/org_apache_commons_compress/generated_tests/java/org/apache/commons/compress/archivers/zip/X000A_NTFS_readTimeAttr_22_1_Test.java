package org.apache.commons.compress.archivers.zip;

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

public class X000A_NTFS_readTimeAttr_22_1_Test {

    private X000A_NTFS x000A_NTFS;

    @BeforeEach
    public void setUp() {
        x000A_NTFS = new X000A_NTFS();
    }

    @Test
    public void testReadTimeAttr_ValidData() throws Exception {
        byte[] data = new byte[26];
        ZipShort tag = new ZipShort(0x0001);
        System.arraycopy(tag.getBytes(), 0, data, 0, 2);
        long modifyTimeValue = 1622548800000L;
        long accessTimeValue = 1622548800000L;
        long createTimeValue = 1622548800000L;
        System.arraycopy(new ZipEightByteInteger(modifyTimeValue).getBytes(), 0, data, 2, 8);
        System.arraycopy(new ZipEightByteInteger(accessTimeValue).getBytes(), 0, data, 10, 8);
        System.arraycopy(new ZipEightByteInteger(createTimeValue).getBytes(), 0, data, 18, 8);
        Method method = X000A_NTFS.class.getDeclaredMethod("readTimeAttr", byte[].class, int.class, int.class);
        method.setAccessible(true);
        method.invoke(x000A_NTFS, data, 0, data.length);
        assertEquals(modifyTimeValue, x000A_NTFS.getModifyTime().getValue());
        assertEquals(accessTimeValue, x000A_NTFS.getAccessTime().getValue());
        assertEquals(createTimeValue, x000A_NTFS.getCreateTime().getValue());
    }

    @Test
    public void testReadTimeAttr_InvalidTagSize() throws Exception {
        byte[] data = new byte[10];
        ZipShort tag = new ZipShort(0x0001);
        System.arraycopy(tag.getBytes(), 0, data, 0, 2);
        Method method = X000A_NTFS.class.getDeclaredMethod("readTimeAttr", byte[].class, int.class, int.class);
        method.setAccessible(true);
        method.invoke(x000A_NTFS, data, 0, data.length);
        assertEquals(0, x000A_NTFS.getModifyTime().getValue());
        assertEquals(0, x000A_NTFS.getAccessTime().getValue());
        assertEquals(0, x000A_NTFS.getCreateTime().getValue());
    }
}
