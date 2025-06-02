package org.apache.commons.lang3.tuple;
import org.apache.commons.lang3.tuple.ImmutablePair;
import org.junit.Test;
import static org.junit.Assert.assertNull;

public class tuple_ImmutablePair_of_Object_Object_cfg_path_3_Test {

    @Test(timeout = 4000)
    public void testOfBothParametersNull() {
        // Test case where both left and right parameters are null
        ImmutablePair<Object, Object> result = ImmutablePair.of(null, null);
        assertNull(result); // Expecting nullPair() to be called
    }

}