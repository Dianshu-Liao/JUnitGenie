package com.fasterxml.jackson.core.util;

import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import java.io.IOException;
import com.fasterxml.jackson.core.JsonGenerator;

public class DefaultIndenter_withLinefeed_0_0_Test {

    private DefaultIndenter defaultIndenter;

    @BeforeEach
    public void setUp() {
        // Initialize with some indent and linefeed
        defaultIndenter = new DefaultIndenter("  ", "\n");
    }

    @Test
    public void testWithLinefeed_SameLinefeed_ReturnsSameInstance() {
        DefaultIndenter result = defaultIndenter.withLinefeed("\n");
        assertSame(defaultIndenter, result, "Expected the same instance to be returned when linefeed is the same.");
    }

    @Test
    public void testWithLinefeed_DifferentLinefeed_ReturnsNewInstance() {
        DefaultIndenter result = defaultIndenter.withLinefeed("\r\n");
        assertNotSame(defaultIndenter, result, "Expected a new instance to be returned when linefeed is different.");
    }

    @Test
    public void testWithLinefeed_NullLinefeed_ReturnsNewInstance() {
        DefaultIndenter result = defaultIndenter.withLinefeed(null);
        assertNotSame(defaultIndenter, result, "Expected a new instance to be returned when linefeed is null.");
    }

    @Test
    public void testWithLinefeed_EmptyLinefeed_ReturnsNewInstance() {
        DefaultIndenter result = defaultIndenter.withLinefeed("");
        assertNotSame(defaultIndenter, result, "Expected a new instance to be returned when linefeed is empty.");
    }

    @Test
    public void testWithLinefeed_WhitespaceLinefeed_ReturnsNewInstance() {
        DefaultIndenter result = defaultIndenter.withLinefeed("   ");
        assertNotSame(defaultIndenter, result, "Expected a new instance to be returned when linefeed is whitespace.");
    }
}
