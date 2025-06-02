package org.apache.commons.compress.changes;
import org.apache.commons.compress.changes.ChangeSetResults;
import org.junit.Test;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertFalse;

public class changes_ChangeSetResults_hasBeenAdded_String_cfg_path_2_Test {



    @Test(timeout = 4000)
    public void testHasNotBeenAdded() {
        ChangeSetResults changeSetResults = new ChangeSetResults();
        
        // Test that hasBeenAdded returns false for a file not in either list
        boolean result = changeSetResults.hasBeenAdded("nonExistentFile.txt");
        assertFalse(result);
    }


}
