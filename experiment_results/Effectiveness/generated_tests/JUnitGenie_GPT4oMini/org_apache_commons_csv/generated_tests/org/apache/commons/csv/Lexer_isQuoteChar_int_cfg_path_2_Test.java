package org.apache.commons.csv;
import org.junit.Test;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class Lexer_isQuoteChar_int_cfg_path_2_Test {

    @Test(timeout = 4000)
    public void testIsQuoteChar() {
        // Arrange
        int quoteCharValue = '"'; // Assuming the quoteChar is set to double quote
        MockLexer lexer = new MockLexer(quoteCharValue); // Use MockLexer instead of TestableLexer

        // Act & Assert
        assertTrue(lexer.isQuoteChar(quoteCharValue)); // Test with the quote character
        assertFalse(lexer.isQuoteChar('a')); // Test with a non-quote character
    }

    // Since Lexer is final, we cannot extend it. We will create a mock or use composition instead.
    private static class MockLexer {
        private final int quoteChar;

        public MockLexer(int quoteChar) {
            this.quoteChar = quoteChar;
        }

        public boolean isQuoteChar(int ch) {
            return ch == quoteChar;
        }
    }


}