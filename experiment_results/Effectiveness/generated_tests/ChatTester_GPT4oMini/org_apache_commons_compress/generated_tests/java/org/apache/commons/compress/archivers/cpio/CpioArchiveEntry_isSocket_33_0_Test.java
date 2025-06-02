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

public class CpioArchiveEntry_isSocket_33_0_Test {

    private CpioArchiveEntry entry;

    @BeforeEach
    public void setUp() {
        // Initialize with a mode that signifies a regular file
        entry = new CpioArchiveEntry((short) 0, "testEntry");
        // Assume C_ISREG is the constant for regular files
        setMode(entry, C_ISREG);
    }

    @Test
    public void testIsSocketReturnsFalseForRegularFile() {
        assertFalse(entry.isSocket(), "Expected isSocket() to return false for regular file");
    }

    @Test
    public void testIsSocketReturnsTrueForSocket() {
        // Assume C_ISSOCK is the constant for sockets
        setMode(entry, C_ISSOCK);
        assertTrue(entry.isSocket(), "Expected isSocket() to return true for socket");
    }

    private void setMode(CpioArchiveEntry entry, long mode) {
        try {
            // Use reflection to access the private field 'mode'
            Field modeField = CpioArchiveEntry.class.getDeclaredField("mode");
            modeField.setAccessible(true);
            modeField.setLong(entry, mode);
        } catch (Exception e) {
            throw new RuntimeException("Failed to set mode", e);
        }
    }

    // Constants to represent file types
    // Regular file
    private static final long C_ISREG = 0x8000;

    // Socket
    private static final long C_ISSOCK = 0xC000;
}
