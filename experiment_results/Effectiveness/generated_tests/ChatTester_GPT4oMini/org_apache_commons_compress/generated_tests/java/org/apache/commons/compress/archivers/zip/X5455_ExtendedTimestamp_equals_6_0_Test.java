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

public class X5455_ExtendedTimestamp_equals_6_0_Test {

    private X5455_ExtendedTimestamp timestamp1;

    private X5455_ExtendedTimestamp timestamp2;

    private X5455_ExtendedTimestamp timestamp3;

    @BeforeEach
    public void setUp() {
        timestamp1 = new X5455_ExtendedTimestamp();
        timestamp2 = new X5455_ExtendedTimestamp();
        timestamp3 = new X5455_ExtendedTimestamp();
    }

    @Test
    public void testEquals_SameObject() {
        assertTrue(timestamp1.equals(timestamp1), "Object should equal itself");
    }

    @Test
    public void testEquals_Null() {
        assertFalse(timestamp1.equals(null), "Object should not equal null");
    }

    @Test
    public void testEquals_DifferentClass() {
        assertFalse(timestamp1.equals("string"), "Object should not equal different class");
    }

    @Test
    public void testEquals_SameFlagsAndTimes() throws Exception {
        setPrivateField(timestamp1, "flags", (byte) 0x07);
        setPrivateField(timestamp2, "flags", (byte) 0x07);
        setPrivateField(timestamp1, "modifyTime", new ZipLong(123456789L));
        setPrivateField(timestamp2, "modifyTime", new ZipLong(123456789L));
        setPrivateField(timestamp1, "accessTime", new ZipLong(987654321L));
        setPrivateField(timestamp2, "accessTime", new ZipLong(987654321L));
        setPrivateField(timestamp1, "createTime", new ZipLong(111111111L));
        setPrivateField(timestamp2, "createTime", new ZipLong(111111111L));
        assertTrue(timestamp1.equals(timestamp2), "Objects with same flags and times should be equal");
    }

    @Test
    public void testEquals_DifferentFlags() throws Exception {
        setPrivateField(timestamp1, "flags", (byte) 0x07);
        setPrivateField(timestamp2, "flags", (byte) 0x06);
        assertFalse(timestamp1.equals(timestamp2), "Objects with different flags should not be equal");
    }

    @Test
    public void testEquals_DifferentModifyTime() throws Exception {
        setPrivateField(timestamp1, "flags", (byte) 0x07);
        setPrivateField(timestamp2, "flags", (byte) 0x07);
        setPrivateField(timestamp1, "modifyTime", new ZipLong(123456789L));
        setPrivateField(timestamp2, "modifyTime", new ZipLong(987654321L));
        assertFalse(timestamp1.equals(timestamp2), "Objects with different modify times should not be equal");
    }

    @Test
    public void testEquals_DifferentAccessTime() throws Exception {
        setPrivateField(timestamp1, "flags", (byte) 0x07);
        setPrivateField(timestamp2, "flags", (byte) 0x07);
        setPrivateField(timestamp1, "accessTime", new ZipLong(987654321L));
        setPrivateField(timestamp2, "accessTime", new ZipLong(123456789L));
        assertFalse(timestamp1.equals(timestamp2), "Objects with different access times should not be equal");
    }

    @Test
    public void testEquals_DifferentCreateTime() throws Exception {
        setPrivateField(timestamp1, "flags", (byte) 0x07);
        setPrivateField(timestamp2, "flags", (byte) 0x07);
        setPrivateField(timestamp1, "createTime", new ZipLong(111111111L));
        setPrivateField(timestamp2, "createTime", new ZipLong(222222222L));
        assertFalse(timestamp1.equals(timestamp2), "Objects with different create times should not be equal");
    }

    private void setPrivateField(Object obj, String fieldName, Object value) throws Exception {
        Field field = obj.getClass().getDeclaredField(fieldName);
        field.setAccessible(true);
        field.set(obj, value);
    }
}
