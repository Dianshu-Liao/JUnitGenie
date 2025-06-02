package org.apache.commons.compress.archivers.zip;

import org.apache.commons.compress.archivers.zip.ZipShort;
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

public class X000A_NTFS_readTimeAttr_22_0_Test {

    private X000A_NTFS x000A_ntfs;

    @BeforeEach
    public void setUp() {
        x000A_ntfs = new X000A_NTFS();
    }

    @Test
    public void testReadTimeAttr_ValidData() throws Exception {
        byte[] data = new byte[30];
        ZipShort tag = new ZipShort(0x0001);
        // 2 bytes for tag + 2 bytes for size + 3 * 8 bytes for time values
        ZipShort size = new ZipShort(24);
        System.arraycopy(tag.getBytes(), 0, data, 0, 2);
        System.arraycopy(size.getBytes(), 0, data, 2, 2);
        // Mock time values for testing
        // Fill with appropriate test data
        byte[] mockModifyTime = new byte[8];
        // Fill with appropriate test data
        byte[] mockAccessTime = new byte[8];
        // Fill with appropriate test data
        byte[] mockCreateTime = new byte[8];
        System.arraycopy(mockModifyTime, 0, data, 4, 8);
        System.arraycopy(mockAccessTime, 0, data, 12, 8);
        System.arraycopy(mockCreateTime, 0, data, 20, 8);
        // Invoke the private method using reflection
        Method method = X000A_NTFS.class.getDeclaredMethod("readTimeAttr", byte[].class, int.class, int.class);
        method.setAccessible(true);
        method.invoke(x000A_ntfs, data, 0, data.length);
        // Assert the values are set correctly
        assertEquals(mockModifyTime, x000A_ntfs.getModifyTime().getBytes());
        assertEquals(mockAccessTime, x000A_ntfs.getAccessTime().getBytes());
        assertEquals(mockCreateTime, x000A_ntfs.getCreateTime().getBytes());
    }

    @Test
    public void testReadTimeAttr_InvalidSize() throws Exception {
        // Not enough data to read time attributes
        byte[] data = new byte[10];
        Method method = X000A_NTFS.class.getDeclaredMethod("readTimeAttr", byte[].class, int.class, int.class);
        method.setAccessible(true);
        method.invoke(x000A_ntfs, data, 0, data.length);
        // Assert that the time attributes remain unchanged (ZERO)
        assertEquals(ZipEightByteInteger.ZERO, x000A_ntfs.getModifyTime());
        assertEquals(ZipEightByteInteger.ZERO, x000A_ntfs.getAccessTime());
        assertEquals(ZipEightByteInteger.ZERO, x000A_ntfs.getCreateTime());
    }

    @Test
    public void testReadTimeAttr_InvalidTag() throws Exception {
        byte[] data = new byte[30];
        ZipShort invalidTag = new ZipShort(0x0002);
        // 2 bytes for tag + 2 bytes for size + 3 * 8 bytes for time values
        ZipShort size = new ZipShort(24);
        System.arraycopy(invalidTag.getBytes(), 0, data, 0, 2);
        System.arraycopy(size.getBytes(), 0, data, 2, 2);
        // Mock time values for testing
        // Fill with appropriate test data
        byte[] mockModifyTime = new byte[8];
        // Fill with appropriate test data
        byte[] mockAccessTime = new byte[8];
        // Fill with appropriate test data
        byte[] mockCreateTime = new byte[8];
        System.arraycopy(mockModifyTime, 0, data, 4, 8);
        System.arraycopy(mockAccessTime, 0, data, 12, 8);
        System.arraycopy(mockCreateTime, 0, data, 20, 8);
        Method method = X000A_NTFS.class.getDeclaredMethod("readTimeAttr", byte[].class, int.class, int.class);
        method.setAccessible(true);
        method.invoke(x000A_ntfs, data, 0, data.length);
        // Assert that the time attributes remain unchanged (ZERO)
        assertEquals(ZipEightByteInteger.ZERO, x000A_ntfs.getModifyTime());
        assertEquals(ZipEightByteInteger.ZERO, x000A_ntfs.getAccessTime());
        assertEquals(ZipEightByteInteger.ZERO, x000A_ntfs.getCreateTime());
    }
}
