// Test method
package org.apache.commons.compress.compressors.gzip;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;
import java.io.IOException;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.Objects;
import org.apache.commons.compress.compressors.gzip.ExtraField.SubField;
import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

public class ExtraField_toByteArray_11_1_Test {

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
        SubField subField = new SubField((byte) 1, (byte) 2, new byte[] { 3, 4, 5 });
        subFields.add(subField);
        setSubFields(extraField, subFields);
        // 4 for the metadata
        setTotalSize(extraField, subField.payload.length + 4);
        // si1, si2, length in little endian, payload
        byte[] expected = new byte[] { 1, 2, 3, 0, 4, 0, 5 };
        byte[] result = invokeToByteArray(extraField);
        assertArrayEquals(expected, result);
    }

    @Test
    public void testToByteArray_MultipleSubFields() throws Exception {
        List<SubField> subFields = new ArrayList<>();
        SubField subField1 = new SubField((byte) 1, (byte) 2, new byte[] { 3, 4 });
        SubField subField2 = new SubField((byte) 5, (byte) 6, new byte[] { 7, 8, 9 });
        subFields.add(subField1);
        subFields.add(subField2);
        setSubFields(extraField, subFields);
        // 4 for each metadata
        setTotalSize(extraField, subField1.payload.length + 4 + subField2.payload.length + 4);
        byte[] expected = new byte[] { 1, 2, 3, 0, 4, 0, 5, 6, 7, 0, 8, 0, 9 };
        byte[] result = invokeToByteArray(extraField);
        assertArrayEquals(expected, result);
    }

    private byte[] invokeToByteArray(ExtraField extraField) throws Exception {
        Method method = ExtraField.class.getDeclaredMethod("toByteArray");
        method.setAccessible(true);
        return (byte[]) method.invoke(extraField);
    }

    private void setSubFields(ExtraField extraField, List<SubField> subFields) throws Exception {
        java.lang.reflect.Field field = ExtraField.class.getDeclaredField("subFields");
        field.setAccessible(true);
        field.set(extraField, subFields);
    }

    private void setTotalSize(ExtraField extraField, int totalSize) throws Exception {
        java.lang.reflect.Field field = ExtraField.class.getDeclaredField("totalSize");
        field.setAccessible(true);
        field.setInt(extraField, totalSize);
    }

    // Mock SubField class for testing purposes
    static class SubField {

        byte si1;

        byte si2;

        byte[] payload;

        SubField(byte si1, byte si2, byte[] payload) {
            this.si1 = si1;
            this.si2 = si2;
            this.payload = payload;
        }
    }
}
