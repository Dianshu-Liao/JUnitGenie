package com.fasterxml.jackson.databind.util;
import com.fasterxml.jackson.databind.util.ArrayBuilders;
import com.fasterxml.jackson.databind.util.ArrayBuilders.ShortBuilder;
import org.junit.Test;
import static org.junit.Assert.assertNotNull;

public class util_ArrayBuilders_getShortBuilder__cfg_path_1_Test {

    @Test(timeout = 4000)
    public void testGetShortBuilder() {
        ArrayBuilders arrayBuilders = new ArrayBuilders();
        ShortBuilder shortBuilder = arrayBuilders.getShortBuilder();
        assertNotNull("ShortBuilder should not be null", shortBuilder);
    }

}