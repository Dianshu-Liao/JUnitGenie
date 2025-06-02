package org.apache.commons.compress.utils;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.ServiceConfigurationError;
import org.junit.Test;
import static org.junit.Assert.*;

public class utils_ServiceLoaderIterator_hasNext__cfg_path_77_Test {

    @Test(timeout = 4000)
    public void testHasNext_WhenNoNextServiceLoader_ReturnsFalse() {
        // Arrange
        Iterator<Object> mockIterator = new Iterator<Object>() {
            private boolean hasNext = false;

            @Override
            public boolean hasNext() {
                return hasNext;
            }

            @Override
            public Object next() {
                throw new NoSuchElementException();
            }
        };
        
        ServiceLoaderIterator<Object> serviceLoaderIterator = new ServiceLoaderIterator<>(Object.class, mockIterator);

        // Act
        boolean result = serviceLoaderIterator.hasNext();

        // Assert
        assertFalse(result);
    }

    @Test(timeout = 4000)
    public void testHasNext_WhenServiceLoaderThrowsSecurityException_IgnoresException() {
        // Arrange
        Iterator<Object> mockIterator = new Iterator<Object>() {
            @Override
            public boolean hasNext() {
                throw new ServiceConfigurationError("Error", new SecurityException("Security issue"));
            }

            @Override
            public Object next() {
                return new Object();
            }
        };
        
        ServiceLoaderIterator<Object> serviceLoaderIterator = new ServiceLoaderIterator<>(Object.class, mockIterator);

        // Act
        boolean result = serviceLoaderIterator.hasNext();

        // Assert
        assertFalse(result); // Should continue and return false as no valid element
    }

    @Test(timeout = 4000)
    public void testHasNext_WhenServiceLoaderThrowsOtherException_ThrowsException() {
        // Arrange
        Iterator<Object> mockIterator = new Iterator<Object>() {
            @Override
            public boolean hasNext() {
                throw new ServiceConfigurationError("Other error");
            }

            @Override
            public Object next() {
                return new Object();
            }
        };
        
        ServiceLoaderIterator<Object> serviceLoaderIterator = new ServiceLoaderIterator<>(Object.class, mockIterator);

        // Act
        try {
            serviceLoaderIterator.hasNext();
            fail("Expected ServiceConfigurationError to be thrown");
        } catch (ServiceConfigurationError e) {
            // Assert
            assertEquals("Other error", e.getMessage());
        }
    }

    // Assuming ServiceLoaderIterator is defined somewhere in the codebase
    private static class ServiceLoaderIterator<T> implements Iterator<T> {
        private final Class<T> service;
        private final Iterator<T> iterator;

        public ServiceLoaderIterator(Class<T> service, Iterator<T> iterator) {
            this.service = service;
            this.iterator = iterator;
        }

        @Override
        public boolean hasNext() {
            try {
                return iterator.hasNext();
            } catch (ServiceConfigurationError e) {
                // Log or handle the exception as needed
                return false;
            }
        }

        @Override
        public T next() {
            return iterator.next();
        }
    }

}