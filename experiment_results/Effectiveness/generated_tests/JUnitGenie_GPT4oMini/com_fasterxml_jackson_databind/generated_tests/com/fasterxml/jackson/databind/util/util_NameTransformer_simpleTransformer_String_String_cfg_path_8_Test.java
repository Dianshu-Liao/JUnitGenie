package com.fasterxml.jackson.databind.util;
import com.fasterxml.jackson.databind.util.NameTransformer;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class util_NameTransformer_simpleTransformer_String_String_cfg_path_8_Test {

    @Test(timeout = 4000)
    public void testSimpleTransformerWithPrefixAndSuffix() {
        String prefix = "Pre-";
        String suffix = "-Suf";
        NameTransformer transformer = NameTransformer.simpleTransformer(prefix, suffix);
        
        String transformed = transformer.transform("Name");
        assertEquals("Pre-Name-Suf", transformed);
        
        String reversed = transformer.reverse(transformed);
        assertEquals("Name", reversed);
    }

    @Test(timeout = 4000)
    public void testSimpleTransformerWithOnlyPrefix() {
        String prefix = "Pre-";
        String suffix = null;
        NameTransformer transformer = NameTransformer.simpleTransformer(prefix, suffix);
        
        String transformed = transformer.transform("Name");
        assertEquals("Pre-Name", transformed);
        
        String reversed = transformer.reverse(transformed);
        assertEquals("Name", reversed);
    }

    @Test(timeout = 4000)
    public void testSimpleTransformerWithOnlySuffix() {
        String prefix = null;
        String suffix = "-Suf";
        NameTransformer transformer = NameTransformer.simpleTransformer(prefix, suffix);
        
        String transformed = transformer.transform("Name");
        assertEquals("Name-Suf", transformed);
        
        String reversed = transformer.reverse(transformed);
        assertEquals("Name", reversed);
    }

    @Test(timeout = 4000)
    public void testSimpleTransformerWithNullPrefixAndSuffix() {
        String prefix = null;
        String suffix = null;
        NameTransformer transformer = NameTransformer.simpleTransformer(prefix, suffix);
        
        assertEquals(NameTransformer.NOP, transformer);
    }

    @Test(timeout = 4000)
    public void testReverseWithInvalidTransformedString() {
        String prefix = "Pre-";
        String suffix = "-Suf";
        NameTransformer transformer = NameTransformer.simpleTransformer(prefix, suffix);
        
        String reversed = transformer.reverse("Invalid-Name");
        assertEquals(null, reversed);
    }

}