package org.apache.commons.compress.archivers.zip;

import org.apache.commons.compress.archivers.zip.ZipLong;
import java.lang.reflect.Method;
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

class X5455_ExtendedTimestamp_setFlags_35_0_Test {

    private X5455_ExtendedTimestamp extendedTimestamp;

    @BeforeEach
    void setUp() {
        extendedTimestamp = new X5455_ExtendedTimestamp();
    }

    @Test
    void testSetFlagsWithModifyTime() throws Exception {
        byte flags = X5455_ExtendedTimestamp.MODIFY_TIME_BIT;
        invokeSetFlags(flags);
        assertTrue(extendedTimestamp.isBit0_modifyTimePresent());
        assertFalse(extendedTimestamp.isBit1_accessTimePresent());
        assertFalse(extendedTimestamp.isBit2_createTimePresent());
        assertEquals(flags, extendedTimestamp.getFlags());
    }

    @Test
    void testSetFlagsWithAccessTime() throws Exception {
        byte flags = X5455_ExtendedTimestamp.ACCESS_TIME_BIT;
        invokeSetFlags(flags);
        assertFalse(extendedTimestamp.isBit0_modifyTimePresent());
        assertTrue(extendedTimestamp.isBit1_accessTimePresent());
        assertFalse(extendedTimestamp.isBit2_createTimePresent());
        assertEquals(flags, extendedTimestamp.getFlags());
    }

    @Test
    void testSetFlagsWithCreateTime() throws Exception {
        byte flags = X5455_ExtendedTimestamp.CREATE_TIME_BIT;
        invokeSetFlags(flags);
        assertFalse(extendedTimestamp.isBit0_modifyTimePresent());
        assertFalse(extendedTimestamp.isBit1_accessTimePresent());
        assertTrue(extendedTimestamp.isBit2_createTimePresent());
        assertEquals(flags, extendedTimestamp.getFlags());
    }

    @Test
    void testSetFlagsWithAllFlags() throws Exception {
        byte flags = (byte) (X5455_ExtendedTimestamp.MODIFY_TIME_BIT | X5455_ExtendedTimestamp.ACCESS_TIME_BIT | X5455_ExtendedTimestamp.CREATE_TIME_BIT);
        invokeSetFlags(flags);
        assertTrue(extendedTimestamp.isBit0_modifyTimePresent());
        assertTrue(extendedTimestamp.isBit1_accessTimePresent());
        assertTrue(extendedTimestamp.isBit2_createTimePresent());
        assertEquals(flags, extendedTimestamp.getFlags());
    }

    @Test
    void testSetFlagsWithNoFlags() throws Exception {
        byte flags = 0;
        invokeSetFlags(flags);
        assertFalse(extendedTimestamp.isBit0_modifyTimePresent());
        assertFalse(extendedTimestamp.isBit1_accessTimePresent());
        assertFalse(extendedTimestamp.isBit2_createTimePresent());
        assertEquals(flags, extendedTimestamp.getFlags());
    }

    private void invokeSetFlags(byte flags) throws Exception {
        Method method = X5455_ExtendedTimestamp.class.getDeclaredMethod("setFlags", byte.class);
        method.setAccessible(true);
        method.invoke(extendedTimestamp, flags);
    }
}
