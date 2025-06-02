package org.apache.commons.lang3.builder;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.junit.Test;
import static org.junit.Assert.assertSame;

public class builder_EqualsBuilder_append_boolean_boolean_cfg_path_2_Test {

    @Test(timeout = 4000)
    public void testAppendWhenIsEqualsIsTrueAndLhsIsEqualToRhs() {
        EqualsBuilder equalsBuilder = new EqualsBuilder();
        equalsBuilder.append(true, true);
        assertSame(equalsBuilder, equalsBuilder);
    }

    @Test(timeout = 4000)
    public void testAppendWhenIsEqualsIsTrueAndLhsIsNotEqualToRhs() {
        EqualsBuilder equalsBuilder = new EqualsBuilder();
        equalsBuilder.append(true, false);
        assertSame(equalsBuilder, equalsBuilder);
    }

    @Test(timeout = 4000)
    public void testAppendWhenIsEqualsIsFalse() {
        EqualsBuilder equalsBuilder = new EqualsBuilder();
        equalsBuilder.append(false, true);
        assertSame(equalsBuilder, equalsBuilder);
    }

}