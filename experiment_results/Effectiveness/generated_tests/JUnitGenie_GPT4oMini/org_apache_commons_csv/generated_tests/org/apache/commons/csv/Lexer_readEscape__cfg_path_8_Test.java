package org.apache.commons.csv;
import org.apache.commons.csv.CSVException;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.ExtendedBufferedReader;
import org.apache.commons.csv.Lexer;
import org.junit.Test;
import static org.junit.Assert.*;
import java.io.IOException;
import java.io.StringReader;

public class Lexer_readEscape__cfg_path_8_Test {

    @Test(timeout = 4000)
    public void testReadEscape_ReturnsTabCharacter() {
        // Arrange
        String input = "\t"; // Tab character
        ExtendedBufferedReader reader = new ExtendedBufferedReader(new StringReader(input));
        Lexer lexer = new Lexer(CSVFormat.DEFAULT, reader);

        try {
            // Act
            int result = lexer.readEscape();

            // Assert
            assertEquals(Constants.TAB, result);
        } catch (IOException e) {
            fail("IOException should not have been thrown");
        } 
    }

    @Test(timeout = 4000)
    public void testReadEscape_ReturnsBackspaceCharacter() {
        // Arrange
        String input = "\b"; // Backspace character
        ExtendedBufferedReader reader = new ExtendedBufferedReader(new StringReader(input));
        Lexer lexer = new Lexer(CSVFormat.DEFAULT, reader);

        try {
            // Act
            int result = lexer.readEscape();

            // Assert
            assertEquals(Constants.BACKSPACE, result);
        } catch (IOException e) {
            fail("IOException should not have been thrown");
        } 
    }

    @Test(timeout = 4000)
    public void testReadEscape_ThrowsCSVExceptionOnEOF() {
        // Arrange
        String input = ""; // Empty input to simulate EOF
        ExtendedBufferedReader reader = new ExtendedBufferedReader(new StringReader(input));
        Lexer lexer = new Lexer(CSVFormat.DEFAULT, reader);

        try {
            // Act
            lexer.readEscape();
            fail("Expected CSVException to be thrown");
        } catch (CSVException e) {
            // Assert
            assertEquals("EOF while processing escape sequence", e.getMessage());
        } catch (IOException e) {
            fail("IOException should not have been thrown");
        }
    }


}