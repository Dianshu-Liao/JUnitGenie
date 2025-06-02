package org.apache.commons.compress.archivers.sevenz;

import org.apache.commons.compress.archivers.sevenz.SevenZMethod;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import java.util.Objects;

class SevenZMethodConfiguration_SevenZMethodConfiguration_4_0_Test {

    private SevenZMethodConfiguration configuration;

    @BeforeEach
    void setUp() {
        // Initialize the SevenZMethodConfiguration with a valid SevenZMethod
        configuration = new SevenZMethodConfiguration(SevenZMethod.LZMA);
    }

    @Test
    void testConstructorWithValidMethod() {
        assertNotNull(configuration);
        assertEquals(SevenZMethod.LZMA, invokeGetMethod(configuration));
        assertEquals(null, invokeGetOptions(configuration));
    }

    @Test
    void testConstructorWithNullMethod() {
        // Using reflection to invoke the private constructor
        Exception exception = null;
        try {
            Constructor<SevenZMethodConfiguration> constructor = SevenZMethodConfiguration.class.getDeclaredConstructor(SevenZMethod.class);
            constructor.setAccessible(true);
            configuration = constructor.newInstance((SevenZMethod) null);
        } catch (Exception e) {
            exception = e;
        }
        assertNotNull(exception);
    }

    private SevenZMethod invokeGetMethod(SevenZMethodConfiguration config) {
        try {
            Field methodField = SevenZMethodConfiguration.class.getDeclaredField("method");
            methodField.setAccessible(true);
            return (SevenZMethod) methodField.get(config);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    private Object invokeGetOptions(SevenZMethodConfiguration config) {
        try {
            Field optionsField = SevenZMethodConfiguration.class.getDeclaredField("options");
            optionsField.setAccessible(true);
            return optionsField.get(config);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
