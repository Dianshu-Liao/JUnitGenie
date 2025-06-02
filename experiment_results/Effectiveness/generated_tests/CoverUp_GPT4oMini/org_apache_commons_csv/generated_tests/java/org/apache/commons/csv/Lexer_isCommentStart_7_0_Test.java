package org.apache.commons.csv;

import java.io.IOException;
import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.extension.ExtendWith;
import static org.apache.commons.io.IOUtils.EOF;
import java.io.Closeable;
import org.apache.commons.io.IOUtils;

class Lexer_isCommentStart_7_0_Test {

    private Lexer lexer;

    private ExtendedBufferedReader mockReader;

    @BeforeEach
    void setUp() {
        // Mock the ExtendedBufferedReader and its expected behavior
        mockReader = Mockito.mock(ExtendedBufferedReader.class);
        lexer = new Lexer(CSVFormat.DEFAULT, mockReader);
    }

    @Test
    void testIsCommentStart_withCommentStartCharacter() {
        // Assuming commentStart is initialized to a specific character, e.g., '#'
        setPrivateField(lexer, "commentStart", '#');
        assertTrue(lexer.isCommentStart('#'));
    }

    @Test
    void testIsCommentStart_withDifferentCharacter() {
        // Assuming commentStart is initialized to a specific character, e.g., '#'
        setPrivateField(lexer, "commentStart", '#');
        assertFalse(lexer.isCommentStart('A'));
    }

    private void setPrivateField(Object obj, String fieldName, Object value) {
        try {
            java.lang.reflect.Field field = obj.getClass().getDeclaredField(fieldName);
            field.setAccessible(true);
            field.set(obj, value);
        } catch (NoSuchFieldException | IllegalAccessException e) {
            fail("Failed to set private field: " + e.getMessage());
        }
    }
}
