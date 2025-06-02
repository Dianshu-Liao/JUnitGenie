package org.apache.commons.compress.archivers.zip;

import org.apache.commons.compress.archivers.zip.ZipShort;
import org.apache.commons.compress.archivers.zip.PKWareExtraHeader;
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

class PKWareExtraHeader_getCentralDirectoryData_1_0_Test {

    private PKWareExtraHeader header;

    private class TestPKWareExtraHeader extends PKWareExtraHeader {

        protected TestPKWareExtraHeader(final ZipShort headerId) {
            super(headerId);
        }
    }

    @BeforeEach
    void setUp() {
        header = new TestPKWareExtraHeader(new ZipShort(1));
    }

    @Test
    void testGetCentralDirectoryData_withCentralData() throws Exception {
        byte[] centralData = { 1, 2, 3, 4, 5 };
        header.setCentralDirectoryData(centralData);
        byte[] result = header.getCentralDirectoryData();
        assertNotNull(result);
        assertArrayEquals(centralData, result);
        // Ensure a copy is returned
        assertNotSame(centralData, result);
    }

    @Test
    void testGetCentralDirectoryData_withoutCentralData() throws Exception {
        byte[] localData = { 6, 7, 8, 9, 10 };
        header.setLocalFileDataData(localData);
        byte[] result = header.getCentralDirectoryData();
        assertNotNull(result);
        assertArrayEquals(localData, result);
    }

    @Test
    void testGetCentralDirectoryData_withNullCentralData() throws Exception {
        header.setCentralDirectoryData(null);
        byte[] result = header.getCentralDirectoryData();
        assertNull(result);
    }

    @Test
    void testGetCentralDirectoryData_withEmptyCentralData() throws Exception {
        header.setCentralDirectoryData(new byte[0]);
        byte[] result = header.getCentralDirectoryData();
        assertNotNull(result);
        assertEquals(0, result.length);
    }

    @Test
    void testGetCentralDirectoryData_withEmptyLocalData() throws Exception {
        header.setLocalFileDataData(new byte[0]);
        byte[] result = header.getCentralDirectoryData();
        assertNotNull(result);
        assertEquals(0, result.length);
    }

    @Test
    void testGetCentralDirectoryData_withNullLocalData() throws Exception {
        header.setLocalFileDataData(null);
        byte[] result = header.getCentralDirectoryData();
        assertNull(result);
    }
}
