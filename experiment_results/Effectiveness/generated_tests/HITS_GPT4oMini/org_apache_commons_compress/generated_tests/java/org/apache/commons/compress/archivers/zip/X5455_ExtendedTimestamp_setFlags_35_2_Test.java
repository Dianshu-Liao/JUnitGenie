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

public class X5455_ExtendedTimestamp_setFlags_35_2_Test {

    private X5455_ExtendedTimestamp extendedTimestamp;

    @BeforeEach
    public void setUp() {
        extendedTimestamp = new X5455_ExtendedTimestamp();
    }

    @Test
    public void testSetFlagsWithModifyTime() {
        byte flags = X5455_ExtendedTimestamp.MODIFY_TIME_BIT;
        extendedTimestamp.setFlags(flags);
        assertEquals(flags, extendedTimestamp.getFlags());
        assertTrue((extendedTimestamp.getFlags() & X5455_ExtendedTimestamp.MODIFY_TIME_BIT) != 0);
        assertFalse((extendedTimestamp.getFlags() & X5455_ExtendedTimestamp.ACCESS_TIME_BIT) != 0);
        assertFalse((extendedTimestamp.getFlags() & X5455_ExtendedTimestamp.CREATE_TIME_BIT) != 0);
    }

    @Test
    public void testSetFlagsWithAccessTime() {
        byte flags = X5455_ExtendedTimestamp.ACCESS_TIME_BIT;
        extendedTimestamp.setFlags(flags);
        assertEquals(flags, extendedTimestamp.getFlags());
        assertFalse((extendedTimestamp.getFlags() & X5455_ExtendedTimestamp.MODIFY_TIME_BIT) != 0);
        assertTrue((extendedTimestamp.getFlags() & X5455_ExtendedTimestamp.ACCESS_TIME_BIT) != 0);
        assertFalse((extendedTimestamp.getFlags() & X5455_ExtendedTimestamp.CREATE_TIME_BIT) != 0);
    }

    @Test
    public void testSetFlagsWithCreateTime() {
        byte flags = X5455_ExtendedTimestamp.CREATE_TIME_BIT;
        extendedTimestamp.setFlags(flags);
        assertEquals(flags, extendedTimestamp.getFlags());
        assertFalse((extendedTimestamp.getFlags() & X5455_ExtendedTimestamp.MODIFY_TIME_BIT) != 0);
        assertFalse((extendedTimestamp.getFlags() & X5455_ExtendedTimestamp.ACCESS_TIME_BIT) != 0);
        assertTrue((extendedTimestamp.getFlags() & X5455_ExtendedTimestamp.CREATE_TIME_BIT) != 0);
    }

    @Test
    public void testSetFlagsWithAllFlags() {
        byte flags = (byte) (X5455_ExtendedTimestamp.MODIFY_TIME_BIT | X5455_ExtendedTimestamp.ACCESS_TIME_BIT | X5455_ExtendedTimestamp.CREATE_TIME_BIT);
        extendedTimestamp.setFlags(flags);
        assertEquals(flags, extendedTimestamp.getFlags());
        assertTrue((extendedTimestamp.getFlags() & X5455_ExtendedTimestamp.MODIFY_TIME_BIT) != 0);
        assertTrue((extendedTimestamp.getFlags() & X5455_ExtendedTimestamp.ACCESS_TIME_BIT) != 0);
        assertTrue((extendedTimestamp.getFlags() & X5455_ExtendedTimestamp.CREATE_TIME_BIT) != 0);
    }

    @Test
    public void testSetFlagsWithNoFlags() {
        byte flags = 0;
        extendedTimestamp.setFlags(flags);
        assertEquals(flags, extendedTimestamp.getFlags());
        assertFalse((extendedTimestamp.getFlags() & X5455_ExtendedTimestamp.MODIFY_TIME_BIT) != 0);
        assertFalse((extendedTimestamp.getFlags() & X5455_ExtendedTimestamp.ACCESS_TIME_BIT) != 0);
        assertFalse((extendedTimestamp.getFlags() & X5455_ExtendedTimestamp.CREATE_TIME_BIT) != 0);
    }
}
