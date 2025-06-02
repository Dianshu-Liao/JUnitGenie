package com.fasterxml.jackson.databind.introspect;
import com.fasterxml.jackson.databind.introspect.ClassIntrospector;
import com.fasterxml.jackson.databind.introspect.SimpleMixInResolver;
import org.junit.Test;
import static org.junit.Assert.assertNotNull;
import java.util.HashMap;
import java.util.Map;

public class introspect_SimpleMixInResolver_copy__cfg_path_4_Test {

    @Test(timeout = 4000)
    public void testCopyWithNullOverridesAndLocalMixIns() {
        SimpleMixInResolver resolver = new SimpleMixInResolver(null);
        SimpleMixInResolver copiedResolver = resolver.copy();
        assertNotNull(copiedResolver);
    }


    @Test(timeout = 4000)
    public void testCopyWithOverridesNotNullAndLocalMixInsNull() {
        ClassIntrospector.MixInResolver overrides = new ClassIntrospector.MixInResolver() {
            @Override
            public SimpleMixInResolver copy() {
                return new SimpleMixInResolver(this, null); // Implementing the copy method
            }

            @Override
            public Class<?> findMixInClassFor(Class<?> cls) {
                return null; // Implementing the required method
            }
        };
        SimpleMixInResolver resolver = new SimpleMixInResolver(overrides, null);
        SimpleMixInResolver copiedResolver = resolver.copy();
        assertNotNull(copiedResolver);
    }



}
