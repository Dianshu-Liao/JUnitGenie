package com.fasterxml.jackson.core.sym;
import com.fasterxml.jackson.core.sym.Name2;
import org.junit.Test;
import static org.junit.Assert.assertFalse;

public class sym_Name2_equals_int_____int_cfg_path_4_Test {

    @Test(timeout = 4000)
    public void testEquals_WhenQLenIsNotTwo_ReturnsFalse() {
        // Arrange
        Name2 name2 = new Name2("test", 1, 2, 3);
        int[] quads = {1, 2}; // This will test when qlen is not 2
        int qlen = 1; // qlen is not equal to 2

        // Act
        boolean result;
        try {
            result = name2.equals(quads, qlen);
        } catch (Exception e) {
            // Handle exception if any
            throw new RuntimeException("Unexpected exception thrown", e);
        }

        // Assert
        assertFalse(result);
    }

}