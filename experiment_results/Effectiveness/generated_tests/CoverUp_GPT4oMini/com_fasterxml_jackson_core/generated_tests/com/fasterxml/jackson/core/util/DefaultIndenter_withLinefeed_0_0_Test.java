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
        defaultIndenter = new DefaultIndenter("  ", System.lineSeparator());
    }

    @Test
    public void testWithLinefeed_SameLinefeed() {
        // Arrange
        String linefeed = defaultIndenter.getEol();
        // Act
        DefaultIndenter result = defaultIndenter.withLinefeed(linefeed);
        // Assert
        assertSame(defaultIndenter, result);
    }

    @Test
    public void testWithLinefeed_DifferentLinefeed() {
        // Arrange
        String differentLinefeed = "\n";
        // Act
        DefaultIndenter result = defaultIndenter.withLinefeed(differentLinefeed);
        // Assert
        assertNotSame(defaultIndenter, result);
        assertSame(differentLinefeed, result.getEol());
    }
}
