package com.fasterxml.jackson.databind.util;
import com.fasterxml.jackson.databind.util.ArrayBuilders;
import com.fasterxml.jackson.databind.util.ArrayBuilders.IntBuilder;
import org.junit.Test;
import static org.junit.Assert.assertNotNull;

public class util_ArrayBuilders_getIntBuilder__cfg_path_2_Test {

    @Test(timeout = 4000)
    public void testGetIntBuilder() {
        ArrayBuilders arrayBuilders = new ArrayBuilders();
        IntBuilder intBuilder = null;

        try {
            intBuilder = arrayBuilders.getIntBuilder();
        } catch (Exception e) {
            // Handle the exception if it occurs
            e.printStackTrace();
        }

        assertNotNull("IntBuilder should not be null", intBuilder);
    }

}