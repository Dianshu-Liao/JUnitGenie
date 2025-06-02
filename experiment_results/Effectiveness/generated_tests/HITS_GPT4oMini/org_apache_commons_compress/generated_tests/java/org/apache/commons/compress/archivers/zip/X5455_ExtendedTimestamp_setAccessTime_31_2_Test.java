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

public class X5455_ExtendedTimestamp_setAccessTime_31_2_Test {

    private X5455_ExtendedTimestamp extendedTimestamp;

    @BeforeEach
    public void setUp() {
        extendedTimestamp = new X5455_ExtendedTimestamp();
    }

    @Test
    public void testSetAccessTime_NonNullValue() throws Exception {
        ZipLong accessTime = new ZipLong(123456789L);
        extendedTimestamp.setAccessTime(accessTime);
        Field bit1Field = X5455_ExtendedTimestamp.class.getDeclaredField("bit1_accessTimePresent");
        bit1Field.setAccessible(true);
        boolean bit1_accessTimePresent = (boolean) bit1Field.get(extendedTimestamp);
        assertTrue(bit1_accessTimePresent, "Access time bit should be present");
        Field accessTimeField = X5455_ExtendedTimestamp.class.getDeclaredField("accessTime");
        accessTimeField.setAccessible(true);
        ZipLong actualAccessTime = (ZipLong) accessTimeField.get(extendedTimestamp);
        assertEquals(accessTime.getValue(), actualAccessTime != null ? actualAccessTime.getValue() : 0, "Access time should be set correctly");
        Field flagsField = X5455_ExtendedTimestamp.class.getDeclaredField("flags");
        flagsField.setAccessible(true);
        byte flags = (byte) flagsField.get(extendedTimestamp);
        assertTrue((flags & X5455_ExtendedTimestamp.ACCESS_TIME_BIT) != 0, "Flags should indicate access time is present");
    }

    @Test
    public void testSetAccessTime_NullValue() throws Exception {
        extendedTimestamp.setAccessTime(null);
        Field bit1Field = X5455_ExtendedTimestamp.class.getDeclaredField("bit1_accessTimePresent");
        bit1Field.setAccessible(true);
        boolean bit1_accessTimePresent = (boolean) bit1Field.get(extendedTimestamp);
        assertFalse(bit1_accessTimePresent, "Access time bit should not be present");
        Field accessTimeField = X5455_ExtendedTimestamp.class.getDeclaredField("accessTime");
        accessTimeField.setAccessible(true);
        ZipLong actualAccessTime = (ZipLong) accessTimeField.get(extendedTimestamp);
        assertEquals(0, actualAccessTime != null ? actualAccessTime.getValue() : 0, "Access time should be null");
        Field flagsField = X5455_ExtendedTimestamp.class.getDeclaredField("flags");
        flagsField.setAccessible(true);
        byte flags = (byte) flagsField.get(extendedTimestamp);
        assertFalse((flags & X5455_ExtendedTimestamp.ACCESS_TIME_BIT) != 0, "Flags should indicate access time is not present");
    }
}
