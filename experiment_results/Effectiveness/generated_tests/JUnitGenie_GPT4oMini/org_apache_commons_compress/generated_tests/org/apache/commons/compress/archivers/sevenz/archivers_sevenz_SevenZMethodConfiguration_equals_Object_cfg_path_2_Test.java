package org.apache.commons.compress.archivers.sevenz;
import org.apache.commons.compress.archivers.sevenz.SevenZMethodConfiguration;
import org.apache.commons.compress.archivers.sevenz.SevenZMethod;
import org.junit.Test;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertFalse;

public class archivers_sevenz_SevenZMethodConfiguration_equals_Object_cfg_path_2_Test {

    @Test(timeout = 4000)
    public void testEquals_SameObject() {
        SevenZMethod method = SevenZMethod.values()[0]; // Use an existing enum constant
        SevenZMethodConfiguration config = new SevenZMethodConfiguration(method);
        assertTrue(config.equals(config));
    }

    @Test(timeout = 4000)
    public void testEquals_NullObject() {
        SevenZMethod method = SevenZMethod.values()[0]; // Use an existing enum constant
        SevenZMethodConfiguration config = new SevenZMethodConfiguration(method);
        assertFalse(config.equals(null));
    }

    @Test(timeout = 4000)
    public void testEquals_DifferentClass() {
        SevenZMethod method = SevenZMethod.values()[0]; // Use an existing enum constant
        SevenZMethodConfiguration config = new SevenZMethodConfiguration(method);
        assertFalse(config.equals(new Object()));
    }




}
