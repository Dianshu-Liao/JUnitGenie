package org.apache.commons.compress.utils;
import org.apache.commons.compress.utils.ServiceLoaderIterator;
import java.util.Iterator;
import java.util.ServiceConfigurationError;
import org.junit.Test;
import static org.junit.Assert.*;

public class utils_ServiceLoaderIterator_hasNext__cfg_path_30_Test {

    @Test(expected = ServiceConfigurationError.class, timeout = 4000)
    public void testHasNext_throwsServiceConfigurationError() {
        // Instantiating a ServiceLoaderIterator with a mock iterator
        Iterator<Object> mockIterator = new Iterator<Object>() {
            @Override
            public boolean hasNext() {
                return true; // Continue in the loop
            }

            @Override
            public Object next() {
                throw new ServiceConfigurationError("Mocked error", new SecurityException("Security issue."));
            }
        };

        // Create instance of ServiceLoaderIterator
        ServiceLoaderIterator<Object> serviceLoaderIterator = new ServiceLoaderIterator<>(Object.class);
        // Access the private field via reflection
        try {
            java.lang.reflect.Field field = ServiceLoaderIterator.class.getDeclaredField("serviceLoaderIterator");
            field.setAccessible(true);
            field.set(serviceLoaderIterator, mockIterator);
        } catch (Exception e) {
            fail("Reflection access failed: " + e.getMessage());
        }

        // Invoke the hasNext method
        serviceLoaderIterator.hasNext(); // This should throw a ServiceConfigurationError
    }
    
    @Test(timeout = 4000)
    public void testHasNext_withNoMoreElements() {
        // Create an empty iterator
        Iterator<Object> emptyIterator = new Iterator<Object>() {
            @Override
            public boolean hasNext() {
                return false;
            }

            @Override
            public Object next() {
                return null; // This will not be called since hasNext() is false
            }
        };

        // Create instance of ServiceLoaderIterator
        ServiceLoaderIterator<Object> serviceLoaderIterator = new ServiceLoaderIterator<>(Object.class);
        // Access the private field via reflection
        try {
            java.lang.reflect.Field field = ServiceLoaderIterator.class.getDeclaredField("serviceLoaderIterator");
            field.setAccessible(true);
            field.set(serviceLoaderIterator, emptyIterator);
        } catch (Exception e) {
            fail("Reflection access failed: " + e.getMessage());
        }

        // Assert hasNext() returns false
        assertFalse(serviceLoaderIterator.hasNext());
    }

}