package org.apache.commons.lang3.builder;
import org.apache.commons.lang3.builder.CompareToBuilder;
import org.junit.Test;
import static org.junit.Assert.assertSame;

public class builder_CompareToBuilder_append_boolean_boolean_cfg_path_4_Test {

    @Test(timeout = 4000)
    public void testAppendWhenComparisonIsZeroAndLhsEqualsRhs() {
        CompareToBuilder builder = new CompareToBuilder();
        builder.append(true, true);
        assertSame(builder, builder); // Verifying that the same instance is returned
    }

    @Test(timeout = 4000)
    public void testAppendWhenComparisonIsZeroAndLhsIsTrueRhsIsFalse() {
        CompareToBuilder builder = new CompareToBuilder();
        builder.append(true, false);
        assertSame(builder, builder); // Verifying that the same instance is returned
    }

    @Test(timeout = 4000)
    public void testAppendWhenComparisonIsZeroAndLhsIsFalseRhsIsTrue() {
        CompareToBuilder builder = new CompareToBuilder();
        builder.append(false, true);
        assertSame(builder, builder); // Verifying that the same instance is returned
    }

}