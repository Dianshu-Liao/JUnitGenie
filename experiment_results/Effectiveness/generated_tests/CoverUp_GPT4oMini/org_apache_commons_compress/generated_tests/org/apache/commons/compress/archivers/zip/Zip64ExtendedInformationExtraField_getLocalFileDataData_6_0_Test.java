package org.apache.commons.compress.archivers.zip;

import org.apache.commons.compress.archivers.zip.ZipEightByteInteger;
import org.apache.commons.compress.archivers.zip.ZipLong;
import org.apache.commons.compress.archivers.zip.Zip64ExtendedInformationExtraField;
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
    public void testGetLocalFileDataDataWithBothSizes() {
        ZipEightByteInteger size = new ZipEightByteInteger(1024);
        ZipEightByteInteger compressedSize = new ZipEightByteInteger(512);
        zip64Field.setSize(size);
        zip64Field.setCompressedSize(compressedSize);
        byte[] result = zip64Field.getLocalFileDataData();
        assertNotNull(result);
        // 2 * DWORD = 8
        assertEquals(8, result.length);
    }

    @Test
    public void testGetLocalFileDataDataWithSizeNull() {
        ZipEightByteInteger compressedSize = new ZipEightByteInteger(512);
        zip64Field.setCompressedSize(compressedSize);
        IllegalArgumentException thrown = assertThrows(IllegalArgumentException.class, () -> {
            zip64Field.getLocalFileDataData();
        });
        assertEquals("Zip64 extended information must contain both size values in the local file header.", thrown.getMessage());
    }

    @Test
    public void testGetLocalFileDataDataWithCompressedSizeNull() {
        ZipEightByteInteger size = new ZipEightByteInteger(1024);
        zip64Field.setSize(size);
        IllegalArgumentException thrown = assertThrows(IllegalArgumentException.class, () -> {
            zip64Field.getLocalFileDataData();
        });
        assertEquals("Zip64 extended information must contain both size values in the local file header.", thrown.getMessage());
    }

    @Test
    public void testGetLocalFileDataDataWithBothSizesNull() {
        byte[] result = zip64Field.getLocalFileDataData();
        assertNotNull(result);
        // Should return empty byte array
        assertEquals(0, result.length);
    }
}
