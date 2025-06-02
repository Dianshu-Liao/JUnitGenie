package org.apache.commons.compress.archivers.zip;

import org.apache.commons.compress.archivers.zip.ZipShort;
import java.lang.reflect.Field;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import java.util.zip.ZipException;
import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

public class ResourceAlignmentExtraField_getLocalFileDataData_5_0_Test {

    private ResourceAlignmentExtraField resourceAlignmentExtraField;

    @BeforeEach
    public void setUp() {
        // Initialize the ResourceAlignmentExtraField with various parameters for testing
        resourceAlignmentExtraField = new ResourceAlignmentExtraField(0, false, 0);
    }

    @Test
    public void testGetLocalFileDataData_NoPadding_NoMethodChange() {
        resourceAlignmentExtraField = new ResourceAlignmentExtraField(0, false, 0);
        byte[] expected = new byte[ResourceAlignmentExtraField.BASE_SIZE];
        ZipShort.putShort(0, expected, 0);
        byte[] actual = resourceAlignmentExtraField.getLocalFileDataData();
        assertArrayEquals(expected, actual);
    }

    @Test
    public void testGetLocalFileDataData_NoPadding_MethodChange() {
        resourceAlignmentExtraField = new ResourceAlignmentExtraField(0, true, 0);
        byte[] expected = new byte[ResourceAlignmentExtraField.BASE_SIZE];
        ZipShort.putShort(getAllowMethodMessageChangeFlag() | 0, expected, 0);
        byte[] actual = resourceAlignmentExtraField.getLocalFileDataData();
        assertArrayEquals(expected, actual);
    }

    @Test
    public void testGetLocalFileDataData_WithPadding_NoMethodChange() {
        resourceAlignmentExtraField = new ResourceAlignmentExtraField(0, false, 2);
        byte[] expected = new byte[ResourceAlignmentExtraField.BASE_SIZE + 2];
        ZipShort.putShort(0, expected, 0);
        byte[] actual = resourceAlignmentExtraField.getLocalFileDataData();
        assertArrayEquals(expected, actual);
    }

    @Test
    public void testGetLocalFileDataData_WithPadding_MethodChange() {
        resourceAlignmentExtraField = new ResourceAlignmentExtraField(0, true, 2);
        byte[] expected = new byte[ResourceAlignmentExtraField.BASE_SIZE + 2];
        ZipShort.putShort(getAllowMethodMessageChangeFlag(), expected, 0);
        byte[] actual = resourceAlignmentExtraField.getLocalFileDataData();
        assertArrayEquals(expected, actual);
    }

    @Test
    public void testGetLocalFileDataData_NonZeroAlignment_NoPadding() {
        resourceAlignmentExtraField = new ResourceAlignmentExtraField(5, false, 0);
        byte[] expected = new byte[ResourceAlignmentExtraField.BASE_SIZE];
        ZipShort.putShort(5, expected, 0);
        byte[] actual = resourceAlignmentExtraField.getLocalFileDataData();
        assertArrayEquals(expected, actual);
    }

    @Test
    public void testGetLocalFileDataData_NonZeroAlignment_WithPadding() {
        resourceAlignmentExtraField = new ResourceAlignmentExtraField(5, true, 2);
        byte[] expected = new byte[ResourceAlignmentExtraField.BASE_SIZE + 2];
        ZipShort.putShort(5 | getAllowMethodMessageChangeFlag(), expected, 0);
        byte[] actual = resourceAlignmentExtraField.getLocalFileDataData();
        assertArrayEquals(expected, actual);
    }

    private int getAllowMethodMessageChangeFlag() {
        try {
            Field field = ResourceAlignmentExtraField.class.getDeclaredField("ALLOW_METHOD_MESSAGE_CHANGE_FLAG");
            field.setAccessible(true);
            return (int) field.get(null);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
