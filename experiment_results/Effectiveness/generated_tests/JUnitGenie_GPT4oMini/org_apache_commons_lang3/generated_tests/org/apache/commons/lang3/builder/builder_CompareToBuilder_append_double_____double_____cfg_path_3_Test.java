package org.apache.commons.lang3.builder;
import org.apache.commons.lang3.builder.CompareToBuilder;
import org.junit.Test;
import static org.junit.Assert.*;

public class builder_CompareToBuilder_append_double_____double_____cfg_path_3_Test {

    @Test(timeout = 4000)
    public void testAppendWithValidArrays() {
        CompareToBuilder builder = new CompareToBuilder();
        double[] lhs = {1.0, 2.0, 3.0};
        double[] rhs = {1.0, 2.0, 3.0};
        
        builder.append(lhs, rhs);
        // Assuming comparison should be 0 for equal arrays
        assertEquals(0, builder.toComparison());
    }

    @Test(timeout = 4000)
    public void testAppendWithDifferentLengths() {
        CompareToBuilder builder = new CompareToBuilder();
        double[] lhs = {1.0, 2.0};
        double[] rhs = {1.0, 2.0, 3.0};
        
        builder.append(lhs, rhs);
        // Assuming comparison should be -1 for lhs shorter than rhs
        assertTrue(builder.toComparison() < 0);
    }

    @Test(timeout = 4000)
    public void testAppendWithNullLhs() {
        CompareToBuilder builder = new CompareToBuilder();
        double[] lhs = null;
        double[] rhs = {1.0, 2.0};
        
        builder.append(lhs, rhs);
        // Assuming comparison should be -1 when lhs is null
        assertEquals(-1, builder.toComparison());
    }

    @Test(timeout = 4000)
    public void testAppendWithNullRhs() {
        CompareToBuilder builder = new CompareToBuilder();
        double[] lhs = {1.0, 2.0};
        double[] rhs = null;
        
        builder.append(lhs, rhs);
        // Assuming comparison should be 1 when rhs is null
        assertEquals(1, builder.toComparison());
    }

    @Test(timeout = 4000)
    public void testAppendWithSameReference() {
        CompareToBuilder builder = new CompareToBuilder();
        double[] lhs = {1.0, 2.0};
        double[] rhs = lhs; // Same reference
        
        builder.append(lhs, rhs);
        // Assuming comparison should be 0 for same reference
        assertEquals(0, builder.toComparison());
    }

    @Test(timeout = 4000)
    public void testAppendWithDifferentValues() {
        CompareToBuilder builder = new CompareToBuilder();
        double[] lhs = {1.0, 2.0, 3.0};
        double[] rhs = {1.0, 2.0, 4.0};
        
        builder.append(lhs, rhs);
        // Assuming comparison should be < 0 since 3.0 < 4.0
        assertTrue(builder.toComparison() < 0);
    }


}