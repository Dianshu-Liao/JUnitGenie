package org.apache.commons.lang3.builder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.junit.Test;
import static org.junit.Assert.assertNotNull;

public class builder_HashCodeBuilder_append_float_____cfg_path_2_Test {

    @Test(timeout = 4000)
    public void testAppendWithValidArray() {
        HashCodeBuilder builder = new HashCodeBuilder();
        float[] array = {1.0f, -2.0f, Float.NaN, Float.POSITIVE_INFINITY, Float.NEGATIVE_INFINITY};
        
        try {
            HashCodeBuilder result = builder.append(array);
            assertNotNull(result);
        } catch (Exception e) {
            // Handle the exception if it occurs
            e.printStackTrace();
        }
    }

    @Test(timeout = 4000)
    public void testAppendWithNullArray() {
        HashCodeBuilder builder = new HashCodeBuilder();
        float[] array = null;

        try {
            HashCodeBuilder result = builder.append(array);
            assertNotNull(result);
        } catch (Exception e) {
            // Handle the exception if it occurs
            e.printStackTrace();
        }
    }

}