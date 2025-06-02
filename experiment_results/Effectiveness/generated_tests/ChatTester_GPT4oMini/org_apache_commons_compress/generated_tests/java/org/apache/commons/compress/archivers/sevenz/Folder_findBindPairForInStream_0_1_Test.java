// Test method
package org.apache.commons.compress.archivers.sevenz;

import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import java.io.IOException;
import java.util.Collections;
import java.util.LinkedList;

final class Folder_findBindPairForInStream_0_1_Test {

    private Folder folder;

    @BeforeEach
    void setUp() {
        folder = new Folder();
    }

    @Test
    void testFindBindPairForInStream_WithNullBindPairs() {
        // Arrange
        folder.bindPairs = null;
        // Act
        int result = folder.findBindPairForInStream(0);
        // Assert
        assertEquals(-1, result);
    }

    @Test
    void testFindBindPairForInStream_WithEmptyBindPairs() {
        // Arrange
        folder.bindPairs = new BindPair[0];
        // Act
        int result = folder.findBindPairForInStream(0);
        // Assert
        assertEquals(-1, result);
    }

    @Test
    void testFindBindPairForInStream_WithNoMatchingIndex() {
        // Arrange
        folder.bindPairs = new BindPair[] { new BindPair(1, 0), new BindPair(2, 0), new BindPair(3, 0) };
        // Act
        int result = folder.findBindPairForInStream(0);
        // Assert
        assertEquals(-1, result);
    }

    @Test
    void testFindBindPairForInStream_WithMatchingIndex() {
        // Arrange
        folder.bindPairs = new BindPair[] { new BindPair(0, 0), new BindPair(1, 0), new BindPair(2, 0) };
        // Act
        int result = folder.findBindPairForInStream(1);
        // Assert
        assertEquals(1, result);
    }

    @Test
    void testFindBindPairForInStream_WithMultipleMatchingIndices() {
        // Arrange
        folder.bindPairs = new BindPair[] { new BindPair(0, 0), new BindPair(1, 0), new BindPair(1, 0) };
        // Act
        int result = folder.findBindPairForInStream(1);
        // Assert
        // Should return the first match
        assertEquals(1, result);
    }
}
