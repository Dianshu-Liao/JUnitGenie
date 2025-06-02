package org.apache.commons.compress.changes;

import java.lang.reflect.Method;
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

    @Test
    public void testHasBeenAdded_FileInAddedFromChangeSet() throws Exception {
        // Using reflection to access private field
        addToAddedFromChangeSet("testFile.txt");
        assertTrue(invokeHasBeenAdded("testFile.txt"));
    }

    @Test
    public void testHasBeenAdded_FileInAddedFromStream() throws Exception {
        // Using reflection to access private field
        addToAddedFromStream("testFile.txt");
        assertTrue(invokeHasBeenAdded("testFile.txt"));
    }

    @Test
    public void testHasBeenAdded_FileNotAdded() throws Exception {
        assertFalse(invokeHasBeenAdded("nonExistentFile.txt"));
    }

    private void addToAddedFromChangeSet(String fileName) throws Exception {
        Method method = ChangeSetResults.class.getDeclaredMethod("getAddedFromChangeSet");
        method.setAccessible(true);
        List<String> addedFromChangeSet = (List<String>) method.invoke(changeSetResults);
        addedFromChangeSet.add(fileName);
    }

    private void addToAddedFromStream(String fileName) throws Exception {
        Method method = ChangeSetResults.class.getDeclaredMethod("getAddedFromStream");
        method.setAccessible(true);
        List<String> addedFromStream = (List<String>) method.invoke(changeSetResults);
        addedFromStream.add(fileName);
    }

    private boolean invokeHasBeenAdded(String fileName) throws Exception {
        Method method = ChangeSetResults.class.getDeclaredMethod("hasBeenAdded", String.class);
        method.setAccessible(true);
        return (boolean) method.invoke(changeSetResults, fileName);
    }
}
