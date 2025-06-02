package org.apache.commons.compress.archivers.zip;

import java.lang.reflect.Method;
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

public class PKWareExtraHeader_getCentralDirectoryData_1_2_Test {

    private PKWareExtraHeader pkWareExtraHeader;

    @BeforeEach
    public void setUp() {
        pkWareExtraHeader = new PKWareExtraHeader(mock(ZipShort.class)) {

            private byte[] localData = "localData".getBytes();

            private byte[] centralData = null;

            @Override
            public byte[] getLocalFileDataData() {
                return localData;
            }

            // For testing, we will use reflection to set centralData
            protected void setCentralData(byte[] data) {
                this.centralData = data;
            }
        };
    }

    @Test
    public void testGetCentralDirectoryData_CentralDataNotNull() throws Exception {
        byte[] expectedCentralData = "centralData".getBytes();
        invokeSetCentralData(expectedCentralData);
        byte[] result = pkWareExtraHeader.getCentralDirectoryData();
        assertArrayEquals(expectedCentralData, result);
    }

    @Test
    public void testGetCentralDirectoryData_CentralDataNull() throws Exception {
        byte[] result = pkWareExtraHeader.getCentralDirectoryData();
        assertArrayEquals("localData".getBytes(), result);
    }

    private void invokeSetCentralData(byte[] data) throws Exception {
        Method method = PKWareExtraHeader.class.getDeclaredMethod("setCentralData", byte[].class);
        method.setAccessible(true);
        method.invoke(pkWareExtraHeader, (Object) data);
    }
}
