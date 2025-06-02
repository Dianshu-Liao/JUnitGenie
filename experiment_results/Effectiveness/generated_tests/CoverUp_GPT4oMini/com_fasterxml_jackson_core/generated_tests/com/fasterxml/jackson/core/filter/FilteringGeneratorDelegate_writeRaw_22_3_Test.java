package com.fasterxml.jackson.core.filter;

import com.fasterxml.jackson.core.filter.TokenFilter;
import com.fasterxml.jackson.core.filter.TokenFilterContext;
import com.fasterxml.jackson.core.filter.FilteringGeneratorDelegate;
import java.io.IOException;
import java.io.StringWriter;
import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import java.io.InputStream;
import java.io.Reader;
import java.math.BigDecimal;
import java.math.BigInteger;
import com.fasterxml.jackson.core.*;
import com.fasterxml.jackson.core.filter.TokenFilter.Inclusion;
import com.fasterxml.jackson.core.util.JsonGeneratorDelegate;

class FilteringGeneratorDelegate_writeRaw_22_3_Test {

    private JsonGenerator mockJsonGenerator;

    private TokenFilter mockTokenFilter;

    private FilteringGeneratorDelegate filteringGeneratorDelegate;

    @BeforeEach
    void setUp() throws IOException {
        mockJsonGenerator = mock(JsonGenerator.class);
        // Using INCLUDE_ALL for testing
        mockTokenFilter = TokenFilter.INCLUDE_ALL;
        filteringGeneratorDelegate = new FilteringGeneratorDelegate(mockJsonGenerator, mockTokenFilter, true, true);
    }

    @Test
    void testWriteRaw_withValidText_callsWriteRawOnDelegate() throws IOException {
        String text = "test";
        filteringGeneratorDelegate.writeRaw(text);
        verify(mockJsonGenerator, times(1)).writeRaw(text);
    }

    @Test
    void testWriteRaw_withNullText_doesNotCallWriteRawOnDelegate() throws IOException {
        String text = null;
        filteringGeneratorDelegate = new FilteringGeneratorDelegate(mockJsonGenerator, TokenFilter.INCLUDE_ALL, true, true);
        filteringGeneratorDelegate.writeRaw(text);
        verify(mockJsonGenerator, never()).writeRaw(anyString());
    }

    @Test
    void testWriteRaw_withItemFilterNull_doesNotCallWriteRawOnDelegate() throws IOException {
        filteringGeneratorDelegate = new FilteringGeneratorDelegate(mockJsonGenerator, null, true, true);
        filteringGeneratorDelegate.writeRaw("test");
        verify(mockJsonGenerator, never()).writeRaw(anyString());
    }

    @Test
    void testWriteRaw_withItemFilterNotIncludeAll_doesNotCallWriteRawOnDelegate() throws IOException {
        TokenFilter customFilter = mock(TokenFilter.class);
        when(customFilter.includeRawValue()).thenReturn(false);
        filteringGeneratorDelegate = new FilteringGeneratorDelegate(mockJsonGenerator, customFilter, true, true);
        filteringGeneratorDelegate.writeRaw("test");
        verify(mockJsonGenerator, never()).writeRaw(anyString());
    }

    @Test
    void testWriteRaw_withItemFilterIncludeRawValue_callsWriteRawOnDelegate() throws IOException {
        TokenFilter customFilter = mock(TokenFilter.class);
        when(customFilter.includeRawValue()).thenReturn(true);
        filteringGeneratorDelegate = new FilteringGeneratorDelegate(mockJsonGenerator, customFilter, true, true);
        filteringGeneratorDelegate.writeRaw("test");
        verify(mockJsonGenerator, times(1)).writeRaw("test");
    }

    @Test
    void testWriteRaw_whenExceptionThrown_doesNotThrowUnexpectedException() {
        assertThrows(IOException.class, () -> {
            doThrow(new IOException("Mocked exception")).when(mockJsonGenerator).writeRaw(anyString());
            filteringGeneratorDelegate.writeRaw("test");
        });
    }

    // Test private method _checkRawValueWrite using reflection
    @Test
    void testCheckRawValueWrite_whenItemFilterIsNull_returnsFalse() throws Exception {
        filteringGeneratorDelegate = new FilteringGeneratorDelegate(mockJsonGenerator, null, true, true);
        boolean result = (boolean) invokePrivateMethod(filteringGeneratorDelegate, "_checkRawValueWrite");
        assertFalse(result);
    }

    @Test
    void testCheckRawValueWrite_whenItemFilterIsIncludeAll_returnsTrue() throws Exception {
        boolean result = (boolean) invokePrivateMethod(filteringGeneratorDelegate, "_checkRawValueWrite");
        assertTrue(result);
    }

    private Object invokePrivateMethod(Object obj, String methodName, Object... args) throws Exception {
        Class<?> clazz = obj.getClass();
        java.lang.reflect.Method method = clazz.getDeclaredMethod(methodName);
        method.setAccessible(true);
        return method.invoke(obj, args);
    }
}
