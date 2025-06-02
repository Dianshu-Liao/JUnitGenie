// Test method
package org.apache.commons.csv;

import java.io.IOException;
import org.junit.jupiter.api.extension.ExtendWith;
import static org.apache.commons.io.IOUtils.EOF;
import java.io.Closeable;
import org.apache.commons.io.IOUtils;
import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

class Lexer_parseSimpleToken_18_2_Test {

    private Lexer lexer;

    private ExtendedBufferedReader mockReader;

    @BeforeEach
    void setUp() {
        mockReader = mock(ExtendedBufferedReader.class);
        CSVFormat mockFormat = mock(CSVFormat.class);
        lexer = new Lexer(mockFormat, mockReader);
    }

    @Test
    void testParseSimpleTokenEndOfLine() throws IOException {
        Token token = new Token();
        when(mockReader.read()).thenReturn((int) Constants.LF);
        Token result = invokeParseSimpleToken(token, (int) Constants.LF);
        assertEquals(Token.Type.EORECORD, result.type);
    }

    @Test
    void testParseSimpleTokenEndOfFile() throws IOException {
        Token token = new Token();
        when(mockReader.read()).thenReturn(-1);
        Token result = invokeParseSimpleToken(token, -1);
        assertEquals(Token.Type.EOF, result.type);
        assertTrue(result.isReady);
    }

    @Test
    void testParseSimpleTokenDelimiter() throws IOException {
        Token token = new Token();
        when(mockReader.read()).thenReturn((int) ',');
        Token result = invokeParseSimpleToken(token, (int) ',');
        assertEquals(Token.Type.TOKEN, result.type);
    }

    @Test
    void testParseSimpleTokenEscape() throws IOException {
        Token token = new Token();
        when(mockReader.read()).thenReturn((int) '\\', (int) 'n');
        Token result = invokeParseSimpleToken(token, (int) '\\');
        assertNotNull(result);
        assertTrue(result.content.toString().contains("\n"));
    }

    @Test
    void testParseSimpleTokenNormalCharacter() throws IOException {
        Token token = new Token();
        when(mockReader.read()).thenReturn((int) 'a');
        Token result = invokeParseSimpleToken(token, (int) 'a');
        assertEquals(Token.Type.TOKEN, result.type);
        assertEquals("a", result.content.toString());
    }

    @Test
    void testParseSimpleTokenIgnoreSurroundingSpaces() throws IOException {
        Token token = new Token();
        // Accessing the private field using reflection
        try {
            // Fixed line: changed 'var' to 'Field'
            java.lang.reflect.Field field = Lexer.class.getDeclaredField("ignoreSurroundingSpaces");
            field.setAccessible(true);
            field.set(lexer, true);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        when(mockReader.read()).thenReturn((int) ' ', (int) 'b', (int) ' ');
        Token result = invokeParseSimpleToken(token, (int) ' ');
        assertEquals("b", result.content.toString());
    }

    @Test
    void testParseSimpleTokenMultipleCharacters() throws IOException {
        Token token = new Token();
        when(mockReader.read()).thenReturn((int) 'c', (int) 'd', (int) 'e', (int) Constants.LF);
        Token result = invokeParseSimpleToken(token, (int) 'c');
        assertEquals(Token.Type.EORECORD, result.type);
        assertEquals("cde", result.content.toString());
    }

    private Token invokeParseSimpleToken(Token token, int ch) throws IOException {
        // Fixed line: changed 'var' to 'Method'
        try {
            java.lang.reflect.Method method = Lexer.class.getDeclaredMethod("parseSimpleToken", Token.class, int.class);
            method.setAccessible(true);
            return (Token) method.invoke(lexer, token, ch);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
