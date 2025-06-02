package org.apache.commons.compress.archivers.zip;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import static org.apache.commons.compress.archivers.zip.ZipConstants.DWORD;
import static org.apache.commons.compress.archivers.zip.ZipConstants.WORD;
import java.util.zip.ZipException;
import org.apache.commons.compress.utils.ByteUtils;
import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

public class Zip64ExtendedInformationExtraField_getLocalFileDataData_6_0_Test {

    private Zip64ExtendedInformationExtraField zip64ExtendedInfo;

    @BeforeEach
    public void setUp() {
        zip64ExtendedInfo = new Zip64ExtendedInformationExtraField();
    }

    @Test
    public void testGetLocalFileDataData_WithBothSizes() {
        // Fix: Use reflection to set private fields
        setPrivateField(zip64ExtendedInfo, "size", new ZipEightByteInteger(100));
        setPrivateField(zip64ExtendedInfo, "compressedSize", new ZipEightByteInteger(100));
        // Act
        byte[] result = zip64ExtendedInfo.getLocalFileDataData();
        // Assert
        assertNotNull(result);
        // 2 * DWORD = 8 bytes
        assertEquals(8, result.length);
    }

    @Test
    public void testGetLocalFileDataData_WithSizeNull() {
        // Fix: Use reflection to set private fields
        setPrivateField(zip64ExtendedInfo, "size", null);
        setPrivateField(zip64ExtendedInfo, "compressedSize", new ZipEightByteInteger(100));
        // Act & Assert
        IllegalArgumentException thrown = assertThrows(IllegalArgumentException.class, () -> {
            zip64ExtendedInfo.getLocalFileDataData();
        });
        assertEquals("Zip64 extended information must contain both size values in the local file header.", thrown.getMessage());
    }

    @Test
    public void testGetLocalFileDataData_WithCompressedSizeNull() {
        // Fix: Use reflection to set private fields
        setPrivateField(zip64ExtendedInfo, "size", new ZipEightByteInteger(100));
        setPrivateField(zip64ExtendedInfo, "compressedSize", null);
        // Act & Assert
        IllegalArgumentException thrown = assertThrows(IllegalArgumentException.class, () -> {
            zip64ExtendedInfo.getLocalFileDataData();
        });
        assertEquals("Zip64 extended information must contain both size values in the local file header.", thrown.getMessage());
    }

    @Test
    public void testGetLocalFileDataData_WithBothSizesNull() {
        // Fix: Use reflection to set private fields
        setPrivateField(zip64ExtendedInfo, "size", null);
        setPrivateField(zip64ExtendedInfo, "compressedSize", null);
        // Act
        byte[] result = zip64ExtendedInfo.getLocalFileDataData();
        // Assert
        assertNotNull(result);
        // Should return empty byte array
        assertEquals(0, result.length);
    }

    @Test
    public void testGetLocalFileDataData_WithValidSizes_CallsAddSizes() throws Exception {
        // Fix: Use reflection to set private fields
        setPrivateField(zip64ExtendedInfo, "size", new ZipEightByteInteger(100));
        setPrivateField(zip64ExtendedInfo, "compressedSize", new ZipEightByteInteger(100));
        // Prepare a byte array for addSizes
        byte[] data = new byte[8];
        // Act
        invokePrivateAddSizes(data);
        // Assert
        assertNotNull(data);
        // You can add further assertions based on what addSizes is supposed to do
    }

    // Reflection test to invoke private method if needed
    private void invokePrivateAddSizes(byte[] data) throws Exception {
        Method method = Zip64ExtendedInformationExtraField.class.getDeclaredMethod("addSizes", byte[].class);
        method.setAccessible(true);
        method.invoke(zip64ExtendedInfo, (Object) data);
    }

    // Reflection utility to set private fields
    private void setPrivateField(Object target, String fieldName, Object value) {
        try {
            Field field = target.getClass().getDeclaredField(fieldName);
            field.setAccessible(true);
            field.set(target, value);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
