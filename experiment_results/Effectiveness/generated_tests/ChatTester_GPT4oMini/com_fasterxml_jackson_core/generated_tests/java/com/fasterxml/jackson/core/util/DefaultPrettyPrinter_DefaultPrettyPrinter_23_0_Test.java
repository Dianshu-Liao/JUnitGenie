// Test method
package com.fasterxml.jackson.core.util;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import com.fasterxml.jackson.core.io.SerializedString;
import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import java.io.*;
import com.fasterxml.jackson.core.*;

public class DefaultPrettyPrinter_DefaultPrettyPrinter_23_0_Test {

    private SerializableString rootSeparator;

    @BeforeEach
    public void setUp() {
        rootSeparator = new SerializedString(";");
    }

    @Test
    public void testConstructorWithSerializableString() throws NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException {
        // Get the constructor for DefaultPrettyPrinter that takes SerializableString as an argument
        Constructor<DefaultPrettyPrinter> constructor = DefaultPrettyPrinter.class.getDeclaredConstructor(SerializableString.class);
        // Make the constructor accessible
        constructor.setAccessible(true);
        // Invoke the constructor with the rootSeparator
        DefaultPrettyPrinter printer = constructor.newInstance(rootSeparator);
        // Assert that the printer is not null
        assertNotNull(printer);
        // Additional assertions can be made here based on the expected state of the printer
        // Since there is no method getRootSeparator(), we need to check the internal state directly
        // Assuming we want to check the _rootSeparator field
        assertEquals(rootSeparator.getValue(), printer._rootSeparator.getValue());
    }
}
