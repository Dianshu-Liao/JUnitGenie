package com.fasterxml.jackson.databind.util;
import static org.junit.Assert.assertNotNull;
import org.junit.Test;
import com.fasterxml.jackson.databind.util.NameTransformer;

public class util_NameTransformer_simpleTransformer_String_String_cfg_path_4_Test {

    @Test(timeout = 4000)
    public void testSimpleTransformerWithPrefixAndSuffix() {
        String prefix = "Mr. ";
        String suffix = " Jr.";
        
        NameTransformer transformer = NameTransformer.simpleTransformer(prefix, suffix);
        
        assertNotNull("Transformer should not be null", transformer);
        String transformed = transformer.transform("John");
        String reversed = transformer.reverse(transformed);

        assertNotNull("Transformed name should not be null", transformed);
        assertNotNull("Reversed name should not be null", reversed);
    }

    @Test(timeout = 4000)
    public void testSimpleTransformerWithOnlyPrefix() {
        String prefix = "Mr. ";
        String suffix = null;

        NameTransformer transformer = NameTransformer.simpleTransformer(prefix, suffix);
        
        assertNotNull("Transformer should not be null", transformer);
        String transformed = transformer.transform("John");
        String reversed = transformer.reverse(transformed);

        assertNotNull("Transformed name should not be null", transformed);
        assertNotNull("Reversed name should not be null", reversed);
    }

    @Test(timeout = 4000)
    public void testSimpleTransformerWithOnlySuffix() {
        String prefix = null;
        String suffix = " Jr.";

        NameTransformer transformer = NameTransformer.simpleTransformer(prefix, suffix);
        
        assertNotNull("Transformer should not be null", transformer);
        String transformed = transformer.transform("John");
        String reversed = transformer.reverse(transformed);

        assertNotNull("Transformed name should not be null", transformed);
        assertNotNull("Reversed name should not be null", reversed);
    }

    @Test(timeout = 4000)
    public void testSimpleTransformerWithNeither() {
        String prefix = null;
        String suffix = null;

        NameTransformer transformer = NameTransformer.simpleTransformer(prefix, suffix);

        assertNotNull("Transformer should be the NOP variant", transformer);
    }
    
    @Test(timeout = 4000)
    public void testTransformerReverseWithInvalidInput() {
        String prefix = "Mr. ";
        String suffix = " Jr.";
        
        NameTransformer transformer = NameTransformer.simpleTransformer(prefix, suffix);
        
        String result = transformer.reverse("InvalidName");

        assertNotNull("Reversing invalid name should return null", result);
    }

}