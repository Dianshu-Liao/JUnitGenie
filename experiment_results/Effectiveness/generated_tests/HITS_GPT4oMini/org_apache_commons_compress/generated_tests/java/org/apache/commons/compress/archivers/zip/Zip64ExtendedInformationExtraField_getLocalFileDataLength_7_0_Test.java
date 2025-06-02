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

    private Zip64ExtendedInformationExtraField zip64FieldWithSize;

    private Zip64ExtendedInformationExtraField zip64FieldWithoutSize;

    @BeforeEach
    public void setUp() {
        ZipEightByteInteger size = new ZipEightByteInteger(1024);
        ZipEightByteInteger compressedSize = new ZipEightByteInteger(512);
        // Create instances for testing
        zip64FieldWithSize = new Zip64ExtendedInformationExtraField(size, compressedSize);
        zip64FieldWithoutSize = new Zip64ExtendedInformationExtraField(null, compressedSize);
    }

    @Test
    public void testGetLocalFileDataLength_WithSize() {
        ZipShort expectedLength = new ZipShort(2 * DWORD);
        ZipShort actualLength = zip64FieldWithSize.getLocalFileDataLength();
        assertNotNull(actualLength);
        assertEquals(expectedLength, actualLength);
    }

    @Test
    public void testGetLocalFileDataLength_WithoutSize() {
        ZipShort expectedLength = new ZipShort(0);
        ZipShort actualLength = zip64FieldWithoutSize.getLocalFileDataLength();
        assertNotNull(actualLength);
        assertEquals(expectedLength, actualLength);
    }
}
