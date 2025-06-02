package com.fasterxml.jackson.core.sym;
import com.fasterxml.jackson.core.sym.ByteQuadsCanonicalizer;
import com.fasterxml.jackson.core.util.InternCache;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class sym_ByteQuadsCanonicalizer_addName_String_int_int_cfg_path_1_Test {
    private ByteQuadsCanonicalizer canonicalizer;

    @Before
    public void setUp() throws Exception {
        // Using reflection to access the private constructor
        canonicalizer = (ByteQuadsCanonicalizer) ByteQuadsCanonicalizer.class
                .getDeclaredConstructor(int.class, int.class)
                .newInstance(16, 16); // Example parameters for the constructor
    }

    @Test(timeout = 4000)
    public void testAddName() {
        String name = "testName";
        int q1 = 1;
        int q2 = 2;

        try {
            String result = canonicalizer.addName(name, q1, q2);
            assertEquals(name, result);
        } catch (Exception e) { // Changed to catch a more general Exception
            fail("Exception should not be thrown: " + e.getMessage());
        }
    }

    @Test(timeout = 4000)
    public void testAddNameWithInterning() {
        // Set up the _interner to not be null
        try {
            InternCache interner = new InternCache();
            // Using reflection to set the _interner field
            java.lang.reflect.Field internerField = ByteQuadsCanonicalizer.class.getDeclaredField("_interner");
            internerField.setAccessible(true);
            internerField.set(canonicalizer, interner);

            String name = "testName";
            int q1 = 1;
            int q2 = 2;

            try {
                String result = canonicalizer.addName(name, q1, q2);
                assertEquals(name, result);
            } catch (Exception e) { // Changed to catch a more general Exception
                fail("Exception should not be thrown: " + e.getMessage());
            }
        } catch (NoSuchFieldException e) {
            fail("Field _interner not found: " + e.getMessage());
        } catch (IllegalAccessException e) {
            fail("Illegal access to field _interner: " + e.getMessage());
        } catch (Exception e) {
            fail("Exception during test setup: " + e.getMessage());
        }
    }

}