package org.apache.commons.compress.harmony.unpack200;

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
import org.apache.commons.compress.harmony.pack200.Pack200Exception;
import org.apache.commons.compress.utils.IOUtils;

class SegmentHeader_setArchiveMinorVersion_33_0_Test {

    private SegmentHeader segmentHeader;

    @BeforeEach
    void setUp() {
        // Assuming Segment is a valid class, you would need to instantiate it accordingly.
        // Replace with actual constructor parameters if needed
        Segment segment = new Segment();
        segmentHeader = new SegmentHeader(segment);
    }

    @Test
    void testSetArchiveMinorVersion_ValidVersion() throws Exception {
        invokeSetArchiveMinorVersion(7);
        // Use reflection to access the private field archiveMinor
        int archiveMinor = getPrivateField("archiveMinor");
        assertEquals(7, archiveMinor);
    }

    @Test
    void testSetArchiveMinorVersion_InvalidVersion() {
        Exception exception = assertThrows(Pack200Exception.class, () -> {
            invokeSetArchiveMinorVersion(6);
        });
        assertEquals("Invalid segment minor version", exception.getMessage());
    }

    private void invokeSetArchiveMinorVersion(int version) throws Exception {
        Method method = SegmentHeader.class.getDeclaredMethod("setArchiveMinorVersion", int.class);
        method.setAccessible(true);
        method.invoke(segmentHeader, version);
    }

    private int getPrivateField(String fieldName) throws Exception {
        java.lang.reflect.Field field = SegmentHeader.class.getDeclaredField(fieldName);
        field.setAccessible(true);
        return field.getInt(segmentHeader);
    }
}
