package com.fasterxml.jackson.core.filter;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.filter.FilteringGeneratorDelegate;
import com.fasterxml.jackson.core.filter.TokenFilter;
import org.junit.Test;
import java.io.IOException;
import static org.mockito.Mockito.*;

public class filter_FilteringGeneratorDelegate_writeRaw_String_cfg_path_1_Test {

    @Test(timeout = 4000)
    public void testWriteRaw() {
        // Arrange
        JsonGenerator mockJsonGenerator = mock(JsonGenerator.class);
        TokenFilter mockTokenFilter = mock(TokenFilter.class);
        FilteringGeneratorDelegate delegate = new FilteringGeneratorDelegate(mockJsonGenerator, mockTokenFilter, false, false);

        String text = "Sample text";

        // Act
        try {
            delegate.writeRaw(text);
            // Assert
            verify(mockJsonGenerator).writeRaw(text);
        } catch (IOException e) {
            // Handle the exception as per rule 4
            e.printStackTrace();
        }
    }

}