package org.apache.commons.lang3.builder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.junit.Test;
import static org.junit.Assert.assertNotNull;

public class builder_HashCodeBuilder_append_float_____cfg_path_3_Test {

    @Test(timeout = 4000)
    public void testAppendWithNonNullArray() {
        HashCodeBuilder builder = new HashCodeBuilder();
        float[] array = {1.0f, 2.0f, 3.0f}; // Example array
        HashCodeBuilder result = builder.append(array);
        assertNotNull(result); // Ensure the result is not null
    }

    @Test(timeout = 4000)
    public void testAppendWithNullArray() {
        HashCodeBuilder builder = new HashCodeBuilder();
        float[] array = null; // Null array
        HashCodeBuilder result = builder.append(array);
        assertNotNull(result); // Ensure the result is not null
    }

}