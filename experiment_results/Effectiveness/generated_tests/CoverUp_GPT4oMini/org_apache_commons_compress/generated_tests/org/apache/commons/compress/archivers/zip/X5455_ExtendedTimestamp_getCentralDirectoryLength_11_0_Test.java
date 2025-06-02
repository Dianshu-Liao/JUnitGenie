package org.apache.commons.compress.archivers.zip;

import org.apache.commons.compress.archivers.zip.ZipShort;
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

    private X5455_ExtendedTimestamp timestamp;

    @BeforeEach
    public void setUp() {
        timestamp = new X5455_ExtendedTimestamp();
    }

    @Test
    public void testGetCentralDirectoryLength_NoModifyTime() {
        // Test when modify time is not present
        ZipShort length = timestamp.getCentralDirectoryLength();
        assertEquals(1, length.getValue());
    }

    @Test
    public void testGetCentralDirectoryLength_WithModifyTime() {
        // Test when modify time is present
        timestamp.setFlags((byte) (X5455_ExtendedTimestamp.MODIFY_TIME_BIT));
        ZipShort length = timestamp.getCentralDirectoryLength();
        assertEquals(5, length.getValue());
    }

    @Test
    public void testGetCentralDirectoryLength_WithModifyTimeAndAccessTime() {
        // Test when modify and access time are present
        timestamp.setFlags((byte) (X5455_ExtendedTimestamp.MODIFY_TIME_BIT | X5455_ExtendedTimestamp.ACCESS_TIME_BIT));
        ZipShort length = timestamp.getCentralDirectoryLength();
        assertEquals(5, length.getValue());
    }

    @Test
    public void testGetCentralDirectoryLength_WithAllTimes() {
        // Test when modify, access, and create time are present
        timestamp.setFlags((byte) (X5455_ExtendedTimestamp.MODIFY_TIME_BIT | X5455_ExtendedTimestamp.ACCESS_TIME_BIT | X5455_ExtendedTimestamp.CREATE_TIME_BIT));
        ZipShort length = timestamp.getCentralDirectoryLength();
        assertEquals(5, length.getValue());
    }
}
