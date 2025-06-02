package com.fasterxml.jackson.core.io;
import com.fasterxml.jackson.core.io.CharTypes;
import org.junit.Test;
import static org.junit.Assert.assertArrayEquals;

public class io_CharTypes_copyHexBytes_boolean_cfg_path_2_Test {

    @Test(timeout = 4000)
    public void testCopyHexBytesWithUppercase() {
        // Given
        boolean uppercase = true;

        // When
        byte[] result = CharTypes.copyHexBytes(uppercase);

        // Then
        byte[] expected = CharTypes.HB.clone(); // Expected result is the clone of HB
        assertArrayEquals(expected, result);
    }

    @Test(timeout = 4000)
    public void testCopyHexBytesWithLowercase() {
        // Given
        boolean uppercase = false;

        // When
        byte[] result = CharTypes.copyHexBytes(uppercase);

        // Then
        byte[] expected = CharTypes.HBlower.clone(); // Expected result is the clone of HBlower
        assertArrayEquals(expected, result);
    }

}