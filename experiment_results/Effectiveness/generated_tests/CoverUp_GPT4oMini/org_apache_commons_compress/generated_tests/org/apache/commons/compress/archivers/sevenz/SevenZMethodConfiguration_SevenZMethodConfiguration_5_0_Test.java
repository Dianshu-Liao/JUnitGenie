package org.apache.commons.compress.archivers.sevenz;

import org.apache.commons.compress.archivers.sevenz.Coders;
import org.apache.commons.compress.archivers.sevenz.SevenZMethod;
import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import java.util.Objects;

class SevenZMethodConfiguration_SevenZMethodConfiguration_5_0_Test {

    private SevenZMethodConfiguration sevenZMethodConfiguration;

    private SevenZMethod method;

    @BeforeEach
    void setUp() {
        // Example method, can be changed as needed
        method = SevenZMethod.LZMA;
    }

    @Test
    void testConstructorWithValidOptions() {
        // Replace with actual valid options for the method
        Object validOptions = new Object();
        when(Coders.findByMethod(method)).thenReturn(mock(AbstractCoder.class));
        when(Coders.findByMethod(method).isOptionInstance(validOptions)).thenReturn(true);
        sevenZMethodConfiguration = new SevenZMethodConfiguration(method, validOptions);
        assertNotNull(sevenZMethodConfiguration);
        assertEquals(method, sevenZMethodConfiguration.getMethod());
        assertEquals(validOptions, sevenZMethodConfiguration.getOptions());
    }

    @Test
    void testConstructorWithNullOptions() {
        sevenZMethodConfiguration = new SevenZMethodConfiguration(method, null);
        assertNotNull(sevenZMethodConfiguration);
        assertEquals(method, sevenZMethodConfiguration.getMethod());
        assertNull(sevenZMethodConfiguration.getOptions());
    }

    @Test
    void testConstructorWithInvalidOptions() {
        // Replace with actual invalid options for the method
        Object invalidOptions = new Object();
        when(Coders.findByMethod(method)).thenReturn(mock(AbstractCoder.class));
        when(Coders.findByMethod(method).isOptionInstance(invalidOptions)).thenReturn(false);
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> {
            new SevenZMethodConfiguration(method, invalidOptions);
        });
        assertEquals("The " + method + " method doesn't support options of type " + invalidOptions.getClass(), exception.getMessage());
    }
}
