package org.apache.commons.compress.archivers.zip;

import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import java.util.zip.ZipException;

public class ResourceAlignmentExtraField_ResourceAlignmentExtraField_9_1_Test {

    private ResourceAlignmentExtraField resourceAlignmentExtraField;

    @BeforeEach
    public void setUp() {
        // Initialize the ResourceAlignmentExtraField before each test
        resourceAlignmentExtraField = new ResourceAlignmentExtraField();
    }

    @Test
    public void testDefaultConstructor() {
        assertNotNull(resourceAlignmentExtraField);
        // Check only alignment as others cannot be accessed
        assertEquals(0, resourceAlignmentExtraField.getAlignment());
    }

    @Test
    public void testConstructorWithAlignment() {
        int alignment = 16;
        resourceAlignmentExtraField = new ResourceAlignmentExtraField(alignment);
        assertEquals(alignment, resourceAlignmentExtraField.getAlignment());
    }

    @Test
    public void testConstructorWithAlignmentAndAllowMethodChange() {
        int alignment = 32;
        boolean allowMethodChange = true;
        resourceAlignmentExtraField = new ResourceAlignmentExtraField(alignment, allowMethodChange);
        assertEquals(alignment, resourceAlignmentExtraField.getAlignment());
    }

    @Test
    public void testConstructorWithAllParameters() {
        int alignment = 64;
        boolean allowMethodChange = true;
        int padding = 10;
        resourceAlignmentExtraField = new ResourceAlignmentExtraField(alignment, allowMethodChange, padding);
        assertEquals(alignment, resourceAlignmentExtraField.getAlignment());
    }
}
