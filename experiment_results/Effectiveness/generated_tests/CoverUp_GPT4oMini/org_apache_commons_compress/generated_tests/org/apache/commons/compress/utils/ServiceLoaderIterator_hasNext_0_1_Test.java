package org.apache.commons.compress.utils;

import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.ServiceConfigurationError;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import java.util.ServiceLoader;
import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class ServiceLoaderIterator_hasNext_0_1_Test {

    private ServiceLoaderIterator<MyService> serviceLoaderIterator;

    private Iterator<MyService> mockServiceLoaderIterator;

    @BeforeEach
    void setUp() {
        mockServiceLoaderIterator = mock(Iterator.class);
        serviceLoaderIterator = new ServiceLoaderIterator<MyService>(MyService.class) {

            {
                // Use reflection to set the private field serviceLoaderIterator
                try {
                    java.lang.reflect.Field field = ServiceLoaderIterator.class.getDeclaredField("serviceLoaderIterator");
                    field.setAccessible(true);
                    field.set(this, mockServiceLoaderIterator);
                } catch (Exception e) {
                    throw new RuntimeException(e);
                }
            }
        };
    }

    @Test
    void testHasNextReturnsFalseWhenNoMoreElements() {
        when(mockServiceLoaderIterator.hasNext()).thenReturn(false);
        assertFalse(serviceLoaderIterator.hasNext());
    }

    @Test
    void testHasNextReturnsTrueWhenNextElementAvailable() {
        when(mockServiceLoaderIterator.hasNext()).thenReturn(true);
        when(mockServiceLoaderIterator.next()).thenReturn(new MyService());
        assertTrue(serviceLoaderIterator.hasNext());
    }

    @Test
    void testHasNextHandlesServiceConfigurationError() {
        when(mockServiceLoaderIterator.hasNext()).thenThrow(new ServiceConfigurationError("Error"));
        assertThrows(ServiceConfigurationError.class, () -> serviceLoaderIterator.hasNext());
    }

//    @Test
//    void testHasNextIgnoresSecurityException() {
//        when(mockServiceLoaderIterator.hasNext()).thenThrow(new ServiceConfigurationError("Error", new SecurityException()));
//        when(mockServiceLoaderIterator.next()).thenReturn(new MyService());
//        assertTrue(serviceLoaderIterator.hasNext());
//    }

    @Test
    void testHasNextContinuesAfterSecurityException() {
        when(mockServiceLoaderIterator.hasNext()).thenThrow(new ServiceConfigurationError("Error", new SecurityException())).thenReturn(true);
        when(mockServiceLoaderIterator.next()).thenReturn(new MyService());
        assertTrue(serviceLoaderIterator.hasNext());
    }

    // Dummy service class for testing
    private static class MyService {
    }
}
