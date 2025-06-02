package com.fasterxml.jackson.core.filter;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.filter.FilteringGeneratorDelegate;
import com.fasterxml.jackson.core.filter.TokenFilter;
import com.fasterxml.jackson.core.filter.TokenFilterContext;
import org.junit.Before;
import org.junit.Test;
import java.io.IOException;
import static org.mockito.Mockito.*;

public class filter_FilteringGeneratorDelegate_writeStartObject_Object_cfg_path_1_Test {
    private FilteringGeneratorDelegate delegate;
    private TokenFilterContext mockFilterContext;
    private TokenFilter mockItemFilter;
    private JsonGenerator mockJsonGenerator;

    @Before
    public void setUp() {
        mockJsonGenerator = mock(JsonGenerator.class);
        mockFilterContext = mock(TokenFilterContext.class);
        mockItemFilter = mock(TokenFilter.class);
        delegate = new FilteringGeneratorDelegate(mockJsonGenerator, mockItemFilter, false, false);
        delegate._filterContext = mockFilterContext; // Set mock filter context
    }

    @Test(timeout = 4000)
    public void testWriteStartObjectWithNonNullItemFilter() throws IOException {
        // Mocking behavior
        when(delegate._itemFilter).thenReturn(mockItemFilter);
        when(mockFilterContext.checkValue(mockItemFilter)).thenReturn(TokenFilter.INCLUDE_ALL);
        
        // Calling the focal method
        delegate.writeStartObject(new Object());

        // Verifying interactions
        verify(mockFilterContext).createChildObjectContext(mockItemFilter, true);
        verify(mockJsonGenerator).writeStartObject(any());
    }

    @Test(timeout = 4000)
    public void testWriteStartObjectWithNullItemFilter() throws IOException {
        // Setting _itemFilter to null
        delegate._itemFilter = null;

        // Calling the focal method
        delegate.writeStartObject(new Object());

        // Verifying interactions
        verify(mockFilterContext).createChildObjectContext(delegate._itemFilter, false);
    }

}