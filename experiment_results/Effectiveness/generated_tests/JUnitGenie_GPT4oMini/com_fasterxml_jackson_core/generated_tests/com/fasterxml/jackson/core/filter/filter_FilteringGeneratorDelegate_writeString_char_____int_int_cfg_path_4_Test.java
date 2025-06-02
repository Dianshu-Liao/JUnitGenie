package com.fasterxml.jackson.core.filter;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.filter.FilteringGeneratorDelegate;
import com.fasterxml.jackson.core.filter.TokenFilter;
import org.junit.Test;
import static org.mockito.Mockito.*;
import java.io.IOException;

public class filter_FilteringGeneratorDelegate_writeString_char_____int_int_cfg_path_4_Test {

    @Test(timeout = 4000)
    public void testWriteStringWithNullItemFilter() throws IOException {
        // Arrange
        JsonGenerator mockGenerator = mock(JsonGenerator.class);
        FilteringGeneratorDelegate delegate = new FilteringGeneratorDelegate(mockGenerator, null, false, false);
        char[] text = "test".toCharArray();
        int offset = 0;
        int len = 4;

        // Act
        delegate.writeString(text, offset, len);

        // Assert
        // Verify that writeString was not called on the delegate since _itemFilter is null
        verify(mockGenerator, never()).writeString(any(char[].class), anyInt(), anyInt());
    }

    @Test(timeout = 4000)
    public void testWriteStringWithIncludeAllItemFilter() throws IOException {
        // Arrange
        JsonGenerator mockGenerator = mock(JsonGenerator.class);
        TokenFilter mockFilter = TokenFilter.INCLUDE_ALL;
        FilteringGeneratorDelegate delegate = new FilteringGeneratorDelegate(mockGenerator, mockFilter, false, false);
        char[] text = "test".toCharArray();
        int offset = 0;
        int len = 4;

        // Act
        delegate.writeString(text, offset, len);

        // Assert
        // Verify that writeString was called on the delegate
        verify(mockGenerator).writeString(text, offset, len);
    }

    @Test(timeout = 4000)
    public void testWriteStringWithNonNullItemFilterAndNullCheckValue() throws IOException {
        // Arrange
        JsonGenerator mockGenerator = mock(JsonGenerator.class);
        TokenFilter mockFilter = new TokenFilter() {
            @Override
            public boolean includeString(String value) {
                return false; // Simulate a filter that excludes the string
            }
        };
        FilteringGeneratorDelegate delegate = new FilteringGeneratorDelegate(mockGenerator, mockFilter, false, false);
        char[] text = "test".toCharArray();
        int offset = 0;
        int len = 4;

        // Act
        delegate.writeString(text, offset, len);

        // Assert
        // Verify that writeString was not called on the delegate since the filter excludes the string
        verify(mockGenerator, never()).writeString(any(char[].class), anyInt(), anyInt());
    }


}