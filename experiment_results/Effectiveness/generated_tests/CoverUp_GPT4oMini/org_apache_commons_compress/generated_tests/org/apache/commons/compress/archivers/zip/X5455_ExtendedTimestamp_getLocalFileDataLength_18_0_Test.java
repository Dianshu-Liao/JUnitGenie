package org.apache.commons.compress.archivers.zip;

import org.apache.commons.compress.archivers.zip.ZipShort;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import java.io.Serializable;
import java.nio.file.attribute.FileTime;
import java.util.Arrays;
import java.util.Date;
import java.util.Objects;
import java.util.zip.ZipException;
import org.apache.commons.compress.utils.TimeUtils;
import org.apache.commons.io.file.attribute.FileTimes;

public class X5455_ExtendedTimestamp_getLocalFileDataLength_18_0_Test {

    private X5455_ExtendedTimestamp timestamp;

    @BeforeEach
    public void setUp() {
        timestamp = new X5455_ExtendedTimestamp();
    }

    @Test
    public void testGetLocalFileDataLength_NoFlags() {
        // No flags set, should return 1
        assertEquals(new ZipShort(1), timestamp.getLocalFileDataLength());
    }

    @Test
    public void testGetLocalFileDataLength_ModifyTimePresent() {
        timestamp.setFlags(X5455_ExtendedTimestamp.MODIFY_TIME_BIT);
        // Setting a valid modify time
        timestamp.setModifyTime(new ZipLong(1234567890L));
        assertEquals(new ZipShort(5), timestamp.getLocalFileDataLength());
    }

    @Test
    public void testGetLocalFileDataLength_AccessTimePresent() {
        timestamp.setFlags(X5455_ExtendedTimestamp.ACCESS_TIME_BIT);
        // Setting a valid access time
        timestamp.setAccessTime(new ZipLong(1234567890L));
        assertEquals(new ZipShort(5), timestamp.getLocalFileDataLength());
    }

    @Test
    public void testGetLocalFileDataLength_CreateTimePresent() {
        timestamp.setFlags(X5455_ExtendedTimestamp.CREATE_TIME_BIT);
        // Setting a valid create time
        timestamp.setCreateTime(new ZipLong(1234567890L));
        assertEquals(new ZipShort(5), timestamp.getLocalFileDataLength());
    }

    @Test
    public void testGetLocalFileDataLength_AllTimesPresent() {
        timestamp.setFlags((byte) (X5455_ExtendedTimestamp.MODIFY_TIME_BIT | X5455_ExtendedTimestamp.ACCESS_TIME_BIT | X5455_ExtendedTimestamp.CREATE_TIME_BIT));
        // Setting valid modify time
        timestamp.setModifyTime(new ZipLong(1234567890L));
        // Setting valid access time
        timestamp.setAccessTime(new ZipLong(1234567890L));
        // Setting valid create time
        timestamp.setCreateTime(new ZipLong(1234567890L));
        assertEquals(new ZipShort(13), timestamp.getLocalFileDataLength());
    }

    @Test
    public void testGetLocalFileDataLength_AccessTimeNotPresent() {
        timestamp.setFlags((byte) (X5455_ExtendedTimestamp.MODIFY_TIME_BIT | X5455_ExtendedTimestamp.CREATE_TIME_BIT));
        // Setting valid modify time
        timestamp.setModifyTime(new ZipLong(1234567890L));
        // Access time not present
        timestamp.setAccessTime(null);
        // Setting valid create time
        timestamp.setCreateTime(new ZipLong(1234567890L));
        assertEquals(new ZipShort(9), timestamp.getLocalFileDataLength());
    }

    @Test
    public void testGetLocalFileDataLength_CreateTimeNotPresent() {
        timestamp.setFlags((byte) (X5455_ExtendedTimestamp.MODIFY_TIME_BIT | X5455_ExtendedTimestamp.ACCESS_TIME_BIT));
        // Setting valid modify time
        timestamp.setModifyTime(new ZipLong(1234567890L));
        // Setting valid access time
        timestamp.setAccessTime(new ZipLong(1234567890L));
        // Create time not present
        timestamp.setCreateTime(null);
        assertEquals(new ZipShort(9), timestamp.getLocalFileDataLength());
    }
}
