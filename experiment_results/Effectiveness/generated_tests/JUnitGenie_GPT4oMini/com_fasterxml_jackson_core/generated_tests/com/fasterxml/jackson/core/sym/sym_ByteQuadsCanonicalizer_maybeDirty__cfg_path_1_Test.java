package com.fasterxml.jackson.core.sym;
import com.fasterxml.jackson.core.sym.ByteQuadsCanonicalizer;
import org.junit.Test;
import static org.junit.Assert.assertFalse;

public class sym_ByteQuadsCanonicalizer_maybeDirty__cfg_path_1_Test {

    @Test(timeout = 4000)
    public void testMaybeDirtyWhenHashSharedIsFalse() {
        try {
            // Using reflection to access the private constructor
            ByteQuadsCanonicalizer instance = (ByteQuadsCanonicalizer) 
                ByteQuadsCanonicalizer.class.getDeclaredConstructor(int.class, int.class)
                .newInstance(1, 1);
            
            // Accessing the protected field _hashShared using reflection
            java.lang.reflect.Field field = ByteQuadsCanonicalizer.class.getDeclaredField("_hashShared");
            field.setAccessible(true);
            field.setBoolean(instance, false); // Set _hashShared to false
            
            // Call the method and assert the expected result
            boolean result = instance.maybeDirty();
            assertFalse(result);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test(timeout = 4000)
    public void testMaybeDirtyWhenHashSharedIsTrue() {
        try {
            // Using reflection to access the private constructor
            ByteQuadsCanonicalizer instance = (ByteQuadsCanonicalizer) 
                ByteQuadsCanonicalizer.class.getDeclaredConstructor(int.class, int.class)
                .newInstance(1, 1);
            
            // Accessing the protected field _hashShared using reflection
            java.lang.reflect.Field field = ByteQuadsCanonicalizer.class.getDeclaredField("_hashShared");
            field.setAccessible(true);
            field.setBoolean(instance, true); // Set _hashShared to true
            
            // Call the method and assert the expected result
            boolean result = instance.maybeDirty();
            assertFalse(result); // Since _hashShared is true, we expect maybeDirty to return false
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}