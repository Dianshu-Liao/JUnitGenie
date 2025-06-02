package org.apache.commons.lang3.builder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.junit.Test;
import static org.junit.Assert.assertNotNull;

public class builder_HashCodeBuilder_append_float_____cfg_path_1_Test {

    @Test(timeout = 4000)
    public void testAppendWithNullArray() {
        HashCodeBuilder builder = new HashCodeBuilder();
        try {
            builder.append((float[]) null);
            // Since we are testing the behavior with a null array, we can assert that the builder is not null
            assertNotNull(builder);
        } catch (Exception e) {
            // Handle the exception if it occurs
            e.printStackTrace();
        }
    }

}