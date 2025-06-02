package com.fasterxml.jackson.core.util;

import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import java.lang.reflect.Field;
import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import java.io.*;
import java.math.BigDecimal;
import java.util.*;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.io.NumberInput;

public class TextBuffer_contentsAsString_16_0_Test {

    private BufferRecycler mockAllocator;

    private TextBuffer textBuffer;

    @BeforeEach
    public void setUp() {
        mockAllocator = Mockito.mock(BufferRecycler.class);
        textBuffer = new TextBuffer(mockAllocator);
    }

    @Test
    public void testContentsAsString_EmptyBuffer() throws IOException {
        assertEquals("", textBuffer.contentsAsString());
    }

    @Test
    public void testContentsAsString_WithInputBuffer() throws IOException, NoSuchFieldException, IllegalAccessException {
        Field inputBufferField = TextBuffer.class.getDeclaredField("_inputBuffer");
        inputBufferField.setAccessible(true);
        inputBufferField.set(textBuffer, new char[] { 'H', 'e', 'l', 'l', 'o' });
        Field inputStartField = TextBuffer.class.getDeclaredField("_inputStart");
        inputStartField.setAccessible(true);
        inputStartField.setInt(textBuffer, 0);
        Field inputLenField = TextBuffer.class.getDeclaredField("_inputLen");
        inputLenField.setAccessible(true);
        inputLenField.setInt(textBuffer, 5);
        String result = textBuffer.contentsAsString();
        assertEquals("Hello", result);
    }

    @Test
    public void testContentsAsString_WithCurrentSegment() throws IOException, NoSuchFieldException, IllegalAccessException {
        Field currentSegmentField = TextBuffer.class.getDeclaredField("_currentSegment");
        currentSegmentField.setAccessible(true);
        currentSegmentField.set(textBuffer, new char[] { 'W', 'o', 'r', 'l', 'd' });
        Field currentSizeField = TextBuffer.class.getDeclaredField("_currentSize");
        currentSizeField.setAccessible(true);
        currentSizeField.setInt(textBuffer, 5);
        String result = textBuffer.contentsAsString();
        assertEquals("World", result);
    }

    @Test
    public void testContentsAsString_WithSegments() throws IOException, NoSuchFieldException, IllegalAccessException {
        Field segmentsField = TextBuffer.class.getDeclaredField("_segments");
        segmentsField.setAccessible(true);
        List<char[]> segments = new ArrayList<>();
        segments.add(new char[] { 'A', 'B', 'C' });
        segments.add(new char[] { 'D', 'E', 'F' });
        segmentsField.set(textBuffer, segments);
        Field currentSegmentField = TextBuffer.class.getDeclaredField("_currentSegment");
        currentSegmentField.setAccessible(true);
        currentSegmentField.set(textBuffer, new char[] { 'G', 'H', 'I' });
        Field currentSizeField = TextBuffer.class.getDeclaredField("_currentSize");
        currentSizeField.setAccessible(true);
        currentSizeField.setInt(textBuffer, 3);
        String result = textBuffer.contentsAsString();
        assertEquals("ABCDEFHI", result);
    }

    @Test
    public void testContentsAsString_WithResultArray() throws IOException, NoSuchFieldException, IllegalAccessException {
        Field resultArrayField = TextBuffer.class.getDeclaredField("_resultArray");
        resultArrayField.setAccessible(true);
        resultArrayField.set(textBuffer, new char[] { 'T', 'e', 's', 't' });
        String result = textBuffer.contentsAsString();
        assertEquals("Test", result);
    }

    @Test
    public void testContentsAsString_WithBufferOverflow() throws NoSuchFieldException, IllegalAccessException {
        // Set up the private fields using reflection
        Field segmentsField = TextBuffer.class.getDeclaredField("_segments");
        segmentsField.setAccessible(true);
        segmentsField.set(textBuffer, new ArrayList<char[]>(Arrays.asList(new char[Integer.MAX_VALUE])));
        Field currentSegmentField = TextBuffer.class.getDeclaredField("_currentSegment");
        currentSegmentField.setAccessible(true);
        currentSegmentField.set(textBuffer, new char[] { 'A', 'B', 'C' });
        Field currentSizeField = TextBuffer.class.getDeclaredField("_currentSize");
        currentSizeField.setAccessible(true);
        currentSizeField.setInt(textBuffer, 3);
        Exception exception = assertThrows(IOException.class, () -> {
            textBuffer.contentsAsString();
        });
        String expectedMessage = "Buffer overflow";
        String actualMessage = exception.getMessage();
        assertTrue(actualMessage.contains(expectedMessage));
    }
}
