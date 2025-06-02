package org.apache.commons.compress.archivers.zip;

import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import java.io.Serializable;
import java.nio.file.attribute.FileTime;
import java.util.Arrays;
import java.util.Date;
import java.util.Objects;
import java.util.zip.ZipException;
import org.apache.commons.compress.utils.TimeUtils;
import org.apache.commons.io.file.attribute.FileTimes;

public class X5455_ExtendedTimestamp_setAccessTime_31_0_Test {

    private X5455_ExtendedTimestamp extendedTimestamp;

    @BeforeEach
    public void setUp() {
        extendedTimestamp = new X5455_ExtendedTimestamp();
    }

    private boolean isAccessTimePresent() {
        return (extendedTimestamp.getFlags() & X5455_ExtendedTimestamp.ACCESS_TIME_BIT) != 0;
    }

    @Test
    public void testSetAccessTime_NullValue() {
        // Arrange
        ZipLong accessTime = null;
        // Act
        extendedTimestamp.setAccessTime(accessTime);
        // Assert
        assertFalse(isAccessTimePresent(), "Access time should not be present when null is passed.");
        assertEquals(extendedTimestamp.getFlags(), (extendedTimestamp.getFlags() & ~X5455_ExtendedTimestamp.ACCESS_TIME_BIT), "Flags should not have access time bit set.");
    }

    @Test
    public void testSetAccessTime_ValidValue() {
        // Arrange
        ZipLong accessTime = new ZipLong(123456789L);
        // Act
        extendedTimestamp.setAccessTime(accessTime);
        // Assert
        assertTrue(isAccessTimePresent(), "Access time should be present when a valid ZipLong is passed.");
        assertEquals(extendedTimestamp.getFlags(), (extendedTimestamp.getFlags() | X5455_ExtendedTimestamp.ACCESS_TIME_BIT), "Flags should have access time bit set.");
    }
}
