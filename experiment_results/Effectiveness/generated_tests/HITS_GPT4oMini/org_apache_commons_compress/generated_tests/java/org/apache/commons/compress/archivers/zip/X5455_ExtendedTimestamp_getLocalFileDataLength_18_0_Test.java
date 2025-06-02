package org.apache.commons.compress.archivers.zip;

import org.apache.commons.compress.archivers.zip.ZipShort;
import org.apache.commons.compress.archivers.zip.ZipLong;
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

public class X5455_ExtendedTimestamp_getLocalFileDataLength_18_0_Test {

    private X5455_ExtendedTimestamp extendedTimestamp;

    @BeforeEach
    public void setUp() {
        extendedTimestamp = new X5455_ExtendedTimestamp();
    }

    private void setFlags(boolean modifyTime, boolean accessTime, boolean createTime) {
        byte flags = 0;
        // Set the modify time bit
        if (modifyTime)
            flags |= 1;
        // Set the access time bit
        if (accessTime)
            flags |= 2;
        // Set the create time bit
        if (createTime)
            flags |= 4;
        // Assuming setFlags(byte) exists
        extendedTimestamp.setFlags(flags);
    }

    @Test
    public void testGetLocalFileDataLength_NoFlags() {
        assertEquals(new ZipShort(1), extendedTimestamp.getLocalFileDataLength());
    }

    @Test
    public void testGetLocalFileDataLength_ModifyTimePresent() {
        setFlags(true, false, false);
        assertEquals(new ZipShort(5), extendedTimestamp.getLocalFileDataLength());
    }

    @Test
    public void testGetLocalFileDataLength_AccessTimePresent() {
        setFlags(false, true, false);
        extendedTimestamp.setAccessTime(new ZipLong(123456789));
        assertEquals(new ZipShort(5), extendedTimestamp.getLocalFileDataLength());
    }

    @Test
    public void testGetLocalFileDataLength_CreateTimePresent() {
        setFlags(false, false, true);
        extendedTimestamp.setCreateTime(new ZipLong(987654321));
        assertEquals(new ZipShort(5), extendedTimestamp.getLocalFileDataLength());
    }

    @Test
    public void testGetLocalFileDataLength_AllFlagsPresent() {
        setFlags(true, true, true);
        extendedTimestamp.setAccessTime(new ZipLong(123456789));
        extendedTimestamp.setCreateTime(new ZipLong(987654321));
        assertEquals(new ZipShort(9), extendedTimestamp.getLocalFileDataLength());
    }

    @Test
    public void testGetLocalFileDataLength_AccessTimeNotPresent() {
        setFlags(true, false, true);
        extendedTimestamp.setCreateTime(new ZipLong(987654321));
        assertEquals(new ZipShort(5), extendedTimestamp.getLocalFileDataLength());
    }

    @Test
    public void testGetLocalFileDataLength_CreateTimeNotPresent() {
        setFlags(true, true, false);
        extendedTimestamp.setAccessTime(new ZipLong(123456789));
        assertEquals(new ZipShort(5), extendedTimestamp.getLocalFileDataLength());
    }
}
