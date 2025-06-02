package com.fasterxml.jackson.core.filter;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.filter.FilteringGeneratorDelegate;
import com.fasterxml.jackson.core.filter.TokenFilter;
import org.junit.Test;
import java.io.IOException;

public class filter_FilteringGeneratorDelegate_writeNumber_char_____int_int_cfg_path_6_Test {

    @Test(timeout = 4000)
    public void testWriteNumber_withNullItemFilter() {
        // Arrange
        JsonGenerator mockJsonGenerator = null; // Create a mock JsonGenerator as needed.
        TokenFilter mockTokenFilter = null; // This will be irrelevant as _itemFilter is null
        FilteringGeneratorDelegate delegate = new FilteringGeneratorDelegate(mockJsonGenerator, mockTokenFilter, false, false);

        char[] encodedValueBuffer = new char[]{'1', '2', '3'};
        int offset = 0;
        int length = 3;

        try {
            // Act
            delegate.writeNumber(encodedValueBuffer, offset, length);
            // Assert
            // No exception is expected and nothing else to assert since it just returns
        } catch (IOException e) {
            // Handle IOException if it ever occurs
            e.printStackTrace();
        } catch (UnsupportedOperationException e) {
            // Handle UnsupportedOperationException if it ever occurs
            e.printStackTrace();
        }
    }

}