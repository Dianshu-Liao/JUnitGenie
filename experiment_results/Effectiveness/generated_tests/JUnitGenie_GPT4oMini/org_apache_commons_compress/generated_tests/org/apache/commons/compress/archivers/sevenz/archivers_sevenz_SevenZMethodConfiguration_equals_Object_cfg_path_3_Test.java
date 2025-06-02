package org.apache.commons.compress.archivers.sevenz;
import org.apache.commons.compress.archivers.sevenz.SevenZMethodConfiguration;
import org.apache.commons.compress.archivers.sevenz.SevenZMethod;
import org.junit.Test;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertFalse;

public class archivers_sevenz_SevenZMethodConfiguration_equals_Object_cfg_path_3_Test {

    @Test(timeout = 4000)
    public void testEquals_SameObject() {
        SevenZMethod method = SevenZMethod.values()[0]; // Use an existing enum value
        SevenZMethodConfiguration config = new SevenZMethodConfiguration(method);
        assertTrue(config.equals(config));
    }

    @Test(timeout = 4000)
    public void testEquals_NullObject() {
        SevenZMethod method = SevenZMethod.values()[0]; // Use an existing enum value
        SevenZMethodConfiguration config = new SevenZMethodConfiguration(method);
        assertFalse(config.equals(null));
    }

    @Test(timeout = 4000)
    public void testEquals_DifferentClass() {
        SevenZMethod method = SevenZMethod.values()[0]; // Use an existing enum value
        SevenZMethodConfiguration config = new SevenZMethodConfiguration(method);
        assertFalse(config.equals(new Object()));
    }

    @Test(timeout = 4000)
    public void testEquals_DifferentMethods() {
        SevenZMethod method1 = SevenZMethod.values()[0]; // Use an existing enum value
        SevenZMethod method2 = SevenZMethod.values()[1]; // Use a different existing enum value
        SevenZMethodConfiguration config1 = new SevenZMethodConfiguration(method1);
        SevenZMethodConfiguration config2 = new SevenZMethodConfiguration(method2);
        assertFalse(config1.equals(config2));
    }




}
