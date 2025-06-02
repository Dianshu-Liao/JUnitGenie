package org.apache.commons.collections4.map;
import org.apache.commons.collections4.map.CompositeMap;
import org.junit.Test;
import static org.junit.Assert.fail;

public class map_CompositeMap_put_Object_Object_cfg_path_2_Test {

    @Test(timeout = 4000)
    public void testPutThrowsUnsupportedOperationExceptionWhenMutatorIsNull() {
        CompositeMap compositeMap = new CompositeMap(); // Using the default constructor

        try {
            compositeMap.put(new Object(), new Object());
            fail("Expected UnsupportedOperationException to be thrown");
        } catch (UnsupportedOperationException e) {
            // Exception is expected, test passes
            assert "No mutator specified".equals(e.getMessage());
        }
    }

}