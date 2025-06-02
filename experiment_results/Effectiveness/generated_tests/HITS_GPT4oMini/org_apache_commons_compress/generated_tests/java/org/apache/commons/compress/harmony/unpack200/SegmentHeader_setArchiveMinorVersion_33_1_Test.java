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

public class SegmentHeader_setArchiveMinorVersion_33_1_Test {

    private Segment segment;

    private SegmentHeader segmentHeader;

    @BeforeEach
    public void setUp() {
        // Assuming Segment has a default constructor
        segment = new Segment();
        segmentHeader = new SegmentHeader(segment);
    }

    @Test
    public void testSetArchiveMinorVersion_ValidVersion() throws Exception {
        // Arrange
        int validVersion = 7;
        // Act
        invokeSetArchiveMinorVersion(segmentHeader, validVersion);
        // Assert
        int archiveMinor = getPrivateField(segmentHeader, "archiveMinor");
        assertEquals(validVersion, archiveMinor);
    }

    @Test
    public void testSetArchiveMinorVersion_InvalidVersion() {
        // Arrange
        int invalidVersion = 8;
        // Act & Assert
        Pack200Exception thrown = assertThrows(Pack200Exception.class, () -> {
            invokeSetArchiveMinorVersion(segmentHeader, invalidVersion);
        });
        // Verify the exception message
        assertEquals("Invalid segment minor version", thrown.getMessage());
    }

    private void invokeSetArchiveMinorVersion(SegmentHeader segmentHeader, int version) throws Exception {
        Method method = SegmentHeader.class.getDeclaredMethod("setArchiveMinorVersion", int.class);
        method.setAccessible(true);
        method.invoke(segmentHeader, version);
    }

    private int getPrivateField(SegmentHeader segmentHeader, String fieldName) {
        try {
            java.lang.reflect.Field field = SegmentHeader.class.getDeclaredField(fieldName);
            field.setAccessible(true);
            return (int) field.get(segmentHeader);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
