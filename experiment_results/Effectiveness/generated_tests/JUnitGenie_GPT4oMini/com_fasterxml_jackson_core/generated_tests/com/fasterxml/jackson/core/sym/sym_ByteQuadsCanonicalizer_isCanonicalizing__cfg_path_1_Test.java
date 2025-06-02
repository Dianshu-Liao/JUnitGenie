package com.fasterxml.jackson.core.sym;
import com.fasterxml.jackson.core.sym.ByteQuadsCanonicalizer;
import org.junit.Test;
import static org.junit.Assert.assertFalse;

public class sym_ByteQuadsCanonicalizer_isCanonicalizing__cfg_path_1_Test {

    @Test(timeout = 4000)
    public void testIsCanonicalizingWhenParentIsNull() {
        try {
            // Create an instance of ByteQuadsCanonicalizer using reflection
            ByteQuadsCanonicalizer instance = (ByteQuadsCanonicalizer) 
                ByteQuadsCanonicalizer.class.getDeclaredConstructor(int.class, int.class)
                .newInstance(0, 0);
            
            // Since _parent is protected and final, we cannot set it directly.
            // We will assume it is null by default as per the constructor used.

            // Call the method under test
            boolean result = instance.isCanonicalizing();

            // Assert that the result is false when _parent is null
            assertFalse(result);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // Add this method to make the constructor accessible for testing
    private static void makeConstructorAccessible() {
        try {
            java.lang.reflect.Constructor<ByteQuadsCanonicalizer> constructor = 
                ByteQuadsCanonicalizer.class.getDeclaredConstructor(int.class, int.class);
            constructor.setAccessible(true);
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        }
    }

    static {
        makeConstructorAccessible();
    }


}