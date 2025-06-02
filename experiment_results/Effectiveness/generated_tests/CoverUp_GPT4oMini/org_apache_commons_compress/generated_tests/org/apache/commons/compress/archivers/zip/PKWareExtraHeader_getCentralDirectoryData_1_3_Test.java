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

@ExtendWith(MockitoExtension.class)
class PKWareExtraHeader_getCentralDirectoryData_1_3_Test {

    private PKWareExtraHeader header;

    @BeforeEach
    void setUp() {
        header = new PKWareExtraHeader(new ZipShort(1)) {
        };
    }

    @Test
    void testGetCentralDirectoryData_withCentralData() throws Exception {
        byte[] centralData = { 1, 2, 3, 4, 5 };
        header.setCentralDirectoryData(centralData);
        byte[] result = header.getCentralDirectoryData();
        assertArrayEquals(centralData, result);
    }

    @Test
    void testGetCentralDirectoryData_withoutCentralData() throws Exception {
        byte[] localData = { 6, 7, 8, 9, 10 };
        header.setLocalFileDataData(localData);
        byte[] result = header.getCentralDirectoryData();
        assertArrayEquals(localData, result);
    }

    @Test
    void testGetCentralDirectoryData_withNullCentralData() throws Exception {
        header.setLocalFileDataData(null);
        byte[] result = header.getCentralDirectoryData();
        assertNull(result);
    }

    @Test
    void testGetCentralDirectoryData_withEmptyCentralData() throws Exception {
        header.setCentralDirectoryData(new byte[0]);
        byte[] result = header.getCentralDirectoryData();
        assertArrayEquals(new byte[0], result);
    }

    @Test
    void testGetCentralDirectoryData_withEmptyLocalData() throws Exception {
        header.setLocalFileDataData(new byte[0]);
        byte[] result = header.getCentralDirectoryData();
        assertArrayEquals(new byte[0], result);
    }

    // Test private method using reflection
    private Object invokePrivateMethod(String methodName, Class<?>[] parameterTypes, Object... args) throws Exception {
        Method method = PKWareExtraHeader.class.getDeclaredMethod(methodName, parameterTypes);
        method.setAccessible(true);
        return method.invoke(header, args);
    }
}
