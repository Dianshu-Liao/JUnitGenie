package com.fasterxml.jackson.databind.util;
import com.fasterxml.jackson.databind.util.NameTransformer;
import org.junit.Test;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertEquals;

public class util_NameTransformer_simpleTransformer_String_String_cfg_path_22_Test {

    @Test(timeout = 4000)
    public void testSimpleTransformerWithPrefixAndSuffix() {
        String prefix = "Pre-";
        String suffix = "-Suf";
        NameTransformer transformer = NameTransformer.simpleTransformer(prefix, suffix);
        assertNotNull(transformer);
        
        // Test transform method
        String transformed = transformer.transform("Name");
        assertNotNull(transformed);
        assertEquals("Pre-Name-Suf", transformed);
        
        // Test reverse method
        String reversed = transformer.reverse(transformed);
        assertNotNull(reversed);
        assertEquals("Name", reversed);
    }

    @Test(timeout = 4000)
    public void testSimpleTransformerWithOnlyPrefix() {
        String prefix = "Pre-";
        String suffix = null;
        NameTransformer transformer = NameTransformer.simpleTransformer(prefix, suffix);
        assertNotNull(transformer);
        
        // Test transform method
        String transformed = transformer.transform("Name");
        assertNotNull(transformed);
        assertEquals("Pre-Name", transformed);
        
        // Test reverse method
        String reversed = transformer.reverse(transformed);
        assertNotNull(reversed);
        assertEquals("Name", reversed);
    }

    @Test(timeout = 4000)
    public void testSimpleTransformerWithOnlySuffix() {
        String prefix = null;
        String suffix = "-Suf";
        NameTransformer transformer = NameTransformer.simpleTransformer(prefix, suffix);
        assertNotNull(transformer);
        
        // Test transform method
        String transformed = transformer.transform("Name");
        assertNotNull(transformed);
        assertEquals("Name-Suf", transformed);
        
        // Test reverse method
        String reversed = transformer.reverse(transformed);
        assertNotNull(reversed);
        assertEquals("Name", reversed);
    }

    @Test(timeout = 4000)
    public void testSimpleTransformerWithNoPrefixAndSuffix() {
        String prefix = null;
        String suffix = null;
        NameTransformer transformer = NameTransformer.simpleTransformer(prefix, suffix);
        assertNotNull(transformer);
        assertEquals(NameTransformer.NOP, transformer);
    }


}