package org.apache.commons.compress.archivers.zip;

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

public class Zip64ExtendedInformationExtraField_parseFromCentralDirectoryData_10_0_Test {

    private Zip64ExtendedInformationExtraField zip64Field;

    @BeforeEach
    public void setUp() {
        zip64Field = new Zip64ExtendedInformationExtraField();
    }

    @Test
    public void testParseFromCentralDirectoryData_ValidData_AllFields() throws ZipException {
        // 3 * DWORD
        byte[] buffer = new byte[24];
        // Fill buffer with test data
        for (int i = 0; i < buffer.length; i++) {
            buffer[i] = (byte) i;
        }
        zip64Field.parseFromCentralDirectoryData(buffer, 0, buffer.length);
        // Assuming buffer[0-7] represents size
        assertEquals(8, zip64Field.getSize().getLongValue());
        // Assuming buffer[8-15] represents compressedSize
        assertEquals(8, zip64Field.getCompressedSize().getLongValue());
        // Assuming buffer[16-23] represents relativeHeaderOffset
        assertEquals(8, zip64Field.getRelativeHeaderOffset().getLongValue());
    }

    @Test
    public void testParseFromCentralDirectoryData_Length24() throws ZipException {
        // 3 * DWORD
        byte[] buffer = new byte[24];
        // Fill buffer with test data
        for (int i = 0; i < buffer.length; i++) {
            buffer[i] = (byte) i;
        }
        zip64Field.parseFromCentralDirectoryData(buffer, 0, buffer.length);
        // Assuming buffer[0-7] represents size
        assertEquals(8, zip64Field.getSize().getLongValue());
        // Assuming buffer[8-15] represents compressedSize
        assertEquals(8, zip64Field.getCompressedSize().getLongValue());
        // Assuming buffer[16-23] represents relativeHeaderOffset
        assertEquals(8, zip64Field.getRelativeHeaderOffset().getLongValue());
    }

    @Test
    public void testParseFromCentralDirectoryData_Length16() throws ZipException {
        // 2 * DWORD
        byte[] buffer = new byte[16];
        // Fill buffer with test data
        for (int i = 0; i < buffer.length; i++) {
            buffer[i] = (byte) i;
        }
        zip64Field.parseFromCentralDirectoryData(buffer, 0, buffer.length);
        // Assuming buffer[0-7] represents size
        assertEquals(8, zip64Field.getSize().getLongValue());
        // Assuming buffer[8-15] represents compressedSize
        assertEquals(8, zip64Field.getCompressedSize().getLongValue());
        // Should be null
        assertEquals(null, zip64Field.getRelativeHeaderOffset());
    }

    @Test
    public void testParseFromCentralDirectoryData_LengthLessThan16() throws ZipException {
        // Less than 2 * DWORD
        byte[] buffer = new byte[8];
        // Fill buffer with test data
        for (int i = 0; i < buffer.length; i++) {
            buffer[i] = (byte) i;
        }
        zip64Field.parseFromCentralDirectoryData(buffer, 0, buffer.length);
        // Should be null
        assertEquals(null, zip64Field.getSize());
        // Should be null
        assertEquals(null, zip64Field.getCompressedSize());
        // Should be null
        assertEquals(null, zip64Field.getRelativeHeaderOffset());
    }

    @Test
    public void testParseFromCentralDirectoryData_ThrowsZipException() {
        // Empty buffer
        byte[] buffer = new byte[0];
        assertThrows(ZipException.class, () -> {
            zip64Field.parseFromCentralDirectoryData(buffer, 0, buffer.length);
        });
    }

    @Test
    public void testParseFromCentralDirectoryData_LengthNotMultipleOfDWORD() throws ZipException {
        // Length not a multiple of DWORD
        byte[] buffer = new byte[20];
        // Fill buffer with test data
        for (int i = 0; i < buffer.length; i++) {
            buffer[i] = (byte) i;
        }
        zip64Field.parseFromCentralDirectoryData(buffer, 0, buffer.length);
    }
}
