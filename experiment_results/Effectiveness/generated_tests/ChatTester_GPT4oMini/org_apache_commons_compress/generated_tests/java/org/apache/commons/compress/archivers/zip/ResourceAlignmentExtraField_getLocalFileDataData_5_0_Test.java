package org.apache.commons.compress.archivers.zip;

import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import java.util.zip.ZipException;

public class ResourceAlignmentExtraField_getLocalFileDataData_5_0_Test {

    private ResourceAlignmentExtraField resourceAlignmentExtraField;

    @BeforeEach
    public void setUp() {
        // Initialize with default values for testing
        resourceAlignmentExtraField = new ResourceAlignmentExtraField(0, false, 0);
    }

    @Test
    public void testGetLocalFileDataData_NoPadding_NoMethodChange() {
        // Test case with no padding and no method change
        resourceAlignmentExtraField = new ResourceAlignmentExtraField(0, false, 0);
        byte[] expected = new byte[ResourceAlignmentExtraField.BASE_SIZE];
        // alignment
        expected[0] = 0;
        // method change flag not set
        expected[1] = 0;
        byte[] actual = resourceAlignmentExtraField.getLocalFileDataData();
        assertArrayEquals(expected, actual);
    }

    @Test
    public void testGetLocalFileDataData_WithPadding_NoMethodChange() {
        // Test case with padding and no method change
        resourceAlignmentExtraField = new ResourceAlignmentExtraField(1, false, 2);
        byte[] expected = new byte[ResourceAlignmentExtraField.BASE_SIZE + 2];
        // alignment
        expected[0] = 1;
        // method change flag not set
        expected[1] = 0;
        byte[] actual = resourceAlignmentExtraField.getLocalFileDataData();
        assertArrayEquals(expected, actual);
    }

    @Test
    public void testGetLocalFileDataData_NoPadding_WithMethodChange() {
        // Test case with no padding and method change
        resourceAlignmentExtraField = new ResourceAlignmentExtraField(1, true, 0);
        byte[] expected = new byte[ResourceAlignmentExtraField.BASE_SIZE];
        // alignment
        expected[0] = 1;
        // method change flag set
        expected[1] = (byte) 0x80;
        byte[] actual = resourceAlignmentExtraField.getLocalFileDataData();
        assertArrayEquals(expected, actual);
    }

    @Test
    public void testGetLocalFileDataData_WithPadding_WithMethodChange() {
        // Test case with padding and method change
        resourceAlignmentExtraField = new ResourceAlignmentExtraField(2, true, 3);
        byte[] expected = new byte[ResourceAlignmentExtraField.BASE_SIZE + 3];
        // alignment
        expected[0] = 2;
        // method change flag set
        expected[1] = (byte) 0x80;
        byte[] actual = resourceAlignmentExtraField.getLocalFileDataData();
        assertArrayEquals(expected, actual);
    }
}
