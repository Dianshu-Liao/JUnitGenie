package com.fasterxml.jackson.core.sym;
import com.fasterxml.jackson.core.sym.ByteQuadsCanonicalizer;
import org.junit.Test;
import static org.junit.Assert.assertTrue;

public class sym_ByteQuadsCanonicalizer_maybeDirty__cfg_path_2_Test {

    @Test(timeout = 4000)
    public void testMaybeDirtyWhenHashSharedIsFalse() {
        try {
            // Use reflection to access the protected field _hashShared
            // Create an instance of ByteQuadsCanonicalizer using the appropriate constructor
            ByteQuadsCanonicalizer instance = ByteQuadsCanonicalizer.createRoot(0); // Assuming createRoot is a static method to create an instance
            
            java.lang.reflect.Field field = ByteQuadsCanonicalizer.class.getDeclaredField("_hashShared");
            field.setAccessible(true);
            field.setBoolean(instance, false); // Set _hashShared to false
            
            boolean result = instance.maybeDirty();
            assertTrue(result); // Expecting true since _hashShared is false
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


}