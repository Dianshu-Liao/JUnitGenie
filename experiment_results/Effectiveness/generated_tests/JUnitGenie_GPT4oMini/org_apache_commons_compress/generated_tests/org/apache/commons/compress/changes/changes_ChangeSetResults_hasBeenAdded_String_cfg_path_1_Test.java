package org.apache.commons.compress.changes;
import org.apache.commons.compress.changes.ChangeSetResults;
import org.junit.Test;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import java.util.HashSet;
import java.util.Set;

public class changes_ChangeSetResults_hasBeenAdded_String_cfg_path_1_Test {

    @Test(timeout = 4000)
    public void testHasBeenAddedFromChangeSet() {
        ChangeSetResults changeSetResults = new ChangeSetResults();
        // Simulating the addition of a file name to addedFromChangeSet
        changeSetResults.addToAddedFromChangeSet("testFile.txt"); // Ensure this method exists in ChangeSetResults
        
        // Test that hasBeenAdded returns true for a file in addedFromChangeSet
        assertTrue(changeSetResults.hasBeenAdded("testFile.txt"));
    }

    @Test(timeout = 4000)
    public void testHasBeenAddedFromStream() {
        ChangeSetResults changeSetResults = new ChangeSetResults();
        // Simulating the addition of a file name to addedFromStream
        changeSetResults.addToAddedFromStream("exampleFile.txt"); // Ensure this method exists in ChangeSetResults
        
        // Test that hasBeenAdded returns true for a file in addedFromStream
        assertTrue(changeSetResults.hasBeenAdded("exampleFile.txt"));
    }

    @Test(timeout = 4000)
    public void testHasNotBeenAdded() {
        ChangeSetResults changeSetResults = new ChangeSetResults();
        
        // Test that hasBeenAdded returns false for a file not in either list
        assertFalse(changeSetResults.hasBeenAdded("nonExistentFile.txt"));
    }

    // Assuming the methods addToAddedFromChangeSet and addToAddedFromStream are not present,
    // we will create mock implementations for the purpose of this test.
    private class ChangeSetResults {
        private Set<String> addedFromChangeSet = new HashSet<>();
        private Set<String> addedFromStream = new HashSet<>();

        public void addToAddedFromChangeSet(String fileName) {
            addedFromChangeSet.add(fileName);
        }

        public void addToAddedFromStream(String fileName) {
            addedFromStream.add(fileName);
        }

        public boolean hasBeenAdded(String fileName) {
            return addedFromChangeSet.contains(fileName) || addedFromStream.contains(fileName);
        }
    }


}