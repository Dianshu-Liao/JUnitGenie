package org.apache.commons.collections4.functors;
import org.apache.commons.collections4.functors.ConstantTransformer;
import org.apache.commons.collections4.Transformer;
import org.junit.Test;
import static org.junit.Assert.assertNotNull;

public class functors_ConstantTransformer_constantTransformer_Object_cfg_path_1_Test {

    @Test(timeout = 4000)
    public void testConstantTransformerWithNonNullInput() {
        Object constantValue = "Test Constant";
        Transformer<Object, Object> transformer = null;

        try {
            transformer = ConstantTransformer.constantTransformer(constantValue);
        } catch (Exception e) {
            // Handle the exception if it occurs
            e.printStackTrace();
        }

        assertNotNull("Transformer should not be null when input is non-null", transformer);
    }

    @Test(timeout = 4000)
    public void testConstantTransformerWithNullInput() {
        Transformer<Object, Object> transformer = null;

        try {
            transformer = ConstantTransformer.constantTransformer(null);
        } catch (Exception e) {
            // Handle the exception if it occurs
            e.printStackTrace();
        }

        assertNotNull("Transformer should be null when input is null", transformer);
    }

}