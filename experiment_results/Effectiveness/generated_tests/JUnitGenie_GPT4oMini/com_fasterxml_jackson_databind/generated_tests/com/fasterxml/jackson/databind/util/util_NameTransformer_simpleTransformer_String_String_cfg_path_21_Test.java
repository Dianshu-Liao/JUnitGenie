package com.fasterxml.jackson.databind.util;
import com.fasterxml.jackson.databind.util.NameTransformer;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class util_NameTransformer_simpleTransformer_String_String_cfg_path_21_Test {

    @Test(timeout = 4000)
    public void testSimpleTransformerWithPrefixOnly() {
        String prefix = "Pre_";
        String suffix = null;
        NameTransformer transformer = NameTransformer.simpleTransformer(prefix, suffix);
        
        String transformed = transformer.transform("Name");
        assertEquals("Pre_Name", transformed);
        
        String reversed = transformer.reverse(transformed);
        assertEquals("Name", reversed);
    }

    @Test(timeout = 4000)
    public void testSimpleTransformerWithSuffixOnly() {
        String prefix = null;
        String suffix = "_Suf";
        NameTransformer transformer = NameTransformer.simpleTransformer(prefix, suffix);
        
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
    public void testSimpleTransformerWithNullPrefixAndSuffix() {
        String prefix = null;
        String suffix = null;
        NameTransformer transformer = NameTransformer.simpleTransformer(prefix, suffix);
        
        assertEquals(NameTransformer.NOP, transformer);
    }

}