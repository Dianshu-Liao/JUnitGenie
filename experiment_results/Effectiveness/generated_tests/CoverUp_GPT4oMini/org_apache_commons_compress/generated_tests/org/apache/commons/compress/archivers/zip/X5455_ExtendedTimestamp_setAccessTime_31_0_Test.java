package org.apache.commons.compress.archivers.zip;

import org.apache.commons.compress.archivers.zip.ZipLong;
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

public class X5455_ExtendedTimestamp_setAccessTime_31_0_Test {

    private X5455_ExtendedTimestamp timestamp;

    @BeforeEach
    public void setUp() {
        timestamp = new X5455_ExtendedTimestamp();
    }

    @Test
    public void testSetAccessTime_Null() throws Exception {
        // Set access time to null
        timestamp.setAccessTime(null);
        // Use reflection to access private fields
        Field flagsField = X5455_ExtendedTimestamp.class.getDeclaredField("flags");
        flagsField.setAccessible(true);
        Field bit1_accessTimePresentField = X5455_ExtendedTimestamp.class.getDeclaredField("bit1_accessTimePresent");
        bit1_accessTimePresentField.setAccessible(true);
        Field accessTimeField = X5455_ExtendedTimestamp.class.getDeclaredField("accessTime");
        accessTimeField.setAccessible(true);
        // Verify the internal state
        assertEquals(0, flagsField.getByte(timestamp));
        assertFalse((Boolean) bit1_accessTimePresentField.get(timestamp));
        assertNull(accessTimeField.get(timestamp));
    }

    @Test
    public void testSetAccessTime_ValidValue() throws Exception {
        ZipLong zipLong = new ZipLong(123456789L);
        // Set access time to a valid ZipLong value
        timestamp.setAccessTime(zipLong);
        // Use reflection to access private fields
        Field flagsField = X5455_ExtendedTimestamp.class.getDeclaredField("flags");
        flagsField.setAccessible(true);
        Field bit1_accessTimePresentField = X5455_ExtendedTimestamp.class.getDeclaredField("bit1_accessTimePresent");
        bit1_accessTimePresentField.setAccessible(true);
        Field accessTimeField = X5455_ExtendedTimestamp.class.getDeclaredField("accessTime");
        accessTimeField.setAccessible(true);
        // Verify the internal state
        assertEquals(X5455_ExtendedTimestamp.ACCESS_TIME_BIT, flagsField.getByte(timestamp));
        assertTrue((Boolean) bit1_accessTimePresentField.get(timestamp));
        assertEquals(zipLong, accessTimeField.get(timestamp));
    }

    @Test
    public void testSetAccessTime_ChangeFromNullToValue() throws Exception {
        // Initially set access time to null
        timestamp.setAccessTime(null);
        assertFalse(timestamp.getAccessFileTime() != null);
        // Now set to a valid ZipLong value
        ZipLong zipLong = new ZipLong(987654321L);
        timestamp.setAccessTime(zipLong);
        // Verify the internal state
        assertTrue(timestamp.getAccessFileTime() != null);
        assertEquals(zipLong, timestamp.getAccessTime());
    }

    @Test
    public void testSetAccessTime_ChangeFromValueToNull() throws Exception {
        ZipLong zipLong = new ZipLong(111111111L);
        timestamp.setAccessTime(zipLong);
        assertTrue(timestamp.getAccessFileTime() != null);
        // Now set access time to null
        timestamp.setAccessTime(null);
        // Verify the internal state
        assertFalse(timestamp.getAccessFileTime() != null);
        assertNull(timestamp.getAccessTime());
    }
}
