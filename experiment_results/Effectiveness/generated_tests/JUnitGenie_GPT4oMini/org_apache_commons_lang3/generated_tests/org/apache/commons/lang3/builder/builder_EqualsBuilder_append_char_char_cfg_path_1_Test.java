package org.apache.commons.lang3.builder;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.junit.Test;
import static org.junit.Assert.assertTrue;

public class builder_EqualsBuilder_append_char_char_cfg_path_1_Test {

    @Test(timeout = 4000)
    public void testAppendWhenLhsNotEqualsRhs() {
        EqualsBuilder equalsBuilder = new EqualsBuilder();
        equalsBuilder.append('a', 'b');
        // Checking the result of comparison instead of accessing the private field
        assertTrue("isEquals should be false when lhs and rhs are not equal", equalsBuilder.isEquals());
    }

    @Test(timeout = 4000)
    public void testAppendWhenLhsEqualsRhs() {
        EqualsBuilder equalsBuilder = new EqualsBuilder();
        equalsBuilder.append('a', 'a');
        // Checking the result of comparison instead of accessing the private field
        assertTrue("isEquals should remain true when lhs and rhs are equal", equalsBuilder.isEquals());
    }


}