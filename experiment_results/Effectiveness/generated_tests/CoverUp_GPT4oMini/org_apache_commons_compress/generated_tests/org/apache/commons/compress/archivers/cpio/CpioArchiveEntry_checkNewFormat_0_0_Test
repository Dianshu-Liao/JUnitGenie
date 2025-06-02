package org.apache.commons.compress.archivers.cpio;

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

public class CpioArchiveEntry_checkNewFormat_0_0_Test {

    private CpioArchiveEntry entry;

    @BeforeEach
    public void setUp() {
        // Initialize with a format that will allow the method to pass
        // Assuming FORMAT_NEW_MASK is 1
        entry = new CpioArchiveEntry((short) 1);
    }

    @Test
    public void testCheckNewFormat_ValidFormat() throws Exception {
        // This should not throw an exception
        invokeCheckNewFormat(entry);
    }

    @Test
    public void testCheckNewFormat_InvalidFormat() throws Exception {
        // Set the fileFormat to a value that will trigger the exception
        // Assuming FORMAT_NEW_MASK is 1
        setPrivateField(entry, "fileFormat", (short) 0);
        // This should throw an UnsupportedOperationException
        assertThrows(UnsupportedOperationException.class, () -> invokeCheckNewFormat(entry));
    }

    private void invokeCheckNewFormat(CpioArchiveEntry entry) throws Exception {
        Method method = CpioArchiveEntry.class.getDeclaredMethod("checkNewFormat");
        method.setAccessible(true);
        method.invoke(entry);
    }

    private void setPrivateField(CpioArchiveEntry entry, String fieldName, Object value) throws Exception {
        java.lang.reflect.Field field = CpioArchiveEntry.class.getDeclaredField(fieldName);
        field.setAccessible(true);
        field.set(entry, value);
    }
}
