package org.apache.commons.lang3;
import org.apache.commons.lang3.Functions;
import org.apache.commons.lang3.Functions.FailableSupplier;
import org.junit.Test;
import static org.junit.Assert.fail;

public class Functions_get_FailableSupplier_cfg_path_1_Test {

    @Test(timeout = 4000)
    public void testGetThrowsException() {
        FailableSupplier<Object, Throwable> supplier = new FailableSupplier<Object, Throwable>() {
            @Override
            public Object get() throws Throwable {
                throw new Exception("Test Exception");
            }
        };

        try {
            Functions.get(supplier);
            fail("Expected an exception to be thrown");
        } catch (Throwable t) {
            // Expected exception
            // Here we can assert the type of exception if needed
        }
    }

    @Test(timeout = 4000)
    public void testGetWithRuntimeException() {
        FailableSupplier<Object, Throwable> supplier = new FailableSupplier<Object, Throwable>() {
            @Override
            public Object get() throws Throwable {
                throw new IllegalArgumentException("Test IllegalArgumentException");
            }
        };

        try {
            Functions.get(supplier);
            fail("Expected an exception to be thrown");
        } catch (Throwable t) {
            // Expected exception
            // Here we can assert the type of exception if needed
        }
    }

}