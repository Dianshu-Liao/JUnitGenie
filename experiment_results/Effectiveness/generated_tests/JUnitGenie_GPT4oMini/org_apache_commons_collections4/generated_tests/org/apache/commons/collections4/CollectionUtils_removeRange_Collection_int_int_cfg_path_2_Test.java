package org.apache.commons.collections4;
import org.apache.commons.collections4.CollectionUtils;
import org.junit.Test;
import java.util.ArrayList;
import java.util.Collection;
import static org.junit.Assert.fail;

public class CollectionUtils_removeRange_Collection_int_int_cfg_path_2_Test {

    @Test(timeout = 4000)
    public void testRemoveRange_EndIndexGreaterThanSize() {
        Collection<Integer> input = new ArrayList<>();
        input.add(1);
        input.add(2);
        input.add(3);
        
        int startIndex = 1;
        int endIndex = 5; // This will trigger the IndexOutOfBoundsException

        try {
            CollectionUtils.removeRange(input, startIndex, endIndex);
            fail("Expected IndexOutOfBoundsException to be thrown");
        } catch (IndexOutOfBoundsException e) {
            // Exception is expected, test passes
        }
    }

}