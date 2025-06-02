package com.fasterxml.jackson.core;
import com.fasterxml.jackson.core.StreamReadConstraints;
import org.junit.Test;
import static org.junit.Assert.assertTrue;

public class StreamReadConstraints_hasMaxDocumentLength__cfg_path_2_Test {

    @Test(timeout = 4000)
    public void testHasMaxDocumentLength() {
        try {
            // Using reflection to access the protected constructor
            java.lang.reflect.Constructor<StreamReadConstraints> constructor = 
                StreamReadConstraints.class.getDeclaredConstructor(int.class, long.class, int.class, int.class);
            constructor.setAccessible(true);
            StreamReadConstraints constraints = constructor.newInstance(0, 1L, 0, 0);
            
            // Test the hasMaxDocumentLength method
            boolean result = constraints.hasMaxDocumentLength();
            assertTrue(result); // Expecting true since _maxDocLen is set to 1L which is greater than 0L
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}