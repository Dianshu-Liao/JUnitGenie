package com.fasterxml.jackson.core.io;
import static org.junit.Assert.assertArrayEquals;
import org.junit.Test;
import com.fasterxml.jackson.core.io.CharTypes;

public class io_CharTypes_copyHexBytes_boolean_cfg_path_1_Test {

    @Test(timeout = 4000)
    public void testCopyHexBytesLowercase() {
        // Given
        boolean uppercase = false;

        // When
        byte[] result = CharTypes.copyHexBytes(uppercase);

        // Then
        byte[] expected = CharTypes.HBlower.clone();
        assertArrayEquals(expected, result);
    }

    @Test(timeout = 4000)
    public void testCopyHexBytesUppercase() {
        // Given
        boolean uppercase = true;

        // When
        byte[] result = CharTypes.copyHexBytes(uppercase);

        // Then
        byte[] expected = CharTypes.HB.clone();
        assertArrayEquals(expected, result);
    }

}