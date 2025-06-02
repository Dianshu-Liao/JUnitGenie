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

public class X5455_ExtendedTimestamp_getCentralDirectoryLength_11_0_Test {

    private X5455_ExtendedTimestamp extendedTimestamp;

    @BeforeEach
    public void setUp() {
        extendedTimestamp = new X5455_ExtendedTimestamp();
    }

    @Test
    public void testGetCentralDirectoryLength_NoFlags() {
        // Arrange
        extendedTimestamp.setFlags((byte) 0);
        // Act
        ZipShort result = extendedTimestamp.getCentralDirectoryLength();
        // Assert
        assertEquals(new ZipShort(1), result);
    }

    @Test
    public void testGetCentralDirectoryLength_ModifyTimePresent() {
        // Arrange
        extendedTimestamp.setFlags((byte) (0 | X5455_ExtendedTimestamp.MODIFY_TIME_BIT));
        // Act
        ZipShort result = extendedTimestamp.getCentralDirectoryLength();
        // Assert
        assertEquals(new ZipShort(5), result);
    }

    @Test
    public void testGetCentralDirectoryLength_AccessTimePresent() {
        // Arrange
        extendedTimestamp.setFlags((byte) (0 | X5455_ExtendedTimestamp.ACCESS_TIME_BIT));
        // Act
        ZipShort result = extendedTimestamp.getCentralDirectoryLength();
        // Assert
        assertEquals(new ZipShort(1), result);
    }

    @Test
    public void testGetCentralDirectoryLength_CreateTimePresent() {
        // Arrange
        extendedTimestamp.setFlags((byte) (0 | X5455_ExtendedTimestamp.CREATE_TIME_BIT));
        // Act
        ZipShort result = extendedTimestamp.getCentralDirectoryLength();
        // Assert
        assertEquals(new ZipShort(1), result);
    }

    @Test
    public void testGetCentralDirectoryLength_AllFlagsPresent() {
        // Arrange
        extendedTimestamp.setFlags((byte) (X5455_ExtendedTimestamp.MODIFY_TIME_BIT | X5455_ExtendedTimestamp.ACCESS_TIME_BIT | X5455_ExtendedTimestamp.CREATE_TIME_BIT));
        // Act
        ZipShort result = extendedTimestamp.getCentralDirectoryLength();
        // Assert
        assertEquals(new ZipShort(5), result);
    }
}
