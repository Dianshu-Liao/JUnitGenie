package org.apache.commons.compress.compressors.gzip;
import org.apache.commons.compress.compressors.gzip.ExtraField;
import org.junit.Test;
import static org.junit.Assert.assertArrayEquals;

public class compressors_gzip_ExtraField_toByteArray__cfg_path_1_Test {

    @Test(timeout = 4000)
    public void testToByteArray_WhenSubFieldsIsEmpty() {
        ExtraField extraField = new ExtraField(); // Using the default constructor

        // Execute the method under test
        byte[] result = extraField.toByteArray();

        // Expected output
        byte[] expected = {}; // The expected output for an empty subFields is ZERO_BYTES, which is an empty byte array.

        // Assert the result
        assertArrayEquals(expected, result);
    }

}