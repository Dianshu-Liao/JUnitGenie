package org.apache.commons.lang3.builder;
import org.apache.commons.lang3.builder.CompareToBuilder;
import org.junit.Test;
import static org.junit.Assert.*;

public class builder_CompareToBuilder_append_boolean_boolean_cfg_path_3_Test {

    @Test(timeout = 4000)
    public void testAppend_DifferentBooleanValues() {
        CompareToBuilder builder = new CompareToBuilder();
        builder.append(true, false);
        assertEquals(-1, builder.toComparison());
    }

    @Test(timeout = 4000)
    public void testAppend_SameBooleanValuesTrue() {
        CompareToBuilder builder = new CompareToBuilder();
        builder.append(true, true);
        assertEquals(0, builder.toComparison());
    }

    @Test(timeout = 4000)
    public void testAppend_SameBooleanValuesFalse() {
        CompareToBuilder builder = new CompareToBuilder();
        builder.append(false, false);
        assertEquals(0, builder.toComparison());
    }


}