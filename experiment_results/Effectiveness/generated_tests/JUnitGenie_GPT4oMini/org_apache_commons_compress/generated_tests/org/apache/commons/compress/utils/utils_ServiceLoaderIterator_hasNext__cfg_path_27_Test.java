package org.apache.commons.compress.utils;
import org.apache.commons.compress.utils.ServiceLoaderIterator;
import org.junit.Test;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.ServiceConfigurationError;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class utils_ServiceLoaderIterator_hasNext__cfg_path_27_Test {

    @Test(timeout = 4000)
    public void testHasNextWhenServiceLoaderIteratorHasNext() {
        // Mocking an Iterator that has elements
        Iterator<String> mockIterator = new Iterator<String>() {
            private int count = 0;

            @Override
            public boolean hasNext() {
                return count < 1; // Simulate that there is one element
            }

            @Override
            public String next() {
                if (count < 1) {
                    count++;
                    return "element";
                }
                throw new NoSuchElementException();
            }
        };

        ServiceLoaderIterator<String> serviceLoaderIterator = new ServiceLoaderIterator<>(String.class);
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
    public void testHasNextWhenServiceLoaderIteratorIsEmpty() {
        // Mocking an empty Iterator
        Iterator<String> mockIterator = new Iterator<String>() {
            @Override
            public boolean hasNext() {
                return false; // Simulate that there are no elements
            }

            @Override
            public String next() {
                throw new NoSuchElementException();
            }
        };

        ServiceLoaderIterator<String> serviceLoaderIterator = new ServiceLoaderIterator<>(String.class);
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
        Iterator<String> mockIterator = new Iterator<String>() {
            @Override
            public boolean hasNext() {
                throw new ServiceConfigurationError("Error occurred");
            }

            @Override
            public String next() {
                return "element"; // This won't be reached
            }
        };

        ServiceLoaderIterator<String> serviceLoaderIterator = new ServiceLoaderIterator<>(String.class);
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
        }
    }

}