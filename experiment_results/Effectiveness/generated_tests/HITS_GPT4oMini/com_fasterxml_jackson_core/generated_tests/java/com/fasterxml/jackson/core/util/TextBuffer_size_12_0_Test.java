package com.fasterxml.jackson.core.util;

import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import java.io.*;
import java.math.BigDecimal;
import java.util.*;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.io.NumberInput;

public class TextBuffer_size_12_0_Test {

    private TextBuffer textBuffer;

    @BeforeEach
    public void setUp() {
        textBuffer = new TextBuffer(new BufferRecycler());
    }

    private void setInputBuffer(int start, int len) {
        // Helper method to set private fields for testing
        try {
            java.lang.reflect.Field inputStartField = TextBuffer.class.getDeclaredField("_inputStart");
            inputStartField.setAccessible(true);
            inputStartField.set(textBuffer, start);
            java.lang.reflect.Field inputLenField = TextBuffer.class.getDeclaredField("_inputLen");
            inputLenField.setAccessible(true);
            inputLenField.set(textBuffer, len);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    private void setResultArray(char[] array) {
        try {
            java.lang.reflect.Field resultArrayField = TextBuffer.class.getDeclaredField("_resultArray");
            resultArrayField.setAccessible(true);
            resultArrayField.set(textBuffer, array);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    private void setResultString(String resultString) {
        try {
            java.lang.reflect.Field resultStringField = TextBuffer.class.getDeclaredField("_resultString");
            resultStringField.setAccessible(true);
            resultStringField.set(textBuffer, resultString);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    private void setSegmentSize(int segmentSize) {
        try {
            java.lang.reflect.Field segmentSizeField = TextBuffer.class.getDeclaredField("_segmentSize");
            segmentSizeField.setAccessible(true);
            segmentSizeField.set(textBuffer, segmentSize);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    private void setCurrentSize(int currentSize) {
        try {
            java.lang.reflect.Field currentSizeField = TextBuffer.class.getDeclaredField("_currentSize");
            currentSizeField.setAccessible(true);
            currentSizeField.set(textBuffer, currentSize);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Test
    public void testSizeWithInputBuffer() {
        setInputBuffer(0, 10);
        assertEquals(10, textBuffer.size());
    }

    @Test
    public void testSizeWithResultArray() {
        setResultArray(new char[15]);
        assertEquals(15, textBuffer.size());
    }

    @Test
    public void testSizeWithResultString() {
        setResultString("Hello, World!");
        assertEquals(13, textBuffer.size());
    }

    @Test
    public void testSizeWithSegments() {
        setSegmentSize(5);
        setCurrentSize(3);
        assertEquals(8, textBuffer.size());
    }

    @Test
    public void testSizeWithNoSegmentsOrResult() {
        setInputBuffer(-1, 0);
        setResultArray(null);
        setResultString(null);
        setSegmentSize(0);
    }
}
