package org.apache.commons.compress.archivers.sevenz;
import org.apache.commons.compress.archivers.sevenz.SevenZMethodConfiguration;
import org.apache.commons.compress.archivers.sevenz.SevenZMethod;
import org.junit.Test;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class archivers_sevenz_SevenZMethodConfiguration_equals_Object_cfg_path_1_Test {

    @Test(timeout = 4000)
    public void testEquals_SameObject() {
        SevenZMethodConfiguration config = new SevenZMethodConfiguration(SevenZMethod.LZMA); // Use a valid enum value
        assertTrue(config.equals(config));
    }

    @Test(timeout = 4000)
    public void testEquals_NullObject() {
        SevenZMethodConfiguration config = new SevenZMethodConfiguration(SevenZMethod.LZMA); // Use a valid enum value
        assertFalse(config.equals(null));
    }

    @Test(timeout = 4000)
    public void testEquals_DifferentClass() {
        SevenZMethodConfiguration config = new SevenZMethodConfiguration(SevenZMethod.LZMA); // Use a valid enum value
        assertFalse(config.equals(new Object()));
    }

    @Test(timeout = 4000)
    public void testEquals_EqualConfigurations() {
        SevenZMethodConfiguration config1 = new SevenZMethodConfiguration(SevenZMethod.LZMA); // Use a valid enum value
        SevenZMethodConfiguration config2 = new SevenZMethodConfiguration(SevenZMethod.LZMA); // Use a valid enum value
        assertTrue(config1.equals(config2));
    }

    @Test(timeout = 4000)
    public void testEquals_DifferentConfigurations() {
        SevenZMethodConfiguration config1 = new SevenZMethodConfiguration(SevenZMethod.LZMA); // Use a valid enum value
        SevenZMethodConfiguration config2 = new SevenZMethodConfiguration(SevenZMethod.BZIP2); // Use a different valid enum value
        assertFalse(config1.equals(config2));
    }


}