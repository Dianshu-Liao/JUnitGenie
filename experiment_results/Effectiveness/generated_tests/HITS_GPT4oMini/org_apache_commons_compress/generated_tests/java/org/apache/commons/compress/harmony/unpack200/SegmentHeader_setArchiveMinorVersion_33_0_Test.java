package org.apache.commons.compress.harmony.unpack200;

import org.apache.commons.compress.harmony.pack200.Pack200Exception;
import java.lang.reflect.Method;
import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import org.apache.commons.compress.harmony.pack200.BHSDCodec;
import org.apache.commons.compress.harmony.pack200.Codec;
import org.apache.commons.compress.utils.IOUtils;

public class SegmentHeader_setArchiveMinorVersion_33_0_Test {

    private SegmentHeader segmentHeader;

    @BeforeEach
    public void setUp() {
        segmentHeader = new SegmentHeader(new Segment());
    }

    @Test
    public void testSetArchiveMinorVersion_ValidVersion() throws Exception {
        invokeSetArchiveMinorVersion(7);
        // If no exception is thrown, the test passes
    }

    @Test
    public void testSetArchiveMinorVersion_InvalidVersion() {
        assertThrows(Pack200Exception.class, () -> {
            invokeSetArchiveMinorVersion(6);
        }, "Invalid segment minor version");
    }

    @Test
    public void testSetArchiveMinorVersion_AnotherInvalidVersion() {
        assertThrows(Pack200Exception.class, () -> {
            invokeSetArchiveMinorVersion(8);
        }, "Invalid segment minor version");
    }

    @Test
    public void testSetArchiveMinorVersion_NegativeVersion() {
        assertThrows(Pack200Exception.class, () -> {
            invokeSetArchiveMinorVersion(-1);
        }, "Invalid segment minor version");
    }

    private void invokeSetArchiveMinorVersion(int version) throws Exception {
        Method method = SegmentHeader.class.getDeclaredMethod("setArchiveMinorVersion", int.class);
        method.setAccessible(true);
        method.invoke(segmentHeader, version);
    }
}
