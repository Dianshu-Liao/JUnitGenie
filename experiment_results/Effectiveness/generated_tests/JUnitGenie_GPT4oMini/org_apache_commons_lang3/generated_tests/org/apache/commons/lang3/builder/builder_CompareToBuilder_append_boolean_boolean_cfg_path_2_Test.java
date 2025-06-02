package org.apache.commons.lang3.builder;
import org.apache.commons.lang3.builder.CompareToBuilder;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class builder_CompareToBuilder_append_boolean_boolean_cfg_path_2_Test {

    @Test(timeout = 4000)
    public void testAppend_LhsTrue_RhsFalse() {
        CompareToBuilder builder = new CompareToBuilder();
        builder.append(true, false);
        assertEquals(1, builder.toComparison());
    }

    @Test(timeout = 4000)
    public void testAppend_LhsFalse_RhsTrue() {
        CompareToBuilder builder = new CompareToBuilder();
        builder.append(false, true);
        assertEquals(-1, builder.toComparison());
    }

    @Test(timeout = 4000)
    public void testAppend_LhsTrue_RhsTrue() {
        CompareToBuilder builder = new CompareToBuilder();
        builder.append(true, true);
        assertEquals(0, builder.toComparison());
    }

    @Test(timeout = 4000)
    public void testAppend_LhsFalse_RhsFalse() {
        CompareToBuilder builder = new CompareToBuilder();
        builder.append(false, false);
        assertEquals(0, builder.toComparison());
    }

    @Test(timeout = 4000)
    public void testAppend_ComparisonNotZero() {
        CompareToBuilder builder = new CompareToBuilder();
        builder.append(true, false);
        assertEquals(1, builder.toComparison()); // Should remain unchanged
    }


}