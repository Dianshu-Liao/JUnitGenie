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

class X000A_NTFS_readTimeAttr_22_0_Test {

    private X000A_NTFS x000aNtfs;

    @BeforeEach
    void setUp() {
        x000aNtfs = new X000A_NTFS();
    }

    @Test
    void testReadTimeAttr_ValidData() throws Exception {
        byte[] data = new byte[26];
        // low byte
        data[0] = 0x18;
        // high byte
        data[1] = 0x00;
        for (int i = 0; i < 8; i++) {
            data[2 + i] = 0x00;
        }
        // modifyTime
        data[10] = 0x01;
        for (int i = 0; i < 8; i++) {
            data[10 + 2 + i] = 0x00;
        }
        // accessTime
        data[18] = 0x02;
        for (int i = 0; i < 8; i++) {
            data[18 + 2 + i] = 0x00;
        }
        // createTime
        data[26] = 0x03;
        Method method = X000A_NTFS.class.getDeclaredMethod("readTimeAttr", byte[].class, int.class, int.class);
        method.setAccessible(true);
        method.invoke(x000aNtfs, data, 0, data.length);
        assertEquals(1, x000aNtfs.getModifyTime().getValue());
        assertEquals(2, x000aNtfs.getAccessTime().getValue());
        assertEquals(3, x000aNtfs.getCreateTime().getValue());
    }

    @Test
    void testReadTimeAttr_InvalidTagLength() throws Exception {
        byte[] data = new byte[10];
        // low byte
        data[0] = 0x00;
        // high byte
        data[1] = 0x00;
        Method method = X000A_NTFS.class.getDeclaredMethod("readTimeAttr", byte[].class, int.class, int.class);
        method.setAccessible(true);
        method.invoke(x000aNtfs, data, 0, data.length);
        assertEquals(0, x000aNtfs.getModifyTime().getValue());
        assertEquals(0, x000aNtfs.getAccessTime().getValue());
        assertEquals(0, x000aNtfs.getCreateTime().getValue());
    }
}
