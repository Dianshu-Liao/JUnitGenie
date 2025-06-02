package com.fasterxml.jackson.databind.util;
import org.junit.Test;
import static org.junit.Assert.*;
import com.fasterxml.jackson.databind.util.NameTransformer;

public class util_NameTransformer_simpleTransformer_String_String_cfg_path_15_Test {

    @Test(timeout = 4000)
    public void testSimpleTransformer_WithNonEmptyPrefixAndSuffix() {
        NameTransformer transformer = NameTransformer.simpleTransformer("pre-", "-suf");
        String transformed = transformer.transform("name");
        assertEquals("pre-name-suf", transformed);
        
        String reversed = transformer.reverse(transformed);
        assertEquals("name", reversed);
    }

    @Test(timeout = 4000)
    public void testSimpleTransformer_WithNonEmptyPrefix() {
        NameTransformer transformer = NameTransformer.simpleTransformer("pre-", null);
        String transformed = transformer.transform("name");
        assertEquals("pre-name", transformed);

        String reversed = transformer.reverse(transformed);
        assertEquals("name", reversed);
    }

    @Test(timeout = 4000)
    public void testSimpleTransformer_WithNonEmptySuffix() {
        NameTransformer transformer = NameTransformer.simpleTransformer(null, "-suf");
        String transformed = transformer.transform("name");
        assertEquals("name-suf", transformed);

        String reversed = transformer.reverse(transformed);
        assertEquals("name", reversed);
    }

    @Test(timeout = 4000)
    public void testSimpleTransformer_WithEmptyPrefixAndSuffix() {
        NameTransformer transformer = NameTransformer.simpleTransformer("", "");
        String transformed = transformer.transform("name");
        assertEquals("name", transformed);
        
        String reversed = transformer.reverse(transformed);
        assertEquals("name", reversed);
    }
    
    @Test(timeout = 4000)
    public void testSimpleTransformer_WithNullPrefixAndSuffix() {
        NameTransformer transformer = NameTransformer.simpleTransformer(null, null);
        String transformed = transformer.transform("name");
        assertEquals("name", transformed);
        
        String reversed = transformer.reverse(transformed);
        assertEquals("name", reversed);
    }

    @Test(timeout = 4000)
    public void testSimpleTransformer_ReverseWithIncorrectInput() {
        NameTransformer transformer = NameTransformer.simpleTransformer("pre-", "-suf");
        String transformed = "randomName";
        
        String reversed = transformer.reverse(transformed);
        assertNull(reversed);
    }

    @Test(timeout = 4000)
    public void testSimpleTransformer_ReverseWithCorrectSuffixOnly() {
        NameTransformer transformer = NameTransformer.simpleTransformer(null, "-suf");
        String transformed = "name-suf";
        
        String reversed = transformer.reverse(transformed);
        assertEquals("name", reversed);
    }

    @Test(timeout = 4000)
    public void testSimpleTransformer_ReverseWithCorrectPrefixOnly() {
        NameTransformer transformer = NameTransformer.simpleTransformer("pre-", null);
        String transformed = "pre-name";
        
        String reversed = transformer.reverse(transformed);
        assertEquals("name", reversed);
    }
    
    @Test(timeout = 4000)
    public void testSimpleTransformer_ReverseWithSuffixOnly() {
        NameTransformer transformer = NameTransformer.simpleTransformer(null, "-suf");
        String transformed = "name-suf";
        
        assertEquals("name", transformer.reverse(transformed));
        assertNull(transformer.reverse("name"));
    }

    @Test(timeout = 4000)
    public void testSimpleTransformer_ReverseWithPrefixOnly() {
        NameTransformer transformer = NameTransformer.simpleTransformer("pre-", null);
        String transformed = "pre-name";
        
        assertEquals("name", transformer.reverse(transformed));
        assertNull(transformer.reverse("name"));
    }

}