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
    public void testEquals_SameObject() {
        assertTrue(timestamp1.equals(timestamp1), "An object should equal itself");
    }

    @Test
    public void testEquals_Null() {
        assertFalse(timestamp1.equals(null), "An object should not equal null");
    }

    @Test
    public void testEquals_DifferentClass() {
        assertFalse(timestamp1.equals("Not a timestamp"), "An object should not equal an instance of a different class");
    }

    @Test
    public void testEquals_SameValues() {
        timestamp1.setFlags((byte) 0x07);
        timestamp1.setModifyTime(new ZipLong(12345));
        timestamp1.setAccessTime(new ZipLong(67890));
        timestamp1.setCreateTime(new ZipLong(11111));
        timestamp2.setFlags((byte) 0x07);
        timestamp2.setModifyTime(new ZipLong(12345));
        timestamp2.setAccessTime(new ZipLong(67890));
        timestamp2.setCreateTime(new ZipLong(11111));
        assertTrue(timestamp1.equals(timestamp2), "Two timestamps with the same values should be equal");
    }

    @Test
    public void testEquals_DifferentModifyTime() {
        timestamp1.setFlags((byte) 0x07);
        timestamp1.setModifyTime(new ZipLong(12345));
        timestamp2.setFlags((byte) 0x07);
        timestamp2.setModifyTime(new ZipLong(54321));
        assertFalse(timestamp1.equals(timestamp2), "Timestamps with different modify times should not be equal");
    }

    @Test
    public void testEquals_DifferentAccessTime() {
        timestamp1.setFlags((byte) 0x07);
        timestamp1.setAccessTime(new ZipLong(67890));
        timestamp2.setFlags((byte) 0x07);
        timestamp2.setAccessTime(new ZipLong(98765));
        assertFalse(timestamp1.equals(timestamp2), "Timestamps with different access times should not be equal");
    }

    @Test
    public void testEquals_DifferentCreateTime() {
        timestamp1.setFlags((byte) 0x07);
        timestamp1.setCreateTime(new ZipLong(11111));
        timestamp2.setFlags((byte) 0x07);
        timestamp2.setCreateTime(new ZipLong(22222));
        assertFalse(timestamp1.equals(timestamp2), "Timestamps with different create times should not be equal");
    }

    @Test
    public void testEquals_DifferentFlags() {
        timestamp1.setFlags((byte) 0x03);
        timestamp2.setFlags((byte) 0x07);
        assertFalse(timestamp1.equals(timestamp2), "Timestamps with different flags should not be equal");
    }
}
