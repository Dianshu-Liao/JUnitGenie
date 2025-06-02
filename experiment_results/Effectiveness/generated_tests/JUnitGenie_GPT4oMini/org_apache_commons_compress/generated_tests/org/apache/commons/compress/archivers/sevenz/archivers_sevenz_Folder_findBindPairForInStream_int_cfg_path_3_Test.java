package org.apache.commons.compress.archivers.sevenz;
import org.apache.commons.compress.archivers.sevenz.Folder;
import org.apache.commons.compress.archivers.sevenz.BindPair;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class archivers_sevenz_Folder_findBindPairForInStream_int_cfg_path_3_Test {

    @Test(timeout = 4000)
    public void testFindBindPairForInStream() {
        // Setup
        BindPair[] bindPairs = new BindPair[2];
        bindPairs[0] = new BindPair(0L, 0L); // Changed to long
        bindPairs[1] = new BindPair(1L, 1L); // Changed to long
        Folder folder = new Folder();
        folder.bindPairs = bindPairs;

        // Test case where index matches inIndex of the first BindPair
        int result = folder.findBindPairForInStream(0);
        assertEquals(0, result);

        // Test case where index matches inIndex of the second BindPair
        result = folder.findBindPairForInStream(1);
        assertEquals(1, result);

        // Test case where index does not match any inIndex
        result = folder.findBindPairForInStream(2);
        assertEquals(-1, result);
    }

    @Test(timeout = 4000)
    public void testFindBindPairForInStreamWithNullBindPairs() {
        // Setup
        Folder folder = new Folder();
        folder.bindPairs = null;

        // Test case where bindPairs is null
        int result = folder.findBindPairForInStream(0);
        assertEquals(-1, result);
    }


}