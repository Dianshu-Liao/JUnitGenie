package com.fasterxml.jackson.core.filter;

import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import java.io.IOException;
import com.fasterxml.jackson.core.*;

public class TokenFilterContext_hasCurrentName_16_0_Test {

    private TokenFilterContext contextWithName;

    private TokenFilterContext contextWithoutName;

    @BeforeEach
    public void setUp() {
        // Assuming TokenFilter is a valid class and we can create an instance of it
        // You may need to adjust this based on the actual implementation
        TokenFilter filter = new TokenFilter();
        // Create a context with a current name
        contextWithName = new TokenFilterContext(0, null, filter, true) {

            {
                // Set a valid name
                _currentName = "TestName";
            }
        };
        // Create a context without a current name
        contextWithoutName = new TokenFilterContext(0, null, filter, true) {

            {
                // Set to null
                _currentName = null;
            }
        };
    }

    @Test
    public void testHasCurrentName_WithName_ReturnsTrue() {
        // Act
        boolean result = contextWithName.hasCurrentName();
        // Assert
        assertTrue(result, "Expected hasCurrentName to return true when _currentName is not null");
    }

    @Test
    public void testHasCurrentName_WithoutName_ReturnsFalse() {
        // Act
        boolean result = contextWithoutName.hasCurrentName();
        // Assert
        assertFalse(result, "Expected hasCurrentName to return false when _currentName is null");
    }
}
