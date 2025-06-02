package org.apache.commons.compress.archivers.zip;

import java.lang.reflect.InvocationTargetException;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import org.mockito.junit.jupiter.MockitoExtension;
import java.util.zip.ZipException;

class ResourceAlignmentExtraField_ResourceAlignmentExtraField_9_0_Test {

    private ResourceAlignmentExtraField resourceAlignmentExtraField;

    @BeforeEach
    void setUp() {
        resourceAlignmentExtraField = new ResourceAlignmentExtraField();
    }

    @Test
    void testDefaultConstructor() {
        assertNotNull(resourceAlignmentExtraField);
        assertEquals(0, resourceAlignmentExtraField.getAlignment());
        assertFalse(resourceAlignmentExtraField.allowMethodChange());
    }

    @Test
    void testConstructorWithAlignment() {
        resourceAlignmentExtraField = new ResourceAlignmentExtraField(16);
        assertEquals(16, resourceAlignmentExtraField.getAlignment());
        assertFalse(resourceAlignmentExtraField.allowMethodChange());
    }

    @Test
    void testConstructorWithAlignmentAndAllowMethodChange() {
        resourceAlignmentExtraField = new ResourceAlignmentExtraField(16, true);
        assertEquals(16, resourceAlignmentExtraField.getAlignment());
        assertTrue(resourceAlignmentExtraField.allowMethodChange());
    }

    @Test
    void testConstructorWithAlignmentAllowMethodChangeAndPadding() {
        resourceAlignmentExtraField = new ResourceAlignmentExtraField(16, true, 4);
        assertEquals(16, resourceAlignmentExtraField.getAlignment());
        assertTrue(resourceAlignmentExtraField.allowMethodChange());
        assertEquals(4, resourceAlignmentExtraField.getLocalFileDataLength().getValue() - ResourceAlignmentExtraField.BASE_SIZE);
    }

    @Test
    void testParseFromCentralDirectoryDataTooShort() {
        // Too short
        byte[] buffer = new byte[1];
        assertThrows(java.util.zip.ZipException.class, () -> {
            resourceAlignmentExtraField.parseFromCentralDirectoryData(buffer, 0, buffer.length);
        });
    }

    @Test
    void testParseFromCentralDirectoryData() throws java.util.zip.ZipException {
        // alignment = 16
        byte[] buffer = new byte[] { 0x10, 0x00 };
        resourceAlignmentExtraField.parseFromCentralDirectoryData(buffer, 0, buffer.length);
        assertEquals(16, resourceAlignmentExtraField.getAlignment());
        assertFalse(resourceAlignmentExtraField.allowMethodChange());
    }

    @Test
    void testParseFromLocalFileData() throws java.util.zip.ZipException {
        // alignment = 16
        byte[] buffer = new byte[] { 0x10, 0x00 };
        resourceAlignmentExtraField.parseFromLocalFileData(buffer, 0, buffer.length);
        assertEquals(16, resourceAlignmentExtraField.getAlignment());
        assertFalse(resourceAlignmentExtraField.allowMethodChange());
        assertEquals(0, resourceAlignmentExtraField.getLocalFileDataLength().getValue() - ResourceAlignmentExtraField.BASE_SIZE);
    }

    @Test
    void testGetCentralDirectoryData() {
        byte[] data = resourceAlignmentExtraField.getCentralDirectoryData();
        assertEquals(2, data.length);
        assertEquals(0, ZipShort.getValue(data, 0));
    }

    @Test
    void testGetLocalFileDataData() {
        byte[] data = resourceAlignmentExtraField.getLocalFileDataData();
        assertEquals(ResourceAlignmentExtraField.BASE_SIZE, data.length);
        assertEquals(0, ZipShort.getValue(data, 0));
    }

    @Test
    void testGetCentralDirectoryLength() {
        assertEquals(ResourceAlignmentExtraField.BASE_SIZE, resourceAlignmentExtraField.getCentralDirectoryLength().getValue());
    }

    @Test
    void testGetHeaderId() {
        assertEquals(ResourceAlignmentExtraField.ID, resourceAlignmentExtraField.getHeaderId());
    }
}
