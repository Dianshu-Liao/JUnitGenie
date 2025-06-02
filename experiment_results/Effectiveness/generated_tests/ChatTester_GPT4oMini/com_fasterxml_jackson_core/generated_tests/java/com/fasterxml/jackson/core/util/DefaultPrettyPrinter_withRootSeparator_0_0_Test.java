package com.fasterxml.jackson.core.util;

import java.lang.reflect.Method;
import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import java.io.*;
import com.fasterxml.jackson.core.*;
import com.fasterxml.jackson.core.io.SerializedString;

public class DefaultPrettyPrinter_withRootSeparator_0_0_Test {

    private DefaultPrettyPrinter printer;

    @BeforeEach
    public void setUp() {
        printer = new DefaultPrettyPrinter();
    }

    @Test
    public void testWithRootSeparator_NullSeparator() throws Exception {
        // Invoke the focal method with a null separator
        SerializableString rootSeparator = null;
        DefaultPrettyPrinter result = invokeWithRootSeparator(printer, rootSeparator);
        // should return the same instance
        assertSame(printer, result);
    }

    @Test
    public void testWithRootSeparator_SameSeparator() throws Exception {
        // Create a SerializableString instance
        SerializableString rootSeparator = new SerializedString(" ");
        // Set initial separator
        printer = printer.withRootSeparator(rootSeparator);
        // Invoke the focal method with the same separator
        DefaultPrettyPrinter result = invokeWithRootSeparator(printer, rootSeparator);
        // should return the same instance
        assertSame(printer, result);
    }

    @Test
    public void testWithRootSeparator_DifferentSeparator() throws Exception {
        // Create different SerializableString instances
        SerializableString rootSeparator1 = new SerializedString(" ");
        SerializableString rootSeparator2 = new SerializedString(",");
        // Set initial separator
        printer = printer.withRootSeparator(rootSeparator1);
        // Invoke the focal method with a different separator
        DefaultPrettyPrinter result = invokeWithRootSeparator(printer, rootSeparator2);
        // should return a new instance
        assertNotSame(printer, result);
        // result should not be null
        assertNotNull(result);
    }

    private DefaultPrettyPrinter invokeWithRootSeparator(DefaultPrettyPrinter printer, SerializableString rootSeparator) throws Exception {
        Method method = DefaultPrettyPrinter.class.getDeclaredMethod("withRootSeparator", SerializableString.class);
        method.setAccessible(true);
        return (DefaultPrettyPrinter) method.invoke(printer, rootSeparator);
    }
}
