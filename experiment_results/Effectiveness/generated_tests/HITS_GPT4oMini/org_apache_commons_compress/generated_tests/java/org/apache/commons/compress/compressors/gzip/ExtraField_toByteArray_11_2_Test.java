package org.apache.commons.compress.compressors.gzip;

import java.io.IOException;
import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;
import org.apache.commons.compress.compressors.gzip.ExtraField.SubField;

public class ExtraField_toByteArray_11_2_Test {

    private ExtraField extraField;

    @BeforeEach
    public void setUp() {
        extraField = new ExtraField();
    }

    @Test
    public void testToByteArray_EmptySubFields() throws IOException {
        byte[] expected = {};
        byte[] actual = extraField.toByteArray();
        assertArrayEquals(expected, actual, "Expected empty byte array when there are no subfields.");
    }

    @Test
    public void testToByteArray_SingleSubField() throws IOException {
        byte[] payload = new byte[] { 0x01, 0x02 };
        extraField.addSubField("subField1", payload);
        byte[] expected = new byte[] { 1, 2, 2, 0, 0x01, 0x02 };
        byte[] actual = extraField.toByteArray();
        assertArrayEquals(expected, actual, "Expected byte array for a single subfield.");
    }

    @Test
    public void testToByteArray_MultipleSubFields() throws IOException {
        byte[] payload1 = new byte[] { 0x01, 0x02 };
        byte[] payload2 = new byte[] { 0x03, 0x04, 0x05 };
        extraField.addSubField("subField1", payload1);
        extraField.addSubField("subField2", payload2);
        byte[] expected = new byte[] { 1, 2, 2, 0, 0x01, 0x02, 3, 4, 3, 0, 0x03, 0x04, 0x05 };
        byte[] actual = extraField.toByteArray();
        assertArrayEquals(expected, actual, "Expected byte array for multiple subfields.");
    }
}
