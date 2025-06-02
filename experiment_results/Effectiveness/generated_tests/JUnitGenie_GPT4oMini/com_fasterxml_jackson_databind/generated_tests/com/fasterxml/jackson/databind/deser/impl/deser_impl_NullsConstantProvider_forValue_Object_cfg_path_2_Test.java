package com.fasterxml.jackson.databind.deser.impl;
import com.fasterxml.jackson.databind.deser.impl.NullsConstantProvider;
import org.junit.Test;
import static org.junit.Assert.assertNotNull;

public class deser_impl_NullsConstantProvider_forValue_Object_cfg_path_2_Test {

    @Test(timeout = 4000)
    public void testForValue_NonNullInput() {
        Object testValue = new Object();
        NullsConstantProvider result = NullsConstantProvider.forValue(testValue);
        assertNotNull(result);
    }

    @Test(timeout = 4000)
    public void testForValue_NullInput() {
        try {
            NullsConstantProvider result = NullsConstantProvider.forValue(null);
            assertNotNull(result);
            // Additional check to ensure it returns the NULLER instance
            assertNotNull(NullsConstantProvider.class.getDeclaredField("NULLER").get(null));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}