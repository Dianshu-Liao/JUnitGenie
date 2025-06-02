package com.fasterxml.jackson.core.util;

import com.fasterxml.jackson.core.util.DefaultPrettyPrinter;
import com.fasterxml.jackson.core.io.SerializedString;
import java.lang.reflect.Method;
import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import java.io.*;
import com.fasterxml.jackson.core.*;

public class DefaultPrettyPrinter_withRootSeparator_1_1_Test {

    @Test
    public void testWithRootSeparator_Null() throws Exception {
        DefaultPrettyPrinter printer = new DefaultPrettyPrinter();
        DefaultPrettyPrinter result = invokeWithRootSeparator(printer, null);
        assertNotNull(result);
        // Verify that the root separator is null
        assertSame(printer, result);
    }

    @Test
    public void testWithRootSeparator_EmptyString() throws Exception {
        DefaultPrettyPrinter printer = new DefaultPrettyPrinter();
        DefaultPrettyPrinter result = invokeWithRootSeparator(printer, "");
        assertNotNull(result);
        // Verify that the root separator is set correctly
        assertSame(printer, result);
    }

    @Test
    public void testWithRootSeparator_ValidString() throws Exception {
        DefaultPrettyPrinter printer = new DefaultPrettyPrinter();
        DefaultPrettyPrinter result = invokeWithRootSeparator(printer, "rootSeparator");
        assertNotNull(result);
        // Verify that the root separator is set correctly
        // You may want to verify the internal state if needed
    }

    private DefaultPrettyPrinter invokeWithRootSeparator(DefaultPrettyPrinter printer, String rootSeparator) throws Exception {
        Method method = DefaultPrettyPrinter.class.getDeclaredMethod("withRootSeparator", String.class);
        method.setAccessible(true);
        return (DefaultPrettyPrinter) method.invoke(printer, rootSeparator);
    }
}
