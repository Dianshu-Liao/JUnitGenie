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

public class CpioArchiveEntry_getMode_17_0_Test {

    private CpioArchiveEntry entry;

    @BeforeEach
    public void setUp() {
        entry = new CpioArchiveEntry("testEntry");
    }

    @Test
    public void testGetModeWhenModeIsZeroAndNameIsNotTrailer() throws Exception {
        // Arrange
        // Assuming C_ISREG is defined as a constant somewhere
        String expectedMode = "C_ISREG";
        // Set mode to 0
        setPrivateField(entry, "mode", 0);
        // Set name to a non-trailer name
        setPrivateField(entry, "name", "testEntry");
        // Act
        long actualMode = entry.getMode();
        // Assert
        assertEquals(expectedMode, actualMode);
    }

    @Test
    public void testGetModeWhenModeIsNotZero() throws Exception {
        // Arrange
        // Example mode value
        long expectedMode = 1234;
        // Set mode to a non-zero value
        setPrivateField(entry, "mode", expectedMode);
        // Act
        long actualMode = entry.getMode();
        // Assert
        assertEquals(expectedMode, actualMode);
    }

    @Test
    public void testGetModeWhenModeIsZeroAndNameIsTrailer() throws Exception {
        // Arrange
        // Set mode to 0
        setPrivateField(entry, "mode", 0);
        // Set name to the trailer name
        setPrivateField(entry, "name", "CPIO_TRAILER");
        // Act
        long actualMode = entry.getMode();
        // Assert
        // Mode should remain 0
        assertEquals(0, actualMode);
    }

    @Test
    public void testSetModeWithInvalidMode() {
        // Arrange
        // Example of an invalid mode
        long invalidMode = -1;
        // Act & Assert
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> {
            entry.setMode(invalidMode);
        });
        // Assert
        assertEquals("Unknown mode. Full: " + Long.toHexString(invalidMode) + " Masked: " + Long.toHexString(invalidMode & CpioArchiveEntry.S_IFMT), exception.getMessage());
    }

    private void setPrivateField(CpioArchiveEntry entry, String fieldName, Object value) throws Exception {
        java.lang.reflect.Field field = CpioArchiveEntry.class.getDeclaredField(fieldName);
        field.setAccessible(true);
        field.set(entry, value);
    }
}
