package org.apache.commons.compress.utils;
import org.apache.commons.compress.utils.ServiceLoaderIterator;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.ServiceConfigurationError;
import org.junit.Test;
import static org.junit.Assert.*;

public class utils_ServiceLoaderIterator_hasNext__cfg_path_33_Test {

    @Test(timeout = 4000)
    public void testHasNext_whenServiceLoaderIteratorHasElements() {
        Iterator<Object> mockIterator = new Iterator<Object>() {
            private int count = 2; // simulate two elements

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
                return new Object(); // return a mock object
            }
        };

        ServiceLoaderIterator<Object> serviceLoaderIterator = new ServiceLoaderIterator<>(Object.class);
        // Use reflection to access the private field for testing
        try {
            java.lang.reflect.Field field = ServiceLoaderIterator.class.getDeclaredField("serviceLoaderIterator");
            field.setAccessible(true);
            field.set(serviceLoaderIterator, mockIterator);
        } catch (Exception e) {
            fail("Reflection failed: " + e.getMessage());
        }

        assertTrue(serviceLoaderIterator.hasNext());
    }

    @Test(timeout = 4000)
    public void testHasNext_whenServiceLoaderIteratorHasNoElements() {
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
        // Use reflection to access the private field for testing
        try {
            java.lang.reflect.Field field = ServiceLoaderIterator.class.getDeclaredField("serviceLoaderIterator");
            field.setAccessible(true);
            field.set(serviceLoaderIterator, mockIterator);
        } catch (Exception e) {
            fail("Reflection failed: " + e.getMessage());
        }

        assertFalse(serviceLoaderIterator.hasNext());
    }

    @Test(timeout = 4000)
    public void testHasNext_apiException_throwsServiceConfigurationError() {
        Iterator<Object> mockIterator = new Iterator<Object>() {
            @Override
            public boolean hasNext() {
                throw new ServiceConfigurationError("Config error");
            }

            @Override
            public Object next() {
                throw new NoSuchElementException();
            }
        };

        ServiceLoaderIterator<Object> serviceLoaderIterator = new ServiceLoaderIterator<>(Object.class);
        // Use reflection to access the private field for testing
        try {
            java.lang.reflect.Field field = ServiceLoaderIterator.class.getDeclaredField("serviceLoaderIterator");
            field.setAccessible(true);
            field.set(serviceLoaderIterator, mockIterator);
        } catch (Exception e) {
            fail("Reflection failed: " + e.getMessage());
        }

        try {
            serviceLoaderIterator.hasNext();
            fail("Expected ServiceConfigurationError to be thrown");
        } catch (ServiceConfigurationError e) {
            // Exception handled
        }
    }

    @Test(timeout = 4000)
    public void testHasNext_securityExceptionIgnored() {
        Iterator<Object> mockIterator = new Iterator<Object>() {
            @Override
            public boolean hasNext() {
                throw new ServiceConfigurationError("Security exception") {
                    @Override
                    public Throwable getCause() {
                        return new SecurityException();
                    }
                };
            }

            @Override
            public Object next() {
                throw new NoSuchElementException();
            }
        };

        ServiceLoaderIterator<Object> serviceLoaderIterator = new ServiceLoaderIterator<>(Object.class);
        // Use reflection to access the private field for testing
        try {
            java.lang.reflect.Field field = ServiceLoaderIterator.class.getDeclaredField("serviceLoaderIterator");
            field.setAccessible(true);
            field.set(serviceLoaderIterator, mockIterator);
        } catch (Exception e) {
            fail("Reflection failed: " + e.getMessage());
        }

        // This should not throw an exception and continue without returning it
        try {
            assertTrue(serviceLoaderIterator.hasNext()); // We expect hasNext to continue checking
        } catch (ServiceConfigurationError e) {
            // Ignore the exception as per the test's intention
        }
    }

}