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

public class Zip64ExtendedInformationExtraField_getLocalFileDataLength_7_0_Test {

    private Zip64ExtendedInformationExtraField zip64ExtendedInfo;

    @BeforeEach
    public void setUp() {
        zip64ExtendedInfo = new Zip64ExtendedInformationExtraField();
    }

    @Test
    public void testGetLocalFileDataLength_WhenSizeIsNull() {
        // Arrange
        // No additional setup needed as size is null by default
        // Act
        ZipShort result = zip64ExtendedInfo.getLocalFileDataLength();
        // Assert
        assertEquals(new ZipShort(0), result);
    }

    @Test
    public void testGetLocalFileDataLength_WhenSizeIsNotNull() {
        // Arrange
        ZipEightByteInteger size = new ZipEightByteInteger(1);
        ZipEightByteInteger compressedSize = new ZipEightByteInteger(1);
        zip64ExtendedInfo = new Zip64ExtendedInformationExtraField(size, compressedSize);
        // Act
        ZipShort result = zip64ExtendedInfo.getLocalFileDataLength();
        // Assert
        // Assuming DWORD is 4
        assertEquals(new ZipShort(2 * 4), result);
    }

    @Test
    public void testGetLocalFileDataLength_WhenOnlyCompressedSizeIsNotNull() {
        // Arrange
        ZipEightByteInteger compressedSize = new ZipEightByteInteger(1);
        zip64ExtendedInfo.setCompressedSize(compressedSize);
        // Act
        ZipShort result = zip64ExtendedInfo.getLocalFileDataLength();
        // Assert
        // Size is still null
        assertEquals(new ZipShort(0), result);
    }

    @Test
    public void testGetLocalFileDataLength_WhenBothSizesAreNotNull() {
        // Arrange
        ZipEightByteInteger size = new ZipEightByteInteger(1);
        ZipEightByteInteger compressedSize = new ZipEightByteInteger(1);
        zip64ExtendedInfo.setSize(size);
        zip64ExtendedInfo.setCompressedSize(compressedSize);
        // Act
        ZipShort result = zip64ExtendedInfo.getLocalFileDataLength();
        // Assert
        // Assuming DWORD is 4
        assertEquals(new ZipShort(2 * 4), result);
    }
}
