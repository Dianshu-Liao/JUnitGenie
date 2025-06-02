package com.fasterxml.jackson.databind.util;
import com.fasterxml.jackson.databind.util.NameTransformer;
import org.junit.Test;
import static org.junit.Assert.assertSame;

public class util_NameTransformer_simpleTransformer_String_String_cfg_path_23_Test {

    @Test(timeout = 4000)
    public void testSimpleTransformerWithPrefixOnly() {
        String prefix = "Pre_";
        String suffix = null;
        
        NameTransformer transformer = NameTransformer.simpleTransformer(prefix, suffix);
        
        String transformed = transformer.transform("TestName");
        String reversed = transformer.reverse(transformed);
        
        assertSame("Pre_TestName", transformed);
        assertSame("TestName", reversed);
    }

    @Test(timeout = 4000)
    public void testSimpleTransformerWithSuffixOnly() {
        String prefix = null;
        String suffix = "_Post";
        
        NameTransformer transformer = NameTransformer.simpleTransformer(prefix, suffix);
        
        String transformed = transformer.transform("TestName");
        String reversed = transformer.reverse(transformed);
        
        assertSame("TestName_Post", transformed);
        assertSame("TestName", reversed);
    }

    @Test(timeout = 4000)
    public void testSimpleTransformerWithPrefixAndSuffix() {
        String prefix = "Pre_";
        String suffix = "_Post";
        
        NameTransformer transformer = NameTransformer.simpleTransformer(prefix, suffix);
        
        String transformed = transformer.transform("TestName");
        String reversed = transformer.reverse(transformed);
        
        assertSame("Pre_TestName_Post", transformed);
        assertSame("TestName", reversed);
    }

    @Test(timeout = 4000)
    public void testSimpleTransformerWithEmptyPrefixAndSuffix() {
        String prefix = "";
        String suffix = "";
        
        NameTransformer transformer = NameTransformer.simpleTransformer(prefix, suffix);
        
        assertSame(NameTransformer.NOP, transformer);
    }

    @Test(timeout = 4000)
    public void testSimpleTransformerWithNullPrefixAndSuffix() {
        String prefix = null;
        String suffix = null;

        NameTransformer transformer = NameTransformer.simpleTransformer(prefix, suffix);
        
        assertSame(NameTransformer.NOP, transformer);
    }

}