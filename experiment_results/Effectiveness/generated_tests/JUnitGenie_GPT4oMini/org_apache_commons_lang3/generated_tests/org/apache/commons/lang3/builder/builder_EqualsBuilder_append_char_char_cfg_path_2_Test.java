package org.apache.commons.lang3.builder;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class builder_EqualsBuilder_append_char_char_cfg_path_2_Test {

    @Test(timeout = 4000)
    public void testAppendWhenIsEqualsTrueAndCharsEqual() {
        EqualsBuilder builder = new EqualsBuilder();
        builder.append('a', 'a');
        assertEquals(true, builder.isEquals()); // Use the method to get the value
    }

    @Test(timeout = 4000)
    public void testAppendWhenIsEqualsTrueAndCharsNotEqual() {
        EqualsBuilder builder = new EqualsBuilder();
        builder.append('a', 'b');
        assertEquals(false, builder.isEquals()); // Use the method to get the value
    }
    
    @Test(timeout = 4000)
    public void testAppendWhenIsEqualsFalse() {
        EqualsBuilder builder = new EqualsBuilder();
        builder.append('a', 'b'); 
        assertEquals(false, builder.isEquals()); // Check the value after appending
    }

    @Test(timeout = 4000)
    public void testAppendWhenIsEqualsTrueWithDifferentChars() {
        EqualsBuilder builder = new EqualsBuilder();
        builder.append('c', 'd');
        assertEquals(false, builder.isEquals()); // Check the value after appending
    }


}