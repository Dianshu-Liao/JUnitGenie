package org.apache.commons.lang3.function;
import org.apache.commons.lang3.function.Failable;
import org.apache.commons.lang3.function.FailableBooleanSupplier;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertFalse;
import org.junit.Test;

public class function_Failable_getAsBoolean_FailableBooleanSupplier_cfg_path_2_Test {

    @Test(timeout = 4000)
    public void testGetAsBooleanReturnsTrue() {
        FailableBooleanSupplier supplier = new FailableBooleanSupplier() {
            @Override
            public boolean getAsBoolean() {
                return true; // Return true to test the successful path
            }
        };
        
        boolean result = Failable.getAsBoolean(supplier);
        assertTrue(result);
    }

    @Test(timeout = 4000)
    public void testGetAsBooleanReturnsFalse() {
        FailableBooleanSupplier supplier = new FailableBooleanSupplier() {
            @Override
            public boolean getAsBoolean() {
                return false; // Return false to test the successful path
            }
        };
        
        boolean result = Failable.getAsBoolean(supplier);
        assertFalse(result);
    }

    @Test(timeout = 4000)
    public void testGetAsBooleanThrowsException() {
        FailableBooleanSupplier supplier = new FailableBooleanSupplier() {
            @Override
            public boolean getAsBoolean() throws Exception {
                throw new Exception("Test Exception"); // Simulate an exception
            }
        };
        
        try {
            Failable.getAsBoolean(supplier);
            // If no exception is thrown, the test should fail
            assertTrue("Expected an exception to be thrown", false);
        } catch (Exception e) {
            // Handle the exception and ensure it reaches here for the test to pass
            assertTrue(e.getMessage().contains("Test Exception"));
        }
    }


}