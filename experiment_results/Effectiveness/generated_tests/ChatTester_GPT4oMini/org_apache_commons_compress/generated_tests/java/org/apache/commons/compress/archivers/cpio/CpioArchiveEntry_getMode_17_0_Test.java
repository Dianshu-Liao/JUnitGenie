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

public class CpioArchiveEntry_getMode_17_0_Test {

    private CpioArchiveEntry entry;

    @BeforeEach
    public void setUp() {
        entry = new CpioArchiveEntry((short) 1, "testEntry", 0);
    }

    @Test
    public void testGetMode_WithZeroModeAndNotTrailer() throws Exception {
        // Arrange
        // Mode is initialized to 0 and name is not CPIO_TRAILER
        String testName = "testEntry";
        setField(entry, "name", testName);
        setField(entry, "mode", 0L);
        // Act
        long mode = entry.getMode();
        // Assert
        assertEquals(CpioArchiveEntry.C_ISREG, mode);
    }

    @Test
    public void testGetMode_WithNonZeroMode() throws Exception {
        // Arrange
        long expectedMode = 12345L;
        setField(entry, "mode", expectedMode);
        // Act
        long mode = entry.getMode();
        // Assert
        assertEquals(expectedMode, mode);
    }

    @Test
    public void testGetMode_WithZeroModeAndTrailer() throws Exception {
        // Arrange
        setField(entry, "name", CpioArchiveEntry.CPIO_TRAILER);
        setField(entry, "mode", 0L);
        // Act
        long mode = entry.getMode();
        // Assert
        assertEquals(0L, mode);
    }

    private void setField(CpioArchiveEntry entry, String fieldName, Object value) throws Exception {
        Field field = CpioArchiveEntry.class.getDeclaredField(fieldName);
        field.setAccessible(true);
        field.set(entry, value);
    }
}
