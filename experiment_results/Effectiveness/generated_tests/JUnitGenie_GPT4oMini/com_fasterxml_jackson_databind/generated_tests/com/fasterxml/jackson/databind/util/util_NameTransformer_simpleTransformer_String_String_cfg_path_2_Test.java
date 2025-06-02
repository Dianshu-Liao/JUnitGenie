package com.fasterxml.jackson.databind.util;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertEquals;
import com.fasterxml.jackson.databind.util.NameTransformer;
import org.junit.Test;

public class util_NameTransformer_simpleTransformer_String_String_cfg_path_2_Test {

    @Test(timeout = 4000)
    public void testSimpleTransformer_withPrefixAndSuffix() {
        String prefix = "Pre_";
        String suffix = "_Suf";
        NameTransformer transformer = NameTransformer.simpleTransformer(prefix, suffix);
        assertNotNull(transformer);
        String transformed = transformer.transform("Name");
        String reversed = transformer.reverse(transformed);
        
        assertNotNull(transformed);
        assertNotNull(reversed);
        assertEquals("Name", reversed);
    }

    @Test(timeout = 4000)
    public void testSimpleTransformer_withOnlyPrefix() {
        String prefix = "Pre_";
        String suffix = null;
        NameTransformer transformer = NameTransformer.simpleTransformer(prefix, suffix);
        assertNotNull(transformer);
        String transformed = transformer.transform("Name");
        String reversed = transformer.reverse(transformed);
        
        assertNotNull(transformed);
        assertNotNull(reversed);
        assertEquals("Name", reversed);
    }

    @Test(timeout = 4000)
    public void testSimpleTransformer_withOnlySuffix() {
        String prefix = null;
        String suffix = "_Suf";
        NameTransformer transformer = NameTransformer.simpleTransformer(prefix, suffix);
        assertNotNull(transformer);
        String transformed = transformer.transform("Name");
        String reversed = transformer.reverse(transformed);
        
        assertNotNull(transformed);
        assertNotNull(reversed);
        assertEquals("Name", reversed);
    }

    @Test(timeout = 4000)
    public void testSimpleTransformer_withNullPrefixAndSuffix() {
        String prefix = null;
        String suffix = null;
        NameTransformer transformer = NameTransformer.simpleTransformer(prefix, suffix);
        assertNotNull(transformer);
        // Assert that transformer is NOP or a specific expected behavior if applicable.
    }


}