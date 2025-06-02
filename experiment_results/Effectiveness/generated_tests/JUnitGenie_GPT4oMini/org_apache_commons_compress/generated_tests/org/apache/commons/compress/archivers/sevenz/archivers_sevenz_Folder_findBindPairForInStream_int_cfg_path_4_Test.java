package org.apache.commons.compress.archivers.sevenz;
import org.apache.commons.compress.archivers.sevenz.Folder;
import org.apache.commons.compress.archivers.sevenz.BindPair;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class archivers_sevenz_Folder_findBindPairForInStream_int_cfg_path_4_Test {

    @Test(timeout = 4000)
    public void testFindBindPairForInStreamWithNullBindPairs() {
        Folder folder = new Folder();
        int result = folder.findBindPairForInStream(0);
        assertEquals(-1, result);
    }

    @Test(timeout = 4000)
    public void testFindBindPairForInStreamWithEmptyBindPairs() {
        Folder folder = new Folder();
        folder.bindPairs = new BindPair[0]; // Setting bindPairs to an empty array
        int result = folder.findBindPairForInStream(0);
        assertEquals(-1, result);
    }

    @Test(timeout = 4000)
    public void testFindBindPairForInStreamWithMatchingIndex() {
        Folder folder = new Folder();
        BindPair bindPair = new BindPair(1, 0); // Creating BindPair with inIndex = 1 and outIndex = 0
        folder.bindPairs = new BindPair[] { bindPair }; // Setting bindPairs with one element
        int result = folder.findBindPairForInStream(1);
        assertEquals(0, result); // Expecting to find the bind pair at index 0
    }

    @Test(timeout = 4000)
    public void testFindBindPairForInStreamWithNonMatchingIndex() {
        Folder folder = new Folder();
        BindPair bindPair = new BindPair(2, 0); // Creating BindPair with inIndex = 2 and outIndex = 0
        folder.bindPairs = new BindPair[] { bindPair }; // Setting bindPairs with one element
        int result = folder.findBindPairForInStream(1);
        assertEquals(-1, result); // Expecting not to find the bind pair
    }


}