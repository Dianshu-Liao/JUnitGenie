package org.apache.commons.compress.archivers.sevenz;
import org.apache.commons.compress.archivers.sevenz.SevenZMethod;
import org.apache.commons.compress.archivers.sevenz.SevenZMethodConfiguration;
import org.apache.commons.compress.archivers.sevenz.Coders;
import org.junit.Test;
import static org.junit.Assert.*;

public class archivers_sevenz_SevenZMethodConfiguration__init__SevenZMethod_Object_cfg_path_2_Test {

    @Test(timeout = 4000)
    public void testConstructorWithValidOptions() {
        SevenZMethod method = SevenZMethod.LZMA; // Use a valid enum constant instead of instantiation
        Object options = new Object(); // Replace with a valid options instance

        try {
            SevenZMethodConfiguration config = new SevenZMethodConfiguration(method, options);
            assertNotNull(config);
        } catch (IllegalArgumentException e) {
            fail("Constructor threw IllegalArgumentException for valid options: " + e.getMessage());
        }
    }

    @Test(timeout = 4000)
    public void testConstructorWithNullOptions() {
        SevenZMethod method = SevenZMethod.LZMA; // Use a valid enum constant instead of instantiation

        try {
            SevenZMethodConfiguration config = new SevenZMethodConfiguration(method, null);
            assertNotNull(config);
        } catch (IllegalArgumentException e) {
            fail("Constructor threw IllegalArgumentException for null options: " + e.getMessage());
        }
    }

    @Test(timeout = 4000)
    public void testConstructorWithInvalidOptions() {
        SevenZMethod method = SevenZMethod.LZMA; // Use a valid enum constant instead of instantiation
        Object invalidOptions = new Object(); // Replace with an invalid options instance

        try {
            SevenZMethodConfiguration config = new SevenZMethodConfiguration(method, invalidOptions);
            fail("Constructor should have thrown IllegalArgumentException for invalid options");
        } catch (IllegalArgumentException e) {
            // Expected exception
        }
    }


}