package org.apache.commons.lang3.builder;
import org.apache.commons.lang3.builder.CompareToBuilder;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class builder_CompareToBuilder_append_boolean_boolean_cfg_path_1_Test {

    @Test(timeout = 4000)
    public void testAppend_LhsTrue_RhsFalse() {
        CompareToBuilder builder = new CompareToBuilder();
        builder.append(true, false);
        // The comparison should be set to 1 since lhs is true and rhs is false
        assertEquals(1, builder.toComparison());
    }

    @Test(timeout = 4000)
    public void testAppend_LhsFalse_RhsTrue() {
        CompareToBuilder builder = new CompareToBuilder();
        builder.append(false, true);
        // The comparison should be set to -1 since lhs is false and rhs is true
        assertEquals(-1, builder.toComparison());
    }

    @Test(timeout = 4000)
    public void testAppend_LhsTrue_RhsTrue() {
        CompareToBuilder builder = new CompareToBuilder();
        builder.append(true, true);
        // The comparison should remain 0 since lhs and rhs are equal
        assertEquals(0, builder.toComparison());
    }

    @Test(timeout = 4000)
    public void testAppend_LhsFalse_RhsFalse() {
        CompareToBuilder builder = new CompareToBuilder();
        builder.append(false, false);
        // The comparison should remain 0 since lhs and rhs are equal
        assertEquals(0, builder.toComparison());
    }

    @Test(timeout = 4000)
    public void testAppend_ComparisonNotZero() {
        CompareToBuilder builder = new CompareToBuilder();
        builder.append(true, false);
        // The comparison should remain 1 since it was already set
        assertEquals(1, builder.toComparison());
    }


}