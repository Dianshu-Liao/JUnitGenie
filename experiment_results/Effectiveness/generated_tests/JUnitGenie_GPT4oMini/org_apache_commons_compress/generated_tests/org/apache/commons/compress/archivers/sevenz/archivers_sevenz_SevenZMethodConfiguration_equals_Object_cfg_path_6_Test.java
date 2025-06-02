package org.apache.commons.compress.archivers.sevenz;
import org.apache.commons.compress.archivers.sevenz.SevenZMethodConfiguration;
import org.junit.Test;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertFalse;

public class archivers_sevenz_SevenZMethodConfiguration_equals_Object_cfg_path_6_Test {

    @Test(timeout = 4000)
    public void testEquals_SameReference_ShouldReturnTrue() {
        SevenZMethodConfiguration config = new SevenZMethodConfiguration(null);
        assertTrue(config.equals(config));
    }

    @Test(timeout = 4000)
    public void testEquals_NullObject_ShouldReturnFalse() {
        SevenZMethodConfiguration config = new SevenZMethodConfiguration(null);
        assertFalse(config.equals(null));
    }

    @Test(timeout = 4000)
    public void testEquals_DifferentType_ShouldReturnFalse() {
        SevenZMethodConfiguration config = new SevenZMethodConfiguration(null);
        assertFalse(config.equals("NotASevenZMethodConfiguration"));
    }

    @Test(timeout = 4000)
    public void testEquals_DifferentObject_ShouldReturnFalse() {
        SevenZMethodConfiguration config1 = new SevenZMethodConfiguration(null);
        SevenZMethodConfiguration config2 = new SevenZMethodConfiguration(null);
        assertFalse(config1.equals(config2));
    }

    @Test(timeout = 4000)
    public void testEquals_SameContent_ShouldReturnTrue() {
        SevenZMethodConfiguration config1 = new SevenZMethodConfiguration(null); // Assuming a valid method instance is passed
        SevenZMethodConfiguration config2 = new SevenZMethodConfiguration(null); // Use similar method instance
        assertTrue(config1.equals(config2));
    }

}