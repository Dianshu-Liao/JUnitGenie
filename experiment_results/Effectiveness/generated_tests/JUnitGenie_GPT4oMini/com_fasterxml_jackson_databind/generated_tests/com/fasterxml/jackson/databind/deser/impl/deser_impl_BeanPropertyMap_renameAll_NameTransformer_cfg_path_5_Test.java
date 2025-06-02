package com.fasterxml.jackson.databind.deser.impl;
import com.fasterxml.jackson.databind.deser.impl.BeanPropertyMap;
import com.fasterxml.jackson.databind.util.NameTransformer;
import org.junit.Test;
import static org.junit.Assert.assertSame;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Locale;

public class deser_impl_BeanPropertyMap_renameAll_NameTransformer_cfg_path_5_Test {

    private static class TestNameTransformer extends NameTransformer {
        @Override
        public String reverse(String name) {
            return name; // Simple implementation for testing
        }

        @Override
        public String transform(String name) {
            return name; // Simple implementation for testing
        }
    }

    @Test(timeout = 4000)
    public void testRenameAllWithNullTransformer() {
        BeanPropertyMap beanPropertyMap = new BeanPropertyMap(true, new ArrayList<>(), new HashMap<>(), Locale.getDefault());
        BeanPropertyMap result = beanPropertyMap.renameAll(null);
        assertSame(beanPropertyMap, result);
    }

    @Test(timeout = 4000)
    public void testRenameAllWithNoOpTransformer() {
        BeanPropertyMap beanPropertyMap = new BeanPropertyMap(true, new ArrayList<>(), new HashMap<>(), Locale.getDefault());
        NameTransformer transformer = NameTransformer.NOP; // Assuming NOP is a valid static instance
        BeanPropertyMap result = beanPropertyMap.renameAll(transformer);
        assertSame(beanPropertyMap, result);
    }


}