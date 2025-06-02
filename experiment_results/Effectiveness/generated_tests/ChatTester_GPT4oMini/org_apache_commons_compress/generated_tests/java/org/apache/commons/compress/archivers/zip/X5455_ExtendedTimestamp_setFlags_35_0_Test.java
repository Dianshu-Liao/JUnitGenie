package org.apache.commons.compress.archivers.zip;

import java.lang.reflect.Field;
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

public class X5455_ExtendedTimestamp_setFlags_35_0_Test {

    private X5455_ExtendedTimestamp instance;

    @BeforeEach
    public void setUp() {
        instance = new X5455_ExtendedTimestamp();
    }

    @Test
    public void testSetFlagsWithModifyTimeBit() throws Exception {
        // Only MODIFY_TIME_BIT set
        byte flags = 1;
        invokeSetFlags(flags);
        assertTrue(getPrivateField("bit0_modifyTimePresent"), "Modify time should be present");
        assertFalse(getPrivateField("bit1_accessTimePresent"), "Access time should not be present");
        assertFalse(getPrivateField("bit2_createTimePresent"), "Create time should not be present");
    }

    @Test
    public void testSetFlagsWithAccessTimeBit() throws Exception {
        // Only ACCESS_TIME_BIT set
        byte flags = 2;
        invokeSetFlags(flags);
        assertFalse(getPrivateField("bit0_modifyTimePresent"), "Modify time should not be present");
        assertTrue(getPrivateField("bit1_accessTimePresent"), "Access time should be present");
        assertFalse(getPrivateField("bit2_createTimePresent"), "Create time should not be present");
    }

    @Test
    public void testSetFlagsWithCreateTimeBit() throws Exception {
        // Only CREATE_TIME_BIT set
        byte flags = 4;
        invokeSetFlags(flags);
        assertFalse(getPrivateField("bit0_modifyTimePresent"), "Modify time should not be present");
        assertFalse(getPrivateField("bit1_accessTimePresent"), "Access time should not be present");
        assertTrue(getPrivateField("bit2_createTimePresent"), "Create time should be present");
    }

    @Test
    public void testSetFlagsWithAllBitsSet() throws Exception {
        // All bits set (1 | 2 | 4)
        byte flags = 7;
        invokeSetFlags(flags);
        assertTrue(getPrivateField("bit0_modifyTimePresent"), "Modify time should be present");
        assertTrue(getPrivateField("bit1_accessTimePresent"), "Access time should be present");
        assertTrue(getPrivateField("bit2_createTimePresent"), "Create time should be present");
    }

    @Test
    public void testSetFlagsWithNoBitsSet() throws Exception {
        // No bits set
        byte flags = 0;
        invokeSetFlags(flags);
        assertFalse(getPrivateField("bit0_modifyTimePresent"), "Modify time should not be present");
        assertFalse(getPrivateField("bit1_accessTimePresent"), "Access time should not be present");
        assertFalse(getPrivateField("bit2_createTimePresent"), "Create time should not be present");
    }

    private void invokeSetFlags(byte flags) throws Exception {
        Method method = X5455_ExtendedTimestamp.class.getDeclaredMethod("setFlags", byte.class);
        method.setAccessible(true);
        method.invoke(instance, flags);
    }

    private boolean getPrivateField(String fieldName) throws Exception {
        Field field = X5455_ExtendedTimestamp.class.getDeclaredField(fieldName);
        field.setAccessible(true);
        return field.getBoolean(instance);
    }
}
