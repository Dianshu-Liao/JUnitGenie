package com.fasterxml.jackson.databind.deser.impl;
import com.fasterxml.jackson.databind.deser.impl.BeanPropertyMap;
import com.fasterxml.jackson.databind.util.NameTransformer;
import org.junit.Test;
import static org.junit.Assert.assertSame;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Locale;

public class deser_impl_BeanPropertyMap_renameAll_NameTransformer_cfg_path_4_Test {

    private static class NopTransformer extends NameTransformer {
        @Override
        public String reverse(String name) {
            return name; // No operation, returns the name as is
        }

        @Override
        public String transform(String name) {
            return name; // No operation, returns the name as is
        }
    }

    @Test(timeout = 4000)
    public void testRenameAllWithNopTransformer() {
        // Arrange
        BeanPropertyMap beanPropertyMap = new BeanPropertyMap(true, new ArrayList<>(), new HashMap<>(), Locale.getDefault());
        NameTransformer transformer = NameTransformer.NOP; // Using the NOP transformer

        // Act
        BeanPropertyMap result = beanPropertyMap.renameAll(transformer);

        // Assert
        assertSame(beanPropertyMap, result); // Should return the same instance
    }

    @Test(timeout = 4000)
    public void testRenameAllWithNullTransformer() {
        // Arrange
        BeanPropertyMap beanPropertyMap = new BeanPropertyMap(true, new ArrayList<>(), new HashMap<>(), Locale.getDefault());
        NameTransformer transformer = null; // Null transformer

        // Act
        BeanPropertyMap result = beanPropertyMap.renameAll(transformer);

        // Assert
        assertSame(beanPropertyMap, result); // Should return the same instance
    }


}