package org.apache.commons.compress.archivers.zip;

import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import java.util.zip.ZipException;

public class ResourceAlignmentExtraField_ResourceAlignmentExtraField_11_0_Test {

    private ResourceAlignmentExtraField resourceAlignmentExtraField;

    @BeforeEach
    public void setUp() {
        // Initialize the object with default values
        resourceAlignmentExtraField = new ResourceAlignmentExtraField(10, true);
    }

    @Test
    public void testConstructorWithAlignmentAndAllowMethodChange() {
        // Create a new instance using the constructor
        ResourceAlignmentExtraField instance = new ResourceAlignmentExtraField(10, true);
        // Use reflection to access private fields
        try {
            java.lang.reflect.Field alignmentField = ResourceAlignmentExtraField.class.getDeclaredField("alignment");
            alignmentField.setAccessible(true);
            short alignment = (short) alignmentField.get(instance);
            assertEquals(10, alignment);
            java.lang.reflect.Field allowMethodChangeField = ResourceAlignmentExtraField.class.getDeclaredField("allowMethodChange");
            allowMethodChangeField.setAccessible(true);
            boolean allowMethodChange = (boolean) allowMethodChangeField.get(instance);
            assertTrue(allowMethodChange);
            java.lang.reflect.Field paddingField = ResourceAlignmentExtraField.class.getDeclaredField("padding");
            paddingField.setAccessible(true);
            int padding = (int) paddingField.get(instance);
            // Check default padding value
            assertEquals(0, padding);
        } catch (NoSuchFieldException | IllegalAccessException e) {
            fail("Reflection access failed: " + e.getMessage());
        }
    }

    @Test
    public void testConstructorWithDifferentValues() {
        ResourceAlignmentExtraField instance = new ResourceAlignmentExtraField(20, false);
        // Use reflection to access private fields
        try {
            java.lang.reflect.Field alignmentField = ResourceAlignmentExtraField.class.getDeclaredField("alignment");
            alignmentField.setAccessible(true);
            short alignment = (short) alignmentField.get(instance);
            assertEquals(20, alignment);
            java.lang.reflect.Field allowMethodChangeField = ResourceAlignmentExtraField.class.getDeclaredField("allowMethodChange");
            allowMethodChangeField.setAccessible(true);
            boolean allowMethodChange = (boolean) allowMethodChangeField.get(instance);
            assertFalse(allowMethodChange);
            java.lang.reflect.Field paddingField = ResourceAlignmentExtraField.class.getDeclaredField("padding");
            paddingField.setAccessible(true);
            int padding = (int) paddingField.get(instance);
            // Check default padding value
            assertEquals(0, padding);
        } catch (NoSuchFieldException | IllegalAccessException e) {
            fail("Reflection access failed: " + e.getMessage());
        }
    }

    @Test
    public void testConstructorWithNegativeAlignment() {
        ResourceAlignmentExtraField instance = new ResourceAlignmentExtraField(-1, false);
        // Use reflection to access private fields
        try {
            java.lang.reflect.Field alignmentField = ResourceAlignmentExtraField.class.getDeclaredField("alignment");
            alignmentField.setAccessible(true);
            short alignment = (short) alignmentField.get(instance);
            assertEquals(-1, alignment);
            java.lang.reflect.Field allowMethodChangeField = ResourceAlignmentExtraField.class.getDeclaredField("allowMethodChange");
            allowMethodChangeField.setAccessible(true);
            boolean allowMethodChange = (boolean) allowMethodChangeField.get(instance);
            assertFalse(allowMethodChange);
            java.lang.reflect.Field paddingField = ResourceAlignmentExtraField.class.getDeclaredField("padding");
            paddingField.setAccessible(true);
            int padding = (int) paddingField.get(instance);
            // Check default padding value
            assertEquals(0, padding);
        } catch (NoSuchFieldException | IllegalAccessException e) {
            fail("Reflection access failed: " + e.getMessage());
        }
    }
}
