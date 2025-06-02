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

class DefaultPrettyPrinter_withRootSeparator_1_0_Test {

    @Test
    void testWithRootSeparator_NullInput() throws Exception {
        DefaultPrettyPrinter printer = new DefaultPrettyPrinter();
        DefaultPrettyPrinter result = invokeWithRootSeparator(printer, null);
        assertNull(result._rootSeparator);
    }

    @Test
    void testWithRootSeparator_EmptyString() throws Exception {
        DefaultPrettyPrinter printer = new DefaultPrettyPrinter();
        DefaultPrettyPrinter result = invokeWithRootSeparator(printer, "");
        assertNotNull(result._rootSeparator);
        assertEquals(" ", result._rootSeparator.getValue());
    }

    @Test
    void testWithRootSeparator_ValidString() throws Exception {
        DefaultPrettyPrinter printer = new DefaultPrettyPrinter();
        String separator = "mySeparator";
        DefaultPrettyPrinter result = invokeWithRootSeparator(printer, separator);
        assertNotNull(result._rootSeparator);
        assertEquals(separator, result._rootSeparator.getValue());
    }

    private DefaultPrettyPrinter invokeWithRootSeparator(DefaultPrettyPrinter printer, String rootSeparator) throws Exception {
        Method method = DefaultPrettyPrinter.class.getDeclaredMethod("withRootSeparator", String.class);
        method.setAccessible(true);
        return (DefaultPrettyPrinter) method.invoke(printer, rootSeparator);
    }
}
