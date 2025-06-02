package org.apache.commons.lang3.builder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.junit.Test;
import static org.junit.Assert.assertNotNull;

public class builder_HashCodeBuilder_append_short_____cfg_path_3_Test {

    @Test(timeout = 4000)
    public void testAppendWithNonNullArray() {
        HashCodeBuilder builder = new HashCodeBuilder();
        short[] array = {1, 2, 3};
        
        HashCodeBuilder result = builder.append(array);
        
        assertNotNull(result);
    }

    @Test(timeout = 4000)
    public void testAppendWithNullArray() {
        HashCodeBuilder builder = new HashCodeBuilder();
        short[] array = null;
        
        HashCodeBuilder result = builder.append(array);
        
        assertNotNull(result);
    }

}