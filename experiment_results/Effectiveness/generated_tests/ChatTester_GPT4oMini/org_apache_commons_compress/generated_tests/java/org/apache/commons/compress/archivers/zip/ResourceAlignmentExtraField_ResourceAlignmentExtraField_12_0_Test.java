package org.apache.commons.compress.archivers.zip;

import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import java.util.zip.ZipException;

public class ResourceAlignmentExtraField_ResourceAlignmentExtraField_12_0_Test {

    @Test
    public void testConstructorWithValidParameters() {
        ResourceAlignmentExtraField resource = new ResourceAlignmentExtraField(100, true, 10);
        assertNotNull(resource);
    }

    @Test
    public void testConstructorWithAlignmentTooLow() {
        IllegalArgumentException thrown = assertThrows(IllegalArgumentException.class, () -> {
            new ResourceAlignmentExtraField(-1, true, 10);
        });
        assertEquals("Alignment must be between 0 and 0x7fff, was: -1", thrown.getMessage());
    }

    @Test
    public void testConstructorWithAlignmentTooHigh() {
        IllegalArgumentException thrown = assertThrows(IllegalArgumentException.class, () -> {
            new ResourceAlignmentExtraField(0x8000, true, 10);
        });
        assertEquals("Alignment must be between 0 and 0x7fff, was: 32768", thrown.getMessage());
    }

    @Test
    public void testConstructorWithNegativePadding() {
        IllegalArgumentException thrown = assertThrows(IllegalArgumentException.class, () -> {
            new ResourceAlignmentExtraField(100, true, -1);
        });
        assertEquals("Padding must not be negative, was: -1", thrown.getMessage());
    }

    @Test
    public void testConstructorWithAlignmentAndMethodChange() {
        ResourceAlignmentExtraField resource = new ResourceAlignmentExtraField(200, false, 5);
        assertEquals(200, resource.getAlignment());
        assertFalse(resource.allowMethodChange());
    }

    @Test
    public void testConstructorWithAlignmentAndPadding() {
        ResourceAlignmentExtraField resource = new ResourceAlignmentExtraField(300, true, 15);
        assertEquals(300, resource.getAlignment());
        assertTrue(resource.allowMethodChange());
        assertEquals(15, resource.getLocalFileDataLength().getValue() - ResourceAlignmentExtraField.BASE_SIZE);
    }
}
