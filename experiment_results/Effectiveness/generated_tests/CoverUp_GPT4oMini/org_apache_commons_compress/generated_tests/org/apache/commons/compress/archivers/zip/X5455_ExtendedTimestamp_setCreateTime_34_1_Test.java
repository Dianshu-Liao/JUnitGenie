package org.apache.commons.compress.archivers.zip;

import org.apache.commons.compress.archivers.zip.ZipLong;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
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
import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

class X5455_ExtendedTimestamp_setCreateTime_34_1_Test {

    private X5455_ExtendedTimestamp timestamp;

    @BeforeEach
    void setUp() {
        timestamp = new X5455_ExtendedTimestamp();
    }

    @Test
    void testSetCreateTime_NullValue() throws Exception {
        // Invoke the setCreateTime method with null
        invokeSetCreateTime(null);
        // Validate the internal state
        assertFalse(getBit2CreateTimePresent());
        assertEquals(0, timestamp.getFlags());
        assertEquals(null, timestamp.getCreateTime());
    }

    @Test
    void testSetCreateTime_ValidValue() throws Exception {
        ZipLong zipLong = new ZipLong(123456789L);
        // Invoke the setCreateTime method with a valid ZipLong
        invokeSetCreateTime(zipLong);
        // Validate the internal state
        assertTrue(getBit2CreateTimePresent());
        assertEquals(4, timestamp.getFlags());
        assertEquals(zipLong.getValue(), timestamp.getCreateTime().getValue());
    }

    private void invokeSetCreateTime(ZipLong zipLong) throws Exception {
        Method method = X5455_ExtendedTimestamp.class.getDeclaredMethod("setCreateTime", ZipLong.class);
        method.setAccessible(true);
        method.invoke(timestamp, zipLong);
    }

    private boolean getBit2CreateTimePresent() throws Exception {
        Field field = X5455_ExtendedTimestamp.class.getDeclaredField("bit2_createTimePresent");
        field.setAccessible(true);
        return (boolean) field.get(timestamp);
    }
}
