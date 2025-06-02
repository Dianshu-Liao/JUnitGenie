package org.apache.commons.compress.archivers.zip;

import org.apache.commons.compress.archivers.zip.ZipEightByteInteger;
import org.apache.commons.compress.archivers.zip.ZipLong;
import org.apache.commons.compress.archivers.zip.ZipShort;
import org.apache.commons.compress.archivers.zip.Zip64ExtendedInformationExtraField;
import java.lang.reflect.Method;
import java.util.zip.ZipException;
import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import static org.apache.commons.compress.archivers.zip.ZipConstants.DWORD;
import static org.apache.commons.compress.archivers.zip.ZipConstants.WORD;
import org.apache.commons.compress.utils.ByteUtils;

class Zip64ExtendedInformationExtraField_parseFromCentralDirectoryData_10_0_Test {

    private Zip64ExtendedInformationExtraField zip64Field;

    @BeforeEach
    void setUp() {
        zip64Field = new Zip64ExtendedInformationExtraField();
    }

    @Test
    void testParseFromCentralDirectoryData_withValidData() throws Exception {
        byte[] buffer = new byte[24];
        // Fill buffer with valid data for size, compressedSize, and relativeHeaderOffset
        for (int i = 0; i < 24; i++) {
            buffer[i] = (byte) i;
        }
        zip64Field.parseFromCentralDirectoryData(buffer, 0, buffer.length);
        assertNotNull(zip64Field.getSize());
        assertNotNull(zip64Field.getCompressedSize());
        assertNotNull(zip64Field.getRelativeHeaderOffset());
        assertNull(zip64Field.getDiskStartNumber());
    }

    @Test
    void testParseFromCentralDirectoryData_withOnlySizes() throws Exception {
        // 3 * DWORD
        byte[] buffer = new byte[12];
        // Fill buffer with valid data for size and compressedSize
        for (int i = 0; i < 12; i++) {
            buffer[i] = (byte) i;
        }
        zip64Field.parseFromCentralDirectoryData(buffer, 0, buffer.length);
        assertNotNull(zip64Field.getSize());
        assertNotNull(zip64Field.getCompressedSize());
        assertNull(zip64Field.getRelativeHeaderOffset());
        assertNull(zip64Field.getDiskStartNumber());
    }

    @Test
    void testParseFromCentralDirectoryData_withDiskStart() throws Exception {
        // length % DWORD == WORD
        byte[] buffer = new byte[8];
        // Fill the buffer with data such that the last 4 bytes represent diskStart
        for (int i = 0; i < 8; i++) {
            buffer[i] = (byte) i;
        }
        zip64Field.parseFromCentralDirectoryData(buffer, 0, buffer.length);
        assertNull(zip64Field.getSize());
        assertNull(zip64Field.getCompressedSize());
        assertNull(zip64Field.getRelativeHeaderOffset());
        assertNotNull(zip64Field.getDiskStartNumber());
    }

    @Test
    void testParseFromCentralDirectoryData_withInvalidLength() {
        // Invalid length for size and compressedSize
        byte[] buffer = new byte[5];
        ZipException exception = assertThrows(ZipException.class, () -> {
            zip64Field.parseFromCentralDirectoryData(buffer, 0, buffer.length);
        });
        assertEquals("Zip64 extended information must contain both size values in the local file header.", exception.getMessage());
    }

    @Test
    void testParseFromCentralDirectoryData_withZeroLength() throws Exception {
        zip64Field.parseFromCentralDirectoryData(new byte[0], 0, 0);
        assertNull(zip64Field.getSize());
        assertNull(zip64Field.getCompressedSize());
        assertNull(zip64Field.getRelativeHeaderOffset());
        assertNull(zip64Field.getDiskStartNumber());
    }

    @Test
    void testParseFromCentralDirectoryData_withNullBuffer() {
        assertThrows(NullPointerException.class, () -> {
            zip64Field.parseFromCentralDirectoryData(null, 0, 0);
        });
    }

    @Test
    void testParseFromCentralDirectoryData_withInsufficientData() {
        // Insufficient data
        byte[] buffer = new byte[10];
        assertThrows(ZipException.class, () -> {
            zip64Field.parseFromCentralDirectoryData(buffer, 0, buffer.length);
        });
    }
}
