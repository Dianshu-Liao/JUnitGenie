package org.apache.commons.lang3;
import org.apache.commons.lang3.Functions;
import org.apache.commons.lang3.Functions.FailableSupplier;
import static org.junit.Assert.*;
import org.junit.Test;

public class Functions_get_FailableSupplier_cfg_path_2_Test {

    @Test(timeout = 4000)
    public void testGet_Success() {
        // Arrange
        FailableSupplier<String, Throwable> supplier = new FailableSupplier<String, Throwable>() {
            @Override
            public String get() throws Throwable {
                return "Hello, World!";
            }
        };

        // Act
        String result = Functions.get(supplier);

        // Assert
        assertEquals("Hello, World!", result);
    }

    @Test(timeout = 4000)
    public void testGet_ThrowsException() {
        // Arrange
        FailableSupplier<String, Throwable> supplier = new FailableSupplier<String, Throwable>() {
            @Override
            public String get() throws Throwable {
                throw new RuntimeException("Exception occurred");
            }
        };

        // Act
        try {
            Functions.get(supplier);
            fail("Expected an exception to be thrown");
        } catch (Throwable t) {
            // Assert
            assertTrue(t instanceof RuntimeException);
            assertEquals("Exception occurred", t.getMessage());
        }
    }

}