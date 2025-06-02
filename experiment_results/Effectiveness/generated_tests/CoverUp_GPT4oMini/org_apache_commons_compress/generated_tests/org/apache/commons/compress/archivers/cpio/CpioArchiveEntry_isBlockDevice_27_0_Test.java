package org.apache.commons.compress.archivers.cpio;

import org.apache.commons.compress.archivers.cpio.CpioArchiveEntry;
import org.apache.commons.compress.archivers.cpio.CpioUtil;
import java.lang.reflect.Method;
import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
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
        // Initialize with a default format
        entry = new CpioArchiveEntry((short) 0);
    }

    @Test
    public void testIsBlockDeviceWhenModeIsBlockDevice() throws Exception {
        // Set mode to block device (C_ISBLK)
        setPrivateField(entry, "mode", CpioConstants.C_ISBLK);
        assertTrue(entry.isBlockDevice());
    }

    @Test
    public void testIsBlockDeviceWhenModeIsNotBlockDevice() throws Exception {
        // Set mode to a regular file (C_ISREG)
        setPrivateField(entry, "mode", CpioConstants.C_ISREG);
        assertFalse(entry.isBlockDevice());
    }

    @Test
    public void testIsBlockDeviceWhenModeIsZero() throws Exception {
        // Set mode to zero (default case)
        setPrivateField(entry, "mode", 0);
        assertFalse(entry.isBlockDevice());
    }

    private void setPrivateField(Object obj, String fieldName, long value) throws Exception {
        java.lang.reflect.Field field = obj.getClass().getDeclaredField(fieldName);
        field.setAccessible(true);
        field.setLong(obj, value);
    }
}
