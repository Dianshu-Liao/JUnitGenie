package org.apache.commons.csv;
import org.apache.commons.csv.CSVException;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.ExtendedBufferedReader;
import org.apache.commons.csv.Lexer;
import org.junit.Test;
import static org.junit.Assert.*;
import java.io.IOException;
import java.io.StringReader;

public class Lexer_readEscape__cfg_path_4_Test {

    @Test(timeout = 4000)
    public void testReadEscape_ReturnsLF() {
        try {
            // Arrange
            StringReader stringReader = new StringReader("\n"); // Simulate LF character
            ExtendedBufferedReader mockReader = new ExtendedBufferedReader(stringReader);
            Lexer lexer = new Lexer(CSVFormat.DEFAULT, mockReader);

            // Act
            int result = lexer.readEscape();

            // Assert
            assertEquals(Constants.LF, result);
        } catch (IOException e) {
            fail("IOException was thrown: " + e.getMessage());
        }
    }

    @Test(timeout = 4000)
    public void testReadEscape_ReturnsCR() {
        try {
            // Arrange
            StringReader stringReader = new StringReader("\r"); // Simulate CR character
            ExtendedBufferedReader mockReader = new ExtendedBufferedReader(stringReader);
            Lexer lexer = new Lexer(CSVFormat.DEFAULT, mockReader);

            // Act
            int result = lexer.readEscape();

            // Assert
            assertEquals(Constants.CR, result);
        } catch (IOException e) {
            fail("IOException was thrown: " + e.getMessage());
        }
    }

    @Test(timeout = 4000)
    public void testReadEscape_ThrowsCSVException_OnEOF() {
        try {
            // Arrange
            StringReader stringReader = new StringReader(""); // Simulate EOF
            ExtendedBufferedReader mockReader = new ExtendedBufferedReader(stringReader);
            Lexer lexer = new Lexer(CSVFormat.DEFAULT, mockReader);

            // Act
            lexer.readEscape();
            fail("Expected CSVException was not thrown");
        } catch (CSVException e) {
            // Assert
            assertEquals("EOF while processing escape sequence", e.getMessage());
        } catch (IOException e) {
            fail("IOException was thrown: " + e.getMessage());
        }
    }


}