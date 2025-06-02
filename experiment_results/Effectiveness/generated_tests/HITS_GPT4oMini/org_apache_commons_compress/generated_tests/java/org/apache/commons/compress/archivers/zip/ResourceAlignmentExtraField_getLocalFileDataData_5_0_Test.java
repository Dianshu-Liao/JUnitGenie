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
        resourceAlignmentExtraField = new ResourceAlignmentExtraField();
    }

    @Test
    public void testGetLocalFileDataData_WithoutPadding_AndMethodChange() {
        // Arrange
        resourceAlignmentExtraField = new ResourceAlignmentExtraField((short) 0x1234, false, 0);
        // Act
        byte[] result = resourceAlignmentExtraField.getLocalFileDataData();
        // Assert
        byte[] expected = new byte[ResourceAlignmentExtraField.BASE_SIZE];
        ZipShort.putShort(0x1234, expected, 0);
        assertArrayEquals(expected, result);
    }

    @Test
    public void testGetLocalFileDataData_WithoutPadding_WithMethodChange() {
        // Arrange
        resourceAlignmentExtraField = new ResourceAlignmentExtraField((short) 0x1234, true, 0);
        // Act
        byte[] result = resourceAlignmentExtraField.getLocalFileDataData();
        // Assert
        byte[] expected = new byte[ResourceAlignmentExtraField.BASE_SIZE];
        ZipShort.putShort(0x1234 | 0x8000, expected, 0);
        assertArrayEquals(expected, result);
    }

    @Test
    public void testGetLocalFileDataData_WithPadding_WithoutMethodChange() {
        // Arrange
        resourceAlignmentExtraField = new ResourceAlignmentExtraField((short) 0x1234, false, 5);
        // Act
        byte[] result = resourceAlignmentExtraField.getLocalFileDataData();
        // Assert
        byte[] expected = new byte[ResourceAlignmentExtraField.BASE_SIZE + 5];
        ZipShort.putShort(0x1234, expected, 0);
        assertArrayEquals(expected, result);
    }

    @Test
    public void testGetLocalFileDataData_WithPadding_WithMethodChange() {
        // Arrange
        resourceAlignmentExtraField = new ResourceAlignmentExtraField((short) 0x1234, true, 5);
        // Act
        byte[] result = resourceAlignmentExtraField.getLocalFileDataData();
        // Assert
        byte[] expected = new byte[ResourceAlignmentExtraField.BASE_SIZE + 5];
        ZipShort.putShort(0x1234 | 0x8000, expected, 0);
        assertArrayEquals(expected, result);
    }
}
