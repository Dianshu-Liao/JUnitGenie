package org.apache.commons.compress.utils;
import org.apache.commons.compress.utils.ServiceLoaderIterator;
import org.junit.Test;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.ServiceConfigurationError;
import static org.junit.Assert.*;

public class utils_ServiceLoaderIterator_hasNext__cfg_path_25_Test {

    @Test(timeout = 4000)
    public void testHasNext() {
        // Mocking an Iterator that has elements
        Iterator<Object> mockIterator = new Iterator<Object>() {
            private int count = 0;

            @Override
            public boolean hasNext() {
                return count < 1; // Only one element
            }

            @Override
            public Object next() {
                if (count < 1) {
                    count++;
                    return new Object(); // Return a new object
                }
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
        assertTrue(serviceLoaderIterator.hasNext());
    }

    @Test(timeout = 4000)
    public void testHasNextThrowsServiceConfigurationError() {
        // Mocking an Iterator that throws ServiceConfigurationError
        Iterator<Object> mockIterator = new Iterator<Object>() {
            @Override
            public boolean hasNext() {
                throw new ServiceConfigurationError("Service configuration error");
            }

            @Override
            public Object next() {
                return new Object(); // This won't be called
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

        // Test the hasNext method and handle the exception
        try {
            serviceLoaderIterator.hasNext();
            fail("Expected ServiceConfigurationError to be thrown");
        } catch (ServiceConfigurationError e) {
            // Expected exception
        }
    }

    @Test(timeout = 4000)
    public void testHasNextHandlesSecurityException() {
        // Mocking an Iterator that throws ServiceConfigurationError with SecurityException
        Iterator<Object> mockIterator = new Iterator<Object>() {
            @Override
            public boolean hasNext() {
                throw new ServiceConfigurationError("Service configuration error", new SecurityException());
            }

            @Override
            public Object next() {
                return new Object(); // This won't be called
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
            serviceLoaderIterator.hasNext(); // This will throw ServiceConfigurationError
            fail("Expected ServiceConfigurationError to be thrown");
        } catch (ServiceConfigurationError e) {
            // Expected exception
        }
    }

}