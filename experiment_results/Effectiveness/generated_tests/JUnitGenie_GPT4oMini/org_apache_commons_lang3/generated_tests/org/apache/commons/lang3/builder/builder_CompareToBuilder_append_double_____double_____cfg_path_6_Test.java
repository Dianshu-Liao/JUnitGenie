package org.apache.commons.lang3.builder;
import org.apache.commons.lang3.builder.CompareToBuilder;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class builder_CompareToBuilder_append_double_____double_____cfg_path_6_Test {

    @Test(timeout = 4000)
    public void testAppendArraysEqual() {
        CompareToBuilder builder = new CompareToBuilder();
        double[] lhs = {1.0, 2.0, 3.0};
        double[] rhs = {1.0, 2.0, 3.0};
        
        builder.append(lhs, rhs);
        
        assertEquals(0, builder.toComparison());
    }

    @Test(timeout = 4000)
    public void testAppendNullLhs() {
        CompareToBuilder builder = new CompareToBuilder();
        double[] lhs = null;
        double[] rhs = {1.0, 2.0, 3.0};
        
        builder.append(lhs, rhs);
        
        assertEquals(-1, builder.toComparison());
    }

    @Test(timeout = 4000)
    public void testAppendNullRhs() {
        CompareToBuilder builder = new CompareToBuilder();
        double[] lhs = {1.0, 2.0, 3.0};
        double[] rhs = null;
        
        builder.append(lhs, rhs);
        
        assertEquals(1, builder.toComparison());
    }

    @Test(timeout = 4000)
    public void testAppendLhsShorter() {
        CompareToBuilder builder = new CompareToBuilder();
        double[] lhs = {1.0};
        double[] rhs = {1.0, 2.0, 3.0};
        
        builder.append(lhs, rhs);
        
        assertEquals(-1, builder.toComparison());
    }

    @Test(timeout = 4000)
    public void testAppendRhsShorter() {
        CompareToBuilder builder = new CompareToBuilder();
        double[] lhs = {1.0, 2.0, 3.0};
        double[] rhs = {1.0};
        
        builder.append(lhs, rhs);
        
        assertEquals(1, builder.toComparison());
    }

    @Test(timeout = 4000)
    public void testAppendDifferentElements() {
        CompareToBuilder builder = new CompareToBuilder();
        double[] lhs = {1.0, 2.0, 3.0};
        double[] rhs = {1.0, 2.0, 4.0};
        
        builder.append(lhs, rhs);
        
        // The comparison should be less than 0 since 3.0 < 4.0
        assertEquals(-1, builder.toComparison());
    }


}