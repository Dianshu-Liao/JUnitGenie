package org.apache.commons.compress.archivers.zip;

import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import org.mockito.junit.jupiter.MockitoExtension;
import java.util.zip.ZipException;

class ResourceAlignmentExtraField_ResourceAlignmentExtraField_12_0_Test {

    @Test
    void testValidConstructor() {
        ResourceAlignmentExtraField field = new ResourceAlignmentExtraField(1000, true, 10);
        assertEquals(1000, field.getAlignment());
        assertTrue(field.allowMethodChange());
    }

    @Test
    void testAlignmentTooLow() {
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> {
            new ResourceAlignmentExtraField(-1, true, 10);
        });
        assertEquals("Alignment must be between 0 and 0x7fff, was: -1", exception.getMessage());
    }

    @Test
    void testAlignmentTooHigh() {
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> {
            new ResourceAlignmentExtraField(0x8000, true, 10);
        });
        assertEquals("Alignment must be between 0 and 0x7fff, was: 32768", exception.getMessage());
    }

    @Test
    void testNegativePadding() {
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> {
            new ResourceAlignmentExtraField(1000, true, -1);
        });
        assertEquals("Padding must not be negative, was: -1", exception.getMessage());
    }

    @Test
    void testGetCentralDirectoryData() {
        ResourceAlignmentExtraField field = new ResourceAlignmentExtraField(1000, true, 10);
        byte[] data = field.getCentralDirectoryData();
        assertNotNull(data);
        assertEquals(2, data.length);
    }

    @Test
    void testGetLocalFileDataData() {
        ResourceAlignmentExtraField field = new ResourceAlignmentExtraField(1000, true, 10);
        byte[] localData = field.getLocalFileDataData();
        assertNotNull(localData);
        // BASE_SIZE + padding
        assertEquals(12, localData.length);
    }

    @Test
    void testParseFromCentralDirectoryData() throws ZipException {
        ResourceAlignmentExtraField field = new ResourceAlignmentExtraField();
        byte[] buffer = new byte[] { (byte) 0xE8, (byte) 0x03 };
        field.parseFromCentralDirectoryData(buffer, 0, buffer.length);
        assertEquals(1000, field.getAlignment());
        assertTrue(field.allowMethodChange());
    }

    @Test
    void testParseFromCentralDirectoryDataTooShort() {
        ResourceAlignmentExtraField field = new ResourceAlignmentExtraField();
        ZipException exception = assertThrows(ZipException.class, () -> {
            field.parseFromCentralDirectoryData(new byte[] {}, 0, 0);
        });
        assertEquals("Too short content for ResourceAlignmentExtraField (0xa11e): 0", exception.getMessage());
    }

    @Test
    void testParseFromLocalFileData() throws ZipException {
        ResourceAlignmentExtraField field = new ResourceAlignmentExtraField();
        byte[] buffer = new byte[] { (byte) 0xE8, (byte) 0x03 };
        field.parseFromLocalFileData(buffer, 0, buffer.length);
        assertEquals(1000, field.getAlignment());
        assertTrue(field.allowMethodChange());
    }
}
