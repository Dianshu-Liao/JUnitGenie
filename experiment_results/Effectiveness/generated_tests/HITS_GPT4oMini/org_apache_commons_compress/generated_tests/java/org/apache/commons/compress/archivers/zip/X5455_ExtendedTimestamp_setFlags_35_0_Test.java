package org.apache.commons.compress.archivers.zip;

import java.lang.reflect.Field;
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

public class X5455_ExtendedTimestamp_setFlags_35_0_Test {

    private X5455_ExtendedTimestamp extendedTimestamp;

    @BeforeEach
    public void setUp() {
        extendedTimestamp = new X5455_ExtendedTimestamp();
    }

    private boolean getBit0ModifyTimePresent() throws Exception {
        Field field = X5455_ExtendedTimestamp.class.getDeclaredField("bit0_modifyTimePresent");
        field.setAccessible(true);
        return (boolean) field.get(extendedTimestamp);
    }

    private boolean getBit1AccessTimePresent() throws Exception {
        Field field = X5455_ExtendedTimestamp.class.getDeclaredField("bit1_accessTimePresent");
        field.setAccessible(true);
        return (boolean) field.get(extendedTimestamp);
    }

    private boolean getBit2CreateTimePresent() throws Exception {
        Field field = X5455_ExtendedTimestamp.class.getDeclaredField("bit2_createTimePresent");
        field.setAccessible(true);
        return (boolean) field.get(extendedTimestamp);
    }

    @Test
    public void testSetFlagsWithModifyTime() throws Exception {
        extendedTimestamp.setFlags(X5455_ExtendedTimestamp.MODIFY_TIME_BIT);
        assertTrue(getBit0ModifyTimePresent(), "Modify time bit should be present.");
        assertFalse(getBit1AccessTimePresent(), "Access time bit should not be present.");
        assertFalse(getBit2CreateTimePresent(), "Create time bit should not be present.");
    }

    @Test
    public void testSetFlagsWithAccessTime() throws Exception {
        extendedTimestamp.setFlags(X5455_ExtendedTimestamp.ACCESS_TIME_BIT);
        assertFalse(getBit0ModifyTimePresent(), "Modify time bit should not be present.");
        assertTrue(getBit1AccessTimePresent(), "Access time bit should be present.");
        assertFalse(getBit2CreateTimePresent(), "Create time bit should not be present.");
    }

    @Test
    public void testSetFlagsWithCreateTime() throws Exception {
        extendedTimestamp.setFlags(X5455_ExtendedTimestamp.CREATE_TIME_BIT);
        assertFalse(getBit0ModifyTimePresent(), "Modify time bit should not be present.");
        assertFalse(getBit1AccessTimePresent(), "Access time bit should not be present.");
        assertTrue(getBit2CreateTimePresent(), "Create time bit should be present.");
    }

    @Test
    public void testSetFlagsWithMultipleBits() throws Exception {
        byte combinedFlags = (byte) (X5455_ExtendedTimestamp.MODIFY_TIME_BIT | X5455_ExtendedTimestamp.ACCESS_TIME_BIT);
        extendedTimestamp.setFlags(combinedFlags);
        assertTrue(getBit0ModifyTimePresent(), "Modify time bit should be present.");
        assertTrue(getBit1AccessTimePresent(), "Access time bit should be present.");
        assertFalse(getBit2CreateTimePresent(), "Create time bit should not be present.");
    }

    @Test
    public void testSetFlagsWithNoBits() throws Exception {
        extendedTimestamp.setFlags((byte) 0);
        assertFalse(getBit0ModifyTimePresent(), "Modify time bit should not be present.");
        assertFalse(getBit1AccessTimePresent(), "Access time bit should not be present.");
        assertFalse(getBit2CreateTimePresent(), "Create time bit should not be present.");
    }
}
