package org.apache.commons.csv;
import static org.junit.Assert.assertFalse;
import org.apache.commons.csv.Lexer;

public class Lexer_isEscape_int_cfg_path_1_Test {

    @org.junit.Test
    public void testIsEscape() {
        // Given
        Lexer lexer = new Lexer(null, null); // using the constructor to instantiate the class
        int nonEscapeCharacter = 0; // assuming escape is not zero for this test case

        // When
        boolean result = lexer.isEscape(nonEscapeCharacter);

        // Then
        assertFalse(result);
    }

}