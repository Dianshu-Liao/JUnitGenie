package org.apache.commons.lang3.builder;
import org.apache.commons.lang3.builder.CompareToBuilder;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class builder_CompareToBuilder_append_boolean_____boolean_____cfg_path_8_Test {

    @Test(timeout = 4000)
    public void testAppendWithNullLhs() {
        CompareToBuilder builder = new CompareToBuilder();
        boolean[] lhs = null;
        boolean[] rhs = {true, false};

        builder.append(lhs, rhs);
        
        // Verify that comparison is set to -1 when lhs is null
        // Use a method to retrieve the comparison result instead of accessing the private field directly
        int comparisonResult = builder.toComparison();
        assertEquals(-1, comparisonResult);
    }


}