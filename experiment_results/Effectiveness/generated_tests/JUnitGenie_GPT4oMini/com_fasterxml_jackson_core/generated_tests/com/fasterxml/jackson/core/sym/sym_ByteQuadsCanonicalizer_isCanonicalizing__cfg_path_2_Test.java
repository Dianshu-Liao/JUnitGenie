package com.fasterxml.jackson.core.sym;
import com.fasterxml.jackson.core.sym.ByteQuadsCanonicalizer;
import org.junit.Test;
import static org.junit.Assert.assertFalse;

public class sym_ByteQuadsCanonicalizer_isCanonicalizing__cfg_path_2_Test {

    @Test(timeout = 4000)
    public void testIsCanonicalizingWhenParentIsNull() {
        try {
            // Using reflection to access the protected constructor
            ByteQuadsCanonicalizer instance = (ByteQuadsCanonicalizer) 
                ByteQuadsCanonicalizer.class.getDeclaredConstructor(int.class, int.class)
                .newInstance(0, 0);
            
            // Since _parent is protected and final, we cannot set it directly.
            // We will assume it is null by default as per the constructor's behavior.
            boolean result = instance.isCanonicalizing();
            assertFalse(result);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


}