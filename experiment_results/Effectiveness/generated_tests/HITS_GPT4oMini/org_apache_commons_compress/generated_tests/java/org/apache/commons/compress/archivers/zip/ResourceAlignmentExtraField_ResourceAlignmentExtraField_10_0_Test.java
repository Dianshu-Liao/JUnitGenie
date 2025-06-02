package org.apache.commons.compress.archivers.zip;

import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import java.util.zip.ZipException;

public class ResourceAlignmentExtraField_ResourceAlignmentExtraField_10_0_Test {

    @Test
    public void testConstructorWithAlignment() {
        // Example alignment value
        int alignment = 16;
        ResourceAlignmentExtraField resourceField = new ResourceAlignmentExtraField(alignment);
        assertNotNull(resourceField, "ResourceAlignmentExtraField should not be null");
    }

    @Test
    public void testConstructorWithAlignmentAndAllowMethodChange() {
        // Example alignment value
        int alignment = 32;
        boolean allowMethodChange = true;
        ResourceAlignmentExtraField resourceField = new ResourceAlignmentExtraField(alignment, allowMethodChange);
        assertNotNull(resourceField, "ResourceAlignmentExtraField should not be null");
    }

    @Test
    public void testConstructorWithAlignmentAllowMethodChangeAndPadding() {
        // Example alignment value
        int alignment = 64;
        boolean allowMethodChange = false;
        // Example padding value
        int padding = 8;
        ResourceAlignmentExtraField resourceField = new ResourceAlignmentExtraField(alignment, allowMethodChange, padding);
        assertNotNull(resourceField, "ResourceAlignmentExtraField should not be null");
    }

    @Test
    public void testBaseSize() {
        assertEquals(2, ResourceAlignmentExtraField.BASE_SIZE, "Base size should be 2");
    }

    @Test
    public void testId() {
        assertNotNull(ResourceAlignmentExtraField.ID, "ID should not be null");
        assertEquals(0xa11e, ResourceAlignmentExtraField.ID.getValue(), "ID value should match expected");
    }
}
