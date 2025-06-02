package org.apache.commons.collections4.bag;
import org.apache.commons.collections4.Bag;
import org.apache.commons.collections4.bag.UnmodifiableBag;
import org.apache.commons.collections4.bag.HashBag;
import org.junit.Test;
import static org.junit.Assert.*;

public class bag_UnmodifiableBag_unmodifiableBag_Bag_cfg_path_1_Test {

    @Test(timeout = 4000)
    public void testUnmodifiableBagWithNonUnmodifiableBag() {
        // Create a modifiable Bag instance
        Bag<String> modifiableBag = new HashBag<>();
        modifiableBag.add("item1");
        modifiableBag.add("item2");

        // Call the focal method
        Bag<String> resultBag = null;
        try {
            resultBag = UnmodifiableBag.unmodifiableBag(modifiableBag);
        } catch (Exception e) {
            fail("Exception should not be thrown for a modifiable bag: " + e.getMessage());
        }

        // Verify that the result is an instance of UnmodifiableBag
        assertTrue(resultBag instanceof UnmodifiableBag);
        // Verify that the contents of the bag are as expected
        assertEquals(2, resultBag.size());
        assertTrue(resultBag.contains("item1"));
        assertTrue(resultBag.contains("item2"));
    }

}