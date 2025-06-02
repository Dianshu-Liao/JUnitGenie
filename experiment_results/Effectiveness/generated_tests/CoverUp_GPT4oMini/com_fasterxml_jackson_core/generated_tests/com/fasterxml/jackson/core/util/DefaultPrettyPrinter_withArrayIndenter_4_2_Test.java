package com.fasterxml.jackson.core.util;

import com.fasterxml.jackson.core.io.SerializedString;
import com.fasterxml.jackson.core.util.DefaultPrettyPrinter.Indenter;
import com.fasterxml.jackson.core.util.DefaultPrettyPrinter.FixedSpaceIndenter;
import com.fasterxml.jackson.core.util.DefaultPrettyPrinter.NopIndenter;
import java.lang.reflect.Method;
import java.lang.reflect.Field;
import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import java.io.*;
import com.fasterxml.jackson.core.*;

class DefaultPrettyPrinter_withArrayIndenter_4_2_Test {

    @Test
    void testWithArrayIndenter_NullIndenter() throws Exception {
        DefaultPrettyPrinter printer = new DefaultPrettyPrinter();
        // Invoke the method using reflection
        DefaultPrettyPrinter result = (DefaultPrettyPrinter) invokePrivateMethod(printer, "withArrayIndenter", (Indenter) null);
        assertNotNull(result);
        assertSame(NopIndenter.instance, getFieldValue(result, "_arrayIndenter"));
    }

    @Test
    void testWithArrayIndenter_SameIndenter() throws Exception {
        DefaultPrettyPrinter printer = new DefaultPrettyPrinter();
        Indenter sameIndenter = FixedSpaceIndenter.instance;
        // Set the initial indenter
        printer = printer.withArrayIndenter(sameIndenter);
        // Invoke the method using reflection
        DefaultPrettyPrinter result = (DefaultPrettyPrinter) invokePrivateMethod(printer, "withArrayIndenter", sameIndenter);
        assertSame(printer, result);
    }

    @Test
    void testWithArrayIndenter_DifferentIndenter() throws Exception {
        DefaultPrettyPrinter printer = new DefaultPrettyPrinter();
        Indenter newIndenter = new FixedSpaceIndenter();
        // Invoke the method using reflection
        DefaultPrettyPrinter result = (DefaultPrettyPrinter) invokePrivateMethod(printer, "withArrayIndenter", newIndenter);
        assertNotSame(printer, result);
        assertSame(newIndenter, getFieldValue(result, "_arrayIndenter"));
    }

    private Object invokePrivateMethod(Object obj, String methodName, Object... args) throws Exception {
        Class<?> clazz = obj.getClass();
        Class<?>[] argTypes = new Class[args.length];
        for (int i = 0; i < args.length; i++) {
            // Adjusting for null
            argTypes[i] = args[i] != null ? args[i].getClass() : Indenter.class;
        }
        Method method = clazz.getDeclaredMethod(methodName, argTypes);
        method.setAccessible(true);
        return method.invoke(obj, args);
    }

    private Object getFieldValue(Object obj, String fieldName) throws Exception {
        Field field = obj.getClass().getDeclaredField(fieldName);
        field.setAccessible(true);
        return field.get(obj);
    }
}
