package org.apache.commons.lang3.builder;
import org.apache.commons.lang3.builder.CompareToBuilder;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class builder_CompareToBuilder_append_double_____double_____cfg_path_8_Test {

    @Test(timeout = 4000)
    public void testAppendWithNullLhs() {
        CompareToBuilder builder = new CompareToBuilder();
        double[] lhs = null;
        double[] rhs = {1.0, 2.0, 3.0};

        builder.append(lhs, rhs);
        
        // Verify that comparison is set to -1 when lhs is null
        // Since comparison is private, we should use a method to get the result instead
        int result = builder.toComparison(); // Use the toComparison method for getting comparison result
        assertEquals(-1, result);
    }


}