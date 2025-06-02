package com.fasterxml.jackson.databind.util;
import com.fasterxml.jackson.databind.util.NameTransformer;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class util_NameTransformer_simpleTransformer_String_String_cfg_path_3_Test {

    @Test(timeout = 4000)
    public void testSimpleTransformerWithNoPrefixAndNoSuffix() {
        NameTransformer transformer = NameTransformer.simpleTransformer(null, null);
        assertEquals(NameTransformer.NOP, transformer);
    }

    @Test(timeout = 4000)
    public void testSimpleTransformerWithOnlyPrefix() {
        String prefix = "Pre_";
        NameTransformer transformer = NameTransformer.simpleTransformer(prefix, null);
        String transformed = transformer.transform("Name");
        assertEquals("Pre_Name", transformed);
        String reversed = transformer.reverse(transformed);
        assertEquals("Name", reversed);
    }

    @Test(timeout = 4000)
    public void testSimpleTransformerWithOnlySuffix() {
        String suffix = "_Suf";
        NameTransformer transformer = NameTransformer.simpleTransformer(null, suffix);
        String transformed = transformer.transform("Name");
        assertEquals("Name_Suf", transformed);
        String reversed = transformer.reverse(transformed);
        assertEquals("Name", reversed);
    }

    @Test(timeout = 4000)
    public void testSimpleTransformerWithPrefixAndSuffix() {
        String prefix = "Pre_";
        String suffix = "_Suf";
        NameTransformer transformer = NameTransformer.simpleTransformer(prefix, suffix);
        String transformed = transformer.transform("Name");
        assertEquals("Pre_Name_Suf", transformed);
        String reversed = transformer.reverse(transformed);
        assertEquals("Name", reversed);
    }

    @Test(timeout = 4000)
    public void testSimpleTransformerWithInvalidReverse() {
        String prefix = "Pre_";
        String suffix = "_Suf";
        NameTransformer transformer = NameTransformer.simpleTransformer(prefix, suffix);
        String transformed = transformer.transform("Name");
        String invalidTransformed = "Invalid_Name_Suf";
        String reversed = transformer.reverse(invalidTransformed);
        assertEquals(null, reversed);
    }

}