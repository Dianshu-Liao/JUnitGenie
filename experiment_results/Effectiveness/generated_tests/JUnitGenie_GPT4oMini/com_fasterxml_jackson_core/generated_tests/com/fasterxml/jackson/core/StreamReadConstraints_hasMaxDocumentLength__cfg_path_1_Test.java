package com.fasterxml.jackson.core;
import com.fasterxml.jackson.core.StreamReadConstraints;
import org.junit.Test;
import java.lang.reflect.Constructor;
import static org.junit.Assert.assertFalse;

public class StreamReadConstraints_hasMaxDocumentLength__cfg_path_1_Test {

    @Test(timeout = 4000)
    public void testHasMaxDocumentLength_WhenMaxDocLenIsZero_ReturnsFalse() {
        try {
            // Use reflection to access the protected constructor
            Constructor<StreamReadConstraints> constructor = StreamReadConstraints.class.getDeclaredConstructor(int.class, long.class, int.class, int.class);
            constructor.setAccessible(true);
            StreamReadConstraints constraints = constructor.newInstance(0, 0L, 0, 0);
            
            // Assert that hasMaxDocumentLength returns false
            assertFalse(constraints.hasMaxDocumentLength());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}