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

class Lexer_parseSimpleToken_18_0_Test {

    private Lexer lexer;

    private ExtendedBufferedReader reader;

    @BeforeEach
    void setUp() {
        CSVFormat format = CSVFormat.DEFAULT;
        reader = new ExtendedBufferedReader(new StringReader("test,token\nanother,test"));
        lexer = new Lexer(format, reader);
    }

    @Test
    void testParseSimpleTokenEndOfLine() throws Exception {
        Token token = new Token();
        invokeParseSimpleToken(token, '\n');
        assertEquals(Token.Type.EORECORD, token.type);
    }

    @Test
    void testParseSimpleTokenEndOfFile() throws Exception {
        Token token = new Token();
        // Simulate EOF
        invokeParseSimpleToken(token, -1);
        assertEquals(Token.Type.EOF, token.type);
        assertTrue(token.isReady);
    }

    @Test
    void testParseSimpleTokenDelimiter() throws Exception {
        Token token = new Token();
        invokeParseSimpleToken(token, ',');
        assertEquals(Token.Type.TOKEN, token.type);
        assertEquals("test", token.content.toString());
    }

    @Test
    void testParseSimpleTokenEscape() throws Exception {
        Token token = new Token();
        // Simulate escape character
        invokeParseSimpleToken(token, '\\');
        assertEquals(Token.Type.TOKEN, token.type);
        // Ensure some content was added
        assertTrue(token.content.length() > 0);
    }

    @Test
    void testParseSimpleTokenIgnoreSurroundingSpaces() throws Exception {
        lexer = new Lexer(CSVFormat.DEFAULT.builder().setIgnoreSurroundingSpaces(true).get(), reader);
        Token token = new Token();
        invokeParseSimpleToken(token, ' ');
        assertEquals("test", token.content.toString().trim());
    }

    private void invokeParseSimpleToken(Token token, int ch) throws Exception {
        Method method = Lexer.class.getDeclaredMethod("parseSimpleToken", Token.class, int.class);
        method.setAccessible(true);
        method.invoke(lexer, token, ch);
    }
}
