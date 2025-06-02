package org.apache.commons.compress.utils;
import org.apache.commons.compress.utils.ServiceLoaderIterator;
import org.junit.Test;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.ServiceConfigurationError;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class utils_ServiceLoaderIterator_hasNext__cfg_path_75_Test {

    @Test(timeout = 4000)
    public void testHasNextWhenServiceLoaderIteratorHasNext() {
        // Mocking the serviceLoaderIterator to return true for hasNext()
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

        assertTrue(serviceLoaderIterator.hasNext());
    }

    @Test(timeout = 4000)
    public void testHasNextWhenServiceLoaderIteratorHasNoNext() {
        // Mocking the serviceLoaderIterator to return false for hasNext()
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

        assertFalse(serviceLoaderIterator.hasNext());
    }

    @Test(timeout = 4000)
    public void testHasNextHandlesServiceConfigurationError() {
        // Mocking the serviceLoaderIterator to throw ServiceConfigurationError
        Iterator<Object> mockIterator = new Iterator<Object>() {
            @Override
            public boolean hasNext() {
                throw new ServiceConfigurationError("Error occurred");
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

        try {
            serviceLoaderIterator.hasNext();
        } catch (ServiceConfigurationError e) {
            // Expected exception
            return;
        }
        // If we reach here, the exception was not thrown
        assertFalse("Expected ServiceConfigurationError to be thrown", true);
    }

}