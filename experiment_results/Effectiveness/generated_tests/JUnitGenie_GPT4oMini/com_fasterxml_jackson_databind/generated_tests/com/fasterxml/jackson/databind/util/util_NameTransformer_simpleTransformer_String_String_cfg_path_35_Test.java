package com.fasterxml.jackson.databind.util;
import com.fasterxml.jackson.databind.util.NameTransformer;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class util_NameTransformer_simpleTransformer_String_String_cfg_path_35_Test {

    @Test(timeout = 4000)
    public void testSimpleTransformerWithNullPrefixAndSuffix() {
        NameTransformer transformer = NameTransformer.simpleTransformer(null, null);
        assertEquals(NameTransformer.NOP, transformer);
    }

    @Test(timeout = 4000)
    public void testSimpleTransformerWithNullPrefix() {
        NameTransformer transformer = NameTransformer.simpleTransformer(null, "suffix");
        assertEquals(NameTransformer.NOP, transformer);
    }

    @Test(timeout = 4000)
    public void testSimpleTransformerWithNullSuffix() {
        NameTransformer transformer = NameTransformer.simpleTransformer("prefix", null);
        assertEquals(NameTransformer.NOP, transformer);
    }

    @Test(timeout = 4000)
    public void testSimpleTransformerWithEmptyPrefixAndSuffix() {
        NameTransformer transformer = NameTransformer.simpleTransformer("", "");
        assertEquals(NameTransformer.NOP, transformer);
    }

    @Test(timeout = 4000)
    public void testSimpleTransformerWithOnlyPrefix() {
        NameTransformer transformer = NameTransformer.simpleTransformer("prefix", "");
        String transformed = transformer.transform("name");
        assertEquals("prefixname", transformed);
        String reversed = transformer.reverse(transformed);
        assertEquals("name", reversed);
    }

    @Test(timeout = 4000)
    public void testSimpleTransformerWithOnlySuffix() {
        NameTransformer transformer = NameTransformer.simpleTransformer("", "suffix");
        String transformed = transformer.transform("name");
        assertEquals("namesuffix", transformed);
        String reversed = transformer.reverse(transformed);
        assertEquals("name", reversed);
    }

    @Test(timeout = 4000)
    public void testSimpleTransformerWithBothPrefixAndSuffix() {
        NameTransformer transformer = NameTransformer.simpleTransformer("pre", "suf");
        String transformed = transformer.transform("name");
        assertEquals("prename" + "suf", transformed);
        String reversed = transformer.reverse(transformed);
        assertEquals("name", reversed);
    }

}