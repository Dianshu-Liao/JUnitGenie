// Test method
package org.apache.commons.compress.archivers.sevenz;

import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import java.util.Objects;
import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
public class SevenZMethodConfiguration_SevenZMethodConfiguration_5_2_Test {

    @Test
    public void testConstructorWithValidOptions() {
        // Mocking SevenZMethod
        SevenZMethod method = mock(SevenZMethod.class);
        // Replace with an actual valid option instance
        Object validOptions = new Object();
        SevenZMethodConfiguration config = new SevenZMethodConfiguration(method, validOptions);
        assertNotNull(config);
        assertEquals(method, config.getMethod());
        assertEquals(validOptions, config.getOptions());
    }

    @Test
    public void testConstructorWithNullOptions() {
        // Mocking SevenZMethod
        SevenZMethod method = mock(SevenZMethod.class);
        SevenZMethodConfiguration config = new SevenZMethodConfiguration(method, null);
        assertNotNull(config);
        assertEquals(method, config.getMethod());
        assertNull(config.getOptions());
    }

    @Test
    public void testConstructorWithInvalidOptions() {
        // Mocking SevenZMethod
        SevenZMethod method = mock(SevenZMethod.class);
        // Replace with an actual invalid option instance
        Object invalidOptions = new Object();
        // Mocking findByMethod to return a valid AbstractCoder
        AbstractCoder mockCoder = mock(AbstractCoder.class);
        when(Coders.findByMethod(method)).thenReturn(mockCoder);
        when(mockCoder.isOptionInstance(invalidOptions)).thenReturn(false);
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> {
            new SevenZMethodConfiguration(method, invalidOptions);
        });
        assertEquals("The " + method + " method doesn't support options of type " + invalidOptions.getClass(), exception.getMessage());
    }
}
