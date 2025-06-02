package com.fasterxml.jackson.core.format;

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

    private JsonFactory jsonFactory1;

    private JsonFactory jsonFactory2;

    private DataFormatDetector detector;

    @BeforeEach
    public void setUp() {
        jsonFactory1 = new JsonFactory();
        jsonFactory2 = new JsonFactory();
        detector = new DataFormatDetector(jsonFactory1, jsonFactory2);
    }

    @Test
    public void testWithMaxInputLookahead_ChangeValue() {
        DataFormatDetector newDetector = detector.withMaxInputLookahead(128);
        assertEquals(128, newDetector._maxInputLookahead);
        assertEquals(detector._detectors, newDetector._detectors);
        assertEquals(detector._optimalMatch, newDetector._optimalMatch);
        assertEquals(detector._minimalMatch, newDetector._minimalMatch);
    }

    @Test
    public void testWithMaxInputLookahead_SameValue() {
        DataFormatDetector sameDetector = detector.withMaxInputLookahead(DataFormatDetector.DEFAULT_MAX_INPUT_LOOKAHEAD);
        assertSame(detector, sameDetector);
    }

    @Test
    public void testWithMaxInputLookahead_DefaultValue() {
        DataFormatDetector defaultDetector = new DataFormatDetector(jsonFactory1, jsonFactory2);
        assertEquals(DataFormatDetector.DEFAULT_MAX_INPUT_LOOKAHEAD, defaultDetector.withMaxInputLookahead(DataFormatDetector.DEFAULT_MAX_INPUT_LOOKAHEAD)._maxInputLookahead);
    }
}
