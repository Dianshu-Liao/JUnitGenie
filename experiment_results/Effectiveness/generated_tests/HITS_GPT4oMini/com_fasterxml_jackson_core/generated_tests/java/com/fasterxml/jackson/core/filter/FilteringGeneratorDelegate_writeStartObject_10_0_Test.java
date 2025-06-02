package com.fasterxml.jackson.core.filter;

import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import java.io.IOException;
import java.io.InputStream;
import java.io.Reader;
import java.math.BigDecimal;
import java.math.BigInteger;
import com.fasterxml.jackson.core.filter.TokenFilter.Inclusion;
import com.fasterxml.jackson.core.util.JsonGeneratorDelegate;
import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import com.fasterxml.jackson.core.*;

class FilteringGeneratorDelegate_writeStartObject_10_0_Test {

    private JsonGenerator generator;

    private TokenFilter filter;

    private FilteringGeneratorDelegate filteringGeneratorDelegate;

    @BeforeEach
    void setUp() throws IOException {
        JsonFactory jsonFactory = new JsonFactory();
        generator = jsonFactory.createGenerator(System.out);
        filter = TokenFilter.INCLUDE_ALL;
        filteringGeneratorDelegate = new FilteringGeneratorDelegate(generator, filter, TokenFilter.Inclusion.INCLUDE_ALL_AND_PATH, true);
    }

    @Test
    void testWriteStartObjectWithIncludeAll() throws IOException {
        filteringGeneratorDelegate.writeStartObject(new Object());
        // Add assertions to verify the expected behavior
        // Example assertion (assuming you have a way to verify the generator output):
        // verify(generator).writeStartObject(any());
    }

    @Test
    void testWriteStartObjectWithNullFilter() throws IOException {
        filteringGeneratorDelegate = new FilteringGeneratorDelegate(generator, null, TokenFilter.Inclusion.INCLUDE_ALL_AND_PATH, true);
        filteringGeneratorDelegate.writeStartObject(new Object());
        // Add assertions to verify the expected behavior
        // Example assertion:
        // verify(generator).writeStartObject(any());
    }

    @Test
    void testWriteStartObjectWithNonNullInclusion() throws IOException {
        filteringGeneratorDelegate = new FilteringGeneratorDelegate(generator, filter, TokenFilter.Inclusion.INCLUDE_NON_NULL, true);
        filteringGeneratorDelegate.writeStartObject(new Object());
        // Add assertions to verify the expected behavior
        // Example assertion:
        // verify(generator).writeStartObject(any());
    }
}
