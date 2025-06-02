package org.apache.commons.lang3.builder;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.junit.Test;
import static org.junit.Assert.assertTrue;

public class builder_EqualsBuilder_append_char_char_cfg_path_3_Test {

    @Test(timeout = 4000)
    public void testAppendWhenIsEqualsTrue() {
        EqualsBuilder equalsBuilder = new EqualsBuilder();
        equalsBuilder.append('a', 'a'); // Both characters are equal
        assertTrue(equalsBuilder.isEquals()); // Use the method isEquals() instead of accessing the field directly
    }

    @Test(timeout = 4000)
    public void testAppendWhenIsEqualsFalse() {
        EqualsBuilder equalsBuilder = new EqualsBuilder();
        equalsBuilder.append('a', 'b'); // Characters are not equal
        assertTrue(!equalsBuilder.isEquals()); // Use the method isEquals() instead of accessing the field directly
    }


}