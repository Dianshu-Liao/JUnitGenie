package com.fasterxml.jackson.core.util;

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

class DefaultPrettyPrinter_withRootSeparator_0_1_Test {

    @Test
    void testWithRootSeparator_NullRootSeparator() throws Exception {
        DefaultPrettyPrinter printer = new DefaultPrettyPrinter();
        DefaultPrettyPrinter result = invokeWithRootSeparator(printer, (SerializableString) null);
        assertSame(printer, result);
    }

    @Test
    void testWithRootSeparator_SameRootSeparator() throws Exception {
        DefaultPrettyPrinter printer = new DefaultPrettyPrinter(new SerializedString("separator"));
        DefaultPrettyPrinter result = invokeWithRootSeparator(printer, new SerializedString("separator"));
        assertSame(printer, result);
    }

    @Test
    void testWithRootSeparator_DifferentRootSeparator() throws Exception {
        DefaultPrettyPrinter printer = new DefaultPrettyPrinter(new SerializedString("oldSeparator"));
        DefaultPrettyPrinter result = invokeWithRootSeparator(printer, new SerializedString("newSeparator"));
        assertNotSame(printer, result);
        assertEquals("newSeparator", result._rootSeparator.getValue());
    }

    @Test
    void testWithRootSeparator_EmptyRootSeparator() throws Exception {
        DefaultPrettyPrinter printer = new DefaultPrettyPrinter(new SerializedString("oldSeparator"));
        DefaultPrettyPrinter result = invokeWithRootSeparator(printer, new SerializedString(""));
        assertNotSame(printer, result);
        assertEquals("", result._rootSeparator.getValue());
    }

    @Test
    void testWithRootSeparator_IdenticalRootSeparator() throws Exception {
        DefaultPrettyPrinter printer = new DefaultPrettyPrinter(new SerializedString("sameSeparator"));
        DefaultPrettyPrinter result = invokeWithRootSeparator(printer, new SerializedString("sameSeparator"));
        assertSame(printer, result);
    }

    @Test
    void testWithRootSeparator_NullToNonNull() throws Exception {
        DefaultPrettyPrinter printer = new DefaultPrettyPrinter(new SerializedString("separator"));
        DefaultPrettyPrinter result = invokeWithRootSeparator(printer, null);
        assertNotSame(printer, result);
        assertNull(result._rootSeparator);
    }

    @Test
    void testWithRootSeparator_ChangeFromNullToNonNull() throws Exception {
        DefaultPrettyPrinter printer = new DefaultPrettyPrinter();
        DefaultPrettyPrinter result = invokeWithRootSeparator(printer, new SerializedString("newSeparator"));
        assertNotSame(printer, result);
        assertEquals("newSeparator", result._rootSeparator.getValue());
    }

    private DefaultPrettyPrinter invokeWithRootSeparator(DefaultPrettyPrinter printer, SerializableString rootSeparator) throws Exception {
        Method method = DefaultPrettyPrinter.class.getDeclaredMethod("withRootSeparator", SerializableString.class);
        method.setAccessible(true);
        return (DefaultPrettyPrinter) method.invoke(printer, rootSeparator);
    }
}
