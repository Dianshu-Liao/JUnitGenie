package org.apache.commons.compress.archivers.zip;

import org.apache.commons.compress.archivers.zip.ZipShort;
import org.apache.commons.compress.archivers.zip.ZipUtil;
import java.lang.reflect.Method;
import java.util.Arrays;
import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.zip.ZipException;

class PKWareExtraHeader_getCentralDirectoryData_1_1_Test {

    private PKWareExtraHeader header;

    @BeforeEach
    void setUp() {
        header = new PKWareExtraHeader(ZipShort.ZERO) {

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
    void testGetCentralDirectoryDataWithCentralData() throws Exception {
        byte[] centralData = { 1, 2, 3, 4, 5 };
        header.setCentralDirectoryData(centralData);
        byte[] result = invokeGetCentralDirectoryData();
        assertArrayEquals(centralData, result);
    }

    @Test
    void testGetCentralDirectoryDataWithoutCentralData() throws Exception {
        byte[] localData = { 6, 7, 8, 9, 10 };
        header.setLocalFileDataData(localData);
        byte[] result = invokeGetCentralDirectoryData();
        assertArrayEquals(localData, result);
    }

    private byte[] invokeGetCentralDirectoryData() throws Exception {
        Method method = PKWareExtraHeader.class.getDeclaredMethod("getCentralDirectoryData");
        method.setAccessible(true);
        return (byte[]) method.invoke(header);
    }
}
