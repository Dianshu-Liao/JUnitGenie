package com.fasterxml.jackson.core.filter;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.filter.FilteringGeneratorDelegate;
import com.fasterxml.jackson.core.filter.TokenFilter;
import org.junit.Test;
import java.io.Reader;
import java.io.StringReader;
import java.io.IOException;
import static org.mockito.Mockito.mock;

public class filter_FilteringGeneratorDelegate_writeString_Reader_int_cfg_path_6_Test {

    @Test(timeout = 4000)
    public void testWriteStringWithNullItemFilter() {
        // Arrange
        JsonGenerator mockGenerator = mock(JsonGenerator.class);
        TokenFilter mockFilter = null; // _itemFilter is null
        FilteringGeneratorDelegate delegate = new FilteringGeneratorDelegate(mockGenerator, mockFilter, false, false);
        Reader reader = new StringReader("test string");
        int len = 11;

        // Act
        try {
            delegate.writeString(reader, len);
        } catch (IOException e) {
            // Handle exception if necessary
        }

        // Assert
        // No assertion needed as the method should return without throwing an exception
    }

}