package org.apache.commons.compress.archivers.zip;

import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.zip.ZipException;

public class PKWareExtraHeader_getCentralDirectoryData_1_0_Test {

    private PKWareExtraHeader pkWareExtraHeader;

    private static final ZipShort HEADER_ID = new ZipShort(1);

    @BeforeEach
    public void setUp() {
        pkWareExtraHeader = new PKWareExtraHeader(HEADER_ID) {
        };
    }

    @Test
    public void testGetCentralDirectoryDataWhenCentralDataIsNull() {
        // Arrange
        byte[] localData = { 1, 2, 3, 4, 5 };
        pkWareExtraHeader.setLocalFileDataData(localData);
        // Act
        byte[] result = pkWareExtraHeader.getCentralDirectoryData();
        // Assert
        assertArrayEquals(localData, result);
    }

    @Test
    public void testGetCentralDirectoryDataWhenCentralDataIsNotNull() {
        // Arrange
        byte[] centralData = { 6, 7, 8, 9, 10 };
        pkWareExtraHeader.setCentralDirectoryData(centralData);
        // Act
        byte[] result = pkWareExtraHeader.getCentralDirectoryData();
        // Assert
        assertArrayEquals(centralData, result);
    }

    @Test
    public void testGetCentralDirectoryDataWhenCentralDataIsEmpty() {
        // Arrange
        byte[] centralData = {};
        pkWareExtraHeader.setCentralDirectoryData(centralData);
        // Act
        byte[] result = pkWareExtraHeader.getCentralDirectoryData();
        // Assert
        assertArrayEquals(centralData, result);
    }

    @Test
    public void testGetCentralDirectoryDataWhenBothDataAreNull() {
        // Act
        byte[] result = pkWareExtraHeader.getCentralDirectoryData();
        // Assert
        assertNull(result);
    }
}
