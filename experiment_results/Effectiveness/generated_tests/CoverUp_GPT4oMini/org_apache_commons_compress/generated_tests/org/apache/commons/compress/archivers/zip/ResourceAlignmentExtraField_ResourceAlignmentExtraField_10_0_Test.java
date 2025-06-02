package org.apache.commons.compress.archivers.zip;

import org.apache.commons.compress.archivers.zip.ZipShort;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import java.util.zip.ZipException;
import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

class ResourceAlignmentExtraField_ResourceAlignmentExtraField_10_0_Test {

    private ResourceAlignmentExtraField resourceAlignmentExtraField;

    @BeforeEach
    void setUp() {
        resourceAlignmentExtraField = new ResourceAlignmentExtraField();
    }

    @Test
    void testConstructorWithAlignment() {
        int alignment = 16;
        resourceAlignmentExtraField = new ResourceAlignmentExtraField(alignment);
        assertEquals(alignment, resourceAlignmentExtraField.getAlignment());
        assertFalse(resourceAlignmentExtraField.allowMethodChange());
    }

    @Test
    void testConstructorWithAlignmentAndAllowMethodChange() {
        int alignment = 32;
        boolean allowMethodChange = true;
        resourceAlignmentExtraField = new ResourceAlignmentExtraField(alignment, allowMethodChange);
        assertEquals(alignment, resourceAlignmentExtraField.getAlignment());
        assertTrue(resourceAlignmentExtraField.allowMethodChange());
    }

    @Test
    void testConstructorWithAlignmentAllowMethodChangeAndPadding() {
        int alignment = 64;
        boolean allowMethodChange = false;
        int padding = 10;
        resourceAlignmentExtraField = new ResourceAlignmentExtraField(alignment, allowMethodChange, padding);
        assertEquals(alignment, resourceAlignmentExtraField.getAlignment());
        assertFalse(resourceAlignmentExtraField.allowMethodChange());
        assertEquals(padding, resourceAlignmentExtraField.getLocalFileDataLength().getValue() - ResourceAlignmentExtraField.BASE_SIZE);
    }

    @Test
    void testParseFromCentralDirectoryDataWithValidData() throws ZipException {
        // alignment = 16
        byte[] data = new byte[] { 0x00, 0x10 };
        resourceAlignmentExtraField.parseFromCentralDirectoryData(data, 0, data.length);
        assertEquals(16, resourceAlignmentExtraField.getAlignment());
        assertFalse(resourceAlignmentExtraField.allowMethodChange());
    }

    @Test
    void testParseFromCentralDirectoryDataWithInvalidData() {
        // too short
        byte[] data = new byte[] { 0x00 };
        assertThrows(ZipException.class, () -> {
            resourceAlignmentExtraField.parseFromCentralDirectoryData(data, 0, data.length);
        });
    }

    @Test
    void testGetCentralDirectoryData() {
        resourceAlignmentExtraField = new ResourceAlignmentExtraField(16, true);
        byte[] centralData = resourceAlignmentExtraField.getCentralDirectoryData();
        assertEquals(0x8000 | 16, ZipShort.getValue(centralData, 0));
    }

    @Test
    void testGetLocalFileDataData() {
        resourceAlignmentExtraField = new ResourceAlignmentExtraField(32, false, 5);
        byte[] localData = resourceAlignmentExtraField.getLocalFileDataData();
        assertEquals(32, ZipShort.getValue(localData, 0));
        assertEquals(5 + ResourceAlignmentExtraField.BASE_SIZE, localData.length);
    }

    @Test
    void testGetHeaderId() {
        assertEquals(ResourceAlignmentExtraField.ID, resourceAlignmentExtraField.getHeaderId());
    }

    @Test
    void testGetCentralDirectoryLength() {
        assertEquals(ResourceAlignmentExtraField.BASE_SIZE, resourceAlignmentExtraField.getCentralDirectoryLength().getValue());
    }
}
