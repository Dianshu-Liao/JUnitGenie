package org.apache.commons.csv;
import org.apache.commons.csv.CSVException;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.ExtendedBufferedReader;
import org.apache.commons.csv.Lexer;
import org.junit.Test;
import java.io.IOException;
import java.io.Reader;
import java.io.StringReader;
import static org.junit.Assert.assertEquals;

public class Lexer_readEscape__cfg_path_6_Test {

    private Reader mockReader;

    @Test(timeout = 4000)
    public void testReadEscapeReturnsCR() {
        try {
            // Arrange
            mockReader = new StringReader(String.valueOf(Constants.CR)); // Simulate reading a carriage return
            Lexer lexer = new Lexer(CSVFormat.DEFAULT, new ExtendedBufferedReader(mockReader));

            // Act
            int result = lexer.readEscape();

            // Assert
            assertEquals(Constants.CR, result);
        } catch (IOException e) {
            // Handle the exception
            e.printStackTrace();
        }
    }

    @Test(timeout = 4000)
    public void testReadEscapeReturnsLF() {
        try {
            // Arrange
            mockReader = new StringReader(String.valueOf(Constants.LF)); // Simulate reading a line feed
            Lexer lexer = new Lexer(CSVFormat.DEFAULT, new ExtendedBufferedReader(mockReader));

            // Act
            int result = lexer.readEscape();

            // Assert
            assertEquals(Constants.LF, result);
        } catch (IOException e) {
            // Handle the exception
            e.printStackTrace();
        }
    }

    @Test(timeout = 4000)
    public void testReadEscapeReturnsTAB() {
        try {
            // Arrange
            mockReader = new StringReader(String.valueOf(Constants.TAB)); // Simulate reading a tab
            Lexer lexer = new Lexer(CSVFormat.DEFAULT, new ExtendedBufferedReader(mockReader));

            // Act
            int result = lexer.readEscape();

            // Assert
            assertEquals(Constants.TAB, result);
        } catch (IOException e) {
            // Handle the exception
            e.printStackTrace();
        }
    }

    @Test(timeout = 4000)
    public void testReadEscapeThrowsCSVExceptionOnEOF() {
        try {
            // Arrange
            mockReader = new StringReader(""); // Simulate EOF
            Lexer lexer = new Lexer(CSVFormat.DEFAULT, new ExtendedBufferedReader(mockReader));

            // Act
            lexer.readEscape();
        } catch (CSVException e) {
            // Assert
            assertEquals("EOF while processing escape sequence", e.getMessage());
        } catch (IOException e) {
            // Handle the exception
            e.printStackTrace();
        }
    }


}