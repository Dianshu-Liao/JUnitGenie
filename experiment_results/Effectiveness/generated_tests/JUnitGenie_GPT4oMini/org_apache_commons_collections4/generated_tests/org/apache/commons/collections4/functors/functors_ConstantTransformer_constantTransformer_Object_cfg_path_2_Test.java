package org.apache.commons.collections4.functors;
import org.apache.commons.collections4.functors.ConstantTransformer;
import org.apache.commons.collections4.Transformer;
import org.junit.Test;
import static org.junit.Assert.assertNull;

public class functors_ConstantTransformer_constantTransformer_Object_cfg_path_2_Test {

    @Test(timeout = 4000)
    public void testConstantTransformerWithNull() {
        // Test case for the scenario where constantToReturn is null
        Transformer<Object, Object> transformer = ConstantTransformer.constantTransformer(null);
        assertNull(transformer);
    }

}