package com.fasterxml.jackson.core.util;

import com.fasterxml.jackson.core.io.SerializedString;
import com.fasterxml.jackson.core.util.DefaultPrettyPrinter;
import com.fasterxml.jackson.core.util.Separators;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import java.lang.reflect.Method;
import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import java.io.*;
import com.fasterxml.jackson.core.*;

public class DefaultPrettyPrinter_withRootSeparator_0_0_Test {

    private DefaultPrettyPrinter printer;

    private Separators separators;

    @BeforeEach
    public void setUp() {
        separators = new Separators();
        printer = new DefaultPrettyPrinter(separators);
    }

    @Test
    public void testWithRootSeparator_NullRootSeparator() {
        DefaultPrettyPrinter result = invokeWithRootSeparator(printer, null);
        assertSame(printer, result, "Should return the same instance when rootSeparator is null");
    }

    @Test
    public void testWithRootSeparator_SameRootSeparator() {
        SerializedString rootSeparator = new SerializedString(" ");
        printer = invokeWithRootSeparator(printer, rootSeparator);
        DefaultPrettyPrinter result = invokeWithRootSeparator(printer, rootSeparator);
        assertSame(printer, result, "Should return the same instance when rootSeparator is the same");
    }

    @Test
    public void testWithRootSeparator_DifferentRootSeparator() {
        SerializedString rootSeparator1 = new SerializedString(" ");
        SerializedString rootSeparator2 = new SerializedString(",");
        DefaultPrettyPrinter updatedPrinter = invokeWithRootSeparator(printer, rootSeparator1);
        DefaultPrettyPrinter result = invokeWithRootSeparator(updatedPrinter, rootSeparator2);
        assertNotSame(updatedPrinter, result, "Should return a new instance when rootSeparator is different");
        assertNotNull(result, "Result should not be null");
    }

    @Test
    public void testWithRootSeparator_EqualRootSeparator() {
        SerializedString rootSeparator = new SerializedString(" ");
        printer = invokeWithRootSeparator(printer, rootSeparator);
        DefaultPrettyPrinter result = invokeWithRootSeparator(printer, new SerializedString(" "));
        assertSame(printer, result, "Should return the same instance when rootSeparator equals the current one");
    }

    @Test
    public void testWithRootSeparator_ChangeRootSeparator() {
        SerializedString rootSeparator1 = new SerializedString(" ");
        SerializedString rootSeparator2 = new SerializedString(",");
        DefaultPrettyPrinter updatedPrinter = invokeWithRootSeparator(printer, rootSeparator1);
        DefaultPrettyPrinter result = invokeWithRootSeparator(updatedPrinter, rootSeparator2);
        assertNotSame(updatedPrinter, result, "Should return a new instance when rootSeparator changes");
        assertEquals(rootSeparator2.getValue(), getRootSeparatorValue(result), "Root separator should be updated");
    }

    private DefaultPrettyPrinter invokeWithRootSeparator(DefaultPrettyPrinter printer, SerializableString rootSeparator) {
        try {
            Method method = DefaultPrettyPrinter.class.getDeclaredMethod("withRootSeparator", SerializableString.class);
            method.setAccessible(true);
            return (DefaultPrettyPrinter) method.invoke(printer, rootSeparator);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    private String getRootSeparatorValue(DefaultPrettyPrinter printer) {
        try {
            java.lang.reflect.Field field = DefaultPrettyPrinter.class.getDeclaredField("_rootSeparator");
            field.setAccessible(true);
            return ((SerializedString) field.get(printer)).getValue();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
