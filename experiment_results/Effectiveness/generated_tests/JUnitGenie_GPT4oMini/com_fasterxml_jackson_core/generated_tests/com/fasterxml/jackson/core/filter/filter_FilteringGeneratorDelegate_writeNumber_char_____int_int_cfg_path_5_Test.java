package com.fasterxml.jackson.core.filter;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.filter.FilteringGeneratorDelegate;
import com.fasterxml.jackson.core.filter.TokenFilter;
import org.junit.Test;
import static org.mockito.Mockito.*;
import java.io.IOException;

public class filter_FilteringGeneratorDelegate_writeNumber_char_____int_int_cfg_path_5_Test {

    @Test(timeout = 4000)
    public void testWriteNumber_withIncludeAll() {
        // Arrange
        JsonGenerator mockJsonGenerator = mock(JsonGenerator.class);
        FilteringGeneratorDelegate delegate = new FilteringGeneratorDelegate(mockJsonGenerator, TokenFilter.INCLUDE_ALL, false, false);
        char[] encodedValueBuffer = new char[]{'1', '2', '3'};
        int offset = 0;
        int length = 3;

        // Act
        try {
            delegate.writeNumber(encodedValueBuffer, offset, length);
        } catch (IOException | UnsupportedOperationException e) {
            // Handle exception if thrown
            e.printStackTrace();
        }

        // Assert
        try {
            verify(mockJsonGenerator).writeNumber(encodedValueBuffer, offset, length);
        } catch (IOException e) {
            // Handle exception if thrown
            e.printStackTrace();
        }
    }

    @Test(timeout = 4000)
    public void testWriteNumber_withNullItemFilter() {
        // Arrange
        JsonGenerator mockJsonGenerator = mock(JsonGenerator.class);
        FilteringGeneratorDelegate delegate = new FilteringGeneratorDelegate(mockJsonGenerator, null, false, false);
        char[] encodedValueBuffer = new char[]{'1', '2', '3'};
        int offset = 0;
        int length = 3;

        // Act
        try {
            delegate.writeNumber(encodedValueBuffer, offset, length);
        } catch (IOException | UnsupportedOperationException e) {
            // Handle exception if thrown
            e.printStackTrace();
        }

        // Assert
        try {
            verify(mockJsonGenerator, never()).writeNumber(any(char[].class), anyInt(), anyInt());
        } catch (IOException e) {
            // Handle exception if thrown
            e.printStackTrace();
        }
    }

    @Test(timeout = 4000)
    public void testWriteNumber_withNonIncludeAllFilter() {
        // Arrange
        JsonGenerator mockJsonGenerator = mock(JsonGenerator.class);
        TokenFilter nonIncludeAllFilter = mock(TokenFilter.class);
        when(nonIncludeAllFilter.includeRawValue()).thenReturn(false);
        FilteringGeneratorDelegate delegate = new FilteringGeneratorDelegate(mockJsonGenerator, nonIncludeAllFilter, false, false);
        char[] encodedValueBuffer = new char[]{'1', '2', '3'};
        int offset = 0;
        int length = 3;

        // Act
        try {
            delegate.writeNumber(encodedValueBuffer, offset, length);
        } catch (IOException | UnsupportedOperationException e) {
            // Handle exception if thrown
            e.printStackTrace();
        }

        // Assert
        try {
            verify(mockJsonGenerator, never()).writeNumber(any(char[].class), anyInt(), anyInt());
        } catch (IOException e) {
            // Handle exception if thrown
            e.printStackTrace();
        }
    }

}