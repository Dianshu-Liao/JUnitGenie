package org.apache.commons.lang3.builder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.junit.Test;
import static org.junit.Assert.assertNotNull;

public class builder_HashCodeBuilder_append_short_____cfg_path_2_Test {

    @Test(timeout = 4000)
    public void testAppendWithNonNullArray() {
        HashCodeBuilder builder = new HashCodeBuilder();
        short[] array = {1, 2, 3, 4, 5}; // Valid short array

        HashCodeBuilder result = builder.append(array);
        
        // Verify that the result is not null
        assertNotNull(result);
    }

    @Test(timeout = 4000)
    public void testAppendWithNullArray() {
        HashCodeBuilder builder = new HashCodeBuilder();
        short[] array = null; // Null array

        try {
            HashCodeBuilder result = builder.append(array);
            // Verify that the result is not null even when array is null
            assertNotNull(result);
        } catch (Exception e) {
            // Handle exception if any
            e.printStackTrace();
        }
    }

}