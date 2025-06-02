package org.apache.commons.compress.archivers.zip;

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

public class Zip64ExtendedInformationExtraField_getLocalFileDataData_6_0_Test {

    private Zip64ExtendedInformationExtraField zip64Field;

    @BeforeEach
    public void setUp() {
        zip64Field = new Zip64ExtendedInformationExtraField();
    }

    @Test
    public void testGetLocalFileDataData_WithBothSizesSet() {
        ZipEightByteInteger size = new ZipEightByteInteger(1024);
        ZipEightByteInteger compressedSize = new ZipEightByteInteger(512);
        zip64Field.setSize(size);
        zip64Field.setCompressedSize(compressedSize);
        byte[] expectedData = new byte[2 * DWORD];
        System.arraycopy(size.getBytes(), 0, expectedData, 0, DWORD);
        System.arraycopy(compressedSize.getBytes(), 0, expectedData, DWORD, DWORD);
        byte[] actualData = zip64Field.getLocalFileDataData();
        assertArrayEquals(expectedData, actualData);
    }

    @Test
    public void testGetLocalFileDataData_WithSizeNotSet() {
        ZipEightByteInteger compressedSize = new ZipEightByteInteger(512);
        zip64Field.setCompressedSize(compressedSize);
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> zip64Field.getLocalFileDataData());
        assertArrayEquals("Zip64 extended information must contain both size values in the local file header.".getBytes(), exception.getMessage().getBytes());
    }

    @Test
    public void testGetLocalFileDataData_WithCompressedSizeNotSet() {
        ZipEightByteInteger size = new ZipEightByteInteger(1024);
        zip64Field.setSize(size);
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> zip64Field.getLocalFileDataData());
        assertArrayEquals("Zip64 extended information must contain both size values in the local file header.".getBytes(), exception.getMessage().getBytes());
    }

    @Test
    public void testGetLocalFileDataData_WithNoSizesSet() {
        byte[] expectedData = ByteUtils.EMPTY_BYTE_ARRAY;
        byte[] actualData = zip64Field.getLocalFileDataData();
        assertArrayEquals(expectedData, actualData);
    }
}
