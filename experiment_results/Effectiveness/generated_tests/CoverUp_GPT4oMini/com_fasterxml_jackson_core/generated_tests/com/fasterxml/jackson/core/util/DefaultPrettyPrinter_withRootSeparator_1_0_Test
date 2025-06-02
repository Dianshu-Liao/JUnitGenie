package com.fasterxml.jackson.core.util;

import com.fasterxml.jackson.core.io.SerializedString;
import java.lang.reflect.Field;
import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import java.io.*;
import com.fasterxml.jackson.core.*;

public class DefaultPrettyPrinter_withRootSeparator_1_0_Test {

    private DefaultPrettyPrinter defaultPrettyPrinter;

    @BeforeEach
    public void setUp() {
        defaultPrettyPrinter = new DefaultPrettyPrinter();
    }

    @Test
    public void testWithRootSeparator_Null() throws Exception {
        DefaultPrettyPrinter result = invokeWithRootSeparator(null);
        assertNotNull(result);
        assertNull(getPrivateField(result, "_rootSeparator"));
    }

    @Test
    public void testWithRootSeparator_EmptyString() throws Exception {
        DefaultPrettyPrinter result = invokeWithRootSeparator("");
        assertNotNull(result);
        assertEquals(new SerializedString(""), getPrivateField(result, "_rootSeparator"));
    }

    @Test
    public void testWithRootSeparator_ValidString() throws Exception {
        String rootSeparator = "rootSeparator";
        DefaultPrettyPrinter result = invokeWithRootSeparator(rootSeparator);
        assertNotNull(result);
        assertEquals(new SerializedString(rootSeparator), getPrivateField(result, "_rootSeparator"));
    }

    @Test
    public void testWithRootSeparator_SameValue() throws Exception {
        String rootSeparator = "rootSeparator";
        DefaultPrettyPrinter initial = defaultPrettyPrinter.withRootSeparator(rootSeparator);
        DefaultPrettyPrinter result = initial.withRootSeparator(rootSeparator);
        assertSame(initial, result);
    }

    @Test
    public void testWithRootSeparator_DifferentValue() throws Exception {
        String rootSeparator1 = "rootSeparator1";
        String rootSeparator2 = "rootSeparator2";
        DefaultPrettyPrinter initial = defaultPrettyPrinter.withRootSeparator(rootSeparator1);
        DefaultPrettyPrinter result = initial.withRootSeparator(rootSeparator2);
        assertNotSame(initial, result);
        assertEquals(new SerializedString(rootSeparator2), getPrivateField(result, "_rootSeparator"));
    }

    private DefaultPrettyPrinter invokeWithRootSeparator(String rootSeparator) throws Exception {
        return (DefaultPrettyPrinter) DefaultPrettyPrinter.class.getDeclaredMethod("withRootSeparator", String.class).invoke(defaultPrettyPrinter, rootSeparator);
    }

    private SerializedString getPrivateField(DefaultPrettyPrinter printer, String fieldName) throws Exception {
        Field field = DefaultPrettyPrinter.class.getDeclaredField(fieldName);
        field.setAccessible(true);
        return (SerializedString) field.get(printer);
    }
}
