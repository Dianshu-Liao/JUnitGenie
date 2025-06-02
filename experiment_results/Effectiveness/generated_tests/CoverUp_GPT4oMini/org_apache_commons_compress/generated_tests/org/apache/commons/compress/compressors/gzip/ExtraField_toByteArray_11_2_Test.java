package org.apache.commons.compress.compressors.gzip;

import org.apache.commons.compress.compressors.gzip.ExtraField;
import org.apache.commons.compress.compressors.gzip.ExtraField.SubField;
import java.lang.reflect.Method;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;
import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import java.io.IOException;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.Objects;

public class ExtraField_toByteArray_11_2_Test {

    private ExtraField extraField;

    @BeforeEach
    public void setUp() {
        extraField = new ExtraField();
    }

    @Test
    public void testToByteArray_EmptySubFields() throws Exception {
        byte[] result = invokeToByteArray(extraField);
        assertArrayEquals(new byte[] {}, result);
    }

    @Test
    public void testToByteArray_NonEmptySubFields() throws Exception {
        List<SubField> subFields = new ArrayList<>();
        SubField subField1 = new SubField((byte) 1, (byte) 2, new byte[] { 10, 20, 30 });
        SubField subField2 = new SubField((byte) 3, (byte) 4, new byte[] { 40, 50 });
        subFields.add(subField1);
        subFields.add(subField2);
        // Use reflection to set the private subFields field
        setSubFields(extraField, subFields);
        // Calculate expected byte array
        byte[] expected = new byte[] { // First SubField
        // First SubField
        // Second SubField
        // Second SubField
        1, // Second SubField
        2, // Second SubField
        3, // Second SubField
        0, // Second SubField
        10, // Second SubField
        20, // Second SubField
        30, 3, 4, 2, 0, 40, 50 };
        byte[] result = invokeToByteArray(extraField);
        assertArrayEquals(expected, result);
        assertEquals(8, extraField.getEncodedSize());
    }

    private byte[] invokeToByteArray(ExtraField extraField) throws Exception {
        Method method = ExtraField.class.getDeclaredMethod("toByteArray");
        method.setAccessible(true);
        return (byte[]) method.invoke(extraField);
    }

    private void setSubFields(ExtraField extraField, List<SubField> subFields) throws Exception {
        Field field = ExtraField.class.getDeclaredField("subFields");
        field.setAccessible(true);
        field.set(extraField, subFields);
        // Update totalSize based on the new subFields
        int totalSize = 0;
        for (SubField f : subFields) {
            // 4 bytes for header + payload length
            Field payloadField = SubField.class.getDeclaredField("payload");
            payloadField.setAccessible(true);
            byte[] payload = (byte[]) payloadField.get(f);
            totalSize += 4 + payload.length;
        }
        Field totalSizeField = ExtraField.class.getDeclaredField("totalSize");
        totalSizeField.setAccessible(true);
        totalSizeField.set(extraField, totalSize);
    }
}
