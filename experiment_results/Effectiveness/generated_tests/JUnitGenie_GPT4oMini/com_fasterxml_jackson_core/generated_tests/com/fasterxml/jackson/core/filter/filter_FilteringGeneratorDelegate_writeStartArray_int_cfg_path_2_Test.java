package com.fasterxml.jackson.core.filter;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.filter.FilteringGeneratorDelegate;
import com.fasterxml.jackson.core.filter.TokenFilter;
import org.junit.Test;
import static org.mockito.Mockito.*;
import java.io.IOException;

public class filter_FilteringGeneratorDelegate_writeStartArray_int_cfg_path_2_Test {

    @Test(timeout = 4000)
    public void testWriteStartArrayWithIncludeAll() {
        // Arrange
        JsonGenerator mockJsonGenerator = mock(JsonGenerator.class);
        TokenFilter mockTokenFilter = TokenFilter.INCLUDE_ALL;
        FilteringGeneratorDelegate delegate = new FilteringGeneratorDelegate(mockJsonGenerator, mockTokenFilter, true, false);
        int size = 5; // valid non-negative integer

        // Act
        try {
            delegate.writeStartArray(size);
        } catch (IOException e) {
            // Handle exception if thrown
            e.printStackTrace();
        }

        // Assert
        try {
            verify(mockJsonGenerator).writeStartArray(size);
        } catch (IOException e) {
            // Handle exception if thrown
            e.printStackTrace();
        }
    }

    @Test(timeout = 4000)
    public void testWriteStartArrayWithNullItemFilter() {
        // Arrange
        JsonGenerator mockJsonGenerator = mock(JsonGenerator.class);
        TokenFilter mockTokenFilter = null; // setting _itemFilter to null
        FilteringGeneratorDelegate delegate = new FilteringGeneratorDelegate(mockJsonGenerator, mockTokenFilter, true, false);
        int size = 5; // valid non-negative integer

        // Act
        try {
            delegate.writeStartArray(size);
        } catch (IOException e) {
            // Handle exception if thrown
            e.printStackTrace();
        }

        // Assert
        // No interaction with mockJsonGenerator since _itemFilter is null
        try {
            verify(mockJsonGenerator, never()).writeStartArray(anyInt());
        } catch (IOException e) {
            // Handle exception if thrown
            e.printStackTrace();
        }
    }

    @Test(timeout = 4000)
    public void testWriteStartArrayWithNonIncludeAll() {
        // Arrange
        JsonGenerator mockJsonGenerator = mock(JsonGenerator.class);
        TokenFilter mockTokenFilter = new TokenFilter() {}; // a non-include-all filter
        FilteringGeneratorDelegate delegate = new FilteringGeneratorDelegate(mockJsonGenerator, mockTokenFilter, true, false);
        int size = 5; // valid non-negative integer

        // Act
        try {
            delegate.writeStartArray(size);
        } catch (IOException e) {
            // Handle exception if thrown
            e.printStackTrace();
        }

        // Assert
        try {
            verify(mockJsonGenerator).writeStartArray(size);
        } catch (IOException e) {
            // Handle exception if thrown
            e.printStackTrace();
        }
    }


}