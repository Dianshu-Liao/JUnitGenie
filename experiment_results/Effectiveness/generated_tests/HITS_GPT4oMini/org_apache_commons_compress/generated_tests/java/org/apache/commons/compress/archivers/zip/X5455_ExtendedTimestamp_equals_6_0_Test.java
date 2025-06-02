package org.apache.commons.compress.archivers.zip;

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
    public void testEquals_BothModifyTimeNull() {
        timestamp1.setModifyTime(null);
        timestamp2.setModifyTime(null);
        assertTrue(timestamp1.equals(timestamp2), "Both modify times are null, should be equal");
    }

    @Test
    public void testEquals_ModifyTimeDifferent() {
        timestamp1.setModifyTime(new ZipLong(123456789));
        timestamp2.setModifyTime(new ZipLong(987654321));
        assertFalse(timestamp1.equals(timestamp2), "Different modify times should not be equal");
    }

    @Test
    public void testEquals_ModifyTimeSame() {
        timestamp1.setModifyTime(new ZipLong(123456789));
        timestamp2.setModifyTime(new ZipLong(123456789));
        assertTrue(timestamp1.equals(timestamp2), "Same modify times should be equal");
    }

    @Test
    public void testEquals_OneModifyTimeNull() {
        timestamp1.setModifyTime(new ZipLong(123456789));
        timestamp2.setModifyTime(null);
        assertFalse(timestamp1.equals(timestamp2), "One modify time is null, should not be equal");
    }

    @Test
    public void testEquals_SameInstance() {
        assertTrue(timestamp1.equals(timestamp1), "Same instance should be equal");
    }

    @Test
    public void testEquals_NonX5455Object() {
        String nonX5455Object = "Not an X5455_ExtendedTimestamp";
        assertFalse(timestamp1.equals(nonX5455Object), "Should not be equal to non-X5455 object");
    }
}
