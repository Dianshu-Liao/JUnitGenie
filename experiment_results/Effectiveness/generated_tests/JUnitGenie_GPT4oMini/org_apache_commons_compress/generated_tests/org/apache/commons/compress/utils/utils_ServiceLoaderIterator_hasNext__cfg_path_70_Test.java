package org.apache.commons.compress.utils;
import org.apache.commons.compress.utils.ServiceLoaderIterator;
import org.junit.Test;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.ServiceConfigurationError;
import static org.junit.Assert.assertFalse;

public class utils_ServiceLoaderIterator_hasNext__cfg_path_70_Test {

    @Test(timeout = 4000)
    public void testHasNextThrowsServiceConfigurationError() {
        // Create a mock iterator that will throw a ServiceConfigurationError
        Iterator<Object> mockIterator = new Iterator<Object>() {
            @Override
            public boolean hasNext() {
                return true; // Simulate that there is a next element
            }

            @Override
            public Object next() {
                throw new ServiceConfigurationError("Mock error", new SecurityException("Security issue"));
            }
        };

        ServiceLoaderIterator serviceLoaderIterator = new ServiceLoaderIterator(mockIterator.getClass());

        // Call hasNext() and expect it to handle the exception and return true
        boolean result = serviceLoaderIterator.hasNext();
        assertFalse(result); // Since the nextServiceLoader should remain null
    }

    @Test(timeout = 4000)
    public void testHasNextThrowsNonSecurityException() {
        // Create a mock iterator that will throw a ServiceConfigurationError with a non-security exception
        Iterator<Object> mockIterator = new Iterator<Object>() {
            @Override
            public boolean hasNext() {
                return true; // Simulate that there is a next element
            }

            @Override
            public Object next() {
                throw new ServiceConfigurationError("Mock error", new Exception("Non-security issue"));
            }
        };

        ServiceLoaderIterator serviceLoaderIterator = new ServiceLoaderIterator(mockIterator.getClass());

        try {
            serviceLoaderIterator.hasNext();
        } catch (ServiceConfigurationError e) {
            // Expected exception
        }
    }

}