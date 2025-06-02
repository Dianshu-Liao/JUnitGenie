package com.fasterxml.jackson.databind.util;
import com.fasterxml.jackson.databind.util.NameTransformer;
import org.junit.Test;
import static org.junit.Assert.assertNotNull;

public class util_NameTransformer_simpleTransformer_String_String_cfg_path_17_Test {

    @Test(timeout = 4000)
    public void testSimpleTransformer_withPrefixAndSuffix() {
        NameTransformer transformer = NameTransformer.simpleTransformer("pre-", "-suf");
        assertNotNull(transformer);

        // Test the transform method
        String transformed = transformer.transform("name");
        assertNotNull(transformed);
        assert transformed.equals("pre-name-suf");

        // Test the reverse method
        String reversed = transformer.reverse(transformed);
        assertNotNull(reversed);
        assert reversed.equals("name");
    }

    @Test(timeout = 4000)
    public void testSimpleTransformer_withPrefixOnly() {
        NameTransformer transformer = NameTransformer.simpleTransformer("pre-", null);
        assertNotNull(transformer);

        // Test the transform method
        String transformed = transformer.transform("name");
        assertNotNull(transformed);
        assert transformed.equals("pre-name");

        // Test the reverse method
        String reversed = transformer.reverse(transformed);
        assertNotNull(reversed);
        assert reversed.equals("name");
    }

    @Test(timeout = 4000)
    public void testSimpleTransformer_withSuffixOnly() {
        NameTransformer transformer = NameTransformer.simpleTransformer(null, "-suf");
        assertNotNull(transformer);

        // Test the transform method
        String transformed = transformer.transform("name");
        assertNotNull(transformed);
        assert transformed.equals("name-suf");

        // Test the reverse method
        String reversed = transformer.reverse(transformed);
        assertNotNull(reversed);
        assert reversed.equals("name");
    }

    @Test(timeout = 4000)
    public void testSimpleTransformer_withNoPrefixAndSuffix() {
        NameTransformer transformer = NameTransformer.simpleTransformer(null, null);
        assertNotNull(transformer);
        
        // Since NOP is returned when both prefix and suffix are null, 
        // there will be no transform() or reverse() behavior to test.
    }

}