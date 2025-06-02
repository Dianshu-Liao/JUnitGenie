package org.apache.commons.compress.archivers.zip;

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

public class X5455_ExtendedTimestamp_getLocalFileDataLength_18_0_Test {

    private X5455_ExtendedTimestamp extendedTimestamp;

    @BeforeEach
    public void setUp() {
        extendedTimestamp = new X5455_ExtendedTimestamp();
    }

    @Test
    public void testGetLocalFileDataLength_NoFlagsSet() {
        // All flags are false, expect length to be 1
        assertEquals(new ZipShort(1), extendedTimestamp.getLocalFileDataLength());
    }

    @Test
    public void testGetLocalFileDataLength_ModifyTimePresent() {
        // Set modify time flag
        invokePrivateMethod(extendedTimestamp, "setModifyTime", new ZipLong(123456));
        assertEquals(new ZipShort(5), extendedTimestamp.getLocalFileDataLength());
    }

    @Test
    public void testGetLocalFileDataLength_AccessTimePresent() {
        // Set access time flag
        invokePrivateMethod(extendedTimestamp, "setAccessTime", new ZipLong(123456));
        assertEquals(new ZipShort(5), extendedTimestamp.getLocalFileDataLength());
    }

    @Test
    public void testGetLocalFileDataLength_CreateTimePresent() {
        // Set create time flag
        invokePrivateMethod(extendedTimestamp, "setCreateTime", new ZipLong(123456));
        assertEquals(new ZipShort(5), extendedTimestamp.getLocalFileDataLength());
    }

    @Test
    public void testGetLocalFileDataLength_AllFlagsSet() {
        // Set all flags and accessTime/createTime
        invokePrivateMethod(extendedTimestamp, "setModifyTime", new ZipLong(123456));
        invokePrivateMethod(extendedTimestamp, "setAccessTime", new ZipLong(654321));
        invokePrivateMethod(extendedTimestamp, "setCreateTime", new ZipLong(789012));
        assertEquals(new ZipShort(13), extendedTimestamp.getLocalFileDataLength());
    }

    private void invokePrivateMethod(Object obj, String methodName, Object... args) {
        try {
            Class<?>[] argTypes = new Class[args.length];
            for (int i = 0; i < args.length; i++) {
                argTypes[i] = args[i].getClass();
            }
            // Fixed line: Changed 'var' to 'java.lang.reflect.Method'
            java.lang.reflect.Method method = obj.getClass().getDeclaredMethod(methodName, argTypes);
            method.setAccessible(true);
            method.invoke(obj, args);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
