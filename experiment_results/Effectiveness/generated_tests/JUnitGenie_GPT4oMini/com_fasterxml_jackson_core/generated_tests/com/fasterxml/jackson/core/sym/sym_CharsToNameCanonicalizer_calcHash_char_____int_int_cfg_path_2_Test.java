package com.fasterxml.jackson.core.sym;
import com.fasterxml.jackson.core.sym.CharsToNameCanonicalizer;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class sym_CharsToNameCanonicalizer_calcHash_char_____int_int_cfg_path_2_Test {

    @Test(timeout = 4000)
    public void testCalcHash() {
        // Arrange
        char[] buffer = {'a', 'b', 'c'};
        int start = 0;
        int len = 3;
        // Create an instance of CharsToNameCanonicalizer with appropriate parameters
        CharsToNameCanonicalizer instance = CharsToNameCanonicalizer.createRoot();
        
        // Act
        int result = 0;
        try {
            result = instance.calcHash(buffer, start, len);
        } catch (Exception e) {
            // Handle exception if necessary
        }

        // Assert
        int expectedHash = (instance._seed * 33) + 'a';
        expectedHash = (expectedHash * 33) + 'b';
        expectedHash = (expectedHash * 33) + 'c';
        expectedHash = (expectedHash == 0) ? 1 : expectedHash;
        assertEquals(expectedHash, result);
    }


}