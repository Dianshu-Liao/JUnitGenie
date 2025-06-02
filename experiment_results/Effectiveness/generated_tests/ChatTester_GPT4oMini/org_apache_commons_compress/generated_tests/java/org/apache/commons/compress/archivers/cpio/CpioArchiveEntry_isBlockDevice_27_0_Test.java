// Test method
package org.apache.commons.compress.archivers.cpio;

import java.lang.reflect.Field;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import java.io.File;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.LinkOption;
import java.nio.file.Path;
import java.nio.file.attribute.FileTime;
import java.util.Date;
import java.util.Objects;
import org.apache.commons.compress.archivers.ArchiveEntry;
import org.apache.commons.compress.utils.ExactMath;
import org.apache.commons.compress.utils.TimeUtils;

public class CpioArchiveEntry_isBlockDevice_27_0_Test {

    private CpioArchiveEntry entry;

    @BeforeEach
    public void setUp() {
        // Initialize with a default mode that is not a block device
        entry = new CpioArchiveEntry((short) 0, "testEntry");
        // Assuming mode 0 is not a block device
        setPrivateField(entry, "mode", 0);
    }

    @Test
    public void testIsBlockDeviceFalse() {
        // Test when mode is not a block device
        assertFalse(entry.isBlockDevice());
    }

    @Test
    public void testIsBlockDeviceTrue() throws Exception {
        // Test when mode is a block device
        // Fixed line
        setPrivateField(entry, "mode", CpioArchiveEntry.C_ISBLK);
        assertTrue(entry.isBlockDevice());
    }

    private void setPrivateField(Object obj, String fieldName, long value) {
        try {
            Field field = obj.getClass().getDeclaredField(fieldName);
            field.setAccessible(true);
            field.setLong(obj, value);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
