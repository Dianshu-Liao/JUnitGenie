package org.apache.commons.compress.archivers.zip;

import org.apache.commons.compress.archivers.zip.PKWareExtraHeader;
import org.apache.commons.compress.archivers.zip.ZipShort;
import org.apache.commons.compress.archivers.zip.ZipUtil;
import java.lang.reflect.Method;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.zip.ZipException;

class PKWareExtraHeader_getCentralDirectoryData_1_4_Test {

    private PKWareExtraHeader pkWareExtraHeader;

    @BeforeEach
    void setUp() {
        pkWareExtraHeader = new PKWareExtraHeader(new ZipShort(1)) {
        };
    }

    @Test
    void testGetCentralDirectoryDataWithCentralData() throws Exception {
        byte[] centralData = { 1, 2, 3, 4, 5 };
        pkWareExtraHeader.setCentralDirectoryData(centralData);
        byte[] result = pkWareExtraHeader.getCentralDirectoryData();
        assertArrayEquals(centralData, result);
    }

    @Test
    void testGetCentralDirectoryDataWithoutCentralData() throws Exception {
        byte[] localData = { 6, 7, 8, 9, 10 };
        pkWareExtraHeader.setLocalFileDataData(localData);
        byte[] result = pkWareExtraHeader.getCentralDirectoryData();
        assertArrayEquals(localData, result);
    }

    @Test
    void testGetCentralDirectoryDataWhenCentralDataIsNull() throws Exception {
        byte[] localData = { 11, 12, 13, 14, 15 };
        pkWareExtraHeader.setLocalFileDataData(localData);
        byte[] result = pkWareExtraHeader.getCentralDirectoryData();
        assertArrayEquals(localData, result);
    }

    @Test
    void testGetCentralDirectoryDataWhenCentralDataIsEmpty() throws Exception {
        pkWareExtraHeader.setCentralDirectoryData(new byte[0]);
        byte[] result = pkWareExtraHeader.getCentralDirectoryData();
        assertArrayEquals(new byte[0], result);
    }

    @Test
    void testGetCentralDirectoryLengthWithCentralData() throws Exception {
        byte[] centralData = { 1, 2, 3, 4, 5 };
        pkWareExtraHeader.setCentralDirectoryData(centralData);
        ZipShort result = pkWareExtraHeader.getCentralDirectoryLength();
        assertEquals(centralData.length, result.getValue());
    }

    @Test
    void testGetCentralDirectoryLengthWithoutCentralData() throws Exception {
        byte[] localData = { 6, 7, 8, 9, 10 };
        pkWareExtraHeader.setLocalFileDataData(localData);
        ZipShort result = pkWareExtraHeader.getCentralDirectoryLength();
        assertEquals(localData.length, result.getValue());
    }

    @Test
    void testGetCentralDirectoryLengthWhenCentralDataIsNull() throws Exception {
        byte[] localData = { 11, 12, 13, 14, 15 };
        pkWareExtraHeader.setLocalFileDataData(localData);
        ZipShort result = pkWareExtraHeader.getCentralDirectoryLength();
        assertEquals(localData.length, result.getValue());
    }

    @Test
    void testGetCentralDirectoryLengthWhenCentralDataIsEmpty() throws Exception {
        pkWareExtraHeader.setCentralDirectoryData(new byte[0]);
        ZipShort result = pkWareExtraHeader.getCentralDirectoryLength();
        assertEquals(0, result.getValue());
    }
}
