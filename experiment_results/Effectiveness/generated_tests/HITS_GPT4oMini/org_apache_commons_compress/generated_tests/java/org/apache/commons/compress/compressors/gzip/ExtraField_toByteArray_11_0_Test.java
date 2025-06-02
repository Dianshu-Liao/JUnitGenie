package org.apache.commons.compress.compressors.gzip;

import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;
import org.apache.commons.compress.compressors.gzip.ExtraField.SubField;

public class // Additional test cases can be added here for further coverage of the toByteArray() method,
// particularly when subFields are not empty, if needed in future development.
ExtraField_toByteArray_11_0_Test {

    @Test
    public void testToByteArray_EmptySubFields() {
        // Arrange
        ExtraField extraField = new ExtraField();
        // Act
        byte[] result = extraField.toByteArray();
        // Assert
        // ZERO_BYTES
        byte[] expected = new byte[0];
        assertArrayEquals(expected, result, "Expected an empty byte array when subFields are empty.");
    }
}
