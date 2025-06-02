package com.fasterxml.jackson.databind.util;
import com.fasterxml.jackson.databind.util.NameTransformer;
import org.junit.Test;
import static org.junit.Assert.assertNotNull;

public class util_NameTransformer_simpleTransformer_String_String_cfg_path_32_Test {

    @Test(timeout = 4000)
    public void testSimpleTransformer_WithBothPrefixAndSuffix() {
        String prefix = "Pre-";
        String suffix = "-Suff";
        NameTransformer transformer = NameTransformer.simpleTransformer(prefix, suffix);
        assertNotNull(transformer);
    }

    @Test(timeout = 4000)
    public void testSimpleTransformer_WithOnlyPrefix() {
        String prefix = "Pre-";
        String suffix = null; // testing with null suffix
        NameTransformer transformer = NameTransformer.simpleTransformer(prefix, suffix);
        assertNotNull(transformer);
    }

    @Test(timeout = 4000)
    public void testSimpleTransformer_WithOnlySuffix() {
        String prefix = null; // testing with null prefix
        String suffix = "-Suff";
        NameTransformer transformer = NameTransformer.simpleTransformer(prefix, suffix);
        assertNotNull(transformer);
    }

    @Test(timeout = 4000)
    public void testSimpleTransformer_WithEmptyPrefixAndSuffix() {
        String prefix = ""; // testing with empty string as prefix
        String suffix = ""; // testing with empty string as suffix
        NameTransformer transformer = NameTransformer.simpleTransformer(prefix, suffix);
        assertNotNull(transformer);
    }

    @Test(timeout = 4000)
    public void testSimpleTransformer_WithNullPrefixAndSuffix() {
        String prefix = null; // testing with null prefix
        String suffix = null; // testing with null suffix
        NameTransformer transformer = NameTransformer.simpleTransformer(prefix, suffix);
        assertNotNull(transformer);
    }

}