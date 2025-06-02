package org.apache.commons.compress.archivers.cpio;

import java.lang.reflect.Field;
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

public class CpioArchiveEntry_isRegularFile_32_0_Test {

    private CpioArchiveEntry entry;

    @BeforeEach
    public void setUp() {
        // Using a constructor that sets the mode
        entry = new CpioArchiveEntry((short) 0);
    }

    @Test
    public void testIsRegularFile_WhenModeIsRegular_ReturnsTrue() throws Exception {
        // Example mode for regular file
        long regularFileMode = 0x8000;
        setMode(entry, regularFileMode);
        assertTrue(entry.isRegularFile());
    }

    @Test
    public void testIsRegularFile_WhenModeIsNotRegular_ReturnsFalse() throws Exception {
        // Example mode for directory
        long nonRegularFileMode = 0x4000;
        setMode(entry, nonRegularFileMode);
        assertFalse(entry.isRegularFile());
    }

    private void setMode(CpioArchiveEntry entry, long mode) throws Exception {
        // Use reflection to set the private 'mode' field
        Field modeField = CpioArchiveEntry.class.getDeclaredField("mode");
        modeField.setAccessible(true);
        modeField.set(entry, mode);
    }
}
