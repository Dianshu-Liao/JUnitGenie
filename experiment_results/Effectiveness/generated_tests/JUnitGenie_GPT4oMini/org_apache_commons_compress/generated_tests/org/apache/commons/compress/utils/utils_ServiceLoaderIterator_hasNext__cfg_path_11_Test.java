package org.apache.commons.compress.utils;
import org.junit.Test;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Collections;
import java.util.ServiceConfigurationError;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class utils_ServiceLoaderIterator_hasNext__cfg_path_11_Test {

    @Test(timeout = 4000)
    public void testHasNextReturnsFalseWhenNoElements() {
        Iterator<Object> emptyIterator = Collections.emptyIterator();
        ServiceLoaderIterator serviceLoaderIterator = new ServiceLoaderIterator(Object.class, null);
        setServiceLoaderIterator(serviceLoaderIterator, emptyIterator); // Use setter method

        assertFalse(serviceLoaderIterator.hasNext());
    }

    @Test(timeout = 4000)
    public void testHasNextReturnsTrueWhenElementsExist() {
        Iterator<Object> singleElementIterator = Collections.singletonList(new Object()).iterator();
        ServiceLoaderIterator serviceLoaderIterator = new ServiceLoaderIterator(Object.class, null);
        setServiceLoaderIterator(serviceLoaderIterator, singleElementIterator); // Use setter method

        assertTrue(serviceLoaderIterator.hasNext());
    }

    @Test(timeout = 4000)
    public void testHasNextHandlesSecurityException() {
        // Create a mock iterator that will throw a ServiceConfigurationError with a SecurityException
        Iterator<Object> errorThrowingIterator = new Iterator<Object>() {
            @Override
            public boolean hasNext() {
                throw new ServiceConfigurationError("Test error", new SecurityException("Security exception"));
            }

            @Override
            public Object next() {
                throw new NoSuchElementException();
            }
        };
        ServiceLoaderIterator serviceLoaderIterator = new ServiceLoaderIterator(Object.class, null);
        setServiceLoaderIterator(serviceLoaderIterator, errorThrowingIterator); // Use setter method

        // Since the implementation ignores the SecurityException, we should still call hasNext and expect it to loop
        try {
            assertFalse(serviceLoaderIterator.hasNext()); // Should not throw an unhandled exception
        } catch (ServiceConfigurationError e) {
            // We should not reach here
            assertTrue(false);
        } catch (Throwable t) {
            // Catch any other unexpected exceptions
            assertTrue(false);
        }
    }

    @Test(expected = ServiceConfigurationError.class)
    public void testHasNextThrowsServiceConfigurationErrorForUnexpectedException() {
        // Create a mock iterator that will throw a ServiceConfigurationError without a SecurityException
        Iterator<Object> errorThrowingIterator = new Iterator<Object>() {
            @Override
            public boolean hasNext() {
                throw new ServiceConfigurationError("Test error"); // No SecurityException
            }

            @Override
            public Object next() {
                throw new NoSuchElementException();
            }
        };
        ServiceLoaderIterator serviceLoaderIterator = new ServiceLoaderIterator(Object.class, null);
        setServiceLoaderIterator(serviceLoaderIterator, errorThrowingIterator); // Use setter method

        // This should throw the ServiceConfigurationError
        serviceLoaderIterator.hasNext();
    }

    // Setter method to set the private field
    private void setServiceLoaderIterator(ServiceLoaderIterator serviceLoaderIterator, Iterator<Object> iterator) {
        try {
            java.lang.reflect.Field field = ServiceLoaderIterator.class.getDeclaredField("serviceLoaderIterator");
            field.setAccessible(true);
            field.set(serviceLoaderIterator, iterator);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }


}