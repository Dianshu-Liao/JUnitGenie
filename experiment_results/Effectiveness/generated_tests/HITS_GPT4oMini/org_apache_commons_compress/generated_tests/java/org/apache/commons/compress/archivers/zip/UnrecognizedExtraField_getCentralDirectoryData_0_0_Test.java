package org.apache.commons.compress.archivers.zip;

import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import java.util.Arrays;

public class UnrecognizedExtraField_getCentralDirectoryData_0_0_Test {

    private UnrecognizedExtraField extraField;

    @BeforeEach
    public void setUp() {
        extraField = new UnrecognizedExtraField();
    }

    @Test
    public void testGetCentralDirectoryData_WhenCentralDataIsNotNull() {
        byte[] centralData = { 1, 2, 3, 4, 5 };
        extraField.setCentralDirectoryData(centralData);
        byte[] result = extraField.getCentralDirectoryData();
        assertArrayEquals(centralData, result, "Expected central data to be returned.");
    }

    @Test
    public void testGetCentralDirectoryData_WhenCentralDataIsNull() {
        byte[] localData = { 6, 7, 8, 9, 10 };
        extraField.setLocalFileDataData(localData);
        byte[] result = extraField.getCentralDirectoryData();
        assertArrayEquals(localData, result, "Expected local data to be returned when central data is null.");
    }

    @Test
    public void testGetCentralDirectoryData_WhenBothCentralAndLocalDataAreNull() {
        extraField.setCentralDirectoryData(null);
        extraField.setLocalFileDataData(null);
        byte[] result = extraField.getCentralDirectoryData();
        assertNull(result, "Expected null when both central and local data are null.");
    }
}
