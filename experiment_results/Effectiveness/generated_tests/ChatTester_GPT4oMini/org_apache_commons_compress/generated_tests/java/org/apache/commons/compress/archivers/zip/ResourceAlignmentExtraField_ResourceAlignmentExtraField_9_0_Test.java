package org.apache.commons.compress.archivers.zip;

import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import java.util.zip.ZipException;

public class ResourceAlignmentExtraField_ResourceAlignmentExtraField_9_0_Test {

    private ResourceAlignmentExtraField resourceAlignmentExtraField;

    @BeforeEach
    public void setUp() {
        resourceAlignmentExtraField = new ResourceAlignmentExtraField();
    }

    @Test
    public void testDefaultConstructor() {
        // Validate that the alignment is initialized to 0
        assertEquals(0, resourceAlignmentExtraField.getAlignment());
        // Validate that allowMethodChange is initialized to false
        assertFalse(resourceAlignmentExtraField.allowMethodChange());
        // Validate that padding is initialized to 0
        // Accessing padding via reflection since it's private
        try {
            int padding = getPadding();
            assertEquals(0, padding);
        } catch (Exception e) {
            fail("Failed to access padding field: " + e.getMessage());
        }
    }

    // Reflection to access private fields
    private int getPadding() throws Exception {
        java.lang.reflect.Field field = ResourceAlignmentExtraField.class.getDeclaredField("padding");
        field.setAccessible(true);
        return (int) field.get(resourceAlignmentExtraField);
    }
}
