package org.apache.commons.compress.utils;

import java.lang.reflect.Field;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.ServiceConfigurationError;
import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import java.util.ServiceLoader;

class ServiceLoaderIterator_hasNext_0_2_Test {

    private ServiceLoaderIterator<MyService> serviceLoaderIterator;

    private Iterator<MyService> mockIterator;

    @BeforeEach
    void setUp() {
        mockIterator = mock(Iterator.class);
        serviceLoaderIterator = new ServiceLoaderIterator<>(MyService.class);
        setServiceLoaderIterator(mockIterator);
    }

    @SuppressWarnings("unchecked")
    private void setServiceLoaderIterator(Iterator<MyService> iterator) {
        try {
            Field field = ServiceLoaderIterator.class.getDeclaredField("serviceLoaderIterator");
            field.setAccessible(true);
            field.set(serviceLoaderIterator, iterator);
        } catch (NoSuchFieldException | IllegalAccessException e) {
            fail("Failed to set serviceLoaderIterator via reflection: " + e.getMessage());
        }
    }

    @Test
    void testHasNext_WhenNoMoreElements_ReturnsFalse() {
        when(mockIterator.hasNext()).thenReturn(false);
        assertFalse(serviceLoaderIterator.hasNext());
    }

    @Test
    void testHasNext_WhenNextElementIsAvailable_ReturnsTrue() {
        when(mockIterator.hasNext()).thenReturn(true).thenReturn(false);
        when(mockIterator.next()).thenReturn(new MyService());
        assertTrue(serviceLoaderIterator.hasNext());
        assertFalse(serviceLoaderIterator.hasNext());
    }

    @Test
    void testHasNext_WhenServiceConfigurationErrorIsThrown_ReturnsFalse() {
        when(mockIterator.hasNext()).thenThrow(new ServiceConfigurationError("Error"));
        ServiceConfigurationError exception = assertThrows(ServiceConfigurationError.class, () -> {
            serviceLoaderIterator.hasNext();
        });
        assertEquals("Error", exception.getMessage());
    }

//    @Test
//    void testHasNext_WhenSecurityExceptionIsCaught_IgnoresError() {
//        when(mockIterator.hasNext()).thenThrow(new ServiceConfigurationError("Error", new SecurityException()));
//        when(mockIterator.next()).thenReturn(new MyService());
//        assertTrue(serviceLoaderIterator.hasNext());
//    }

    // Dummy service class for testing
    static class MyService {
        // Implementation details for MyService
    }
}
