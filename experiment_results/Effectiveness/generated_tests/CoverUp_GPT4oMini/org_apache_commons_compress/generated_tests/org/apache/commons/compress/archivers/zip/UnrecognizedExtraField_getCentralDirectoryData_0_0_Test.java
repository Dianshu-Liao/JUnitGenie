package org.apache.commons.compress.archivers.zip;

import org.apache.commons.compress.archivers.zip.UnrecognizedExtraField;
import org.apache.commons.compress.archivers.zip.ZipShort;
import java.lang.reflect.Method;
import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import java.util.Arrays;

class UnrecognizedExtraField_getCentralDirectoryData_0_0_Test {

    private UnrecognizedExtraField unrecognizedExtraField;

    @BeforeEach
    void setUp() {
        unrecognizedExtraField = new UnrecognizedExtraField();
    }

    @Test
    void testGetCentralDirectoryDataWhenCentralDataIsNotNull() throws Exception {
        byte[] centralData = { 1, 2, 3, 4, 5 };
        unrecognizedExtraField.setCentralDirectoryData(centralData);
        byte[] result = unrecognizedExtraField.getCentralDirectoryData();
        assertNotNull(result);
        assertArrayEquals(centralData, result);
    }

    @Test
    void testGetCentralDirectoryDataWhenCentralDataIsNull() throws Exception {
        byte[] localData = { 6, 7, 8, 9, 10 };
        unrecognizedExtraField.setLocalFileDataData(localData);
        byte[] result = unrecognizedExtraField.getCentralDirectoryData();
        assertNotNull(result);
        assertArrayEquals(localData, result);
    }

    @Test
    void testGetCentralDirectoryDataWhenBothDataAreNull() throws Exception {
        byte[] result = unrecognizedExtraField.getCentralDirectoryData();
        assertNull(result);
    }

    private byte[] invokeGetLocalFileDataData() throws Exception {
        Method method = UnrecognizedExtraField.class.getDeclaredMethod("getLocalFileDataData");
        method.setAccessible(true);
        return (byte[]) method.invoke(unrecognizedExtraField);
    }
}
