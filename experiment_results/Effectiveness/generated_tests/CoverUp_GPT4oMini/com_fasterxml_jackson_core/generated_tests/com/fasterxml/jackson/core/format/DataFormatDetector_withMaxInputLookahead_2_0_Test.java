package com.fasterxml.jackson.core.format;

import com.fasterxml.jackson.core.format.MatchStrength;
import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import java.io.*;
import java.util.*;
import com.fasterxml.jackson.core.*;

public class DataFormatDetector_withMaxInputLookahead_2_0_Test {

    private DataFormatDetector detector;

    @BeforeEach
    public void setUp() {
        JsonFactory jsonFactory1 = new JsonFactory();
        JsonFactory jsonFactory2 = new JsonFactory();
        detector = new DataFormatDetector(jsonFactory1, jsonFactory2);
    }

    @Test
    public void testWithMaxInputLookahead_SameValue() {
        DataFormatDetector result = detector.withMaxInputLookahead(DataFormatDetector.DEFAULT_MAX_INPUT_LOOKAHEAD);
        assertSame(detector, result);
    }

    @Test
    public void testWithMaxInputLookahead_DifferentValue() {
        int newLookahead = DataFormatDetector.DEFAULT_MAX_INPUT_LOOKAHEAD + 10;
        DataFormatDetector result = detector.withMaxInputLookahead(newLookahead);
        assertNotSame(detector, result);
        assertEquals(newLookahead, getMaxInputLookahead(result));
    }

    private int getMaxInputLookahead(DataFormatDetector detector) {
        try {
            java.lang.reflect.Field field = DataFormatDetector.class.getDeclaredField("_maxInputLookahead");
            field.setAccessible(true);
            return (int) field.get(detector);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
