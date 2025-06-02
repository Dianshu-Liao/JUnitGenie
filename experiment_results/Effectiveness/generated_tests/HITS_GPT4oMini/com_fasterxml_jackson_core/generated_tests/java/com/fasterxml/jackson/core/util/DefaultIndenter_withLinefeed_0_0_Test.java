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
        defaultIndenter = new DefaultIndenter();
    }

    @Test
    public void testWithLinefeed_SameLinefeed_ReturnsSameInstance() {
        String linefeed = defaultIndenter.getEol();
        DefaultIndenter result = defaultIndenter.withLinefeed(linefeed);
        assertSame(defaultIndenter, result, "Expected the same instance when linefeed is unchanged.");
    }

    @Test
    public void testWithLinefeed_DifferentLinefeed_ReturnsNewInstance() {
        // Assuming a different linefeed
        String differentLinefeed = "\n";
        DefaultIndenter result = defaultIndenter.withLinefeed(differentLinefeed);
        assertNotSame(defaultIndenter, result, "Expected a new instance when linefeed is changed.");
    }
}
