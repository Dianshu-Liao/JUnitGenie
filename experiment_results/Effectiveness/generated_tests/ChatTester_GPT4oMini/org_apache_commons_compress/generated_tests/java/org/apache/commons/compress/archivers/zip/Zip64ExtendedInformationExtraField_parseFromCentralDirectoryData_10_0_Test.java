// Test method
package org.apache.commons.compress.archivers.zip;

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

public class Zip64ExtendedInformationExtraField_parseFromCentralDirectoryData_10_0_Test {

    private Zip64ExtendedInformationExtraField zip64ExtraField;

    @BeforeEach
    public void setUp() {
        zip64ExtraField = new Zip64ExtendedInformationExtraField();
    }

    @Test
    public void testParseFromCentralDirectoryData_ValidData() throws Exception {
        // Example buffer with enough length
        byte[] buffer = new byte[24];
        // Fill buffer with test data
        for (int i = 0; i < 24; i++) {
            buffer[i] = (byte) i;
        }
        zip64ExtraField.parseFromCentralDirectoryData(buffer, 0, buffer.length);
        // Validate the fields using reflection
        assertNotNull(getPrivateField(zip64ExtraField, "size"));
        assertNotNull(getPrivateField(zip64ExtraField, "compressedSize"));
        assertNotNull(getPrivateField(zip64ExtraField, "relativeHeaderOffset"));
    }

    @Test
    public void testParseFromCentralDirectoryData_LengthThreeTimesDWORD() throws Exception {
        // Exactly length of 3 * DWORD
        byte[] buffer = new byte[12];
        // Fill buffer with test data
        for (int i = 0; i < 12; i++) {
            buffer[i] = (byte) (i + 1);
        }
        zip64ExtraField.parseFromCentralDirectoryData(buffer, 0, buffer.length);
        // Validate the fields using reflection
        assertNotNull(getPrivateField(zip64ExtraField, "size"));
        assertNotNull(getPrivateField(zip64ExtraField, "compressedSize"));
        assertNotNull(getPrivateField(zip64ExtraField, "relativeHeaderOffset"));
    }

    @Test
    public void testParseFromCentralDirectoryData_LengthModDWORDIsWORD() throws Exception {
        // Length % DWORD == WORD
        byte[] buffer = new byte[20];
        // Fill buffer with test data
        for (int i = 0; i < 20; i++) {
            buffer[i] = (byte) (i + 1);
        }
        zip64ExtraField.parseFromCentralDirectoryData(buffer, 0, buffer.length);
        // Validate the fields using reflection
        assertNotNull(getPrivateField(zip64ExtraField, "diskStart"));
    }

    @Test
    public void testParseFromCentralDirectoryData_InsufficientData() {
        // Not enough data
        byte[] buffer = new byte[8];
        // Fill buffer with test data
        for (int i = 0; i < 8; i++) {
            buffer[i] = (byte) (i + 1);
        }
        assertDoesNotThrow(() -> zip64ExtraField.parseFromCentralDirectoryData(buffer, 0, buffer.length));
    }

    private Object getPrivateField(Object obj, String fieldName) throws Exception {
        // Fixed line: changed 'var' to 'Field'
        java.lang.reflect.Field field = obj.getClass().getDeclaredField(fieldName);
        field.setAccessible(true);
        return field.get(obj);
    }
}
