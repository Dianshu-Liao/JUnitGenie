package org.apache.commons.collections4;
import org.apache.commons.collections4.CollectionUtils;
import org.junit.Test;
import java.util.ArrayList;
import java.util.Collection;
import static org.junit.Assert.fail;

public class CollectionUtils_removeRange_Collection_int_int_cfg_path_3_Test {

    @Test(timeout = 4000)
    public void testRemoveRange_EndIndexLessThanStartIndex() {
        Collection<Integer> input = new ArrayList<>();
        input.add(1);
        input.add(2);
        input.add(3);
        
        int startIndex = 1;
        int endIndex = 0;

        try {
            CollectionUtils.removeRange(input, startIndex, endIndex);
            fail("Expected IllegalArgumentException to be thrown");
        } catch (IllegalArgumentException e) {
            // Expected exception
        }
    }

}