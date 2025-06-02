package com.fasterxml.jackson.databind.util;
import com.fasterxml.jackson.databind.util.ArrayBuilders;
import com.fasterxml.jackson.databind.util.ArrayBuilders.ByteBuilder;
import org.junit.Test;
import static org.junit.Assert.assertNotNull;

public class util_ArrayBuilders_getByteBuilder__cfg_path_1_Test {

    @Test(timeout = 4000)
    public void testGetByteBuilder() {
        ArrayBuilders arrayBuilders = new ArrayBuilders();
        ByteBuilder byteBuilder = null;

        try {
            byteBuilder = arrayBuilders.getByteBuilder();
        } catch (Exception e) {
            // Handle the exception if it occurs
            e.printStackTrace();
        }

        assertNotNull("ByteBuilder should not be null", byteBuilder);
    }

}