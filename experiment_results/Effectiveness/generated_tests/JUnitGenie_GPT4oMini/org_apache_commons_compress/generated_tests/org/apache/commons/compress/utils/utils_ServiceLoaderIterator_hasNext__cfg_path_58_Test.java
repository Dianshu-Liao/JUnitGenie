package org.apache.commons.compress.utils;
import org.apache.commons.compress.utils.ServiceLoaderIterator;
import org.junit.Test;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.ServiceConfigurationError;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class utils_ServiceLoaderIterator_hasNext__cfg_path_58_Test {

    @Test(timeout = 4000)
    public void testHasNextWhenServiceLoaderIteratorHasNext() {
        // Mocking the Iterator to return a value
        Iterator<Object> mockIterator = new Iterator<Object>() {
            private boolean hasNext = true;

            @Override
            public boolean hasNext() {
                return hasNext;
            }

            @Override
            public Object next() {
                if (!hasNext) {
                    throw new NoSuchElementException();
                }
                hasNext = false; // Simulate that there is only one element
                return new Object();
            }
        };

        ServiceLoaderIterator<Object> serviceLoaderIterator = new ServiceLoaderIterator<>(Object.class);
        // Using reflection to set the private field serviceLoaderIterator
        try {
            java.lang.reflect.Field field = ServiceLoaderIterator.class.getDeclaredField("serviceLoaderIterator");
            field.setAccessible(true);
            field.set(serviceLoaderIterator, mockIterator);
        } catch (Exception e) {
            e.printStackTrace();
        }

        // Test the hasNext method
        assertTrue(serviceLoaderIterator.hasNext());
        assertFalse(serviceLoaderIterator.hasNext());
    }

    @Test(timeout = 4000)
    public void testHasNextWhenServiceLoaderIteratorThrowsServiceConfigurationError() {
        // Mocking the Iterator to throw ServiceConfigurationError
        Iterator<Object> mockIterator = new Iterator<Object>() {
            @Override
            public boolean hasNext() {
                return true; // Simulate that there is an element
            }

            @Override
            public Object next() {
                throw new ServiceConfigurationError("Error occurred", new SecurityException());
            }
        };

        ServiceLoaderIterator<Object> serviceLoaderIterator = new ServiceLoaderIterator<>(Object.class);
        // Using reflection to set the private field serviceLoaderIterator
        try {
            java.lang.reflect.Field field = ServiceLoaderIterator.class.getDeclaredField("serviceLoaderIterator");
            field.setAccessible(true);
            field.set(serviceLoaderIterator, mockIterator);
        } catch (Exception e) {
            e.printStackTrace();
        }

        // Test the hasNext method
        try {
            serviceLoaderIterator.hasNext();
        } catch (ServiceConfigurationError e) {
            // Expected to catch the ServiceConfigurationError
            return; // Exit the test successfully
        }
        // If no exception was thrown, fail the test
        assertFalse("Expected ServiceConfigurationError was not thrown", true);
    }

    @Test(timeout = 4000)
    public void testHasNextWhenServiceLoaderIteratorThrowsNonSecurityException() {
        // Mocking the Iterator to throw ServiceConfigurationError with a non-security exception
        Iterator<Object> mockIterator = new Iterator<Object>() {
            @Override
            public boolean hasNext() {
                return true; // Simulate that there is an element
            }

            @Override
            public Object next() {
                throw new ServiceConfigurationError("Error occurred", new RuntimeException());
            }
        };

        ServiceLoaderIterator<Object> serviceLoaderIterator = new ServiceLoaderIterator<>(Object.class);
        // Using reflection to set the private field serviceLoaderIterator
        try {
            java.lang.reflect.Field field = ServiceLoaderIterator.class.getDeclaredField("serviceLoaderIterator");
            field.setAccessible(true);
            field.set(serviceLoaderIterator, mockIterator);
        } catch (Exception e) {
            e.printStackTrace();
        }

        // Test the hasNext method
        try {
            serviceLoaderIterator.hasNext();
        } catch (ServiceConfigurationError e) {
            // Expected to catch the ServiceConfigurationError
            return; // Exit the test successfully
        }
        // If no exception was thrown, fail the test
        assertFalse("Expected ServiceConfigurationError was not thrown", true);
    }

}