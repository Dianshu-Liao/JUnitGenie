package org.apache.commons.compress.archivers.zip;

import org.apache.commons.compress.archivers.zip.ZipLong;
import org.apache.commons.compress.archivers.zip.ZipShort;
import org.apache.commons.compress.archivers.zip.ZipEightByteInteger;
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
    public void testGetCentralDirectoryLength_WithNoFields() {
        ZipShort length = zip64ExtendedInfo.getCentralDirectoryLength();
        assertEquals(0, length.getValue());
    }

    @Test
    public void testGetCentralDirectoryLength_WithSizeOnly() {
        zip64ExtendedInfo.setSize(new ZipEightByteInteger(new byte[8]));
        ZipShort length = zip64ExtendedInfo.getCentralDirectoryLength();
        // Only size is present (DWORD)
        assertEquals(4, length.getValue());
    }

    @Test
    public void testGetCentralDirectoryLength_WithCompressedSizeOnly() {
        zip64ExtendedInfo.setCompressedSize(new ZipEightByteInteger(new byte[8]));
        ZipShort length = zip64ExtendedInfo.getCentralDirectoryLength();
        // Only compressed size is present (DWORD)
        assertEquals(4, length.getValue());
    }

    @Test
    public void testGetCentralDirectoryLength_WithSizeAndCompressedSize() {
        zip64ExtendedInfo.setSize(new ZipEightByteInteger(new byte[8]));
        zip64ExtendedInfo.setCompressedSize(new ZipEightByteInteger(new byte[8]));
        ZipShort length = zip64ExtendedInfo.getCentralDirectoryLength();
        // Size and compressed size (2 * DWORD)
        assertEquals(8, length.getValue());
    }

    @Test
    public void testGetCentralDirectoryLength_WithRelativeHeaderOffset() {
        zip64ExtendedInfo.setRelativeHeaderOffset(new ZipEightByteInteger(new byte[8]));
        ZipShort length = zip64ExtendedInfo.getCentralDirectoryLength();
        // Only relative header offset is present (DWORD)
        assertEquals(4, length.getValue());
    }

    @Test
    public void testGetCentralDirectoryLength_WithDiskStart() {
        zip64ExtendedInfo.setDiskStartNumber(new ZipLong(new byte[4]));
        ZipShort length = zip64ExtendedInfo.getCentralDirectoryLength();
        // Only disk start is present (WORD)
        assertEquals(2, length.getValue());
    }

    @Test
    public void testGetCentralDirectoryLength_WithAllFields() {
        zip64ExtendedInfo.setSize(new ZipEightByteInteger(new byte[8]));
        zip64ExtendedInfo.setCompressedSize(new ZipEightByteInteger(new byte[8]));
        zip64ExtendedInfo.setRelativeHeaderOffset(new ZipEightByteInteger(new byte[8]));
        zip64ExtendedInfo.setDiskStartNumber(new ZipLong(new byte[4]));
        ZipShort length = zip64ExtendedInfo.getCentralDirectoryLength();
        // All fields present: 3 * DWORD + 1 * WORD
        assertEquals(18, length.getValue());
    }
}
