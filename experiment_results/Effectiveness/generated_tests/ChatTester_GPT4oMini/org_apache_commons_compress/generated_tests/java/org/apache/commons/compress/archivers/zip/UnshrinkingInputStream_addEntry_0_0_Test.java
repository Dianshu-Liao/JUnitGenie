package org.apache.commons.compress.archivers.zip;

import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Method;
import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import java.nio.ByteOrder;
import org.apache.commons.compress.compressors.lzw.LZWInputStream;

class UnshrinkingInputStream_addEntry_0_0_Test {

    private UnshrinkingInputStream unshrinkingInputStream;

    @BeforeEach
    void setUp() {
        InputStream mockInputStream = new InputStream() {

            @Override
            public int read() {
                // End of stream for testing
                return -1;
            }
        };
        unshrinkingInputStream = new UnshrinkingInputStream(mockInputStream);
    }

    @Test
    void testAddEntry_NewEntry() throws Exception {
        // Arrange
        // Example previous code
        int previousCode = 0;
        // Example character
        byte character = 'a';
        // Act
        int result = invokeAddEntry(previousCode, character);
        // Assert
        assertTrue(result >= 0, "Expected a valid index for a new entry");
    }

    @Test
    void testAddEntry_ExceedMaxTableSize() throws Exception {
        // Arrange
        // Example previous code
        int previousCode = 0;
        // Example character
        byte character = 'b';
        for (int i = 0; i < (1 << 13); i++) {
            invokeAddEntry(previousCode, character);
        }
        // Act
        int result = invokeAddEntry(previousCode, character);
        // Assert
        assertEquals(-1, result, "Expected -1 when exceeding max table size");
    }

    @Test
    void testAddEntry_ValidEntryAfterUsed() throws Exception {
        // Arrange
        // Example previous code
        int previousCode = 0;
        // Example character
        byte character = 'c';
        // First add entry to fill the table
        for (int i = 0; i < (1 << 13) - 1; i++) {
            invokeAddEntry(previousCode, character);
        }
        // Now add one more entry to check the behavior
        // This should fill the table
        invokeAddEntry(previousCode, character);
        // Act
        // Try to add again
        int result = invokeAddEntry(previousCode, character);
        // Assert
        assertEquals(-1, result, "Expected -1 when trying to add entry after max table size reached");
    }

    private int invokeAddEntry(int previousCode, byte character) throws Exception {
        Method method = UnshrinkingInputStream.class.getDeclaredMethod("addEntry", int.class, byte.class);
        method.setAccessible(true);
        return (int) method.invoke(unshrinkingInputStream, previousCode, character);
    }
}
