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

    private Zip64ExtendedInformationExtraField zip64Field;

    @BeforeEach
    public void setUp() {
        zip64Field = new Zip64ExtendedInformationExtraField();
    }

    @Test
    public void testGetCentralDirectoryLength_WhenAllFieldsAreNull() {
        // Arrange
        // No fields are set, so all should be null.
        // Act
        ZipShort result = zip64Field.getCentralDirectoryLength();
        // Assert
        assertEquals(new ZipShort(0), result);
    }

    @Test
    public void testGetCentralDirectoryLength_WhenSizeIsSet() {
        // Arrange
        zip64Field = new Zip64ExtendedInformationExtraField(new ZipEightByteInteger(1), null, null, null);
        // Act
        ZipShort result = zip64Field.getCentralDirectoryLength();
        // Assert
        assertEquals(new ZipShort(DWORD), result);
    }

    @Test
    public void testGetCentralDirectoryLength_WhenCompressedSizeIsSet() {
        // Arrange
        zip64Field = new Zip64ExtendedInformationExtraField(null, new ZipEightByteInteger(1), null, null);
        // Act
        ZipShort result = zip64Field.getCentralDirectoryLength();
        // Assert
        assertEquals(new ZipShort(DWORD), result);
    }

    @Test
    public void testGetCentralDirectoryLength_WhenRelativeHeaderOffsetIsSet() {
        // Arrange
        zip64Field = new Zip64ExtendedInformationExtraField(null, null, new ZipEightByteInteger(1), null);
        // Act
        ZipShort result = zip64Field.getCentralDirectoryLength();
        // Assert
        assertEquals(new ZipShort(DWORD), result);
    }

    @Test
    public void testGetCentralDirectoryLength_WhenDiskStartIsSet() {
        // Arrange
        zip64Field = new Zip64ExtendedInformationExtraField(null, null, null, new ZipLong(1));
        // Act
        ZipShort result = zip64Field.getCentralDirectoryLength();
        // Assert
        assertEquals(new ZipShort(WORD), result);
    }

    @Test
    public void testGetCentralDirectoryLength_WhenAllFieldsAreSet() {
        // Arrange
        zip64Field = new Zip64ExtendedInformationExtraField(new ZipEightByteInteger(1), new ZipEightByteInteger(1), new ZipEightByteInteger(1), new ZipLong(1));
        // Act
        ZipShort result = zip64Field.getCentralDirectoryLength();
        // Assert
        assertEquals(new ZipShort(DWORD + DWORD + DWORD + WORD), result);
    }
}
