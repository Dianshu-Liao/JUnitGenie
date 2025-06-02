package org.apache.commons.compress.archivers.zip;

import org.apache.commons.compress.archivers.zip.ZipShort;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import java.lang.reflect.Field;
import java.util.zip.ZipException;
import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

class ResourceAlignmentExtraField_ResourceAlignmentExtraField_11_0_Test {

    @Test
    void testConstructorWithAlignmentAndAllowMethodChange() {
        // Test with alignment = 0 and allowMethodChange = false
        ResourceAlignmentExtraField field = new ResourceAlignmentExtraField(0, false);
        assertEquals(0, field.getAlignment());
        assertFalse(field.allowMethodChange());
        // Test with alignment = 0 and allowMethodChange = true
        field = new ResourceAlignmentExtraField(0, true);
        assertEquals(0, field.getAlignment());
        assertTrue(field.allowMethodChange());
        // Test with alignment = 1 and allowMethodChange = false
        field = new ResourceAlignmentExtraField(1, false);
        assertEquals(1, field.getAlignment());
        assertFalse(field.allowMethodChange());
        // Test with alignment = 1 and allowMethodChange = true
        field = new ResourceAlignmentExtraField(1, true);
        assertEquals(1, field.getAlignment());
        assertTrue(field.allowMethodChange());
        // Test with maximum alignment value (assuming short max value)
        field = new ResourceAlignmentExtraField(Short.MAX_VALUE, false);
        assertEquals(Short.MAX_VALUE, field.getAlignment());
        assertFalse(field.allowMethodChange());
        // Test with maximum alignment value and allowMethodChange = true
        field = new ResourceAlignmentExtraField(Short.MAX_VALUE, true);
        assertEquals(Short.MAX_VALUE, field.getAlignment());
        assertTrue(field.allowMethodChange());
    }

    @Test
    void testGetCentralDirectoryData() {
        ResourceAlignmentExtraField field = new ResourceAlignmentExtraField(1, true);
        byte[] data = field.getCentralDirectoryData();
        assertNotNull(data);
        assertEquals(2, data.length);
        // 1 | ALLOW_METHOD_MESSAGE_CHANGE_FLAG
        assertEquals(0x8001, ZipShort.getValue(data, 0));
        field = new ResourceAlignmentExtraField(1, false);
        data = field.getCentralDirectoryData();
        // Just alignment
        assertEquals(0x0001, ZipShort.getValue(data, 0));
    }

    @Test
    void testGetLocalFileDataData() {
        ResourceAlignmentExtraField field = new ResourceAlignmentExtraField(1, true);
        byte[] data = field.getLocalFileDataData();
        assertNotNull(data);
        assertEquals(2, data.length);
        // 1 | ALLOW_METHOD_MESSAGE_CHANGE_FLAG
        assertEquals(0x8001, ZipShort.getValue(data, 0));
        field = new ResourceAlignmentExtraField(1, false);
        data = field.getLocalFileDataData();
        // Just alignment
        assertEquals(0x0001, ZipShort.getValue(data, 0));
    }

    @Test
    void testParseFromCentralDirectoryData() throws Exception {
        ResourceAlignmentExtraField field = new ResourceAlignmentExtraField();
        // alignment = 1, allowMethodChange = true
        byte[] buffer = new byte[] { 0x01, (byte) 0x80 };
        field.parseFromCentralDirectoryData(buffer, 0, buffer.length);
        assertEquals(1, field.getAlignment());
        assertTrue(field.allowMethodChange());
        // alignment = 1, allowMethodChange = false
        buffer = new byte[] { 0x01, 0x00 };
        field.parseFromCentralDirectoryData(buffer, 0, buffer.length);
        assertEquals(1, field.getAlignment());
        assertFalse(field.allowMethodChange());
        // Test exception for too short content
        assertThrows(ZipException.class, () -> {
            field.parseFromCentralDirectoryData(new byte[] { 0x01 }, 0, 1);
        });
    }
}
