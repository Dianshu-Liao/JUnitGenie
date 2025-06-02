package com.fasterxml.jackson.core.filter;

import com.fasterxml.jackson.core.filter.TokenFilter;
import java.io.IOException;
import java.lang.reflect.Method;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import java.io.InputStream;
import java.io.Reader;
import java.math.BigDecimal;
import java.math.BigInteger;
import com.fasterxml.jackson.core.*;
import com.fasterxml.jackson.core.filter.TokenFilter.Inclusion;
import com.fasterxml.jackson.core.util.JsonGeneratorDelegate;

class FilteringGeneratorDelegate_writeRaw_25_0_Test {

    private JsonGenerator mockJsonGenerator;

    private TokenFilter mockTokenFilter;

    private FilteringGeneratorDelegate filteringGeneratorDelegate;

    @BeforeEach
    void setUp() {
        mockJsonGenerator = mock(JsonGenerator.class);
        mockTokenFilter = mock(TokenFilter.class);
        filteringGeneratorDelegate = new FilteringGeneratorDelegate(mockJsonGenerator, mockTokenFilter, true, false);
    }

    @Test
    void testWriteRaw_WithValidInput_CallsDelegate() throws Exception {
        char[] text = "test".toCharArray();
        int offset = 0;
        int len = text.length;
        // Mock the behavior of _checkRawValueWrite to return true
        Method checkRawValueWriteMethod = FilteringGeneratorDelegate.class.getDeclaredMethod("_checkRawValueWrite");
        checkRawValueWriteMethod.setAccessible(true);
        when(checkRawValueWriteMethod.invoke(filteringGeneratorDelegate)).thenReturn(true);
        filteringGeneratorDelegate.writeRaw(text, offset, len);
        verify(mockJsonGenerator).writeRaw(text, offset, len);
    }

    @Test
    void testWriteRaw_WithInvalidInput_DoesNotCallDelegate() throws Exception {
        char[] text = "test".toCharArray();
        int offset = 0;
        int len = text.length;
        // Mock the behavior of _checkRawValueWrite to return false
        Method checkRawValueWriteMethod = FilteringGeneratorDelegate.class.getDeclaredMethod("_checkRawValueWrite");
        checkRawValueWriteMethod.setAccessible(true);
        when(checkRawValueWriteMethod.invoke(filteringGeneratorDelegate)).thenReturn(false);
        filteringGeneratorDelegate.writeRaw(text, offset, len);
        verify(mockJsonGenerator, never()).writeRaw(any(char[].class), anyInt(), anyInt());
    }

    @Test
    void testWriteRaw_IOExceptionThrown_PropagatesIOException() {
        char[] text = "test".toCharArray();
        int offset = 0;
        int len = text.length;
        // Mock the behavior of _checkRawValueWrite to return true
        try {
            Method checkRawValueWriteMethod = FilteringGeneratorDelegate.class.getDeclaredMethod("_checkRawValueWrite");
            checkRawValueWriteMethod.setAccessible(true);
            when(checkRawValueWriteMethod.invoke(filteringGeneratorDelegate)).thenReturn(true);
            doThrow(IOException.class).when(mockJsonGenerator).writeRaw(text, offset, len);
            // Assert that IOException is thrown
            Assertions.assertThrows(IOException.class, () -> {
                filteringGeneratorDelegate.writeRaw(text, offset, len);
            });
        } catch (Exception e) {
            fail("Exception occurred: " + e.getMessage());
        }
    }
}
