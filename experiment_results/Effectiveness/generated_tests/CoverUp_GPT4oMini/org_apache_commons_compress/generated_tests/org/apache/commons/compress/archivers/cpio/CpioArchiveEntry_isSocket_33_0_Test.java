package org.apache.commons.compress.archivers.cpio;

import org.apache.commons.compress.archivers.cpio.CpioArchiveEntry;
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

class CpioArchiveEntry_isSocket_33_0_Test {

    private CpioArchiveEntry entry;

    @BeforeEach
    void setUp() {
        // Using a default format
        entry = new CpioArchiveEntry((short) 0);
    }

    @Test
    void testIsSocketReturnsTrue() throws Exception {
        // Set mode to C_ISSOCK
        setPrivateField(entry, "mode", CpioConstants.C_ISSOCK);
        Method method = CpioArchiveEntry.class.getDeclaredMethod("isSocket");
        method.setAccessible(true);
        boolean result = (boolean) method.invoke(entry);
        assertTrue(result);
    }

    @Test
    void testIsSocketReturnsFalse() throws Exception {
        // Set mode to a non-socket type
        // Regular file
        setPrivateField(entry, "mode", CpioConstants.C_ISREG);
        Method method = CpioArchiveEntry.class.getDeclaredMethod("isSocket");
        method.setAccessible(true);
        boolean result = (boolean) method.invoke(entry);
        assertFalse(result);
    }

    private void setPrivateField(CpioArchiveEntry entry, String fieldName, long value) throws Exception {
        java.lang.reflect.Field field = CpioArchiveEntry.class.getDeclaredField(fieldName);
        field.setAccessible(true);
        field.set(entry, value);
    }
}
