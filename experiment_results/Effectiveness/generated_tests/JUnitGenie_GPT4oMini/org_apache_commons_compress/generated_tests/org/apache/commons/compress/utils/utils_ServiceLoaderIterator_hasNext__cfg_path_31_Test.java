package org.apache.commons.compress.utils;
import org.apache.commons.compress.utils.ServiceLoaderIterator;
import org.junit.Test;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.ServiceConfigurationError;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class utils_ServiceLoaderIterator_hasNext__cfg_path_31_Test {

    @Test(timeout = 4000)
    public void testHasNextReturnsTrue() {
        // Mocking an Iterator that has elements
        Iterator<Object> mockIterator = new Iterator<Object>() {
            private int count = 2; // Two elements to return

            @Override
            public boolean hasNext() {
                return count > 0;
            }

            @Override
            public Object next() {
                if (count <= 0) {
                    throw new NoSuchElementException();
                }
                count--;
                return new Object(); // Return a new Object
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
        assertTrue(serviceLoaderIterator.hasNext()); // Call again to ensure it still returns true
    }

    @Test(timeout = 4000)
    public void testHasNextReturnsFalse() {
        // Mocking an empty Iterator
        Iterator<Object> mockIterator = new Iterator<Object>() {
            @Override
            public boolean hasNext() {
                return false;
            }

            @Override
            public Object next() {
                throw new NoSuchElementException();
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
        assertFalse(serviceLoaderIterator.hasNext());
    }

    @Test(timeout = 4000)
    public void testHasNextHandlesServiceConfigurationError() {
        // Mocking an Iterator that throws ServiceConfigurationError
        Iterator<Object> mockIterator = new Iterator<Object>() {
            @Override
            public boolean hasNext() {
                throw new ServiceConfigurationError("Service configuration error");
            }

            @Override
            public Object next() {
                throw new NoSuchElementException();
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
            // Expected exception
            assertTrue(e.getMessage().contains("Service configuration error"));
        }
    }

    @Test(timeout = 4000)
    public void testHasNextHandlesSecurityException() {
        // Mocking an Iterator that throws SecurityException
        Iterator<Object> mockIterator = new Iterator<Object>() {
            @Override
            public boolean hasNext() {
                throw new SecurityException("Security issue");
            }

            @Override
            public Object next() {
                throw new NoSuchElementException();
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
        assertFalse(serviceLoaderIterator.hasNext()); // Should ignore the SecurityException
    }

}