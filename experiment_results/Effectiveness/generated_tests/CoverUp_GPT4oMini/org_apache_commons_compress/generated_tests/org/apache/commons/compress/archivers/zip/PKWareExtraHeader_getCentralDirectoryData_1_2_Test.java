package org.apache.commons.compress.archivers.zip;

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

class PKWareExtraHeader_getCentralDirectoryData_1_2_Test {

    private PKWareExtraHeader header;

    @BeforeEach
    void setUp() {
        header = new PKWareExtraHeader(new ZipShort(1)) {

            @Override
            public byte[] getLocalFileDataData() {
                return super.getLocalFileDataData();
            }

            @Override
            public ZipShort getLocalFileDataLength() {
                return super.getLocalFileDataLength();
            }
        };
    }

    @Test
    void testGetCentralDirectoryData_WithCentralData() throws Exception {
        byte[] expectedData = { 1, 2, 3, 4, 5 };
        header.setCentralDirectoryData(expectedData);
        byte[] result = header.getCentralDirectoryData();
        assertArrayEquals(expectedData, result);
    }

    @Test
    void testGetCentralDirectoryData_WithoutCentralData() throws Exception {
        byte[] expectedData = { 6, 7, 8, 9, 10 };
        header.setLocalFileDataData(expectedData);
        byte[] result = header.getCentralDirectoryData();
        assertArrayEquals(expectedData, result);
    }

    @Test
    void testGetCentralDirectoryData_WithNullCentralData() throws Exception {
        header.setLocalFileDataData(new byte[] { 11, 12, 13 });
        header.setCentralDirectoryData(null);
        byte[] result = header.getCentralDirectoryData();
        assertArrayEquals(new byte[] { 11, 12, 13 }, result);
    }

    @Test
    void testGetCentralDirectoryData_WithEmptyCentralData() throws Exception {
        header.setCentralDirectoryData(new byte[] {});
        byte[] result = header.getCentralDirectoryData();
        assertArrayEquals(new byte[] {}, result);
    }

    @Test
    void testGetCentralDirectoryData_WithNullLocalData() throws Exception {
        header.setCentralDirectoryData(null);
        header.setLocalFileDataData(null);
        byte[] result = header.getCentralDirectoryData();
        assertNull(result);
    }
}
