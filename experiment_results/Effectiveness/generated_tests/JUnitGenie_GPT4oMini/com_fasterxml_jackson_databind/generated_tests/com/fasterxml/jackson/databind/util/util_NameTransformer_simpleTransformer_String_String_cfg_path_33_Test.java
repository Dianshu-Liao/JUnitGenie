package com.fasterxml.jackson.databind.util;
import com.fasterxml.jackson.databind.util.NameTransformer;
import org.junit.Test;
import static org.junit.Assert.assertNotNull;

public class util_NameTransformer_simpleTransformer_String_String_cfg_path_33_Test {

    @Test(timeout = 4000)
    public void testSimpleTransformerWithNoPrefixAndNoSuffix() {
        NameTransformer transformer = NameTransformer.simpleTransformer(null, null);
        assertNotNull(transformer);
    }

    @Test(timeout = 4000)
    public void testSimpleTransformerWithPrefixOnly() {
        NameTransformer transformer = NameTransformer.simpleTransformer("pre-", null);
        assertNotNull(transformer);
        String transformed = transformer.transform("name");
        String reversed = transformer.reverse(transformed);
        assertNotNull(transformed);
        assertNotNull(reversed);
    }

    @Test(timeout = 4000)
    public void testSimpleTransformerWithSuffixOnly() {
        NameTransformer transformer = NameTransformer.simpleTransformer(null, "-suf");
        assertNotNull(transformer);
        String transformed = transformer.transform("name");
        String reversed = transformer.reverse(transformed);
        assertNotNull(transformed);
        assertNotNull(reversed);
    }

    @Test(timeout = 4000)
    public void testSimpleTransformerWithPrefixAndSuffix() {
        NameTransformer transformer = NameTransformer.simpleTransformer("pre-", "-suf");
        assertNotNull(transformer);
        String transformed = transformer.transform("name");
        String reversed = transformer.reverse(transformed);
        assertNotNull(transformed);
        assertNotNull(reversed);
    }

}