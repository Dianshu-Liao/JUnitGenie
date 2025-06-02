package org.apache.commons.lang3.function;
import org.apache.commons.lang3.function.Failable;
import org.apache.commons.lang3.function.FailableBooleanSupplier;
import org.junit.Test;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertEquals;
import java.io.IOException;

public class function_Failable_getAsBoolean_FailableBooleanSupplier_cfg_path_1_Test {

    @Test(timeout = 4000)
    public void testGetAsBooleanThrowsException() {
        FailableBooleanSupplier supplier = () -> {
            throw new IOException("Test Exception");
        };

        try {
            Failable.getAsBoolean(supplier);
        } catch (RuntimeException e) {
            // Verify that the exception is thrown and is of the expected type
            assertTrue(e.getCause() instanceof IOException);
            assertEquals("Test Exception", e.getCause().getMessage());
        }
    }

    @Test(timeout = 4000)
    public void testGetAsBooleanReturnsTrue() {
        FailableBooleanSupplier supplier = () -> true;

        boolean result = Failable.getAsBoolean(supplier);
        assertTrue(result);
    }

    @Test(timeout = 4000)
    public void testGetAsBooleanReturnsFalse() {
        FailableBooleanSupplier supplier = () -> false;

        boolean result = Failable.getAsBoolean(supplier);
        assertFalse(result);
    }


}