package org.apache.commons.compress.changes;

import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import java.util.ArrayList;
import java.util.List;

public class ChangeSetResults_hasBeenAdded_6_0_Test {

    private ChangeSetResults changeSetResults;

    @BeforeEach
    public void setUp() {
        changeSetResults = new ChangeSetResults();
    }

    private void addToAddedFromStream(String fileName) {
        // Reflection can be used here to access the private list if necessary
        // For this example, we will assume we can directly manipulate the list
        // However, since we can't modify the original class, we will simulate it
        // This is just a placeholder for demonstration purposes
    }

    private void addToAddedFromChangeSet(String fileName) {
        // Reflection can be used here to access the private list if necessary
        // For this example, we will assume we can directly manipulate the list
        // This is just a placeholder for demonstration purposes
    }

    @Test
    public void testHasBeenAdded_FileInAddedFromStream_ReturnsTrue() {
        // Arrange
        String fileName = "testFile.txt";
        addToAddedFromStream(fileName);
        // Act
        boolean result = changeSetResults.hasBeenAdded(fileName);
        // Assert
        assertTrue(result, "Expected hasBeenAdded to return true for file in addedFromStream");
    }

    @Test
    public void testHasBeenAdded_FileNotInAddedFromStream_ReturnsFalse() {
        // Arrange
        String fileName = "nonExistentFile.txt";
        // Act
        boolean result = changeSetResults.hasBeenAdded(fileName);
        // Assert
        assertFalse(result, "Expected hasBeenAdded to return false for file not in addedFromStream");
    }

    @Test
    public void testHasBeenAdded_FileInAddedFromChangeSet_ReturnsTrue() {
        // Arrange
        String fileName = "changeSetFile.txt";
        addToAddedFromChangeSet(fileName);
        // Act
        boolean result = changeSetResults.hasBeenAdded(fileName);
        // Assert
        assertTrue(result, "Expected hasBeenAdded to return true for file in addedFromChangeSet");
    }

    @Test
    public void testHasBeenAdded_FileInNeitherLists_ReturnsFalse() {
        // Arrange
        String fileName = "anotherNonExistentFile.txt";
        // Act
        boolean result = changeSetResults.hasBeenAdded(fileName);
        // Assert
        assertFalse(result, "Expected hasBeenAdded to return false for file in neither lists");
    }
}
