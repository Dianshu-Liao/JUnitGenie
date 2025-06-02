package org.apache.commons.csv;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.Lexer;
import org.apache.commons.csv.Token;
import org.apache.commons.csv.ExtendedBufferedReader;
import java.io.StringReader;
import java.io.IOException;
import java.lang.reflect.Method;
import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.extension.ExtendWith;
import static org.apache.commons.io.IOUtils.EOF;
import java.io.Closeable;
import org.apache.commons.io.IOUtils;

class Lexer_appendNextEscapedCharacterToToken_0_4_Test {

    private Lexer lexer;

    private ExtendedBufferedReader reader;

    @BeforeEach
    void setUp() {
        CSVFormat format = CSVFormat.DEFAULT;
        String input = "Sample input with escape \\n character";
        reader = new ExtendedBufferedReader(new StringReader(input));
        lexer = new Lexer(format, reader);
    }

    @Test
    void testAppendNextEscapedCharacterToTokenWithEscapeDelimiter() throws Exception {
        Token token = new Token();
        // Assuming the escape character is '\\'
        setEscapeCharacter('\\');
        invokeAppendNextEscapedCharacterToToken(token);
        assertEquals("Sample input with escape \n character", token.content.toString());
    }

    @Test
    void testAppendNextEscapedCharacterToTokenWithUnexpectedEOF() throws Exception {
        Token token = new Token();
        // Set up reader to simulate EOF after escape character
        reader = new ExtendedBufferedReader(new StringReader("\\"));
        lexer = new Lexer(CSVFormat.DEFAULT, reader);
        Exception exception = assertThrows(IOException.class, () -> {
            invokeAppendNextEscapedCharacterToToken(token);
        });
        assertTrue(exception.getMessage().contains("unexpected char after escape"));
    }

    @Test
    void testAppendNextEscapedCharacterToTokenWithValidCharacter() throws Exception {
        Token token = new Token();
        // Simulate reading a valid escape character
        reader = new ExtendedBufferedReader(new StringReader("\\t"));
        lexer = new Lexer(CSVFormat.DEFAULT, reader);
        invokeAppendNextEscapedCharacterToToken(token);
        // tab character
        assertEquals("	", token.content.toString());
    }

    private void invokeAppendNextEscapedCharacterToToken(Token token) throws Exception {
        Method method = Lexer.class.getDeclaredMethod("appendNextEscapedCharacterToToken", Token.class);
        method.setAccessible(true);
        method.invoke(lexer, token);
    }

    private void setEscapeCharacter(char escapeChar) {
        // Use reflection to set the escape character in the lexer
        try {
            java.lang.reflect.Field escapeField = Lexer.class.getDeclaredField("escape");
            escapeField.setAccessible(true);
            escapeField.setInt(lexer, escapeChar);
        } catch (NoSuchFieldException | IllegalAccessException e) {
            fail("Failed to set escape character: " + e.getMessage());
        }
    }
}
