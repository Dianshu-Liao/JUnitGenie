package org.apache.commons.collections4;
import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.collections4.Closure;
import org.junit.Test;
import static org.junit.Assert.assertNull;

public class CollectionUtils_forAllDo_Iterable_Closure_cfg_path_1_Test {

    @Test(timeout = 4000)
    public void testForAllDoWithNullClosure() {
        Iterable<String> collection = java.util.Arrays.asList("item1", "item2", "item3");
        Closure<String> closure = null;

        Closure<String> result = CollectionUtils.forAllDo(collection, closure);

        // Verify that the result is null when closure is null
        assertNull(result);
    }

}