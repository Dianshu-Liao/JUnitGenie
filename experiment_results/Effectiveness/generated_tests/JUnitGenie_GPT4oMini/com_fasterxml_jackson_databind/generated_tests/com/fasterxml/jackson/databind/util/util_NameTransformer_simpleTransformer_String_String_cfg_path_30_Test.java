package com.fasterxml.jackson.databind.util;
import com.fasterxml.jackson.databind.util.NameTransformer;
import org.junit.Test;
import static org.junit.Assert.assertNotNull;

public class util_NameTransformer_simpleTransformer_String_String_cfg_path_30_Test {

    @Test(timeout = 4000)
    public void testSimpleTransformerWithPrefixAndSuffix() {
        String prefix = "Pre-";
        String suffix = "-Suf";
        NameTransformer transformer = NameTransformer.simpleTransformer(prefix, suffix);
        assertNotNull(transformer);
        
        String transformed = transformer.transform("Name");
        String reversed = transformer.reverse(transformed);
        
        assertNotNull(transformed);
        assertNotNull(reversed);
    }

}