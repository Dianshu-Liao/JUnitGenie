package com.fasterxml.jackson.core.filter;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.filter.FilteringGeneratorDelegate;
import com.fasterxml.jackson.core.filter.TokenFilter;
import org.junit.Test;
import org.mockito.Mockito;
import java.io.IOException;
import java.io.Reader;

public class filter_FilteringGeneratorDelegate_writeString_Reader_int_cfg_path_1_Test {

    @Test(timeout = 4000)
    public void testWriteString_withItemFilterNotNullAndIncludeAll() throws IOException {
        // Arrange
        JsonGenerator mockGenerator = Mockito.mock(JsonGenerator.class);
        TokenFilter mockFilter = TokenFilter.INCLUDE_ALL;
        FilteringGeneratorDelegate delegate = new FilteringGeneratorDelegate(mockGenerator, mockFilter, false, false);
        
        Reader mockReader = Mockito.mock(Reader.class);
        int len = 10;

        // Act
        delegate.writeString(mockReader, len);

        // Assert
        Mockito.verify(mockGenerator).writeString(mockReader, len);
    }

    @Test(timeout = 4000)
    public void testWriteString_withItemFilterNotNullAndNotIncludeAll() throws IOException {
        // Arrange
        JsonGenerator mockGenerator = Mockito.mock(JsonGenerator.class);
        TokenFilter mockFilter = new TokenFilter() {
            @Override
            public boolean includeString(Reader reader, int len) {
                return true; // Simulate inclusion
            }
        };
        FilteringGeneratorDelegate delegate = new FilteringGeneratorDelegate(mockGenerator, mockFilter, false, false);
        
        Reader mockReader = Mockito.mock(Reader.class);
        int len = 10;

        // Act
        delegate.writeString(mockReader, len);

        // Assert
        Mockito.verify(mockGenerator).writeString(mockReader, len);
    }

    @Test(timeout = 4000)
    public void testWriteString_withItemFilterNull() throws IOException {
        // Arrange
        JsonGenerator mockGenerator = Mockito.mock(JsonGenerator.class);
        FilteringGeneratorDelegate delegate = new FilteringGeneratorDelegate(mockGenerator, null, false, false);
        
        Reader mockReader = Mockito.mock(Reader.class);
        int len = 10;

        // Act
        delegate.writeString(mockReader, len);

        // Assert
        Mockito.verify(mockGenerator, Mockito.never()).writeString(Mockito.any(Reader.class), Mockito.anyInt());
    }


}