package org.apache.commons.compress.archivers.sevenz;

import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import java.util.Objects;

class SevenZMethodConfiguration_SevenZMethodConfiguration_4_0_Test {

    @Test
    void testConstructorWithMethod() {
        // Arrange
        // Use an actual enum constant
        SevenZMethod method = SevenZMethod.LZMA;
        // Act
        SevenZMethodConfiguration config = new SevenZMethodConfiguration(method);
        // Assert
        assertNotNull(config);
        assertEquals(method, config.getMethod());
        assertNull(config.getOptions());
    }

    @Test
    void testConstructorWithMethodAndOptions() {
        // Arrange
        // Use an actual enum constant
        SevenZMethod method = SevenZMethod.LZMA;
        // Replace with actual options if necessary
        Object options = new Object();
        // Act
        SevenZMethodConfiguration config = new SevenZMethodConfiguration(method, options);
        // Assert
        assertNotNull(config);
        assertEquals(method, config.getMethod());
        assertEquals(options, config.getOptions());
    }
}
