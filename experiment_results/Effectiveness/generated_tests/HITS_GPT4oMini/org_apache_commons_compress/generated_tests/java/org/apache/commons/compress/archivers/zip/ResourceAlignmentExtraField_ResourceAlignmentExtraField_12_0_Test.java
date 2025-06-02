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
        ResourceAlignmentExtraField resourceField = new ResourceAlignmentExtraField(1000, true, 10);
        assertNotNull(resourceField);
    }

    @Test
    public void testConstructorWithAlignmentBoundaryLow() {
        ResourceAlignmentExtraField resourceField = new ResourceAlignmentExtraField(0, false, 0);
        assertNotNull(resourceField);
    }

    @Test
    public void testConstructorWithAlignmentBoundaryHigh() {
        ResourceAlignmentExtraField resourceField = new ResourceAlignmentExtraField(0x7fff, true, 0);
        assertNotNull(resourceField);
    }

    @Test
    public void testConstructorWithAlignmentTooLow() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            new ResourceAlignmentExtraField(-1, false, 0);
        });
        assertEquals("Alignment must be between 0 and 0x7fff, was: -1", exception.getMessage());
    }

    @Test
    public void testConstructorWithAlignmentTooHigh() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            new ResourceAlignmentExtraField(0x8000, false, 0);
        });
        assertEquals("Alignment must be between 0 and 0x7fff, was: 32768", exception.getMessage());
    }

    @Test
    public void testConstructorWithNegativePadding() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            new ResourceAlignmentExtraField(1000, true, -1);
        });
        assertEquals("Padding must not be negative, was: -1", exception.getMessage());
    }
}
