package org.apache.commons.compress.archivers.sevenz;
import org.apache.commons.compress.archivers.sevenz.SevenZMethodConfiguration;
import org.junit.Test;
import static org.junit.Assert.assertFalse;

public class archivers_sevenz_SevenZMethodConfiguration_equals_Object_cfg_path_5_Test {

    @Test(timeout = 4000)
    public void testEqualsWithNull() {
        SevenZMethodConfiguration config = new SevenZMethodConfiguration(null);
        try {
            boolean result = config.equals(null);
            assertFalse(result);
        } catch (Exception e) {
            // Handle exception if necessary
        }
    }

}