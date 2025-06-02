package org.apache.commons.lang3.builder;
import org.apache.commons.lang3.builder.CompareToBuilder;
import static org.junit.Assert.assertEquals;
import org.junit.Before;
import org.junit.Test;

public class builder_CompareToBuilder_append_byte_byte_cfg_path_1_Test {
    private CompareToBuilder compareToBuilder;

    @Before
    public void setUp() {
        compareToBuilder = new CompareToBuilder();
    }

    @Test(timeout = 4000)
    public void testAppendWithEqualBytes() {
        CompareToBuilder result = compareToBuilder.append((byte) 1, (byte) 1);
        assertEquals(compareToBuilder, result);
    }

    @Test(timeout = 4000)
    public void testAppendWithLessThan() {
        CompareToBuilder result = compareToBuilder.append((byte) 1, (byte) 2);
        assertEquals(compareToBuilder, result);
    }

    @Test(timeout = 4000)
    public void testAppendWithGreaterThan() {
        CompareToBuilder result = compareToBuilder.append((byte) 2, (byte) 1);
        assertEquals(compareToBuilder, result);
    }

}