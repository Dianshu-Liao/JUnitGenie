package org.apache.commons.compress.archivers.zip;

import java.lang.reflect.Method;
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

public class X5455_ExtendedTimestamp_setAccessTime_31_0_Test {

    private X5455_ExtendedTimestamp instance;

    @BeforeEach
    public void setUp() {
        instance = new X5455_ExtendedTimestamp();
    }

    @Test
    public void testSetAccessTime_Null() throws Exception {
        // Arrange
        ZipLong accessTime = null;
        // Act
        invokeSetAccessTime(accessTime);
        // Assert
        assertFalse(getBit1AccessTimePresent());
        assertEquals(0, getFlags() & X5455_ExtendedTimestamp.ACCESS_TIME_BIT);
        assertNull(getAccessTime());
    }

    @Test
    public void testSetAccessTime_ValidValue() throws Exception {
        // Arrange
        ZipLong accessTime = new ZipLong(123456789L);
        // Act
        invokeSetAccessTime(accessTime);
        // Assert
        assertTrue(getBit1AccessTimePresent());
        assertEquals(X5455_ExtendedTimestamp.ACCESS_TIME_BIT, getFlags() & X5455_ExtendedTimestamp.ACCESS_TIME_BIT);
        assertEquals(accessTime, getAccessTime());
    }

    private void invokeSetAccessTime(ZipLong accessTime) throws Exception {
        Method method = X5455_ExtendedTimestamp.class.getDeclaredMethod("setAccessTime", ZipLong.class);
        method.setAccessible(true);
        method.invoke(instance, accessTime);
    }

    private boolean getBit1AccessTimePresent() throws Exception {
        return (boolean) getFieldValue("bit1_accessTimePresent");
    }

    private byte getFlags() throws Exception {
        return (byte) getFieldValue("flags");
    }

    private ZipLong getAccessTime() throws Exception {
        return (ZipLong) getFieldValue("accessTime");
    }

    private Object getFieldValue(String fieldName) throws Exception {
        // Fixed line: replaced 'var' with 'Field' to correctly declare the field variable
        java.lang.reflect.Field field = X5455_ExtendedTimestamp.class.getDeclaredField(fieldName);
        field.setAccessible(true);
        return field.get(instance);
    }
}
