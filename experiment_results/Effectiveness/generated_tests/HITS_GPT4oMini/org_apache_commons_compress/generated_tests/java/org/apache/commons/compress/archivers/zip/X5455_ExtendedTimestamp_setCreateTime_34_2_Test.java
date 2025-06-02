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

public class X5455_ExtendedTimestamp_setCreateTime_34_2_Test {

    private X5455_ExtendedTimestamp extendedTimestamp;

    @BeforeEach
    public void setUp() {
        extendedTimestamp = new X5455_ExtendedTimestamp();
    }

    private boolean getBit2CreateTimePresent() throws NoSuchFieldException, IllegalAccessException {
        Field field = X5455_ExtendedTimestamp.class.getDeclaredField("bit2_createTimePresent");
        field.setAccessible(true);
        return (boolean) field.get(extendedTimestamp);
    }

    private byte getFlags() throws NoSuchFieldException, IllegalAccessException {
        Field field = X5455_ExtendedTimestamp.class.getDeclaredField("flags");
        field.setAccessible(true);
        return (byte) field.get(extendedTimestamp);
    }

    private ZipLong getCreateTime() throws NoSuchFieldException, IllegalAccessException {
        Field field = X5455_ExtendedTimestamp.class.getDeclaredField("createTime");
        field.setAccessible(true);
        return (ZipLong) field.get(extendedTimestamp);
    }

    @Test
    public void testSetCreateTime_NullValue() throws Exception {
        extendedTimestamp.setCreateTime(null);
        assertFalse(getBit2CreateTimePresent(), "Create time should not be present when set to null");
        assertEquals(0, getFlags() & X5455_ExtendedTimestamp.CREATE_TIME_BIT, "Flags should not have CREATE_TIME_BIT set");
        assertNull(getCreateTime(), "Create time should be null");
    }

    @Test
    public void testSetCreateTime_ValidValue() throws Exception {
        ZipLong createTimeValue = new ZipLong(123456789L);
        extendedTimestamp.setCreateTime(createTimeValue);
        assertTrue(getBit2CreateTimePresent(), "Create time should be present when set to a valid value");
        assertEquals(X5455_ExtendedTimestamp.CREATE_TIME_BIT, getFlags() & X5455_ExtendedTimestamp.CREATE_TIME_BIT, "Flags should have CREATE_TIME_BIT set");
        assertEquals(createTimeValue, getCreateTime(), "Create time should equal the value set");
    }

    @Test
    public void testSetCreateTime_AnotherValidValue() throws Exception {
        ZipLong createTimeValue = new ZipLong(987654321L);
        extendedTimestamp.setCreateTime(createTimeValue);
        assertTrue(getBit2CreateTimePresent(), "Create time should be present when set to a valid value");
        assertEquals(X5455_ExtendedTimestamp.CREATE_TIME_BIT, getFlags() & X5455_ExtendedTimestamp.CREATE_TIME_BIT, "Flags should have CREATE_TIME_BIT set");
        assertEquals(createTimeValue, getCreateTime(), "Create time should equal the value set");
    }
}
