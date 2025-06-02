package com.fasterxml.jackson.databind.util;
import com.fasterxml.jackson.databind.util.ArrayBuilders;
import com.fasterxml.jackson.databind.util.ArrayBuilders.FloatBuilder;
import org.junit.Test;
import static org.junit.Assert.assertNotNull;

public class util_ArrayBuilders_getFloatBuilder__cfg_path_1_Test {

    @Test(timeout = 4000)
    public void testGetFloatBuilder() {
        ArrayBuilders arrayBuilders = new ArrayBuilders();
        FloatBuilder floatBuilder = null;

        try {
            floatBuilder = arrayBuilders.getFloatBuilder();
        } catch (Exception e) {
            // Handle the exception if it occurs
            e.printStackTrace();
        }

        assertNotNull("FloatBuilder should not be null", floatBuilder);
    }

}