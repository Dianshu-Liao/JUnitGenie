package org.apache.commons.lang3.builder;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.junit.Test;
import static org.junit.Assert.assertSame;

public class builder_EqualsBuilder_append_boolean_boolean_cfg_path_3_Test {

    @Test(timeout = 4000)
    public void testAppendWhenIsEqualsTrue() {
        EqualsBuilder equalsBuilder = new EqualsBuilder();
        equalsBuilder.append(true, true);
        assertSame(equalsBuilder, equalsBuilder.append(true, true));
    }

    @Test(timeout = 4000)
    public void testAppendWhenIsEqualsFalse() {
        EqualsBuilder equalsBuilder = new EqualsBuilder();
        equalsBuilder.append(true, false);
        assertSame(equalsBuilder, equalsBuilder.append(true, false));
    }

}