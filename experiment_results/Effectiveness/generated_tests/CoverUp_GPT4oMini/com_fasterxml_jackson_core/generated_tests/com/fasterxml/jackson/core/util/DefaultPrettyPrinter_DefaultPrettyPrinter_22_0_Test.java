package com.fasterxml.jackson.core.util;

import com.fasterxml.jackson.core.util.DefaultPrettyPrinter;
import com.fasterxml.jackson.core.io.SerializedString;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import java.io.*;
import com.fasterxml.jackson.core.*;

public class DefaultPrettyPrinter_DefaultPrettyPrinter_22_0_Test {

    @Test
    public void testDefaultPrettyPrinterWithNullRootSeparator() throws Exception {
        DefaultPrettyPrinter printer = invokeConstructorWithReflection((String) null);
        Field rootSeparatorField = DefaultPrettyPrinter.class.getDeclaredField("_rootSeparator");
        rootSeparatorField.setAccessible(true);
        SerializedString rootSeparator = (SerializedString) rootSeparatorField.get(printer);
        assertEquals(null, rootSeparator);
    }

    @Test
    public void testDefaultPrettyPrinterWithEmptyRootSeparator() throws Exception {
        DefaultPrettyPrinter printer = invokeConstructorWithReflection("");
        Field rootSeparatorField = DefaultPrettyPrinter.class.getDeclaredField("_rootSeparator");
        rootSeparatorField.setAccessible(true);
        SerializedString rootSeparator = (SerializedString) rootSeparatorField.get(printer);
        assertEquals("", rootSeparator.getValue());
    }

    @Test
    public void testDefaultPrettyPrinterWithValidRootSeparator() throws Exception {
        String rootSeparatorValue = "rootSeparator";
        DefaultPrettyPrinter printer = invokeConstructorWithReflection(rootSeparatorValue);
        Field rootSeparatorField = DefaultPrettyPrinter.class.getDeclaredField("_rootSeparator");
        rootSeparatorField.setAccessible(true);
        SerializedString rootSeparator = (SerializedString) rootSeparatorField.get(printer);
        assertEquals(rootSeparatorValue, rootSeparator.getValue());
    }

    private DefaultPrettyPrinter invokeConstructorWithReflection(String rootSeparator) throws Exception {
        Constructor<DefaultPrettyPrinter> constructor = DefaultPrettyPrinter.class.getDeclaredConstructor(String.class);
        constructor.setAccessible(true);
        return constructor.newInstance(rootSeparator);
    }
}
