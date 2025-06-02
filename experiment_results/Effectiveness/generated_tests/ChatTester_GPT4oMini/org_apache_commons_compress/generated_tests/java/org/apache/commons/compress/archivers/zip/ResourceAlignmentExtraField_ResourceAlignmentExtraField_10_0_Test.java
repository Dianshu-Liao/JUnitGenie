package org.apache.commons.compress.archivers.zip;

import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import java.util.zip.ZipException;

public class ResourceAlignmentExtraField_ResourceAlignmentExtraField_10_0_Test {

    private ResourceAlignmentExtraField resourceAlignmentExtraField;

    @BeforeEach
    public void setUp() {
        // Initialize the object with a default alignment value
        resourceAlignmentExtraField = new ResourceAlignmentExtraField(10);
    }

    @Test
    public void testResourceAlignmentExtraFieldConstructorWithAlignment() {
        // Create a new instance with a specific alignment
        ResourceAlignmentExtraField instance = new ResourceAlignmentExtraField(20);
        // Use reflection to access the private fields
        try {
            java.lang.reflect.Field alignmentField = ResourceAlignmentExtraField.class.getDeclaredField("alignment");
            alignmentField.setAccessible(true);
            short alignment = (short) alignmentField.get(instance);
            assertEquals(20, alignment);
        } catch (NoSuchFieldException | IllegalAccessException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testDefaultAllowMethodChange() {
        // Use reflection to access the private fields
        try {
            java.lang.reflect.Field allowMethodChangeField = ResourceAlignmentExtraField.class.getDeclaredField("allowMethodChange");
            allowMethodChangeField.setAccessible(true);
            boolean allowMethodChange = (boolean) allowMethodChangeField.get(resourceAlignmentExtraField);
            assertEquals(false, allowMethodChange);
        } catch (NoSuchFieldException | IllegalAccessException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testResourceAlignmentExtraFieldConstructorWithDefaultAllowMethodChange() {
        // Create a new instance with a specific alignment and check if the allowMethodChange is false
        ResourceAlignmentExtraField instance = new ResourceAlignmentExtraField(15);
        try {
            java.lang.reflect.Field allowMethodChangeField = ResourceAlignmentExtraField.class.getDeclaredField("allowMethodChange");
            allowMethodChangeField.setAccessible(true);
            boolean allowMethodChange = (boolean) allowMethodChangeField.get(instance);
            assertEquals(false, allowMethodChange);
        } catch (NoSuchFieldException | IllegalAccessException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testResourceAlignmentExtraFieldConstructorWithAlignmentAndCheckPadding() {
        // Create a new instance with a specific alignment
        ResourceAlignmentExtraField instance = new ResourceAlignmentExtraField(25);
        // Use reflection to access the private fields
        try {
            java.lang.reflect.Field paddingField = ResourceAlignmentExtraField.class.getDeclaredField("padding");
            paddingField.setAccessible(true);
            int padding = (int) paddingField.get(instance);
            // Default padding should be 0
            assertEquals(0, padding);
        } catch (NoSuchFieldException | IllegalAccessException e) {
            e.printStackTrace();
        }
    }
}
