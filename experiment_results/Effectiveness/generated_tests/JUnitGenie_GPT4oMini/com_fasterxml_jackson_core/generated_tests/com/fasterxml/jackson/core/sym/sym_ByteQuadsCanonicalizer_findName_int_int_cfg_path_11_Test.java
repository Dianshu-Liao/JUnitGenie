package com.fasterxml.jackson.core.sym;
import com.fasterxml.jackson.core.sym.ByteQuadsCanonicalizer;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class sym_ByteQuadsCanonicalizer_findName_int_int_cfg_path_11_Test {

    @Test(timeout = 4000)
    public void testFindName() {
        try {
            // Create an instance of ByteQuadsCanonicalizer using reflection
            java.lang.reflect.Constructor<ByteQuadsCanonicalizer> constructor = 
                ByteQuadsCanonicalizer.class.getDeclaredConstructor(int.class, int.class);
            constructor.setAccessible(true); // Make the constructor accessible
            ByteQuadsCanonicalizer instance = constructor.newInstance(0, 0);

            // Set up the _hashArea and _names fields using reflection
            int[] hashArea = new int[] {1, 2, 0, 2}; // Example values
            String[] names = new String[] {"Name1", "Name2"};
            java.lang.reflect.Field hashAreaField = ByteQuadsCanonicalizer.class.getDeclaredField("_hashArea");
            hashAreaField.setAccessible(true);
            hashAreaField.set(instance, hashArea);

            java.lang.reflect.Field namesField = ByteQuadsCanonicalizer.class.getDeclaredField("_names");
            namesField.setAccessible(true);
            namesField.set(instance, names);

            // Call the method under test
            String result = instance.findName(1, 2);

            // Verify the result
            assertEquals("Name1", result);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}