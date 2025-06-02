// Test method
package org.apache.commons.compress.archivers.zip;

import java.lang.reflect.Field;
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

public class X5455_ExtendedTimestamp_setCreateTime_34_0_Test {

    private X5455_ExtendedTimestamp instance;

    @BeforeEach
    public void setUp() {
        instance = new X5455_ExtendedTimestamp();
    }

    @Test
    public void testSetCreateTime_NullValue() throws Exception {
        // Arrange
        ZipLong createTime = null;
        // Act
        invokeSetCreateTime(createTime);
        // Assert
        assertFalse(getBit2CreateTimePresent());
        assertEquals(0, getFlags());
        assertNull(getCreateTime());
    }

    @Test
    public void testSetCreateTime_ValidValue() throws Exception {
        // Arrange
        ZipLong createTime = new ZipLong(123456789L);
        // Act
        invokeSetCreateTime(createTime);
        // Assert
        assertTrue(getBit2CreateTimePresent());
        assertEquals(4, getFlags());
        assertEquals(createTime, getCreateTime());
    }

    private void invokeSetCreateTime(ZipLong createTime) throws Exception {
        // Fixed line: Replaced 'var' with 'java.lang.reflect.Method'
        java.lang.reflect.Method method = X5455_ExtendedTimestamp.class.getDeclaredMethod("setCreateTime", ZipLong.class);
        method.setAccessible(true);
        method.invoke(instance, createTime);
    }

    private boolean getBit2CreateTimePresent() throws Exception {
        Field field = X5455_ExtendedTimestamp.class.getDeclaredField("bit2_createTimePresent");
        field.setAccessible(true);
        return field.getBoolean(instance);
    }

    private byte getFlags() throws Exception {
        Field field = X5455_ExtendedTimestamp.class.getDeclaredField("flags");
        field.setAccessible(true);
        return field.getByte(instance);
    }

    private ZipLong getCreateTime() throws Exception {
        Field field = X5455_ExtendedTimestamp.class.getDeclaredField("createTime");
        field.setAccessible(true);
        return (ZipLong) field.get(instance);
    }
}
