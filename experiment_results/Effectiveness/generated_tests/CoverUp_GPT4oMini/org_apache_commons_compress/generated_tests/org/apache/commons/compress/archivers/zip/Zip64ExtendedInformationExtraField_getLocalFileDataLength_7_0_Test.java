package org.apache.commons.compress.archivers.zip;

import org.apache.commons.compress.archivers.zip.Zip64ExtendedInformationExtraField;
import org.apache.commons.compress.archivers.zip.ZipEightByteInteger;
import org.apache.commons.compress.archivers.zip.ZipLong;
import org.apache.commons.compress.archivers.zip.ZipShort;
import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import static org.apache.commons.compress.archivers.zip.ZipConstants.DWORD;
import static org.apache.commons.compress.archivers.zip.ZipConstants.WORD;
import java.util.zip.ZipException;
import org.apache.commons.compress.utils.ByteUtils;

public class Zip64ExtendedInformationExtraField_getLocalFileDataLength_7_0_Test {

    private Zip64ExtendedInformationExtraField field;

    @BeforeEach
    public void setUp() {
        field = new Zip64ExtendedInformationExtraField();
    }

    @Test
    public void testGetLocalFileDataLength_WhenSizeIsNull_ShouldReturnZero() {
        ZipShort result = field.getLocalFileDataLength();
        assertEquals(new ZipShort(0), result);
    }

    @Test
    public void testGetLocalFileDataLength_WhenSizeIsNotNull_ShouldReturnCorrectLength() {
        ZipEightByteInteger size = new ZipEightByteInteger(new byte[8]);
        field.setSize(size);
        ZipShort result = field.getLocalFileDataLength();
        // 2 * DWORD = 8
        assertEquals(new ZipShort(8), result);
    }

    @Test
    public void testGetLocalFileDataData_WhenBothSizesAreNull_ShouldReturnEmptyArray() {
        byte[] result = field.getLocalFileDataData();
        assertEquals(0, result.length);
    }

    @Test
    public void testGetLocalFileDataData_WhenOnlySizeIsNull_ShouldThrowException() {
        field.setCompressedSize(new ZipEightByteInteger(new byte[8]));
        IllegalArgumentException thrown = assertThrows(IllegalArgumentException.class, () -> {
            field.getLocalFileDataData();
        });
        assertEquals("Zip64 extended information must contain both size values in the local file header.", thrown.getMessage());
    }

    @Test
    public void testGetLocalFileDataData_WhenBothSizesAreSet_ShouldReturnData() {
        ZipEightByteInteger size = new ZipEightByteInteger(new byte[8]);
        ZipEightByteInteger compressedSize = new ZipEightByteInteger(new byte[8]);
        field.setSize(size);
        field.setCompressedSize(compressedSize);
        byte[] result = field.getLocalFileDataData();
        // 2 * DWORD = 8
        assertEquals(8, result.length);
    }

    @Test
    public void testGetCentralDirectoryLength_WhenAllFieldsAreNull_ShouldReturnZero() {
        ZipShort result = field.getCentralDirectoryLength();
        assertEquals(new ZipShort(0), result);
    }

    @Test
    public void testGetCentralDirectoryLength_WhenSomeFieldsAreSet_ShouldReturnCorrectLength() {
        ZipEightByteInteger size = new ZipEightByteInteger(new byte[8]);
        ZipEightByteInteger compressedSize = new ZipEightByteInteger(new byte[8]);
        field.setSize(size);
        field.setCompressedSize(compressedSize);
        ZipShort result = field.getCentralDirectoryLength();
        // 2 * DWORD = 8
        assertEquals(new ZipShort(8), result);
    }

    @Test
    public void testParseFromLocalFileData_WhenLengthIsZero_ShouldNotThrow() throws Exception {
        byte[] buffer = new byte[0];
        // Should not throw
        field.parseFromLocalFileData(buffer, 0, 0);
    }

    @Test
    public void testParseFromLocalFileData_WhenLengthIsLessThanRequired_ShouldThrow() {
        // Less than 2 * DWORD
        byte[] buffer = new byte[4];
        assertThrows(ZipException.class, () -> {
            field.parseFromLocalFileData(buffer, 0, buffer.length);
        });
    }

    @Test
    public void testParseFromLocalFileData_WhenValidData_ShouldSetFields() throws Exception {
        // Enough for size and compressedSize
        byte[] buffer = new byte[16];
        field.parseFromLocalFileData(buffer, 0, buffer.length);
        assertEquals(new ZipEightByteInteger(buffer, 0), field.getSize());
        assertEquals(new ZipEightByteInteger(buffer, 4), field.getCompressedSize());
    }
}
