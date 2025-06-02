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

public class Zip64ExtendedInformationExtraField_getCentralDirectoryLength_2_0_Test {

    private Zip64ExtendedInformationExtraField zip64ExtendedInfo;

    @BeforeEach
    public void setUp() {
        zip64ExtendedInfo = new Zip64ExtendedInformationExtraField();
    }

    @Test
    public void testGetCentralDirectoryLength_withAllSizes() {
        // Arrange
        setPrivateField(zip64ExtendedInfo, "size", new ZipEightByteInteger(1024));
        setPrivateField(zip64ExtendedInfo, "compressedSize", new ZipEightByteInteger(512));
        setPrivateField(zip64ExtendedInfo, "relativeHeaderOffset", new ZipEightByteInteger(256));
        setPrivateField(zip64ExtendedInfo, "diskStart", new ZipLong(1));
        // Act
        ZipShort result = zip64ExtendedInfo.getCentralDirectoryLength();
        // Assert
        assertNotNull(result);
        // 4 + 4 + 4 + 2 = 14 (DWORDs) + WORD (2)
        assertEquals(16, result.getValue());
    }

    @Test
    public void testGetCentralDirectoryLength_withSizeOnly() {
        // Arrange
        setPrivateField(zip64ExtendedInfo, "size", new ZipEightByteInteger(1024));
        setPrivateField(zip64ExtendedInfo, "compressedSize", null);
        setPrivateField(zip64ExtendedInfo, "relativeHeaderOffset", null);
        setPrivateField(zip64ExtendedInfo, "diskStart", null);
        // Act
        ZipShort result = zip64ExtendedInfo.getCentralDirectoryLength();
        // Assert
        assertNotNull(result);
        // Only size is present
        assertEquals(4, result.getValue());
    }

    @Test
    public void testGetCentralDirectoryLength_withCompressedSizeOnly() {
        // Arrange
        setPrivateField(zip64ExtendedInfo, "size", null);
        setPrivateField(zip64ExtendedInfo, "compressedSize", new ZipEightByteInteger(512));
        setPrivateField(zip64ExtendedInfo, "relativeHeaderOffset", null);
        setPrivateField(zip64ExtendedInfo, "diskStart", null);
        // Act
        ZipShort result = zip64ExtendedInfo.getCentralDirectoryLength();
        // Assert
        assertNotNull(result);
        // Only compressedSize is present
        assertEquals(4, result.getValue());
    }

    @Test
    public void testGetCentralDirectoryLength_withRelativeHeaderOffsetOnly() {
        // Arrange
        setPrivateField(zip64ExtendedInfo, "size", null);
        setPrivateField(zip64ExtendedInfo, "compressedSize", null);
        setPrivateField(zip64ExtendedInfo, "relativeHeaderOffset", new ZipEightByteInteger(256));
        setPrivateField(zip64ExtendedInfo, "diskStart", null);
        // Act
        ZipShort result = zip64ExtendedInfo.getCentralDirectoryLength();
        // Assert
        assertNotNull(result);
        // Only relativeHeaderOffset is present
        assertEquals(4, result.getValue());
    }

    @Test
    public void testGetCentralDirectoryLength_withDiskStartOnly() {
        // Arrange
        setPrivateField(zip64ExtendedInfo, "size", null);
        setPrivateField(zip64ExtendedInfo, "compressedSize", null);
        setPrivateField(zip64ExtendedInfo, "relativeHeaderOffset", null);
        setPrivateField(zip64ExtendedInfo, "diskStart", new ZipLong(1));
        // Act
        ZipShort result = zip64ExtendedInfo.getCentralDirectoryLength();
        // Assert
        assertNotNull(result);
        // Only diskStart is present
        assertEquals(2, result.getValue());
    }

    private void setPrivateField(Object obj, String fieldName, Object value) {
        try {
            java.lang.reflect.Field field = obj.getClass().getDeclaredField(fieldName);
            field.setAccessible(true);
            field.set(obj, value);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
