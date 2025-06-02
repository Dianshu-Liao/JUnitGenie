package org.apache.commons.compress.archivers.zip;

import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import java.nio.file.attribute.FileTime;
import java.util.Date;
import java.util.Objects;
import java.util.zip.ZipException;
import org.apache.commons.io.file.attribute.FileTimes;

public class X000A_NTFS_setModifyTime_32_0_Test {

    @Test
    public void testSetModifyTime_NullValue() {
        X000A_NTFS instance = new X000A_NTFS();
        instance.setModifyTime(null);
        assertEquals(ZipEightByteInteger.ZERO, instance.getModifyTime(), "Expected modifyTime to be ZERO when set with null");
    }

    @Test
    public void testSetModifyTime_ValidValue() {
        X000A_NTFS instance = new X000A_NTFS();
        ZipEightByteInteger newTime = new ZipEightByteInteger(123456789L);
        instance.setModifyTime(newTime);
        assertEquals(newTime, instance.getModifyTime(), "Expected modifyTime to be set to the new valid value");
    }

    @Test
    public void testSetModifyTime_ZeroValue() {
        X000A_NTFS instance = new X000A_NTFS();
        ZipEightByteInteger zeroTime = ZipEightByteInteger.ZERO;
        instance.setModifyTime(zeroTime);
        assertEquals(zeroTime, instance.getModifyTime(), "Expected modifyTime to remain ZERO when set with ZERO");
    }

    @Test
    public void testSetModifyTime_NegativeValue() {
        X000A_NTFS instance = new X000A_NTFS();
        ZipEightByteInteger negativeTime = new ZipEightByteInteger(-123456789L);
        instance.setModifyTime(negativeTime);
        assertEquals(negativeTime, instance.getModifyTime(), "Expected modifyTime to be set to the negative value");
    }

    @Test
    public void testSetModifyTime_PositiveValue() {
        X000A_NTFS instance = new X000A_NTFS();
        ZipEightByteInteger positiveTime = new ZipEightByteInteger(987654321L);
        instance.setModifyTime(positiveTime);
        assertEquals(positiveTime, instance.getModifyTime(), "Expected modifyTime to be set to the positive value");
    }
}
