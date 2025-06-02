package org.joda.time.convert;
import org.joda.time.convert.ConverterManager;
import org.joda.time.convert.DurationConverter;
import org.junit.Test;
import static org.junit.Assert.assertNull;

public class convert_ConverterManager_addDurationConverter_DurationConverter_cfg_path_2_Test {

    @Test(timeout = 4000)
    public void testAddDurationConverterWithNull() {
        ConverterManager manager = new ConverterManager();
        DurationConverter result = null;

        // Temporarily disable the security manager for this test
        System.setSecurityManager(null);

        try {
            result = manager.addDurationConverter(null);
        } catch (SecurityException e) {
            // Handle the exception if thrown
            e.printStackTrace();
        }

        assertNull("Expected result to be null when adding a null DurationConverter", result);
    }


}