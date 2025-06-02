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
    public void testHasBeenAdded_FileInChangeSet() throws Exception {
        // Using reflection to access private fields
        addToChangeSet("testFile.txt");
        assertTrue(invokeHasBeenAdded("testFile.txt"));
    }

    @Test
    public void testHasBeenAdded_FileInStream() throws Exception {
        // Using reflection to access private fields
        addToStream("testFile.txt");
        assertTrue(invokeHasBeenAdded("testFile.txt"));
    }

    @Test
    public void testHasBeenAdded_FileNotAdded() throws Exception {
        assertFalse(invokeHasBeenAdded("nonExistentFile.txt"));
    }

    private void addToChangeSet(String fileName) throws Exception {
        // Reflection to add file to addedFromChangeSet
        Method method = ChangeSetResults.class.getDeclaredMethod("addToChangeSet", String.class);
        method.setAccessible(true);
        method.invoke(changeSetResults, fileName);
    }

    private void addToStream(String fileName) throws Exception {
        // Reflection to add file to addedFromStream
        Method method = ChangeSetResults.class.getDeclaredMethod("addToStream", String.class);
        method.setAccessible(true);
        method.invoke(changeSetResults, fileName);
    }

    private boolean invokeHasBeenAdded(String fileName) throws Exception {
        Method method = ChangeSetResults.class.getDeclaredMethod("hasBeenAdded", String.class);
        method.setAccessible(true);
        return (boolean) method.invoke(changeSetResults, fileName);
    }
}
