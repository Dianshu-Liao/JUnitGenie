package com.fasterxml.jackson.databind.util;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertEquals;
import org.junit.Test;
import com.fasterxml.jackson.databind.util.NameTransformer;

public class util_NameTransformer_simpleTransformer_String_String_cfg_path_25_Test {

    @Test(timeout = 4000)
    public void testSimpleTransformerWithPrefixOnly() {
        String prefix = "pre_";
        String suffix = null; // Testing with no suffix
        
        NameTransformer transformer = NameTransformer.simpleTransformer(prefix, suffix);
        
        assertNotNull(transformer);
        String transformed = transformer.transform("name");
        String reversed = transformer.reverse(transformed);
        
        // Verifying the transformation and reverse process
        assertNotNull(transformed);
        assertEquals("pre_name", transformed);
        assertEquals("name", reversed);
    }

    @Test(timeout = 4000)
    public void testSimpleTransformerWithSuffixOnly() {
        String prefix = null; // Testing with no prefix
        String suffix = "_suf";
        
        NameTransformer transformer = NameTransformer.simpleTransformer(prefix, suffix);

        assertNotNull(transformer);
        String transformed = transformer.transform("name");
        String reversed = transformer.reverse(transformed);
        
        // Verifying the transformation and reverse process
        assertNotNull(transformed);
        assertEquals("name_suf", transformed);
        assertEquals("name", reversed);
    }

    @Test(timeout = 4000)
    public void testSimpleTransformerWithPrefixAndSuffix() {
        String prefix = "pre_";
        String suffix = "_suf";
        
        NameTransformer transformer = NameTransformer.simpleTransformer(prefix, suffix);

        assertNotNull(transformer);
        String transformed = transformer.transform("name");
        String reversed = transformer.reverse(transformed);
        
        // Verifying the transformation and reverse process
        assertNotNull(transformed);
        assertEquals("pre_name_suf", transformed);
        assertEquals("name", reversed);
    }

    @Test(timeout = 4000)
    public void testSimpleTransformerWithEmptyPrefixAndSuffix() {
        String prefix = ""; // Empty prefix
        String suffix = ""; // Empty suffix
        
        NameTransformer transformer = NameTransformer.simpleTransformer(prefix, suffix);
        
        // Should return NOP when both prefix and suffix are empty
        assertNotNull(transformer);
        String transformed = transformer.transform("name");
        
        // Expecting no transformation
        assertEquals("name", transformed);
    }


}